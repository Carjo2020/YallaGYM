package com.yallagym.club.layouts;

import com.cn2.ui.cn1Display;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import static com.codename1.ui.CN.getCurrentForm;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.yallagym.club.club_images_controller;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;

public class profile_img extends com.codename1.ui.Container {

//    static Image img;
    club_APIs api = new club_APIs();
//    static String filePath;

    public profile_img() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public profile_img(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }
    Image img_change;

    public profile_img(com.codename1.ui.util.Resources res, String id, /*String Url,*/ Image imge, int width, int height) {
//        System.out.println("Url:" + Url);
        initGuiBuilderComponents(res);
//        this.img = api.getImage(res, Url);
//        this.filePath = filePath;
        gui_lbl_img_path.setText(id);
//        gui_con_img.getAllStyles().setBgImage(api.getImage(res, Url));
        gui_con_img.getAllStyles().setBgImage(imge);
        gui_con_img.setPreferredW(width);
        gui_con_img.setPreferredH(height);
//        gui_btn_delete.setIcon(new cn1Icons().getImage("delete", "club_profile_img_delete", 4));
//        gui_btn_change.setIcon(new cn1Icons().getImage("camera", "club_profile_img_camera", 4));
//"camera_gradient_ic.png" "delete_ic.png"
        Image delete_ic = res.getImage("delete_ic.png").scaled(56, 56);
        Image camera_ic = res.getImage("camera_gradient_ic.png").scaled(56, 56);
        gui_btn_delete.setIcon(delete_ic);
        gui_btn_delete.setPressedIcon(delete_ic);
        gui_btn_delete.getAllStyles().setAlignment(CENTER);
        gui_btn_change.setIcon(camera_ic);
        gui_btn_change.setPressedIcon(camera_ic);
        gui_btn_change.getAllStyles().setAlignment(CENTER);
        gui_btn_change.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        String filePath = (String) ev.getSource();
                        int fileNameIndex = filePath.lastIndexOf("/") + 1;
                        String fileName = filePath.substring(fileNameIndex);
                        System.out.println("fileName:" + fileName);
                        try {
                            EncodedImage placeholder = (EncodedImage) res.getImage("Placeholder-1.jpg");
//                            img = placeholder;
                            gui_con_img.getAllStyles().setBgImage(placeholder);
//                            if (!img.equals(null)) {
                            api.updateImg(filePath, gui_lbl_img_path.getText());
                            CN.callSerially(() -> {
                                club_BaseForm.gym_url = api.getGymImages();
                                new club_images_controller().getGymImages(club_BaseForm.gym_url);
                            });

//                            String url = api.getGymImg(id);
//                            api.getImage(res, url);
                            img_change = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
                            gui_con_img.getAllStyles().setBgImage(img_change);
                            revalidate();
//                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }, Display.GALLERY_IMAGE);
        });
        gui_btn_delete.addActionListener(e -> {
            System.out.println("delete: " + id);
            api.delete(id);
            delete();
            CN.callSerially(() -> {
                club_BaseForm.gym_url = api.getGymImages();
                new club_images_controller().getGymImages(club_BaseForm.gym_url);
//                club_BaseForm.profile_info_images = api.getImages(res, club_BaseForm.gym_url);

            });
        });
    }
//////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_con_img = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_change = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_delete = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_img_path = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("profile_img");
        gui_con_img.setPreferredSizeStr("48.67725mm 33.333332mm");
                gui_con_img.setInlineStylesTheme(resourceObjectInstance);
        gui_con_img.setName("con_img");
        addComponent(gui_con_img);
        gui_Container.setPreferredSizeStr("34.391533mm 11.904762mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_lbl_img_path.setPreferredSizeStr("inherit 7.4074073mm");
                gui_lbl_img_path.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_img_path.setName("lbl_img_path");
        gui_con_img.addComponent(gui_Container);
        gui_btn_change.setPreferredSizeStr("19.31217mm 8.994709mm");
        gui_btn_change.setUIID("club_profile_img_camera");
                gui_btn_change.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_change.setName("btn_change");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_change,"\ue3b0".charAt(0));
        gui_Label.setPreferredSizeStr("15.608466mm 5.555556mm");
        gui_Label.setText("change");
        gui_Label.setUIID("club_profile_img_camera");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("alignment:center;");
        gui_Label.setName("Label");
        gui_btn_delete.setPreferredSizeStr("17.989418mm inherit");
        gui_btn_delete.setUIID("club_profile_img_delete");
                gui_btn_delete.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_delete.setName("btn_delete");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_delete,"\ue872".charAt(0));
        gui_Label_1.setPreferredSizeStr("19.047619mm 5.291005mm");
        gui_Label_1.setText("delete");
        gui_Label_1.setUIID("club_profile_img_delete");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("alignment:center;");
        gui_Label_1.setName("Label_1");
        gui_Container.addComponent(gui_btn_change);
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_btn_delete);
        gui_Container.addComponent(gui_Label_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_change.getParent().getLayout()).setInsets(gui_btn_change, "0.0mm 50.0% 3.968254mm 0.0mm").setReferenceComponents(gui_btn_change, "-1 -1 -1 -1").setReferencePositions(gui_btn_change, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 50.0% 0.0mm 9.536743E-7mm").setReferenceComponents(gui_Label, "0 -1 -1 -1").setReferencePositions(gui_Label, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_delete.getParent().getLayout()).setInsets(gui_btn_delete, "0.0mm 0.0mm 3.968254mm 0.0mm").setReferenceComponents(gui_btn_delete, "-1 -1 -1 0 ").setReferencePositions(gui_btn_delete, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "1.1920929E-7mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Label_1, "2 -1 -1 1 ").setReferencePositions(gui_Label_1, "1.0 0.0 0.0 1.0");
        gui_con_img.addComponent(gui_lbl_img_path);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)34.391533);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)11.904762);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto auto auto auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_img_path.getParent().getLayout()).setInsets(gui_lbl_img_path, "50.0% 50.0% 50.0% 50.0%").setReferenceComponents(gui_lbl_img_path, "-1 -1 -1 -1").setReferencePositions(gui_lbl_img_path, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_img.getLayout()).setPreferredWidthMM((float)48.67725);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_img.getLayout()).setPreferredHeightMM((float)33.333332);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_img.getParent().getLayout()).setInsets(gui_con_img, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_con_img, "-1 -1 -1 -1").setReferencePositions(gui_con_img, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!'T EDIT ABOVE THIS LINE!!!   
//    public static Image getImage() {
//        return img;
//    }
    private void delete() {
        this.remove();
        Container con = (Container) ((Container) getCurrentForm().getContentPane().getComponentAt(0)).getComponentAt(0);
        int width = cn1Display.getWidth();
        int highet = con.getPreferredH();
        int count_imgs = con.getComponentCount();
        switch (count_imgs) {
            case 1:
                Button add_btn = (Button) con.getComponentAt(0);
                add_btn.setPreferredW(width);
                add_btn.setPreferredH(highet);
                break;

            case 2:
                profile_img con_profile = (profile_img) con.getComponentAt(0);
                Button add_btn2 = (Button) con.getComponentAt(1);
                con_profile.setPreferredW(width / 2);
                con_profile.setPreferredH(highet);
                add_btn2.setPreferredW(width / 2);
                add_btn2.setPreferredH(highet);

                break;
            case 3:
                Button add_btn3 = (Button) con.getComponentAt(2);
                add_btn3.setPreferredW(width);
                add_btn3.setPreferredH(highet / 2);
                break;
            case 4:
                Button add_btn4 = (Button) con.getComponentAt(3);
                add_btn4.setPreferredW(width / 2);
                add_btn4.setPreferredH(highet / 2);
                break;
        }
        getCurrentForm().revalidate();
    }

//    public static String getPath() {
//        return filePath;
//    }
//    public static void setPrefSize(int width,int highet){
//         gui_con_img.setPreferredW(width);
//        gui_con_img.setPreferredH(highet);
//    }
    public Image getImage() {
        return gui_con_img.getAllStyles().getBgImage();
    }

    public void setScaled(int width, int highet) {
        this.setPreferredW(width);
        this.setPreferredH(highet);
//        gui_con_img.getAllStyles().getBgImage().scaled(width, highet);
    }

}
