package com.yallagym.client.dialogs;

import com.cn2.lang.cn1Math;
import static com.cn2.ui.cn1Slider.initStarRankStyle;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Image;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.yallagym.APIs;

public class rating_user_to_gym extends com.codename1.ui.Dialog {

    Resources res;

    public rating_user_to_gym() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public rating_user_to_gym(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

    }
    APIs api = new APIs();

    public rating_user_to_gym(com.codename1.ui.util.Resources res, String id_order) {
        initGuiBuilderComponents(res);
        this.res = res;
        this.setScrollable(false);
        this.setScrollVisible(false);
        this.setDialogUIID("transperent");
        this.setTitle("");
        this.setDisposeWhenPointerOutOfBounds(false);
        this.setMinimizeOnBack(true);
        this.setBlurBackgroundRadius(15);
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
            }
        };
        this.setBackCommand(back);
        gui_Label.setPreferredW(gui_Label.getPreferredH());
        String name_gym = api.getGymName(id_order);
        if (!com.yallagym.BaseForm.isArabic()) {
            gui_sb_msg.setText("How Would You \n" + name_gym + " Gym?");
        } else {
            gui_sb_msg.setText("اكم تقيم هذا النادي؟ \n" + name_gym);
        }

        Slider starRank = createStarRankSlider(4, 5);
        gui_con_stars.add(FlowLayout.encloseCenter(starRank));

        gui_btn_submit.addActionListener(e -> {
            api.changeRating(id_order);
            api.rateGym(id_order, starRank.getProgress() / 2);
            dispose();
        });
        gui_btn_skip.addActionListener(e -> {
            api.changeRating(id_order);
            dispose();
        });
    }
//////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_submit = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_skip = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_con_stars = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.components.SpanLabel gui_sb_msg = new com.codename1.components.SpanLabel();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("rating_user_to_gym");
        setName("rating_user_to_gym");
        gui_Container.setPreferredSizeStr("67.19577mm 67.46032mm");
        gui_Container.setUIID("Dialog_ContantPane");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_btn_submit.setPreferredSizeStr("inherit 6.878307mm");
        gui_btn_submit.setText("Submit");
        gui_btn_submit.setUIID("btn_get_yellow");
                gui_btn_submit.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_submit.setName("btn_submit");
        gui_btn_skip.setPreferredSizeStr("26.190475mm 5.820106mm");
        gui_btn_skip.setText("Skip");
        gui_btn_skip.setUIID("btn_get_red");
                gui_btn_skip.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_skip.setName("btn_skip");
        gui_Label.setPreferredSizeStr("10.31746mm 10.58201mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:greet.png;");
        gui_Label.setName("Label");
        gui_con_stars.setPreferredSizeStr("59.25926mm 8.730159mm");
                gui_con_stars.setInlineStylesTheme(resourceObjectInstance);
        gui_con_stars.setName("con_stars");
        gui_sb_msg.setPreferredSizeStr("67.19577mm 22.486773mm");
        gui_sb_msg.setScrollVisible(true);
        gui_sb_msg.setUIID("club_dlg_done_sb_green");
                gui_sb_msg.setInlineStylesTheme(resourceObjectInstance);
        gui_sb_msg.setName("sb_msg");
        gui_sb_msg.setPropertyValue("textUiid", "club_dlg_done_sb_green");
        gui_Container.addComponent(gui_btn_submit);
        gui_Container.addComponent(gui_btn_skip);
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_con_stars);
        gui_Container.addComponent(gui_sb_msg);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_submit.getParent().getLayout()).setInsets(gui_btn_submit, "2.0mm 10.0% auto 55.0%").setReferenceComponents(gui_btn_submit, "3 -1 -1 -1").setReferencePositions(gui_btn_submit, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_skip.getParent().getLayout()).setInsets(gui_btn_skip, "2.4645505mm 55.0% auto 10.0%").setReferenceComponents(gui_btn_skip, "3 -1 -1 -1").setReferencePositions(gui_btn_skip, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "3.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getLayout()).setPreferredWidthMM((float)59.25926);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getLayout()).setPreferredHeightMM((float)8.730159);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getParent().getLayout()).setInsets(gui_con_stars, "1.0mm 0.0mm auto -4.7683716E-7mm").setReferenceComponents(gui_con_stars, "4 -1 -1 -1").setReferencePositions(gui_con_stars, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_sb_msg.getParent().getLayout()).setInsets(gui_sb_msg, "1.5mm 0.0mm auto 0.0mm").setReferenceComponents(gui_sb_msg, "2 -1 -1 -1").setReferencePositions(gui_sb_msg, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)68.51852);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)67.46032);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public Slider createStarRankSlider(double value, int iconSize) {
        int progress = cn1Math.nextDown(value / 0.5);
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(2);
        starRank.setMaxValue(12);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(iconSize, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
//        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
//  Image fullStar=res.getImage("");
        Image fullStar = res.getImage("gold.png").scaled(96, 96);
        Image emptyStar = res.getImage("filled.png").scaled(96, 96);
        s.setOpacity(100);
        s.setFgColor(0);
//        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);

        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
//        starRank.setEditable(false);
        starRank.setProgress(progress);
        return starRank;
    }

}
