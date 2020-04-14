package com.yallagym.club.layouts;

import com.codename1.ui.util.Resources;

public class club_payment_tabs_container_top extends com.codename1.ui.Container {
    
    public club_payment_tabs_container_top() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
    }
    
    public club_payment_tabs_container_top(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_lbl_div_1.setPreferredH(3);
        gui_lbl_div_2.setPreferredH(3);
    }
    
    public club_payment_tabs_container_top(com.codename1.ui.util.Resources res, String type, String total) {
        checkLanguage(res);
        gui_lbl_div_1.setPreferredH(3);
        gui_lbl_div_2.setPreferredH(3);
        gui_lbl_total.setText(total);
          gui_Button.setVisible(false);
        if (type.equals("green")) {
            gui_lbl_back.getAllStyles().setBackgroundGradientStartColor(0xAAE409);
//            gui_Button.setText("Debt Collection");
//            gui_Button.setUIID("club_payments_pay_red_btn");
//            gui_Button.setPreferredW(cn1Display.getWidth() / 2);
            gui_lbl_total.getAllStyles().setFgColor(0xA3CC2E);
          
        } else if (type.equals("red")) {
//            gui_Button.addActionListener(e -> new pay().show());
        }
    }

//////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_back = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_total = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_con_divider = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_div_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_div_2 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("club_payment_tabs_container_top");
        gui_Container.setPreferredSizeStr("47.354496mm 30.15873mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("43.386242mm 24.603174mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Button.setPreferredSizeStr("12.698413mm 5.555556mm");
        gui_Button.setText("Pay");
        gui_Button.setUIID("club_payments_pay_green_btn");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_con_divider.setPreferredSizeStr("60.84656mm 4.2328043mm");
        gui_con_divider.setScrollableX(false);
                gui_con_divider.setInlineStylesTheme(resourceObjectInstance);
        gui_con_divider.setName("con_divider");
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_back.setPreferredSizeStr("62.962963mm 32.27513mm");
        gui_lbl_back.setUIID("club_payment_con_red");
                gui_lbl_back.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_back.setInlineAllStyles("opacity:247;");
        gui_lbl_back.setName("lbl_back");
        gui_Label.setPreferredSizeStr("73.544975mm 33.862434mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("opacity:147; bgImage:river_ic.png;");
        gui_Label.setName("Label");
        gui_Label_2.setPreferredSizeStr("18.518518mm 5.291005mm");
        gui_Label_2.setText("Total Balance");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:2.5mm; fgColor:ffffff; bgImage:;");
        gui_Label_2.setName("Label_2");
        gui_lbl_total.setText("-10.00");
                gui_lbl_total.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total.setInlineAllStyles("font:10.0mm; fgColor:c90000;");
        gui_lbl_total.setName("lbl_total");
        gui_Label_4.setText("JOD");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setInlineAllStyles("font:6.0mm; fgColor:ffffff; bgImage:;");
        gui_Label_4.setName("Label_4");
        gui_Container_1.addComponent(gui_lbl_back);
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_lbl_total);
        gui_Container_1.addComponent(gui_Label_4);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_back.getParent().getLayout()).setInsets(gui_lbl_back, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_back, "-1 -1 -1 -1").setReferencePositions(gui_lbl_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "1.5mm auto auto 3.5mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total.getParent().getLayout()).setInsets(gui_lbl_total, "2.3809524mm auto auto 3.5mm").setReferenceComponents(gui_lbl_total, "2 -1 -1 -1").setReferencePositions(gui_lbl_total, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "auto auto 4.2328043mm 2.1164021mm").setReferenceComponents(gui_Label_4, "-1 -1 -1 3 ").setReferencePositions(gui_Label_4, "0.0 0.0 0.0 1.0");
        gui_Container.addComponent(gui_Button);
        gui_Container.addComponent(gui_con_divider);
        gui_lbl_div_1.setPreferredSizeStr("28.042328mm 0.52910054mm");
                gui_lbl_div_1.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_div_1.setInlineAllStyles("bgColor:8d8d8d; transparency:135; bgImage:;");
        gui_lbl_div_1.setName("lbl_div_1");
        gui_Label_1.setPreferredSizeStr("21.428572mm 5.026455mm");
        gui_Label_1.setText("Transaction Timeline");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:2.0mm; fgColor:8d8d8d;");
        gui_Label_1.setName("Label_1");
        gui_lbl_div_2.setPreferredSizeStr("28.042328mm 0.52910054mm");
                gui_lbl_div_2.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_div_2.setInlineAllStyles("bgColor:8d8d8d; transparency:135; bgImage:;");
        gui_lbl_div_2.setName("lbl_div_2");
        gui_con_divider.addComponent(gui_lbl_div_1);
        gui_con_divider.addComponent(gui_Label_1);
        gui_con_divider.addComponent(gui_lbl_div_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_div_1.getParent().getLayout()).setInsets(gui_lbl_div_1, "auto 4.0mm auto 4.0mm").setReferenceComponents(gui_lbl_div_1, "-1 1 -1 -1").setReferencePositions(gui_lbl_div_1, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "auto auto auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_div_2.getParent().getLayout()).setInsets(gui_lbl_div_2, "auto 4.0mm auto 4.0mm").setReferenceComponents(gui_lbl_div_2, "-1 -1 -1 1 ").setReferencePositions(gui_lbl_div_2, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)58.73016);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)24.603174);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "20.0mm auto auto auto").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_divider.getLayout()).setPreferredWidthMM((float)60.31746);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_divider.getLayout()).setPreferredHeightMM((float)4.2328043);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_divider.getParent().getLayout()).setInsets(gui_con_divider, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_divider, "1 -1 -1 -1").setReferencePositions(gui_con_divider, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)60.31746);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)30.15873);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!T EDIT ABOVE THIS LINE!!!
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
        setName("club_payment_tabs_container_top");
        gui_Container.setPreferredSizeStr("47.354496mm 30.15873mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("43.386242mm 24.603174mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Button.setPreferredSizeStr("12.698413mm 5.555556mm");
        gui_Button.setText("Pay");
        gui_Button.setUIID("club_payments_pay_green_btn");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_con_divider.setPreferredSizeStr("60.84656mm 4.2328043mm");
        gui_con_divider.setScrollableX(false);
                gui_con_divider.setInlineStylesTheme(resourceObjectInstance);
        gui_con_divider.setName("con_divider");
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_back.setPreferredSizeStr("62.962963mm 32.27513mm");
        gui_lbl_back.setUIID("club_payment_con_red");
                gui_lbl_back.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_back.setInlineAllStyles("opacity:247;");
        gui_lbl_back.setName("lbl_back");
        gui_Label.setPreferredSizeStr("73.544975mm 33.862434mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("opacity:147; bgImage:river_ic.png;");
        gui_Label.setName("Label");
        gui_Label_2.setPreferredSizeStr("18.518518mm 5.291005mm");
        gui_Label_2.setRTL(false);
        gui_Label_2.setText("Total Balance");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:2.5mm; fgColor:ffffff; bgImage:; alignment:right;");
        gui_Label_2.setName("Label_2");
        gui_lbl_total.setText("-10.00");
                gui_lbl_total.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total.setInlineAllStyles("font:10.0mm; fgColor:c90000; alignment:left;");
        gui_lbl_total.setName("lbl_total");
        gui_Label_4.setText("JOD");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setInlineAllStyles("font:6.0mm; fgColor:ffffff; bgImage:; alignment:right;");
        gui_Label_4.setName("Label_4");
        gui_Container_1.addComponent(gui_lbl_back);
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_lbl_total);
        gui_Container_1.addComponent(gui_Label_4);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_back.getParent().getLayout()).setInsets(gui_lbl_back, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_back, "-1 -1 -1 -1").setReferencePositions(gui_lbl_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "1.5mm 3.5mm auto 3.5mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total.getParent().getLayout()).setInsets(gui_lbl_total, "2.3809524mm 3.5mm auto auto").setReferenceComponents(gui_lbl_total, "2 -1 -1 -1").setReferencePositions(gui_lbl_total, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "auto 3.7037048mm 4.2328043mm auto").setReferenceComponents(gui_Label_4, "-1 3 -1 -1").setReferencePositions(gui_Label_4, "0.0 1.0 0.0 0.0");
        gui_Container.addComponent(gui_Button);
        gui_Container.addComponent(gui_con_divider);
        gui_lbl_div_1.setPreferredSizeStr("28.042328mm 0.52910054mm");
                gui_lbl_div_1.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_div_1.setInlineAllStyles("bgColor:8d8d8d; transparency:135; bgImage:;");
        gui_lbl_div_1.setName("lbl_div_1");
        gui_Label_1.setPreferredSizeStr("21.428572mm 5.026455mm");
        gui_Label_1.setText("Transaction Timeline");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:2.0mm; fgColor:8d8d8d; alignment:center;");
        gui_Label_1.setName("Label_1");
        gui_lbl_div_2.setPreferredSizeStr("28.042328mm 0.52910054mm");
                gui_lbl_div_2.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_div_2.setInlineAllStyles("bgColor:8d8d8d; transparency:135; bgImage:;");
        gui_lbl_div_2.setName("lbl_div_2");
        gui_con_divider.addComponent(gui_lbl_div_1);
        gui_con_divider.addComponent(gui_Label_1);
        gui_con_divider.addComponent(gui_lbl_div_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_div_1.getParent().getLayout()).setInsets(gui_lbl_div_1, "auto 4.0mm auto 4.0mm").setReferenceComponents(gui_lbl_div_1, "-1 1 -1 -1").setReferencePositions(gui_lbl_div_1, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "auto auto auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_div_2.getParent().getLayout()).setInsets(gui_lbl_div_2, "auto 4.0mm auto 4.0mm").setReferenceComponents(gui_lbl_div_2, "-1 -1 -1 1 ").setReferencePositions(gui_lbl_div_2, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)58.73016);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)24.603174);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "20.0mm auto auto auto").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_divider.getLayout()).setPreferredWidthMM((float)60.31746);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_divider.getLayout()).setPreferredHeightMM((float)4.2328043);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_divider.getParent().getLayout()).setInsets(gui_con_divider, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_divider, "1 -1 -1 -1").setReferencePositions(gui_con_divider, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)60.31746);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)30.15873);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>


    private void setRTLCmb(Resources res) {
    }
}
