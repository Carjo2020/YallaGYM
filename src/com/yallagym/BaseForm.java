package com.yallagym;

import com.cn2.lang.cn1Math;
import com.cn2.ui.cn1Display;
import com.cn2.ui.cn1Icons;
import com.codename1.components.Switch;
import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.animations.Transition;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.yallagym.client.Map_Switch_Icon_Controller;
import com.yallagym.client.dialogs.dlg_apple_select_map;
import com.yallagym.client.forms.Settings;
import com.yallagym.client.forms.client_orders;
import com.yallagym.client.forms.list_form;
import com.yallagym.client.forms.map_form;
import com.yallagym.forms.login.forms.login_form;
import com.yallagym.client.layouts.logo;
import com.yallagym.client.forms.user_info;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BaseForm extends Form {

    private int is = 0;
    public static Transition defaultInTrans = CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 500);
    public static Transition defaultInTrans2 = CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, false, 300);
    int length = cn1Math.nextDown(getToolbar().getPreferredH() / 3.0);
    private Form cerruntForm = null;
    private static List<Map<String, Object>> list = null;
    private static String[] gyms_names;
    private static String[] gyms_coordinates;
    private static boolean isArabic = Preferences.get("bundle_language", "null").equals("ar");
    private static boolean isAndroid = Display.getInstance().getProperty("OS", "").equals("android");

    public static void enableArabic(boolean isArabic) {
        BaseForm.isArabic = isArabic;
    }

    public static String[] getGymsNames() {
        return gyms_names;
    }

    public static String[] getGymsCoord() {
        return gyms_coordinates;
    }

    public static List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
        int size = list.size();
        gyms_names = new String[size];
        gyms_coordinates = new String[size];
        if (list != null) {
            for (int i = 0; i < size; i++) {
                Map<String, Object> item = list.get(i);
//                String id_gym = item.get("id") + "";
                gyms_names[i] = item.get("name") + "";
                gyms_coordinates[i] = item.get("coordinates") + "";
            }
        }

    }

    public Form getCerruntForm() {
        return cerruntForm;
    }

    public void setCerruntForm(Form cerruntForm) {
        this.cerruntForm = cerruntForm;
    }

    public void installTitleArea(Resources res) {
        this.setTitle("");
        this.setScrollVisible(false);
//        System.out.println("cn1Display.getHeight()/9:" + cn1Display.getHeight() / 9);
        getToolbar().setPreferredH(Math.max(150, cn1Display.getHeight() / 9));
        this.getToolbar().add(CENTER, new logo(res));
    }

    public void installBackIcon(Form backform) {
        if (!isArabic) {
            this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK_IOS, e -> {
                backform.show();
            });
        } else {
            this.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_FORWARD, e -> {
                backform.show();
            });
        }
    }

    public void installCheckIcon(ActionListener e) {
        if (!isArabic) {
            this.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_CHECK, e);
        } else {
            this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_CHECK, e);
        }
    }

    public void installBackCommand(Form backform) {
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
                backform.show();
            }
        };
        this.setBackCommand(back);
    }

    public void installOrderIcon(Resources res, ActionListener e) {
        Button orders = new Button("");
        orders.getAllStyles().setBgImage(res.getImage("orders.png").scaled(length, length));
//        orders.getAllStyles().setMarginTop(2);
//        orders.getAllStyles().setMarginBottom(2);
//        orders.getAllStyles().setMarginRight(0);
//System.out.println(    getToolbar().getComponentAt(2).getUIID());
//        for (int i = 0; i < getToolbar().getComponentCount(); i++) {
//            System.out.println(getToolbar().getComponentAt(i).getUIID());
//        }
//        System.out.println(((Container)getToolbar().getComponentAt(1)).getComponentAt(1).getUIID());

//        System.out.println(getToolbar().getComponentat);
//        System.out.println(getToolbar().getComponentForm().getComponentCount());
        orders.setPreferredW(length);
        orders.addActionListener(e);
        this.getToolbar().addComponent(BorderLayout.EAST, orders);
    }

    public void installMessangerIcon(Resources res, ActionListener e) {
        Button orders = new Button("");
        orders.getAllStyles().setBgImage(res.getImage("messengerr.png").scaled(length, length));
        orders.setPreferredW(length);
        orders.addActionListener(e);
        this.getToolbar().addComponent(BorderLayout.EAST, orders);
    }

    public void installSideMenu(Resources res, Form frm) {
        Label l = new Label("", "YallaGym");
        l.setPreferredH(cn1Display.getScaledMax(12));
        l.setPreferredW(cn1Display.getWidth());
        l.getAllStyles().setMarginTop(cn1Display.getScaledMax(20));
        if (!isArabic()) {

            this.getToolbar().addComponentToLeftSideMenu(l);
            this.getToolbar().addCommandToLeftSideMenu("   Home", new cn1Icons().getImage("home", "SideCommand", 6), e -> {
                new list_form(res).show();
            });
            this.getToolbar().addComponentToLeftSideMenu(createDivider());
            this.getToolbar().addCommandToLeftSideMenu("   Map", new cn1Icons().getImage("map", "SideCommand", 6), e -> {
                if (isAndroid()) {
                    new map_form(res, new list_form(res), null).show();
                } else {
                    boolean is_select_map = Preferences.get("map_type", false);
                    if (is_select_map) {
                        new map_form(res, new list_form(res), null).show();
                    } else {
                        new dlg_apple_select_map(res).show();
                    }
                }
            });

            this.getToolbar().addComponentToLeftSideMenu(createDivider());
            this.getToolbar().addCommandToLeftSideMenu("   Personal Information", new cn1Icons().getImage("person", "SideCommand", 6), e -> {
                new user_info(res, frm).show();
            });
            this.getToolbar().addComponentToLeftSideMenu(createDivider());
            this.getToolbar().addCommandToLeftSideMenu("   My Orders", new cn1Icons().getImage("business center", "SideCommand", 6), e -> {
//            new user_orders(res, frm).show();
                new client_orders(res, frm).show();
            });
            this.getToolbar().addComponentToLeftSideMenu(createDivider());
            this.getToolbar().addCommandToLeftSideMenu("   Settings", new cn1Icons().getImage("settings", "SideCommand", 6), e -> {
                new Settings(res, frm).show();
            });
            this.getToolbar().addComponentToLeftSideMenu(createDivider());
            this.getToolbar().addCommandToLeftSideMenu("   Logout", new cn1Icons().getImage("exit to app", "SideCommand", 6), e -> {
                Preferences.delete("username");
                Preferences.delete("password");
                new login_form(res).show();
            });
            this.getToolbar().addComponentToLeftSideMenu(createDivider());
        } else {
            this.getToolbar().addComponentToRightSideMenu(l);
            Command c = this.getToolbar().addCommandToRightSideMenu("   Home", new cn1Icons().getImage("home", "SideCommand", 6), e -> {
                new list_form(res).show();
            });
            this.getToolbar().addComponentToRightSideMenu(createDivider());
            this.getToolbar().addCommandToRightSideMenu("   Map", new cn1Icons().getImage("map", "SideCommand", 6), e -> {
                new map_form(res, new list_form(res), null).show();
            });

            this.getToolbar().addComponentToRightSideMenu(createDivider());
            this.getToolbar().addCommandToRightSideMenu("   Personal Information", new cn1Icons().getImage("person", "SideCommand", 6), e -> {
                new user_info(res, frm).show();
            });
            this.getToolbar().addComponentToRightSideMenu(createDivider());
            this.getToolbar().addCommandToRightSideMenu("   My Orders", new cn1Icons().getImage("business center", "SideCommand", 6), e -> {
//            new user_orders(res, frm).show();
                new client_orders(res, frm).show();
            });
            this.getToolbar().addComponentToRightSideMenu(createDivider());
            this.getToolbar().addCommandToRightSideMenu("   Settings", new cn1Icons().getImage("settings", "SideCommand", 6), e -> {
                new Settings(res, frm).show();
            });
            this.getToolbar().addComponentToRightSideMenu(createDivider());
            this.getToolbar().addCommandToRightSideMenu("   Logout", new cn1Icons().getImage("exit to app", "SideCommand", 6), e -> {
                Preferences.delete("username");
                Preferences.delete("password");
                new login_form(res).show();
            });
            this.getToolbar().addComponentToRightSideMenu(createDivider());
        }
    }

    public Coord getDeviceCoord() {
        Location location = LocationManager.getLocationManager().getLastKnownLocation();
        if (location == null) {
            try {
                location = LocationManager.getLocationManager().getCurrentLocation();
            } catch (IOException err) {
                ToastBar.showErrorMessage("erorr: " + is);
                is++;
                getDeviceCoord();
            }
        }
        Double lat = location.getLatitude();
        Double lng = location.getLongitude();
        return new Coord(lat, lng);
    }

    private Label createDivider() {
        Label divider = new Label("", "dividerSideMenu");
        divider.setPreferredH(10);
        divider.setPreferredW(cn1Display.getWidth());
        divider.getAllStyles().setBgColor(0xececec);
        return divider;
    }

//    private void facebookLogout(Resources res) {
//        String clientId = "477873012799140";
//        String redirectURI = "https://yallagym.com/";
//        String clientSecret = "62a40334c51182c38745ef8040e75227";
//        com.codename1.social.Login fb = FacebookConnect.getInstance();
//        fb.setClientId(clientId);
//        fb.setRedirectURI(redirectURI);
//        fb.setClientSecret(clientSecret);
//        fb.setScope("email");
//        fb.doLogout();
//        Preferences.set("token", "");
//        new Login(res).show();
//    }
    public TextField createSearchBar(Resources res, Container con_search) {
        TextField search;
        search = new TextField("", "Search Here...");
        search.getHintLabel().setGap(15);

        search.setUIID("Activation_Input");
        search.setHintIcon(res.getImage("search_ic.png").scaled(56, 56));
        search.getHintLabel().setUIID("TextHintLarge");
        con_search.setUIID("search_input");
        con_search.add(CENTER, search);
        return search;
    }

    public boolean checkIfThereChars(String textField) {
        boolean bool = textField.contains("'") || textField.contains("\"") || textField.contains("\\") || textField.contains("/") || textField.contains(".") || textField.contains("@");
        return bool;
    }

    public Component getComponent(Form frm, int... index) {
        Container cmb = (Container) frm.getComponentAt(index[0]);
        for (int i : index) {
            Container Container1 = (Container) cmb.getComponentAt(i);
            cmb = Container1;
        }
        return cmb;
    }

    public static boolean isArabic() {
        return isArabic;
    }

    public static boolean isAndroid() {
        return isAndroid;
    }
    private static Switch switch_cpm = new Switch();
    private static boolean isSwitchOn = true;

//    public void installSwitchIcon(Form list_form, Form map_form) {
//        switch_cpm.getAllStyles().setFgColor(0xF7ED23);
//        switch_cpm.getAllStyles().setBgColor(0xA3CC2E);
//        switch_cpm.setPropertyValue("value", isSwitchOn);
//        switch_cpm.addActionListener(e -> {
//            if (isSwitchOn) {
//                isSwitchOn = false;
//                map_form.show();
//            } else {
//                isSwitchOn = true;
//                list_form.show();
//            }
//        });
//            if (Map_Switch_Icon_Controller.isOnRight) {
//                Map_Switch_Icon_Controller.isOnRight = false;
//                Form map = new map_form(res, this);
//                setCerruntForm(map);
//                map.show();
//            } else {
//                Form lastform = getCerruntForm();
//                if (lastform != null) {
//                    lastform.show();
//                }
//
//            }
//            if (!isArabic()) {
//        getToolbar().addComponent(BorderLayout.EAST, switch_cpm);
//            } else {
//                getToolbar().addComponent(BorderLayout.WEST, switch_cpm);
//            }
//      
//        return switch_cpm;
//    }
}
