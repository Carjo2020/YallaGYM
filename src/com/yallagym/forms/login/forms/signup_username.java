package com.yallagym.forms.login.forms;

import com.cn2.ui.cn1Display;
import com.cn2.ui.cn1Font;
import com.cn2.ui.cn1Icons;
import com.cn2.util.cn1String;
import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.l10n.SimpleDateFormat;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import com.yallagym.client.dialogs.accepted_terms;
import java.util.Date;
import java.util.Random;

public class signup_username extends BaseLogin {

    Form frm;
    Resources res;
    TextField first_name;
    TextField last_name;
    TextField username;
    TextField phone;
    String countries[] = {"Amman", "Zarqa", "Irbid", "Jerash", "Madaba", "Ajloun", "Balqa", "Mafraq", "Ma'an", "Karak", "Tafilah", "Aqaba"};
    PickerComponent date;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    APIs api = new APIs();

    public signup_username() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public signup_username(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ... 
    }

    public signup_username(com.codename1.ui.util.Resources res, Form frm) {
        first_name = createTextField("First name", new cn1Icons().getImage("person", "TitleCommand", 5).scaled(56, 56));
        last_name = createTextField("Last name", new cn1Icons().getImage("person", "TitleCommand", 5).scaled(56, 56));
        phone = createTextField("Enter phone", new cn1Icons().getImage("phone", "TitleCommand", 5).scaled(56, 56));
        username = createTextField("Enter username", new cn1Icons().getImage("email", "TitleCommand", 5).scaled(56, 56));

        checkLanguage(res);
        this.res = res;
        this.frm = frm;
        installBackCommand(frm);
        installFixItems();
        if (!BaseForm.isAndroid()) {
            gui_Container_3.getAllStyles().setMarginTop(cn1Display.getScaledMax(30));
//            gui_Container_2.setPreferredH(6);
//            gui_Container_2.setVisible(false);

        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_bg_img = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_bg_img_gray = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_continue = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_con_first_name = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_con_last_name = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_con_username = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_con_phone = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Con_Picker = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.ComboBox gui_CBox_Type = new com.codename1.ui.ComboBox();
    protected com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_5_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.ComboBox gui_CBox_Country = new com.codename1.ui.ComboBox();
    protected com.codename1.components.SpanButton gui_btn_check_privacy = new com.codename1.components.SpanButton();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_back = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_continue.addActionListener(callback);
        gui_btn_check_privacy.addActionListener(callback);
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
            if(sourceComponent == gui_btn_check_privacy) {
                onbtn_check_privacyActionEvent(ev);
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
        setTitle("signup_username");
        setName("signup_username");
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
        gui_Container_1.setPreferredSizeStr("58.46561mm 114.28571mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_3.setPreferredSizeStr("59.78836mm 9.78836mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container.addComponent(gui_bg_img);
        gui_Container.addComponent(gui_bg_img_gray);
        gui_Container.addComponent(gui_Container_1);
        gui_btn_continue.setPreferredSizeStr("57.67196mm 7.6719575mm");
        gui_btn_continue.setText("CONTINUE");
        gui_btn_continue.setUIID("login_btn");
                gui_btn_continue.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_continue.setInlineAllStyles("fgColor:ffffff; bgImage:btn_green.png;");
        gui_btn_continue.setName("btn_continue");
        gui_con_first_name.setPreferredSizeStr("20.899471mm 8.994709mm");
        gui_con_first_name.setUIID("con_input");
                gui_con_first_name.setInlineStylesTheme(resourceObjectInstance);
        gui_con_first_name.setName("con_first_name");
        gui_con_last_name.setPreferredSizeStr("25.661375mm 8.994709mm");
        gui_con_last_name.setUIID("con_input");
                gui_con_last_name.setInlineStylesTheme(resourceObjectInstance);
        gui_con_last_name.setName("con_last_name");
        gui_con_username.setPreferredSizeStr("78.30688mm 8.994709mm");
        gui_con_username.setUIID("con_input");
                gui_con_username.setInlineStylesTheme(resourceObjectInstance);
        gui_con_username.setName("con_username");
        gui_con_phone.setPreferredSizeStr("74.07407mm 8.994709mm");
        gui_con_phone.setUIID("con_input");
                gui_con_phone.setInlineStylesTheme(resourceObjectInstance);
        gui_con_phone.setName("con_phone");
        gui_Container_2.setPreferredSizeStr("53.174603mm 8.994709mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container_4.setPreferredSizeStr("26.190475mm 9.78836mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Container_5.setPreferredSizeStr("27.248678mm 9.78836mm");
                gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setName("Container_5");
        gui_btn_check_privacy.setPreferredSizeStr("55.555557mm 15.873016mm");
        gui_btn_check_privacy.setText("Check our Privacy Policy for information on how you can Unsubscribe to promotional emails & how your personal information is used.");
        gui_btn_check_privacy.setUIID("Home_Show_More_Dialog_Lbls");
                gui_btn_check_privacy.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_check_privacy.setName("btn_check_privacy");
        gui_btn_check_privacy.setPropertyValue("textUiid", "Home_Show_More_Dialog_Lbls");
        gui_Container_1.addComponent(gui_btn_continue);
        gui_Container_1.addComponent(gui_con_first_name);
        gui_Container_1.addComponent(gui_con_last_name);
        gui_Container_1.addComponent(gui_con_username);
        gui_Container_1.addComponent(gui_con_phone);
        gui_Container_1.addComponent(gui_Container_2);
        gui_Label_1.setPreferredSizeStr("23.280424mm 12.962963mm");
        gui_Label_1.setText("Date of Birth");
        gui_Label_1.setUIID("PersonalInfo_Lbl");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("fgColor:ffffff;");
        gui_Label_1.setName("Label_1");
        gui_Con_Picker.setPreferredSizeStr("26.190475mm 9.78836mm");
                gui_Con_Picker.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Picker.setName("Con_Picker");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Container_2.addComponent(gui_Con_Picker);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Picker.getLayout()).setPreferredWidthMM((float)26.190475);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Picker.getLayout()).setPreferredHeightMM((float)9.78836);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Picker.getParent().getLayout()).setInsets(gui_Con_Picker, "-5.9604645E-8mm -4.7683716E-7mm 0.0mm 25.0%").setReferenceComponents(gui_Con_Picker, "-1 -1 -1 0 ").setReferencePositions(gui_Con_Picker, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_Label_2.setPreferredSizeStr("10.58201mm 12.962963mm");
        gui_Label_2.setText("Type");
        gui_Label_2.setUIID("PersonalInfo_Lbl");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("fgColor:ffffff;");
        gui_Label_2.setName("Label_2");
        gui_Container_4_1.setPreferredSizeStr("37.83069mm 9.78836mm");
                gui_Container_4_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4_1.setName("Container_4_1");
        gui_Container_4.addComponent(gui_Label_2);
        gui_Container_4.addComponent(gui_Container_4_1);
        gui_CBox_Type.setPreferredSizeStr("37.037037mm 9.523809mm");
                gui_CBox_Type.setInlineStylesTheme(resourceObjectInstance);
        gui_CBox_Type.setName("CBox_Type");
        gui_Container_4_1.addComponent(gui_CBox_Type);
        ((com.codename1.ui.layouts.LayeredLayout)gui_CBox_Type.getParent().getLayout()).setInsets(gui_CBox_Type, "0.0mm 0.0mm -0.2645502mm 0.0mm").setReferenceComponents(gui_CBox_Type, "-1 -1 -1 -1").setReferencePositions(gui_CBox_Type, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4_1.getLayout()).setPreferredWidthMM((float)37.83069);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4_1.getLayout()).setPreferredHeightMM((float)9.78836);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4_1.getParent().getLayout()).setInsets(gui_Container_4_1, "-5.9604645E-8mm -4.7683716E-7mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_4_1, "-1 -1 -1 0 ").setReferencePositions(gui_Container_4_1, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_Container_5);
        gui_Label_3.setPreferredSizeStr("9.78836mm 12.962963mm");
        gui_Label_3.setText("City");
        gui_Label_3.setUIID("PersonalInfo_Lbl");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("fgColor:ffffff;");
        gui_Label_3.setName("Label_3");
        gui_Container_5_1.setPreferredSizeStr("37.83069mm 9.78836mm");
                gui_Container_5_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5_1.setName("Container_5_1");
        gui_Container_5.addComponent(gui_Label_3);
        gui_Container_5.addComponent(gui_Container_5_1);
        gui_CBox_Country.setPreferredSizeStr("42.32804mm 11.111112mm");
                gui_CBox_Country.setInlineStylesTheme(resourceObjectInstance);
        gui_CBox_Country.setName("CBox_Country");
        gui_Container_5_1.addComponent(gui_CBox_Country);
        ((com.codename1.ui.layouts.LayeredLayout)gui_CBox_Country.getParent().getLayout()).setInsets(gui_CBox_Country, "-2.3841858E-7mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_CBox_Country, "-1 -1 -1 -1").setReferencePositions(gui_CBox_Country, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Label_3, "-1 -1 -1 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5_1.getLayout()).setPreferredWidthMM((float)37.83069);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5_1.getLayout()).setPreferredHeightMM((float)9.78836);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5_1.getParent().getLayout()).setInsets(gui_Container_5_1, "-5.9604645E-8mm -4.7683716E-7mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_5_1, "-1 -1 -1 0 ").setReferencePositions(gui_Container_5_1, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_btn_check_privacy);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_continue.getParent().getLayout()).setInsets(gui_btn_continue, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_continue, "8 -1 -1 -1").setReferencePositions(gui_btn_continue, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_first_name.getLayout()).setPreferredWidthMM((float)20.899471);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_first_name.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_first_name.getParent().getLayout()).setInsets(gui_con_first_name, "0.0mm 55.0% auto 1.1920929E-7mm").setReferenceComponents(gui_con_first_name, "-1 -1 -1 -1").setReferencePositions(gui_con_first_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_last_name.getLayout()).setPreferredWidthMM((float)25.661375);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_last_name.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_last_name.getParent().getLayout()).setInsets(gui_con_last_name, "0.0mm 9.536743E-7mm auto 55.0%").setReferenceComponents(gui_con_last_name, "-1 -1 -1 -1").setReferencePositions(gui_con_last_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_username.getLayout()).setPreferredWidthMM((float)78.30688);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_username.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_username.getParent().getLayout()).setInsets(gui_con_username, "5.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_con_username, "1 -1 -1 -1").setReferencePositions(gui_con_username, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_phone.getLayout()).setPreferredWidthMM((float)59.25926);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_phone.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_phone.getParent().getLayout()).setInsets(gui_con_phone, "5.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_con_phone, "3 -1 -1 -1").setReferencePositions(gui_con_phone, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)58.99471);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "3.7037036mm 0.26454926mm auto 0.0mm").setReferenceComponents(gui_Container_2, "4 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)26.190475);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)9.78836);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "5.0% 50.0% auto 0.0mm").setReferenceComponents(gui_Container_4, "5 -1 -1 -1").setReferencePositions(gui_Container_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredWidthMM((float)27.248678);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredHeightMM((float)9.78836);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "5.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_5, "5 -1 -1 6 ").setReferencePositions(gui_Container_5, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_check_privacy.getParent().getLayout()).setInsets(gui_btn_check_privacy, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_check_privacy, "7 -1 -1 -1").setReferencePositions(gui_btn_check_privacy, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_3);
        gui_btn_back.setPreferredSizeStr("10.8465605mm 9.523809mm");
        gui_btn_back.setUIID("login_btn");
                gui_btn_back.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_back.setName("btn_back");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_back,"\ue5c4".charAt(0));
        gui_Label.setPreferredSizeStr("24.074074mm 11.904762mm");
        gui_Label.setText("Sign up");
        gui_Label.setUIID("lbl_white");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Container_3.addComponent(gui_btn_back);
        gui_Container_3.addComponent(gui_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_back.getParent().getLayout()).setInsets(gui_btn_back, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_btn_back, "-1 -1 -1 -1").setReferencePositions(gui_btn_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto 0.0mm auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)53.439156);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)114.28571);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "5.0% 2.6455026mm 0.0mm 3.7037039mm").setReferenceComponents(gui_Container_1, "3 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)59.78836);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)9.78836);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)69.04762);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)116.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!   
    public void onbtn_continueActionEvent(com.codename1.ui.events.ActionEvent ev) {
        boolean isAcceptedTerms = Preferences.get("accepted_terms", false);
        if (isAcceptedTerms) {

            String first_name = this.first_name.getText();
            String last_name = this.last_name.getText();
            String username = this.username.getText().toLowerCase();
            String phone = formatPhone(this.phone.getText());
            String age = date.getPicker().getText();
//            String age = dateFormat.format(new Date());
            String type = gui_CBox_Type.getSelectedItem() + "";
            String address = gui_CBox_Country.getSelectedItem() + "";
//          System.out.println(""+dateFormat.format(new Date()));
//        System.out.println("age.equals(dateFormat.format(new Date())):"+age.equals(dateFormat.format(new Date())));
            if (!isHaveArabic(username)) {
                if (!first_name.contains(" ") && !last_name.contains(" ") && !username.contains(" ") && !phone.contains(" ")) {
                    boolean checkChars = !checkIfThereChars(first_name) && !checkIfThereChars(last_name) && !checkIfThereChars(username) && !checkIfThereChars(phone);
                    if (first_name.length() > 0 && checkChars) {
                        if (last_name.length() > 0) {
                            if (username.length() > 0) {
                                if (!username.endsWith("_yalla") && !username.equals("null")) {
                                    if (phone.length() > 0) {
//                                        if (!age.equals(dateFormat.format(new Date()))) {
                                        if (address.length() > 0) {
                                            if (api.isUser(username).equals("0") && api.isUser(phone).equals("0")) {

                                                new signup_password(res, this, first_name, last_name, username, phone, age, type, address).show();

                                            } else {
                                                ToastBar.showErrorMessage("Username / Phone is already taken");
                                            }
                                        } else {

                                            ToastBar.showErrorMessage("Please select city");
                                        }
//                                        } else {
//                                            ToastBar.showErrorMessage("Please select your birthday");
//                                        }
                                    } else {
                                        ToastBar.showErrorMessage("Please enter phone number!");
                                    }
                                } else {
                                    ToastBar.showErrorMessage("You cann't create username like: " + username + " try change that.");
                                }
                            } else {
                                ToastBar.showErrorMessage("Please enter username!");
                            }
                        } else {
                            ToastBar.showErrorMessage("Please enter a last name!");
                        }
                    } else {
                        if (checkChars) {
                            ToastBar.showErrorMessage("Please enter a first name!");
                        } else {
                            ToastBar.showErrorMessage("Error: special chars are not allowed in fields");
                        }
                    }
                } else {
                    ToastBar.showErrorMessage("Error: spaces are not allowed in fields");
                }
            } else {
                ToastBar.showErrorMessage("Username should be in english");
            }
        } else {
            new accepted_terms(res).show();
        }
    }

    public void onbtn_backActionEvent(com.codename1.ui.events.ActionEvent ev) {
        frm.show();
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
        gui_btn_check_privacy.getTextAllStyles().setFgColor(0xffffff);
        gui_btn_check_privacy.setIcon(new cn1Icons().getImage("lock", "icons_yellow_light", 8));

        gui_con_first_name.add(CENTER, first_name);
        gui_con_last_name.add(CENTER, last_name);
        gui_con_phone.add(CENTER, phone);
        gui_con_username.add(CENTER, username);
        gui_Container_1.setPreferredH(cn1Display.getHeight() - gui_Container_3.getPreferredH());
        gui_CBox_Type.addItem("male");
        gui_CBox_Type.addItem("female");
        gui_CBox_Type.setScrollVisible(false);
        gui_CBox_Country.setScrollVisible(false);
        for (String s : countries) {
            gui_CBox_Country.addItem(s);
        }
        this.setScrollable(false);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setScrollVisible(false);
        Date now = new Date();
        date = PickerComponent.createDate(now);
        date.getPicker().setFormatter(dateFormat);
        try {
            date.getPicker().setStartDate(dateFormat.parse("01/01/1935"));
            date.getPicker().setEndDate(now);
        } catch (Exception e) {
        }

        date.getPicker().setUseLightweightPopup(true);
//        date.setUIID("con_input");
        date.getPicker().setUIID("con_input");
        date.setPreferredSize(gui_Con_Picker.getPreferredSize());
        date.getPicker().setPreferredSize(gui_Con_Picker.getPreferredSize());
//        date.getPicker().setPreferredH(200);

        gui_Con_Picker.add(CENTER, date);
    }

    public void onbtn_check_privacyActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Display.getInstance().execute("https://openskyjo.github.io/Terms-Conditions/");
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
        setTitle("signup_username");
        setName("signup_username");
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
        gui_Container_1.setPreferredSizeStr("58.46561mm 114.28571mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_3.setPreferredSizeStr("59.78836mm 9.78836mm");
        gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container.addComponent(gui_bg_img);
        gui_Container.addComponent(gui_bg_img_gray);
        gui_Container.addComponent(gui_Container_1);
        gui_btn_continue.setPreferredSizeStr("57.67196mm 7.6719575mm");
        gui_btn_continue.setText("CONTINUE");
        gui_btn_continue.setUIID("login_btn");
        gui_btn_continue.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_continue.setInlineAllStyles("fgColor:ffffff; bgImage:btn_green.png;");
        gui_btn_continue.setName("btn_continue");
        gui_con_first_name.setPreferredSizeStr("20.899471mm 8.994709mm");
        gui_con_first_name.setUIID("con_input");
        gui_con_first_name.setInlineStylesTheme(resourceObjectInstance);
        gui_con_first_name.setName("con_first_name");
        gui_con_last_name.setPreferredSizeStr("25.661375mm 8.994709mm");
        gui_con_last_name.setUIID("con_input");
        gui_con_last_name.setInlineStylesTheme(resourceObjectInstance);
        gui_con_last_name.setName("con_last_name");
        gui_con_username.setPreferredSizeStr("78.30688mm 8.994709mm");
        gui_con_username.setUIID("con_input");
        gui_con_username.setInlineStylesTheme(resourceObjectInstance);
        gui_con_username.setName("con_username");
        gui_con_phone.setPreferredSizeStr("74.07407mm 8.994709mm");
        gui_con_phone.setUIID("con_input");
        gui_con_phone.setInlineStylesTheme(resourceObjectInstance);
        gui_con_phone.setName("con_phone");
        gui_Container_2.setPreferredSizeStr("53.174603mm 9.78836mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container_4.setPreferredSizeStr("26.190475mm 9.78836mm");
        gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Container_5.setPreferredSizeStr("27.248678mm 9.78836mm");
        gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setName("Container_5");
        gui_btn_check_privacy.setPreferredSizeStr("55.555557mm 15.873016mm");
        gui_btn_check_privacy.setRTL(true);
        gui_btn_check_privacy.setText("Check our Privacy Policy for information on how you can Unsubscribe to promotional emails & how your personal information is used.");
        gui_btn_check_privacy.setUIID("Home_Show_More_Dialog_Lbls");
        gui_btn_check_privacy.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_check_privacy.setName("btn_check_privacy");
        gui_btn_check_privacy.setPropertyValue("textUiid", "Home_Show_More_Dialog_Lbls");
        gui_Container_1.addComponent(gui_btn_continue);
        gui_Container_1.addComponent(gui_con_first_name);
        gui_Container_1.addComponent(gui_con_last_name);
        gui_Container_1.addComponent(gui_con_username);
        gui_Container_1.addComponent(gui_con_phone);
        gui_Container_1.addComponent(gui_Container_2);
        gui_Label_1.setPreferredSizeStr("23.280424mm 12.962963mm");
        gui_Label_1.setText("Date of Birth");
        gui_Label_1.setUIID("PersonalInfo_Lbl");
        gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:2.5mm; fgColor:ffffff; alignment:right;");
        gui_Label_1.setName("Label_1");
        gui_Con_Picker.setPreferredSizeStr("29.36508mm 9.78836mm");
        gui_Con_Picker.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Picker.setName("Con_Picker");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Container_2.addComponent(gui_Con_Picker);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Picker.getLayout()).setPreferredWidthMM((float) 29.36508);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Picker.getLayout()).setPreferredHeightMM((float) 9.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Picker.getParent().getLayout()).setInsets(gui_Con_Picker, "-5.9604645E-8mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Con_Picker, "-1 0 -1 -1").setReferencePositions(gui_Con_Picker, "0.0 1.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_Label_2.setPreferredSizeStr("12.433863mm 12.962963mm");
        gui_Label_2.setText("Type");
        gui_Label_2.setUIID("PersonalInfo_Lbl");
        gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:2.5mm; fgColor:ffffff;");
        gui_Label_2.setName("Label_2");
        gui_Container_4_1.setPreferredSizeStr("37.83069mm 9.78836mm");
        gui_Container_4_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4_1.setName("Container_4_1");
        gui_Container_4.addComponent(gui_Label_2);
        gui_Container_4.addComponent(gui_Container_4_1);
        gui_CBox_Type.setPreferredSizeStr("37.037037mm 9.523809mm");
        gui_CBox_Type.setRTL(true);
        gui_CBox_Type.setInlineStylesTheme(resourceObjectInstance);
        gui_CBox_Type.setName("CBox_Type");
        gui_Container_4_1.addComponent(gui_CBox_Type);
        ((com.codename1.ui.layouts.LayeredLayout) gui_CBox_Type.getParent().getLayout()).setInsets(gui_CBox_Type, "0.0mm 0.0mm -0.2645502mm 0.0mm").setReferenceComponents(gui_CBox_Type, "-1 -1 -1 -1").setReferencePositions(gui_CBox_Type, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4_1.getLayout()).setPreferredWidthMM((float) 37.83069);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4_1.getLayout()).setPreferredHeightMM((float) 9.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4_1.getParent().getLayout()).setInsets(gui_Container_4_1, "-5.9604645E-8mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_4_1, "-1 0 -1 -1").setReferencePositions(gui_Container_4_1, "0.0 1.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_5);
        gui_Label_3.setPreferredSizeStr("13.756614mm 12.962963mm");
        gui_Label_3.setText("City");
        gui_Label_3.setUIID("PersonalInfo_Lbl");
        gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("font:2.5mm; fgColor:ffffff;");
        gui_Label_3.setName("Label_3");
        gui_Container_5_1.setPreferredSizeStr("9.78836mm 9.78836mm");
        gui_Container_5_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5_1.setName("Container_5_1");
        gui_Container_5.addComponent(gui_Label_3);
        gui_Container_5.addComponent(gui_Container_5_1);
        gui_CBox_Country.setPreferredSizeStr("42.32804mm 11.111112mm");
        gui_CBox_Country.setRTL(true);
        gui_CBox_Country.setInlineStylesTheme(resourceObjectInstance);
        gui_CBox_Country.setName("CBox_Country");
        gui_Container_5_1.addComponent(gui_CBox_Country);
        ((com.codename1.ui.layouts.LayeredLayout) gui_CBox_Country.getParent().getLayout()).setInsets(gui_CBox_Country, "-2.3841858E-7mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_CBox_Country, "-1 -1 -1 -1").setReferencePositions(gui_CBox_Country, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Label_3, "-1 -1 -1 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5_1.getLayout()).setPreferredWidthMM((float) 9.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5_1.getLayout()).setPreferredHeightMM((float) 9.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5_1.getParent().getLayout()).setInsets(gui_Container_5_1, "-5.9604645E-8mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_5_1, "-1 0 -1 -1").setReferencePositions(gui_Container_5_1, "0.0 1.0 0.0 0.0");
        gui_Container_1.addComponent(gui_btn_check_privacy);
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_continue.getParent().getLayout()).setInsets(gui_btn_continue, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_continue, "8 -1 -1 -1").setReferencePositions(gui_btn_continue, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_first_name.getLayout()).setPreferredWidthMM((float) 20.899471);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_first_name.getLayout()).setPreferredHeightMM((float) 8.994709);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_first_name.getParent().getLayout()).setInsets(gui_con_first_name, "0.0mm 0.0mm auto 55.0%").setReferenceComponents(gui_con_first_name, "-1 -1 -1 -1").setReferencePositions(gui_con_first_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_last_name.getLayout()).setPreferredWidthMM((float) 25.661375);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_last_name.getLayout()).setPreferredHeightMM((float) 8.994709);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_last_name.getParent().getLayout()).setInsets(gui_con_last_name, "0.0mm 55.0% auto 0.0mm").setReferenceComponents(gui_con_last_name, "-1 -1 -1 -1").setReferencePositions(gui_con_last_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_username.getLayout()).setPreferredWidthMM((float) 78.30688);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_username.getLayout()).setPreferredHeightMM((float) 8.994709);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_username.getParent().getLayout()).setInsets(gui_con_username, "5.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_con_username, "1 -1 -1 -1").setReferencePositions(gui_con_username, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_phone.getLayout()).setPreferredWidthMM((float) 59.25926);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_phone.getLayout()).setPreferredHeightMM((float) 8.994709);
        ((com.codename1.ui.layouts.LayeredLayout) gui_con_phone.getParent().getLayout()).setInsets(gui_con_phone, "5.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_con_phone, "3 -1 -1 -1").setReferencePositions(gui_con_phone, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 53.174603);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 9.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "5.0% 0.26454926mm auto 0.0mm").setReferenceComponents(gui_Container_2, "4 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredWidthMM((float) 26.190475);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredHeightMM((float) 9.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "5.0% 50.0% auto 0.0mm").setReferenceComponents(gui_Container_4, "5 -1 -1 -1").setReferencePositions(gui_Container_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getLayout()).setPreferredWidthMM((float) 27.248678);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getLayout()).setPreferredHeightMM((float) 9.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "5.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_5, "5 -1 -1 6 ").setReferencePositions(gui_Container_5, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_check_privacy.getParent().getLayout()).setInsets(gui_btn_check_privacy, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_check_privacy, "7 -1 -1 -1").setReferencePositions(gui_btn_check_privacy, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_3);
        gui_btn_back.setPreferredSizeStr("10.8465605mm 9.523809mm");
        gui_btn_back.setUIID("login_btn");
        gui_btn_back.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_back.setName("btn_back");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_back, "\ue5c8".charAt(0));
        gui_Label.setPreferredSizeStr("24.074074mm 11.904762mm");
        gui_Label.setText("Sign up");
        gui_Label.setUIID("lbl_white");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Container_3.addComponent(gui_btn_back);
        gui_Container_3.addComponent(gui_Label);
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_back.getParent().getLayout()).setInsets(gui_btn_back, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_btn_back, "-1 -1 -1 -1").setReferencePositions(gui_btn_back, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto 0.0mm auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 53.439156);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 114.28571);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "5.0% 2.6455026mm 0.0mm 3.7037039mm").setReferenceComponents(gui_Container_1, "3 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredWidthMM((float) 59.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredHeightMM((float) 9.78836);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 0.0mm 92.682915% 0.0mm").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 69.04762);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 116.666664);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
//        gui_btn_check_privacy.getTextAllStyles().setAlignment(LEFT);
        gui_btn_check_privacy.getTextComponent().setRTL(true);
        first_name.setRTL(true);
        first_name.getHintLabel().setRTL(true);
        last_name.setRTL(true);
        last_name.getHintLabel().setRTL(true);
        username.setRTL(true);
        username.getHintLabel().setRTL(true);
        phone.setRTL(true);
        phone.getHintLabel().setRTL(true);
    }
}
