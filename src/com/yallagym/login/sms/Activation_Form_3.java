package com.yallagym.login.sms;

import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.yallagym.APIs;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.client.forms.list_form;
import com.yallagym.client.forms.Splash;
import com.yallagym.forms.login.forms.BaseLogin;
import com.yallagym.forms.login.forms.login_form;
import com.yallagym.client.forms.user_info;

public class Activation_Form_3 extends BaseLogin {

    Resources res;
    String code_generated;
    String phone;
    APIs api = new APIs();

    public Activation_Form_3() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }
    boolean isFromSignUp;

    public Activation_Form_3(com.codename1.ui.util.Resources resourceObjectInstance) {
        checkLanguage(res);
        this.res = res;
        this.code_generated = code_generated;
        sethideToolbar();
        setEditOnShow(gui_Digit_1);
        createDigits();
//        gui_sb_msg.setText("Enter the 4-digit code sent to you at " + phone);
    }

    public Activation_Form_3(com.codename1.ui.util.Resources res, Form frm, String phone, String code_generated, boolean isFromSignUp) {
        checkLanguage(res);
        this.res = res;
        this.code_generated = code_generated;
        this.phone = phone;
        this.isFromSignUp = isFromSignUp;
        installBackCommand(frm);
        sethideToolbar();
        setEditOnShow(gui_Digit_1);
        createDigits();
        gui_lbl_phone_no.setText(phone);
        gui_btn_back.addActionListener(e -> {
            if (isFromSignUp) {
                new erorr(res, "Warning", "Do you want to return to the login page?", "Yes", ee -> {
                    new login_form(res).show();
                }).show();
            } else {
                new user_info(res, new list_form(res)).show();
            }
        });
        gui_btn_check.addActionListener(e -> {
            System.out.println("code_generated:" + code_generated);
            String input_code_user = gui_Digit_1.getText() + gui_Digit_2.getText() + gui_Digit_3.getText() + gui_Digit_4.getText();
            if (!input_code_user.equals("")) {
                if (input_code_user.equals(code_generated)) {
                    Preferences.set("phone", phone);
                    System.out.println("onbtn_checkActionEvent run and phone is :" + phone);
                    if (isFromSignUp) {
                        api.verifiedPhone(res);
                    } else {
                        api.updatePhone(res, phone);
                    }
                } else {
                    ToastBar.showInfoMessage("The entered code is not correct");
                }

            } else {
                ToastBar.showInfoMessage("Please enter code numbers");
            }
            if (input_code_user.equals(code_generated)) {

            }
        });
    }
    ////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Con_Digits = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.TextField gui_Digit_1 = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Digit_2 = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Digit_3 = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Digit_4 = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_btn_clear = new com.codename1.ui.Button();
    protected com.codename1.components.SpanLabel gui_sb_msg = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Label gui_lbl_phone_no = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_check = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_back = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_check.addActionListener(callback);
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

            if(sourceComponent == gui_btn_check) {
                onbtn_checkActionEvent(ev);
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
        setInlineAllStyles("bgColor:ffffff; transparency:255;");
        setTitle("Activation_Form_3");
        setName("Activation_Form_3");
        gui_Container.setPreferredSizeStr("104.49735mm 123.809525mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_2.setPreferredSizeStr("71.42857mm 34.391533mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("bgColor:ffffff; transparency:255; opacity:255;");
        gui_Container_2.setName("Container_2");
        gui_Container_4.setPreferredSizeStr("77.77778mm 21.693121mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_btn_back.setPreferredSizeStr("6.6137567mm 9.259259mm");
                gui_btn_back.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_back.setName("btn_back");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_back,"\ue5c4".charAt(0));
        gui_Container.addComponent(gui_Container_2);
        gui_Con_Digits.setPreferredSizeStr("71.95767mm 8.201058mm");
                gui_Con_Digits.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Digits.setName("Con_Digits");
        gui_sb_msg.setPreferredSizeStr("83.862434mm 10.58201mm");
        gui_sb_msg.setText("Enter the 4-digit code sent to you at");
                gui_sb_msg.setInlineStylesTheme(resourceObjectInstance);
        gui_sb_msg.setName("sb_msg");
        gui_lbl_phone_no.setPreferredSizeStr("97.8836mm 6.6137567mm");
        gui_lbl_phone_no.setText("");
                gui_lbl_phone_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_phone_no.setName("lbl_phone_no");
        gui_Container_2.addComponent(gui_Con_Digits);
        gui_Container_1.setPreferredSizeStr("51.32275mm 11.640212mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_btn_clear.setPreferredSizeStr("8.201058mm inherit");
        gui_btn_clear.setText("X");
                gui_btn_clear.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_clear.setName("btn_clear");
        gui_Con_Digits.addComponent(gui_Container_1);
        gui_Digit_1.setPreferredSizeStr("6.3492064mm 17.989418mm");
        gui_Digit_1.setHint("0");
        gui_Digit_1.setUIID("Digit");
                gui_Digit_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Digit_1.setName("Digit_1");
        gui_Digit_1.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        gui_Digit_2.setPreferredSizeStr("6.3492064mm 17.989418mm");
        gui_Digit_2.setHint("0");
        gui_Digit_2.setUIID("Digit");
                gui_Digit_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Digit_2.setName("Digit_2");
        gui_Digit_2.setRows(1);
        gui_Digit_2.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        gui_Digit_3.setPreferredSizeStr("6.3492064mm 17.989418mm");
        gui_Digit_3.setHint("0");
        gui_Digit_3.setUIID("Digit");
                gui_Digit_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Digit_3.setName("Digit_3");
        gui_Digit_3.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        gui_Digit_4.setPreferredSizeStr("6.3492064mm 17.989418mm");
        gui_Digit_4.setHint("0");
        gui_Digit_4.setUIID("Digit");
                gui_Digit_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Digit_4.setName("Digit_4");
        gui_Digit_4.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        gui_Container_1.addComponent(gui_Digit_1);
        gui_Container_1.addComponent(gui_Digit_2);
        gui_Container_1.addComponent(gui_Digit_3);
        gui_Container_1.addComponent(gui_Digit_4);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Digit_1.getParent().getLayout()).setInsets(gui_Digit_1, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Digit_1, "-1 -1 -1 -1").setReferencePositions(gui_Digit_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Digit_2.getParent().getLayout()).setInsets(gui_Digit_2, "0.0mm auto 0.0mm 2.0mm").setReferenceComponents(gui_Digit_2, "-1 -1 -1 0 ").setReferencePositions(gui_Digit_2, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Digit_3.getParent().getLayout()).setInsets(gui_Digit_3, "0.0mm auto 0.0mm 2.0mm").setReferenceComponents(gui_Digit_3, "-1 -1 -1 1 ").setReferencePositions(gui_Digit_3, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Digit_4.getParent().getLayout()).setInsets(gui_Digit_4, "0.0mm auto 0.0mm 2.0mm").setReferenceComponents(gui_Digit_4, "-1 -1 -1 2 ").setReferencePositions(gui_Digit_4, "0.0 0.0 0.0 1.0");
        gui_Con_Digits.addComponent(gui_btn_clear);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)51.32275);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)8.201058);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_clear.getParent().getLayout()).setInsets(gui_btn_clear, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_btn_clear, "-1 -1 -1 0 ").setReferencePositions(gui_btn_clear, "0.0 0.0 0.0 1.0");
        gui_Container_2.addComponent(gui_sb_msg);
        gui_Container_2.addComponent(gui_lbl_phone_no);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Digits.getLayout()).setPreferredWidthMM((float)71.95767);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Digits.getLayout()).setPreferredHeightMM((float)8.201058);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Digits.getParent().getLayout()).setInsets(gui_Con_Digits, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Digits, "2 -1 -1 -1").setReferencePositions(gui_Con_Digits, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_sb_msg.getParent().getLayout()).setInsets(gui_sb_msg, "2.3809524mm 0.0mm auto 0.0mm").setReferenceComponents(gui_sb_msg, "-1 -1 -1 -1").setReferencePositions(gui_sb_msg, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_phone_no.getParent().getLayout()).setInsets(gui_lbl_phone_no, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_phone_no, "1 -1 -1 -1").setReferencePositions(gui_lbl_phone_no, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_4);
        gui_Container_3.setPreferredSizeStr("28.571428mm 34.126984mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_4.addComponent(gui_Container_3);
        gui_btn_check.setPreferredSizeStr("8.994709mm 7.936508mm");
        gui_btn_check.setUIID("ic_fab");
                gui_btn_check.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_check.setName("btn_check");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_check,"\ue5c8".charAt(0));
        gui_Container_3.addComponent(gui_btn_check);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_check.getParent().getLayout()).setInsets(gui_btn_check, "auto auto auto auto").setReferenceComponents(gui_btn_check, "-1 -1 -1 -1").setReferencePositions(gui_btn_check, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)28.571428);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)31.481482);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 0.0mm 0.0mm 70.0%").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_btn_back);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)70.37037);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)34.391533);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 3.7037036mm auto 3.7037036mm").setReferenceComponents(gui_Container_2, "2 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)77.77778);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)21.693121);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_4, "-1 -1 -1 -1").setReferencePositions(gui_Container_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_back.getParent().getLayout()).setInsets(gui_btn_back, "0.0mm auto auto 5.0%").setReferenceComponents(gui_btn_back, "-1 -1 -1 -1").setReferencePositions(gui_btn_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)104.49735);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)123.809525);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.26455027mm auto 0.26455027mm auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!! 
    //-- DON'T EDIT ABOVE THIS LINE!!!   
    private void createDigits() {
        gui_Digit_1.getHintLabel().getAllStyles().setAlignment(CENTER);
        gui_Digit_1.getHintLabel().getAllStyles().setPadding(0, 0, 0, 0);
        gui_Digit_1.addDataChangedListener((i, ii) -> {
            if (gui_Digit_1.getText().length() == 1) {
                gui_Digit_1.stopEditing();
                gui_Digit_2.startEditingAsync();

            }
        });
        gui_Digit_2.getHintLabel().getAllStyles().setAlignment(CENTER);
        gui_Digit_2.getHintLabel().getAllStyles().setPadding(0, 0, 0, 0);
        gui_Digit_2.addDataChangedListener((i, ii) -> {
            if (gui_Digit_2.getText().length() == 1) {
                gui_Digit_2.stopEditing();
                gui_Digit_3.startEditingAsync();

            }
        });
        gui_Digit_3.getHintLabel().getAllStyles().setAlignment(CENTER);
        gui_Digit_3.getHintLabel().getAllStyles().setPadding(0, 0, 0, 0);
        gui_Digit_3.addDataChangedListener((i, ii) -> {
            if (gui_Digit_3.getText().length() == 1) {
                gui_Digit_3.stopEditing();
                gui_Digit_4.startEditingAsync();

            }
        });
        gui_Digit_4.getHintLabel().getAllStyles().setAlignment(CENTER);
        gui_Digit_4.getHintLabel().getAllStyles().setPadding(0, 0, 0, 0);
//        gui_Digit_4.addDataChangedListener((i, ii) -> {
        //check
//        });

    }

//    private void createDigits(TextField[] response) {
//        for (int iter = 0; iter < response.length; iter++) {
//            TextField t = response[iter];
//            t.getHintLabel().getAllStyles().setAlignment(CENTER);
//            t.getHintLabel().getAllStyles().setPadding(0, 0, 0, 0);
//        }
//        for (int iter = 0; iter < response.length - 1; iter++) {
//            onTypeNext(iter, response[iter], response[iter + 1]);
////            if (iter == 3) {
////                response[iter].addDataChangedListener((i, ii) -> {
////                    /// cheak digits
////                });
////            }
//        }
//
//    }
//    private void onTypeNext(int iter, TextField current, TextField next) {
//        current.addDataChangedListener((i, ii) -> {
//            if (current.getText().length() == 1) {
//                current.stopEditing();
//                next.startEditingAsync();
//
//            }
//        });
//    }
    public void onbtn_checkActionEvent(com.codename1.ui.events.ActionEvent ev) {
//        String input_code_user = gui_Digit_1.getText() + gui_Digit_2.getText() + gui_Digit_3.getText() + gui_Digit_4.getText();
//        if (input_code_user.equals(code_generated)) {
//            Preferences.set("phone", phone);
//            System.out.println("onbtn_checkActionEvent run and phone is :" + phone);
////            api.updatePhone(res, phone);
//            if (isFromSignUp) {
////                new user_info(res, new list_form(res)).show();
//                api.verifiedPhone(res);
//            } else {
//                api.updatePhone(res, phone);
//            }
//        }
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
        setInlineAllStyles("bgColor:ffffff; transparency:255;");
        setTitle("Activation_Form_3");
        setName("Activation_Form_3");
        gui_Container.setPreferredSizeStr("104.49735mm 123.809525mm");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_2.setPreferredSizeStr("71.42857mm 34.391533mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("bgColor:ffffff; transparency:255; opacity:255;");
        gui_Container_2.setName("Container_2");
        gui_Container_4.setPreferredSizeStr("77.77778mm 21.693121mm");
        gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_btn_back.setPreferredSizeStr("6.6137567mm 9.259259mm");
        gui_btn_back.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_back.setName("btn_back");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_back, "\ue5c8".charAt(0));
        gui_Container.addComponent(gui_Container_2);
        gui_Con_Digits.setPreferredSizeStr("71.95767mm 8.201058mm");
        gui_Con_Digits.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Digits.setName("Con_Digits");
        gui_sb_msg.setPreferredSizeStr("83.862434mm 10.58201mm");
        gui_sb_msg.setText("Enter the 4-digit code sent to you at");
        gui_sb_msg.setInlineStylesTheme(resourceObjectInstance);
        gui_sb_msg.setName("sb_msg");
        gui_lbl_phone_no.setPreferredSizeStr("97.8836mm 6.6137567mm");
        gui_lbl_phone_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_phone_no.setName("lbl_phone_no");
        gui_Container_2.addComponent(gui_Con_Digits);
        gui_Container_1.setPreferredSizeStr("51.32275mm 11.640212mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_btn_clear.setPreferredSizeStr("8.201058mm inherit");
        gui_btn_clear.setText("X");
        gui_btn_clear.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_clear.setName("btn_clear");
        gui_Con_Digits.addComponent(gui_Container_1);
        gui_Digit_1.setPreferredSizeStr("6.3492064mm 17.989418mm");
        gui_Digit_1.setHint("0");
        gui_Digit_1.setUIID("Digit");
        gui_Digit_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Digit_1.setName("Digit_1");
        gui_Digit_1.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        gui_Digit_2.setPreferredSizeStr("6.3492064mm 17.989418mm");
        gui_Digit_2.setHint("0");
        gui_Digit_2.setUIID("Digit");
        gui_Digit_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Digit_2.setName("Digit_2");
        gui_Digit_2.setRows(1);
        gui_Digit_2.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        gui_Digit_3.setPreferredSizeStr("6.3492064mm 17.989418mm");
        gui_Digit_3.setHint("0");
        gui_Digit_3.setUIID("Digit");
        gui_Digit_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Digit_3.setName("Digit_3");
        gui_Digit_3.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        gui_Digit_4.setPreferredSizeStr("6.3492064mm 17.989418mm");
        gui_Digit_4.setHint("0");
        gui_Digit_4.setUIID("Digit");
        gui_Digit_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Digit_4.setName("Digit_4");
        gui_Digit_4.setConstraint(com.codename1.ui.TextArea.NUMERIC);
        gui_Container_1.addComponent(gui_Digit_1);
        gui_Container_1.addComponent(gui_Digit_2);
        gui_Container_1.addComponent(gui_Digit_3);
        gui_Container_1.addComponent(gui_Digit_4);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Digit_1.getParent().getLayout()).setInsets(gui_Digit_1, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Digit_1, "-1 -1 -1 -1").setReferencePositions(gui_Digit_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Digit_2.getParent().getLayout()).setInsets(gui_Digit_2, "0.0mm auto 0.0mm 2.0mm").setReferenceComponents(gui_Digit_2, "-1 -1 -1 0 ").setReferencePositions(gui_Digit_2, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Digit_3.getParent().getLayout()).setInsets(gui_Digit_3, "0.0mm auto 0.0mm 2.0mm").setReferenceComponents(gui_Digit_3, "-1 -1 -1 1 ").setReferencePositions(gui_Digit_3, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Digit_4.getParent().getLayout()).setInsets(gui_Digit_4, "0.0mm auto 0.0mm 2.0mm").setReferenceComponents(gui_Digit_4, "-1 -1 -1 2 ").setReferencePositions(gui_Digit_4, "0.0 0.0 0.0 1.0");
        gui_Con_Digits.addComponent(gui_btn_clear);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 51.32275);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 8.201058);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_clear.getParent().getLayout()).setInsets(gui_btn_clear, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_btn_clear, "-1 -1 -1 0 ").setReferencePositions(gui_btn_clear, "0.0 0.0 0.0 1.0");
        gui_Container_2.addComponent(gui_sb_msg);
        gui_Container_2.addComponent(gui_lbl_phone_no);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Digits.getLayout()).setPreferredWidthMM((float) 71.95767);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Digits.getLayout()).setPreferredHeightMM((float) 8.201058);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Digits.getParent().getLayout()).setInsets(gui_Con_Digits, "2.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Digits, "2 -1 -1 -1").setReferencePositions(gui_Con_Digits, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_sb_msg.getParent().getLayout()).setInsets(gui_sb_msg, "2.3809524mm 0.0mm auto 0.0mm").setReferenceComponents(gui_sb_msg, "-1 -1 -1 -1").setReferencePositions(gui_sb_msg, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_phone_no.getParent().getLayout()).setInsets(gui_lbl_phone_no, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_phone_no, "1 -1 -1 -1").setReferencePositions(gui_lbl_phone_no, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_4);
        gui_Container_3.setPreferredSizeStr("28.571428mm 34.126984mm");
        gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_4.addComponent(gui_Container_3);
        gui_btn_check.setPreferredSizeStr("8.994709mm 7.936508mm");
        gui_btn_check.setUIID("ic_fab");
        gui_btn_check.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_check.setName("btn_check");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_check, "\ue5c4".charAt(0));
        gui_Container_3.addComponent(gui_btn_check);
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_check.getParent().getLayout()).setInsets(gui_btn_check, "auto auto auto auto").setReferenceComponents(gui_btn_check, "-1 -1 -1 -1").setReferencePositions(gui_btn_check, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredWidthMM((float) 28.571428);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredHeightMM((float) 31.481482);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 70.0% 0.0mm 0.0mm").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_btn_back);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 70.37037);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 34.391533);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 3.7037036mm auto 3.7037036mm").setReferenceComponents(gui_Container_2, "2 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredWidthMM((float) 77.77778);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredHeightMM((float) 21.693121);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_4, "-1 -1 -1 -1").setReferencePositions(gui_Container_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_back.getParent().getLayout()).setInsets(gui_btn_back, "0.0mm 5.0% auto auto").setReferenceComponents(gui_btn_back, "-1 -1 -1 -1").setReferencePositions(gui_btn_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 104.49735);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 123.809525);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.26455027mm auto 0.26455027mm auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
        gui_sb_msg.getTextComponent().setRTL(true);
        gui_lbl_phone_no.setRTL(true);
    }
}
