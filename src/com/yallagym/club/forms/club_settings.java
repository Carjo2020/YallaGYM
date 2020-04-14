package com.yallagym.club.forms;

import com.cn2.ui.cn1Display;
import com.cn2.util.cn1String;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.NetworkManager;
import com.codename1.io.Preferences;
import com.codename1.io.Storage;
import static com.codename1.io.Util.sleep;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import static com.codename1.ui.CN.getCurrentForm;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.codename1.util.StringUtil;
import com.yallagym.BaseForm;

import com.yallagym.club.layouts.profile_img;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.client.layouts.Correct_Msg;
import com.yallagym.club.club_images_controller;
//import static com.yallagym.club.forms.club_BaseForm.getGym_url;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class club_settings extends club_BaseForm {

    Form frm;
    Form current;

    List<Map<String, Object>> content;
    Resources res;
    Button add_btn;
    String price_d = "0";
    String price_w = "0";
    String price_m = "0";

    public club_settings() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public club_settings(com.codename1.ui.util.Resources res) {
        checkLanguage(res);
    }

    public club_settings(com.codename1.ui.util.Resources res, Form frm) {
        checkLanguage(res);
        this.frm = frm;
        this.res = res;
        current = this;
        installFixItems();
        NetworkManager.getInstance().start();
//        addPhotos();
        gui_Infinite_Progress.setVisible(true);
        setValues();

        new UITimer(() -> {
            refreshImages();
        }).schedule(50, false, this);

//        gui_btn_save.addActionListener(e -> saveBtn());
//        Storage.getInstance().clearStorage();
//        Storage.getInstance().clearCache();
        if (!BaseForm.isArabic()) {
            this.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_CHECK, e -> {
                updateInfo();
            });
        } else {
            this.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_CHECK, e -> {
                updateInfo();
            });
        }

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Con_Images = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Container gui_Con_Details = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_tf_description = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Con_Subscription = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Container_10 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.CheckBox gui_C_BOX_Day = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.TextField gui_tf_price_day = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_11 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.CheckBox gui_C_BOX_Week = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.TextField gui_tf_price_week = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_Label_8 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_12 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.CheckBox gui_C_BOX_Month = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.TextField gui_tf_price_month = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_7 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_tf_place = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Container_8 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_tf_phone = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Container_9 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Con_From = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.spinner.Picker gui_time_from = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Con_To = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.spinner.Picker gui_time_to = new com.codename1.ui.spinner.Picker();
    protected com.codename1.components.SpanLabel gui_Span_Label = new com.codename1.components.SpanLabel();
    protected com.codename1.components.InfiniteProgress gui_Infinite_Progress = new com.codename1.components.InfiniteProgress();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_settings");
        setName("club_settings");
        gui_Container.setPreferredSizeStr("inherit 132.80423mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Con_Images.setPreferredSizeStr("inherit 38.88889mm");
                gui_Con_Images.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Images.setName("Con_Images");
        gui_Con_Details.setPreferredSizeStr("inherit 90.21164mm");
        gui_Con_Details.setUIID("Gray_Con");
                gui_Con_Details.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Details.setName("Con_Details");
        gui_Infinite_Progress.setPreferredSizeStr("11.111112mm 9.523809mm");
                gui_Infinite_Progress.setInlineStylesTheme(resourceObjectInstance);
        gui_Infinite_Progress.setName("Infinite_Progress");
        gui_Container.addComponent(gui_Con_Images);
        gui_Container.addComponent(gui_Con_Details);
        gui_Label.setPreferredSizeStr("18.25397mm 6.3492064mm");
        gui_Label.setText("Description:");
        gui_Label.setUIID("Details_Lbls");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_tf_description.setPreferredSizeStr("45.767197mm 14.550264mm");
        gui_tf_description.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        gui_tf_description.setUIID("blue_rec");
                gui_tf_description.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_description.setName("tf_description");
        gui_tf_description.setColumns(8);
        gui_Container_3.setPreferredSizeStr("62.16931mm 28.571428mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_6.setPreferredSizeStr("74.33862mm 25.661375mm");
                gui_Container_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_6.setName("Container_6");
        gui_Span_Label.setPreferredSizeStr("62.698414mm 8.201058mm");
        gui_Span_Label.setText("* Please note we will add our fees on your current price");
        gui_Span_Label.setUIID("Detalis_Sb_green");
                gui_Span_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label.setName("Span_Label");
        gui_Span_Label.setPropertyValue("textUiid", "Detalis_Sb_green");
        gui_Con_Details.addComponent(gui_Label);
        gui_Con_Details.addComponent(gui_tf_description);
        gui_Con_Details.addComponent(gui_Container_3);
        gui_Container_4.setPreferredSizeStr("36.50794mm 5.026455mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Con_Subscription.setPreferredSizeStr("31.746033mm 23.544973mm");
                gui_Con_Subscription.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Subscription.setName("Con_Subscription");
        gui_Container_3.addComponent(gui_Container_4);
        gui_Label_2.setPreferredSizeStr("72.48677mm 12.433863mm");
        gui_Label_2.setText("Choose your reservation type:");
        gui_Label_2.setUIID("Details_Lbls");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_Container_4.addComponent(gui_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        gui_Container_3.addComponent(gui_Con_Subscription);
        gui_Container_10.setPreferredSizeStr("85.71429mm 7.6719575mm");
                gui_Container_10.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_10.setName("Container_10");
        gui_Container_11.setPreferredSizeStr("85.71429mm 7.6719575mm");
                gui_Container_11.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_11.setName("Container_11");
        gui_Container_12.setPreferredSizeStr("85.71429mm 7.6719575mm");
                gui_Container_12.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_12.setName("Container_12");
        gui_Con_Subscription.addComponent(gui_Container_10);
        gui_C_BOX_Day.setPreferredSizeStr("33.597885mm 10.05291mm");
        gui_C_BOX_Day.setText("   Booking for a day");
        gui_C_BOX_Day.setUIID("blue_rec");
                gui_C_BOX_Day.setInlineStylesTheme(resourceObjectInstance);
        gui_C_BOX_Day.setName("C_BOX_Day");
        gui_tf_price_day.setPreferredSizeStr("7.4074073mm 6.0846562mm");
        gui_tf_price_day.setHint("price");
        gui_tf_price_day.setText("5");
        gui_tf_price_day.setUIID("blue_rec");
                gui_tf_price_day.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_price_day.setName("tf_price_day");
        gui_tf_price_day.setConstraint(com.codename1.ui.TextArea.DECIMAL | com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.URL);
        gui_Label_7.setPreferredSizeStr("4.4973545mm 13.227513mm");
        gui_Label_7.setText("JD");
        gui_Label_7.setUIID("Detalis_Sb_green");
                gui_Label_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_7.setName("Label_7");
        gui_Container_10.addComponent(gui_C_BOX_Day);
        gui_Container_10.addComponent(gui_tf_price_day);
        gui_Container_10.addComponent(gui_Label_7);
        ((com.codename1.ui.layouts.LayeredLayout)gui_C_BOX_Day.getParent().getLayout()).setInsets(gui_C_BOX_Day, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_C_BOX_Day, "-1 -1 -1 -1").setReferencePositions(gui_C_BOX_Day, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_price_day.getParent().getLayout()).setInsets(gui_tf_price_day, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_tf_price_day, "-1 2 -1 -1").setReferencePositions(gui_tf_price_day, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_7.getParent().getLayout()).setInsets(gui_Label_7, "0.0mm 1.8518518mm 0.0mm auto").setReferenceComponents(gui_Label_7, "-1 -1 -1 -1").setReferencePositions(gui_Label_7, "0.0 0.0 0.0 0.0");
        gui_Con_Subscription.addComponent(gui_Container_11);
        gui_C_BOX_Week.setPreferredSizeStr("33.333332mm inherit");
        gui_C_BOX_Week.setText("   Booking for a week");
        gui_C_BOX_Week.setUIID("blue_rec");
                gui_C_BOX_Week.setInlineStylesTheme(resourceObjectInstance);
        gui_C_BOX_Week.setName("C_BOX_Week");
        gui_tf_price_week.setPreferredSizeStr("7.4074073mm 5.555556mm");
        gui_tf_price_week.setHint("price");
        gui_tf_price_week.setText("10");
        gui_tf_price_week.setUIID("blue_rec");
                gui_tf_price_week.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_price_week.setName("tf_price_week");
        gui_tf_price_week.setConstraint(com.codename1.ui.TextArea.DECIMAL | com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.URL);
        gui_Label_8.setPreferredSizeStr("4.4973545mm 10.31746mm");
        gui_Label_8.setText("JD");
        gui_Label_8.setUIID("Detalis_Sb_green");
                gui_Label_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_8.setName("Label_8");
        gui_Container_11.addComponent(gui_C_BOX_Week);
        gui_Container_11.addComponent(gui_tf_price_week);
        gui_Container_11.addComponent(gui_Label_8);
        ((com.codename1.ui.layouts.LayeredLayout)gui_C_BOX_Week.getParent().getLayout()).setInsets(gui_C_BOX_Week, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_C_BOX_Week, "-1 -1 -1 -1").setReferencePositions(gui_C_BOX_Week, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_price_week.getParent().getLayout()).setInsets(gui_tf_price_week, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_tf_price_week, "-1 2 -1 -1").setReferencePositions(gui_tf_price_week, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_8.getParent().getLayout()).setInsets(gui_Label_8, "0.0mm 1.8mm 0.0mm auto").setReferenceComponents(gui_Label_8, "-1 -1 -1 -1").setReferencePositions(gui_Label_8, "0.0 0.0 0.0 0.0");
        gui_Con_Subscription.addComponent(gui_Container_12);
        gui_C_BOX_Month.setPreferredSizeStr("33.597885mm inherit");
        gui_C_BOX_Month.setText("   Booking for a month");
        gui_C_BOX_Month.setUIID("blue_rec");
                gui_C_BOX_Month.setInlineStylesTheme(resourceObjectInstance);
        gui_C_BOX_Month.setName("C_BOX_Month");
        gui_tf_price_month.setPreferredSizeStr("7.4074073mm inherit");
        gui_tf_price_month.setHint("price");
        gui_tf_price_month.setText("15");
        gui_tf_price_month.setUIID("blue_rec");
                gui_tf_price_month.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_price_month.setName("tf_price_month");
        gui_tf_price_month.setConstraint(com.codename1.ui.TextArea.DECIMAL | com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.URL);
        gui_Label_9.setPreferredSizeStr("4.4973545mm 7.142857mm");
        gui_Label_9.setText("JD");
        gui_Label_9.setUIID("Detalis_Sb_green");
                gui_Label_9.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_9.setName("Label_9");
        gui_Container_12.addComponent(gui_C_BOX_Month);
        gui_Container_12.addComponent(gui_tf_price_month);
        gui_Container_12.addComponent(gui_Label_9);
        ((com.codename1.ui.layouts.LayeredLayout)gui_C_BOX_Month.getParent().getLayout()).setInsets(gui_C_BOX_Month, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_C_BOX_Month, "-1 -1 -1 -1").setReferencePositions(gui_C_BOX_Month, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_price_month.getParent().getLayout()).setInsets(gui_tf_price_month, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_tf_price_month, "-1 2 -1 -1").setReferencePositions(gui_tf_price_month, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_9.getParent().getLayout()).setInsets(gui_Label_9, "0.0mm 1.8mm 0.0mm auto").setReferenceComponents(gui_Label_9, "-1 -1 -1 -1").setReferencePositions(gui_Label_9, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_10.getLayout()).setPreferredWidthMM((float)66.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_10.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_11.getLayout()).setPreferredWidthMM((float)66.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_11.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_12.getLayout()).setPreferredWidthMM((float)66.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_12.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)71.42857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)5.026455);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_4, "-1 -1 -1 -1").setReferencePositions(gui_Container_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Subscription.getParent().getLayout()).setInsets(gui_Con_Subscription, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Subscription, "0 -1 -1 -1").setReferencePositions(gui_Con_Subscription, "1.0 0.0 0.0 0.0");
        gui_Con_Details.addComponent(gui_Container_6);
        gui_Container_7.setPreferredSizeStr("66.137566mm 8.465609mm");
                gui_Container_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_7.setName("Container_7");
        gui_Container_8.setPreferredSizeStr("62.962963mm 8.465609mm");
                gui_Container_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_8.setName("Container_8");
        gui_Container_9.setPreferredSizeStr("62.962963mm 8.465609mm");
                gui_Container_9.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_9.setName("Container_9");
        gui_Container_6.addComponent(gui_Container_7);
        gui_Label_1.setPreferredSizeStr("11.111112mm 10.8465605mm");
        gui_Label_1.setText("Address:");
        gui_Label_1.setUIID("Details_Lbls");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_tf_place.setPreferredSizeStr("50.529102mm 9.78836mm");
        gui_tf_place.setHint("Like: Amman - City Center");
        gui_tf_place.setUIID("blue_rec");
                gui_tf_place.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_place.setName("tf_place");
        gui_tf_place.setRows(1);
        gui_Container_7.addComponent(gui_Label_1);
        gui_Container_7.addComponent(gui_tf_place);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_place.getParent().getLayout()).setInsets(gui_tf_place, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_tf_place, "-1 -1 -1 0 ").setReferencePositions(gui_tf_place, "0.0 0.0 0.0 1.0");
        gui_Container_6.addComponent(gui_Container_8);
        gui_Label_3.setPreferredSizeStr("11.111112mm 10.8465605mm");
        gui_Label_3.setText("Phone:");
        gui_Label_3.setUIID("Details_Lbls");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setName("Label_3");
        gui_tf_phone.setPreferredSizeStr("50.529102mm 9.78836mm");
        gui_tf_phone.setHint("Like: 0791234567");
        gui_tf_phone.setUIID("blue_rec");
                gui_tf_phone.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_phone.setName("tf_phone");
        gui_tf_phone.setConstraint(com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.NUMERIC | com.codename1.ui.TextArea.PHONENUMBER);
        gui_Container_8.addComponent(gui_Label_3);
        gui_Container_8.addComponent(gui_tf_phone);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Label_3, "-1 -1 -1 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_phone.getParent().getLayout()).setInsets(gui_tf_phone, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_tf_phone, "-1 -1 -1 0 ").setReferencePositions(gui_tf_phone, "0.0 0.0 0.0 1.0");
        gui_Container_6.addComponent(gui_Container_9);
        gui_Label_4.setPreferredSizeStr("18.25397mm 10.8465605mm");
        gui_Label_4.setText("Work Time from:");
        gui_Label_4.setUIID("Details_Lbls");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setInlineAllStyles("font:2.0mm; alignment:right;");
        gui_Label_4.setName("Label_4");
        gui_Con_From.setPreferredSizeStr("12.698413mm 7.4074073mm");
                gui_Con_From.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_From.setName("Con_From");
        gui_Label_6.setPreferredSizeStr("4.7619047mm 8.465609mm");
        gui_Label_6.setText("To");
        gui_Label_6.setUIID("Details_Lbls");
                gui_Label_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_6.setInlineAllStyles("font:2.0mm; alignment:center;");
        gui_Label_6.setName("Label_6");
        gui_Con_To.setPreferredSizeStr("12.698413mm 7.142857mm");
                gui_Con_To.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_To.setName("Con_To");
        gui_Container_9.addComponent(gui_Label_4);
        gui_Container_9.addComponent(gui_Con_From);
        gui_time_from.setPreferredSizeStr("23.544973mm 10.31746mm");
        gui_time_from.setText("00:00");
        gui_time_from.setUIID("blue_rec");
                gui_time_from.setInlineStylesTheme(resourceObjectInstance);
        gui_time_from.setInlineAllStyles("alignment:center;");
        gui_time_from.setName("time_from");
        gui_time_from.setType(2);
        gui_Con_From.addComponent(gui_time_from);
        ((com.codename1.ui.layouts.LayeredLayout)gui_time_from.getParent().getLayout()).setInsets(gui_time_from, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_time_from, "-1 -1 -1 -1").setReferencePositions(gui_time_from, "0.0 0.0 0.0 0.0");
        gui_Container_9.addComponent(gui_Label_6);
        gui_Container_9.addComponent(gui_Con_To);
        gui_time_to.setPreferredSizeStr("29.100529mm 12.698413mm");
        gui_time_to.setText("00:00");
        gui_time_to.setUIID("blue_rec");
                gui_time_to.setInlineStylesTheme(resourceObjectInstance);
        gui_time_to.setInlineAllStyles("alignment:center;");
        gui_time_to.setName("time_to");
        gui_time_to.setType(2);
        gui_Con_To.addComponent(gui_time_to);
        ((com.codename1.ui.layouts.LayeredLayout)gui_time_to.getParent().getLayout()).setInsets(gui_time_to, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_time_to, "-1 -1 -1 -1").setReferencePositions(gui_time_to, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Label_4, "-1 -1 -1 -1").setReferencePositions(gui_Label_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_From.getLayout()).setPreferredWidthMM((float)12.698413);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_From.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_From.getParent().getLayout()).setInsets(gui_Con_From, "auto auto auto 0.0mm").setReferenceComponents(gui_Con_From, "-1 -1 -1 0 ").setReferencePositions(gui_Con_From, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_6.getParent().getLayout()).setInsets(gui_Label_6, "0.0mm auto 2.3841858E-7mm 0.0mm").setReferenceComponents(gui_Label_6, "-1 -1 -1 1 ").setReferencePositions(gui_Label_6, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_To.getLayout()).setPreferredWidthMM((float)12.698413);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_To.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_To.getParent().getLayout()).setInsets(gui_Con_To, "auto auto auto 0.0mm").setReferenceComponents(gui_Con_To, "-1 -1 -1 2 ").setReferencePositions(gui_Con_To, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getLayout()).setPreferredWidthMM((float)66.137566);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getLayout()).setPreferredHeightMM((float)8.201058);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getParent().getLayout()).setInsets(gui_Container_7, "0.0mm 0.0mm auto -4.7683716E-7mm").setReferenceComponents(gui_Container_7, "-1 -1 -1 -1").setReferencePositions(gui_Container_7, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_8.getLayout()).setPreferredWidthMM((float)62.962963);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_8.getLayout()).setPreferredHeightMM((float)8.465609);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_8.getParent().getLayout()).setInsets(gui_Container_8, "0.0mm -1.1920929E-7mm auto -3.5762787E-7mm").setReferenceComponents(gui_Container_8, "0 -1 -1 -1").setReferencePositions(gui_Container_8, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_9.getLayout()).setPreferredWidthMM((float)62.962963);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_9.getLayout()).setPreferredHeightMM((float)8.465609);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_9.getParent().getLayout()).setInsets(gui_Container_9, "0.0mm -5.9604645E-8mm auto -4.172325E-7mm").setReferenceComponents(gui_Container_9, "1 -1 -1 -1").setReferencePositions(gui_Container_9, "1.0 0.0 0.0 0.0");
        gui_Con_Details.addComponent(gui_Span_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_description.getParent().getLayout()).setInsets(gui_tf_description, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_tf_description, "-1 -1 -1 0 ").setReferencePositions(gui_tf_description, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)71.42857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)28.571428);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_3, "3 -1 -1 -1").setReferencePositions(gui_Container_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getLayout()).setPreferredWidthMM((float)71.42857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getLayout()).setPreferredHeightMM((float)25.661375);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getParent().getLayout()).setInsets(gui_Container_6, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_6, "1 -1 -1 -1").setReferencePositions(gui_Container_6, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Label.getParent().getLayout()).setInsets(gui_Span_Label, "-2.3841858E-7mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Span_Label, "2 -1 -1 -1").setReferencePositions(gui_Span_Label, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Infinite_Progress);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Images.getParent().getLayout()).setInsets(gui_Con_Images, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Images, "-1 -1 -1 -1").setReferencePositions(gui_Con_Images, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Details.getLayout()).setPreferredWidthMM((float)77.77778);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Details.getLayout()).setPreferredHeightMM((float)90.21164);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Details.getParent().getLayout()).setInsets(gui_Con_Details, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Con_Details, "0 -1 -1 -1").setReferencePositions(gui_Con_Details, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Infinite_Progress.getParent().getLayout()).setInsets(gui_Infinite_Progress, "10.0% auto auto auto").setReferenceComponents(gui_Infinite_Progress, "-1 -1 -1 -1").setReferencePositions(gui_Infinite_Progress, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)82.01058);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)132.80423);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!BOVE THIS LINE!!!    
    private void installFixItems() {
        this.setScrollableY(false);
        this.setScrollVisible(false);
        this.setPreferredH(cn1Display.getHeight() - 300);
        this.getContentPane().setScrollableY(false);
        this.getContentPane().setScrollVisible(false);
        gui_Container.setScrollableY(true);
        gui_Container.setScrollVisible(false);
        this.setTitle("Club Information");
        installBackIcon(frm);
        installBackCommand(frm);
        this.getToolbar().setTitleCentered(true);
        gui_tf_description.setMaxSize(110);

//        gui_tf_description.addDataChangedListener(new DataChangedListener() {
//            @Override
//            public void dataChanged(int type, int index) {
//                int length = gui_tf_description.getText().length();
//                int max_size = gui_tf_description.getMaxSize();
//                if (length == max_size - 2) {
//                    ToastBar.showInfoMessage("The max size of chars for description is: " + max_size);
//                }
//            }
////        });
        gui_tf_place.setMaxSize(30);
//        gui_tf_place.addDataChangedListener(new DataChangedListener() {
//            @Override
//            public void dataChanged(int type, int index) {
//                int length = gui_tf_place.getText().length();
//                System.out.println(length);
//                int max_size = gui_tf_place.getMaxSize();
//                if (length == max_size) {
//                    ToastBar.showInfoMessage("The max size of chars for address: " + max_size);
//                }
//            }
//        });

        gui_C_BOX_Day.setSelected(true);
        gui_C_BOX_Week.setSelected(true);
        gui_C_BOX_Month.setSelected(true);
        gui_C_BOX_Day.addActionListener(e -> {
            if (!gui_C_BOX_Day.isSelected()) {
                gui_tf_price_day.setVisible(false);
                gui_Label_7.setVisible(false);
                gui_C_BOX_Day.setSelected(false);
            } else {
                gui_tf_price_day.setVisible(true);
                gui_Label_7.setVisible(true);
                gui_C_BOX_Day.setSelected(true);
            }
            revalidate();
        });
        gui_C_BOX_Week.addActionListener(e -> {

            if (!gui_C_BOX_Week.isSelected()) {
                gui_tf_price_week.setVisible(false);
                gui_Label_8.setVisible(false);
                gui_C_BOX_Week.setSelected(false);
            } else {
                gui_tf_price_week.setVisible(true);
                gui_Label_8.setVisible(true);
                gui_C_BOX_Week.setSelected(true);
            }
            revalidate();
        });
        gui_C_BOX_Month.addActionListener(e -> {

            if (!gui_C_BOX_Month.isSelected()) {
                gui_tf_price_month.setVisible(false);
                gui_Label_9.setVisible(false);
                gui_C_BOX_Month.setSelected(false);
            } else {
                gui_tf_price_month.setVisible(true);
                gui_Label_9.setVisible(true);
                gui_C_BOX_Month.setSelected(true);
            }
            revalidate();
        });
    }

    Image img = null;
    String filePath = "";
    club_APIs api = new club_APIs();
    SimpleDateFormat dateFormat = new SimpleDateFormat("H:mm");

    private void addButtonActionListener(Button add_btn) {
        add_btn.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        filePath = (String) ev.getSource();
                        System.out.println("filre path:" + filePath);
                        String id = api.uploadImg(filePath);
                        addImage(id, filePath);

                        CN.callSerially(() -> {
                            club_BaseForm.gym_url = api.getGymImages();
                            new club_images_controller().getGymImages(club_BaseForm.gym_url);
//                            club_BaseForm.profile_info_images = api.getFetchesImages(res, club_BaseForm.gym_url);
//                            refreshImages();
                        });

                    }
                }

            }, Display.GALLERY_IMAGE);
        });
    }

    private void add_btn(int width, int highet) {
        Button add_btn = new Button("+", "club_profile_btn_add_image");
        add_btn.setPreferredW(width);
        add_btn.setPreferredH(highet);
        addButtonActionListener(add_btn);
        gui_Con_Images.add(add_btn);
    }

    private void refreshImages() {
        gui_Con_Images.removeAll();
        int width = cn1Display.getWidth();
        int highet = gui_Con_Images.getPreferredH();
//        content = club_BaseForm.getProfile_info_images();
        content = getGym_url();
//        Image[] imgs = api.getImages(res, content);
//        Image[] imgs = club_BaseForm.getProfile_info_images();
        int images_count = Preferences.get("images_count", 0);
        System.out.println("images_count:" + images_count);
        Image[] imgs = new Image[images_count];
        for (int i = 0; i < images_count; i++) {
            try {
                String img0 = Preferences.get("profile_img_" + i, "");
                Storage storage = Storage.getInstance();
                if (storage.exists(img0)) {
                    imgs[i] = Image.createImage(Storage.getInstance().createInputStream(img0));
                } else {
                    imgs[i] = res.getImage("place_holder.png");
                }
            } catch (Exception e) {
                e.printStackTrace();
                imgs[i] = res.getImage("place_holder.png");
//                return;
            }
        }

        switch (images_count) {
            case 0:
                add_btn(width, highet);
                break;
            case 1:
                gui_Con_Images.add(new profile_img(res, content.get(0).get("id") + "", imgs[0], width / 2, highet));
                add_btn(width / 2, highet);
                break;
            case 2:
                gui_Con_Images.add(new profile_img(res, content.get(0).get("id") + "", imgs[0], width / 2, highet / 2));
                gui_Con_Images.add(new profile_img(res, content.get(1).get("id") + "", imgs[1], width / 2, highet / 2));
                add_btn(width, highet / 2);
                break;
            case 3:
                gui_Con_Images.add(new profile_img(res, content.get(0).get("id") + "", imgs[0], width / 2, highet / 2));
                gui_Con_Images.add(new profile_img(res, content.get(1).get("id") + "", imgs[1], width / 2, highet / 2));
                gui_Con_Images.add(new profile_img(res, content.get(2).get("id") + "", imgs[2], width / 2, highet / 2));
                add_btn(width / 2, highet / 2);
                break;
            case 4:

                gui_Con_Images.add(new profile_img(res, content.get(0).get("id") + "", imgs[0], width / 2, highet / 2));
                gui_Con_Images.add(new profile_img(res, content.get(1).get("id") + "", imgs[1], width / 2, highet / 2));
                gui_Con_Images.add(new profile_img(res, content.get(2).get("id") + "", imgs[2], width / 2, highet / 2));
                gui_Con_Images.add(new profile_img(res, content.get(3).get("id") + "", imgs[3], width / 2, highet / 2));
                add_btn(0, 0);

                break;
        }
        gui_Infinite_Progress.setVisible(false);
        gui_Con_Images.revalidate();
    }

    private void updateInfo() {
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
//        gui_Infinite_Progress.setVisible(true);
        boolean send = true;
        String dec = StringUtil.replaceAll(gui_tf_description.getText(), "\n", "\\n");
        String place = gui_tf_place.getText();
        String phone = formatPhone(gui_tf_phone.getText());
        String time_from = gui_time_from.getText();
        String time_to = gui_time_to.getText();

        if (dec.length() == 0) {
            ToastBar.showErrorMessage("Please enter description");
            send = false;
        } else {
            if (place.length() == 0) {
                ToastBar.showErrorMessage("Please enter place");
                send = false;
            } else {
                if (phone.length() == 0) {
                    ToastBar.showErrorMessage("Please enter phone");
                    send = false;
                } else {
                    if (checksub(send)) {
                        String p_d = price_d;
                        String p_w = price_w;
                        String p_m = price_m;
                        if (!gui_C_BOX_Day.isSelected()) {
                            System.out.println("run1");
                            p_d = "0";
                        }
                        if (!gui_C_BOX_Week.isSelected()) {
                            System.out.println("run2");
                            p_w = "0";
                        }
                        if (!gui_C_BOX_Month.isSelected()) {
                            System.out.println("run3");
                            p_m = "0";
                        }
                        api.updateGymInfo(dec, place, phone, time_from, time_to, p_d, p_w, p_m);
                        CN.callSerially(() -> {
                            club_APIs club_api = new club_APIs();
                            club_BaseForm.profile_info = club_api.getGymInfo();
                        });
                        dlg.dispose();
//                        gui_Infinite_Progress.setVisible(false);
                        new Correct_Msg(res, "Saved successfully", "Your update is live now.", ee -> {

                        }).show();

                    }
                }
            }
        }

    }

    private void setValues() {
        try {
            Map<String, Object> map = club_BaseForm.getProfile_info();
            String work_time = map.get("work_time") + "";
            String[] work_time_interval = cn1String.splite(work_time, "-");
            String price_d = map.get("price_d") + "";
            String price_w = map.get("price_w") + "";
            String price_m = map.get("price_m") + "";
            gui_tf_description.setText(StringUtil.replaceAll(map.get("description") + "", "\\n", "\n"));
            gui_tf_place.setText(map.get("address") + "");
            gui_tf_phone.setText(map.get("phone_gym") + "");
            gui_tf_price_day.setText(price_d);
            gui_tf_price_week.setText(price_w);
            gui_tf_price_month.setText(price_m);

            gui_time_from.setText(work_time_interval[0]);
            gui_time_to.setText(work_time_interval[1]);

            if (price_d.equals("0")) {
                gui_tf_price_day.setVisible(false);
                gui_Label_7.setVisible(false);
                gui_C_BOX_Day.setSelected(false);
            }
            if (price_w.equals("0")) {
                gui_tf_price_week.setVisible(false);
                gui_Label_8.setVisible(false);
                gui_C_BOX_Week.setSelected(false);
            }
            if (price_m.equals("0")) {
                gui_tf_price_month.setVisible(false);
                gui_Label_9.setVisible(false);
                gui_C_BOX_Month.setSelected(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    boolean checksub(boolean send) {
        String p_d = formatArabicNumber(gui_tf_price_day.getText());
        String p_w = formatArabicNumber(gui_tf_price_week.getText());
        String p_m = formatArabicNumber(gui_tf_price_month.getText());
        if (gui_C_BOX_Day.isSelected() && gui_C_BOX_Week.isSelected() && gui_C_BOX_Month.isSelected()) {
            if (p_d.equals("0")) {
                ToastBar.showErrorMessage("Please enter price for a day");
                send = false;
            } else {

                if (p_w.equals("0")) {
                    ToastBar.showErrorMessage("Please enter price for a week");
                    send = false;
                } else {

                    if (p_m.equals("0")) {
                        ToastBar.showErrorMessage("Please enter price for a month");
                        send = false;
                    } else {
                        price_d = p_d;
                        price_w = p_w;
                        price_m = p_m;
                    }
                }
            }
        } else if (!gui_C_BOX_Day.isSelected() && !gui_C_BOX_Week.isSelected() && !gui_C_BOX_Month.isSelected()) {
            new erorr_msg(res, "Submitted Error", "You should select at least one of subscription type", "Ok", null).show();
            send = false;
        } else if (!gui_C_BOX_Day.isSelected() && gui_C_BOX_Week.isSelected() && gui_C_BOX_Month.isSelected()) {
            if (p_w.equals("0")) {
                ToastBar.showErrorMessage("Please enter price for a week");
                send = false;
            } else {
                if (p_m.equals("0")) {
                    ToastBar.showErrorMessage("Please enter price for a month");
                    send = false;
                } else {
                    price_w = p_w;
                    price_m = p_m;
                }
            }

        } else if (gui_C_BOX_Day.isSelected() && !gui_C_BOX_Week.isSelected() && gui_C_BOX_Month.isSelected()) {
            if (p_d.equals("0")) {
                ToastBar.showErrorMessage("Please enter price for a day");
                send = false;
            } else {

                if (p_m.equals("0")) {
                    ToastBar.showErrorMessage("Please enter price for a month");
                    send = false;
                } else {
                    price_d = p_d;
                    price_m = p_m;
                }
            }
        } else if (gui_C_BOX_Day.isSelected() && gui_C_BOX_Week.isSelected() && !gui_C_BOX_Month.isSelected()) {
            if (p_d.equals("0")) {
                ToastBar.showErrorMessage("Please enter price for a day");
                send = false;
            } else {
                if (p_w.equals("0")) {
                    ToastBar.showErrorMessage("Please enter price for a week");
                    send = false;
                } else {
                    price_d = p_d;
                    price_w = p_w;
                }
            }
        } else if (!gui_C_BOX_Day.isSelected() && !gui_C_BOX_Week.isSelected() && gui_C_BOX_Month.isSelected()) {

            if (p_m.equals("0")) {
                ToastBar.showErrorMessage("Please enter price for a month");
                send = false;
            } else {
                price_m = p_m;
            }

        } else if (gui_C_BOX_Day.isSelected() && !gui_C_BOX_Week.isSelected() && !gui_C_BOX_Month.isSelected()) {
            if (p_d.equals("0")) {
                ToastBar.showErrorMessage("Please enter price for a day");
                send = false;
            } else {
                price_d = p_d;

            }
        } else if (!gui_C_BOX_Day.isSelected() && gui_C_BOX_Week.isSelected() && !gui_C_BOX_Month.isSelected()) {
            if (p_w.equals("0")) {
                ToastBar.showErrorMessage("Please enter price for a week");
                send = false;
            } else {
                price_w = p_w;
            }
        }
        return send;
    }

    private void addImage(String id, String filePath) {
        Image img = null;
        try {
            img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Container con = (Container) ((Container) getCurrentForm().getContentPane().getComponentAt(0)).getComponentAt(0);
        int width = cn1Display.getWidth();
        int highet = con.getPreferredH();
        int count_imgs = con.getComponentCount();
        System.out.println("count_imgs:" + count_imgs);

        Storage storage = Storage.getInstance();
        switch (count_imgs) {
            case 1:
                Button add_btn1 = (Button) con.getComponentAt(0);
                add_btn1.remove();
                profile_img con_img1 = new profile_img(res, id, img, width / 2, highet);
                gui_Con_Images.add(con_img1);
                add_btn(width / 2, highet);
                break;
            case 2:
                profile_img profile_img_1 = (profile_img) con.getComponentAt(0);
                Button add_btn2 = (Button) con.getComponentAt(1);
//                Image img_profile_img_1 = getImageAtIndex(storage, 0);
//                profile_img_1.remove();
                profile_img_1.setScaled(width / 2, highet / 2);
                add_btn2.remove();

//                profile_img con_img = new profile_img(res, price_d, img_profile_img_1, width / 2, highet / 2);
                profile_img con_img2 = new profile_img(res, id, img, width / 2, highet / 2);
//                gui_Con_Images.add(con_img);
                gui_Con_Images.add(con_img2);
                add_btn(width, highet / 2);
                break;
            case 3:
                Button add_btn3 = (Button) con.getComponentAt(2);
                add_btn3.remove();
                profile_img con_img3 = new profile_img(res, id, img, width / 2, highet / 2);
                gui_Con_Images.add(con_img3);
                add_btn(width / 2, highet / 2);
                break;
            case 4:
                Button add_btn4 = (Button) con.getComponentAt(3);
                add_btn4.remove();
                profile_img con_img4 = new profile_img(res, id, img, width / 2, highet / 2);
                gui_Con_Images.add(con_img4);
                add_btn(0, highet / 2);
                break;
        }
        getCurrentForm().revalidate();

    }

    private Image getImageAtIndex(Storage storage, int i) {
        try {
            Image img;
            String img0 = Preferences.get("profile_img_" + i, "");
            System.out.println("img0:" + img0);
            if (storage.exists(img0)) {
                System.out.println("====== img0: exist " + img0);
                img = Image.createImage(Storage.getInstance().createInputStream(img0));
            } else {
                img = res.getImage("place_holder.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
            img = res.getImage("place_holder.png");
        }
        return img;
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
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_settings");
        setName("club_settings");
        gui_Container.setPreferredSizeStr("inherit 132.80423mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Con_Images.setPreferredSizeStr("inherit 38.88889mm");
                gui_Con_Images.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Images.setName("Con_Images");
        gui_Con_Details.setPreferredSizeStr("inherit 90.21164mm");
        gui_Con_Details.setUIID("Gray_Con");
                gui_Con_Details.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Details.setName("Con_Details");
        gui_Infinite_Progress.setPreferredSizeStr("11.111112mm 9.523809mm");
                gui_Infinite_Progress.setInlineStylesTheme(resourceObjectInstance);
        gui_Infinite_Progress.setName("Infinite_Progress");
        gui_Container.addComponent(gui_Con_Images);
        gui_Container.addComponent(gui_Con_Details);
        gui_Label.setPreferredSizeStr("18.25397mm 6.3492064mm");
        gui_Label.setText("Description:");
        gui_Label.setUIID("Details_Lbls");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("alignment:right;");
        gui_Label.setName("Label");
        gui_tf_description.setPreferredSizeStr("22.222223mm 14.550264mm");
        gui_tf_description.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        gui_tf_description.setUIID("blue_rec");
                gui_tf_description.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_description.setName("tf_description");
        gui_tf_description.setColumns(8);
        gui_Container_3.setPreferredSizeStr("62.16931mm 28.571428mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_6.setPreferredSizeStr("74.33862mm 25.661375mm");
                gui_Container_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_6.setName("Container_6");
        gui_Span_Label.setPreferredSizeStr("62.698414mm 8.201058mm");
        gui_Span_Label.setText("* Please note we will add our fees on your current price");
        gui_Span_Label.setUIID("Detalis_Sb_green");
                gui_Span_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Label.setName("Span_Label");
        gui_Span_Label.setPropertyValue("textUiid", "Detalis_Sb_green");
        gui_Con_Details.addComponent(gui_Label);
        gui_Con_Details.addComponent(gui_tf_description);
        gui_Con_Details.addComponent(gui_Container_3);
        gui_Container_4.setPreferredSizeStr("36.50794mm 5.026455mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Con_Subscription.setPreferredSizeStr("31.746033mm 23.544973mm");
                gui_Con_Subscription.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Subscription.setName("Con_Subscription");
        gui_Container_3.addComponent(gui_Container_4);
        gui_Label_2.setPreferredSizeStr("72.48677mm 12.433863mm");
        gui_Label_2.setText("Choose your reservation type:");
        gui_Label_2.setUIID("Details_Lbls");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("alignment:right;");
        gui_Label_2.setName("Label_2");
        gui_Container_4.addComponent(gui_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 1.0mm 0.0mm 1.0mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        gui_Container_3.addComponent(gui_Con_Subscription);
        gui_Container_10.setPreferredSizeStr("85.71429mm 7.6719575mm");
                gui_Container_10.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_10.setName("Container_10");
        gui_Container_11.setPreferredSizeStr("85.71429mm 7.6719575mm");
                gui_Container_11.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_11.setName("Container_11");
        gui_Container_12.setPreferredSizeStr("85.71429mm 7.6719575mm");
                gui_Container_12.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_12.setName("Container_12");
        gui_Con_Subscription.addComponent(gui_Container_10);
        gui_C_BOX_Day.setPreferredSizeStr("33.597885mm 10.05291mm");
        gui_C_BOX_Day.setRTL(false);
        gui_C_BOX_Day.setText("Booking for a day");
        gui_C_BOX_Day.setUIID("blue_rec");
                gui_C_BOX_Day.setInlineStylesTheme(resourceObjectInstance);
        gui_C_BOX_Day.setName("C_BOX_Day");
        gui_C_BOX_Day.setGap(15);
        gui_tf_price_day.setPreferredSizeStr("7.4074073mm 6.0846562mm");
        gui_tf_price_day.setHint("price");
        gui_tf_price_day.setText("5");
        gui_tf_price_day.setUIID("blue_rec");
                gui_tf_price_day.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_price_day.setName("tf_price_day");
        gui_tf_price_day.setConstraint(com.codename1.ui.TextArea.DECIMAL | com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.URL);
        gui_Label_7.setPreferredSizeStr("4.4973545mm 13.227513mm");
        gui_Label_7.setText("JD");
        gui_Label_7.setUIID("Detalis_Sb_green");
                gui_Label_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_7.setName("Label_7");
        gui_Container_10.addComponent(gui_C_BOX_Day);
        gui_Container_10.addComponent(gui_tf_price_day);
        gui_Container_10.addComponent(gui_Label_7);
        ((com.codename1.ui.layouts.LayeredLayout)gui_C_BOX_Day.getParent().getLayout()).setInsets(gui_C_BOX_Day, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_C_BOX_Day, "-1 -1 -1 1 ").setReferencePositions(gui_C_BOX_Day, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_price_day.getParent().getLayout()).setInsets(gui_tf_price_day, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_tf_price_day, "-1 -1 -1 2 ").setReferencePositions(gui_tf_price_day, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_7.getParent().getLayout()).setInsets(gui_Label_7, "0.0mm auto 0.0mm 1.8518518mm").setReferenceComponents(gui_Label_7, "-1 -1 -1 -1").setReferencePositions(gui_Label_7, "0.0 0.0 0.0 0.0");
        gui_Con_Subscription.addComponent(gui_Container_11);
        gui_C_BOX_Week.setPreferredSizeStr("33.333332mm inherit");
        gui_C_BOX_Week.setRTL(false);
        gui_C_BOX_Week.setText("Booking for a week");
        gui_C_BOX_Week.setUIID("blue_rec");
                gui_C_BOX_Week.setInlineStylesTheme(resourceObjectInstance);
        gui_C_BOX_Week.setName("C_BOX_Week");
        gui_C_BOX_Week.setGap(15);
        gui_tf_price_week.setPreferredSizeStr("7.4074073mm 5.555556mm");
        gui_tf_price_week.setHint("price");
        gui_tf_price_week.setText("10");
        gui_tf_price_week.setUIID("blue_rec");
                gui_tf_price_week.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_price_week.setName("tf_price_week");
        gui_tf_price_week.setConstraint(com.codename1.ui.TextArea.DECIMAL | com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.URL);
        gui_Label_8.setPreferredSizeStr("4.4973545mm 10.31746mm");
        gui_Label_8.setText("JD");
        gui_Label_8.setUIID("Detalis_Sb_green");
                gui_Label_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_8.setName("Label_8");
        gui_Container_11.addComponent(gui_C_BOX_Week);
        gui_Container_11.addComponent(gui_tf_price_week);
        gui_Container_11.addComponent(gui_Label_8);
        ((com.codename1.ui.layouts.LayeredLayout)gui_C_BOX_Week.getParent().getLayout()).setInsets(gui_C_BOX_Week, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_C_BOX_Week, "-1 -1 -1 1 ").setReferencePositions(gui_C_BOX_Week, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_price_week.getParent().getLayout()).setInsets(gui_tf_price_week, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_tf_price_week, "-1 -1 -1 2 ").setReferencePositions(gui_tf_price_week, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_8.getParent().getLayout()).setInsets(gui_Label_8, "0.0mm auto 0.0mm 1.8mm").setReferenceComponents(gui_Label_8, "-1 -1 -1 -1").setReferencePositions(gui_Label_8, "0.0 0.0 0.0 0.0");
        gui_Con_Subscription.addComponent(gui_Container_12);
        gui_C_BOX_Month.setPreferredSizeStr("33.597885mm inherit");
        gui_C_BOX_Month.setRTL(false);
        gui_C_BOX_Month.setText("Booking for a month");
        gui_C_BOX_Month.setUIID("blue_rec");
                gui_C_BOX_Month.setInlineStylesTheme(resourceObjectInstance);
        gui_C_BOX_Month.setName("C_BOX_Month");
        gui_C_BOX_Month.setGap(15);
        gui_tf_price_month.setPreferredSizeStr("7.4074073mm inherit");
        gui_tf_price_month.setHint("price");
        gui_tf_price_month.setText("15");
        gui_tf_price_month.setUIID("blue_rec");
                gui_tf_price_month.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_price_month.setName("tf_price_month");
        gui_tf_price_month.setConstraint(com.codename1.ui.TextArea.DECIMAL | com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.URL);
        gui_Label_9.setPreferredSizeStr("4.4973545mm 7.142857mm");
        gui_Label_9.setText("JD");
        gui_Label_9.setUIID("Detalis_Sb_green");
                gui_Label_9.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_9.setName("Label_9");
        gui_Container_12.addComponent(gui_C_BOX_Month);
        gui_Container_12.addComponent(gui_tf_price_month);
        gui_Container_12.addComponent(gui_Label_9);
        ((com.codename1.ui.layouts.LayeredLayout)gui_C_BOX_Month.getParent().getLayout()).setInsets(gui_C_BOX_Month, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_C_BOX_Month, "-1 -1 -1 1 ").setReferencePositions(gui_C_BOX_Month, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_price_month.getParent().getLayout()).setInsets(gui_tf_price_month, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_tf_price_month, "-1 -1 -1 2 ").setReferencePositions(gui_tf_price_month, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_9.getParent().getLayout()).setInsets(gui_Label_9, "0.0mm auto 0.0mm 1.8mm").setReferenceComponents(gui_Label_9, "-1 -1 -1 -1").setReferencePositions(gui_Label_9, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_10.getLayout()).setPreferredWidthMM((float)66.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_10.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_11.getLayout()).setPreferredWidthMM((float)66.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_11.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_12.getLayout()).setPreferredWidthMM((float)66.666664);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_12.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)71.42857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)5.026455);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_4, "-1 -1 -1 -1").setReferencePositions(gui_Container_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Subscription.getParent().getLayout()).setInsets(gui_Con_Subscription, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Subscription, "0 -1 -1 -1").setReferencePositions(gui_Con_Subscription, "1.0 0.0 0.0 0.0");
        gui_Con_Details.addComponent(gui_Container_6);
        gui_Container_7.setPreferredSizeStr("66.137566mm 8.465609mm");
                gui_Container_7.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_7.setName("Container_7");
        gui_Container_8.setPreferredSizeStr("62.962963mm 8.465609mm");
                gui_Container_8.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_8.setName("Container_8");
        gui_Container_9.setPreferredSizeStr("62.962963mm 8.465609mm");
                gui_Container_9.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_9.setName("Container_9");
        gui_Container_6.addComponent(gui_Container_7);
        gui_Label_1.setPreferredSizeStr("11.111112mm 10.8465605mm");
        gui_Label_1.setText("Address:");
        gui_Label_1.setUIID("Details_Lbls");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("alignment:right;");
        gui_Label_1.setName("Label_1");
        gui_tf_place.setPreferredSizeStr("28.571428mm 9.78836mm");
        gui_tf_place.setHint("Like: Amman - City Center");
        gui_tf_place.setUIID("blue_rec");
                gui_tf_place.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_place.setName("tf_place");
        gui_tf_place.setRows(1);
        gui_Container_7.addComponent(gui_Label_1);
        gui_Container_7.addComponent(gui_tf_place);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_place.getParent().getLayout()).setInsets(gui_tf_place, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_tf_place, "-1 0 -1 -1").setReferencePositions(gui_tf_place, "0.0 1.0 0.0 0.0");
        gui_Container_6.addComponent(gui_Container_8);
        gui_Label_3.setPreferredSizeStr("11.111112mm 10.8465605mm");
        gui_Label_3.setText("Phone:");
        gui_Label_3.setUIID("Details_Lbls");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("alignment:right;");
        gui_Label_3.setName("Label_3");
        gui_tf_phone.setPreferredSizeStr("30.952381mm 9.78836mm");
        gui_tf_phone.setHint("Like: 0791234567");
        gui_tf_phone.setUIID("blue_rec");
                gui_tf_phone.setInlineStylesTheme(resourceObjectInstance);
        gui_tf_phone.setName("tf_phone");
        gui_tf_phone.setConstraint(com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.NUMERIC | com.codename1.ui.TextArea.PHONENUMBER);
        gui_Container_8.addComponent(gui_Label_3);
        gui_Container_8.addComponent(gui_tf_phone);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Label_3, "-1 -1 -1 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_phone.getParent().getLayout()).setInsets(gui_tf_phone, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_tf_phone, "-1 0 -1 -1").setReferencePositions(gui_tf_phone, "0.0 1.0 0.0 0.0");
        gui_Container_6.addComponent(gui_Container_9);
        gui_Label_4.setPreferredSizeStr("18.25397mm 10.8465605mm");
        gui_Label_4.setText("Work Time from:");
        gui_Label_4.setUIID("Details_Lbls");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setInlineAllStyles("font:2.0mm; alignment:left;");
        gui_Label_4.setName("Label_4");
        gui_Con_From.setPreferredSizeStr("12.698413mm 7.4074073mm");
                gui_Con_From.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_From.setName("Con_From");
        gui_Label_6.setPreferredSizeStr("4.7619047mm 8.465609mm");
        gui_Label_6.setText("To");
        gui_Label_6.setUIID("Details_Lbls");
                gui_Label_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_6.setInlineAllStyles("font:2.0mm; alignment:center;");
        gui_Label_6.setName("Label_6");
        gui_Con_To.setPreferredSizeStr("12.698413mm 7.142857mm");
                gui_Con_To.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_To.setName("Con_To");
        gui_Container_9.addComponent(gui_Label_4);
        gui_Container_9.addComponent(gui_Con_From);
        gui_time_from.setPreferredSizeStr("23.544973mm 10.31746mm");
        gui_time_from.setText("00:00");
        gui_time_from.setUIID("blue_rec");
                gui_time_from.setInlineStylesTheme(resourceObjectInstance);
        gui_time_from.setInlineAllStyles("alignment:center;");
        gui_time_from.setName("time_from");
        gui_time_from.setType(2);
        gui_Con_From.addComponent(gui_time_from);
        ((com.codename1.ui.layouts.LayeredLayout)gui_time_from.getParent().getLayout()).setInsets(gui_time_from, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_time_from, "-1 -1 -1 -1").setReferencePositions(gui_time_from, "0.0 0.0 0.0 0.0");
        gui_Container_9.addComponent(gui_Label_6);
        gui_Container_9.addComponent(gui_Con_To);
        gui_time_to.setPreferredSizeStr("29.100529mm 12.698413mm");
        gui_time_to.setText("00:00");
        gui_time_to.setUIID("blue_rec");
                gui_time_to.setInlineStylesTheme(resourceObjectInstance);
        gui_time_to.setInlineAllStyles("alignment:center;");
        gui_time_to.setName("time_to");
        gui_time_to.setType(2);
        gui_Con_To.addComponent(gui_time_to);
        ((com.codename1.ui.layouts.LayeredLayout)gui_time_to.getParent().getLayout()).setInsets(gui_time_to, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_time_to, "-1 -1 -1 -1").setReferencePositions(gui_time_to, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Label_4, "-1 -1 -1 -1").setReferencePositions(gui_Label_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_From.getLayout()).setPreferredWidthMM((float)12.698413);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_From.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_From.getParent().getLayout()).setInsets(gui_Con_From, "auto 0.0mm auto auto").setReferenceComponents(gui_Con_From, "-1 0 -1 -1").setReferencePositions(gui_Con_From, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_6.getParent().getLayout()).setInsets(gui_Label_6, "0.0mm 0.0mm 2.3841858E-7mm auto").setReferenceComponents(gui_Label_6, "-1 1 -1 -1").setReferencePositions(gui_Label_6, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_To.getLayout()).setPreferredWidthMM((float)12.698413);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_To.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_To.getParent().getLayout()).setInsets(gui_Con_To, "auto 0.0mm auto auto").setReferenceComponents(gui_Con_To, "-1 2 -1 -1").setReferencePositions(gui_Con_To, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getLayout()).setPreferredWidthMM((float)66.137566);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getLayout()).setPreferredHeightMM((float)8.201058);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_7.getParent().getLayout()).setInsets(gui_Container_7, "0.0mm 0.0mm auto -4.7683716E-7mm").setReferenceComponents(gui_Container_7, "-1 -1 -1 -1").setReferencePositions(gui_Container_7, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_8.getLayout()).setPreferredWidthMM((float)62.962963);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_8.getLayout()).setPreferredHeightMM((float)8.465609);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_8.getParent().getLayout()).setInsets(gui_Container_8, "0.0mm -1.1920929E-7mm auto -3.5762787E-7mm").setReferenceComponents(gui_Container_8, "0 -1 -1 -1").setReferencePositions(gui_Container_8, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_9.getLayout()).setPreferredWidthMM((float)62.962963);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_9.getLayout()).setPreferredHeightMM((float)8.465609);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_9.getParent().getLayout()).setInsets(gui_Container_9, "0.0mm -5.9604645E-8mm auto -4.172325E-7mm").setReferenceComponents(gui_Container_9, "1 -1 -1 -1").setReferencePositions(gui_Container_9, "1.0 0.0 0.0 0.0");
        gui_Con_Details.addComponent(gui_Span_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tf_description.getParent().getLayout()).setInsets(gui_tf_description, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_tf_description, "-1 0 -1 -1").setReferencePositions(gui_tf_description, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)71.42857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)28.571428);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_3, "3 -1 -1 -1").setReferencePositions(gui_Container_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getLayout()).setPreferredWidthMM((float)71.42857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getLayout()).setPreferredHeightMM((float)25.661375);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getParent().getLayout()).setInsets(gui_Container_6, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_6, "1 -1 -1 -1").setReferencePositions(gui_Container_6, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Label.getParent().getLayout()).setInsets(gui_Span_Label, "-2.3841858E-7mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Span_Label, "2 -1 -1 -1").setReferencePositions(gui_Span_Label, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Infinite_Progress);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Images.getParent().getLayout()).setInsets(gui_Con_Images, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Images, "-1 -1 -1 -1").setReferencePositions(gui_Con_Images, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Details.getLayout()).setPreferredWidthMM((float)77.77778);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Details.getLayout()).setPreferredHeightMM((float)90.21164);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Details.getParent().getLayout()).setInsets(gui_Con_Details, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Con_Details, "0 -1 -1 -1").setReferencePositions(gui_Con_Details, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Infinite_Progress.getParent().getLayout()).setInsets(gui_Infinite_Progress, "10.0% auto auto auto").setReferenceComponents(gui_Infinite_Progress, "-1 -1 -1 -1").setReferencePositions(gui_Infinite_Progress, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)82.01058);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)132.80423);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>


    private void setRTLCmb(Resources res) {
        gui_Span_Label.setRTL(true);
        gui_Span_Label.getTextComponent().setRTL(true);
    }
}
