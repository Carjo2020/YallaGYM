package com.yallagym.club.forms;

import com.cn2.util.cn1String;
import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.Preferences;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.io.rest.Rest;
import com.codename1.ui.CN;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class club_APIs {

    Display d = Display.getInstance();
//    String URL = "http://localhost:8080";
    String URL = "https://yallagym.herokuapp.com";

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

    boolean saveImgs(String bytes) {
        String Body = "{ \"id_gym\":\"3\", \"bytes\":\"" + bytes + "\" }";
        Rest.get(getURL() + "/api/cpanel/uploadimage1").acceptJson().contentType("APPLICATION/JSON").body(Body).getAsString().getResponseData();

        return true;
    }
    String id = "0";

    String uploadImg(String filePath) {
        System.err.println("id Gym: " + getGymId());
        try {
            MultipartRequest cr = new MultipartRequest() {
                public void readResponse(InputStream input) throws IOException {
                    String respone = Util.readToString(input);
                    String[] splite_respone = cn1String.splite(respone, ":");
                    id = splite_respone[1];
                    System.err.println("id image uploaded:  " + id);
                }

            };
            String mime = ((filePath.substring(filePath.lastIndexOf(".") + 1, filePath.lastIndexOf(".") + 4).toLowerCase().equals("jpg")) ? "image/jpg" : "image/png");
            String name = (filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length()));
            cr.setUrl(getURL() + "/api/gyms/uploadimg/" + getGymId());
            cr.setPost(true);
            cr.addData("file", filePath, mime);
            cr.setFilename("file", name);
            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInfiniteBlocking();
            cr.setDisposeOnCompletion(dlg);
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return id;
        }
        return id;
    }

    public java.util.List<Map<String, Object>> getGymImages() {
        Map<String, Object> currentListing = Rest.get(getURL() + "/api/cpanel/getgymimages/" + getGymId()).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
        java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
        Preferences.set("images_count", content.size());
        deleteOldImages();
        return content;
    }

    public String getGymId() {
        return StringUtil.replaceAll(Preferences.get("id", "null"), ".0", "");
    }

    public Image getImage(Resources res, String url) {
//        String name = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("?"));
        String name = System.currentTimeMillis() + ".png";
        EncodedImage placeholder = (EncodedImage) res.getImage("Placeholder-1.jpg");
        URLImage background = URLImage.createToStorage(placeholder, name, url);
        background.fetch();
        return background;
    }

    public void delete(String id) {
        Rest.get(getURL() + "/api/cpanel/deletegymimage/" + getGymId() + "/" + id).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
    }

    public String updateImg(String filePath, String res_id) {
        try {
            MultipartRequest cr = new MultipartRequest() {
                protected void readResponse(InputStream input) throws IOException {
                    String respone = com.codename1.io.Util.readToString(input);

                }
            };
            String mime = ((filePath.substring(filePath.lastIndexOf(".") + 1, filePath.lastIndexOf(".") + 4).toLowerCase().equals("jpg")) ? "image/jpg" : "image/png");
            String name = (filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length()));
            cr.setUrl(getURL() + "/api/gyms/updateimg/" + res_id);
            cr.setPost(true);
            cr.addData("file", filePath, mime);
            cr.setFilename("file", name);
            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInfiniteBlocking();
            cr.setDisposeOnCompletion(dlg);
            NetworkManager.getInstance().addToQueueAndWait(cr);

        } catch (Exception e) {
            return "null";
        }
        return "null";
    }

    public String getGymImg(String res_id) {
        return Rest.get(getURL() + "/api/cpanel/getgymimg/" + res_id).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
    }

    public Image[] getImages(Resources res, List<Map<String, Object>> content) {
        Image[] imgs = new Image[content.size()];
        for (int iter = 0; iter < imgs.length; iter++) {
            imgs[iter] = getImage(res, content.get(iter).get("url") + "");
            System.out.println(content.get(iter).get("url"));
            Util.sleep(10);
        }
        return imgs;

    }

    public Map<String, Object> getGymInfo() {
        Map<String, Object> currentListing = Rest.get(getURL() + "/api/cpanel/getgym/" + getGymId()).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
        java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
        return content.get(0);
    }

    void updateGymInfo(String dec, String place, String phone, String time_from, String time_to, String price_d, String price_w, String price_m) {
//        System.out.println("dec:" + dec);
//        System.out.println("place:" + place);
//        System.out.println("phone:" + phone);
//        System.out.println("time_from:" + time_from);
//        System.out.println("time_to:" + time_to);
//        System.out.println("price_d:" + price_d);
//        System.out.println("price_w:" + price_w);
//        System.out.println("price_m:" + price_m);
        String body = cn1String.format("{\"id\": \"?\",\"address\": \"?\", \"work_time\": \"?\", \"phone_gym\": \"?\", \"price_d\": \"?\",  \"price_w\": \"?\", \"price_m\": \"?\", \"description\": \"?\" }",
                getGymId(),
                place,
                time_from + "-" + time_to,
                phone,
                price_d,
                price_w,
                price_m,
                dec
        );
        System.out.println(body);
        Rest.post(getURL() + "/api/cpanel/updategym").acceptJson().contentType("APPLICATION/JSON").body(body).getAsString().getResponseData();

    }

    public Map<String, Object> getGymOrders() {
        Map<String, Object> currentListing = Rest.get(getURL() + "/api/cpanel/getgymorders/" + getGymId()).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
        return currentListing;
    }

    public void changeStatus(String id_order, String status) {
        id_order = StringUtil.replaceFirst(id_order, ".0", "");
        System.out.println("/api/cpanel/changestatus/" + id_order + "/" + status);
        Rest.get(getURL() + "/api/cpanel/changestatus/" + id_order + "/" + status).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
    }

    Image[] getFetchesImages(Resources res, List<Map<String, Object>> content) {
        Image[] imgs = new Image[content.size()];
        for (int iter = 0; iter < imgs.length; iter++) {
            imgs[iter] = getImage(res, content.get(iter).get("url") + "");
            System.out.println(content.get(iter).get("url"));
            Util.sleep(100);
        }
        return imgs;
    }

    String decryptID(String contents) {
        String id = Rest.get(getURL() + "/api/cpanel/decrypt/" + contents).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
        return id;
    }

    String isOrderForGym(String id_order) {
        return Rest.get(getURL() + "/api/gym/getstatusorder/" + id_order + "/" + getGymId()).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
    }

    public Map<String, Object> getGymOrder(String id_order) {
        Map<String, Object> currentListing = Rest.get(getURL() + "/api/cpanel/getgymorder/" + id_order).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
        return currentListing;
    }

    public Map<String, Object> getOrder(String id_order) {
        Map<String, Object> currentListing = Rest.get(getURL() + "/api/orders/" + id_order).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
        java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) currentListing.get("root");
        return content.get(0);
    }
//    String getStatusOrder(String id_order) {
//        return Rest.get(getURL() + "/api/gym/getstatusorder/" + id_order + "/" + getGymId()).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
//    }

    public Map<String, Object> getGymPayments() {
        Map<String, Object> currentListing = Rest.get(getURL() + "/api/gym/getallpayments/" + getGymId()).acceptJson().contentType("APPLICATION/JSON").getAsJsonMap().getResponseData();
        return currentListing;
    }

    private void deleteOldImages() {
        Storage storage = Storage.getInstance();
//        for (int i = 0; i < 4; i++) {
//            String img1 = Preferences.get("profile_img_" + i, "");
//            storage.deleteStorageFile(img1);
//            System.out.println("_______________ delete " + img1);
//        }
        storage.clearCache();
        storage.clearStorage();
    }

    public void rateUser(String id_order, int progress) {
        Rest.get(getURL() + "/api/users/rateuser/" + id_order + "/" + progress).acceptJson().contentType("APPLICATION/JSON").getAsString().getResponseData();
    }

}
