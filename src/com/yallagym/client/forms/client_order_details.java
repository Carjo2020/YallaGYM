package com.yallagym.client.forms;

import com.cn2.ui.cn1Icons;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Preferences;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.maps.Coord;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.club.forms.club_APIs;
import java.io.InputStream;
import java.util.Date;

public class client_order_details extends BaseForm {

    Resources res;
    String id_order;
    String pay_type;
    SimpleDateFormat dateFormat = new SimpleDateFormat("d / M / yyyy");
    String gym_name;
    String SUBSCRIPTION_TYPE;

    public client_order_details() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public client_order_details(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }

    public client_order_details(com.codename1.ui.util.Resources res, Form frm, String id_order, String gym_name, String token, String location, Coord coord, String total_price, String date_start, String date_end, String sub_type, String pay_type, String status, String phone) {
        checkLanguage(res);
        this.res = res;
        this.id_order = id_order;
        this.pay_type = pay_type;
        this.gym_name = gym_name;
        installTitleArea(res);
        installBackCommand(frm);
        installBackIcon(frm);
        gui_lbl_person_name.setText(Preferences.get("name", ""));
        Image img = getQrCodeImage(token, "order_" + id_order + ".png");
        gui_lbl_qrcode.getAllStyles().setBgImage(img);
        gui_lbl_gym_name.setText(gym_name);
        gui_lbl_qrcode.setPreferredW(gui_lbl_qrcode.getPreferredH());
        gui_Label_2.setPreferredW(gui_Label_2.getPreferredH());
        gui_Label_3.setPreferredH(3);
        gui_Label_5.setPreferredH(3);
        long date_start_l = Long.parseLong(date_start);
        long date_end_l = Long.parseLong(date_end);
        System.out.println("date_start_l:" + date_start_l);
        System.out.println("date_end_l:" + date_end_l);
        System.out.println((date_end_l - date_start_l) / (1000 * 3600 * 24));
        if (sub_type.equalsIgnoreCase("price_d")) {
            gui_lbl_subscribe_type.setText("Daily Subscription");
            SUBSCRIPTION_TYPE = (!isArabic()) ? "day" : "يوم";

        } else if (sub_type.equalsIgnoreCase("price_w")) {
            gui_lbl_subscribe_type.setText("Weekly Subscription");
            SUBSCRIPTION_TYPE = (!isArabic()) ? "week" : "اسبوع";
        } else if (sub_type.equalsIgnoreCase("price_m")) {
            gui_lbl_subscribe_type.setText("Monthly Subscription");
            SUBSCRIPTION_TYPE = (!isArabic()) ? "month" : "شهر";
        }
        gui_btn_location.addActionListener(e -> {
            String map_url = "";
          if (isAndroid()) {
                map_url = "geo:<" + coord.getLatitude() + ">,<" + coord.getLongitude() + ">?q=<" + coord.getLatitude() + ">,<" + coord.getLongitude() + ">(" + gym_name + ")";
                Display.getInstance().execute(map_url);
            } else {
                new map_form(res, new list_form(res), coord).show();
//                map_url = "https://www.google.com/maps/search/?api=1&query=" + coord.getLatitude() + "," + coord.getLongitude();
            }

        });

        gui_lbl_total_price.setText(total_price + " JOD");
        gui_lbl_start_date_no.setText(dateFormat.format(new Date(date_start_l)));
        gui_lbl_end_date_no.setText(dateFormat.format(new Date(date_end_l)));
        if (status.equals("pending")) {
            gui_lbl_status.setUIID("client_lbl_details_order_status_onhold");
//            gui_lbl_status.setIcon(new cn1Icons().getImage("brightness 1", "MyOrder_Item_Sb_Pending", 3));
//            gui_lbl_status.setText("Dear customer,\nyour order is on hold");
            gui_lbl_status.setText("Order status : On Hold");
            gui_btn_call_gym.getAllStyles().setBgColor(0xe99b35);
            gui_btn_location.getAllStyles().setBgColor(0xe99b35);
//            gui_btn_qrcode.setVisible(true);
        }
        if (status.equals("accepted") || status.equals("ended")) {
            gui_lbl_status.setUIID("client_lbl_details_order_status_accepted");
//            gui_lbl_status.setIcon(new cn1Icons().getImage("brightness 1", "MyOrder_Item_Sb_Pending_Accepted", 3));
            gui_lbl_status.setText("Order status : Accepted");
//            gui_btn_qrcode.setVisible(true);
        }
        if (status.equals("blocked") || status.equals("rejected")) {
            gui_lbl_status.setUIID("client_lbl_details_order_status_rejected");
//            gui_lbl_status.setIcon(new cn1Icons().getImage("brightness 1", "MyOrder_Item_Sb_Pending_Deleted", 3));
            gui_lbl_status.setText("Order status : Rejected");
            gui_btn_call_gym.getAllStyles().setBgColor(0xc90000);
            gui_btn_location.getAllStyles().setBgColor(0xc90000);

        }
//        gui_btn_cancel.setVisible(false);
        gui_btn_call_gym.addActionListener(e -> {
            System.out.println("phone:" + phone);
            Display.getInstance().dial(phone);
        });
//        gui_btn_share.getAllStyles().setFgColor(0xA3CC2E);
        gui_btn_share.setIcon(new cn1Icons().getImage("share", "btn_share", 4));
        gui_btn_share.setPreferredH(gui_btn_cancel.getPreferredH());
    }
//////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_cancel = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_person_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_qrcode = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_subscribe_type = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_total_price = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_gym_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_location = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_location = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_status = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_call_gym = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_share = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_start_date = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_start_date_no = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_end_date = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_end_date_no = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_cancel.addActionListener(callback);
        gui_btn_share.addActionListener(callback);
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
            if(sourceComponent == gui_btn_share) {
                onbtn_shareActionEvent(ev);
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
        setTitle("client_order_details");
        setName("client_order_details");
        gui_Container.setUIID("Dialog_ContantPane");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_btn_cancel.setPreferredSizeStr("7.6719575mm 6.878307mm");
        gui_btn_cancel.setText("X");
        gui_btn_cancel.setUIID("btn_share");
                gui_btn_cancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_cancel.setInlineAllStyles("font:4.0mm; alignment:center;");
        gui_btn_cancel.setName("btn_cancel");
        gui_lbl_person_name.setPreferredSizeStr("74.07407mm inherit");
        gui_lbl_person_name.setText("Sara Noor");
                gui_lbl_person_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_person_name.setInlineAllStyles("font:5.0mm; alignment:center;");
        gui_lbl_person_name.setName("lbl_person_name");
        gui_lbl_qrcode.setPreferredSizeStr("28.571428mm 24.074074mm");
                gui_lbl_qrcode.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_qrcode.setName("lbl_qrcode");
        gui_lbl_subscribe_type.setPreferredSizeStr("83.333336mm 5.026455mm");
        gui_lbl_subscribe_type.setText("Weekly Subscribtion");
        gui_lbl_subscribe_type.setUIID("client_lbl_details_orders");
                gui_lbl_subscribe_type.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_subscribe_type.setInlineAllStyles("font:2.5mm; alignment:center;");
        gui_lbl_subscribe_type.setName("lbl_subscribe_type");
        gui_Label_2.setPreferredSizeStr("16.666666mm 15.343915mm");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("bgImage:user_green_512_ic.png;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("69.57672mm 0.7936508mm");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("bgImage:devider_gray_ic.png;");
        gui_Label_3.setName("Label_3");
        gui_lbl_total_price.setPreferredSizeStr("39.94709mm 6.878307mm");
        gui_lbl_total_price.setText("10.0 JOD");
                gui_lbl_total_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total_price.setInlineAllStyles("font:5.0mm; alignment:center;");
        gui_lbl_total_price.setName("lbl_total_price");
        gui_Label_5.setPreferredSizeStr("94.97355mm 0.7936508mm");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("bgImage:devider_gray_ic.png;");
        gui_Label_5.setName("Label_5");
        gui_lbl_gym_name.setPreferredSizeStr("79.10053mm 6.0846562mm");
        gui_lbl_gym_name.setText("AlBadr Fitness Center");
        gui_lbl_gym_name.setUIID("client_lbl_details_orders");
                gui_lbl_gym_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_gym_name.setInlineAllStyles("font:4.0mm; alignment:center;");
        gui_lbl_gym_name.setName("lbl_gym_name");
        gui_lbl_location.setPreferredSizeStr("77.77778mm 6.0846562mm");
        gui_lbl_location.setText("As Sakhrah Al Musharrafah St., Amman");
        gui_lbl_location.setUIID("client_lbl_details_orders");
                gui_lbl_location.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_location.setInlineAllStyles("alignment:center;");
        gui_lbl_location.setName("lbl_location");
        gui_btn_location.setPreferredSizeStr("38.359787mm 6.878307mm");
        gui_btn_location.setText("SEE ON MAP");
        gui_btn_location.setUIID("client_details_order_btn");
                gui_btn_location.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_location.setInlineAllStyles("alignment:center;");
        gui_btn_location.setName("btn_location");
        gui_lbl_status.setPreferredSizeStr("51.0582mm 8.730159mm");
        gui_lbl_status.setText("Order status : Accepted ");
                gui_lbl_status.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_status.setName("lbl_status");
        gui_btn_call_gym.setPreferredSizeStr("38.359787mm 6.878307mm");
        gui_btn_call_gym.setText("CALL GYM");
        gui_btn_call_gym.setUIID("client_details_order_btn");
                gui_btn_call_gym.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_call_gym.setInlineAllStyles("alignment:center;");
        gui_btn_call_gym.setName("btn_call_gym");
        gui_btn_share.setPreferredSizeStr("inherit 6.3492064mm");
        gui_btn_share.setUIID("btn_share");
                gui_btn_share.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_share.setName("btn_share");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_share,"\ue80d".charAt(0));
        gui_Container_1.setPreferredSizeStr("67.72487mm 5.291005mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("63.492065mm 5.291005mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_btn_cancel);
        gui_Container.addComponent(gui_lbl_person_name);
        gui_Container.addComponent(gui_lbl_qrcode);
        gui_Container.addComponent(gui_lbl_subscribe_type);
        gui_Container.addComponent(gui_Label_2);
        gui_Container.addComponent(gui_Label_3);
        gui_Container.addComponent(gui_lbl_total_price);
        gui_Container.addComponent(gui_Label_5);
        gui_Container.addComponent(gui_lbl_gym_name);
        gui_Container.addComponent(gui_lbl_location);
        gui_Container.addComponent(gui_btn_location);
        gui_Container.addComponent(gui_lbl_status);
        gui_Container.addComponent(gui_btn_call_gym);
        gui_Container.addComponent(gui_btn_share);
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_start_date.setPreferredSizeStr("69.57672mm 5.820106mm");
        gui_lbl_start_date.setText("Start date : ");
                gui_lbl_start_date.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_start_date.setInlineAllStyles("font:3.0mm; alignment:right;");
        gui_lbl_start_date.setName("lbl_start_date");
        gui_lbl_start_date_no.setPreferredSizeStr("18.78307mm 8.465609mm");
                gui_lbl_start_date_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_start_date_no.setInlineAllStyles("font:3.0mm; alignment:left;");
        gui_lbl_start_date_no.setName("lbl_start_date_no");
        gui_Container_1.addComponent(gui_lbl_start_date);
        gui_Container_1.addComponent(gui_lbl_start_date_no);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_start_date.getParent().getLayout()).setInsets(gui_lbl_start_date, "0.0mm 50.0% 0.0mm 0.0mm").setReferenceComponents(gui_lbl_start_date, "-1 -1 -1 -1").setReferencePositions(gui_lbl_start_date, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_start_date_no.getParent().getLayout()).setInsets(gui_lbl_start_date_no, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_start_date_no, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_start_date_no, "0.0 0.0 0.0 1.0");
        gui_Container.addComponent(gui_Container_2);
        gui_lbl_end_date.setPreferredSizeStr("69.57672mm 5.820106mm");
        gui_lbl_end_date.setText("End date : ");
                gui_lbl_end_date.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_end_date.setInlineAllStyles("font:3.0mm; alignment:right;");
        gui_lbl_end_date.setName("lbl_end_date");
        gui_lbl_end_date_no.setPreferredSizeStr("18.78307mm 8.465609mm");
                gui_lbl_end_date_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_end_date_no.setInlineAllStyles("font:3.0mm; alignment:left;");
        gui_lbl_end_date_no.setName("lbl_end_date_no");
        gui_Container_2.addComponent(gui_lbl_end_date);
        gui_Container_2.addComponent(gui_lbl_end_date_no);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_end_date.getParent().getLayout()).setInsets(gui_lbl_end_date, "0.0mm 50.0% 0.0mm 0.0mm").setReferenceComponents(gui_lbl_end_date, "-1 -1 -1 -1").setReferencePositions(gui_lbl_end_date, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_end_date_no.getParent().getLayout()).setInsets(gui_lbl_end_date_no, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_end_date_no, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_end_date_no, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_cancel.getParent().getLayout()).setInsets(gui_btn_cancel, "0.0mm -5.9604645E-8mm auto auto").setReferenceComponents(gui_btn_cancel, "-1 -1 -1 -1").setReferencePositions(gui_btn_cancel, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_person_name.getParent().getLayout()).setInsets(gui_lbl_person_name, "3.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_person_name, "4 -1 -1 -1").setReferencePositions(gui_lbl_person_name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_qrcode.getParent().getLayout()).setInsets(gui_lbl_qrcode, "2.0mm auto auto auto").setReferenceComponents(gui_lbl_qrcode, "1 -1 -1 -1").setReferencePositions(gui_lbl_qrcode, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_subscribe_type.getParent().getLayout()).setInsets(gui_lbl_subscribe_type, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_subscribe_type, "15 -1 -1 -1").setReferencePositions(gui_lbl_subscribe_type, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "3.0mm auto auto auto").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_3, "10 -1 -1 -1").setReferencePositions(gui_Label_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total_price.getParent().getLayout()).setInsets(gui_lbl_total_price, "0.0mm auto auto auto").setReferenceComponents(gui_lbl_total_price, "5 -1 -1 -1").setReferencePositions(gui_lbl_total_price, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_5, "6 -1 -1 -1").setReferencePositions(gui_Label_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_gym_name.getParent().getLayout()).setInsets(gui_lbl_gym_name, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_gym_name, "2 -1 -1 -1").setReferencePositions(gui_lbl_gym_name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_location.getParent().getLayout()).setInsets(gui_lbl_location, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_location, "8 -1 -1 -1").setReferencePositions(gui_lbl_location, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_location.getParent().getLayout()).setInsets(gui_btn_location, "0.0mm 51.0% auto 3.4391534mm").setReferenceComponents(gui_btn_location, "9 -1 -1 -1").setReferencePositions(gui_btn_location, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_status.getParent().getLayout()).setInsets(gui_lbl_status, "1.0mm auto auto auto").setReferenceComponents(gui_lbl_status, "3 -1 -1 -1").setReferencePositions(gui_lbl_status, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_call_gym.getParent().getLayout()).setInsets(gui_btn_call_gym, "0.0mm 3.4391534mm auto 55.0%").setReferenceComponents(gui_btn_call_gym, "9 -1 -1 -1").setReferencePositions(gui_btn_call_gym, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_share.getParent().getLayout()).setInsets(gui_btn_share, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_btn_share, "-1 -1 -1 -1").setReferencePositions(gui_btn_share, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)67.72487);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)5.291005);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "7 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)63.492065);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)5.291005);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_2, "14 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    private Image getQrCodeImage(String textImage, String nameImage) {
        Image placeholder = Image.createImage(500, 500, 0xbfc9d2);
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        try {

//            Image img = URLImage.createToStorage(encImage, "https://chart.googleapis.com/chart?cht=qr&chl=textImage&chs=160x160&chld=L|0", nameImage);
            FileSystemStorage fs = FileSystemStorage.getInstance();
            Util.downloadUrlToFile("https://chart.googleapis.com/chart?cht=qr&chl=" + textImage + "&chs=160x160&chld=L|0", FileSystemStorage.getInstance().getAppHomePath() + "/" + nameImage, true);
            InputStream is = fs.openInputStream(FileSystemStorage.getInstance().getAppHomePath() + "/" + nameImage);
            Image img = Image.createImage(is);
            return img;
        } catch (Exception e) {
            Log.p(e.getMessage());
        }
        return placeholder;
    }
    erorr dlg;
    APIs api = new APIs();

    club_APIs club_api = new club_APIs();

    public void onbtn_cancelActionEvent(com.codename1.ui.events.ActionEvent ev) {
        dlg = new erorr(res, "Warning Message", "Do you want to cancel this order?", "Yes", e -> {
            dlg.dispose();
            if (pay_type.equals("offline")) {
                club_api.changeStatus(id_order, "deleted");
//                this.remove();
//                getCurrentForm().revalidate();
                new client_orders(res, new list_form(res)).show();
            } else {
                ///.. do refund online payment mouny
            }

        });
        dlg.show();
    }

    public void onbtn_shareActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if (!isArabic()) {
            Display.getInstance().share("I will be visiting " + gym_name + " for a " + SUBSCRIPTION_TYPE + " using yalla gym app", null, null);
        } else {
            Display.getInstance().share("سأزور نادي " + gym_name + " لمدة " + SUBSCRIPTION_TYPE + " باستخدام تطبيق yalla gym", null, null);
        }
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
//        Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
//        Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("client_order_details");
        setName("client_order_details");
        gui_Container.setUIID("Dialog_ContantPane");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_btn_cancel.setPreferredSizeStr("7.6719575mm 6.878307mm");
        gui_btn_cancel.setText("X");
        gui_btn_cancel.setUIID("btn_share");
        gui_btn_cancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_cancel.setInlineAllStyles("font:4.0mm; alignment:center;");
        gui_btn_cancel.setName("btn_cancel");
        gui_lbl_person_name.setPreferredSizeStr("74.07407mm inherit");
        gui_lbl_person_name.setText("Sara Noor");
        gui_lbl_person_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_person_name.setInlineAllStyles("font:5.0mm; alignment:center;");
        gui_lbl_person_name.setName("lbl_person_name");
        gui_lbl_qrcode.setPreferredSizeStr("28.571428mm 24.074074mm");
        gui_lbl_qrcode.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_qrcode.setName("lbl_qrcode");
        gui_lbl_subscribe_type.setPreferredSizeStr("83.333336mm 5.026455mm");
        gui_lbl_subscribe_type.setText("Weekly Subscribtion");
        gui_lbl_subscribe_type.setUIID("client_lbl_details_orders");
        gui_lbl_subscribe_type.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_subscribe_type.setInlineAllStyles("font:2.5mm; alignment:center;");
        gui_lbl_subscribe_type.setName("lbl_subscribe_type");
        gui_Label_2.setPreferredSizeStr("16.666666mm 15.343915mm");
        gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("bgImage:user_green_512_ic.png;");
        gui_Label_2.setName("Label_2");
        gui_Label_3.setPreferredSizeStr("69.57672mm 0.7936508mm");
        gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("bgImage:devider_gray_ic.png;");
        gui_Label_3.setName("Label_3");
        gui_lbl_total_price.setPreferredSizeStr("39.94709mm 6.878307mm");
        gui_lbl_total_price.setText("10.0 JOD");
        gui_lbl_total_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total_price.setInlineAllStyles("font:5.0mm; alignment:center;");
        gui_lbl_total_price.setName("lbl_total_price");
        gui_Label_5.setPreferredSizeStr("94.97355mm 0.7936508mm");
        gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("bgImage:devider_gray_ic.png;");
        gui_Label_5.setName("Label_5");
        gui_lbl_gym_name.setPreferredSizeStr("79.10053mm 6.0846562mm");
        gui_lbl_gym_name.setText("AlBadr Fitness Center");
        gui_lbl_gym_name.setUIID("client_lbl_details_orders");
        gui_lbl_gym_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_gym_name.setInlineAllStyles("font:4.0mm; alignment:center;");
        gui_lbl_gym_name.setName("lbl_gym_name");
        gui_lbl_location.setPreferredSizeStr("77.77778mm 6.0846562mm");
        gui_lbl_location.setText("As Sakhrah Al Musharrafah St., Amman");
        gui_lbl_location.setUIID("client_lbl_details_orders");
        gui_lbl_location.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_location.setInlineAllStyles("alignment:center;");
        gui_lbl_location.setName("lbl_location");
        gui_btn_location.setPreferredSizeStr("38.359787mm 6.878307mm");
        gui_btn_location.setText("SEE ON MAP");
        gui_btn_location.setUIID("client_details_order_btn");
        gui_btn_location.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_location.setInlineAllStyles("alignment:center;");
        gui_btn_location.setName("btn_location");
        gui_lbl_status.setPreferredSizeStr("51.0582mm 8.730159mm");
        gui_lbl_status.setText("Order status : Accepted ");
        gui_lbl_status.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_status.setName("lbl_status");
        gui_btn_call_gym.setPreferredSizeStr("21.693121mm 6.878307mm");
        gui_btn_call_gym.setText("CALL GYM");
        gui_btn_call_gym.setUIID("client_details_order_btn");
        gui_btn_call_gym.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_call_gym.setInlineAllStyles("alignment:center;");
        gui_btn_call_gym.setName("btn_call_gym");
        gui_btn_share.setPreferredSizeStr("inherit 6.3492064mm");
        gui_btn_share.setUIID("btn_share");
        gui_btn_share.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_share.setName("btn_share");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_share, "\ue80d".charAt(0));
        gui_Container_1.setPreferredSizeStr("74.60317mm 5.026455mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_2.setPreferredSizeStr("69.57672mm 5.026455mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_btn_cancel);
        gui_Container.addComponent(gui_lbl_person_name);
        gui_Container.addComponent(gui_lbl_qrcode);
        gui_Container.addComponent(gui_lbl_subscribe_type);
        gui_Container.addComponent(gui_Label_2);
        gui_Container.addComponent(gui_Label_3);
        gui_Container.addComponent(gui_lbl_total_price);
        gui_Container.addComponent(gui_Label_5);
        gui_Container.addComponent(gui_lbl_gym_name);
        gui_Container.addComponent(gui_lbl_location);
        gui_Container.addComponent(gui_btn_location);
        gui_Container.addComponent(gui_lbl_status);
        gui_Container.addComponent(gui_btn_call_gym);
        gui_Container.addComponent(gui_btn_share);
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_start_date.setPreferredSizeStr("35.449738mm 9.78836mm");
        gui_lbl_start_date.setRTL(true);
        gui_lbl_start_date.setText("Start date : ");
        gui_lbl_start_date.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_start_date.setInlineAllStyles("font:3.0mm; alignment:right;");
        gui_lbl_start_date.setName("lbl_start_date");
        gui_lbl_start_date_no.setPreferredSizeStr("32.804234mm 6.3492064mm");
        gui_lbl_start_date_no.setRTL(true);
        gui_lbl_start_date_no.setText("10 / 12 / 2019 ");
        gui_lbl_start_date_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_start_date_no.setName("lbl_start_date_no");
        gui_Container_1.addComponent(gui_lbl_start_date);
        gui_Container_1.addComponent(gui_lbl_start_date_no);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_start_date.getParent().getLayout()).setInsets(gui_lbl_start_date, "0.0mm 0.0mm 0.0mm 55.0%").setReferenceComponents(gui_lbl_start_date, "-1 -1 -1 -1").setReferencePositions(gui_lbl_start_date, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_start_date_no.getParent().getLayout()).setInsets(gui_lbl_start_date_no, "0.0mm 1.0mm 1.1920929E-7mm 0.0mm").setReferenceComponents(gui_lbl_start_date_no, "-1 0 -1 -1").setReferencePositions(gui_lbl_start_date_no, "0.0 1.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_2);
        gui_lbl_end_date.setPreferredSizeStr("35.449738mm 9.78836mm");
        gui_lbl_end_date.setRTL(true);
        gui_lbl_end_date.setText("End date : ");
        gui_lbl_end_date.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_end_date.setInlineAllStyles("font:3.0mm; alignment:right;");
        gui_lbl_end_date.setName("lbl_end_date");
        gui_lbl_end_date_no.setPreferredSizeStr("24.074074mm 6.3492064mm");
        gui_lbl_end_date_no.setRTL(true);
        gui_lbl_end_date_no.setText("10 / 1 / 2020");
        gui_lbl_end_date_no.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_end_date_no.setName("lbl_end_date_no");
        gui_Container_2.addComponent(gui_lbl_end_date);
        gui_Container_2.addComponent(gui_lbl_end_date_no);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_end_date.getParent().getLayout()).setInsets(gui_lbl_end_date, "0.0mm 0.0mm 0.0mm 55.0%").setReferenceComponents(gui_lbl_end_date, "-1 -1 -1 -1").setReferencePositions(gui_lbl_end_date, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_end_date_no.getParent().getLayout()).setInsets(gui_lbl_end_date_no, "0.0mm 1.0mm 1.1920929E-7mm 0.0mm").setReferenceComponents(gui_lbl_end_date_no, "-1 0 -1 -1").setReferencePositions(gui_lbl_end_date_no, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_cancel.getParent().getLayout()).setInsets(gui_btn_cancel, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_btn_cancel, "-1 -1 -1 -1").setReferencePositions(gui_btn_cancel, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_person_name.getParent().getLayout()).setInsets(gui_lbl_person_name, "3.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_person_name, "4 -1 -1 -1").setReferencePositions(gui_lbl_person_name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_qrcode.getParent().getLayout()).setInsets(gui_lbl_qrcode, "2.0mm auto auto auto").setReferenceComponents(gui_lbl_qrcode, "1 -1 -1 -1").setReferencePositions(gui_lbl_qrcode, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_subscribe_type.getParent().getLayout()).setInsets(gui_lbl_subscribe_type, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_subscribe_type, "15 -1 -1 -1").setReferencePositions(gui_lbl_subscribe_type, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "3.0mm auto auto auto").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_3, "10 -1 -1 -1").setReferencePositions(gui_Label_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_total_price.getParent().getLayout()).setInsets(gui_lbl_total_price, "0.0mm auto auto auto").setReferenceComponents(gui_lbl_total_price, "5 -1 -1 -1").setReferencePositions(gui_lbl_total_price, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_5, "6 -1 -1 -1").setReferencePositions(gui_Label_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_gym_name.getParent().getLayout()).setInsets(gui_lbl_gym_name, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_gym_name, "2 -1 -1 -1").setReferencePositions(gui_lbl_gym_name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_location.getParent().getLayout()).setInsets(gui_lbl_location, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_location, "8 -1 -1 -1").setReferencePositions(gui_lbl_location, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_location.getParent().getLayout()).setInsets(gui_btn_location, "0.0mm 2.0mm auto 51.0%").setReferenceComponents(gui_btn_location, "9 -1 -1 -1").setReferencePositions(gui_btn_location, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_status.getParent().getLayout()).setInsets(gui_lbl_status, "1.0mm auto auto auto").setReferenceComponents(gui_lbl_status, "3 -1 -1 -1").setReferencePositions(gui_lbl_status, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_call_gym.getParent().getLayout()).setInsets(gui_btn_call_gym, "0.0mm 51.0% auto 2.0mm").setReferenceComponents(gui_btn_call_gym, "9 -1 -1 -1").setReferencePositions(gui_btn_call_gym, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_share.getParent().getLayout()).setInsets(gui_btn_share, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_btn_share, "-1 -1 -1 -1").setReferencePositions(gui_btn_share, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 69.57672);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 5.026455);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "7 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 69.57672);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 5.026455);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_2, "14 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
