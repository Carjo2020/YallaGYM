package com.yallagym.client.dialogs;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import static com.codename1.io.Util.sleep;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.CN;
import static com.codename1.ui.CN.getCurrentForm;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.animations.Transition;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.APIs;
import com.yallagym.client.forms.client_online_payment;
import com.yallagym.client.forms.client_orders;
import com.yallagym.client.forms.list_form;
import com.yallagym.client.forms.map_form;
import com.yallagym.client.layouts.Correct_Msg;
import com.yallagym.client.forms.user_info;
import java.util.Date;
import java.util.Map;

public class pay_dialog extends com.codename1.ui.Dialog {

    APIs api = new APIs();
    private Transition defaultInTrans = CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 500);
    private Transition defaultInTrans2 = CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, false, 300);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Resources res;

    public pay_dialog() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public pay_dialog(com.codename1.ui.util.Resources res) {
        checkLanguage(res);

    }

    public pay_dialog(com.codename1.ui.util.Resources res, String id_gym, String type, String dateStart, String amount) {
        checkLanguage(res);
        this.res = res;
        this.setScrollVisible(false);
        this.setScrollable(false);
        gui_Container.setScrollVisible(false);
        gui_Container.setScrollable(false);
        this.setDialogUIID("transperent");
        this.setTitle("");
//        this.setDefaultBlurBackgroundRadius(10);
//        this.setTransitionInAnimator(CommonTransitions.createFade(1000));
        this.setTransitionInAnimator(defaultInTrans);
        this.setTransitionOutAnimator(defaultInTrans2);
        this.setMinimizeOnBack(true);
        gui_Rb_Offline.setSelected(true);
        //this.setBlurBackgroundRadius(-1);
        this.setDisposeWhenPointerOutOfBounds(true);
        new ButtonGroup(gui_Rb_Offline, gui_Rb_Online);
        gui_btn_done.addActionListener(e -> {
            if (gui_Rb_Offline.isSelected()) {
                newOfflineOrder(id_gym, type, dateStart);
            } else {
                newOnineOrder(id_gym, type, dateStart, amount);
            }
        });
    }
    Dialog dlg;
//////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_done = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.components.SpanButton gui_Span_Button = new com.codename1.components.SpanButton();
    protected com.codename1.ui.Button gui_btn_cancel = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.RadioButton gui_Rb_Online = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Rb_Offline = new com.codename1.ui.RadioButton();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_cancel.addActionListener(callback);
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

            if(sourceComponent == gui_btn_cancel) {
                onbtn_cancelActionEvent(ev);
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
        setTitle("pay_dialog");
        setName("pay_dialog");
        gui_Container.setPreferredSizeStr("75.66138mm 36.243385mm");
        gui_Container.setUIID("Home_Show_More_Dialog");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_btn_done.setPreferredSizeStr("19.31217mm 6.878307mm");
        gui_btn_done.setText("Continue");
        gui_btn_done.setUIID("club_payments_pay_green_btn");
                gui_btn_done.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_done.setName("btn_done");
        gui_Label.setPreferredSizeStr("55.820107mm 6.3492064mm");
        gui_Label.setText("Choose payment method");
        gui_Label.setUIID("PersonalInfo_Lbl_AR");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:3.5mm; fgColor:a3cc2e; alignment:center; padding:0px 0px 0px 0px;");
        gui_Label.setName("Label");
        gui_Label_4.setPreferredSizeStr("41.00529mm 5.026455mm");
        gui_Label_4.setText("Airport Surcharge");
        gui_Label_4.setUIID("Home_Show_More_Dialog_Lbls");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setName("Label_4");
        gui_Span_Button.setPreferredSizeStr("32.27513mm 15.608466mm");
        gui_Span_Button.setText("Fuel Policy Same to Same");
        gui_Span_Button.setUIID("Home_Show_More_Dialog_Lbls");
                gui_Span_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Button.setName("Span_Button");
        gui_Span_Button.setPropertyValue("textUiid", "Home_Show_More_Dialog_Lbls");
        gui_btn_cancel.setPreferredSizeStr("19.31217mm 6.878307mm");
        gui_btn_cancel.setText("Cancel");
        gui_btn_cancel.setUIID("club_payments_pay_red_btn");
                gui_btn_cancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_cancel.setName("btn_cancel");
        gui_Container_1.setPreferredSizeStr("58.73016mm 14.285714mm");
        gui_Container_1.setUIID("club_qr_con_first");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_btn_done);
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_Label_4);
        gui_Container.addComponent(gui_Span_Button);
        gui_Container.addComponent(gui_btn_cancel);
        gui_Container.addComponent(gui_Container_1);
        gui_Rb_Online.setPreferredSizeStr("57.67196mm 8.730159mm");
        gui_Rb_Online.setText("Online payment");
        gui_Rb_Online.setUIID("radio_btn_green_bold");
                gui_Rb_Online.setInlineStylesTheme(resourceObjectInstance);
        gui_Rb_Online.setInlineAllStyles("bgImage:;");
        gui_Rb_Online.setGroup("");
        gui_Rb_Online.setName("Rb_Online");
        gui_Rb_Offline.setPreferredSizeStr("60.05291mm inherit");
        gui_Rb_Offline.setText("Pay at  gym");
        gui_Rb_Offline.setUIID("radio_btn_green_bold");
                gui_Rb_Offline.setInlineStylesTheme(resourceObjectInstance);
        gui_Rb_Offline.setGroup("");
        gui_Rb_Offline.setName("Rb_Offline");
        gui_Container_1.addComponent(gui_Rb_Online);
        gui_Container_1.addComponent(gui_Rb_Offline);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Rb_Online.getParent().getLayout()).setInsets(gui_Rb_Online, "0.0mm 0.0mm 0.0mm 10.0%").setReferenceComponents(gui_Rb_Online, "1 -1 -1 -1").setReferencePositions(gui_Rb_Online, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Rb_Offline.getParent().getLayout()).setInsets(gui_Rb_Offline, "0.0mm 0.0mm 50.0% 10.0%").setReferenceComponents(gui_Rb_Offline, "-1 -1 -1 -1").setReferencePositions(gui_Rb_Offline, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_done.getParent().getLayout()).setInsets(gui_btn_done, "auto 0.0mm -4.7683716E-7mm auto").setReferenceComponents(gui_btn_done, "-1 -1 -1 -1").setReferencePositions(gui_btn_done, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "1.1920929E-7mm 0.0mm 80.344826% 0.0mm").setReferenceComponents(gui_Label_4, "-1 -1 -1 -1").setReferencePositions(gui_Label_4, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Button.getParent().getLayout()).setInsets(gui_Span_Button, "0.0mm -4.7683716E-7mm 0.0mm 0.0mm").setReferenceComponents(gui_Span_Button, "2 -1 0 -1").setReferencePositions(gui_Span_Button, "1.0 0.0 1.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_cancel.getParent().getLayout()).setInsets(gui_btn_cancel, "auto auto -5.364418E-7mm 0.0mm").setReferenceComponents(gui_btn_cancel, "-1 -1 -1 -1").setReferencePositions(gui_btn_cancel, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)55.291004);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)14.285714);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 2.0mm 0.0mm").setReferenceComponents(gui_Container_1, "1 -1 4 -1").setReferencePositions(gui_Container_1, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)60.05291);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)36.243385);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onbtn_cancelActionEvent(com.codename1.ui.events.ActionEvent ev) {
        dispose();
//        api.getOrdersCount();
    }

    private void newOfflineOrder(String id_gym, String type, String dateStart) {
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        String username = Preferences.get("username", "null");
        String date_order = dateFormat.format(new Date());

        api.createOfflineOrder(username, StringUtil.replaceFirst(id_gym, ".0", ""), date_order, type, dateStart);
        dlg.dispose();
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
            }
        };
//        CN.getCurrentForm().setBackCommand(back);
//        this.setBackCommand(back);
        String msg = "";
        if (type.equals("price_d")) {
            msg = "Thank you for your submit, we will contact you within 5 min.";
        } else if (type.equals("price_w")) {
            msg = "Thank you for your submit, we will contact you within a few 24 hours.";
        } else {
            msg = "Thank you for your submit, we will contact you within a few 48 hours.";
        }
        this.dispose();
        Dialog dlg_correct_Msg = new Correct_Msg(res, "Sent successfully", msg, e -> {
            new client_orders(res, new list_form(res)).show();
        });
        dlg_correct_Msg.setDisposeWhenPointerOutOfBounds(false);
        dlg_correct_Msg.show();

    }

    private void newOnineOrder(String id_gym, String type, String dateStart, String amount) {
        ToastBar.showInfoMessage("This payment method will add in coming soon");
//        InfiniteProgress prog = new InfiniteProgress();
//        Dialog dlg = prog.showInfiniteBlocking();
//        Map<String, Object> map = api.createPaymentSession();
//        sleep(500);
//        String idSession = map.get("session") + "";
//        String idUnique = map.get("unique") + "";
//        dlg.dispose();
//        new client_online_payment(res, getCurrentForm(), id_gym, type, dateStart, idSession, idUnique, amount).show();
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
        setTitle("pay_dialog");
        setName("pay_dialog");
        gui_Container.setPreferredSizeStr("75.66138mm 35.714287mm");
        gui_Container.setUIID("Home_Show_More_Dialog");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_btn_done.setPreferredSizeStr("19.31217mm 6.878307mm");
        gui_btn_done.setText("Continue");
        gui_btn_done.setUIID("club_payments_pay_green_btn");
        gui_btn_done.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_done.setName("btn_done");
        gui_Label.setPreferredSizeStr("55.820107mm 6.3492064mm");
        gui_Label.setText("Choose payment method");
        gui_Label.setUIID("PersonalInfo_Lbl_AR");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:3.5mm; fgColor:a3cc2e; alignment:center; padding:0px 0px 0px 0px;");
        gui_Label.setName("Label");
        gui_btn_cancel.setPreferredSizeStr("19.31217mm 6.878307mm");
        gui_btn_cancel.setText("Cancel");
        gui_btn_cancel.setUIID("club_payments_pay_red_btn");
        gui_btn_cancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_cancel.setName("btn_cancel");
        gui_Container_1.setPreferredSizeStr("58.73016mm 14.285714mm");
        gui_Container_1.setUIID("club_qr_con_first");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_btn_done);
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_btn_cancel);
        gui_Container.addComponent(gui_Container_1);
        gui_Rb_Online.setPreferredSizeStr("57.67196mm 6.878307mm");
        gui_Rb_Online.setRTL(true);
        gui_Rb_Online.setText("Online payment");
        gui_Rb_Online.setUIID("radio_btn_green_bold");
        gui_Rb_Online.setInlineStylesTheme(resourceObjectInstance);
        gui_Rb_Online.setInlineAllStyles("bgImage:;");
        gui_Rb_Online.setGroup("");
        gui_Rb_Online.setName("Rb_Online");
        gui_Rb_Offline.setPreferredSizeStr("60.05291mm inherit");
        gui_Rb_Offline.setRTL(true);
        gui_Rb_Offline.setText("Pay at gym");
        gui_Rb_Offline.setUIID("radio_btn_green_bold");
        gui_Rb_Offline.setInlineStylesTheme(resourceObjectInstance);
        gui_Rb_Offline.setGroup("");
        gui_Rb_Offline.setName("Rb_Offline");
        gui_Container_1.addComponent(gui_Rb_Online);
        gui_Container_1.addComponent(gui_Rb_Offline);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Rb_Online.getParent().getLayout()).setInsets(gui_Rb_Online, "-5.364418E-7mm 10.0% 0.0mm 0.0mm").setReferenceComponents(gui_Rb_Online, "1 -1 -1 -1").setReferencePositions(gui_Rb_Online, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Rb_Offline.getParent().getLayout()).setInsets(gui_Rb_Offline, "0.0mm 10.0% 50.0% 0.0mm").setReferenceComponents(gui_Rb_Offline, "-1 -1 -1 -1").setReferencePositions(gui_Rb_Offline, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_done.getParent().getLayout()).setInsets(gui_btn_done, "auto auto -4.7683716E-7mm 2.0mm").setReferenceComponents(gui_btn_done, "-1 -1 -1 -1").setReferencePositions(gui_btn_done, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_cancel.getParent().getLayout()).setInsets(gui_btn_cancel, "auto 2.0mm -5.364418E-7mm auto").setReferenceComponents(gui_btn_cancel, "-1 -1 -1 -1").setReferencePositions(gui_btn_cancel, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 55.291004);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 14.285714);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 2.0mm 0.0mm").setReferenceComponents(gui_Container_1, "1 -1 2 -1").setReferencePositions(gui_Container_1, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 56.084656);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 35.714287);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
