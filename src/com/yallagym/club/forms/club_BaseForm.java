package com.yallagym.club.forms;

import com.cn2.ui.cn1Display;
import com.cn2.ui.cn1Icons;
import com.cn2.util.cn1String;
import com.codename1.io.Preferences;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.BaseForm;
import com.yallagym.client.forms.Settings;
import com.yallagym.forms.login.forms.login_form;
import com.yallagym.client.layouts.logo;
import java.util.List;
import java.util.Map;

public class club_BaseForm extends Form {

    public static Map<String, Object> currentListing;
    public static Map<String, Object> CurrentPaymentListing;
    public static Map<String, Object> profile_info;
    public static Image[] profile_info_images;
    public static List<Map<String, Object>> gym_url;

    public static Map<String, Object> getCurrentListing() {
        return currentListing;
    }

    public static Map<String, Object> getCurrentPaymentListing() {
        return CurrentPaymentListing;
    }

    public static Map<String, Object> getProfile_info() {
        return profile_info;
    }

    public static Image[] getProfile_info_images() {
        return profile_info_images;
    }

    public static List<Map<String, Object>> getGym_url() {
        return gym_url;
    }

//    public static void setCurrentListing(Map<String, Object> currentListing1) {
//        this.currentListing = currentListing1;
//    }
    public void installSideMenu(Resources res, Form frm) {

        Label l = new Label("", "YallaGym");
        l.setPreferredH(cn1Display.getScaledMax(12));
        l.setPreferredW(cn1Display.getWidth());
        l.getAllStyles().setMarginTop(cn1Display.getScaledMax(20));
        if (!BaseForm.isArabic()) {
            this.getToolbar().addComponentToLeftSideMenu(l);
            this.getToolbar().addCommandToLeftSideMenu("   Orders", new cn1Icons().getImage("business center", "SideCommand", 6), e -> {
                new club_orders(res).show();
            });
            this.getToolbar().addComponentToLeftSideMenu(createDivider());
            this.getToolbar().addCommandToLeftSideMenu("   Payments", new cn1Icons().getImage("account balance wallet", "SideCommand", 6), e -> {
                new club_payments(res, frm).show();
            });

            this.getToolbar().addComponentToLeftSideMenu(createDivider());
            this.getToolbar().addCommandToLeftSideMenu("   Profile", new cn1Icons().getImage("person", "SideCommand", 6), e -> {
                new club_settings(res, frm).show();
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
            this.getToolbar().addCommandToRightSideMenu("   Orders", new cn1Icons().getImage("business center", "SideCommand", 6), e -> {
                new club_orders(res).show();
            });
            this.getToolbar().addComponentToRightSideMenu(createDivider());
            this.getToolbar().addCommandToRightSideMenu("   Payments", new cn1Icons().getImage("account balance wallet", "SideCommand", 6), e -> {
                new club_payments(res, frm).show();
            });

            this.getToolbar().addComponentToRightSideMenu(createDivider());
            this.getToolbar().addCommandToRightSideMenu("   Profile", new cn1Icons().getImage("person", "SideCommand", 6), e -> {
                new club_settings(res, frm).show();
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

    private Label createDivider() {
        Label divider = new Label("", "dividerSideMenu");
        divider.setPreferredH(10);
        divider.setPreferredW(cn1Display.getWidth());
        divider.getAllStyles().setBgColor(0xececec);
        return divider;
    }

    public void installTitleArea(Resources res) {
        this.setTitle("");
        this.setScrollVisible(false);
        getToolbar().setPreferredH(cn1Display.getHeight() / 9);
        this.getToolbar().add(CENTER, new logo(res));
    }

    public void installBackIcon(Form backform) {
        if (!BaseForm.isArabic()) {
            this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK_IOS, e -> {
                backform.show();
            });
        } else {
            this.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_FORWARD, e -> {
                backform.show();
            });
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

    public TextField createSearchBar(Resources res, Container con_search) {
        TextField search = new TextField("", "Search Here...");
        search.getHintLabel().setGap(15);
        search.setUIID("Activation_Input");
        search.setHintIcon(res.getImage("search_ic.png").scaled(56, 56));
        search.getHintLabel().setUIID("TextHintLarge");
        con_search.setUIID("search_input");
        con_search.add(CENTER, search);
        if (BaseForm.isArabic()) {
            search.setRTL(true);
            search.getHintLabel().setRTL(true);
        }
        return search;
    }

    public String formatArabicNumber(String no) {
        no = cn1String.replaceAll(no, new String[]{"۰", "۱", "۲", "۳", "٤", "٥", "٦", "٧", "۸", "۹", " "}, new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ""});
        return no;
    }

    public String formatPhone(String phone) {
        phone = cn1String.replaceAll(phone, new String[]{"۰", "۱", "۲", "۳", "٤", "٥", "٦", "٧", "۸", "۹", " "}, new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ""});
        if (phone.startsWith("0")) {
            phone = StringUtil.replaceFirst(phone, "0", "+962");
        } else if (phone.startsWith("962")) {
            phone = StringUtil.replaceFirst(phone, "962", "+962");
        } else if (phone.startsWith("+9620")) {
            phone = StringUtil.replaceFirst(phone, "+9620", "+962");
        } else if (phone.startsWith("9620")) {
            phone = StringUtil.replaceFirst(phone, "9620", "+962");
        } else if (phone.startsWith("00962")) {
            phone = StringUtil.replaceFirst(phone, "00962", "+962");
        } else if (phone.startsWith("77")) {
            phone = StringUtil.replaceFirst(phone, "77", "+96277");
        } else if (phone.startsWith("78")) {
            phone = StringUtil.replaceFirst(phone, "78", "+96278");
        } else if (phone.startsWith("79")) {
            phone = StringUtil.replaceFirst(phone, "79", "+96279");
        }
        System.out.println(phone);
        return phone;
    }

    public boolean isAndroid() {
        return Display.getInstance().getPlatformName().equalsIgnoreCase("and");
    }

}
