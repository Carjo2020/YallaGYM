package com.yallagym.login.sms;

import com.cn2.io.cn1ConnectionRequest;
import com.cn2.util.cn1String;
import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.io.Preferences;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;
import com.codename1.util.StringUtil;
import com.yallagym.APIs;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.forms.login.forms.BaseLogin;
import com.yallagym.forms.login.forms.login_form;
import java.util.Map;
import java.util.Random;

public class Activation_Form_2 extends BaseLogin {

    Resources res;
    String verificationValue;
    private int codeDigits = 4;

    Form current;
    boolean isFromSignUp = false;
    APIs api = new APIs();

    public Activation_Form_2() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public Activation_Form_2(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    public Activation_Form_2(com.codename1.ui.util.Resources res, Form frm) {
        checkLanguage(res);
        this.res = res;
        current = this;
        installBackCommand(frm);
        sethideToolbar();
        setEditOnShow(gui_tf_number);
        gui_tf_number.setConstraint(TextField.PHONENUMBER);
        String phonePref = Preferences.get("phone", "null");
        if (!phonePref.equals("null")) {
            gui_tf_number.setText(phonePref);
        }
        gui_btn_back.addActionListener(e -> {
            frm.show();
        });

        gui_btn_send_sms.addActionListener(e -> {
            String phone = formatPhone(gui_tf_number.getText());
            String correct_phone = StringUtil.replaceFirst(phone, "+962", "");
            Random r = new Random();
            String val = "";
            for (int iter = 0; iter < codeDigits; iter++) {
                val += r.nextInt(10);
            }
            verificationValue = val;
            sendSmsAsync("+962" + correct_phone, val);

        });
    }
//Form frm;

    public Activation_Form_2(com.codename1.ui.util.Resources res, Form frm, boolean isFromSignUp) {
        checkLanguage(res);
        this.res = res;
//           this.frm = frm;
        current = this;
        installBackCommand(frm);
        this.isFromSignUp = isFromSignUp;
        sethideToolbar();
        setEditOnShow(gui_tf_number);
        gui_tf_number.setConstraint(TextField.PHONENUMBER);
        String phonePref = Preferences.get("phone", "null");
        if (!phonePref.equals("null")) {
            gui_tf_number.setText(phonePref);
        }
        gui_btn_back.addActionListener(e -> {
            if (isFromSignUp) {
                new erorr(res, "Warning", "Do you want to return to the login page?", "Yes", ee -> {
                    frm.show();
                }).show();
            } else {
                frm.show();
            }
        });

        gui_btn_send_sms.addActionListener(e -> {
            String phone = formatPhone(gui_tf_number.getText());
            Random r = new Random();
            String val = "";
            for (int iter = 0; iter < codeDigits; iter++) {
                val += r.nextInt(10);
            }
//            verificationValue = val;
            if (isFromSignUp) {
                sendSmsAsync(phone, val);
            } else {
                if (api.isUser(phone).equals("0")) {
                    sendSmsAsync(phone, val);
                } else {
                    ToastBar.showErrorMessage("This Phone is already taken");
                }
            }

        });

        if (isFromSignUp) {
            if (!com.yallagym.BaseForm.isArabic()) {
                new erorr_msg(res, "Verify phone number", "Before login, please verify your phone number", "ok", null).show();
            } else {
                new erorr_msg(res, "اكمال تحقق من رقم الهاتف", "قبل تسجيل الدخول, نحتاج للتحقق من رقم الهاتف", "حسنا", null).show();
            }
        }
    }

////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.TextField gui_tf_number = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_send_sms = new com.codename1.ui.Button();
    protected com.codename1.components.SpanLabel gui_Span_Label = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Button gui_btn_back = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:ffffff; transparency:255;");
        setTitle("Activation_Form_2");
        setName("Activation_Form_2");
        gui_Container.setPreferredSizeStr("104.49735mm 123.809525mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_2.setPreferredSizeStr("96.296295mm 20.10582mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("bgColor:ffffff; transparency:255; opacity:255;");
        gui_Container_2.setName("Container_2");
        gui_Container_4.setPreferredSizeStr("inherit 21.693121mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_btn_back.setPreferredSizeStr("6.6137567mm 9.259259mm");
        gui_btn_back.setText("");
                gui_btn_back.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_back.setName("btn_back");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_back,"\ue5c4".charAt(0));
        gui_Container.addComponent(gui_Container_2);
        gui_Container_1.setPreferredSizeStr("66.137566mm 8.201058mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Label_2.setPreferredSizeStr("47.354496mm 7.6719575mm");
        gui_Label_2.setText("Please enter your mobile number");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_Container_2.addComponent(gui_Container_1);
        gui_tf_number.setPreferredSizeStr("48.148148mm 4.7619047mm");
        gui_tf_number.setHint("0790123456");
        gui_tf_number.setUIID("Activation_Input_Under_Line");
                gui_tf_number.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_number.setName("tf_number");
        gui_Container_1_1.setPreferredSizeStr("17.989418mm 7.142857mm");
                gui_Container_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1_1.setName("Container_1_1");
        gui_Container_1.addComponent(gui_tf_number);
        gui_Container_1.addComponent(gui_Container_1_1);
        gui_Label.setPreferredSizeStr("5.820106mm 3.968254mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:flag-jordan.png;");
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("9.259259mm inherit");
        gui_Label_1.setText("+962");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("fgColor:0; opacity:255;");
        gui_Label_1.setName("Label_1");
        gui_Container_1_1.addComponent(gui_Label);
        gui_Container_1_1.addComponent(gui_Label_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto auto -5.9604645E-8mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "auto 0.0mm auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_number.getParent().getLayout()).setInsets(gui_tf_number, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_tf_number, "-1 -1 -1 1 ").setReferencePositions(gui_tf_number, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getLayout()).setPreferredWidthMM((float)17.989418);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getLayout()).setPreferredHeightMM((float)7.142857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getParent().getLayout()).setInsets(gui_Container_1_1, "auto auto auto 0.2645502mm").setReferenceComponents(gui_Container_1_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1_1, "0.0 0.0 0.0 0.0");
        gui_Container_2.addComponent(gui_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)86.772484);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)8.201058);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 4.7619047mm auto 4.7619047mm").setReferenceComponents(gui_Container_1, "1 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 4.7619047mm auto 4.7619047mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_4);
        gui_Container_3.setPreferredSizeStr("28.571428mm 34.126984mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Span_Label.setPreferredSizeStr("67.19577mm 26.455027mm");
        gui_Span_Label.setText("By continuing you may receive an SMS for verification. Message and data rates may apply.");
                gui_Span_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label.setName("Span_Label");
        gui_Container_4.addComponent(gui_Container_3);
        gui_btn_send_sms.setPreferredSizeStr("8.994709mm 7.936508mm");
        gui_btn_send_sms.setText("");
        gui_btn_send_sms.setUIID("ic_fab");
                gui_btn_send_sms.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_send_sms.setName("btn_send_sms");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_send_sms,"\ue5c8".charAt(0));
        gui_Container_3.addComponent(gui_btn_send_sms);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_send_sms.getParent().getLayout()).setInsets(gui_btn_send_sms, "auto auto auto auto").setReferenceComponents(gui_btn_send_sms, "-1 -1 -1 -1").setReferencePositions(gui_btn_send_sms, "0.0 0.0 0.0 0.0");
        gui_Container_4.addComponent(gui_Span_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)28.571428);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)31.481482);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 0.0mm 0.0mm 70.0%").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Label.getParent().getLayout()).setInsets(gui_Span_Label, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Span_Label, "-1 0 -1 -1").setReferencePositions(gui_Span_Label, "0.0 1.0 0.0 0.0");
        gui_Container.addComponent(gui_btn_back);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)96.296295);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)20.10582);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm -1.5873016mm auto 1.5873016mm").setReferenceComponents(gui_Container_2, "2 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)96.296295);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)21.693121);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_4, "-1 -1 -1 -1").setReferencePositions(gui_Container_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_back.getParent().getLayout()).setInsets(gui_btn_back, "0.0mm auto auto 5.0%").setReferenceComponents(gui_btn_back, "-1 -1 -1 -1").setReferencePositions(gui_btn_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)104.49735);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)123.809525);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.26455027mm auto 0.26455027mm auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!'T EDIT ABOVE THIS LINE!!!   
    public void sendSmsAsync(String phone, String val) {
        cn1ConnectionRequest.sendReleansSMS(phone, "Your Verfication code is:" + val, "Pr1gO3GWpmbkRZEazJn4KRjLM", "eaecb9656afbd9db955b22a49d78f5e5a582d2778d55ee09a448a3aa8f7a8f90");

        new Activation_Form_3(res, this, formatPhone(phone), val, isFromSignUp).show();
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
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgColor:ffffff; transparency:255;");
        setTitle("Activation_Form_2");
        setName("Activation_Form_2");
        gui_Container.setPreferredSizeStr("104.49735mm 123.809525mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_2.setPreferredSizeStr("96.296295mm 20.10582mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("bgColor:ffffff; transparency:255; opacity:255;");
        gui_Container_2.setName("Container_2");
        gui_Container_4.setPreferredSizeStr("inherit 21.693121mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_btn_back.setPreferredSizeStr("6.6137567mm 9.259259mm");
                gui_btn_back.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_back.setName("btn_back");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_back,"\ue5c8".charAt(0));
        gui_Container.addComponent(gui_Container_2);
        gui_Container_1.setPreferredSizeStr("66.137566mm 8.201058mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Label_2.setPreferredSizeStr("47.354496mm 7.6719575mm");
        gui_Label_2.setText("Please enter your mobile number");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("alignment:right;");
        gui_Label_2.setName("Label_2");
        gui_Container_2.addComponent(gui_Container_1);
        gui_tf_number.setPreferredSizeStr("48.148148mm 4.7619047mm");
        gui_tf_number.setHint("0790123456");
        gui_tf_number.setUIID("Activation_Input_Under_Line");
                gui_tf_number.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_number.setName("tf_number");
        gui_Container_1_1.setPreferredSizeStr("17.989418mm 7.142857mm");
                gui_Container_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1_1.setName("Container_1_1");
        gui_Container_1.addComponent(gui_tf_number);
        gui_Container_1.addComponent(gui_Container_1_1);
        gui_Label.setPreferredSizeStr("5.820106mm 3.968254mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:flag-jordan.png;");
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("9.259259mm inherit");
        gui_Label_1.setText("+962");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("fgColor:0; opacity:255;");
        gui_Label_1.setName("Label_1");
        gui_Container_1_1.addComponent(gui_Label);
        gui_Container_1_1.addComponent(gui_Label_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto auto -5.9604645E-8mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "auto 0.0mm auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_number.getParent().getLayout()).setInsets(gui_tf_number, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_tf_number, "-1 -1 -1 1 ").setReferencePositions(gui_tf_number, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getLayout()).setPreferredWidthMM((float)17.989418);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getLayout()).setPreferredHeightMM((float)7.142857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getParent().getLayout()).setInsets(gui_Container_1_1, "auto auto auto 0.2645502mm").setReferenceComponents(gui_Container_1_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1_1, "0.0 0.0 0.0 0.0");
        gui_Container_2.addComponent(gui_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)86.772484);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)8.201058);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 4.7619047mm auto 4.7619047mm").setReferenceComponents(gui_Container_1, "1 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 4.7619047mm auto 4.7619047mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_4);
        gui_Container_3.setPreferredSizeStr("28.571428mm 34.126984mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Span_Label.setPreferredSizeStr("45.238094mm 26.455027mm");
        gui_Span_Label.setText("By continuing you may receive an SMS for verification. Message and data rates may apply.");
                gui_Span_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label.setName("Span_Label");
        gui_Container_4.addComponent(gui_Container_3);
        gui_btn_send_sms.setPreferredSizeStr("8.994709mm 7.936508mm");
        gui_btn_send_sms.setUIID("ic_fab");
                gui_btn_send_sms.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_send_sms.setName("btn_send_sms");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_send_sms,"\ue5c4".charAt(0));
        gui_Container_3.addComponent(gui_btn_send_sms);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_send_sms.getParent().getLayout()).setInsets(gui_btn_send_sms, "auto auto auto auto").setReferenceComponents(gui_btn_send_sms, "-1 -1 -1 -1").setReferencePositions(gui_btn_send_sms, "0.0 0.0 0.0 0.0");
        gui_Container_4.addComponent(gui_Span_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)28.571428);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)31.481482);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 70.0% 0.0mm 0.0mm").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Label.getParent().getLayout()).setInsets(gui_Span_Label, "0.0mm 1.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Span_Label, "-1 -1 -1 0 ").setReferencePositions(gui_Span_Label, "0.0 0.0 0.0 1.0");
        gui_Container.addComponent(gui_btn_back);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)96.296295);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)20.10582);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm -1.5873016mm auto 1.5873016mm").setReferenceComponents(gui_Container_2, "2 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)96.296295);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)21.693121);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_4, "-1 -1 -1 -1").setReferencePositions(gui_Container_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_back.getParent().getLayout()).setInsets(gui_btn_back, "0.0mm 5.0% auto auto").setReferenceComponents(gui_btn_back, "-1 -1 -1 -1").setReferencePositions(gui_btn_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)104.49735);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)123.809525);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.26455027mm auto 0.26455027mm auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>


    private void setRTLCmb(Resources res) {
        gui_Span_Label.getTextComponent().setRTL(true);

    }
}
