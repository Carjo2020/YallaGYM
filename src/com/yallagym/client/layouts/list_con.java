package com.yallagym.client.layouts;

import static com.codename1.ui.CN.getCurrentForm;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.util.Resources;
import com.yallagym.client.forms.details_form;

public class list_con extends com.codename1.ui.Container {

    public list_con() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public list_con(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }

    public list_con(com.codename1.ui.util.Resources res, String id_gym, String name, String priceD, String priceW, String priceM, String address/*, String distance*/) {
        checkLanguage(res);
        gui_lbl_name.setText(name);
        gui_lbl_priceD.setText(priceD);
        gui_lbl_priceW.setText(priceW);
        gui_lbl_priceM.setText(priceM);
        gui_lbl_address.setText(address);
//        gui_lbl_distance.setText(distance);
        gui_lbl_distance.setVisible(false);
        if (priceD.equals("null")) {
            gui_Container_2.setVisible(false);
        }
        if (priceW.equals("null")) {
            gui_Container_3.setVisible(false);
        }
        if (priceM.equals("null")) {
            gui_Container_4.setVisible(false);
        }

        gui_btn_select_day.addActionListener(e -> {
            new details_form(res, getCurrentForm(), id_gym, "price_d").show();
        });
        gui_btn_select_weeky.addActionListener(e -> {
            new details_form(res, getCurrentForm(), id_gym, "price_w").show();
        });

        gui_btn_select_month.addActionListener(e -> {
            new details_form(res, getCurrentForm(), id_gym, "price_m").show();
//            System.out.println("id_gym: "+id_gym);
        });
        gui_btn_con.addActionListener(e -> {
            new details_form(res, getCurrentForm(), id_gym, "price_w").show();
        });

        gui_Container_2.setPreferredW(this.getPreferredW() / 6);
        gui_Container_3.setPreferredW(this.getPreferredW() / 6);
        gui_Container_4.setPreferredW(this.getPreferredW() / 6);
//        gui_Container_2.setPreferredH(gui_Container_1.getPreferredH() - gui_Container_1.getPreferredH()/6);
//        gui_Container_3.setPreferredH(gui_Container_1.getPreferredH() - gui_Container_1.getPreferredH()/6);
//        gui_Container_4.setPreferredH(gui_Container_1.getPreferredH() - gui_Container_1.getPreferredH()/6);

        gui_Container_2.getAllStyles().setMarginTop(3);
        gui_Container_3.getAllStyles().setMarginBottom(2);
        gui_Container_4.getAllStyles().setMarginTop(3);
//        gui_Container_2.getAllStyles().setMarginBottom(2);
        gui_Container_3.getAllStyles().setMarginTop(0);
//        gui_Container_4.getAllStyles().setMarginBottom(2);
        gui_lbl_priceD.setPreferredH(70);
        gui_lbl_priceW.setPreferredH(70);
        gui_lbl_priceM.setPreferredH(70);
        int s = 150;
        RoundRectBorder r1 = RoundRectBorder.create();
        r1.shadowSpread(2.0f);
        r1.shadowBlur(0);
        r1.shadowOpacity(s);
        r1.shadowColor(0xffffff);
        r1.shadowY(0);
        gui_Container_2.getAllStyles().setBorder(r1);

        RoundRectBorder r2 = RoundRectBorder.create();
        r2.shadowSpread(2.0f);
        r2.shadowBlur(0);
        r2.shadowOpacity(150);
        r2.shadowColor(0xF7ED23);
        r2.shadowY(0);
        gui_Container_3.getAllStyles().setBorder(r2);
        RoundRectBorder r3 = RoundRectBorder.create();
        r3.shadowSpread(2.0f);
        r3.shadowBlur(0);
        r3.shadowOpacity(s);
        r3.shadowColor(0xffffff);
        r3.shadowY(0);
        gui_Container_4.getAllStyles().setBorder(r3);
    }

    public list_con(com.codename1.ui.util.Resources res, String id_gym, String name, String priceD, String priceW, String priceM, String address, String distance) {
        checkLanguage(res);
        gui_lbl_name.setText(name);
        gui_lbl_priceD.setText(priceD);
        gui_lbl_priceW.setText(priceW);
        gui_lbl_priceM.setText(priceM);
        gui_lbl_address.setText(address);
        gui_lbl_distance.setText(distance + " km");
        gui_lbl_distance.setVisible(false);
        if (priceD.equals("null")) {
            gui_Container_2.setVisible(false);
        }
        if (priceW.equals("null")) {
            gui_Container_3.setVisible(false);
        }
        if (priceM.equals("null")) {
            gui_Container_4.setVisible(false);
        }

        gui_btn_select_day.addActionListener(e -> {
            new details_form(res, getCurrentForm(), id_gym, "price_d").show();
        });
        gui_btn_select_weeky.addActionListener(e -> {
            new details_form(res, getCurrentForm(), id_gym, "price_w").show();
        });

        gui_btn_select_month.addActionListener(e -> {
            new details_form(res, getCurrentForm(), id_gym, "price_m").show();
//            System.out.println("id_gym: "+id_gym);
        });

        gui_Container_2.setPreferredW(this.getPreferredW() / 6);
        gui_Container_3.setPreferredW(this.getPreferredW() / 6);
        gui_Container_4.setPreferredW(this.getPreferredW() / 6);
//        gui_Container_2.setPreferredH(gui_Container_1.getPreferredH() - gui_Container_1.getPreferredH()/6);
//        gui_Container_3.setPreferredH(gui_Container_1.getPreferredH() - gui_Container_1.getPreferredH()/6);
//        gui_Container_4.setPreferredH(gui_Container_1.getPreferredH() - gui_Container_1.getPreferredH()/6);

        gui_Container_2.getAllStyles().setMarginTop(3);
        gui_Container_3.getAllStyles().setMarginBottom(2);
        gui_Container_4.getAllStyles().setMarginTop(3);
//        gui_Container_2.getAllStyles().setMarginBottom(2);
        gui_Container_3.getAllStyles().setMarginTop(0);
//        gui_Container_4.getAllStyles().setMarginBottom(2);
        gui_lbl_priceD.setPreferredH(70);
        gui_lbl_priceW.setPreferredH(70);
        gui_lbl_priceM.setPreferredH(70);
        int s = 150;
        RoundRectBorder r1 = RoundRectBorder.create();
        r1.shadowSpread(2.0f);
        r1.shadowBlur(0);
        r1.shadowOpacity(s);
        r1.shadowColor(0xffffff);
        r1.shadowY(0);
        gui_Container_2.getAllStyles().setBorder(r1);

        RoundRectBorder r2 = RoundRectBorder.create();
        r2.shadowSpread(2.0f);
        r2.shadowBlur(0);
        r2.shadowOpacity(150);
        r2.shadowColor(0xF7ED23);
        r2.shadowY(0);
        gui_Container_3.getAllStyles().setBorder(r2);
        RoundRectBorder r3 = RoundRectBorder.create();
        r3.shadowSpread(2.0f);
        r3.shadowBlur(0);
        r3.shadowOpacity(s);
        r3.shadowColor(0xffffff);
        r3.shadowY(0);
        gui_Container_4.getAllStyles().setBorder(r3);
    }
//////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_con = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_address = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_distance = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_select_weeky = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_priceW = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_select_month_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_priceM_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_select_month = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_priceM = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_select_day = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_priceD = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("list_con");
        gui_Container.setPreferredSizeStr("65.60847mm 25.925926mm");
        gui_Container.setUIID("list_Con");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_btn_con.setPreferredSizeStr("60.84656mm 28.571428mm");
        gui_btn_con.setUIID("transperent");
                gui_btn_con.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_con.setName("btn_con");
        gui_lbl_name.setPreferredSizeStr("68.25397mm 3.1746032mm");
        gui_lbl_name.setText("yalla gym");
        gui_lbl_name.setUIID("txt_white_left_ar");
                gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setName("lbl_name");
        gui_lbl_address.setPreferredSizeStr("52.910053mm 2.6455026mm");
        gui_lbl_address.setText("amman");
        gui_lbl_address.setUIID("txt_left_yellow_ar");
                gui_lbl_address.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_address.setName("lbl_address");
        gui_lbl_distance.setPreferredSizeStr("0.0mm 2.3809524mm");
        gui_lbl_distance.setText("5 Km");
        gui_lbl_distance.setUIID("txt_left_yellow_ar");
                gui_lbl_distance.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_distance.setName("lbl_distance");
        gui_Container_1.setPreferredSizeStr("63.227512mm 12.1693125mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_btn_con);
        gui_Container.addComponent(gui_lbl_name);
        gui_Container.addComponent(gui_lbl_address);
        gui_Container.addComponent(gui_lbl_distance);
        gui_Container.addComponent(gui_Container_1);
        gui_Container_3.setPreferredSizeStr("9.259259mm 15.343915mm");
        gui_Container_3.setUIID("list_con_sub1_yellow");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setInlineAllStyles("bgImage:;");
        gui_Container_3.setName("Container_3");
        gui_Container_4.setPreferredSizeStr("9.259259mm 14.550264mm");
        gui_Container_4.setUIID("list_con_sub1_gray");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setInlineAllStyles("bgImage:;");
        gui_Container_4.setName("Container_4");
        gui_Container_2.setPreferredSizeStr("9.259259mm 13.227513mm");
        gui_Container_2.setUIID("list_con_sub1_gray");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("bgImage:;");
        gui_Container_2.setName("Container_2");
        gui_Container_1.addComponent(gui_Container_3);
        gui_btn_select_weeky.setPreferredSizeStr("18.518518mm 18.25397mm");
        gui_btn_select_weeky.setUIID("transperent");
                gui_btn_select_weeky.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select_weeky.setName("btn_select_weeky");
        gui_Label_5.setPreferredSizeStr("13.756614mm 2.6455026mm");
        gui_Label_5.setText("Week");
        gui_Label_5.setUIID("txt_black_center_small");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setName("Label_5");
        gui_lbl_priceW.setPreferredSizeStr("11.640212mm 8.730159mm");
        gui_lbl_priceW.setText("5$");
        gui_lbl_priceW.setUIID("txt_black_center_small");
                gui_lbl_priceW.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_priceW.setName("lbl_priceW");
        gui_Container_5.setPreferredSizeStr("9.259259mm 14.285714mm");
        gui_Container_5.setUIID("list_con_sub1_gray");
                gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setInlineAllStyles("bgImage:;");
        gui_Container_5.setName("Container_5");
        gui_Container_3.addComponent(gui_btn_select_weeky);
        gui_Container_3.addComponent(gui_Label_5);
        gui_Container_3.addComponent(gui_lbl_priceW);
        gui_Container_3.addComponent(gui_Container_5);
        gui_btn_select_month_1.setPreferredSizeStr("20.10582mm 20.899471mm");
        gui_btn_select_month_1.setUIID("transperent");
                gui_btn_select_month_1.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select_month_1.setName("btn_select_month_1");
        gui_lbl_2.setPreferredSizeStr("13.756614mm 9.78836mm");
        gui_lbl_2.setText("Month");
        gui_lbl_2.setUIID("txt_black_center_small");
                gui_lbl_2.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_2.setName("lbl_2");
        gui_lbl_priceM_1.setPreferredSizeStr("11.640212mm 8.730159mm");
        gui_lbl_priceM_1.setText("20$");
        gui_lbl_priceM_1.setUIID("txt_black_center_small");
                gui_lbl_priceM_1.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_priceM_1.setName("lbl_priceM_1");
        gui_Container_5.addComponent(gui_btn_select_month_1);
        gui_Container_5.addComponent(gui_lbl_2);
        gui_Container_5.addComponent(gui_lbl_priceM_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select_month_1.getParent().getLayout()).setInsets(gui_btn_select_month_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select_month_1, "-1 -1 -1 -1").setReferencePositions(gui_btn_select_month_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_2.getParent().getLayout()).setInsets(gui_lbl_2, "0.0mm 0.0mm 50.0% 0.0mm").setReferenceComponents(gui_lbl_2, "-1 -1 -1 -1").setReferencePositions(gui_lbl_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_priceM_1.getParent().getLayout()).setInsets(gui_lbl_priceM_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_priceM_1, "1 -1 -1 -1").setReferencePositions(gui_lbl_priceM_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select_weeky.getParent().getLayout()).setInsets(gui_btn_select_weeky, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select_weeky, "-1 -1 -1 -1").setReferencePositions(gui_btn_select_weeky, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "0.0mm 0.0mm 55.0% 0.0mm").setReferenceComponents(gui_Label_5, "-1 -1 -1 -1").setReferencePositions(gui_Label_5, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_priceW.getParent().getLayout()).setInsets(gui_lbl_priceW, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_priceW, "1 -1 -1 -1").setReferencePositions(gui_lbl_priceW, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredWidthMM((float)9.259259);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredHeightMM((float)14.285714);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "4.616402mm auto -2.1164021mm 12.790055%").setReferenceComponents(gui_Container_5, "-1 -1 -1 0 ").setReferencePositions(gui_Container_5, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_btn_select_month.setPreferredSizeStr("20.10582mm 20.899471mm");
        gui_btn_select_month.setUIID("transperent");
                gui_btn_select_month.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select_month.setName("btn_select_month");
        gui_lbl.setPreferredSizeStr("13.756614mm 2.6455026mm");
        gui_lbl.setText("Month");
        gui_lbl.setUIID("txt_black_center_small");
                gui_lbl.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl.setName("lbl");
        gui_lbl_priceM.setPreferredSizeStr("11.640212mm 8.730159mm");
        gui_lbl_priceM.setText("20$");
        gui_lbl_priceM.setUIID("txt_black_center_small");
                gui_lbl_priceM.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_priceM.setName("lbl_priceM");
        gui_Container_4.addComponent(gui_btn_select_month);
        gui_Container_4.addComponent(gui_lbl);
        gui_Container_4.addComponent(gui_lbl_priceM);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select_month.getParent().getLayout()).setInsets(gui_btn_select_month, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select_month, "-1 -1 -1 -1").setReferencePositions(gui_btn_select_month, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl.getParent().getLayout()).setInsets(gui_lbl, "0.0mm 0.0mm 55.0% 0.0mm").setReferenceComponents(gui_lbl, "-1 -1 -1 -1").setReferencePositions(gui_lbl, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_priceM.getParent().getLayout()).setInsets(gui_lbl_priceM, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_priceM, "1 -1 -1 -1").setReferencePositions(gui_lbl_priceM, "1.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_2);
        gui_btn_select_day.setPreferredSizeStr("20.10582mm 20.899471mm");
        gui_btn_select_day.setUIID("transperent");
                gui_btn_select_day.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select_day.setName("btn_select_day");
        gui_lbl_1.setPreferredSizeStr("13.756614mm 3.7037036mm");
        gui_lbl_1.setText("Day");
        gui_lbl_1.setUIID("txt_black_center_small");
                gui_lbl_1.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_1.setName("lbl_1");
        gui_lbl_priceD.setPreferredSizeStr("11.640212mm 8.730159mm");
        gui_lbl_priceD.setText("1$");
        gui_lbl_priceD.setUIID("txt_black_center_small");
                gui_lbl_priceD.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_priceD.setName("lbl_priceD");
        gui_Container_2.addComponent(gui_btn_select_day);
        gui_Container_2.addComponent(gui_lbl_1);
        gui_Container_2.addComponent(gui_lbl_priceD);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select_day.getParent().getLayout()).setInsets(gui_btn_select_day, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select_day, "-1 -1 -1 -1").setReferencePositions(gui_btn_select_day, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_1.getParent().getLayout()).setInsets(gui_lbl_1, "0.0mm 0.0mm 55.0% 0.0mm").setReferenceComponents(gui_lbl_1, "-1 -1 -1 -1").setReferencePositions(gui_lbl_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_priceD.getParent().getLayout()).setInsets(gui_lbl_priceD, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_priceD, "1 -1 -1 -1").setReferencePositions(gui_lbl_priceD, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)9.259259);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)15.343915);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm auto 0.0mm auto").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)9.259259);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)14.550264);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "0.0mm auto 0.0mm 3.1746032mm").setReferenceComponents(gui_Container_4, "-1 -1 -1 0 ").setReferencePositions(gui_Container_4, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)9.259259);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)13.227513);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 3.1746032mm 0.0mm auto").setReferenceComponents(gui_Container_2, "-1 0 -1 -1").setReferencePositions(gui_Container_2, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_con.getParent().getLayout()).setInsets(gui_btn_con, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_con, "-1 -1 -1 -1").setReferencePositions(gui_btn_con, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "-2.3841858E-7mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_name, "-1 -1 -1 -1").setReferencePositions(gui_lbl_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_address.getParent().getLayout()).setInsets(gui_lbl_address, "auto 0.0mm -2.9802322E-7mm -1.4305115E-6mm").setReferenceComponents(gui_lbl_address, "-1 3 -1 -1").setReferencePositions(gui_lbl_address, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_distance.getParent().getLayout()).setInsets(gui_lbl_distance, "auto 0.0mm 0.0mm 99.0%").setReferenceComponents(gui_lbl_distance, "-1 -1 -1 -1").setReferencePositions(gui_lbl_distance, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)53.174603);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)12.1693125);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "1.1920929E-7mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "1 -1 2 -1").setReferencePositions(gui_Container_1, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)57.40741);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)25.925926);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!   //-- DON'T EDIT ABOVE THIS LINE!!!
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
        setName("list_con");
        gui_Container.setPreferredSizeStr("65.60847mm 25.925926mm");
        gui_Container.setUIID("list_Con");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_btn_con.setPreferredSizeStr("60.84656mm 28.571428mm");
        gui_btn_con.setUIID("transperent");
                gui_btn_con.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_con.setName("btn_con");
        gui_lbl_name.setPreferredSizeStr("68.25397mm 3.1746032mm");
        gui_lbl_name.setText("yalla gym");
        gui_lbl_name.setUIID("txt_white_left_ar");
                gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("alignment:right;");
        gui_lbl_name.setName("lbl_name");
        gui_lbl_address.setPreferredSizeStr("52.910053mm 2.6455026mm");
        gui_lbl_address.setText("amman");
        gui_lbl_address.setUIID("txt_left_yellow_ar");
                gui_lbl_address.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_address.setInlineAllStyles("alignment:right;");
        gui_lbl_address.setName("lbl_address");
        gui_lbl_distance.setPreferredSizeStr("0.0mm 2.3809524mm");
        gui_lbl_distance.setText("5 Km");
        gui_lbl_distance.setUIID("txt_left_yellow_ar");
                gui_lbl_distance.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_distance.setName("lbl_distance");
        gui_Container_1.setPreferredSizeStr("63.227512mm 12.1693125mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_btn_con);
        gui_Container.addComponent(gui_lbl_name);
        gui_Container.addComponent(gui_lbl_address);
        gui_Container.addComponent(gui_lbl_distance);
        gui_Container.addComponent(gui_Container_1);
        gui_Container_3.setPreferredSizeStr("9.259259mm 15.343915mm");
        gui_Container_3.setUIID("list_con_sub1_yellow");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setInlineAllStyles("bgImage:;");
        gui_Container_3.setName("Container_3");
        gui_Container_4.setPreferredSizeStr("9.259259mm 14.550264mm");
        gui_Container_4.setUIID("list_con_sub1_gray");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setInlineAllStyles("bgImage:;");
        gui_Container_4.setName("Container_4");
        gui_Container_2.setPreferredSizeStr("9.259259mm 13.227513mm");
        gui_Container_2.setUIID("list_con_sub1_gray");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("bgImage:;");
        gui_Container_2.setName("Container_2");
        gui_Container_1.addComponent(gui_Container_3);
        gui_btn_select_weeky.setPreferredSizeStr("18.518518mm 18.25397mm");
        gui_btn_select_weeky.setUIID("transperent");
                gui_btn_select_weeky.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select_weeky.setName("btn_select_weeky");
        gui_Label_5.setPreferredSizeStr("13.756614mm 2.6455026mm");
        gui_Label_5.setText("Week");
        gui_Label_5.setUIID("txt_black_center_small");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setName("Label_5");
        gui_lbl_priceW.setPreferredSizeStr("11.640212mm 8.730159mm");
        gui_lbl_priceW.setText("5$");
        gui_lbl_priceW.setUIID("txt_black_center_small");
                gui_lbl_priceW.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_priceW.setName("lbl_priceW");
        gui_Container_5.setPreferredSizeStr("9.259259mm 14.285714mm");
        gui_Container_5.setUIID("list_con_sub1_gray");
                gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setInlineAllStyles("bgImage:;");
        gui_Container_5.setName("Container_5");
        gui_Container_3.addComponent(gui_btn_select_weeky);
        gui_Container_3.addComponent(gui_Label_5);
        gui_Container_3.addComponent(gui_lbl_priceW);
        gui_Container_3.addComponent(gui_Container_5);
        gui_btn_select_month_1.setPreferredSizeStr("20.10582mm 20.899471mm");
        gui_btn_select_month_1.setUIID("transperent");
                gui_btn_select_month_1.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select_month_1.setName("btn_select_month_1");
        gui_lbl_2.setPreferredSizeStr("13.756614mm 9.78836mm");
        gui_lbl_2.setText("Month");
        gui_lbl_2.setUIID("txt_black_center_small");
                gui_lbl_2.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_2.setName("lbl_2");
        gui_lbl_priceM_1.setPreferredSizeStr("11.640212mm 8.730159mm");
        gui_lbl_priceM_1.setText("20$");
        gui_lbl_priceM_1.setUIID("txt_black_center_small");
                gui_lbl_priceM_1.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_priceM_1.setName("lbl_priceM_1");
        gui_Container_5.addComponent(gui_btn_select_month_1);
        gui_Container_5.addComponent(gui_lbl_2);
        gui_Container_5.addComponent(gui_lbl_priceM_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select_month_1.getParent().getLayout()).setInsets(gui_btn_select_month_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select_month_1, "-1 -1 -1 -1").setReferencePositions(gui_btn_select_month_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_2.getParent().getLayout()).setInsets(gui_lbl_2, "0.0mm 0.0mm 50.0% 0.0mm").setReferenceComponents(gui_lbl_2, "-1 -1 -1 -1").setReferencePositions(gui_lbl_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_priceM_1.getParent().getLayout()).setInsets(gui_lbl_priceM_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_priceM_1, "1 -1 -1 -1").setReferencePositions(gui_lbl_priceM_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select_weeky.getParent().getLayout()).setInsets(gui_btn_select_weeky, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select_weeky, "-1 -1 -1 -1").setReferencePositions(gui_btn_select_weeky, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "0.0mm 0.0mm 55.0% 0.0mm").setReferenceComponents(gui_Label_5, "-1 -1 -1 -1").setReferencePositions(gui_Label_5, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_priceW.getParent().getLayout()).setInsets(gui_lbl_priceW, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_priceW, "1 -1 -1 -1").setReferencePositions(gui_lbl_priceW, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredWidthMM((float)9.259259);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredHeightMM((float)14.285714);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "4.616402mm auto -2.1164021mm 12.790055%").setReferenceComponents(gui_Container_5, "-1 -1 -1 0 ").setReferencePositions(gui_Container_5, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_btn_select_month.setPreferredSizeStr("20.10582mm 20.899471mm");
        gui_btn_select_month.setUIID("transperent");
                gui_btn_select_month.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select_month.setName("btn_select_month");
        gui_lbl.setPreferredSizeStr("13.756614mm 2.6455026mm");
        gui_lbl.setText("Month");
        gui_lbl.setUIID("txt_black_center_small");
                gui_lbl.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl.setName("lbl");
        gui_lbl_priceM.setPreferredSizeStr("11.640212mm 8.730159mm");
        gui_lbl_priceM.setText("20$");
        gui_lbl_priceM.setUIID("txt_black_center_small");
                gui_lbl_priceM.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_priceM.setName("lbl_priceM");
        gui_Container_4.addComponent(gui_btn_select_month);
        gui_Container_4.addComponent(gui_lbl);
        gui_Container_4.addComponent(gui_lbl_priceM);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select_month.getParent().getLayout()).setInsets(gui_btn_select_month, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select_month, "-1 -1 -1 -1").setReferencePositions(gui_btn_select_month, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl.getParent().getLayout()).setInsets(gui_lbl, "0.0mm 0.0mm 55.0% 0.0mm").setReferenceComponents(gui_lbl, "-1 -1 -1 -1").setReferencePositions(gui_lbl, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_priceM.getParent().getLayout()).setInsets(gui_lbl_priceM, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_priceM, "1 -1 -1 -1").setReferencePositions(gui_lbl_priceM, "1.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_2);
        gui_btn_select_day.setPreferredSizeStr("20.10582mm 20.899471mm");
        gui_btn_select_day.setUIID("transperent");
                gui_btn_select_day.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_select_day.setName("btn_select_day");
        gui_lbl_1.setPreferredSizeStr("13.756614mm 3.7037036mm");
        gui_lbl_1.setText("Day");
        gui_lbl_1.setUIID("txt_black_center_small");
                gui_lbl_1.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_1.setName("lbl_1");
        gui_lbl_priceD.setPreferredSizeStr("11.640212mm 8.730159mm");
        gui_lbl_priceD.setText("1$");
        gui_lbl_priceD.setUIID("txt_black_center_small");
                gui_lbl_priceD.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_priceD.setName("lbl_priceD");
        gui_Container_2.addComponent(gui_btn_select_day);
        gui_Container_2.addComponent(gui_lbl_1);
        gui_Container_2.addComponent(gui_lbl_priceD);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_select_day.getParent().getLayout()).setInsets(gui_btn_select_day, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_select_day, "-1 -1 -1 -1").setReferencePositions(gui_btn_select_day, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_1.getParent().getLayout()).setInsets(gui_lbl_1, "0.0mm 0.0mm 55.0% 0.0mm").setReferenceComponents(gui_lbl_1, "-1 -1 -1 -1").setReferencePositions(gui_lbl_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_priceD.getParent().getLayout()).setInsets(gui_lbl_priceD, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_priceD, "1 -1 -1 -1").setReferencePositions(gui_lbl_priceD, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)9.259259);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)15.343915);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm auto 0.0mm auto").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)9.259259);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)14.550264);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "0.0mm 3.1746032mm 0.0mm auto").setReferenceComponents(gui_Container_4, "-1 0 -1 -1").setReferencePositions(gui_Container_4, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)9.259259);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)13.227513);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm auto 0.0mm 3.1746032mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 0 ").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_con.getParent().getLayout()).setInsets(gui_btn_con, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_con, "-1 -1 -1 -1").setReferencePositions(gui_btn_con, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "-2.3841858E-7mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_name, "-1 -1 -1 -1").setReferencePositions(gui_lbl_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_address.getParent().getLayout()).setInsets(gui_lbl_address, "auto 0.0mm -2.9802322E-7mm -1.4305115E-6mm").setReferenceComponents(gui_lbl_address, "-1 3 -1 -1").setReferencePositions(gui_lbl_address, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_distance.getParent().getLayout()).setInsets(gui_lbl_distance, "auto 0.0mm 0.0mm 99.0%").setReferenceComponents(gui_lbl_distance, "-1 -1 -1 -1").setReferencePositions(gui_lbl_distance, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)53.174603);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)12.1693125);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "1.1920929E-7mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "1 -1 2 -1").setReferencePositions(gui_Container_1, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)57.40741);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)25.925926);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>


    private void setRTLCmb(Resources res) {
    }
}
