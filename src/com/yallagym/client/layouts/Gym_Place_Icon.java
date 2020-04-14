package com.yallagym.client.layouts;

import com.cn2.ui.cn1Font;
import com.cn2.ui.cn1Icons;
import static com.codename1.ui.CN.getCurrentForm;
import com.codename1.ui.util.Resources;
import com.yallagym.client.forms.details_form;

public class Gym_Place_Icon extends com.codename1.ui.Container {

    public Gym_Place_Icon() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public Gym_Place_Icon(com.codename1.ui.util.Resources res) {
        initGuiBuilderComponents(res);
        gui_lbl_icon.getAllStyles().setBgImage(res.getImage("green_place.png"));
        gui_lbl_icon.setPreferredH(gui_lbl_icon.getPreferredW());

    }
//"green_place.png" "yellow_place.png"

    public Gym_Place_Icon(com.codename1.ui.util.Resources res, String id_gym, String type, String price) {
           initGuiBuilderComponents(res);
        gui_lbl_icon.getAllStyles().setBgImage(res.getImage("green_place.png"));
        gui_lbl_icon.setPreferredH(gui_lbl_icon.getPreferredW());
        gui_lbl_txt.setText(price);
        gui_id_gym.setText(id_gym);
        gui_btn_select.addActionListener(e -> {
            new details_form(res, getCurrentForm(), id_gym, type).show();
        });
    }
//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_select = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_icon = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_txt = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_id_gym = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("Gym_Place_Icon");
        gui_Container.setPreferredSizeStr("11.111112mm 10.8465605mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_btn_select.setPreferredSizeStr("27.777779mm 19.31217mm");
        gui_btn_select.setUIID("transperent");
                gui_btn_select.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select.setName("btn_select");
        gui_lbl_icon.setPreferredSizeStr("23.015873mm 23.280424mm");
                gui_lbl_icon.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_icon.setInlineAllStyles("bgImage:green_place.png;");
        gui_lbl_icon.setName("lbl_icon");
        gui_lbl_txt.setPreferredSizeStr("12.433863mm 7.4074073mm");
        gui_lbl_txt.setText("JOD 10");
        gui_lbl_txt.setUIID("Correct_Msg_Sb_Txt");
                gui_lbl_txt.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_txt.setInlineAllStyles("fgColor:f7ed23; opacity:255;");
        gui_lbl_txt.setName("lbl_txt");
                gui_id_gym.setInlineStylesTheme(resourceObjectInstance);
        gui_id_gym.setName("id_gym");
        gui_Container.addComponent(gui_btn_select);
        gui_Container.addComponent(gui_lbl_icon);
        gui_Container.addComponent(gui_lbl_txt);
        gui_Container.addComponent(gui_id_gym);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select.getParent().getLayout()).setInsets(gui_btn_select, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select, "-1 -1 -1 -1").setReferencePositions(gui_btn_select, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_icon.getParent().getLayout()).setInsets(gui_lbl_icon, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_icon, "-1 -1 -1 -1").setReferencePositions(gui_lbl_icon, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_txt.getParent().getLayout()).setInsets(gui_lbl_txt, "10.0% auto auto auto").setReferenceComponents(gui_lbl_txt, "-1 -1 -1 -1").setReferencePositions(gui_lbl_txt, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_id_gym.getParent().getLayout()).setInsets(gui_id_gym, "50.0% 50.0% 50.0% 50.0%").setReferenceComponents(gui_id_gym, "-1 -1 -1 -1").setReferencePositions(gui_id_gym, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)11.111112);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)10.8465605);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto auto auto auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
