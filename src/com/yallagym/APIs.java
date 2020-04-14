package com.yallagym;

import com.cn2.util.cn1String;
import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.io.Util;
import com.codename1.io.rest.Rest;
import com.codename1.push.Push;
import com.codename1.system.NativeLookup;
import com.codename1.ui.CN;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.client.forms.list_form;
import com.yallagym.client.forms.Splash;
import com.yallagym.forms.login.forms.login_form;
import com.yallagym.login.sms.Activation_Form;
import com.yallagym.client.forms.user_info;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIs {

    Display d = Display.getInstance();
    String URL = "https://yallagym.herokuapp.com";
//    String URL = "http://localhost:8080";

    public java.util.List<Map<String, Object>> getGymBaseInfo(Resources res) {
        try {
            final Map<String, Object> currentListing = Rest.get(getURL() + "/api/gyms/info?id_user=" + Preferences.get("id", "0") + "&type=" + Preferences.get("type", "mixed")).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
            java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
            return content;
        } catch (Exception e) {
            return null;
        }
    }

    private String getURL() {
        if (d.getProperty("OS", "").equalsIgnoreCase("android")) {
            String osVer = d.getProperty("OSVer", "");
            String[] osVerSplite = cn1String.splite(osVer, ".");
            int version = Integer.valueOf(osVerSplite[0]);
            if (version < 6) {
                URL = "http://yallagym.herokuapp.com";
            }
        }
        return URL;
    }

    public boolean addUser(String first_name, String last_name, String phone, String age, String type, String address, String username, String password) {
        String language = Preferences.get("bundle_language", "en");
        String Body = "{\"first_name\":\"" + first_name + "\",\"last_name\":\"" + last_name + "\",\"phone\":\"" + phone + "\",\"type\":\"" + type + "\",\"age\":\"" + age + "\",\"address\":\"" + address + "\",\"username\":\"" + username + "\",\"password\":\"" + password + "\",\"push_token\":\"" + Push.getPushKey() + "\",\"language\":\"" + language + "\"}";
        Rest.post(getURL() + "/api/users/add").acceptJson().contentType("APPLICATION/JSON").body(Body).getAsString().getResponseData();
        return true;
    }

    String[] pattern = {"'", "\'"};
    String[] replace = {"", ""};

    public String getCorrectString(String value) {
        return cn1String.replaceAll(value, this.pattern, this.replace);
    }

    public Map<String, Object> getGymAllInfo(Resources res, String gym_id) {
        try {
            final Map<String, Object> currentListing = Rest.get(getURL() + "/api/gyms/info?id_gym=" + gym_id + "&id_user=" + Preferences.get("id", URL)).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
            if (currentListing.size() != 0) {
                java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
                return content.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void createOfflineOrder(String username, String id_gym, String date_order, String type, String dateStart) {
        String Body = "{\"username\":\"" + username + "\",\"id_gym\":\"" + id_gym + "\",\"date_order\":\"" + date_order + "\",\"subscribe_type\":\"" + type + "\",\"pay_method\":\"offline\",\"date_start\":\"" + dateStart + "\",\"payment_id_session\":\"\",\"payment_id_unique\":\"\"}";
        Rest.post(getURL() + "/api/orders/add").acceptJson().contentType("APPLICATION/JSON").body(Body).getAsString().getResponseData();
    }

    public void createOnlineOrder(String username, String id_gym, String date_order, String type, String dateStart, String id_session, String id_unique) {
        String Body = "{\"username\":\"" + username + "\",\"id_gym\":\"" + id_gym + "\",\"date_order\":\"" + date_order + "\",\"subscribe_type\":\"" + type + "\",\"pay_method\":\"online\",\"date_start\":\"" + dateStart + "\",\"payment_id_session\":\"" + id_session + "\",\"payment_id_unique\":\"" + id_unique + "\"}";
        Rest.post(getURL() + "/api/orders/add").acceptJson().contentType("APPLICATION/JSON").body(Body).getAsString().getResponseData();
    }

    public int getOrdersCount() {
        final String currentListing = Rest.get(getURL() + "/api/orders/count").acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return Integer.valueOf(currentListing);
    }

    private void addOrder(String email_user, String order) {
        String Body = "{\"email_user\":\"" + email_user + "\",\"id_order\":\"" + order + "\"}";
        Rest.post(getURL() + "/api/users/add/order").acceptJson().contentType("APPLICATION/JSON").body(Body).getAsJsonMap().getResponseData();

    }

    public List<Map<String, Object>> getOrders(String username) {
        try {
            Map<String, Object> currentListing = Rest.get(getURL() + "/api/users/orders/" + username).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
            java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
            return content;
        } catch (Exception e) {
            return null;
        }
    }

    public Map<String, Object> getOrder(int order) {
        try {
            Map<String, Object> currentListing = Rest.get(getURL() + "/api/users/order/" + order).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
            java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
            return content.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteOrder(String id_order) {
        Rest.delete(getURL() + "/api/orders/delete/" + id_order).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
    }

    public String checkUserLogin(String userStr, String passStr) {
        String username = getCorrectString(userStr);
        String password = getCorrectString(passStr);
        String login = Rest.get(getURL() + "/api/users/login/" + username + "/" + password).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return login;

    }

    public String checkGymLogin(String userStr, String passStr) {
        String username = getCorrectString(userStr);
        String password = getCorrectString(passStr);
        String login = Rest.get(getURL() + "/api/gyms/login/" + username + "/" + password).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return login;

    }

    public void storeUser(Resources res) {
        putLocations();
        String username = Preferences.get("username", "null");
        String password = Preferences.get("password", "null");
        if (!username.equals("null") && !password.equals("null")) {
            String push_token = getPushToken();
//            String push_token = "cn1dfdsf";
//            new erorr_msg(res, "Push Message", "push_token:" + push_token, "Ok", null).show();
            if (!push_token.equals("null") && !push_token.equals("")) {
                Rest.get(getURL() + "/api/users/push/" + username + "/" + password + "/" + push_token).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
            }
            Map<String, Object> currentListing = Rest.get(getURL() + "/api/cpanel/getuser/" + username + "/" + password).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
            java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
            Map<String, Object> map = content.get(0);
            String id = StringUtil.replaceFirst(map.get("id") + "", ".0", "");
            String first_name = map.get("first_name") + "";
            String last_name = map.get("last_name") + "";
            String phone = map.get("phone") + "";
            String type = map.get("type") + "";
            String age = map.get("age") + "";
            String address = map.get("address") + "";
            String is_verified = map.get("is_verified") + "";
            String username2 = map.get("username") + "";
            Preferences.set("id", id);
            Preferences.set("name", first_name + " " + last_name);
            Preferences.set("first_name", first_name);
            Preferences.set("last_name", last_name);
            Preferences.set("phone", phone);
            Preferences.set("type", type);
            Preferences.set("age", age);
            Preferences.set("address", address);
            Preferences.set("is_verified", is_verified);
            Preferences.set("username", username2);
        } else {
            new login_form(res).show();
        }
    }

    public void storeGym(Resources res) {
        String username = Preferences.get("username", "null");
        String password = Preferences.get("password", "null");
        if (!username.equals("null") && !password.equals("null")) {
            String push_token = getPushToken();
//            new erorr_msg(res, "Push Message", "push_token:" + push_token, "Ok", null).show();
            if (!push_token.equals("null") && !push_token.equals("")) {
                Rest.get(getURL() + "/api/gyms/push/" + username + "/" + password + "/" + push_token).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
            }
            Map<String, Object> currentListing = Rest.get(getURL() + "/api/cpanel/getgym/" + username + "/" + password).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
            java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
            Map<String, Object> map = content.get(0);
            String id = map.get("id") + "";
            String name = map.get("name") + "";
            String rate = map.get("rate") + "";
            String visits = map.get("visits") + "";
            String address = map.get("address") + "";
            String work_time = map.get("work_time") + "";
            String id_gym = map.get("id_gym") + "";
            String phone_gym = map.get("phone_gym") + "";
            String email_gym = map.get("email_gym") + "";
            String images = map.get("images") + "";
            String price_d = map.get("price_d") + "";
//            String price_d_fees = map.get("price_d_fees") + "";
            String price_w = map.get("price_w") + "";
//            String price_w_fees = map.get("price_w_fees") + "";
            String price_m = map.get("price_m") + "";
//            String price_m_fees = map.get("price_m_fees") + "";
            String description = map.get("description") + "";

            Preferences.set("id", StringUtil.replaceAll(id, ".0", ""));
            Preferences.set("name", name);
            Preferences.set("rate", rate);
            Preferences.set("visits", visits);
            Preferences.set("address", address);
            Preferences.set("work_time", work_time);
            Preferences.set("id_gym", id_gym);
            Preferences.set("phone_gym", phone_gym);
            Preferences.set("email_gym", email_gym);
            Preferences.set("images", images);
            Preferences.set("price_d", price_d);
            Preferences.set("price_w", price_w);
            Preferences.set("price_m", price_m);
            Preferences.set("description", description);
        } else {
            new login_form(res).show();
        }
    }

    public void updatePassword(Resources res, String username, String password) {
        String changePassword = Rest.get(getURL() + "/api/users/update/password/" + username + "/" + password).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        Preferences.set("username", username);
        Preferences.set("password", password);
        new Splash(res).show();
    }

//    public boolean sendCode(String email, String code) {
//        String Body = "{ \"emails\":\""+email+"\", \"title\":\"\", \"body\":\"Your email account verification code is:\n"+code+"\" }";
//        String request = Rest.post(getURL() + "/api/cpanel/sendemail").acceptJson().contentType("APPLICATION/JSON").body(Body).getAsString().getResponseData();
//        System.out.println("request: " + request);
//        return true;
//    }
    public String sendCode(String email, String code) {
        String request = Rest.get(getURL() + "/api/cpanel/users/forgetpass/" + email + "/" + code).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return request;
    }

    public String isUser(String username) {
        try {
            String request = Rest.get(getURL() + "/api/users/isuser/" + username).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
//            if (request.equals("true")) {
            return request;
//            }
        } catch (Exception e) {
            return "0";
        }
//        return false;
    }

    public void verifiedPhone(Resources res) {
        String username = Preferences.get("username", "null");
        String password = Preferences.get("password", "null");
        String changePassword = Rest.get(getURL() + "/api/users/update/isverified/" + username + "/" + password).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        new Splash(res).show();

    }

    public void updatePhone(Resources res, String phone) {
        String username = Preferences.get("username", "null");
        String password = Preferences.get("password", "null");
//        System.out.println("/api/users/update/phone/" + username + "/" + password + "/" + phone);
        String changePassword = Rest.get(getURL() + "/api/users/update/phone/" + username + "/" + password + "/" + phone).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        new user_info(res, new list_form(res)).show();

    }

    private Image[] imgs;
    private java.util.List<Map<String, Object>> content_imgs;

    public Image getFirstGymImg(Resources res, String gym_id) {
        Map<String, Object> currentListing = Rest.get(getURL() + "/api/cpanel/getgymimages/" + StringUtil.replaceAll(gym_id, ".0", "")).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
        content_imgs = (java.util.List<Map<String, Object>>) currentListing.get("root");
        int size = content_imgs.size();
        if (size != 0) {
            imgs = new Image[content_imgs.size()];
            imgs[0] = getFetchImage(res, content_imgs.get(0).get("url") + "");
            return imgs[0];
        } else {
//            imgs = new Image[0];
//            return res.getImage("Placeholder-1.jpg");
            return null;
        }

    }

    public Image[] getGymImages(Resources res, String gym_id) {

        for (int iter = 1; iter < imgs.length; iter++) {
            imgs[iter] = getImage(res, content_imgs.get(iter).get("url") + "");
            System.out.println(content_imgs.get(iter).get("url"));
            Util.sleep(10);
        }
        return imgs;

    }

    public String[] getGymImagesUrl(Resources res, String gym_id) {
        Map<String, Object> currentListing = Rest.get(getURL() + "/api/cpanel/getgymimages/" + StringUtil.replaceAll(gym_id, ".0", "")).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
        java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
        String[] urls = new String[content.size()];
        for (int iter = 0; iter < content.size(); iter++) {
            urls[iter] = content.get(iter).get("url") + "";
            System.out.println(content.get(iter).get("url"));
        }
        return urls;

    }

    public Image getImage(Resources res, String url) {
        String name = System.currentTimeMillis() + ".png";
        EncodedImage placeholder = (EncodedImage) res.getImage("Placeholder-1.jpg");
        URLImage background = URLImage.createToStorage(placeholder, name, url);
//        background.addActionListener(e -> CN.getCurrentForm().revalidate());
//        Util.sleep(10);
        background.fetch();
        return background;
    }

    public Image getFetchImage(Resources res, String url) {
        String name = System.currentTimeMillis() + ".png";
        EncodedImage placeholder = (EncodedImage) res.getImage("Placeholder-1.jpg");
        URLImage background = URLImage.createToStorage(placeholder, name, url, URLImage.RESIZE_SCALE);
        background.addActionListener(e -> CN.getCurrentForm().revalidate());
        return background;
    }

    public String getGymID(String username) {
        String id = Rest.get(getURL() + "/api/gyms/getgymid/" + username).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return id;
    }

    public String encryptID(String id_order) {
        String id = Rest.get(getURL() + "/api/cpanel/encrypt/" + id_order).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return id;
    }

    public boolean checkUpdate() {
        String appVersion = Display.getInstance().getProperty("AppVersion", "1.0");
        System.out.println("appVersion:" + appVersion);
        String isNeedUpdate = Rest.get(getURL() + "/api/cpanel/checkversion/app_android/" + StringUtil.replaceFirst(appVersion, ".", ",")).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        System.out.println("isNeedUpdate:" + isNeedUpdate);
        return Boolean.valueOf(isNeedUpdate);
    }
    String countries[] = {"Amman", "Zarqa", "Irbid", "Jerash", "Madaba", "Ajloun", "Balqa", "Mafraq", "Ma'an", "Karak", "Tafilah", "Aqaba"};
    String coords[] = {"31.9528763,35.9281701", "32.0660325,36.0950177", "32.5559885,35.8521737", "32.2769965,35.8966687", "31.7185315,35.7953107", "32.3341725,35.7543317", "32.0350154,35.7334344", "32.3394005,36.2055647", "30.1975476,35.7336727", "31.1817516,35.7063867", "30.8336956,35.6182677", "29.5324496,35.0082737"};

    private void putLocations() {
        for (int i = 0; i < countries.length; i++) {
            Preferences.set(countries[i], coords[i]);
        }

    }

    public String checkRatingOrder() {
        String checkrating = Rest.get(getURL() + "/api/users/checkrating/" + Preferences.get("username", "")).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return checkrating;
    }

    public void changeRating(String id_order) {
        String checkrating = Rest.get(getURL() + "/api/users/changerating/" + id_order).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();

    }

    public void rateGym(String id_order, int progress) {
        Rest.get(getURL() + "/api/gym/rategym/" + id_order + "/" + progress).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
    }

    public String getGymName(String id_order) {
        String gymName = Rest.get(getURL() + "/api/gym/namegym/" + id_order).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return gymName;
    }

//    public String isBlocked(String username)
    public Map<String, Object> createPaymentSession() {
        try {
            Map<String, Object> list = Rest.get(getURL() + "/api/payment/createsession").acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
            return list;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean checkHaveOrder(String date) {
        String checkHaveOrder = Rest.get(getURL() + "/api/users/checkdateorder/" + Preferences.get("id", "0") + "/" + date).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        System.out.println("checkHaveOrder:" + checkHaveOrder);
        return Boolean.valueOf(checkHaveOrder);
    }

    private String getPushToken() {
        if (d.getProperty("OS", "").equalsIgnoreCase("android")) {
            return Preferences.get("pushtoken", "null");

        } else if (d.getProperty("OS", "").equalsIgnoreCase("ios")) {
            nativeCodes n = NativeLookup.create(nativeCodes.class
            );
            if (n != null && n.isSupported()) {
                return n.getIosFcmToken();
            }
        }
        return "null";
    }

    public void updateLanguage(Resources res, String language) {
        String username = Preferences.get("username", "null");
        String id = Preferences.get("id", "null");
        String Body = "{\"id\":\"" + id + "\",\"language\":\"" + language + "\"}";
        if (!username.endsWith("_yalla")) {
            Rest.post(getURL() + "/api/users/update/settings").acceptJson().contentType("APPLICATION/JSON").body(Body).getAsString().getResponseData();
        } else {
            Rest.post(getURL() + "/api/gyms/update/settings").acceptJson().contentType("APPLICATION/JSON").body(Body).getAsString().getResponseData();
        }
    }
}
