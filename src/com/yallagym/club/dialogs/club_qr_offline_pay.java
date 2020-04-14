package com.yallagym.club.dialogs;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.Util;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;
import com.yallagym.club.forms.club_orders;
import java.util.Map;

public class club_qr_offline_pay extends club_BaseDialog {

    public club_qr_offline_pay() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public club_qr_offline_pay(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }
    club_APIs api = new club_APIs();

    public club_qr_offline_pay(com.codename1.ui.util.Resources res, String id_order, String price, int highet) {
        checkLanguage(res);
        installDialog(res);
        this.setScrollableY(true);
        this.setScrollVisible(false);
        gui_Label.setPreferredW(gui_Label.getPreferredH());
//        gui_Span_Label.setText("The customer\nmust pay " + price);
        gui_lbl_price_no.setText(price);
        gui_Container.setPreferredH(highet);
        gui_btn_done.addActionListener(e -> {
            api.changeStatus(id_order, "ended");
            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInfiniteBlocking();
            api.changeStatus(id_order, "ended");
            Map<String, Object> currentListing = api.getGymOrders();
            club_BaseForm.currentListing = currentListing;
            club_BaseForm.CurrentPaymentListing = api.getGymPayments();
            Util.sleep(2000);
            dlg.dispose();
            dispose();
            new club_qr_done(res, "We will add our fees on your current account", null, highet, id_order).show();

        });
        gui_btn_cancel.addActionListener(e -> {
            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInfiniteBlocking();
            api.changeStatus(id_order, "rejected");
            Map<String, Object> currentListing = api.getGymOrders();
            club_BaseForm.currentListing = currentListing;
            Util.sleep(2000);
            dlg.dispose();
            dispose();
            new club_orders(res).show();
        });
    }
////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_done = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_cancel = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_close = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_price_no = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();


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
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_qr_offline_pay");
        setName("club_qr_offline_pay");
        gui_Container.setPreferredSizeStr("inherit 85.71429mm");
        gui_Container.setUIID("club_qr_con_first");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("56.084656mm 11.375662mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("57.67196mm 11.375662mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Label_2.setPreferredSizeStr("76.719574mm inherit");
        gui_Label_2.setText("after receiving the payment");
        gui_Label_2.setUIID("PersonalInfo_Lbl");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("alignment:center;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("78.30688mm inherit");
        gui_Label_3.setText("to cancel order");
        gui_Label_3.setUIID("PersonalInfo_Lbl");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("alignment:center;");
        gui_Label_3.setName("Label_3");
        gui_btn_close.setPreferredSizeStr("12.698413mm 8.994709mm");
        gui_btn_close.setText("X");
        gui_btn_close.setUIID("transperent");
                gui_btn_close.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_close.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:center;");
        gui_btn_close.setName("btn_close");
        gui_lbl_price_no.setPreferredSizeStr("63.492065mm inherit");
        gui_lbl_price_no.setText(" $35");
        gui_lbl_price_no.setUIID("club_dlg_done_sb_green");
                gui_lbl_price_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price_no.setName("lbl_price_no");
        gui_Label_5.setPreferredSizeStr("63.492065mm 11.375662mm");
        gui_Label_5.setText("The customer must pay");
        gui_Label_5.setUIID("club_dlg_done_sb_green");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("font:4.0mm;");
        gui_Label_5.setName("Label_5");
        gui_Container.addComponent(gui_Container_1);
        gui_Label.setPreferredSizeStr("22.486773mm 18.78307mm");
        gui_Label.setText("Press");
        gui_Label.setUIID("PersonalInfo_Lbl");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:3.0mm; fgColor:0; alignment:right;");
        gui_Label.setName("Label");
        gui_btn_done.setPreferredSizeStr("23.015873mm 7.142857mm");
        gui_btn_done.setText("DONE");
        gui_btn_done.setUIID("btn_get_yellow");
                gui_btn_done.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_done.setInlineAllStyles("fgColor:737475;");
        gui_btn_done.setName("btn_done");
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_btn_done);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 60.0% 0.0mm 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_done.getParent().getLayout()).setInsets(gui_btn_done, "auto auto auto 1.0mm").setReferenceComponents(gui_btn_done, "-1 -1 -1 0 ").setReferencePositions(gui_btn_done, "0.0 0.0 0.0 1.0");
        gui_Container.addComponent(gui_Container_2);
        gui_Label_1.setPreferredSizeStr("15.608466mm 18.78307mm");
        gui_Label_1.setText("Press");
        gui_Label_1.setUIID("PersonalInfo_Lbl");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:3.0mm; fgColor:0; alignment:right;");
        gui_Label_1.setName("Label_1");
        gui_btn_cancel.setPreferredSizeStr("22.486773mm 5.820106mm");
        gui_btn_cancel.setText("CANCEL");
        gui_btn_cancel.setUIID("btn_get_red");
                gui_btn_cancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_cancel.setInlineAllStyles("fgColor:737475;");
        gui_btn_cancel.setName("btn_cancel");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Container_2.addComponent(gui_btn_cancel);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 60.0% 0.0mm 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_cancel.getParent().getLayout()).setInsets(gui_btn_cancel, "auto auto auto 1.5mm").setReferenceComponents(gui_btn_cancel, "-1 -1 -1 0 ").setReferencePositions(gui_btn_cancel, "0.0 0.0 0.0 1.0");
        gui_Container.addComponent(gui_Label_2);
        gui_Container.addComponent(gui_Label_3);
        gui_Container.addComponent(gui_btn_close);
        gui_Container.addComponent(gui_lbl_price_no);
        gui_Container.addComponent(gui_Label_5);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)57.67196);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)11.375662);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "6.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "5 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)57.67196);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)11.375662);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_2, "2 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "-2.3841858E-7mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_2, "0 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_3, "1 -1 -1 -1").setReferencePositions(gui_Label_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_close.getParent().getLayout()).setInsets(gui_btn_close, "1.0mm 1.0mm auto auto").setReferenceComponents(gui_btn_close, "-1 -1 -1 -1").setReferencePositions(gui_btn_close, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_price_no.getParent().getLayout()).setInsets(gui_lbl_price_no, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_price_no, "6 -1 -1 -1").setReferencePositions(gui_lbl_price_no, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "20.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_5, "-1 -1 -1 -1").setReferencePositions(gui_Label_5, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)61.37566);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)85.71429);
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
        setScrollableY(false);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_qr_offline_pay");
        setName("club_qr_offline_pay");
        gui_Container.setUIID("club_qr_con_first");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("56.084656mm 11.375662mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("57.67196mm 11.375662mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Label_2.setPreferredSizeStr("76.719574mm inherit");
        gui_Label_2.setText("after receiving the payment");
        gui_Label_2.setUIID("PersonalInfo_Lbl");
        gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("alignment:center;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("78.30688mm inherit");
        gui_Label_3.setText("to cancel order");
        gui_Label_3.setUIID("PersonalInfo_Lbl");
        gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("alignment:center;");
        gui_Label_3.setName("Label_3");
        gui_btn_close.setPreferredSizeStr("12.698413mm 8.994709mm");
        gui_btn_close.setText("X");
        gui_btn_close.setUIID("transperent");
        gui_btn_close.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_close.setInlineAllStyles("font:5.0mm; fgColor:0; alignment:center;");
        gui_btn_close.setName("btn_close");
        gui_lbl_price_no.setPreferredSizeStr("63.492065mm inherit");
        gui_lbl_price_no.setText(" $35");
        gui_lbl_price_no.setUIID("club_dlg_done_sb_green");
        gui_lbl_price_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price_no.setName("lbl_price_no");
        gui_Label_5.setPreferredSizeStr("63.492065mm 11.375662mm");
        gui_Label_5.setText("The customer must pay");
        gui_Label_5.setUIID("club_dlg_done_sb_green");
        gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("font:4.0mm;");
        gui_Label_5.setName("Label_5");
        gui_Container.addComponent(gui_Container_1);
        gui_Label.setPreferredSizeStr("22.486773mm 18.78307mm");
        gui_Label.setText("Press");
        gui_Label.setUIID("PersonalInfo_Lbl");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:3.0mm; fgColor:0; alignment:left;");
        gui_Label.setName("Label");
        gui_btn_done.setPreferredSizeStr("23.015873mm 7.142857mm");
        gui_btn_done.setText("DONE");
        gui_btn_done.setUIID("btn_get_yellow");
        gui_btn_done.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_done.setInlineAllStyles("fgColor:737475;");
        gui_btn_done.setName("btn_done");
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_btn_done);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm 0.0mm 60.0%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_done.getParent().getLayout()).setInsets(gui_btn_done, "auto 0.0mm auto auto").setReferenceComponents(gui_btn_done, "-1 0 -1 -1").setReferencePositions(gui_btn_done, "0.0 1.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_2);
        gui_Label_1.setPreferredSizeStr("15.608466mm 18.78307mm");
        gui_Label_1.setText("Press");
        gui_Label_1.setUIID("PersonalInfo_Lbl");
        gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:3.0mm; fgColor:0; alignment:left;");
        gui_Label_1.setName("Label_1");
        gui_btn_cancel.setPreferredSizeStr("22.486773mm 5.820106mm");
        gui_btn_cancel.setText("CANCEL");
        gui_btn_cancel.setUIID("btn_get_red");
        gui_btn_cancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_cancel.setInlineAllStyles("fgColor:737475;");
        gui_btn_cancel.setName("btn_cancel");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Container_2.addComponent(gui_btn_cancel);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 0.0mm 0.0mm 60.0%").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_cancel.getParent().getLayout()).setInsets(gui_btn_cancel, "auto 0.0mm auto auto").setReferenceComponents(gui_btn_cancel, "-1 0 -1 -1").setReferencePositions(gui_btn_cancel, "0.0 1.0 0.0 0.0");
        gui_Container.addComponent(gui_Label_2);
        gui_Container.addComponent(gui_Label_3);
        gui_Container.addComponent(gui_btn_close);
        gui_Container.addComponent(gui_lbl_price_no);
        gui_Container.addComponent(gui_Label_5);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 57.67196);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 11.375662);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "6.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "5 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 57.67196);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 11.375662);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_2, "2 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "-2.3841858E-7mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_2, "0 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_3, "1 -1 -1 -1").setReferencePositions(gui_Label_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_close.getParent().getLayout()).setInsets(gui_btn_close, "1.0mm 1.0mm auto auto").setReferenceComponents(gui_btn_close, "-1 -1 -1 -1").setReferencePositions(gui_btn_close, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_price_no.getParent().getLayout()).setInsets(gui_lbl_price_no, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_price_no, "6 -1 -1 -1").setReferencePositions(gui_lbl_price_no, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "20.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_5, "-1 -1 -1 -1").setReferencePositions(gui_Label_5, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
