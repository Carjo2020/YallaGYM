package com.yallagym.forms.login.forms;

import com.yallagym.forms.login.*;
import com.cn2.util.cn1String;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.push.Push;
import com.codename1.ui.CN;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.APIs;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;
import com.yallagym.club.forms.club_orders;
import com.yallagym.client.forms.list_form;
import com.yallagym.club.club_images_controller;
import com.yallagym.login.sms.Activation_Form_2;

public class BaseLogin extends Form {

    APIs api = new APIs();


    public void installBackCommand(Form backform) {
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
                backform.show();
            }
        };
        this.setBackCommand(back);
    }

    public void sethideToolbar() {
        getToolbar().setHidden(true);
        setScrollVisible(false);
        setScrollable(false);
    }
    Form frm;

    public void checkUserLogin(Resources res, String userStr, String passStr) {
        InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        String check = api.checkUserLogin(userStr, passStr);
        System.out.println(check);

        switch (check) {

            case "true":
                Preferences.set("username", userStr);
                Preferences.set("password", passStr);
                api.storeUser(res);

                String is_verified = Preferences.get("is_verified", "null");
                if (is_verified.equals("false")) {
                    ipDlg.dispose();
                    new Activation_Form_2(res, new login_form(res), true).show();
                } else if (is_verified.equals("blocked")) {
                    new erorr_msg(res, "No access", "Your account has been suspended.", "Ok", e -> {
                        new login_form(res).show();
                    }, true).show();
                } else {
                    frm = new list_form(res);
                    ipDlg.dispose();
                    frm.show();
                }

                break;
            case "username not found":
                ipDlg.dispose();
                ToastBar.showErrorMessage("not correct email/phone ", 4000);
                break;
            case "password not correct":
                ipDlg.dispose();
                ToastBar.showErrorMessage("not correct password ", 4000);
                break;
        }
        ipDlg.dispose();
    }

    public void checkGymLogin(Resources res, String userStr, String passStr) {
        club_APIs club_api = new club_APIs();
        InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInfiniteBlocking();
        String check = api.checkGymLogin(userStr, passStr);
        System.out.println(check);
        switch (check) {

            case "true":
                Preferences.set("id", api.getGymID(userStr));
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
                Form frm = new club_orders(res);
                ipDlg.dispose();
                frm.show();
                break;
            case "username not found":
                ipDlg.dispose();
                ToastBar.showErrorMessage("not correct email/phone ", 4000);
                break;
            case "password not correct":
                ipDlg.dispose();
                ToastBar.showErrorMessage("not correct password ", 4000);
                break;
        }
        ipDlg.dispose();
    }

    public boolean isPhone(String text) {
        String replace = cn1String.replaceAll(text, new String[]{"+", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "۰", "۱", "۲", "۳", "٤", "٥", "٦", "٧", "۸", "۹"}, new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        if (replace.length() == 0) {
            return true;
        }
        return false;
    }

    public String formatUser(String username) {
        System.out.println("isPhone(username):" + isPhone(username));
        if (isPhone(username)) {
            username = cn1String.replaceAll(username, new String[]{"۰", "۱", "۲", "۳", "٤", "٥", "٦", "٧", "۸", "۹", " "}, new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ""});
            if (username.startsWith("0")) {
                username = StringUtil.replaceFirst(username, "0", "+962");
            } else if (username.startsWith("962")) {
                username = StringUtil.replaceFirst(username, "962", "+962");
            } else if (username.startsWith("+9620")) {
                username = StringUtil.replaceFirst(username, "+9620", "+962");
            } else if (username.startsWith("9620")) {
                username = StringUtil.replaceFirst(username, "9620", "+962");
            } else if (username.startsWith("00962")) {
                username = StringUtil.replaceFirst(username, "00962", "+962");
            } else if (username.startsWith("77")) {
                username = StringUtil.replaceFirst(username, "77", "+96277");
            } else if (username.startsWith("78")) {
                username = StringUtil.replaceFirst(username, "78", "+96278");
            } else if (username.startsWith("79")) {
                username = StringUtil.replaceFirst(username, "79", "+96279");
            }
        }
        return username.toLowerCase();
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
        return phone.toLowerCase();
    }

    public boolean checkIfThereChars(String textField) {
        boolean bool = textField.contains("'") || textField.contains("\"") || textField.contains("\\") || textField.contains("/") || textField.contains(".") || textField.contains("@");
        return bool;
    }


    String[] ar_keys = {"ذ", "ض", "ص", "ث", "ق", "ف", "غ", "ع", "ه", "خ", "ح", "ج", "د", "ط", "ك", "م", "ن", "ت", "ا", "ل", "ب", "ي", "س", "ش", "ئ", "ء", "ؤ", "ر", "ى", "ة", "و", "ز", "ظ", "آ", "ْ", "ِ", "ٍ", "أ", "إ", "ٌ", "ُ", "ً", "َ"};

    public boolean isHaveArabic(String username) {
        for (String key : ar_keys) {
            boolean ishave = username.contains(key);
            if (ishave) {
                return true;
            }
        }
        return false;
    }
}
