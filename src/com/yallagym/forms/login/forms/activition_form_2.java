package com.yallagym.forms.login.forms;

import com.cn2.ui.cn1Display;
import com.codename1.components.ToastBar;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.BaseForm;

public class activition_form_2 extends BaseLogin {

    Resources res;
    TextField user;
    Form frm;
    String username;
    String code;

    public activition_form_2() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public activition_form_2(com.codename1.ui.util.Resources res) {
        checkLanguage(res);
        this.res = res;
        installFixItems();
    }

    public activition_form_2(Resources res, Form frm, String username, String code) {
        user = createTextField("code 4-digit", res.getImage("mail_ic.png").scaled(56, 56));
        checkLanguage(res);
        this.res = res;
        this.frm = frm;
        this.code = code;
        this.username = username;
        installBackCommand(frm);
        installFixItems();
     if (!BaseForm.isAndroid()) {
                   gui_btn_back.getAllStyles().setMarginTop(cn1Display.getScaledMax(30));
            gui_lbl_logo.getAllStyles().setMarginTop(cn1Display.getScaledMax(16));
        }
    }
//////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_bg_img = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_bg_img_gray = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_logo = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.components.SpanLabel gui_sb_msg = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Button gui_btn_continue = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_con_user = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_phone_no = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_back = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_continue.addActionListener(callback);
        gui_btn_back.addActionListener(callback);
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

            if(sourceComponent == gui_btn_continue) {
                onbtn_continueActionEvent(ev);
            }
            if(sourceComponent == gui_btn_back) {
                onbtn_backActionEvent(ev);
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
        setTitle("activition_form_2");
        setName("activition_form_2");
        gui_Container.setPreferredSizeStr("inherit 116.666664mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
                gui_bg_img.setInlineStylesTheme(resourceObjectInstance);
        gui_bg_img.setInlineAllStyles("bgImage:background-image.png;");
        gui_bg_img.setName("bg_img");
        gui_bg_img_gray.setPreferredSizeStr("123.544975mm 138.62434mm");
                gui_bg_img_gray.setInlineStylesTheme(resourceObjectInstance);
        gui_bg_img_gray.setInlineAllStyles("bgImage:dark-layer.png;");
        gui_bg_img_gray.setName("bg_img_gray");
        gui_lbl_logo.setPreferredSizeStr("28.042328mm 23.809525mm");
                gui_lbl_logo.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_logo.setInlineAllStyles("bgImage:logo.png;");
        gui_lbl_logo.setName("lbl_logo");
        gui_Container_1.setPreferredSizeStr("58.46561mm 100.5291mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_btn_back.setPreferredSizeStr("10.8465605mm 8.465609mm");
        gui_btn_back.setUIID("login_btn");
                gui_btn_back.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_back.setName("btn_back");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_back,"\ue5c4".charAt(0));
        gui_Container.addComponent(gui_bg_img);
        gui_Container.addComponent(gui_bg_img_gray);
        gui_Container.addComponent(gui_lbl_logo);
        gui_Container.addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("43.915344mm 19.57672mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_btn_continue.setPreferredSizeStr("57.67196mm 7.6719575mm");
        gui_btn_continue.setText("CONTINUE");
        gui_btn_continue.setUIID("login_btn");
                gui_btn_continue.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_continue.setInlineAllStyles("fgColor:ffffff; bgImage:btn_green.png;");
        gui_btn_continue.setName("btn_continue");
        gui_con_user.setPreferredSizeStr("74.07407mm 8.994709mm");
        gui_con_user.setUIID("con_input");
                gui_con_user.setInlineStylesTheme(resourceObjectInstance);
        gui_con_user.setName("con_user");
        gui_Label.setPreferredSizeStr("35.185184mm 7.4074073mm");
        gui_Label.setText("Forget password");
        gui_Label.setUIID("lbl_white");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_lbl_phone_no.setPreferredSizeStr("84.92064mm 4.4973545mm");
        gui_lbl_phone_no.setUIID("sb_center_white");
                gui_lbl_phone_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_phone_no.setName("lbl_phone_no");
        gui_Container_1.addComponent(gui_Container_2);
        gui_sb_msg.setPreferredSizeStr("55.555557mm 11.640212mm");
        gui_sb_msg.setText("Enter email or phone ,we will send you a code that can use to login");
                gui_sb_msg.setInlineStylesTheme(resourceObjectInstance);
        gui_sb_msg.setName("sb_msg");
        gui_sb_msg.setPropertyValue("textUiid", "sb_center_white");
        gui_Container_2.addComponent(gui_sb_msg);
        ((com.codename1.ui.layouts.LayeredLayout)gui_sb_msg.getParent().getLayout()).setInsets(gui_sb_msg, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_sb_msg, "-1 -1 -1 -1").setReferencePositions(gui_sb_msg, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_btn_continue);
        gui_Container_1.addComponent(gui_con_user);
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_lbl_phone_no);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)57.40741);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)19.57672);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 10.0% auto 10.0%").setReferenceComponents(gui_Container_2, "3 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_continue.getParent().getLayout()).setInsets(gui_btn_continue, "3.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_continue, "2 -1 -1 -1").setReferencePositions(gui_btn_continue, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_user.getLayout()).setPreferredWidthMM((float)59.25926);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_user.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_user.getParent().getLayout()).setInsets(gui_con_user, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_user, "4 -1 -1 -1").setReferencePositions(gui_con_user, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "2.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_phone_no.getParent().getLayout()).setInsets(gui_lbl_phone_no, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_phone_no, "0 -1 -1 -1").setReferencePositions(gui_lbl_phone_no, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_btn_back);
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_logo.getParent().getLayout()).setInsets(gui_lbl_logo, "7.0% auto auto auto").setReferenceComponents(gui_lbl_logo, "-1 -1 -1 -1").setReferencePositions(gui_lbl_logo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)58.46561);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)100.5291);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "2.0mm 2.6455026mm 0.0mm 3.7037039mm").setReferenceComponents(gui_Container_1, "2 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_back.getParent().getLayout()).setInsets(gui_btn_back, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_btn_back, "-1 -1 -1 -1").setReferencePositions(gui_btn_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)69.04762);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)116.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!THIS LINE!!!
    public void onbtn_continueActionEvent(com.codename1.ui.events.ActionEvent ev) {
        String text = user.getText();
        if (!text.equals("")) {
            if (text.equals(code)) {
                new activation_form_3(res, formatUser(username)).show();
            } else {
                ToastBar.showInfoMessage("The entered code is not correct");
            }

        } else {
            ToastBar.showInfoMessage("Please enter code numbers");
        }
    }

    public TextField createTextField(String hint, Image hint_icon) {
        TextField tf = new TextField("", "    " + hint);
        tf.setUIID("Activation_Input");
        tf.setScrollVisible(false);
        tf.getHintLabel().setIcon(hint_icon);
        tf.getHintLabel().getAllStyles().setPaddingLeft(2.5f);
        tf.setRows(1);
        tf.setSmoothScrolling(false);
        return tf;
    }

    private void installFixItems() {
        getToolbar().setHidden(true);
        setScrollVisible(false);
        gui_lbl_logo.setPreferredH(gui_lbl_logo.getPreferredW());
        gui_con_user.add(CENTER, user);
        gui_Container.setPreferredH(cn1Display.getHeight());
        gui_sb_msg.setText("Enter the 4-digit code sent to you at");
        gui_lbl_phone_no.setText(username);
    }

    public void onbtn_backActionEvent(com.codename1.ui.events.ActionEvent ev) {
        frm.show();
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
        setTitle("activition_form_2");
        setName("activition_form_2");
        gui_Container.setPreferredSizeStr("inherit 116.666664mm");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_bg_img.setInlineStylesTheme(resourceObjectInstance);
        gui_bg_img.setInlineAllStyles("bgImage:background-image.png;");
        gui_bg_img.setName("bg_img");
        gui_bg_img_gray.setPreferredSizeStr("123.544975mm 138.62434mm");
        gui_bg_img_gray.setInlineStylesTheme(resourceObjectInstance);
        gui_bg_img_gray.setInlineAllStyles("bgImage:dark-layer.png;");
        gui_bg_img_gray.setName("bg_img_gray");
        gui_lbl_logo.setPreferredSizeStr("28.042328mm 23.809525mm");
        gui_lbl_logo.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_logo.setInlineAllStyles("bgImage:logo.png;");
        gui_lbl_logo.setName("lbl_logo");
        gui_Container_1.setPreferredSizeStr("58.46561mm 100.5291mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_btn_back.setPreferredSizeStr("10.8465605mm 8.465609mm");
        gui_btn_back.setUIID("login_btn");
        gui_btn_back.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_back.setName("btn_back");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_back, "\ue5c4".charAt(0));
        gui_Container.addComponent(gui_bg_img);
        gui_Container.addComponent(gui_bg_img_gray);
        gui_Container.addComponent(gui_lbl_logo);
        gui_Container.addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("43.915344mm 12.1693125mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_btn_continue.setPreferredSizeStr("57.67196mm 7.6719575mm");
        gui_btn_continue.setText("CONTINUE");
        gui_btn_continue.setUIID("login_btn");
        gui_btn_continue.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_continue.setInlineAllStyles("fgColor:ffffff; bgImage:btn_green.png;");
        gui_btn_continue.setName("btn_continue");
        gui_con_user.setPreferredSizeStr("74.07407mm 8.994709mm");
        gui_con_user.setUIID("con_input");
        gui_con_user.setInlineStylesTheme(resourceObjectInstance);
        gui_con_user.setName("con_user");
        gui_Label.setPreferredSizeStr("35.185184mm 7.4074073mm");
        gui_Label.setText("Forget password");
        gui_Label.setUIID("lbl_white");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_lbl_phone_no.setPreferredSizeStr("84.92064mm 4.4973545mm");
        gui_lbl_phone_no.setText("");
        gui_lbl_phone_no.setUIID("sb_center_white");
        gui_lbl_phone_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_phone_no.setName("lbl_phone_no");
        gui_Container_1.addComponent(gui_Container_2);
        gui_sb_msg.setPreferredSizeStr("55.555557mm 11.640212mm");
        gui_sb_msg.setText("Enter email or phone ,we will send you a code that can use to login");
        gui_sb_msg.setInlineStylesTheme(resourceObjectInstance);
        gui_sb_msg.setName("sb_msg");
        gui_sb_msg.setPropertyValue("textUiid", "sb_center_white");
        gui_Container_2.addComponent(gui_sb_msg);
        ((com.codename1.ui.layouts.LayeredLayout) gui_sb_msg.getParent().getLayout()).setInsets(gui_sb_msg, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_sb_msg, "-1 -1 -1 -1").setReferencePositions(gui_sb_msg, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_btn_continue);
        gui_Container_1.addComponent(gui_con_user);
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_lbl_phone_no);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 57.40741);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 12.1693125);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 10.0% auto 10.0%").setReferenceComponents(gui_Container_2, "3 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_continue.getParent().getLayout()).setInsets(gui_btn_continue, "3.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_continue, "2 -1 -1 -1").setReferencePositions(gui_btn_continue, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_user.getLayout()).setPreferredWidthMM((float) 59.25926);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_user.getLayout()).setPreferredHeightMM((float) 8.994709);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_user.getParent().getLayout()).setInsets(gui_con_user, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_user, "4 -1 -1 -1").setReferencePositions(gui_con_user, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "2.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_phone_no.getParent().getLayout()).setInsets(gui_lbl_phone_no, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_phone_no, "0 -1 -1 -1").setReferencePositions(gui_lbl_phone_no, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_btn_back);
        ((com.codename1.ui.layouts.LayeredLayout) gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_logo.getParent().getLayout()).setInsets(gui_lbl_logo, "7.0% auto auto auto").setReferenceComponents(gui_lbl_logo, "-1 -1 -1 -1").setReferencePositions(gui_lbl_logo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 58.46561);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 100.5291);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "2.0mm 2.6455026mm 0.0mm 3.7037039mm").setReferenceComponents(gui_Container_1, "2 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_back.getParent().getLayout()).setInsets(gui_btn_back, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_btn_back, "-1 -1 -1 -1").setReferencePositions(gui_btn_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 69.04762);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 116.666664);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
        user.setRTL(true);
        user.getHintLabel().setRTL(true);
    }
}
