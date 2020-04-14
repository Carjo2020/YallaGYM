package com.yallagym.club.layouts;

import com.cn2.ui.cn1Icons;
import com.codename1.ui.CN;
import com.codename1.ui.util.Resources;

public class club_payments_details_item extends com.codename1.ui.Container {

    public club_payments_details_item() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }
    int i = 0;
    int highet;

    public club_payments_details_item(com.codename1.ui.util.Resources resourceObjectInstance) {
        checkLanguage(resourceObjectInstance);
        highet = gui_Container.getPreferredH();
        gui_lbl_arrow.setIcon(new cn1Icons().getImage("keyboard arrow down", "Command", 4));
        gui_Container.setPreferredH(gui_Container_2.getPreferredH());
        gui_btn_show.addActionListener(e -> {
            if (i == 0) {
                gui_Container.setPreferredH(highet);
                gui_lbl_arrow.setIcon(new cn1Icons().getImage("keyboard arrow up", "Command", 4));
                i = 1;
            } else {
                gui_Container.setPreferredH(gui_Container_2.getPreferredH());
                gui_lbl_arrow.setIcon(new cn1Icons().getImage("keyboard arrow down", "Command", 4));
                i = 0;
            }
            CN.getCurrentForm().revalidate();
        });
    }

    public club_payments_details_item(com.codename1.ui.util.Resources resourceObjectInstance, String date_start, String date_end, String total_price, String pay_method, String subscription) {
    checkLanguage(resourceObjectInstance);
        highet = gui_Container.getPreferredH();
        gui_lbl_arrow.setIcon(new cn1Icons().getImage("keyboard arrow down", "Command", 4));
        gui_Container.setPreferredH(gui_Container_2.getPreferredH());
        gui_btn_show.addActionListener(e -> {
            if (i == 0) {
                gui_Container.setPreferredH(highet);
                gui_lbl_arrow.setIcon(new cn1Icons().getImage("keyboard arrow up", "Command", 4));
                i = 1;
            } else {
                gui_Container.setPreferredH(gui_Container_2.getPreferredH());
                gui_lbl_arrow.setIcon(new cn1Icons().getImage("keyboard arrow down", "Command", 4));
                i = 0;
            }
            CN.getCurrentForm().revalidate();
        });
        if (pay_method.equals("offline")) {
            gui_lbl_pay_method.setText("Cash");
        } else {
            gui_lbl_pay_method.setText(pay_method);
        }
        gui_lbl_start.setText(date_start);
        gui_lbl_end.setText(date_end);
        gui_lbl_total_price.setText(total_price);
        gui_lbl_subscription.setText(subscription);
    }

//////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_start = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_end = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_pay_method = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_total_price = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_show = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_subscription = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_arrow = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("club_payments_details_item");
        gui_Container.setPreferredSizeStr("inherit 44.444447mm");
        gui_Container.setUIID("club_payments_details_item_btn");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("54.761906mm 24.603174mm");
        gui_Container_1.setUIID("club_payments_details_item_con");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setInlineAllStyles("border:roundRect +top-left +top-right +bottom-left +bottom-right 3.0mm;");
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("58.46561mm 14.550264mm");
        gui_Container_2.setUIID("club_payments_details_item_btn");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("border:roundRect +top-left +top-right +bottom-left +bottom-right 3.0mm;");
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_start.setPreferredSizeStr("66.402115mm 4.4973545mm");
        gui_lbl_start.setText("Start date : 3 / 9 / 2019 ");
                gui_lbl_start.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_start.setInlineAllStyles("font:2.5mm; fgColor:ffffff;");
        gui_lbl_start.setName("lbl_start");
        gui_lbl_end.setPreferredSizeStr("87.03704mm 4.7619047mm");
        gui_lbl_end.setText("Start date : 3 / 9 / 2019 ");
                gui_lbl_end.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_end.setInlineAllStyles("font:2.5mm; fgColor:ffffff;");
        gui_lbl_end.setName("lbl_end");
        gui_Label_2.setPreferredSizeStr("15.079365mm 7.4074073mm");
        gui_Label_2.setText("Pay through");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:2.5mm; fgColor:ffffff;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("15.873016mm 7.4074073mm");
        gui_Label_3.setText("JOD");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("font:6.0mm; fgColor:ffffff; opacity:122;");
        gui_Label_3.setName("Label_3");
        gui_lbl_pay_method.setPreferredSizeStr("24.603174mm 7.4074073mm");
        gui_lbl_pay_method.setText("Paypal");
                gui_lbl_pay_method.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_pay_method.setInlineAllStyles("font:2.5mm; fgColor:ffffff;");
        gui_lbl_pay_method.setName("lbl_pay_method");
        gui_lbl_total_price.setPreferredSizeStr("14.550264mm 8.465609mm");
        gui_lbl_total_price.setText("95");
                gui_lbl_total_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total_price.setInlineAllStyles("font:10.0mm; fgColor:ffffff;");
        gui_lbl_total_price.setName("lbl_total_price");
        gui_Container_1.addComponent(gui_lbl_start);
        gui_Container_1.addComponent(gui_lbl_end);
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_Label_3);
        gui_Container_1.addComponent(gui_lbl_pay_method);
        gui_Container_1.addComponent(gui_lbl_total_price);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_start.getParent().getLayout()).setInsets(gui_lbl_start, "3.0mm 0.0mm auto 2.0mm").setReferenceComponents(gui_lbl_start, "-1 -1 -1 -1").setReferencePositions(gui_lbl_start, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_end.getParent().getLayout()).setInsets(gui_lbl_end, "0.0mm -1.1920929E-7mm auto 2.0mm").setReferenceComponents(gui_lbl_end, "0 -1 -1 -1").setReferencePositions(gui_lbl_end, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm auto auto 2.0mm").setReferenceComponents(gui_Label_2, "5 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "2.3809524mm 70.149254% auto 0.0mm").setReferenceComponents(gui_Label_3, "1 -1 -1 5 ").setReferencePositions(gui_Label_3, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_pay_method.getParent().getLayout()).setInsets(gui_lbl_pay_method, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_lbl_pay_method, "5 -1 -1 2 ").setReferencePositions(gui_lbl_pay_method, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total_price.getParent().getLayout()).setInsets(gui_lbl_total_price, "1.0mm auto auto 2.0mm").setReferenceComponents(gui_lbl_total_price, "1 -1 -1 -1").setReferencePositions(gui_lbl_total_price, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_2);
        gui_btn_show.setPreferredSizeStr("97.8836mm 24.338625mm");
        gui_btn_show.setUIID("transperent");
                gui_btn_show.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_show.setName("btn_show");
        gui_lbl_subscription.setPreferredSizeStr("47.8836mm 6.878307mm");
        gui_lbl_subscription.setText("Monthly Subscribtion");
                gui_lbl_subscription.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_subscription.setInlineAllStyles("font:4.0mm; fgColor:ffffff; alignment:center;");
        gui_lbl_subscription.setName("lbl_subscription");
                gui_lbl_arrow.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_arrow.setInlineAllStyles("fgColor:ffffff;");
        gui_lbl_arrow.setName("lbl_arrow");
        com.codename1.ui.FontImage.setMaterialIcon(gui_lbl_arrow,"\ue313".charAt(0));
        gui_Container_2.addComponent(gui_btn_show);
        gui_Container_2.addComponent(gui_lbl_subscription);
        gui_Container_2.addComponent(gui_lbl_arrow);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_show.getParent().getLayout()).setInsets(gui_btn_show, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_show, "-1 -1 -1 -1").setReferencePositions(gui_btn_show, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_subscription.getParent().getLayout()).setInsets(gui_lbl_subscription, "auto auto auto auto").setReferenceComponents(gui_lbl_subscription, "-1 -1 -1 -1").setReferencePositions(gui_lbl_subscription, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_arrow.getParent().getLayout()).setInsets(gui_lbl_arrow, "3.968254mm 4.0mm 3.4391532mm auto").setReferenceComponents(gui_lbl_arrow, "-1 -1 -1 -1").setReferencePositions(gui_lbl_arrow, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)69.84127);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)24.603174);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)69.84127);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)14.550264);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)69.84127);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)44.444447);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!DON'T EDIT ABOVE THIS LINE!!!
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
                setInlineStylesTheme(resourceObjectInstance);
        setName("club_payments_details_item");
        gui_Container.setPreferredSizeStr("inherit 44.444447mm");
        gui_Container.setUIID("club_payments_details_item_btn");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("54.761906mm 24.603174mm");
        gui_Container_1.setUIID("club_payments_details_item_con");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("58.46561mm 14.550264mm");
        gui_Container_2.setUIID("club_payments_details_item_btn");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_start.setPreferredSizeStr("66.402115mm 4.4973545mm");
        gui_lbl_start.setRTL(false);
        gui_lbl_start.setText("Start date : 3 / 9 / 2019 ");
                gui_lbl_start.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_start.setInlineAllStyles("font:2.5mm; fgColor:ffffff; alignment:right;");
        gui_lbl_start.setName("lbl_start");
        gui_lbl_end.setPreferredSizeStr("87.03704mm 4.7619047mm");
        gui_lbl_end.setRTL(false);
        gui_lbl_end.setText("Start date : 3 / 9 / 2019 ");
                gui_lbl_end.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_end.setInlineAllStyles("font:2.5mm; fgColor:ffffff; alignment:right;");
        gui_lbl_end.setName("lbl_end");
        gui_Label_2.setPreferredSizeStr("15.079365mm 7.4074073mm");
        gui_Label_2.setText("Pay through");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:2.5mm; fgColor:ffffff; alignment:right;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("15.873016mm 7.4074073mm");
        gui_Label_3.setText("JOD");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("font:6.0mm; fgColor:ffffff; opacity:122; alignment:right;");
        gui_Label_3.setName("Label_3");
        gui_lbl_pay_method.setPreferredSizeStr("24.603174mm 7.4074073mm");
        gui_lbl_pay_method.setRTL(false);
        gui_lbl_pay_method.setText("Paypal");
                gui_lbl_pay_method.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_pay_method.setInlineAllStyles("font:2.5mm; fgColor:ffffff; alignment:right;");
        gui_lbl_pay_method.setName("lbl_pay_method");
        gui_lbl_total_price.setPreferredSizeStr("14.550264mm 8.465609mm");
        gui_lbl_total_price.setText("95");
                gui_lbl_total_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total_price.setInlineAllStyles("font:10.0mm; fgColor:ffffff;");
        gui_lbl_total_price.setName("lbl_total_price");
        gui_Container_1.addComponent(gui_lbl_start);
        gui_Container_1.addComponent(gui_lbl_end);
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_Label_3);
        gui_Container_1.addComponent(gui_lbl_pay_method);
        gui_Container_1.addComponent(gui_lbl_total_price);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_start.getParent().getLayout()).setInsets(gui_lbl_start, "3.0mm 2.0mm auto 2.0mm").setReferenceComponents(gui_lbl_start, "-1 -1 -1 -1").setReferencePositions(gui_lbl_start, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_end.getParent().getLayout()).setInsets(gui_lbl_end, "0.0mm 2.0mm auto 2.0mm").setReferenceComponents(gui_lbl_end, "0 -1 -1 -1").setReferencePositions(gui_lbl_end, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 2.0mm auto auto").setReferenceComponents(gui_Label_2, "5 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "2.3809524mm 0.0mm auto auto").setReferenceComponents(gui_Label_3, "1 5 -1 -1").setReferencePositions(gui_Label_3, "1.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_pay_method.getParent().getLayout()).setInsets(gui_lbl_pay_method, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_lbl_pay_method, "5 2 -1 -1").setReferencePositions(gui_lbl_pay_method, "1.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total_price.getParent().getLayout()).setInsets(gui_lbl_total_price, "1.0mm 2.0mm auto auto").setReferenceComponents(gui_lbl_total_price, "1 -1 -1 -1").setReferencePositions(gui_lbl_total_price, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_2);
        gui_btn_show.setPreferredSizeStr("97.8836mm 24.338625mm");
        gui_btn_show.setUIID("transperent");
                gui_btn_show.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_show.setName("btn_show");
        gui_lbl_subscription.setPreferredSizeStr("47.8836mm 6.878307mm");
        gui_lbl_subscription.setText("Monthly Subscribtion");
                gui_lbl_subscription.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_subscription.setInlineAllStyles("font:4.0mm; fgColor:ffffff; alignment:center;");
        gui_lbl_subscription.setName("lbl_subscription");
                gui_lbl_arrow.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_arrow.setInlineAllStyles("fgColor:ffffff;");
        gui_lbl_arrow.setName("lbl_arrow");
        com.codename1.ui.FontImage.setMaterialIcon(gui_lbl_arrow,"\ue313".charAt(0));
        gui_Container_2.addComponent(gui_btn_show);
        gui_Container_2.addComponent(gui_lbl_subscription);
        gui_Container_2.addComponent(gui_lbl_arrow);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_show.getParent().getLayout()).setInsets(gui_btn_show, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_show, "-1 -1 -1 -1").setReferencePositions(gui_btn_show, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_subscription.getParent().getLayout()).setInsets(gui_lbl_subscription, "auto auto auto auto").setReferenceComponents(gui_lbl_subscription, "-1 -1 -1 -1").setReferencePositions(gui_lbl_subscription, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_arrow.getParent().getLayout()).setInsets(gui_lbl_arrow, "3.968254mm 4.0mm 3.4391532mm auto").setReferenceComponents(gui_lbl_arrow, "-1 -1 -1 -1").setReferencePositions(gui_lbl_arrow, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)69.84127);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)24.603174);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)69.84127);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)14.550264);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)69.84127);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)44.444447);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
