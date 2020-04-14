/*
 * Copyright (c) 2014, Codename One LTD. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codename1.googlemaps;

import com.codename1.impl.android.CodenameOneActivity;
import com.codename1.impl.android.AndroidNativeUtil;
import android.Manifest;

import com.codename1.io.Util;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.GoogleMap;
import com.codename1.impl.android.AndroidNativeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.os.Bundle;
import com.codename1.impl.android.AndroidImplementation;
import com.codename1.impl.android.LifecycleListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.MapsInitializer;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.Polyline;
import android.graphics.Point;
//import com.codename1.impl.android.AndroidImplementation.PeerDraw;
import com.codename1.io.Log;
import com.codename1.ui.Display;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.CameraUpdateFactory;
import android.widget.RelativeLayout;
import android.view.WindowManager;
import android.graphics.Point;
import android.content.Context;
import android.widget.Toast;
import com.codename1.impl.android.IntentResultListener;
import android.provider.Settings;
import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
// import android.util.Log;
import android.net.Uri;
import android.location.Location;
//for enable gps
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;

public class InternalNativeMapsImpl implements LifecycleListener {

    private int mapId;
    private MapView view;
    private GoogleMap mapInstance;
    private static int uniqueIdCounter = 0;
    private HashMap<Long, Marker> markerLookup = new HashMap<Long, Marker>();
    private HashMap<Marker, Long> listeners = new HashMap<Marker, Long>();
    private static boolean supported = true;
    private HashMap<Long, Polyline> paths = new HashMap<Long, Polyline>();
    private PolylineOptions currentPath;
    private LatLng lastPosition;
    private Point lastPoint;
    private Location mLastLocation = null;
    private Point size;
    private boolean showMyLocation;
    private boolean rotateGestureEnabled;
    private int pathStrokeColor = 0;
    private int pathStrokeWidth = 1;
    final CodenameOneActivity cn1activity = (CodenameOneActivity) AndroidNativeUtil.getActivity();

    Context context = AndroidNativeUtil.getContext();
    Activity activity = AndroidNativeUtil.getActivity();
    private static final int REQUEST_CHECK_SETTINGS = 0x1;
    private static GoogleApiClient mGoogleApiClient;
    private static final int ACCESS_FINE_LOCATION_INTENT_ID = 3;
    private static final String BROADCAST_ACTION = "android.location.PROVIDERS_CHANGED";

    static {
        if (AndroidNativeUtil.getActivity() != null) {
            android.util.Log.d("CN1 Maps", "Initializing maps");
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                initMaps();
            } else {
                AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        initMaps();
                    }
                });
            }
        } else {
            android.util.Log.d("CN1 Mapss", "Did not initialize maps because activity was null");
        }
        AndroidNativeUtil.registerViewRenderer(MapView.class, new AndroidNativeUtil.BitmapViewRenderer() {

            public Bitmap renderViewOnBitmap(View v, final int w, final int h) {

                PeerImage pi = PeerImage.getPeerImage(v);
                if (pi == null) {
                    PeerImage.submitUpdate(v, w, h);
                    return null;
                }
                if (pi.peerImage == null || pi.peerW != w || pi.peerH != h) {
                    PeerImage.submitUpdate(v, w, h);
                    return null;
                }
                pi.lastUsed = System.currentTimeMillis();
                return pi.peerImage;

            }
        });
    }

    private static class PeerImage {

        Bitmap peerImage;
        int peerW;
        int peerH;
        Timer timer;
        long lastUsed;

        PeerImage() {
            lastUsed = System.currentTimeMillis();
        }

        public static PeerImage getPeerImage(View v) {
            return peerImages.get(v);
        }

        public void update(View v, final int w, final int h) {
            // prevent potential exception during transitions
            if (w < 10 || h < 10) {

                return;
            }
            final MapView mv = (MapView) v;
            if (mv.getParent() == null || mv.getHeight() < 10 || mv.getWidth() < 10) {
                return;
            }
            AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {

                public void run() {
                    //mv.
                    mv.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
                                public void onSnapshotReady(Bitmap snapshot) {
                                    peerImage = snapshot;
                                    peerW = w;
                                    peerH = h;
                                    lastUsed = System.currentTimeMillis();
                                }
                            });
                        }
                    });

                }

            });

        }

        private static PendingUpdate findPendingUpdate(View v) {
            synchronized (pendingUpdates) {
                for (PendingUpdate u : pendingUpdates) {
                    if (u.view == v) {
                        return u;
                    }
                }
            }
            return null;
        }

        private static void submitUpdate(View v, int w, int h) {
            synchronized (pendingUpdates) {
                PendingUpdate existing = findPendingUpdate(v);
                if (existing == null) {
                    existing = new PendingUpdate();
                    existing.view = v;
                    existing.w = w;
                    existing.h = h;
                    pendingUpdates.add(existing);
                    existing.schedule();
                }
                existing.w = w;
                existing.h = h;
            }

        }

        private static void clearOldest() {
            synchronized (peerImages) {
                int maxNum = 5;
                long currMark = System.currentTimeMillis();
                ArrayList<PeerImage> toRemove = new ArrayList<PeerImage>();
                while (peerImages.size() > 5) {
                    View oldest = null;
                    PeerImage oldestImg = null;
                    for (View vimg : peerImages.keySet()) {
                        PeerImage img = peerImages.get(vimg);
                        if (oldest == null || img.lastUsed < oldestImg.lastUsed) {
                            oldest = vimg;
                            oldestImg = img;
                        }
                    }
                    if (oldest != null) {
                        peerImages.remove(oldest);
                    }

                }

            }
        }

    }

    static HashMap<View, PeerImage> peerImages = new HashMap<View, PeerImage>();

    private static class PendingUpdate {

        private View view;
        private int w;
        private int h;
        long requestTime;
        Timer timer;

        private void schedule() {
            timer = new Timer();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    synchronized (pendingUpdates) {
                        pendingUpdates.remove(PendingUpdate.this);
                    }
                    PeerImage pe = peerImages.get(view);
                    if (pe == null) {
                        pe = new PeerImage();
                        peerImages.put(view, pe);
                    }
                    pe.update(view, w, h);

                }
            };
            timer.schedule(tt, 1000L);
        }
    }
    static java.util.ArrayList<PendingUpdate> pendingUpdates = new java.util.ArrayList<PendingUpdate>();

    private static boolean initialized = false;

    private static void initMaps() {
        if (!initialized) {
            initialized = true;
            try {
                // this triggers the creation of the maps so they are ready when the peer component is invoked
                MapsInitializer.initialize(AndroidNativeUtil.getActivity());
                MapView v = new MapView(AndroidNativeUtil.getActivity());

                v.onCreate(AndroidNativeUtil.getActivationBundle());
                v.onResume();
                //v.getMap();
            } catch (Exception e) {
                supported = false;
                System.out.println("Failed to initialize, google play services not installed: " + e);
                e.printStackTrace();
            }
        }
    }

    public long addMarker(final byte[] icon, final double lat, final double lon, final String text, final String snippet, final boolean callback, final float anchorU, final float anchorV) {
        uniqueIdCounter++;
        final long key = uniqueIdCounter;
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                MarkerOptions mo = new MarkerOptions();
                mo.anchor(anchorU, anchorV);
                if (text != null) {
                    mo.title(text);
                }
                if (icon != null) {
                    Bitmap bmp = BitmapFactory.decodeByteArray(icon, 0, icon.length);
                    mo.icon(BitmapDescriptorFactory.fromBitmap(bmp));
                }
                if (snippet != null) {
                    mo.snippet(snippet);
                }
                mo.position(new LatLng(lat, lon));

                Marker m = mapInstance.addMarker(mo);
                if (callback) {
                    listeners.put(m, key);
                }
                markerLookup.put(key, m);
                //PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
            }
        });

        return key;
    }

    public long beginPath() {
        currentPath = new PolylineOptions()
                .color(0xFF000000 | pathStrokeColor)
                .width(pathStrokeWidth);

        return 1;
    }

    public void setPosition(final double lat, final double lon) {
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                mapInstance.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lon)));
                PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
            }
        });
    }

    public float getZoom() {
        final float[] result = new float[1];
        AndroidImplementation.runOnUiThreadAndBlock(new Runnable() {
            public void run() {
                result[0] = mapInstance.getCameraPosition().zoom;

            }
        });
        return result[0];
    }

    public void setZoom(final double lat, final double lon, final float zoom) {
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                mapInstance.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), zoom));
                PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
            }
        });
    }

    public void addToPath(long param, double param1, double param2) {
        currentPath.add(new LatLng(param1, param2));
    }

    public void removeAllMarkers() {
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                mapInstance.clear();
                markerLookup.clear();
                listeners.clear();
                //PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());

            }
        });
    }

    public int getMinZoom() {
        final int[] result = new int[1];
        AndroidImplementation.runOnUiThreadAndBlock(new Runnable() {
            public void run() {
                result[0] = (int) mapInstance.getMinZoomLevel();
            }
        });
        return result[0];
    }

    public void removeMapElement(final long param) {
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Marker m = markerLookup.get(param);
                if (m != null) {
                    m.remove();
                    markerLookup.remove(param);
                    listeners.remove(m);
                    return;
                }

                Polyline p = paths.get(param);
                if (p != null) {
                    p.remove();
                    paths.remove(param);
                }
                //PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
            }
        });
    }

    public double getLatitude() {
        final double[] result = new double[1];
        AndroidImplementation.runOnUiThreadAndBlock(new Runnable() {
            public void run() {
                result[0] = mapInstance.getCameraPosition().target.latitude;
            }
        });
        return result[0];
    }

    public void setMarkerSize(int width, int height) {
        // not needed right now... used only by Javascript port
    }

    public double getLongitude() {
        final double[] result = new double[1];
        AndroidImplementation.runOnUiThreadAndBlock(new Runnable() {
            public void run() {
                result[0] = mapInstance.getCameraPosition().target.longitude;
            }
        });
        return result[0];
    }

    public void setMapType(final int param) {
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                switch (param) {
                    case MapContainer.MAP_TYPE_HYBRID:
                        mapInstance.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        return;
                    case MapContainer.MAP_TYPE_TERRAIN:
                        mapInstance.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        return;
                }
                mapInstance.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                //PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
            }
        });
    }
boolean setPosition=true;
    public void setShowMyLocation(boolean show) {
        if (show && !showMyLocation) {
            if (!AndroidNativeUtil.checkForPermission(Manifest.permission.ACCESS_FINE_LOCATION, "Show My Location On Map")) {
                //Log.p("Show my location has been disabled because permission was not granted by the user.");
                System.out.println("Show My Location disabled because user didn't grant ACCESS_FINE_LOCATION permission");
                return;
            }

        }
        showMyLocation = show;

        if (mapInstance != null) {
            AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                    android.view.Display display = wm.getDefaultDisplay();
                    size = new Point();
                    display.getSize(size);
                    mapInstance.setMyLocationEnabled(showMyLocation);

                    View locationButton = ((View) view.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
                    RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
// position on right bottom
                    rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
                    rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
                    rlp.setMargins(0, 0, 70, size.y / 9);
                    mapInstance.setOnMyLocationButtonClickListener(new OnMyLocationButtonClickListener() {
                        @Override
                        public boolean onMyLocationButtonClick() {
                            final LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

                            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

                                location l = new location();
                                l.initGoogleAPIClient();
                                l.checkPermissions();
                                mLastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER); 
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                    if (mLastLocation != null && setPosition) {
                                        setZoom(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 14f);
                                    }  
                                       }
                                    }, 10000);
                                return true;
                            } else {

                                   // Toast.makeText(context, "Gps Enabled, see my location", Toast.LENGTH_SHORT).show();   
                                   mLastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);  
                                   if(mLastLocation!=null){
                                     setZoom(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 14f);
                                      setPosition=false;
                                   }
                                  

                                return true;
                            }
                        }
                    });
                }
            });
        }
    }

    private void setupMap() {

    }

    private void installListeners() {
        /*
        if (mapInstance == null) {
            view = null;
            System.out.println("Failed to get map instance, it seems google play services are not installed");
            return;
        }*/
        view.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mapInstance = googleMap;
                mapInstance.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    public boolean onMarkerClick(Marker marker) {
                        Long val = listeners.get(marker);
                        if (val != null) {
                            MapContainer.fireMarkerEvent(InternalNativeMapsImpl.this.mapId, val.longValue());
                            return true;
                        }
                        return false;
                    }
                });
                mapInstance.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
                    public void onCameraChange(CameraPosition position) {
                        MapContainer.fireMapChangeEvent(InternalNativeMapsImpl.this.mapId, (int) position.zoom, position.target.latitude, position.target.longitude);
                        PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
                    }
                });
                mapInstance.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
                    @Override
                    public void onCameraMove() {
                        MapContainer.fireMapChangeEvent(InternalNativeMapsImpl.this.mapId, (int) mapInstance.getCameraPosition().zoom, mapInstance.getCameraPosition().target.latitude, mapInstance.getCameraPosition().target.longitude);

                    }
                });
                mapInstance.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    public void onMapClick(LatLng point) {
                        Point p = mapInstance.getProjection().toScreenLocation(point);
                        MapContainer.fireTapEventStatic(InternalNativeMapsImpl.this.mapId, p.x, p.y);
                    }
                });
                mapInstance.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

                    public void onMapLongClick(LatLng point) {
                        Point p = mapInstance.getProjection().toScreenLocation(point);
                        MapContainer.fireLongPressEventStatic(InternalNativeMapsImpl.this.mapId, p.x, p.y);
                    }
                });
                mapInstance.setMyLocationEnabled(showMyLocation);
                mapInstance.getUiSettings().setRotateGesturesEnabled(rotateGestureEnabled);
            }
        });

    }

    public android.view.View createNativeMap(int mapId) {
        this.mapId = mapId;
        //if (showMyLocation) {
        //    if (!AndroidNativeUtil.checkForPermission(Manifest.permission.ACCESS_FINE_LOCATION, "Show My Location On Map")) {
        //        Log.p("Show my location has been disabled because permission was not granted by the user.");
        //        showMyLocation = false;
        //    }
        //    
        //}
        final boolean[] ready = new boolean[1];
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                try {
                    view = new MapView(AndroidNativeUtil.getActivity());
                    view.onCreate(AndroidNativeUtil.getActivationBundle());
                    view.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            try {
                                mapInstance = googleMap;
                                installListeners();
                            } finally {
                                synchronized (ready) {
                                    ready[0] = true;
                                    ready.notifyAll();
                                }
                            }
                        }
                    });
                    //mapInstance = view.getMap();

                } catch (Throwable e) {
                    System.out.println("Failed to initialize, google play services not installed: " + e);
                    e.printStackTrace();
                    view = null;
                    synchronized (ready) {
                        ready[0] = true;
                        ready.notifyAll();
                    }
                    return;
                }
                //PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
            }
        });
        while (!ready[0]) {
            Display.getInstance().invokeAndBlock(new Runnable() {
                public void run() {
                    synchronized (ready) {
                        if (!ready[0]) {
                            Util.wait(ready, 30);
                        }
                    }
                }
            });
        }
        return view;
    }

    public int getMapType() {
        switch (mapInstance.getMapType()) {
            case GoogleMap.MAP_TYPE_HYBRID:
                return MapContainer.MAP_TYPE_HYBRID;
            case GoogleMap.MAP_TYPE_TERRAIN:
            case GoogleMap.MAP_TYPE_SATELLITE:
                return MapContainer.MAP_TYPE_TERRAIN;
        }
        return MapContainer.MAP_TYPE_NONE;
    }

    public int getMaxZoom() {
        final int[] result = new int[1];
        AndroidImplementation.runOnUiThreadAndBlock(new Runnable() {
            public void run() {
                result[0] = (int) mapInstance.getMaxZoomLevel();
            }
        });
        return result[0];
    }

    public void setRotateGestureEnabled(boolean e) {
        rotateGestureEnabled = e;
        if (mapInstance != null) {
            AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mapInstance.getUiSettings().setRotateGesturesEnabled(rotateGestureEnabled);
                    //PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
                }
            });
        }
    }

    public long finishPath(long param) {
        uniqueIdCounter++;
        final long key = uniqueIdCounter;
        final PolylineOptions fCurrentPath = currentPath;
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                paths.put(key, mapInstance.addPolyline(fCurrentPath));

                //PeerImage.submitUpdate(view, view.getWidth(), view.getHeight());
            }
        });
        return key;
    }

    public void calcScreenPosition(final double lat, final double lon) {
        AndroidImplementation.runOnUiThreadAndBlock(new Runnable() {
            public void run() {
                lastPoint = mapInstance.getProjection().toScreenLocation(new LatLng(lat, lon));
            }
        });
    }

    public int getScreenX() {
        return lastPoint.x;
    }

    public int getScreenY() {
        return lastPoint.y;
    }

    public void calcLatLongPosition(final int x, final int y) {
        AndroidImplementation.runOnUiThreadAndBlock(new Runnable() {
            public void run() {
                lastPosition = mapInstance.getProjection().fromScreenLocation(new Point(x, y));
            }
        });
    }

    public double getScreenLat() {
        return lastPosition.latitude;
    }

    public double getScreenLon() {
        return lastPosition.longitude;
    }

    public boolean isSupported() {
        return supported;
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            if (view != null) {
                view.onCreate(savedInstanceState);
                initMaps();
                view.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        mapInstance = googleMap;
                    }
                });
                //mapInstance = view.getMap();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        try {
            if (view != null) {
                //mapInstance = view.getMap();
                view.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        mapInstance = googleMap;
                    }
                });
                view.onResume();
                installListeners();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onPause() {
        try {
            if (view != null) {
                view.onPause();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onDestroy() {
        try {
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                // if (mGoogleApiClient.isConnected()) {
                //     mGoogleApiClient.disconnect();
                //     // mlocManager.removeUpdates(mPendingIntent);
                //     // mlocManager.removeProximityAlert(mPendingIntent);
                //     // mPendingIntent.cancel();
                // }
                view.onDestroy();
                initialized = false;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSaveInstanceState(Bundle b) {
        try {
            if (view != null) {
                view.onSaveInstanceState(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onLowMemory() {
        try {
            if (view != null) {
                view.onLowMemory();
                synchronized (pendingUpdates) {
                    PendingUpdate toRemove = null;
                    for (PendingUpdate u : pendingUpdates) {
                        if (u.view == view) {
                            if (u.timer != null) {
                                u.timer.cancel();
                                u.timer = null;
                            }
                            toRemove = u;
                        }
                    }
                    if (toRemove != null) {
                        pendingUpdates.remove(toRemove);
                    }

                }
                peerImages.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deinitialize() {
        AndroidNativeUtil.removeLifecycleListener(this);
        synchronized (pendingUpdates) {
            PendingUpdate toRemove = null;
            for (PendingUpdate u : pendingUpdates) {
                if (u.view == view) {
                    if (u.timer != null) {
                        u.timer.cancel();
                        u.timer = null;
                    }
                    toRemove = u;
                }
            }
            if (toRemove != null) {
                pendingUpdates.remove(toRemove);
            }

        }
        PeerImage.clearOldest();
    }

    public void initialize() {
        AndroidNativeUtil.addLifecycleListener(this);
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                try {
                    view.invalidate();
                    view.onPause();
                    view.onResume();
                } catch (Exception e) {
                    Log.e(e);
                }
            }
        });
    }

    /**
     * Sets the color used to stroke paths on the map.
     *
     * @param color The color
     */
    public void setPathStrokeColor(int color) {
        this.pathStrokeColor = color;
    }

    /**
     * Gets the color used to stroke paths on the map.
     *
     * @return The color
     */
    public int getPathStrokeColor() {
        return this.pathStrokeColor;
    }

    /**
     * Sets the pixel width used to stroke paths on the map.
     *
     * @param width The pixel width.
     */
    public void setPathStrokeWidth(int width) {
        this.pathStrokeWidth = width;
    }

    /**
     * Gets the pixel width used to stroke paths on the map.
     *
     * @return The pixel width.
     */
    public int getPathStrokeWidth() {
        return pathStrokeWidth;
    }

    public class location extends CodenameOneActivity {

        /* Initiate Google API Client  */
        public void initGoogleAPIClient() {
            //Without Google API Client Auto Location Dialog will not work
            mGoogleApiClient = new GoogleApiClient.Builder(activity)
                    .addApi(LocationServices.API)
                    .build();
            mGoogleApiClient.connect();
            // mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            mLastLocation =null;
            // Handler handler = new Handler();
            // handler.postDelayed(new Runnable() {
            //     @Override
            //     public void run() {

            //         if (mLastLocation != null) {
            //             setZoom(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 14f);
            //         } else {
            //             Toast.makeText(context, "mLastLocationsss==null", Toast.LENGTH_SHORT).show();
            //             mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            //             setZoom(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 14f);
            //         }
            //     }
            // }, 5000);
        }

        /* Check Location Permission for Marshmallow Devices */
        public void checkPermissions() {
            if (Build.VERSION.SDK_INT >= 23) {
                if (ContextCompat.checkSelfPermission(activity,
                        android.Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestLocationPermission();
                } else {
                    showSettingDialog();
                }
            } else {
                showSettingDialog();
            }

        }

        /*  Show Popup to access User Permission  */
        private void requestLocationPermission() {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(activity,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        ACCESS_FINE_LOCATION_INTENT_ID);

            } else {
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        ACCESS_FINE_LOCATION_INTENT_ID);
            }
        }
//
//    /* Show Location Access Dialog */

        private void showSettingDialog() {
            com.google.android.gms.location.LocationRequest locationRequest = com.google.android.gms.location.LocationRequest.create();
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);//Setting priotity of Location request to high
            locationRequest.setInterval(30 * 1000);
            locationRequest.setFastestInterval(5 * 1000);//5 sec Time interval for location update
            LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                    .addLocationRequest(locationRequest);
            builder.setAlwaysShow(true); //this is the key ingredient to show dialog always when GPS is off

            PendingResult<LocationSettingsResult> result
                    = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
            result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
                @Override
                public void onResult(LocationSettingsResult result) {
                    final Status status = result.getStatus();
                    final LocationSettingsStates state = result.getLocationSettingsStates();
                    switch (status.getStatusCode()) {
                        case LocationSettingsStatusCodes.SUCCESS:
                            // All location settings are satisfied. The client can initialize location
                            // requests here.
                            // activity.runOnUiThread(new Runnable() {
                            //     public void run() {
                                    // Toast.makeText(activity, "GPS is Enabled in your device", Toast.LENGTH_SHORT).show();
                                    // Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                                    // Toast.makeText(context, "mLastLocation==null", Toast.LENGTH_SHORT).show();
                                    // new com.yallagym.client.CallbackNative().saveLocation(mLastLocation.getLatitude() + "", mLastLocation.getLongitude() + "");
                            //     }
                            // });

//                            Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
//                                    mGoogleApiClient);
//                            com.codename1.impl.android.AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {
//                                public void run() {
//                                    new com.yallagym.client.CallbackNative().saveLocation(mLastLocation.getLatitude() + "", mLastLocation.getLongitude() + "");
//                                }
//                            });
                            break;
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            // Location settings are not satisfied. But could be fixed by showing the user
                            // a dialog.
                            try {
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                status.startResolutionForResult(activity, REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException e) {
                                e.printStackTrace();
                                // Ignore the error.
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            // Location settings are not satisfied. However, we have no way to fix the
                            // settings so we won't show the dialog.
                            break;
                    }
                }
            });

        }

        private void updateGPSStatus(String status) {
//       Toast.makeText(activity, status, Toast.LENGTH_SHORT).show();
        }

//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            switch (requestCode) {
//                // Check for the integer request code originally supplied to startResolutionForResult().
//                case REQUEST_CHECK_SETTINGS:
//                    switch (resultCode) {
//                        case -1:
//                            Log.e("Settings", "Result OK");
//                            updateGPSStatus("GPS is Enabled in your device");
//                            //startLocationUpdates();
//                            break;
//                        case 0:
//                            Log.e("Settings", "Result Cancel");
//                            updateGPSStatus("GPS is Disabled in your device");
//                            break;
//                    }
//                    break;
//            }
//        }
        @Override
        protected void onResume() {
            super.onResume();
            // registerReceiver(gpsLocationReceiver, new IntentFilter(BROADCAST_ACTION));//Register broadcast receiver to check the status of GPS
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            //Unregister receiver on destroy
            // if (gpsLocationReceiver != null) {
            //     unregisterReceiver(gpsLocationReceiver);
            // }
            // if (mGoogleApiClient.isConnected()) {
            //     mGoogleApiClient.disconnect();
            //     // mlocManager.removeUpdates(mPendingIntent);
            //     // mlocManager.removeProximityAlert(mPendingIntent);
            //     // mPendingIntent.cancel();
            // }
        }
        //Run on UI
        private Runnable sendUpdatesToUI = new Runnable() {
            public void run() {
                showSettingDialog();
            }
        };

        // /* Broadcast receiver to check status of GPS */
        // private BroadcastReceiver gpsLocationReceiver = new BroadcastReceiver() {

        //     @Override
        //     public void onReceive(Context context, Intent intent) {

        //         //If Action is Location
        //         if (intent.getAction().matches(BROADCAST_ACTION)) {
        //             LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        //             //Check if GPS is turned ON or OFF
        //             if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
        //                 // Log.e("About GPS", "GPS is Enabled in your device");
        //                 updateGPSStatus("GPS is Enabled in your device");
        //             } else {
        //                 //If GPS turned OFF show Location Dialog
        //                 new Handler().postDelayed(sendUpdatesToUI, 10);
        //                 // showSettingDialog();
        //                 updateGPSStatus("GPS is Disabled in your device");
        //                 // Log.e("About GPS", "GPS is Disabled in your device");
        //             }

        //         }
        //     }
        // };

        /* On Request permission method to check the permisison is granted or not for Marshmallow+ Devices  */
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            switch (requestCode) {
                case ACCESS_FINE_LOCATION_INTENT_ID: {
                    // If request is cancelled, the result arrays are empty.
                    if (grantResults.length > 0
                            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        //If permission granted show location dialog if APIClient is not null
                        if (mGoogleApiClient == null) {
                            initGoogleAPIClient();
                            showSettingDialog();
                        } else {
                            showSettingDialog();
                        }

                    } else {
                        Toast.makeText(activity, "Location Permission denied.", Toast.LENGTH_SHORT).show();
                        // permission denied, boo! Disable the
                        // functionality that depends on this permission.
                    }
                    return;
                }
            }
        }
    }

}
