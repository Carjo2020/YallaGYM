package com.yallagym.client.forms;

import com.codename1.io.Preferences;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import java.util.Hashtable;

public class Settings extends BaseForm {

    public Settings() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public Settings(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }
    APIs api = new APIs();

    public Settings(com.codename1.ui.util.Resources res, Form frm) {
        initGuiBuilderComponents(res);
        installBackIcon(frm);
        getToolbar().setTitleCentered(true);
        setRTLAr(res);
        gui_Label.setPreferredH(gui_Label.getPreferredH() + 16);
        installCheckIcon(e -> {
            String name_lng = gui_C_BOX_Language.getSelectedItem().toString();
            switch (name_lng) {
                case "Arabic":
                    api.updateLanguage(res, "ar");
                    Preferences.set("bundle_language", "ar");
                    Preferences.set("is_select_language", true);
                    Hashtable bundle = res.getL10N("Languages", "ar");
                    UIManager.getInstance().setBundle(bundle);
                    BaseForm.enableArabic(true);
                    new Splash(res).show();

                    break;
                case "English":
                    api.updateLanguage(res, "en");
                    Preferences.set("bundle_language", "en");
                    Preferences.set("is_select_language", true);
                    Hashtable bundle2 = res.getL10N("Languages", "Key");
                    UIManager.getInstance().setBundle(bundle2);
                    BaseForm.enableArabic(false);
                    new Splash(res).show();
                    break;
            }

        });
    }
////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.ComboBox gui_C_BOX_Language = new com.codename1.ui.ComboBox("English","Arabic");


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Settings");
        setName("Settings");
        gui_Container.setPreferredSizeStr("104.49735mm 44.179893mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("85.978836mm 112.69841mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_Container_1);
        gui_Label.setText("Language");
        gui_Label.setUIID("PersonalInfo_Lbl_AR");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_C_BOX_Language.setPreferredSizeStr("48.9418mm 10.31746mm");
                gui_C_BOX_Language.setInlineStylesTheme(resourceObjectInstance);
        gui_C_BOX_Language.setName("C_BOX_Language");
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_C_BOX_Language);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 5.0% 0.0mm 5.0%").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)91.269844);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)44.179893);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "4.0mm auto auto auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    private void setRTLAr(Resources res) {
        if (isArabic()) {

            gui_Label.setRTL(true);
//            gui_C_BOX_Language.setRTL(true);
        }
    }
}
