package com.yallagym;

import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.ui.CN;
import com.codename1.ui.Display;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.client.forms.client_orders;
import com.yallagym.client.forms.list_form;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;
import com.yallagym.club.forms.club_orders;
import java.io.IOException;

public class NativeCallback {
    
    static Resources theme;
    
    public static void callback(int arg) {
//        Display.getInstance().invokeAndBlock(() -> {
//            CN.callSeriallyAndWait(() -> {
//                ToastBar.showInfoMessage("Run CallBack");
        try {
            theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
//            });
//        });
    }
}
