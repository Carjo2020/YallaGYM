package com.yallagym.club.layouts;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.Util;
import com.codename1.ui.CN;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.club.forms.club_APIs;
import com.yallagym.club.forms.club_BaseForm;
import com.yallagym.club.forms.club_orders;
import java.util.List;
import java.util.Map;

public class club_order_con extends com.codename1.ui.Container {

    club_APIs api = new club_APIs();
    Resources res;

    public club_order_con() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }
//"block_ic.png" "cancel_ic.png" "correct_ic.png" "message_ic.png" "unlock_ic.png"

    public club_order_con(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }
// Pending Orders

    public club_order_con(Resources res, String id_order, String name, String phone, String price, String start_date, String end_date, String sub_type, String date_order, String type) {
        checkLanguage(res);
        this.res = res;
        switch (type) {
            case "pending":
                setupPendingContainer(res, id_order, name, price, start_date, end_date, sub_type, date_order);
                break;
            case "accepted":
                setupAcceptedContainer(res, id_order, name, phone, price, start_date, end_date, sub_type, date_order);
                break;
            case "blocked":
                setupBlockedContainer(res, id_order, name, price, start_date, end_date, sub_type, date_order);
                break;
            case "ended":
                setupEndedContainer(res, id_order, name, price, start_date, end_date, sub_type, date_order);
                break;
        }

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_img = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_price = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_start_date = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_end_date = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_sub_type = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Con_Actions = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_2 = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_date_order = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_id_order = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("club_order_con");
        gui_Container.setPreferredSizeStr("inherit 24.338625mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setInlineAllStyles("border:1.0px solid a3cc2e; bgColor:ffffff; transparency:255; margin:2.0mm 0.0mm 2.0mm 0.0mm; padding:0px 0px 0px 0px;");
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_lbl_img.setPreferredSizeStr("11.375662mm 11.111112mm");
                gui_lbl_img.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_img.setInlineAllStyles("bgImage:user_green_512_ic.png;");
        gui_lbl_img.setName("lbl_img");
        gui_Container_1.setPreferredSizeStr("33.597885mm 24.603174mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Con_Actions.setPreferredSizeStr("11.640212mm 16.666666mm");
                gui_Con_Actions.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Actions.setName("Con_Actions");
        gui_lbl_date_order.setPreferredSizeStr("18.25397mm 7.6719575mm");
        gui_lbl_date_order.setText("5 Days ago");
        gui_lbl_date_order.setUIID("Detalis_Sb_green");
                gui_lbl_date_order.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_date_order.setInlineAllStyles("alignment:center;");
        gui_lbl_date_order.setName("lbl_date_order");
                gui_lbl_id_order.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_id_order.setName("lbl_id_order");
        gui_Container.addComponent(gui_lbl_img);
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_name.setPreferredSizeStr("42.857143mm 3.968254mm");
        gui_lbl_name.setText("Mikdam Qandeel");
        gui_lbl_name.setUIID("Detalis_Sb_green");
                gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("font:3.0mm; fgColor:3c4646; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_name.setName("lbl_name");
        gui_lbl_price.setPreferredSizeStr("59.25926mm 5.555556mm");
        gui_lbl_price.setText("15 JOD");
        gui_lbl_price.setUIID("Detalis_Sb_green");
                gui_lbl_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price.setInlineAllStyles("font:3.0mm; fgColor:757575; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_price.setName("lbl_price");
        gui_lbl_start_date.setPreferredSizeStr("47.354496mm 3.968254mm");
        gui_lbl_start_date.setText("Start date : 10 / 12 / 2019 ");
        gui_lbl_start_date.setUIID("Detalis_Sb_green");
                gui_lbl_start_date.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_start_date.setInlineAllStyles("fgColor:8b8b8b; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_start_date.setName("lbl_start_date");
        gui_lbl_end_date.setPreferredSizeStr("52.645504mm 3.4391534mm");
        gui_lbl_end_date.setText("End date : 10 / 1 / 2020 ");
        gui_lbl_end_date.setUIID("Detalis_Sb_green");
                gui_lbl_end_date.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_end_date.setInlineAllStyles("fgColor:8b8b8b; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_end_date.setName("lbl_end_date");
        gui_lbl_sub_type.setPreferredSizeStr("51.851852mm 3.968254mm");
        gui_lbl_sub_type.setText("Weekly Subscribtion");
        gui_lbl_sub_type.setUIID("Detalis_Sb_green");
                gui_lbl_sub_type.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_sub_type.setInlineAllStyles("fgColor:8b8b8b; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_sub_type.setName("lbl_sub_type");
        gui_Container_1.addComponent(gui_lbl_name);
        gui_Container_1.addComponent(gui_lbl_price);
        gui_Container_1.addComponent(gui_lbl_start_date);
        gui_Container_1.addComponent(gui_lbl_end_date);
        gui_Container_1.addComponent(gui_lbl_sub_type);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "-1.1920929E-7mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_name, "-1 -1 -1 -1").setReferencePositions(gui_lbl_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_price.getParent().getLayout()).setInsets(gui_lbl_price, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_price, "0 -1 -1 -1").setReferencePositions(gui_lbl_price, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_start_date.getParent().getLayout()).setInsets(gui_lbl_start_date, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_start_date, "1 -1 -1 -1").setReferencePositions(gui_lbl_start_date, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_end_date.getParent().getLayout()).setInsets(gui_lbl_end_date, "-5.9604645E-8mm 0.0mm auto -4.7683716E-7mm").setReferenceComponents(gui_lbl_end_date, "2 -1 -1 -1").setReferencePositions(gui_lbl_end_date, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_sub_type.getParent().getLayout()).setInsets(gui_lbl_sub_type, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_sub_type, "3 -1 -1 -1").setReferencePositions(gui_lbl_sub_type, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Con_Actions);
        gui_Container_2.setPreferredSizeStr("8.730159mm 7.4074073mm");
        gui_Container_2.setUIID("club_order_con_icons");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container_3.setPreferredSizeStr("8.994709mm 7.4074073mm");
        gui_Container_3.setUIID("club_order_con_icons");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Con_Actions.addComponent(gui_Container_2);
        gui_btn_2.setPreferredSizeStr("27.248678mm 17.195766mm");
        gui_btn_2.setUIID("transperent");
                gui_btn_2.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_2.setInlineAllStyles("fgColor:ffffff; opacity:255;");
        gui_btn_2.setName("btn_2");
        gui_Container_2.addComponent(gui_btn_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_2.getParent().getLayout()).setInsets(gui_btn_2, "1.5mm 1.5mm 1.5mm 1.5mm").setReferenceComponents(gui_btn_2, "-1 -1 -1 -1").setReferencePositions(gui_btn_2, "0.0 0.0 0.0 0.0");
        gui_Con_Actions.addComponent(gui_Container_3);
        gui_btn_1.setPreferredSizeStr("27.248678mm 17.195766mm");
        gui_btn_1.setUIID("transperent");
                gui_btn_1.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_1.setInlineAllStyles("fgColor:ffffff; opacity:255;");
        gui_btn_1.setName("btn_1");
        gui_Container_3.addComponent(gui_btn_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_1.getParent().getLayout()).setInsets(gui_btn_1, "1.5mm 1.5mm 1.5mm 1.5mm").setReferenceComponents(gui_btn_1, "-1 -1 -1 -1").setReferencePositions(gui_btn_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)8.730159);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "auto auto 0.0mm auto").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm auto auto auto").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_lbl_date_order);
        gui_Container.addComponent(gui_lbl_id_order);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_img.getParent().getLayout()).setInsets(gui_lbl_img, "2.0mm auto auto 4.0mm").setReferenceComponents(gui_lbl_img, "-1 -1 -1 -1").setReferencePositions(gui_lbl_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)33.597885);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)22.222223);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "2.0mm 25.0% 0.0mm 1.5mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 0 ").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Actions.getLayout()).setPreferredWidthMM((float)11.640212);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Actions.getLayout()).setPreferredHeightMM((float)16.931217);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Actions.getParent().getLayout()).setInsets(gui_Con_Actions, "auto auto auto 0.0mm").setReferenceComponents(gui_Con_Actions, "-1 -1 -1 1 ").setReferencePositions(gui_Con_Actions, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_date_order.getParent().getLayout()).setInsets(gui_lbl_date_order, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_date_order, "0 1 -1 -1").setReferencePositions(gui_lbl_date_order, "1.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_id_order.getParent().getLayout()).setInsets(gui_lbl_id_order, "50.0% 50.0% 50.0% 50.0%").setReferenceComponents(gui_lbl_id_order, "-1 -1 -1 -1").setReferencePositions(gui_lbl_id_order, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)68.783066);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)24.338625);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto -0.2mm auto -0.2mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!! EDIT ABOVE THIS LINE!!!   
    private void setupPendingContainer(Resources res, String id_order, String name, String price, String start_date, String end_date, String sub_type, String date_order) {
        gui_lbl_img.setPreferredH(gui_lbl_img.getPreferredW());
        gui_lbl_img.getAllStyles().setBgImage(res.getImage("user_orange_512_ic.png"));
        gui_lbl_name.setText(name);
        gui_lbl_price.setText(price);
        gui_lbl_start_date.setText(start_date);
        gui_lbl_end_date.setText(end_date);
        gui_lbl_sub_type.setText(sub_type);
        gui_lbl_date_order.setText(date_order);
        gui_lbl_date_order.getAllStyles().setFgColor(0X2CBB1C);
        gui_btn_1.getAllStyles().setBgImage(res.getImage("correct_ic.png"));
        gui_btn_2.getAllStyles().setBgImage(res.getImage("cancel_ic.png"));
        gui_Container_2.setPreferredW(gui_Container_2.getPreferredH());
        gui_Container_3.setPreferredW(gui_Container_3.getPreferredH());
        gui_lbl_id_order.setText(id_order);
        gui_btn_1.addActionListener(e -> {
            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInfiniteBlocking();
            api.changeStatus(id_order, "accepted");
            Map<String, Object> currentListing = api.getGymOrders();
            club_BaseForm.currentListing = currentListing;
            Util.sleep(2000);
            dlg.dispose();
            this.remove();
            CN.getCurrentForm().revalidate();
        });
        gui_btn_2.addActionListener(e -> {
            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInfiniteBlocking();
            api.changeStatus(id_order, "rejected");
            Map<String, Object> currentListing = api.getGymOrders();
            club_BaseForm.currentListing = currentListing;
            Util.sleep(2000);
            dlg.dispose();
            this.remove();
            CN.getCurrentForm().revalidate();
            new club_orders(res).show();
        });
        setupColors(0xFF971D);
    }

    private void setupAcceptedContainer(Resources res, String id_order, String name, String phone, String price, String start_date, String end_date, String sub_type, String date_order) {
        gui_lbl_img.setPreferredH(gui_lbl_img.getPreferredW());
        gui_lbl_img.getAllStyles().setBgImage(res.getImage("user_green_512_ic.png"));
        gui_lbl_name.setText(name);
        gui_lbl_price.setText(price);
        gui_lbl_start_date.setText(start_date);
        gui_lbl_end_date.setText(end_date);
        gui_lbl_sub_type.setText(sub_type);
        gui_lbl_date_order.setText(date_order);
        gui_lbl_date_order.getAllStyles().setFgColor(0X2CBB1C);
        gui_btn_1.getAllStyles().setBgImage(res.getImage("message_ic.png"));
        gui_btn_2.getAllStyles().setBgImage(res.getImage("block_ic.png"));
        gui_Container_2.setPreferredW(gui_Container_2.getPreferredH());
        gui_Container_3.setPreferredW(gui_Container_3.getPreferredH());
        gui_lbl_id_order.setText(id_order);

        gui_btn_1.addActionListener(e -> {
            Display.getInstance().execute("https://wa.me/" + StringUtil.replaceAll(phone, "+", ""));
        });
        gui_btn_2.addActionListener(e -> {
            new erorr(res, "Warning", "Do you sure you want to blocked this user?\nif clicked \"ok\", you can't receive orders from this user", "Ok", ee -> {
                InfiniteProgress prog = new InfiniteProgress();
                Dialog dlg = prog.showInfiniteBlocking();
                api.changeStatus(id_order, "blocked");
                Map<String, Object> currentListing = api.getGymOrders();
                club_BaseForm.currentListing = currentListing;
                Util.sleep(2000);
                dlg.dispose();
                this.remove();
                CN.getCurrentForm().revalidate();
            }, "Cancel", null).show();
        });
        setupColors(0xa3cc2e);

    }

    private void setupBlockedContainer(Resources res, String id_order, String name, String price, String start_date, String end_date, String sub_type, String date_order) {
        gui_lbl_img.setPreferredH(gui_lbl_img.getPreferredW());
        gui_lbl_img.getAllStyles().setBgImage(res.getImage("user_red_512_ic.png"));
        gui_lbl_name.setText(name);
        gui_lbl_price.setText(price);
        gui_lbl_start_date.setText(start_date);
        gui_lbl_end_date.setText(end_date);
        gui_lbl_sub_type.setText(sub_type);
        gui_lbl_date_order.setText(date_order);
        gui_lbl_date_order.getAllStyles().setFgColor(0X2CBB1C);
        gui_btn_1.getAllStyles().setBgImage(res.getImage("unlock_ic.png"));
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "auto auto auto auto").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        gui_Container_3.setPreferredW(gui_Container_2.getPreferredH());
        gui_Container_2.setVisible(false);
        gui_lbl_id_order.setText(id_order);
        gui_btn_1.addActionListener(e -> {
            new erorr(res, "Warning", "Do you sure you want to un blocked this user?\nif clicked \"ok\", you may get orders from this user in future.", "Ok", ee -> {
                InfiniteProgress prog = new InfiniteProgress();
                Dialog dlg = prog.showInfiniteBlocking();
                api.changeStatus(id_order, "unblocked");
                Map<String, Object> currentListing = api.getGymOrders();
                club_BaseForm.currentListing = currentListing;
                Util.sleep(2000);
                dlg.dispose();
                this.remove();
                CN.getCurrentForm().revalidate();
            }, "Cancel", null).show();
        });
        setupColors(0xC90000);
    }

    private void setupEndedContainer(Resources res, String id_order, String name, String price, String start_date, String end_date, String sub_type, String date_order) {
        gui_lbl_img.setPreferredH(gui_lbl_img.getPreferredW());
        gui_lbl_img.getAllStyles().setBgImage(res.getImage("user_black_512_ic.png"));
        gui_lbl_name.setText(name);
        gui_lbl_price.setText(price);
        gui_lbl_start_date.setText(start_date);
        gui_lbl_end_date.setText(end_date);
        gui_lbl_sub_type.setText(sub_type);
        gui_lbl_date_order.setText(date_order);
        gui_lbl_date_order.getAllStyles().setFgColor(0X2CBB1C);
        gui_Container_2.setVisible(false);
        gui_Container_3.setVisible(false);
        gui_lbl_id_order.setText(id_order);
        setupColors(0x000000);
    }

    private void setupColors(int color) {
        gui_Container.getStyle().setBorder(Border.createLineBorder(1, color));
        gui_lbl_date_order.getAllStyles().setFgColor(color);

    }

    private Container getAcceptedContainer(List<Map<String, Object>> list) {
        Container accepted = new Container();
        accepted.setLayout(BoxLayout.y());
        accepted.setScrollableY(true);
        accepted.setScrollVisible(false);
        for (Map<String, Object> map : list) {
            accepted.add(new club_order_con(res, $(map.get("id_order")), $(map.get("name")), $(map.get("phone")), $(map.get("price")) + " JOD", "Start date : " + $(map.get("date_start")), "End date : " + $(map.get("date_end")), $(map.get("subscribe_type")), $(map.get("time_format")), "accepted"));
        }
        return accepted;
    }

    private String $(Object get) {
        return get + "";
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
        Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
        Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
        Label gui_lbl_date_st1 = new com.codename1.ui.Label();
        Label gui_lbl_date_st2 = new com.codename1.ui.Label();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setInlineStylesTheme(resourceObjectInstance);
        setName("club_order_con");
        gui_Container.setPreferredSizeStr("inherit 24.338625mm");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setInlineAllStyles("border:1.0px solid a3cc2e; bgColor:ffffff; transparency:255; margin:2.0mm 0.0mm 2.0mm 0.0mm; padding:0px 0px 0px 0px;");
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_lbl_img.setPreferredSizeStr("11.375662mm 11.111112mm");
        gui_lbl_img.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_img.setInlineAllStyles("bgImage:user_green_512_ic.png;");
        gui_lbl_img.setName("lbl_img");
        gui_Container_1.setPreferredSizeStr("37.037037mm 24.603174mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Con_Actions.setPreferredSizeStr("11.640212mm 16.666666mm");
        gui_Con_Actions.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Actions.setName("Con_Actions");
        gui_lbl_date_order.setPreferredSizeStr("18.25397mm 7.6719575mm");
        gui_lbl_date_order.setText("5 Days ago");
        gui_lbl_date_order.setUIID("Detalis_Sb_green");
        gui_lbl_date_order.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_date_order.setInlineAllStyles("alignment:center;");
        gui_lbl_date_order.setName("lbl_date_order");
        gui_lbl_id_order.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_id_order.setName("lbl_id_order");
        gui_Container.addComponent(gui_lbl_img);
        gui_Container.addComponent(gui_Container_1);
        gui_lbl_name.setPreferredSizeStr("42.857143mm 3.968254mm");
        gui_lbl_name.setRTL(true);
        gui_lbl_name.setText("Mikdam Qandeel");
        gui_lbl_name.setUIID("Detalis_Sb_green");
        gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("font:3.0mm; fgColor:3c4646; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_name.setName("lbl_name");
        gui_lbl_price.setPreferredSizeStr("59.25926mm 5.555556mm");
        gui_lbl_price.setRTL(true);
        gui_lbl_price.setText("15 JOD");
        gui_lbl_price.setUIID("Detalis_Sb_green");
        gui_lbl_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price.setInlineAllStyles("font:3.0mm; fgColor:757575; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_price.setName("lbl_price");
        gui_lbl_sub_type.setPreferredSizeStr("51.851852mm 4.2328043mm");
        gui_lbl_sub_type.setRTL(true);
        gui_lbl_sub_type.setText("Weekly Subscribtion");
        gui_lbl_sub_type.setUIID("Detalis_Sb_green");
        gui_lbl_sub_type.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_sub_type.setInlineAllStyles("fgColor:8b8b8b; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_sub_type.setName("lbl_sub_type");
        gui_Container_4.setPreferredSizeStr("35.714287mm 3.968254mm");
        gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Container_5.setPreferredSizeStr("21.428572mm 3.968254mm");
        gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setName("Container_5");
        gui_Container_1.addComponent(gui_lbl_name);
        gui_Container_1.addComponent(gui_lbl_price);
        gui_Container_1.addComponent(gui_lbl_sub_type);
        gui_Container_1.addComponent(gui_Container_4);
        gui_lbl_date_st1.setPreferredSizeStr("9.523809mm 3.968254mm");
        gui_lbl_date_st1.setRTL(true);
        gui_lbl_date_st1.setText("Start date :");
        gui_lbl_date_st1.setUIID("Detalis_Sb_green");
        gui_lbl_date_st1.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_date_st1.setInlineAllStyles("fgColor:8b8b8b; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_date_st1.setName("lbl_date_st1");
        gui_lbl_start_date.setPreferredSizeStr("17.724869mm 8.994709mm");
        gui_lbl_start_date.setRTL(true);
        gui_lbl_start_date.setText("10 / 12 / 2019 ");
        gui_lbl_start_date.setUIID("Detalis_Sb_green");
        gui_lbl_start_date.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_start_date.setName("lbl_start_date");
        gui_Container_4.addComponent(gui_lbl_date_st1);
        gui_Container_4.addComponent(gui_lbl_start_date);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_date_st1.getParent().getLayout()).setInsets(gui_lbl_date_st1, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_lbl_date_st1, "-1 -1 -1 -1").setReferencePositions(gui_lbl_date_st1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_start_date.getParent().getLayout()).setInsets(gui_lbl_start_date, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_start_date, "-1 0 -1 -1").setReferencePositions(gui_lbl_start_date, "0.0 1.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_5);
        gui_lbl_date_st2.setPreferredSizeStr("9.523809mm 3.968254mm");
        gui_lbl_date_st2.setRTL(true);
        gui_lbl_date_st2.setText("End date :");
        gui_lbl_date_st2.setUIID("Detalis_Sb_green");
        gui_lbl_date_st2.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_date_st2.setInlineAllStyles("fgColor:8b8b8b; margin:0px 0px 0px 0px; padding:0px 0px 0px 0px;");
        gui_lbl_date_st2.setName("lbl_date_st2");
        gui_lbl_end_date.setPreferredSizeStr("17.724869mm 8.994709mm");
        gui_lbl_end_date.setRTL(true);
        gui_lbl_end_date.setText("10 / 1 / 2020 ");
        gui_lbl_end_date.setUIID("Detalis_Sb_green");
        gui_lbl_end_date.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_end_date.setName("lbl_end_date");
        gui_Container_5.addComponent(gui_lbl_date_st2);
        gui_Container_5.addComponent(gui_lbl_end_date);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_date_st2.getParent().getLayout()).setInsets(gui_lbl_date_st2, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_lbl_date_st2, "-1 -1 -1 -1").setReferencePositions(gui_lbl_date_st2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_end_date.getParent().getLayout()).setInsets(gui_lbl_end_date, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_end_date, "-1 0 -1 -1").setReferencePositions(gui_lbl_end_date, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "0.26455015mm 0.26455027mm auto -0.26455027mm").setReferenceComponents(gui_lbl_name, "-1 -1 -1 -1").setReferencePositions(gui_lbl_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_price.getParent().getLayout()).setInsets(gui_lbl_price, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_price, "0 -1 -1 -1").setReferencePositions(gui_lbl_price, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_sub_type.getParent().getLayout()).setInsets(gui_lbl_sub_type, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_sub_type, "4 -1 -1 -1").setReferencePositions(gui_lbl_sub_type, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredWidthMM((float) 35.714287);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredHeightMM((float) 3.968254);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getParent().getLayout()).setInsets(gui_Container_4, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_4, "1 -1 -1 -1").setReferencePositions(gui_Container_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getLayout()).setPreferredWidthMM((float) 21.428572);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getLayout()).setPreferredHeightMM((float) 3.968254);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_5, "3 -1 -1 -1").setReferencePositions(gui_Container_5, "1.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Con_Actions);
        gui_Container_2.setPreferredSizeStr("8.730159mm 7.4074073mm");
        gui_Container_2.setUIID("club_order_con_icons");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container_3.setPreferredSizeStr("8.994709mm 7.4074073mm");
        gui_Container_3.setUIID("club_order_con_icons");
        gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Con_Actions.addComponent(gui_Container_2);
        gui_btn_2.setPreferredSizeStr("27.248678mm 17.195766mm");
        gui_btn_2.setUIID("transperent");
        gui_btn_2.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_2.setInlineAllStyles("fgColor:ffffff; opacity:255;");
        gui_btn_2.setName("btn_2");
        gui_Container_2.addComponent(gui_btn_2);
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_2.getParent().getLayout()).setInsets(gui_btn_2, "1.5mm 1.5mm 1.5mm 1.5mm").setReferenceComponents(gui_btn_2, "-1 -1 -1 -1").setReferencePositions(gui_btn_2, "0.0 0.0 0.0 0.0");
        gui_Con_Actions.addComponent(gui_Container_3);
        gui_btn_1.setPreferredSizeStr("27.248678mm 17.195766mm");
        gui_btn_1.setUIID("transperent");
        gui_btn_1.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_1.setInlineAllStyles("fgColor:ffffff; opacity:255;");
        gui_btn_1.setName("btn_1");
        gui_Container_3.addComponent(gui_btn_1);
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_1.getParent().getLayout()).setInsets(gui_btn_1, "1.5mm 1.5mm 1.5mm 1.5mm").setReferenceComponents(gui_btn_1, "-1 -1 -1 -1").setReferencePositions(gui_btn_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 8.730159);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "auto auto 0.0mm auto").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredWidthMM((float) 8.994709);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredHeightMM((float) 7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "0.0mm auto auto auto").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_lbl_date_order);
        gui_Container.addComponent(gui_lbl_id_order);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_img.getParent().getLayout()).setInsets(gui_lbl_img, "2.0mm 4.0mm auto auto").setReferenceComponents(gui_lbl_img, "-1 -1 -1 -1").setReferencePositions(gui_lbl_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 37.037037);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 22.222223);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "2.0mm 1.5mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "-1 0 -1 2 ").setReferencePositions(gui_Container_1, "0.0 1.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Actions.getLayout()).setPreferredWidthMM((float) 11.640212);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Actions.getLayout()).setPreferredHeightMM((float) 16.931217);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Actions.getParent().getLayout()).setInsets(gui_Con_Actions, "auto auto auto 2.0mm").setReferenceComponents(gui_Con_Actions, "-1 -1 -1 -1").setReferencePositions(gui_Con_Actions, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_date_order.getParent().getLayout()).setInsets(gui_lbl_date_order, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_lbl_date_order, "0 -1 -1 -1").setReferencePositions(gui_lbl_date_order, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_id_order.getParent().getLayout()).setInsets(gui_lbl_id_order, "50.0% 50.0% 50.0% 50.0%").setReferenceComponents(gui_lbl_id_order, "-1 -1 -1 -1").setReferencePositions(gui_lbl_id_order, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 74.07407);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 24.338625);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto -0.2mm auto -0.2mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
