package com.yallagym.club;

import com.codename1.io.Preferences;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import java.io.InputStream;

import java.util.List;
import java.util.Map;

public class club_images_controller {

    public static Image[] profile_info_images;

//    public static String[] getAlImages() {
//        return new String[]{image1, image2, image3, image4};
//    }
//    public static void setGymImages(List<Map<String, Object>> content) {
//
//        images_content_urls = content;
//    }
    public String[] getGymImages(List<Map<String, Object>> content) {
        String name1 = System.currentTimeMillis() + 1 + ".png";
        String name2 = System.currentTimeMillis() + 2 + ".png";
        String name3 = System.currentTimeMillis() + 3 + ".png";
        String name4 = System.currentTimeMillis() + 4 + ".png";
        String[] names = {name1, name2, name3, name4};
        String[] imgs_paths = new String[content.size()];
        for (int i = 0; i < content.size(); i++) {
            downloadImageToStorage(content.get(i).get("url") + "", names[i]);
            imgs_paths[i] = names[i];
            Preferences.set("profile_img_" + i, names[i]);
            System.out.println(i + " : " + names[i]);
        }
        return imgs_paths;
    }

    private String downloadImageToStorage(String url, String name) {
        Util.downloadUrlToStorageInBackground(url, name, (evt) -> {
            System.out.println("done download");
        });

//        System.out.println("exists:" + Storage.getInstance().exists("1580156009292.png"));
        return "";
    }

//    public static Image[] getProfile_info_images() {
//        int images_count = Preferences.get("images_count", 0);
//        profile_info_images = new Image[images_count];
//        System.out.println("images_count: " + images_count);
//        for (int i = 0; i < images_count; i++) {
//            try {
//                String nameImg = Preferences.get("profile_img_" + i, "");
//                System.out.println("get :" + nameImg);
//                System.out.println("Storage.getInstance() exist file: " + Storage.getInstance().exists(nameImg));
//                InputStream is = Storage.getInstance().createInputStream(nameImg);
//                System.out.println(is.read());
////                if (is != null) {
//                profile_info_images[i] =EncodedImage.create(is, is.available());
// 
//                System.out.println(profile_info_images[i]);
////                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return profile_info_images;
//    }
}
