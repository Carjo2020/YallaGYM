package com.yallagym.club.forms;

import com.cn2.ui.cn1Slider;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import com.yallagym.club.layouts.club_payments_details_item;

public class club_payments_details extends club_BaseForm {

    Resources res;
    Form frm;

    public club_payments_details() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public club_payments_details(com.codename1.ui.util.Resources res) {
        checkLanguage(res);

    }

    public club_payments_details(com.codename1.ui.util.Resources res, Form frm) {
        checkLanguage(res);
        this.res = res;
        this.frm = frm;

        installFixItems();

    }

    public club_payments_details(com.codename1.ui.util.Resources res, Form frm, String name, String date_start, String date_end, String total_price, String pay_method, String subscription) {
        checkLanguage(res);
        this.res = res;
        this.frm = frm;
        installTitleArea(res);
        installBackIcon(frm);
        installBackCommand(frm);
        gui_con_stars.add(CENTER, cn1Slider.createStarRankSlider(4.5, 4));
        gui_Label.setPreferredW(gui_Label.getPreferredH());
        gui_Container.setScrollable(false);
        this.setScrollable(false);
        gui_lbl_name.setText(name);
        gui_con_items.add(new club_payments_details_item(res, date_start, date_end, total_price, pay_method, subscription));

    }
//////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_con_stars = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_con_items = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_payments_details");
        setName("club_payments_details");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("20.63492mm 19.84127mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:user_green_512_ic.png;");
        gui_Label.setName("Label");
        gui_lbl_name.setText("Sara Fahmawi");
                gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("font:5.0mm; fgColor:3c4646;");
        gui_lbl_name.setName("lbl_name");
        gui_con_stars.setPreferredSizeStr("34.656086mm 7.6719575mm");
                gui_con_stars.setInlineStylesTheme(resourceObjectInstance);
        gui_con_stars.setName("con_stars");
        gui_con_items.setPreferredSizeStr("inherit 69.04762mm");
                gui_con_items.setInlineStylesTheme(resourceObjectInstance);
        gui_con_items.setName("con_items");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_lbl_name);
        gui_Container.addComponent(gui_con_stars);
        gui_Container.addComponent(gui_con_items);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "9.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "3.0mm auto auto auto").setReferenceComponents(gui_lbl_name, "0 -1 -1 -1").setReferencePositions(gui_lbl_name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getLayout()).setPreferredWidthMM((float)34.656086);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_stars.getParent().getLayout()).setInsets(gui_con_stars, "1.0mm auto auto auto").setReferenceComponents(gui_con_stars, "1 -1 -1 -1").setReferencePositions(gui_con_stars, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_items.getParent().getLayout()).setInsets(gui_con_items, "1.0mm 2.0mm 0.0mm 2.0mm").setReferenceComponents(gui_con_items, "2 -1 -1 -1").setReferencePositions(gui_con_items, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!DON'T EDIT ABOVE THIS LINE!!!
    private void installFixItems() {
        installTitleArea(res);
        installBackIcon(frm);
        installBackCommand(frm);
        gui_con_stars.add(CENTER, cn1Slider.createStarRankSlider(4.5, 4));
        gui_Label.setPreferredW(gui_Label.getPreferredH());
        gui_Container.setScrollable(false);
        this.setScrollable(false);
        gui_con_items.add(new club_payments_details_item(res));
    }

    private void checkLanguage(Resources res) {
        if (com.yallagym.BaseForm.isArabic()) {
            initArGuiBuilderComponents(res);
            setRTLCmb(res);
        } else {
            initGuiBuilderComponents(res);
        }
    }

    private void initArGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_payments_details");
        setName("club_payments_details");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("20.63492mm 19.84127mm");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:user_green_512_ic.png;");
        gui_Label.setName("Label");
        gui_lbl_name.setText("Sara Fahmawi");
        gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("font:5.0mm; fgColor:3c4646;");
        gui_lbl_name.setName("lbl_name");
        gui_con_stars.setPreferredSizeStr("34.656086mm 7.6719575mm");
        gui_con_stars.setInlineStylesTheme(resourceObjectInstance);
        gui_con_stars.setName("con_stars");
        gui_con_items.setPreferredSizeStr("inherit 69.04762mm");
        gui_con_items.setInlineStylesTheme(resourceObjectInstance);
        gui_con_items.setName("con_items");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_lbl_name);
        gui_Container.addComponent(gui_con_stars);
        gui_Container.addComponent(gui_con_items);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "9.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "3.0mm auto auto auto").setReferenceComponents(gui_lbl_name, "0 -1 -1 -1").setReferencePositions(gui_lbl_name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_stars.getLayout()).setPreferredWidthMM((float) 34.656086);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_stars.getLayout()).setPreferredHeightMM((float) 7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_stars.getParent().getLayout()).setInsets(gui_con_stars, "1.0mm auto auto auto").setReferenceComponents(gui_con_stars, "1 -1 -1 -1").setReferencePositions(gui_con_stars, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_items.getParent().getLayout()).setInsets(gui_con_items, "1.0mm 2.0mm 0.0mm 2.0mm").setReferenceComponents(gui_con_items, "2 -1 -1 -1").setReferencePositions(gui_con_items, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
