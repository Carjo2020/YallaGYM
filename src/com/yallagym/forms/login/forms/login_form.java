package com.yallagym.forms.login.forms;

import com.cn2.ui.cn1Display;
import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.system.NativeLookup;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.animations.Transition;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.nativeCodes;

public class login_form extends BaseLogin {
    
    Resources res;
    TextField user;
    TextField pass;
    
    public login_form() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
    }
    
    public login_form(com.codename1.ui.util.Resources res) {
        user = createTextField("Username or Phone", res.getImage("mail_ic.png").scaled(56, 56));
        pass = createTextField("Password", res.getImage("lock_ic.png").scaled(56, 56));
        checkLanguage(res);
        this.res = res;
        
        installFixItems(res);
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
                new erorr(res, "Warning", "Do you want to exit from app?", "Yes", e -> {
                    Display.getInstance().exitApplication();
                }).show();
            }
        };
        this.setBackCommand(back);
     gui_lbl_logo.getAllStyles().setMarginTop(cn1Display.getScaledMax(16));
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_bg_img = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_bg_img_gray = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_logo = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_forget_pass = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_login = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_sign_up = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_con_pass = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_con_user = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_forget_pass.addActionListener(callback);
        gui_btn_login.addActionListener(callback);
        gui_btn_sign_up.addActionListener(callback);
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

            if(sourceComponent == gui_btn_forget_pass) {
                onbtn_forget_passActionEvent(ev);
            }
            if(sourceComponent == gui_btn_login) {
                onbtn_loginActionEvent(ev);
            }
            if(sourceComponent == gui_btn_sign_up) {
                onbtn_sign_upActionEvent(ev);
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
        setTitle("login_form");
        setName("login_form");
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
        gui_Container.addComponent(gui_bg_img);
        gui_Container.addComponent(gui_bg_img_gray);
        gui_Container.addComponent(gui_lbl_logo);
        gui_Container.addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("53.968254mm 7.4074073mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_btn_forget_pass.setPreferredSizeStr("34.920635mm 6.0846562mm");
        gui_btn_forget_pass.setText("Forgot password?");
        gui_btn_forget_pass.setUIID("transperent");
                gui_btn_forget_pass.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_forget_pass.setInlineAllStyles("font:2.5mm; fgColor:ffffff; alignment:right;");
        gui_btn_forget_pass.setName("btn_forget_pass");
        gui_btn_login.setPreferredSizeStr("57.67196mm 8.730159mm");
        gui_btn_login.setText("Log In");
        gui_btn_login.setUIID("login_btn");
                gui_btn_login.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_login.setInlineAllStyles("fgColor:ffffff; bgImage:btn_green.png;");
        gui_btn_login.setName("btn_login");
        gui_btn_sign_up.setPreferredSizeStr("29.89418mm 9.259259mm");
        gui_btn_sign_up.setText("Sign Up");
        gui_btn_sign_up.setUIID("login_btn");
                gui_btn_sign_up.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_sign_up.setInlineAllStyles("fgColor:0; bgImage:Book_Now_Button.png;");
        gui_btn_sign_up.setName("btn_sign_up");
        gui_con_pass.setPreferredSizeStr("81.74603mm 8.730159mm");
        gui_con_pass.setUIID("con_input");
                gui_con_pass.setInlineStylesTheme(resourceObjectInstance);
        gui_con_pass.setName("con_pass");
        gui_con_user.setPreferredSizeStr("74.07407mm 8.994709mm");
        gui_con_user.setUIID("con_input");
                gui_con_user.setInlineStylesTheme(resourceObjectInstance);
        gui_con_user.setName("con_user");
        gui_Container_1.addComponent(gui_Container_2);
        gui_Label_1.setPreferredSizeStr("26.984127mm 8.201058mm");
        gui_Label_1.setText("Login to continue");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:3.0mm; fgColor:ffffff; alignment:right; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("29.36508mm 14.285714mm");
        gui_Label_2.setText(" Yalla Gym");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:4.0mm; fgColor:ffffff; bgImage:; alignment:left; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_Label_2.setName("Label_2");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Container_2.addComponent(gui_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 40.0% 0.0mm 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 0 ").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_btn_forget_pass);
        gui_Container_1.addComponent(gui_btn_login);
        gui_Container_1.addComponent(gui_btn_sign_up);
        gui_Container_1.addComponent(gui_con_pass);
        gui_Container_1.addComponent(gui_con_user);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)53.968254);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_forget_pass.getParent().getLayout()).setInsets(gui_btn_forget_pass, "0.0mm 4.7683716E-7mm auto auto").setReferenceComponents(gui_btn_forget_pass, "4 -1 -1 -1").setReferencePositions(gui_btn_forget_pass, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_login.getParent().getLayout()).setInsets(gui_btn_login, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_login, "1 -1 -1 -1").setReferencePositions(gui_btn_login, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_sign_up.getParent().getLayout()).setInsets(gui_btn_sign_up, "2.0mm 15.0% auto 15.0%").setReferenceComponents(gui_btn_sign_up, "2 -1 -1 -1").setReferencePositions(gui_btn_sign_up, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass.getLayout()).setPreferredWidthMM((float)81.74603);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass.getLayout()).setPreferredHeightMM((float)8.730159);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_pass.getParent().getLayout()).setInsets(gui_con_pass, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_pass, "5 -1 -1 -1").setReferencePositions(gui_con_pass, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_user.getLayout()).setPreferredWidthMM((float)59.25926);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_user.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_user.getParent().getLayout()).setInsets(gui_con_user, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_user, "0 -1 -1 -1").setReferencePositions(gui_con_user, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_logo.getParent().getLayout()).setInsets(gui_lbl_logo, "7.0% auto auto auto").setReferenceComponents(gui_lbl_logo, "-1 -1 -1 -1").setReferencePositions(gui_lbl_logo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)58.46561);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)100.5291);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "2.0mm 2.6455026mm 0.0mm 3.7037039mm").setReferenceComponents(gui_Container_1, "2 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)69.04762);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)116.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!  //-- DON'T EDIT ABOVE THIS LINE!!! 
    private void installFixItems(Resources res) {
        getToolbar().setHidden(true);
        setScrollVisible(false);
        gui_lbl_logo.setPreferredH(gui_lbl_logo.getPreferredW());
        
        pass.setConstraint(TextField.PASSWORD);
        gui_con_user.add(CENTER, user);
        gui_con_pass.add(CENTER, pass);
        gui_Container.setPreferredH(cn1Display.getHeight());
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
    
    public void onbtn_loginActionEvent(com.codename1.ui.events.ActionEvent ev) {
        String userStr = formatUser(user.getText().toLowerCase());
        String passStr = pass.getText();
        if (StringUtil.replaceAll(userStr, " ", "").length() == 0 && passStr.length() == 0) {
            ToastBar.showInfoMessage("Please enter username/phone and password");
        } else if (StringUtil.replaceAll(userStr, " ", "").length() == 0 && passStr.length() != 0) {
            ToastBar.showInfoMessage("Please enter username/phone");
        } else if (StringUtil.replaceAll(userStr, " ", "").length() != 0 && passStr.length() == 0) {
            ToastBar.showInfoMessage("Please enter password");
        } else {
            if (userStr.endsWith("_yalla")) {
                checkGymLogin(res, userStr, passStr);
            } else {
                checkUserLogin(res, userStr, passStr);
                
            }
        }
    }
    
    public void onbtn_sign_upActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new signup_username(res, this).show();
    }
    
    public void onbtn_forget_passActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new activition_form_1(res, this, formatUser(user.getText())).show();
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
        setTitle("login_form");
        setName("login_form");
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
        gui_Container.addComponent(gui_bg_img);
        gui_Container.addComponent(gui_bg_img_gray);
        gui_Container.addComponent(gui_lbl_logo);
        gui_Container.addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("53.968254mm 7.4074073mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_btn_forget_pass.setPreferredSizeStr("53.968254mm 6.0846562mm");
        gui_btn_forget_pass.setText("Forgot password?");
        gui_btn_forget_pass.setUIID("transperent");
        gui_btn_forget_pass.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_forget_pass.setInlineAllStyles("font:2.5mm; fgColor:ffffff; alignment:left;");
        gui_btn_forget_pass.setName("btn_forget_pass");
        gui_btn_login.setPreferredSizeStr("57.67196mm 8.730159mm");
        gui_btn_login.setText("Log In");
        gui_btn_login.setUIID("login_btn");
        gui_btn_login.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_login.setInlineAllStyles("fgColor:ffffff; bgImage:btn_green.png;");
        gui_btn_login.setName("btn_login");
        gui_btn_sign_up.setPreferredSizeStr("29.89418mm 9.259259mm");
        gui_btn_sign_up.setText("Sign Up");
        gui_btn_sign_up.setUIID("login_btn");
        gui_btn_sign_up.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_sign_up.setInlineAllStyles("fgColor:0; bgImage:Book_Now_Button.png;");
        gui_btn_sign_up.setName("btn_sign_up");
        gui_con_pass.setPreferredSizeStr("81.74603mm 8.730159mm");
        gui_con_pass.setUIID("con_input");
        gui_con_pass.setInlineStylesTheme(resourceObjectInstance);
        gui_con_pass.setName("con_pass");
        gui_con_user.setPreferredSizeStr("74.07407mm 8.994709mm");
        gui_con_user.setUIID("con_input");
        gui_con_user.setInlineStylesTheme(resourceObjectInstance);
        gui_con_user.setName("con_user");
        gui_Container_1.addComponent(gui_Container_2);
        gui_Label_1.setPreferredSizeStr("26.984127mm 8.201058mm");
        gui_Label_1.setText("Login to continue");
        gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:3.0mm; fgColor:ffffff; alignment:left; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("29.36508mm 14.285714mm");
        gui_Label_2.setText(" Yalla Gym");
        gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:4.0mm; fgColor:ffffff; bgImage:; alignment:right; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_Label_2.setName("Label_2");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Container_2.addComponent(gui_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 0.0mm 0.0mm 40%").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 1.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Label_2, "-1 0 -1 -1").setReferencePositions(gui_Label_2, "0.0 1.0 0.0 0.0");
        gui_Container_1.addComponent(gui_btn_forget_pass);
        gui_Container_1.addComponent(gui_btn_login);
        gui_Container_1.addComponent(gui_btn_sign_up);
        gui_Container_1.addComponent(gui_con_pass);
        gui_Container_1.addComponent(gui_con_user);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 53.968254);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_forget_pass.getParent().getLayout()).setInsets(gui_btn_forget_pass, "0.0mm 4.7683716E-7mm auto 0.0mm").setReferenceComponents(gui_btn_forget_pass, "4 -1 -1 -1").setReferencePositions(gui_btn_forget_pass, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_login.getParent().getLayout()).setInsets(gui_btn_login, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_login, "1 -1 -1 -1").setReferencePositions(gui_btn_login, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_sign_up.getParent().getLayout()).setInsets(gui_btn_sign_up, "2.0mm 15.0% auto 15.0%").setReferenceComponents(gui_btn_sign_up, "2 -1 -1 -1").setReferencePositions(gui_btn_sign_up, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_pass.getLayout()).setPreferredWidthMM((float) 81.74603);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_pass.getLayout()).setPreferredHeightMM((float) 8.730159);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_pass.getParent().getLayout()).setInsets(gui_con_pass, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_pass, "5 -1 -1 -1").setReferencePositions(gui_con_pass, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_user.getLayout()).setPreferredWidthMM((float) 59.25926);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_user.getLayout()).setPreferredHeightMM((float) 8.994709);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_user.getParent().getLayout()).setInsets(gui_con_user, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_con_user, "0 -1 -1 -1").setReferencePositions(gui_con_user, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_logo.getParent().getLayout()).setInsets(gui_lbl_logo, "7.0% auto auto auto").setReferenceComponents(gui_lbl_logo, "-1 -1 -1 -1").setReferencePositions(gui_lbl_logo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 58.46561);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 100.5291);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "2.0mm 2.6455026mm 0.0mm 3.7037039mm").setReferenceComponents(gui_Container_1, "2 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 69.04762);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 116.666664);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
        user.setRTL(true);
        user.getHintLabel().setRTL(true);
        pass.setRTL(true);
        pass.getHintLabel().setRTL(true);
        
    }
    
}
