package com.yallagym.forms.login.forms;

import com.cn2.ui.cn1Display;
import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.client.forms.list_form;
import com.yallagym.client.forms.Splash;

public class signup_password extends BaseLogin {

    Resources res;
    Form frm;
    TextField pass;
    TextField pass_confirm;
    APIs api = new APIs();
    String first_name;
    String last_name;
    String username;
    String phone;
    String date;
    String type;
    String address;

    public signup_password() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public signup_password(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }

    public signup_password(com.codename1.ui.util.Resources res, Form frm, String first_name, String last_name, String username, String phone, String date, String type, String address) {
        pass = createTextField("New Password", res.getImage("lock_ic.png").scaled(56, 56));
        pass_confirm = createTextField("Confirm password", res.getImage("lock_ic.png").scaled(56, 56));
        initGuiBuilderComponents(res);
        if (com.yallagym.BaseForm.isArabic()) {
            setRTLCmb(res);
        }
        this.res = res;
        this.frm = frm;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.phone = phone;
        this.date = date;
        this.type = type;
        this.address = address;
        installBackCommand(frm);
        installFixItems();
        if (!BaseForm.isAndroid()) {
            gui_btn_back.getAllStyles().setMarginTop(cn1Display.getScaledMax(16));
            gui_lbl_logo.getAllStyles().setMarginTop(cn1Display.getScaledMax(16));
        }
    }
//////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_bg_img = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_bg_img_gray = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_logo = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_con_msg = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.components.SpanLabel gui_sb_msg = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Button gui_btn_submit = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_con_pass = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_title = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_con_pass_confirm = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_back = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_submit.addActionListener(callback);
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

            if(sourceComponent == gui_btn_submit) {
                onbtn_submitActionEvent(ev);
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
        setTitle("signup_password");
        setName("signup_password");
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
        gui_con_msg.setPreferredSizeStr("48.148148mm 14.285714mm");
                gui_con_msg.setInlineStylesTheme(resourceObjectInstance);
        gui_con_msg.setName("con_msg");
        gui_btn_submit.setPreferredSizeStr("57.67196mm 7.6719575mm");
        gui_btn_submit.setText("Submit");
        gui_btn_submit.setUIID("login_btn");
                gui_btn_submit.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_submit.setInlineAllStyles("fgColor:ffffff; bgImage:btn_green.png;");
        gui_btn_submit.setName("btn_submit");
        gui_con_pass.setPreferredSizeStr("74.07407mm 8.994709mm");
        gui_con_pass.setUIID("con_input");
                gui_con_pass.setInlineStylesTheme(resourceObjectInstance);
        gui_con_pass.setName("con_pass");
        gui_lbl_title.setPreferredSizeStr("35.449738mm inherit");
        gui_lbl_title.setText("Sign up");
        gui_lbl_title.setUIID("lbl_white");
                gui_lbl_title.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_title.setName("lbl_title");
        gui_con_pass_confirm.setPreferredSizeStr("74.07407mm 8.994709mm");
        gui_con_pass_confirm.setUIID("con_input");
                gui_con_pass_confirm.setInlineStylesTheme(resourceObjectInstance);
        gui_con_pass_confirm.setName("con_pass_confirm");
        gui_Container_1.addComponent(gui_con_msg);
        gui_sb_msg.setPreferredSizeStr("43.915344mm 7.936508mm");
        gui_sb_msg.setText("Please enter password and confirm password");
                gui_sb_msg.setInlineStylesTheme(resourceObjectInstance);
        gui_sb_msg.setName("sb_msg");
        gui_sb_msg.setPropertyValue("textUiid", "sb_center_white");
        gui_con_msg.addComponent(gui_sb_msg);
        ((com.codename1.ui.layouts.LayeredLayout)gui_sb_msg.getParent().getLayout()).setInsets(gui_sb_msg, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_sb_msg, "-1 -1 -1 -1").setReferencePositions(gui_sb_msg, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_btn_submit);
        gui_Container_1.addComponent(gui_con_pass);
        gui_Container_1.addComponent(gui_lbl_title);
        gui_Container_1.addComponent(gui_con_pass_confirm);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_msg.getLayout()).setPreferredWidthMM((float)47.089947);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_msg.getLayout()).setPreferredHeightMM((float)14.285714);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_msg.getParent().getLayout()).setInsets(gui_con_msg, "1.0mm 10.0% auto 10.0%").setReferenceComponents(gui_con_msg, "3 -1 -1 -1").setReferencePositions(gui_con_msg, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_submit.getParent().getLayout()).setInsets(gui_btn_submit, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_submit, "4 -1 -1 -1").setReferencePositions(gui_btn_submit, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass.getLayout()).setPreferredWidthMM((float)59.25926);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass.getParent().getLayout()).setInsets(gui_con_pass, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_pass, "0 -1 -1 -1").setReferencePositions(gui_con_pass, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_title.getParent().getLayout()).setInsets(gui_lbl_title, "2.0mm auto auto auto").setReferenceComponents(gui_lbl_title, "-1 -1 -1 -1").setReferencePositions(gui_lbl_title, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass_confirm.getLayout()).setPreferredWidthMM((float)59.25926);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass_confirm.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass_confirm.getParent().getLayout()).setInsets(gui_con_pass_confirm, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_pass_confirm, "2 -1 -1 -1").setReferencePositions(gui_con_pass_confirm, "1.0 0.0 0.0 0.0");
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

//-- DON'T EDIT ABOVE THIS LINE!!!  //-- DON'T EDIT ABOVE THIS LINE!!!       
    private void installFixItems() {
        getToolbar().setHidden(true);
        setScrollVisible(false);
        gui_lbl_logo.setPreferredH(gui_lbl_logo.getPreferredW());

        gui_con_pass.add(CENTER, pass);
        gui_con_pass_confirm.add(CENTER, pass_confirm);
        gui_Container.setPreferredH(cn1Display.getHeight());
//        gui_sb_msg.setText("Enter the 4-digit code sent to you at\n");
    }

    public TextField createTextField(String hint, Image hint_icon) {
        TextField tf = new TextField("", "    " + hint);
        tf.setUIID("Activation_Input");
        tf.setScrollVisible(false);
        tf.getHintLabel().setIcon(hint_icon);
        tf.getHintLabel().getAllStyles().setPaddingLeft(2.5f);
        tf.setRows(1);
        tf.setSmoothScrolling(false);
        tf.setConstraint(TextField.PASSWORD);
        return tf;
    }

    public void onbtn_backActionEvent(com.codename1.ui.events.ActionEvent ev) {
        frm.show();
    }

    public void onbtn_submitActionEvent(com.codename1.ui.events.ActionEvent ev) {
        String password = this.pass.getText();
        String password_confirm = this.pass_confirm.getText();
        if (password.equals(password_confirm)) {
            if (password.length() >= 6) {
                if (!password.contains(" ") && !password.contains("'") && !password.contains("\"") && !password.contains("/") && !password.contains("\\") && !password.contains(".")) {
                    boolean request = api.addUser(first_name, last_name, phone, date, type, address, username, password);
                    if (request) {
                        Preferences.set("username", username);
                        Preferences.set("password", password);
                        new Splash(res).show();
                    } else {
                    }
                } else {
                    ToastBar.showInfoMessage("Password should not have spaces or some of special chars like: '  \"  \\ .etc");
                }
            } else {
                ToastBar.showInfoMessage("Passwords must be at least 6 characters long");
            }
        } else {
            ToastBar.showInfoMessage("Password and confirm password does not match");
        }
    }

    private void setRTLCmb(Resources res) {

        pass.setRTL(true);
        pass.getHintLabel().setRTL(true);
        pass_confirm.setRTL(true);
        pass_confirm.getHintLabel().setRTL(true);
    }
}
