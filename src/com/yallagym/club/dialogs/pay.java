package com.yallagym.club.dialogs;

import com.codename1.ui.util.Resources;

public class pay extends club_BaseDialog {

    public pay() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public pay(com.codename1.ui.util.Resources res) {
        checkLanguage(res);

    }

    public pay(com.codename1.ui.util.Resources res, double offline, double online) {
        checkLanguage(res);
        installDialog(res);
        double total = online - offline;
//        gui_Span_Label_1.setTextUIID("Detalis_Sb_white_pay");
        gui_lbl_online.setText(online + "");
        gui_lbl_offline.setText(offline + "");
        gui_lbl_total.setText(total + "");
        if (total >= 0) {
            gui_Button_1.setText("Collect");
            //send collect mony request
        } else {
            gui_Button_1.setText("Deposit");
            gui_lbl_total.getAllStyles().setFgColor(0xc90000);
            //open create payment section
        }

    }

////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.components.SpanLabel gui_Span_Label = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Label gui_lbl_online = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.components.SpanLabel gui_Span_Label_1 = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Label gui_lbl_offline = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_total = new com.codename1.ui.Label();
    protected com.codename1.components.SpanLabel gui_Span_Label_2 = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_ignore = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_ignore.addActionListener(callback);
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

            if(sourceComponent == gui_btn_ignore) {
                onbtn_ignoreActionEvent(ev);
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
        setTitle("pay");
        setName("pay");
        gui_Container.setPreferredSizeStr("51.851852mm 73.809525mm");
        gui_Container.setUIID("club_dlg");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("78.04233mm 8.994709mm");
        gui_Label.setText("Pay");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:5.0mm; fgColor:ffffff; alignment:center;");
        gui_Label.setName("Label");
        gui_Container_1.setPreferredSizeStr("inherit 55.026455mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("inherit 13.4920635mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Label_2.setPreferredSizeStr("9.523809mm 6.878307mm");
        gui_Label_2.setText("-");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:10.0mm; fgColor:ffffff; alignment:center;");
        gui_Label_2.setName("Label_2");
        gui_Container_3.setPreferredSizeStr("65.87302mm 13.4920635mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_4.setPreferredSizeStr("65.87302mm 13.4920635mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Label_5.setPreferredSizeStr("34.656086mm 1.3227513mm");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("font:10.0mm; bgColor:ffffff; fgColor:ffffff; transparency:255; alignment:center;");
        gui_Label_5.setName("Label_5");
        gui_Container_5.setPreferredSizeStr("36.50794mm 8.730159mm");
                gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setName("Container_5");
        gui_Container_1.addComponent(gui_Container_2);
        gui_Span_Label.setPreferredSizeStr("17.460318mm inherit");
        gui_Span_Label.setText("Total Online Payments");
                gui_Span_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label.setName("Span_Label");
        gui_Span_Label.setPropertyValue("textUiid", "Detalis_Sb_white_pay");
        gui_lbl_online.setPreferredSizeStr("38.095238mm 12.433863mm");
        gui_lbl_online.setText("100.0");
                gui_lbl_online.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_online.setInlineAllStyles("font:10.0mm; fgColor:aae40b;");
        gui_lbl_online.setName("lbl_online");
        gui_Container_2.addComponent(gui_Span_Label);
        gui_Container_2.addComponent(gui_lbl_online);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Label.getParent().getLayout()).setInsets(gui_Span_Label, "0.0mm 65.0% 0.0mm 1.0mm").setReferenceComponents(gui_Span_Label, "-1 -1 -1 -1").setReferencePositions(gui_Span_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_online.getParent().getLayout()).setInsets(gui_lbl_online, "auto auto auto 0.0mm").setReferenceComponents(gui_lbl_online, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_online, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_Container_3);
        gui_Span_Label_1.setPreferredSizeStr("17.724869mm inherit");
        gui_Span_Label_1.setText("Total Offline Fees");
                gui_Span_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label_1.setName("Span_Label_1");
        gui_Span_Label_1.setPropertyValue("textUiid", "Detalis_Sb_white_pay");
        gui_lbl_offline.setPreferredSizeStr("36.772488mm 12.433863mm");
        gui_lbl_offline.setText("10.0");
                gui_lbl_offline.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_offline.setInlineAllStyles("font:10.0mm; fgColor:c90000;");
        gui_lbl_offline.setName("lbl_offline");
        gui_Container_3.addComponent(gui_Span_Label_1);
        gui_Container_3.addComponent(gui_lbl_offline);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Label_1.getParent().getLayout()).setInsets(gui_Span_Label_1, "0.0mm 65.0% 0.0mm 1.0mm").setReferenceComponents(gui_Span_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Span_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_offline.getParent().getLayout()).setInsets(gui_lbl_offline, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_offline, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_offline, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_lbl_total.setPreferredSizeStr("36.772488mm 12.433863mm");
        gui_lbl_total.setText("90.0");
                gui_lbl_total.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total.setInlineAllStyles("font:10.0mm; fgColor:aae40b;");
        gui_lbl_total.setName("lbl_total");
        gui_Span_Label_2.setPreferredSizeStr("inherit 22.486773mm");
        gui_Span_Label_2.setText("");
                gui_Span_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label_2.setName("Span_Label_2");
        gui_Span_Label_2.setPropertyValue("textUiid", "Detalis_Sb_white_pay");
        gui_Container_4.addComponent(gui_lbl_total);
        gui_Container_4.addComponent(gui_Span_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total.getParent().getLayout()).setInsets(gui_lbl_total, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_total, "-1 -1 -1 1 ").setReferencePositions(gui_lbl_total, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Label_2.getParent().getLayout()).setInsets(gui_Span_Label_2, "0.0mm 65.0% 0.0mm 1.0mm").setReferenceComponents(gui_Span_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Span_Label_2, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Label_5);
        gui_Container_1.addComponent(gui_Container_5);
        gui_btn_ignore.setPreferredSizeStr("19.84127mm 14.814815mm");
        gui_btn_ignore.setText("Cancel");
        gui_btn_ignore.setUIID("club_payments_pay_red_btn");
                gui_btn_ignore.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_ignore.setName("btn_ignore");
        gui_Button_1.setPreferredSizeStr("26.719578mm 10.58201mm");
        gui_Button_1.setText("Pay");
        gui_Button_1.setUIID("club_payments_pay_green_btn");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1");
        gui_Container_5.addComponent(gui_btn_ignore);
        gui_Container_5.addComponent(gui_Button_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_ignore.getParent().getLayout()).setInsets(gui_btn_ignore, "0.0mm 55.0% 0.0mm 5.0%").setReferenceComponents(gui_btn_ignore, "-1 -1 -1 -1").setReferencePositions(gui_btn_ignore, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button_1.getParent().getLayout()).setInsets(gui_Button_1, "0.0mm 2.3809524% 0.0mm 55.0%").setReferenceComponents(gui_Button_1, "-1 -1 -1 -1").setReferencePositions(gui_Button_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)65.87302);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)13.4920635);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.26455027mm auto -0.26455027mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 2.3809528mm auto auto").setReferenceComponents(gui_Label_2, "0 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)65.87302);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)13.4920635);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm -1.1920929E-7mm auto 1.1920929E-7mm").setReferenceComponents(gui_Container_3, "1 -1 -1 -1").setReferencePositions(gui_Container_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)65.87302);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)13.4920635);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_4, "4 -1 -1 -1").setReferencePositions(gui_Container_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "0.0mm 15.662651% auto 31.726908%").setReferenceComponents(gui_Label_5, "2 -1 -1 -1").setReferencePositions(gui_Label_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredWidthMM((float)52.1164);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredHeightMM((float)8.730159);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_5, "3 -1 -1 -1").setReferencePositions(gui_Container_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)65.87302);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)55.026455);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "0 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)51.851852);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)74.07407);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "10.0% 5.0% 10.0% 5.0%").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!! 
    //-- DON'T EDIT ABOVE THIS LINE!!!   
    public void onbtn_ignoreActionEvent(com.codename1.ui.events.ActionEvent ev) {
        dispose();
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
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("pay");
        setName("pay");
        gui_Container.setPreferredSizeStr("51.851852mm 73.809525mm");
        gui_Container.setUIID("club_dlg");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("78.04233mm 8.994709mm");
        gui_Label.setText("Collect money");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:5.0mm; fgColor:ffffff; alignment:center;");
        gui_Label.setName("Label");
        gui_Container_1.setPreferredSizeStr("inherit 55.026455mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("inherit 13.4920635mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Label_2.setPreferredSizeStr("9.523809mm 6.878307mm");
        gui_Label_2.setText("-");
        gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:10.0mm; fgColor:ffffff; alignment:center;");
        gui_Label_2.setName("Label_2");
        gui_Container_3.setPreferredSizeStr("65.87302mm 13.4920635mm");
        gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_4.setPreferredSizeStr("65.87302mm 13.4920635mm");
        gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Label_5.setPreferredSizeStr("34.656086mm 1.3227513mm");
        gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("font:10.0mm; bgColor:ffffff; fgColor:ffffff; transparency:255; alignment:center;");
        gui_Label_5.setName("Label_5");
        gui_Container_5.setPreferredSizeStr("36.50794mm 8.730159mm");
        gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setName("Container_5");
        gui_Container_1.addComponent(gui_Container_2);
        gui_Span_Label.setPreferredSizeStr("17.460318mm inherit");
        gui_Span_Label.setText("Total Online Payments");
        gui_Span_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label.setName("Span_Label");
        gui_Span_Label.setPropertyValue("textUiid", "Detalis_Sb_white_pay");
        gui_lbl_online.setPreferredSizeStr("29.89418mm 12.433863mm");
        gui_lbl_online.setText("100.0");
        gui_lbl_online.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_online.setInlineAllStyles("font:10.0mm; fgColor:aae40b; alignment:right;");
        gui_lbl_online.setName("lbl_online");
        gui_Container_2.addComponent(gui_Span_Label);
        gui_Container_2.addComponent(gui_lbl_online);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Span_Label.getParent().getLayout()).setInsets(gui_Span_Label, "0.0mm 1.0mm 0.0mm 65.0%").setReferenceComponents(gui_Span_Label, "-1 -1 -1 -1").setReferencePositions(gui_Span_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_online.getParent().getLayout()).setInsets(gui_lbl_online, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_online, "-1 0 -1 -1").setReferencePositions(gui_lbl_online, "0.0 1.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_Container_3);
        gui_Span_Label_1.setPreferredSizeStr("17.724869mm inherit");
        gui_Span_Label_1.setText("Total Offline Fees");
        gui_Span_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label_1.setName("Span_Label_1");
        gui_Span_Label_1.setPropertyValue("textUiid", "Detalis_Sb_white_pay");
        gui_lbl_offline.setPreferredSizeStr("25.925926mm 12.433863mm");
        gui_lbl_offline.setText("10.0");
        gui_lbl_offline.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_offline.setInlineAllStyles("font:10.0mm; fgColor:c90000; alignment:right;");
        gui_lbl_offline.setName("lbl_offline");
        gui_Container_3.addComponent(gui_Span_Label_1);
        gui_Container_3.addComponent(gui_lbl_offline);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Span_Label_1.getParent().getLayout()).setInsets(gui_Span_Label_1, "0.0mm 1.0mm 0.0mm 65.0%").setReferenceComponents(gui_Span_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Span_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_offline.getParent().getLayout()).setInsets(gui_lbl_offline, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_offline, "-1 0 -1 -1").setReferencePositions(gui_lbl_offline, "0.0 1.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_lbl_total.setPreferredSizeStr("27.513227mm 12.433863mm");
        gui_lbl_total.setText("90.0");
        gui_lbl_total.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total.setInlineAllStyles("font:10.0mm; fgColor:aae40b; alignment:right;");
        gui_lbl_total.setName("lbl_total");
        gui_Span_Label_2.setPreferredSizeStr("39.15344mm 22.486773mm");
        gui_Span_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label_2.setName("Span_Label_2");
        gui_Span_Label_2.setPropertyValue("textUiid", "Detalis_Sb_white_pay");
        gui_Container_4.addComponent(gui_lbl_total);
        gui_Container_4.addComponent(gui_Span_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_total.getParent().getLayout()).setInsets(gui_lbl_total, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_total, "-1 1 -1 -1").setReferencePositions(gui_lbl_total, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Span_Label_2.getParent().getLayout()).setInsets(gui_Span_Label_2, "0.0mm 1.0mm 0.0mm 65.0%").setReferenceComponents(gui_Span_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Span_Label_2, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Label_5);
        gui_Container_1.addComponent(gui_Container_5);
        gui_btn_ignore.setPreferredSizeStr("19.84127mm 14.814815mm");
        gui_btn_ignore.setText("Cancel");
        gui_btn_ignore.setUIID("club_payments_pay_red_btn");
        gui_btn_ignore.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_ignore.setName("btn_ignore");
        gui_Button_1.setPreferredSizeStr("26.719578mm 10.58201mm");
        gui_Button_1.setText("Pay");
        gui_Button_1.setUIID("club_payments_pay_green_btn");
        gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1");
        gui_Container_5.addComponent(gui_btn_ignore);
        gui_Container_5.addComponent(gui_Button_1);
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_ignore.getParent().getLayout()).setInsets(gui_btn_ignore, "0.0mm 55.0% 0.0mm 5.0%").setReferenceComponents(gui_btn_ignore, "-1 -1 -1 -1").setReferencePositions(gui_btn_ignore, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Button_1.getParent().getLayout()).setInsets(gui_Button_1, "0.0mm 2.3809524% 0.0mm 55.0%").setReferenceComponents(gui_Button_1, "-1 -1 -1 -1").setReferencePositions(gui_Button_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 65.87302);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 13.4920635);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.26455027mm auto -0.26455027mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm auto auto 2.3809528mm").setReferenceComponents(gui_Label_2, "0 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredWidthMM((float) 65.87302);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredHeightMM((float) 13.4920635);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm -1.1920929E-7mm auto 1.1920929E-7mm").setReferenceComponents(gui_Container_3, "1 -1 -1 -1").setReferencePositions(gui_Container_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredWidthMM((float) 65.87302);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredHeightMM((float) 13.4920635);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_4, "4 -1 -1 -1").setReferencePositions(gui_Container_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "0.0mm 31.73% auto 15.662651%").setReferenceComponents(gui_Label_5, "2 -1 -1 -1").setReferencePositions(gui_Label_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getLayout()).setPreferredWidthMM((float) 52.1164);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getLayout()).setPreferredHeightMM((float) 8.730159);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_5, "3 -1 -1 -1").setReferencePositions(gui_Container_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 65.87302);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 55.026455);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "0 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 51.851852);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 74.07407);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "10.0% 5.0% 10.0% 5.0%").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
