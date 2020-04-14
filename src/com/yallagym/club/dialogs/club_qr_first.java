package com.yallagym.club.dialogs;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.Util;
import com.codename1.ui.CN;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;
import java.util.Map;

public class club_qr_first extends club_BaseDialog {

    public club_qr_first() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public club_qr_first(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

    }
//club_qr_con_first_green
    club_APIs api = new club_APIs();

    public club_qr_first(Resources res, String id_order, String name, String price, String subscription, String start_date, String end_date, String payment_methods) {
        checkLanguage(res);
        installDialog(res);
        this.setScrollableY(true);
        this.setScrollVisible(false);
        gui_Label.setPreferredW(gui_Label.getPreferredH());
        gui_lbl_name.setText(name);
        gui_lbl_price.setText(price);
        gui_lbl_subsctiption.setText(subscription);
        gui_lbl_data_start_no.setText(start_date);
        gui_lbl_data_end_no.setText(end_date);

//        gui_Container.setUIID(UIID);
        if (payment_methods.equalsIgnoreCase("offline")) {
            gui_lbl_payment_method.setText("Cash Payment");
            gui_Container.setUIID("club_qr_con_first");
            gui_btn_continue.addActionListener(e -> {
                dispose();
                new club_qr_offline_pay(res, id_order, price, gui_Container.getPreferredH()).show();
            });
        } else {
            gui_lbl_payment_method.setText(payment_methods.toUpperCase() + " PAYMENT");
            gui_Container.setUIID("club_qr_con_first_green");
            gui_btn_continue.addActionListener(e -> {
                InfiniteProgress prog = new InfiniteProgress();
                Dialog dlg = prog.showInfiniteBlocking();
                api.changeStatus(id_order, "ended");
                Map<String, Object> currentListing = api.getGymOrders();
                club_BaseForm.currentListing = currentListing;
                club_BaseForm.CurrentPaymentListing = api.getGymPayments();
                Util.sleep(2000);
                dlg.dispose();
                dispose();
                new club_qr_done(res, "The following amount has been added to your account", price, gui_Container.getPreferredH(), id_order).show();
            });
        }
    }

////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_subsctiption = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_payment_method = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_continue = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_close = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_price = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_data_start = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_data_start_no = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_data_end = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_data_end_no = new com.codename1.ui.Label();


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
        setTitle("club_qr_first");
        setName("club_qr_first");
        gui_Container.setPreferredSizeStr("inherit 100.0mm");
        gui_Container.setUIID("club_qr_con_first");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("16.931217mm 15.873016mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:user_green_512_ic.png;");
        gui_Label.setName("Label");
        gui_lbl_name.setPreferredSizeStr("80.15873mm inherit");
        gui_lbl_name.setText("Sara Fahmawi");
                gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("font:5.0mm; fgColor:3c4646; alignment:center;");
        gui_lbl_name.setName("lbl_name");
        gui_lbl_subsctiption.setPreferredSizeStr("85.71429mm inherit");
        gui_lbl_subsctiption.setText("Weekly Subscribtion");
                gui_lbl_subsctiption.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_subsctiption.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:center;");
        gui_lbl_subsctiption.setName("lbl_subsctiption");
        gui_lbl_payment_method.setPreferredSizeStr("89.68254mm inherit");
        gui_lbl_payment_method.setText("Paypal Payment");
                gui_lbl_payment_method.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_payment_method.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:center;");
        gui_lbl_payment_method.setName("lbl_payment_method");
        gui_btn_continue.setPreferredSizeStr("34.126984mm 9.259259mm");
        gui_btn_continue.setText("Continue");
        gui_btn_continue.setUIID("btn_get_yellow");
                gui_btn_continue.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_continue.setInlineAllStyles("fgColor:737475;");
        gui_btn_continue.setName("btn_continue");
        gui_btn_close.setPreferredSizeStr("12.698413mm 8.994709mm");
        gui_btn_close.setText("X");
        gui_btn_close.setUIID("transperent");
                gui_btn_close.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_close.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:center;");
        gui_btn_close.setName("btn_close");
        gui_lbl_price.setPreferredSizeStr("76.455025mm 7.142857mm");
        gui_lbl_price.setText("10 JOD");
                gui_lbl_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:center;");
        gui_lbl_price.setName("lbl_price");
        gui_Container_1.setPreferredSizeStr("69.57672mm 4.7619047mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("66.666664mm 4.7619047mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_lbl_name);
        gui_Container.addComponent(gui_lbl_subsctiption);
        gui_Container.addComponent(gui_lbl_payment_method);
        gui_Container.addComponent(gui_btn_continue);
        gui_Container.addComponent(gui_btn_close);
        gui_Container.addComponent(gui_lbl_price);
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_data_start.setPreferredSizeStr("54.761906mm inherit");
        gui_lbl_data_start.setText("Start date : ");
                gui_lbl_data_start.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_data_start.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:right;");
        gui_lbl_data_start.setName("lbl_data_start");
        gui_lbl_data_start_no.setPreferredSizeStr("37.301586mm 10.05291mm");
        gui_lbl_data_start_no.setText("10 / 12 / 2019 ");
                gui_lbl_data_start_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_data_start_no.setInlineAllStyles("font:4.0mm; alignment:left;");
        gui_lbl_data_start_no.setName("lbl_data_start_no");
        gui_Container_1.addComponent(gui_lbl_data_start);
        gui_Container_1.addComponent(gui_lbl_data_start_no);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_data_start.getParent().getLayout()).setInsets(gui_lbl_data_start, "auto 50.0% -0.2645502mm 0.0mm").setReferenceComponents(gui_lbl_data_start, "-1 -1 -1 -1").setReferencePositions(gui_lbl_data_start, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_data_start_no.getParent().getLayout()).setInsets(gui_lbl_data_start_no, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_data_start_no, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_data_start_no, "0.0 0.0 0.0 1.0");
        gui_Container.addComponent(gui_Container_2);
        gui_lbl_data_end.setPreferredSizeStr("54.761906mm inherit");
        gui_lbl_data_end.setText("End date : ");
                gui_lbl_data_end.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_data_end.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:right;");
        gui_lbl_data_end.setName("lbl_data_end");
        gui_lbl_data_end_no.setPreferredSizeStr("37.301586mm 10.05291mm");
        gui_lbl_data_end_no.setText("24 / 12 / 2019 ");
                gui_lbl_data_end_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_data_end_no.setInlineAllStyles("font:4.0mm; alignment:left;");
        gui_lbl_data_end_no.setName("lbl_data_end_no");
        gui_Container_2.addComponent(gui_lbl_data_end);
        gui_Container_2.addComponent(gui_lbl_data_end_no);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_data_end.getParent().getLayout()).setInsets(gui_lbl_data_end, "auto 50.0% -0.2645502mm 0.0mm").setReferenceComponents(gui_lbl_data_end, "-1 -1 -1 -1").setReferencePositions(gui_lbl_data_end, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_data_end_no.getParent().getLayout()).setInsets(gui_lbl_data_end_no, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_data_end_no, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_data_end_no, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "7.0% auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "5.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_name, "0 -1 -1 -1").setReferencePositions(gui_lbl_name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_subsctiption.getParent().getLayout()).setInsets(gui_lbl_subsctiption, "7.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_subsctiption, "6 -1 -1 -1").setReferencePositions(gui_lbl_subsctiption, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_payment_method.getParent().getLayout()).setInsets(gui_lbl_payment_method, "3.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_payment_method, "8 -1 -1 -1").setReferencePositions(gui_lbl_payment_method, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_continue.getParent().getLayout()).setInsets(gui_btn_continue, "3.0mm auto auto auto").setReferenceComponents(gui_btn_continue, "3 -1 -1 -1").setReferencePositions(gui_btn_continue, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_close.getParent().getLayout()).setInsets(gui_btn_close, "1.0mm 1.0mm auto auto").setReferenceComponents(gui_btn_close, "-1 -1 -1 -1").setReferencePositions(gui_btn_close, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_price.getParent().getLayout()).setInsets(gui_lbl_price, "5.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_price, "1 -1 -1 -1").setReferencePositions(gui_lbl_price, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)69.57672);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)4.7619047);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "5.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "2 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)66.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)4.7619047);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "3.0mm 0.0mm auto auto").setReferenceComponents(gui_Container_2, "7 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)68.783066);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)100.0);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onbtn_closeActionEvent(com.codename1.ui.events.ActionEvent ev) {
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
        setTitle("club_qr_first");
        setName("club_qr_first");
        gui_Container.setPreferredSizeStr("inherit 100.0mm");
        gui_Container.setUIID("club_qr_con_first");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("16.931217mm 15.873016mm");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:user_green_512_ic.png;");
        gui_Label.setName("Label");
        gui_lbl_name.setPreferredSizeStr("80.15873mm inherit");
        gui_lbl_name.setText("Sara Fahmawi");
        gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("font:5.0mm; fgColor:3c4646; alignment:center;");
        gui_lbl_name.setName("lbl_name");
        gui_lbl_subsctiption.setPreferredSizeStr("85.71429mm inherit");
        gui_lbl_subsctiption.setText("Weekly Subscribtion");
        gui_lbl_subsctiption.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_subsctiption.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:center;");
        gui_lbl_subsctiption.setName("lbl_subsctiption");
        gui_lbl_payment_method.setPreferredSizeStr("89.68254mm inherit");
        gui_lbl_payment_method.setText("Paypal Payment");
        gui_lbl_payment_method.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_payment_method.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:center;");
        gui_lbl_payment_method.setName("lbl_payment_method");
        gui_btn_continue.setPreferredSizeStr("34.126984mm 9.259259mm");
        gui_btn_continue.setText("Continue");
        gui_btn_continue.setUIID("btn_get_yellow");
        gui_btn_continue.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_continue.setInlineAllStyles("fgColor:737475;");
        gui_btn_continue.setName("btn_continue");
        gui_btn_close.setPreferredSizeStr("12.698413mm 8.994709mm");
        gui_btn_close.setText("X");
        gui_btn_close.setUIID("transperent");
        gui_btn_close.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_close.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:center;");
        gui_btn_close.setName("btn_close");
        gui_lbl_price.setPreferredSizeStr("76.455025mm 7.142857mm");
        gui_lbl_price.setText("10 JOD");
        gui_lbl_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:center;");
        gui_lbl_price.setName("lbl_price");
        gui_Container_1.setPreferredSizeStr("69.57672mm 4.7619047mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("66.666664mm 4.7619047mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_lbl_name);
        gui_Container.addComponent(gui_lbl_subsctiption);
        gui_Container.addComponent(gui_lbl_payment_method);
        gui_Container.addComponent(gui_btn_continue);
        gui_Container.addComponent(gui_btn_close);
        gui_Container.addComponent(gui_lbl_price);
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_data_start.setPreferredSizeStr("43.915344mm inherit");
        gui_lbl_data_start.setRTL(false);
        gui_lbl_data_start.setText("Start date : ");
        gui_lbl_data_start.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_data_start.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:left;");
        gui_lbl_data_start.setName("lbl_data_start");
        gui_lbl_data_start_no.setPreferredSizeStr("26.984127mm 10.05291mm");
        gui_lbl_data_start_no.setText("10 / 12 / 2019 ");
        gui_lbl_data_start_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_data_start_no.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:right;");
        gui_lbl_data_start_no.setName("lbl_data_start_no");
        gui_Container_1.addComponent(gui_lbl_data_start);
        gui_Container_1.addComponent(gui_lbl_data_start_no);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_data_start.getParent().getLayout()).setInsets(gui_lbl_data_start, "0.0mm 0.0mm 5.9604645E-8mm 2.0mm").setReferenceComponents(gui_lbl_data_start, "-1 -1 -1 1 ").setReferencePositions(gui_lbl_data_start, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_data_start_no.getParent().getLayout()).setInsets(gui_lbl_data_start_no, "0.0mm 50.0% 0.0mm 0.0mm").setReferenceComponents(gui_lbl_data_start_no, "-1 -1 -1 -1").setReferencePositions(gui_lbl_data_start_no, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_2);
        gui_lbl_data_end.setPreferredSizeStr("29.62963mm inherit");
        gui_lbl_data_end.setRTL(false);
        gui_lbl_data_end.setText("End date : ");
        gui_lbl_data_end.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_data_end.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:left;");
        gui_lbl_data_end.setName("lbl_data_end");
        gui_lbl_data_end_no.setPreferredSizeStr("33.333332mm 10.05291mm");
        gui_lbl_data_end_no.setText("24 / 12 / 2019 ");
        gui_lbl_data_end_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_data_end_no.setInlineAllStyles("font:4.0mm; fgColor:737475; alignment:right;");
        gui_lbl_data_end_no.setName("lbl_data_end_no");
        gui_Container_2.addComponent(gui_lbl_data_end);
        gui_Container_2.addComponent(gui_lbl_data_end_no);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_data_end.getParent().getLayout()).setInsets(gui_lbl_data_end, "0.0mm 0.0mm 5.9604645E-8mm 2.0mm").setReferenceComponents(gui_lbl_data_end, "-1 -1 -1 1 ").setReferencePositions(gui_lbl_data_end, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_data_end_no.getParent().getLayout()).setInsets(gui_lbl_data_end_no, "0.0mm 50.0% 0.0mm 0.0mm").setReferenceComponents(gui_lbl_data_end_no, "-1 -1 -1 -1").setReferencePositions(gui_lbl_data_end_no, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "7.0% auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "5.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_name, "0 -1 -1 -1").setReferencePositions(gui_lbl_name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_subsctiption.getParent().getLayout()).setInsets(gui_lbl_subsctiption, "7.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_subsctiption, "6 -1 -1 -1").setReferencePositions(gui_lbl_subsctiption, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_payment_method.getParent().getLayout()).setInsets(gui_lbl_payment_method, "3.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_payment_method, "8 -1 -1 -1").setReferencePositions(gui_lbl_payment_method, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_continue.getParent().getLayout()).setInsets(gui_btn_continue, "3.0mm auto auto auto").setReferenceComponents(gui_btn_continue, "3 -1 -1 -1").setReferencePositions(gui_btn_continue, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_close.getParent().getLayout()).setInsets(gui_btn_close, "1.0mm 1.0mm auto auto").setReferenceComponents(gui_btn_close, "-1 -1 -1 -1").setReferencePositions(gui_btn_close, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_price.getParent().getLayout()).setInsets(gui_lbl_price, "5.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_price, "1 -1 -1 -1").setReferencePositions(gui_lbl_price, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 69.57672);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 4.7619047);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "5.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "2 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 66.666664);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 4.7619047);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "3.0mm 0.0mm auto auto").setReferenceComponents(gui_Container_2, "7 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 68.783066);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 100.0);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
