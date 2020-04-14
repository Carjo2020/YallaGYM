package com.yallagym.client.forms;

import com.cn2.lang.cn1Math;
import com.cn2.ui.cn1Display;
import com.cn2.ui.cn1Icons;
import com.cn2.util.cn1String;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.Switch;
import com.codename1.components.ToastBar;
import com.codename1.googlemaps.MapContainer;
import com.codename1.io.Log;
import com.codename1.io.Preferences;
import com.codename1.l10n.L10NManager;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.system.NativeLookup;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.yallagym.APIs;
import com.yallagym.nativeCodes;
import com.yallagym.BaseForm;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.client.layouts.Gym_Place_Icon;
import java.util.List;
import java.util.Map;

public class map_form extends BaseForm {

    int length = cn1Math.nextDown(getToolbar().getPreferredH() / 3.0);
//    private String goole = "AIzaSyBOAwXvTbcRCb_qVNK20YteWajLJuGlnYo";
//     private String ios = "AIzaSyCheXmp9Ye6_ojjRLtOO17ueOTmfW_E1IA";
    private String HTML_API_KEY = "AIzaSyCfdDWuMp2TmDdi7aeIfS4jNXv5KI4PJJQ";
    nativeCodes code;
    APIs api = new APIs();
    int i = 0;

    List<Map<String, Object>> list = getList();
    private static String[] gyms_names;
    private static String[] gyms_coordinates;

    public map_form() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public map_form(com.codename1.ui.util.Resources res) {
        checkLanguage(res);

    }
    int is = 0;
    Dialog erorr_msg;
    String subscription_type = "price_d";

//    Location position = null;
    public map_form(com.codename1.ui.util.Resources res, Form frm, Coord initCoord) {
        checkLanguage(res);
        installTitleArea(res);
        installBackCommand(frm);
        this.setScrollable(false);
        this.setScrollVisible(false);
        gui_Con_Map.setScrollableY(false);
        gui_Con_Map.setScrollVisible(false);
        gui_fab_dlg.setVisible(false);
        gui_ac_search.getHintLabel().setGap(15);
        gyms_names = getGymsNames();
        gyms_coordinates = getGymsCoord();

        gui_ac_search.setCompletion(gyms_names);
        erorr_msg = new erorr_msg(res, "GPS error", "Your location could not be found, please try going outside for a better GPS signal or try again", "Ok", e -> {
            frm.show();
        });
//        position = LocationManager.getLocationManager().getCurrentLocationSync();

        try {
            installFixItems(res, frm);
            MapContainer map = new MapContainer();
            Container root = LayeredLayout.encloseIn(BorderLayout.center(map));
            addMarkers(res, map, "price_d");
            this.revalidate();
            root.setScrollable(false);
            gui_Con_Map.add(BorderLayout.CENTER, root);

            if (initCoord == null) {
                String coordinate_store = Preferences.get(Preferences.get("address", "Amman"), "31.9528763,35.9281701");
                String coord[] = cn1String.splite(coordinate_store, ",");
                Coord deviceCoord = new Coord(Double.valueOf(coord[0]), Double.valueOf(coord[1]));
                map.zoom(deviceCoord, 12);
            } else {
                map.zoom(initCoord, 12);
            }
            map.setShowMyLocation(true);

            gui_btn_search.addActionListener(e -> {
                gui_ac_search.stopEditing();
                String select = gui_ac_search.getText();
                for (int i = 0; i < gyms_names.length; i++) {
                    if (select.equals(gyms_names[i])) {
                        String[] adressSub = cn1String.splite(gyms_coordinates[i], ",");
                        double latu = Double.valueOf(adressSub[0]);
                        double longt = Double.valueOf(adressSub[1]);
                        map.zoom(new Coord(latu, longt), 17);
                        addMarkers(res, map, subscription_type);
                        this.revalidate();
                    }
                }
                map.revalidate();
            });
            addFabListener(res, map);
            this.revalidate();
        } catch (Exception e) {
            is = 1;
            if (is == 0) {
                new map_form(res, frm, initCoord).show();
            } else {
                is = 0;
                erorr_msg.show();
            }

        }

    }

    @Override
    public void show() {
        switch_cpm.setPropertyValue("value", false);
        super.show(); //To change body of generated methods, choose Tools | Templates.
    }

////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Con_Map = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.AutoCompleteTextField gui_ac_search = new com.codename1.ui.AutoCompleteTextField();
    protected com.codename1.ui.Button gui_btn_search = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_fab_dlg = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_tranperent = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_month = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_week = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_day = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_tranperent.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_btn_tranperent) {
                onbtn_tranperentActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("map_form");
        setName("map_form");
        gui_Con_Map.setPreferredSizeStr("37.56614mm 130.95238mm");
                gui_Con_Map.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Map.setName("Con_Map");
        gui_Container.setPreferredSizeStr("50.529102mm 11.904762mm");
        gui_Container.setUIID("search_input");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_fab_dlg.setPreferredSizeStr("27.248678mm 23.544973mm");
                gui_fab_dlg.setInlineStylesTheme(resourceObjectInstance);
        gui_fab_dlg.setName("fab_dlg");
        addComponent(gui_Con_Map);
        addComponent(gui_Container);
        gui_ac_search.setPreferredSizeStr("38.095238mm 11.640212mm");
        gui_ac_search.setHint("Search Here...");
        gui_ac_search.setUIID("");
                gui_ac_search.setInlineStylesTheme(resourceObjectInstance);
        gui_ac_search.setName("ac_search");
        gui_ac_search.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue8b6".charAt(0), gui_ac_search.getUnselectedStyle()));
        gui_btn_search.setPreferredSizeStr("5.555556mm 6.878307mm");
        gui_btn_search.setUIID("Correct_Msg_Save_Lbl");
                gui_btn_search.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_search.setName("btn_search");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_search,"\ue5c8".charAt(0));
        gui_Container.addComponent(gui_ac_search);
        gui_Container.addComponent(gui_btn_search);
        ((com.codename1.ui.layouts.LayeredLayout)gui_ac_search.getParent().getLayout()).setInsets(gui_ac_search, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_ac_search, "-1 1 -1 -1").setReferencePositions(gui_ac_search, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_search.getParent().getLayout()).setInsets(gui_btn_search, "0.0mm -1.9073486E-6mm 0.0mm auto").setReferenceComponents(gui_btn_search, "-1 -1 -1 -1").setReferencePositions(gui_btn_search, "0.0 0.0 0.0 0.0");
        addComponent(gui_fab_dlg);
        gui_btn_tranperent.setPreferredSizeStr("32.804234mm 29.36508mm");
                gui_btn_tranperent.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_tranperent.setName("btn_tranperent");
        gui_btn_month.setPreferredSizeStr("13.4920635mm 9.523809mm");
        gui_btn_month.setText("Month");
        gui_btn_month.setUIID("ic_fab");
                gui_btn_month.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_month.setName("btn_month");
        gui_btn_week.setPreferredSizeStr("13.4920635mm 9.523809mm");
        gui_btn_week.setText("Week");
        gui_btn_week.setUIID("ic_fab");
                gui_btn_week.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_week.setName("btn_week");
        gui_btn_day.setPreferredSizeStr("13.4920635mm 9.523809mm");
        gui_btn_day.setText("Day");
        gui_btn_day.setUIID("ic_fab");
                gui_btn_day.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_day.setName("btn_day");
        gui_fab_dlg.addComponent(gui_btn_tranperent);
        gui_fab_dlg.addComponent(gui_btn_month);
        gui_fab_dlg.addComponent(gui_btn_week);
        gui_fab_dlg.addComponent(gui_btn_day);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_tranperent.getParent().getLayout()).setInsets(gui_btn_tranperent, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_tranperent, "-1 -1 -1 -1").setReferencePositions(gui_btn_tranperent, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_month.getParent().getLayout()).setInsets(gui_btn_month, "2.0% 0.0mm auto auto").setReferenceComponents(gui_btn_month, "-1 -1 -1 -1").setReferencePositions(gui_btn_month, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_week.getParent().getLayout()).setInsets(gui_btn_week, "10.0% auto auto 10.0%").setReferenceComponents(gui_btn_week, "-1 -1 -1 -1").setReferencePositions(gui_btn_week, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_day.getParent().getLayout()).setInsets(gui_btn_day, "auto auto 5.0% 9.0%").setReferenceComponents(gui_btn_day, "-1 -1 -1 -1").setReferencePositions(gui_btn_day, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Map.getLayout()).setPreferredWidthMM((float)75.39683);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Map.getLayout()).setPreferredHeightMM((float)130.95238);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Map.getParent().getLayout()).setInsets(gui_Con_Map, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Con_Map, "-1 -1 -1 -1").setReferencePositions(gui_Con_Map, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)50.529102);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)10.8465605);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "3.0mm 10.0% auto 10.0%").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_fab_dlg.getLayout()).setPreferredWidthMM((float)27.248678);
        ((com.codename1.ui.layouts.LayeredLayout)gui_fab_dlg.getLayout()).setPreferredHeightMM((float)23.544973);
        ((com.codename1.ui.layouts.LayeredLayout)gui_fab_dlg.getParent().getLayout()).setInsets(gui_fab_dlg, "auto 0.0mm 0.0mm auto").setReferenceComponents(gui_fab_dlg, "-1 -1 -1 -1").setReferencePositions(gui_fab_dlg, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    FloatingActionButton fab = FloatingActionButton.createFAB('$');
    Switch switch_cpm = new Switch();

    private void installFixItems(Resources res, Form frm) {
        installSideMenu(res, this);
        gui_ac_search.getHintLabel().setGap(15);
//      search.setUIID("Activation_Input");
        gui_ac_search.setHintIcon(res.getImage("search_ic.png").scaled(56, 56));
        gui_ac_search.getHintLabel().setUIID("TextHintLarge");
//        con_search.setUIID("search_input");

        switch_cpm.getAllStyles().setFgColor(0xF7ED23);
        switch_cpm.getAllStyles().setBgColor(0xA3CC2E);
        switch_cpm.setPropertyValue("value", false);
        if (!isArabic()) {
            getToolbar().addComponent(BorderLayout.EAST, switch_cpm);
        } else {
            getToolbar().addComponent(BorderLayout.WEST, switch_cpm);
        }
        switch_cpm.addActionListener(e -> {
            if (switch_cpm.isOn()) {
                frm.show();
//                new UITimer(() -> {
//                    switch_cpm.setPropertyValue("value", false);
//                }).schedule(150, false, this);

            }
        });
        this.revalidate();
        ((Switch) this.getToolbar().getComponentAt(2)).getAllStyles().setPaddingRight(3);

        gui_ac_search.setRows(1);
        gui_ac_search.getHintLabel().getAllStyles().setAlignment(LEFT);
        gui_ac_search.getHintLabel().getAllStyles().setPaddingLeft(4);
        fab.setPreferredH(cn1Display.getWidth() / 6);
        fab.setPreferredW(cn1Display.getWidth() / 6);
        RoundBorder rb = (RoundBorder) fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.setUIID("FloatingActionButton");
        fab.setX(this.getWidth() - 10);
        fab.setY(this.getHeight() - 10);
    }
    boolean fab_dlg = false;

    private void addFabListener(Resources res, MapContainer map) {
        fab.addActionListener(e -> {
            Image oldImage = fab.getIcon();
            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButtonClose", 3.8f);
            fab.setIcon(image);
            if (!fab_dlg) {
                gui_fab_dlg.setVisible(true);
                fab_dlg = true;
                this.revalidate();
            } else {
                gui_fab_dlg.setVisible(false);
                fab_dlg = false;
                this.revalidate();
            }
            fab.setUIID("FloatingActionButton");
            fab.setIcon(oldImage);
        });
        gui_btn_month.addActionListener(e -> {
            fab_dlg = false;
            subscription_type = "price_m";
            gui_fab_dlg.setVisible(false);
            addMarkers(res, map, "price_m");
            this.revalidate();
        });
        gui_btn_week.addActionListener(e -> {
            fab_dlg = false;
            subscription_type = "price_w";
            gui_fab_dlg.setVisible(false);
            addMarkers(res, map, "price_w");
            this.revalidate();
        });
        gui_btn_day.addActionListener(e -> {
            fab_dlg = false;
            subscription_type = "price_d";
            gui_fab_dlg.setVisible(false);
            addMarkers(res, map, "price_d");
            this.revalidate();
        });

    }

    public void addMarkers(Resources res, MapContainer map, String type) {
        map.clearMapLayers();
        map.revalidate();
        this.revalidate();
        for (Map<String, Object> item : list) {
            String id = item.get("id") + "";
//            if (!id_gym.equals("0")) {
            String name = item.get("name") + "";
//                String price = item.get(type) + " JD";
            String price = (Integer.valueOf(item.get(type).toString()) + Integer.valueOf(item.get(type + "_fees").toString())) + " JD";
            String coordinates = item.get("coordinates") + "";
            String[] adressSub = cn1String.splite(coordinates, ",");
            double lat = Double.valueOf(adressSub[0]);
            double lon = Double.valueOf(adressSub[1]);
            if (!item.get(type).toString().equals("0")) {
                map.addMarker(new Gym_Place_Icon(res, id, type, price), new Coord(lat, lon));
            }
        }
        map.revalidate();
    }

    /*private void addSwitchItem(Form frm) {
        Switch switch_cpm = new Switch();
        switch_cpm.getAllStyles().setFgColor(0xF7ED23);
        switch_cpm.getAllStyles().setBgColor(0xA3CC2E);
        switch_cpm.setPropertyValue("value", false);
//        if (!isArabic()) {
//            getToolbar().addComponent(BorderLayout.EAST, switch_cpm);
//        } else {
//            getToolbar().addComponent(BorderLayout.WEST, switch_cpm);
//        }
        switch_cpm.addActionListener(e -> {
            if (switch_cpm.isOn()) {
                frm.show();
                switch_cpm.setPropertyValue("value", false);
            }
        });
        this.revalidate();
        ((Switch) this.getToolbar().getComponentAt(2)).getAllStyles().setPaddingRight(3);
    }*/
    public void onbtn_tranperentActionEvent(com.codename1.ui.events.ActionEvent ev) {
        gui_fab_dlg.setVisible(false);
    }

    private void checkLanguage(Resources res) {
        initGuiBuilderComponents(res);
        if (com.yallagym.BaseForm.isArabic()) {
            setRTLCmb(res);
        }

    }

    private void initArGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
    }

    private void setRTLCmb(Resources res) {
        gui_ac_search.getHintLabel().setRTL(true);
    }
}
