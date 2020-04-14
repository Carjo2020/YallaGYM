package com.yallagym.club.dialogs;

import com.cn2.lang.cn1Math;
import static com.cn2.ui.cn1Slider.initStarRankStyle;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Image;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;
import com.yallagym.club.forms.club_orders;
import com.yallagym.client.dialogs.erorr;
import java.util.Map;

public class club_qr_done extends club_BaseDialog {
    
    club_APIs api = new club_APIs();
    Resources res;
    
    public club_qr_done() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
    }
    
    public club_qr_done(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        
    }
    
    public club_qr_done(com.codename1.ui.util.Resources res, String msg, String price, int highet, String id_order) {
        initGuiBuilderComponents(res);
        this.res = res;
        installDialog(res);
        this.setScrollableY(true);
        this.setScrollVisible(false);
        gui_Label.setPreferredW(gui_Label.getPreferredH());
        gui_Sb_Msg.setText(msg);
        if (price != null) {
            gui_lbl_price_no.setText(price);
        } else {
            gui_lbl_price_no.setText("");
            gui_lbl_price_no.setPreferredH(4);
        }
        
        gui_Container.setPreferredH(highet);
        Slider starRank = createStarRankSlider(4.5, 5);
        gui_con_stars.add(FlowLayout.encloseCenter(starRank));
        gui_btn_submit.addActionListener(e -> {
            api.rateUser(id_order, starRank.getProgress() / 2);
            dispose();
        });
    }

//////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_done = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_close = new com.codename1.ui.Button();
    protected com.codename1.components.SpanLabel gui_Sb_Msg = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Container gui_con_stars = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_submit = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_price_no = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_close.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_btn_close) {
                onbtn_closeActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_qr_done");
        setName("club_qr_done");
        gui_Container.setPreferredSizeStr("inherit 93.915344mm");
        gui_Container.setUIID("club_qr_con_first_green");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("16.931217mm 15.873016mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:circle_correct_ic.png;");
        gui_Label.setName("Label");
        gui_lbl_done.setPreferredSizeStr("80.15873mm inherit");
        gui_lbl_done.setText("Done!");
                gui_lbl_done.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_done.setInlineAllStyles("font:6.0mm; fgColor:0; alignment:center;");
        gui_lbl_done.setName("lbl_done");
        gui_btn_close.setPreferredSizeStr("12.698413mm 8.994709mm");
        gui_btn_close.setText("X");
        gui_btn_close.setUIID("transperent");
                gui_btn_close.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_close.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:center;");
        gui_btn_close.setName("btn_close");
        gui_Sb_Msg.setPreferredSizeStr("83.597885mm 15.079365mm");
        gui_Sb_Msg.setText("has been increased to your account");
        gui_Sb_Msg.setUIID("SoftButtonCenter");
                gui_Sb_Msg.setInlineStylesTheme(resourceObjectInstance);
        gui_Sb_Msg.setName("Sb_Msg");
        gui_Sb_Msg.setPropertyValue("textUiid", "club_dlg_done_sb");
        gui_con_stars.setPreferredSizeStr("49.73545mm 7.6719575mm");
                gui_con_stars.setInlineStylesTheme(resourceObjectInstance);
        gui_con_stars.setName("con_stars");
        gui_btn_submit.setPreferredSizeStr("27.513227mm 7.6719575mm");
        gui_btn_submit.setText("Submit");
        gui_btn_submit.setUIID("btn_get_started");
                gui_btn_submit.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_submit.setName("btn_submit");
        gui_Label_1.setPreferredSizeStr("79.62963mm 8.201058mm");
        gui_Label_1.setText("Please rate this user");
        gui_Label_1.setUIID("PersonalInfo_Lbl");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:4.0mm; fgColor:0; bgImage:; alignment:center;");
        gui_Label_1.setName("Label_1");
        gui_lbl_price_no.setPreferredSizeStr("69.57672mm 6.0846562mm");
        gui_lbl_price_no.setText("35$");
        gui_lbl_price_no.setUIID("LabelSoftButtonCenter");
                gui_lbl_price_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price_no.setInlineAllStyles("alignment:center;");
        gui_lbl_price_no.setName("lbl_price_no");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_lbl_done);
        gui_Container.addComponent(gui_btn_close);
        gui_Container.addComponent(gui_Sb_Msg);
        gui_Container.addComponent(gui_con_stars);
        gui_Container.addComponent(gui_btn_submit);
        gui_Container.addComponent(gui_Label_1);
        gui_Container.addComponent(gui_lbl_price_no);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "10.0% auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_done.getParent().getLayout()).setInsets(gui_lbl_done, "4.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_done, "0 -1 -1 -1").setReferencePositions(gui_lbl_done, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_close.getParent().getLayout()).setInsets(gui_btn_close, "1.0mm 1.0mm auto auto").setReferenceComponents(gui_btn_close, "-1 -1 -1 -1").setReferencePositions(gui_btn_close, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Sb_Msg.getParent().getLayout()).setInsets(gui_Sb_Msg, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Sb_Msg, "1 -1 -1 -1").setReferencePositions(gui_Sb_Msg, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getLayout()).setPreferredWidthMM((float)49.73545);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getParent().getLayout()).setInsets(gui_con_stars, "0.0mm auto auto auto").setReferenceComponents(gui_con_stars, "6 -1 -1 -1").setReferencePositions(gui_con_stars, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_submit.getParent().getLayout()).setInsets(gui_btn_submit, "3.0mm auto auto auto").setReferenceComponents(gui_btn_submit, "4 -1 -1 -1").setReferencePositions(gui_btn_submit, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_1, "7 -1 -1 -1").setReferencePositions(gui_Label_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_price_no.getParent().getLayout()).setInsets(gui_lbl_price_no, "0.0mm -0.52910054mm auto 0.52910054mm").setReferenceComponents(gui_lbl_price_no, "3 -1 -1 -1").setReferencePositions(gui_lbl_price_no, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)69.57672);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)93.915344);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    @Override
    public void dispose() {
        super.dispose();
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInfiniteBlocking();
        Map<String, Object> currentListing = api.getGymOrders();
        club_BaseForm.currentListing = currentListing;
        dlg.dispose();
        new club_orders(res).show();
        
    }
    
    public void onbtn_closeActionEvent(com.codename1.ui.events.ActionEvent ev) {
        dispose();
    }
    
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
