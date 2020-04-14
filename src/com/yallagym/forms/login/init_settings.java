package com.yallagym.forms.login;

import com.codename1.io.Preferences;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.yallagym.BaseForm;
import com.yallagym.forms.login.forms.BaseLogin;
import java.util.Hashtable;

public class init_settings extends BaseLogin {

    public init_settings() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public init_settings(com.codename1.ui.util.Resources res) {
        checkLanguage(res);
        sethideToolbar();
        gui_logo.setPreferredH(gui_logo.getPreferredW());
        gui_btn_start.addActionListener(e -> {
            String name_lng = gui_C_BOX_Language.getSelectedItem().toString();
            switch (name_lng) {
                case "Arabic":
                    Preferences.set("bundle_language", "ar");
                    Hashtable bundle = res.getL10N("Languages", "ar");
                    BaseForm.enableArabic(true);
                    UIManager.getInstance().setBundle(bundle);
                    break;
                case "English":
                    Preferences.set("bundle_language", "en");
                    break;
                default:
                    Preferences.set("bundle_language", "en");
                    break;
            }
            Preferences.set("is_select_language", true);
            new WalkthruForm(res).show();
        });
    }

//////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_bg_img = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_bg_img_gray = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_logo = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.ComboBox gui_C_BOX_Language = new com.codename1.ui.ComboBox("English","Arabic");
    protected com.codename1.ui.Button gui_btn_start = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("init_settings");
        setName("init_settings");
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
        gui_Container_1.setPreferredSizeStr("54.497356mm 57.142857mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_logo);
        gui_Container.addComponent(gui_Container_1);
        gui_C_BOX_Language.setPreferredSizeStr("48.9418mm 10.31746mm");
                gui_C_BOX_Language.setInlineStylesTheme(resourceObjectInstance);
        gui_C_BOX_Language.setName("C_BOX_Language");
        gui_btn_start.setPreferredSizeStr("35.714287mm 9.523809mm");
        gui_btn_start.setText("Lets Start");
        gui_btn_start.setUIID("btn_get_yellow");
                gui_btn_start.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_start.setName("btn_start");
        gui_Label.setPreferredSizeStr("75.92593mm inherit");
        gui_Label.setText("Please Select Language");
        gui_Label.setUIID("lbl_white");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("69.57672mm inherit");
        gui_Label_1.setText("\u0627\u0644\u0631\u062C\u0627\u0621 \u0627\u062E\u062A\u064A\u0627\u0631 \u0644\u063A\u062A\u0643");
        gui_Label_1.setUIID("lbl_white");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Container_1.addComponent(gui_C_BOX_Language);
        gui_Container_1.addComponent(gui_btn_start);
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_Label_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_C_BOX_Language.getParent().getLayout()).setInsets(gui_C_BOX_Language, "4.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_C_BOX_Language, "3 -1 -1 -1").setReferencePositions(gui_C_BOX_Language, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_start.getParent().getLayout()).setInsets(gui_btn_start, "4.0mm auto auto auto").setReferenceComponents(gui_btn_start, "0 -1 -1 -1").setReferencePositions(gui_btn_start, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "3.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "1.5mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_1, "2 -1 -1 -1").setReferencePositions(gui_Label_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_logo.getParent().getLayout()).setInsets(gui_logo, "10.0% auto auto auto").setReferenceComponents(gui_logo, "-1 -1 -1 -1").setReferencePositions(gui_logo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)54.497356);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)57.142857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm auto auto auto").setReferenceComponents(gui_Container_1, "0 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)104.49735);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)123.809525);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.26455027mm auto 0.26455027mm auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    private void checkLanguage(Resources res) {
        if (com.yallagym.BaseForm.isArabic()) {
            initArGuiBuilderComponents(res);
            setRTLCmb(res);
        } else {
            initGuiBuilderComponents(res);
        }
    }

    private void initArGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
    }

    private void setRTLCmb(Resources res) {
    }
}
