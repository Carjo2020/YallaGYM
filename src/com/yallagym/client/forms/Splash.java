package com.yallagym.client.forms;

import com.yallagym.forms.login.forms.BaseLogin;
import com.codename1.io.Preferences;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.system.NativeLookup;
import com.codename1.ui.CN;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;
import com.yallagym.club.forms.club_orders;
import com.yallagym.club.club_images_controller;
import com.yallagym.forms.login.WalkthruForm;
import com.yallagym.forms.login.forms.login_form;
import com.yallagym.forms.login.init_settings;
import com.yallagym.login.sms.Activation_Form_2;
import com.yallagym.nativeCodes;
import java.util.Hashtable;

public class Splash extends BaseLogin {

    Resources res;
    Location position = null;
    APIs api = new APIs();

    public Splash() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public Splash(com.codename1.ui.util.Resources res) {
        initGuiBuilderComponents(res);
        this.res = res;
        sethideToolbar();
        gui_yallagym.setPreferredW(gui_yallagym.getPreferredH() * 3);
        gui_logo.setPreferredH(gui_logo.getPreferredW());
        new UITimer(() -> {
            if (BaseForm.isAndroid()) {
                boolean checkUpdate = api.checkUpdate();
                if (!checkUpdate) {
                    run();
                } else {
                    new erorr_msg(res, "There is a new update", "you need to update app before open, click on \"ok\" to open in google play.", "Ok", e -> {
                        CN.execute("https://play.google.com/store/apps/details?id=com.yallagym");
                    }, true).show();
                }
            } else {
                run();
            }
        }).schedule(50, false, this);
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {

            }
        };
        this.setBackCommand(back);
    }
//        String lng = Preferences.get("bundle_language", "null");
//        System.out.println("bundle_language:" + lng);
//        switch (lng) {
//            case "null":
//                new init_settings(theme).show();
//                break;
//            case "ar":
//                Hashtable bundle = theme.getL10N("Languages", "ar");
//                manager.setBundle(bundle);
//                BaseForm.enableArabic(true);
//                new Splash(theme).show();
//                break;
//            default:
//                new Splash(theme).show();
//                break;
//        }
//////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_bg_img = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_bg_img_gray = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_logo = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_yallagym = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.components.InfiniteProgress gui_Infinite_Progress = new com.codename1.components.InfiniteProgress();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Splash");
        setName("Splash");
        gui_bg_img.setPreferredSizeStr("98.677246mm 134.12698mm");
                gui_bg_img.setInlineStylesTheme(resourceObjectInstance);
        gui_bg_img.setInlineAllStyles("bgImage:background-image.png;");
        gui_bg_img.setName("bg_img");
        gui_bg_img_gray.setPreferredSizeStr("123.544975mm 138.62434mm");
                gui_bg_img_gray.setInlineStylesTheme(resourceObjectInstance);
        gui_bg_img_gray.setInlineAllStyles("bgImage:dark-layer.png;");
        gui_bg_img_gray.setName("bg_img_gray");
        gui_Container.setPreferredSizeStr("104.49735mm 123.809525mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_bg_img);
        addComponent(gui_bg_img_gray);
        addComponent(gui_Container);
        gui_logo.setPreferredSizeStr("41.534393mm 41.798943mm");
                gui_logo.setInlineStylesTheme(resourceObjectInstance);
        gui_logo.setInlineAllStyles("bgImage:logo.png;");
        gui_logo.setName("logo");
        gui_yallagym.setPreferredSizeStr("47.089947mm 12.698413mm");
                gui_yallagym.setInlineStylesTheme(resourceObjectInstance);
        gui_yallagym.setInlineAllStyles("bgImage:Logo---Crop.png;");
        gui_yallagym.setName("yallagym");
        gui_Label.setPreferredSizeStr("52.910053mm inherit");
        gui_Label.setText("Wait for logging ...");
        gui_Label.setUIID("lbl_white");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
                gui_Infinite_Progress.setInlineStylesTheme(resourceObjectInstance);
        gui_Infinite_Progress.setName("Infinite_Progress");
        gui_Container.addComponent(gui_logo);
        gui_Container.addComponent(gui_yallagym);
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_Infinite_Progress);
        ((com.codename1.ui.layouts.LayeredLayout)gui_logo.getParent().getLayout()).setInsets(gui_logo, "10.0% auto auto auto").setReferenceComponents(gui_logo, "-1 -1 -1 -1").setReferencePositions(gui_logo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_yallagym.getParent().getLayout()).setInsets(gui_yallagym, "5.0% auto auto auto").setReferenceComponents(gui_yallagym, "0 -1 -1 -1").setReferencePositions(gui_yallagym, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto 15.0% auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Infinite_Progress.getParent().getLayout()).setInsets(gui_Infinite_Progress, "auto auto 15.0% auto").setReferenceComponents(gui_Infinite_Progress, "1 -1 2 -1").setReferencePositions(gui_Infinite_Progress, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)104.49735);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)123.809525);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.26455027mm auto 0.26455027mm auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!ON'T EDIT ABOVE THIS LINE!!!   
    public void checkUserLogin(Resources res, String userStr, String passStr) {

        String check = api.checkUserLogin(userStr, passStr);
        switch (check) {
            case "true":
                Preferences.set("username", userStr);
                Preferences.set("password", passStr);
                api.storeUser(res);
                String is_verified = Preferences.get("is_verified", "null");
                if (is_verified.equals("false")) {
                    new Activation_Form_2(res, new login_form(res), true).show();
                } else if (is_verified.equals("blocked")) {
                    new erorr_msg(res, "No access", "Your account has been suspended.", "Ok", e -> {
                        new login_form(res).show();
                    }, true).show();
                } else {              
                    new list_form(res).show();
                }
                break;
            case "username not found":
                new login_form(res).show();
                break;
            case "password not correct":

                new login_form(res).show();
                break;
        }
    }

    public void checkGymLogin(Resources res, String userStr, String passStr) {
        APIs api = new APIs();
        club_APIs club_api = new club_APIs();
        String check = api.checkGymLogin(userStr, passStr);
        switch (check) {
            case "true":
                Preferences.set("username", userStr);
                Preferences.set("password", passStr);
                club_BaseForm.currentListing = club_api.getGymOrders();
                CN.callSerially(() -> {
                    club_BaseForm.CurrentPaymentListing = club_api.getGymPayments();
                    club_BaseForm.profile_info = club_api.getGymInfo();
                    club_BaseForm.gym_url = club_api.getGymImages();
                    new club_images_controller().getGymImages(club_BaseForm.gym_url);
                });
                api.storeGym(res);
                new club_orders(res).show();
                break;
            case "username not found":
                new login_form(res).show();
                break;
            case "password not correct":

                new login_form(res).show();
                break;
        }
    }

    private void run() {
        boolean is_select_language = Preferences.get("is_select_language", false);
        System.out.println("is_select_language:" + is_select_language);
        if (is_select_language) {

            String username = Preferences.get("username", "null");
            String password = Preferences.get("password", "null");
            if (!username.equals("null") && !password.equals("null")) {
                if (!username.endsWith("_yalla")) {
                    checkUserLogin(res, username, password);
                } else {
                    checkGymLogin(res, username, password);
                }
            } else {
                new login_form(res).show();
            }
        } else {
            new init_settings(res).show();
        }
    }

}
//                    LocationManager manager = Display.getInstance().getLocationManager();
//                    if (manager.isGPSDetectionSupported()) {
//                        if (manager.isGPSEnabled()) {
//                            CN.callSeriallyAndWait(() -> {
//                            try {
//                                position = LocationManager.getLocationManager().getCurrentLocationSync(20000);
//                                if (position != null) {
//                                    Preferences.set("lat", position.getLatitude());
//                                    Preferences.set("lng", position.getLongitude());
//                                } else {
//                                    Preferences.set("lat", 0);
//                                    Preferences.set("lng", 0);
//                                }
////                            });
//                                new list_form(res).show();
//                            } catch (Exception e) {
//                                Preferences.set("lat", 0);
//                                Preferences.set("lng", 0);
//                                new list_form(res).show();
//                            }
//
//                        } else {
//                            Dialog dlg = new erorr(res, "GPS disabled", "YallaGym needs access to GPS. Please enable GPS", "Ok", e -> {
//                                nativeCodes advanceCode = NativeLookup.create(nativeCodes.class);
//                                if (advanceCode != null && advanceCode.isSupported()) {
//                                    advanceCode.enableGPSAPI();
//                                }
//                            }, "Skip", ee -> {
//                                Preferences.set("lat", 0);
//                                Preferences.set("lng", 0);
//                                new list_form(res).show();
//                            });
//                            dlg.setDisposeWhenPointerOutOfBounds(false);
//                            dlg.show();
//
//                            // enable gps -> then run splash again
//                        }
//                    } else {
//                        System.err.println("GPS Not supported!!");
//                        Preferences.set("lat", 0);
//                        Preferences.set("lng", 0);
