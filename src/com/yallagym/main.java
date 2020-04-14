package com.yallagym;

import com.codename1.components.InfiniteProgress;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.io.Preferences;
import com.codename1.ui.Toolbar;
import com.codename1.push.Push;
import com.codename1.push.PushCallback;

import com.codename1.ui.CN;
import com.codename1.ui.animations.BubbleTransition;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;
import com.yallagym.club.forms.club_orders;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.client.forms.Splash;
import com.yallagym.client.forms.list_form;
import com.yallagym.client.forms.client_orders;
import com.yallagym.forms.login.init_settings;
import java.util.Hashtable;

public class main implements PushCallback {

    private Form current;
    private Resources theme;
    UIManager manager;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");
        manager = UIManager.getInstance();
        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if (err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            new erorr_msg(theme, "Connection Error", "There was a networking error in the connection to WiFi", "Ok", null).show();
        });
        InfiniteProgress.setDefaultMaterialDesignMode(true);
        Display.getInstance().lockOrientation(true);
        manager.getLookAndFeel().setDefaultFormTransitionIn(null);
        manager.getLookAndFeel().setDefaultFormTransitionOut(new BubbleTransition(300, "BubbleButton"));

    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }
        Display.getInstance().registerPush();
        String lng = Preferences.get("bundle_language", "null");
        System.out.println("bundle_language:" + lng);
        if (lng.equals("ar")) {
            Hashtable bundle = theme.getL10N("Languages", "ar");
            manager.setBundle(bundle);
            BaseForm.enableArabic(true);
        }
        new Splash(theme).show();
    }

    public void stop() {
        current = getCurrentForm();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = getCurrentForm();
        }
    }

    public void destroy() {
    }

    @Override
    public void push(String value) {
        System.out.println("Received push message: " + value);
        String username = Preferences.get("username", "null").toLowerCase();
        if (!username.equals("null")) {
            if (username.endsWith("_yalla")) {
                if (CN.getCurrentForm().getName().equals("club_orders")) {
                    club_APIs club_api = new club_APIs();
                    club_BaseForm.currentListing = club_api.getGymOrders();
                    new erorr_msg(theme, "New enrollment", "you have new enrollment!!\nplease pull the orders page to show a new order or click on refresh", "Refresh", (e) -> {
                        new club_orders(theme).show();
                    }).show();
                } else {
                    club_APIs club_api = new club_APIs();
                    club_BaseForm.currentListing = club_api.getGymOrders();
                    new erorr_msg(theme, "New enrollment", "you have new enrollment!!\ngo to orders page to see it", "Ok", null).show();
                }
            } else {
                new com.yallagym.client.dialogs.erorr(theme, "Push Notification", "A new action has been taken on your order\nDo you want to open orders page now?", "Yes", (e) -> {
                    new client_orders(theme, new list_form()).show();
                }).show();
            }

        }
    }

    public void pushCallBackFromIosDevice() {

    }
//\nplease pull the orders page to show a new order

    @Override
    public void registeredForPush(String discard) {
        // Successfully registered device for push!!
        String DEVICE_ID = Push.getPushKey();
        if (!DEVICE_ID.equals("null")) {
            Preferences.set("pushtoken", DEVICE_ID);
        }
        // Store this DEVICE_ID for later use
//        new erorr_msg(theme, "Push Message", "Push.getPushKey():" + DEVICE_ID, "Ok", null).show();
    }

    @Override
    public void pushRegistrationError(String err, int errCode) {
//        System.out.println("An error occurred during push registration.");
        new erorr_msg(theme, "Push Message", "An error occurred during push registration:" + err, "Ok", null).show();
    }

}
