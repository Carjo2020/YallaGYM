package com.yallagym.client;

import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.ui.CN;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import com.yallagym.client.forms.Splash;

public class CallbackNative {
    
    private Resources res;
// static Splash frm;

    public void saveLocation(String lat, String lng) {
//        ToastBar.showInfoMessage("run CallbackNative");
//        res = UIManager.initNamedTheme("/theme", "Theme");
//        CN.callSerially(() -> {
//            
//            ToastBar.showInfoMessage("run CallbackNative");
//      frm.show();
//
//        });
        com.yallagym.NativeCallback.callback(0);
        Preferences.set("lat", lat);
        Preferences.set("lng", lng);
    }
}
