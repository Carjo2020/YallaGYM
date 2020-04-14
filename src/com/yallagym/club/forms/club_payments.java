package com.yallagym.club.forms;

import com.cn2.ui.cn1Icons;
import com.codename1.ui.*;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.yallagym.BaseForm;
import com.yallagym.club.dialogs.pay;
import static com.yallagym.club.forms.club_BaseForm.getCurrentPaymentListing;
import com.yallagym.club.layouts.club_payment_con_month;
import com.yallagym.club.layouts.club_payment_con_month_item;
import com.yallagym.club.layouts.club_payment_tabs_container_top;

import java.util.List;
import java.util.Map;

public class club_payments extends club_BaseForm {

    Resources res;

    public club_payments() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public club_payments(com.codename1.ui.util.Resources res) {
        initGuiBuilderComponents(res);
    }

    public club_payments(com.codename1.ui.util.Resources res, Form frm) {
        initGuiBuilderComponents(res);
        this.res = res;
        installFixItems();
        installBackCommand(frm);
//        Button pay_button = new Button();
//        pay_button.setPreferredH(300);
//        pay_button.setPreferredW(300);
//        pay_button.setUIID("ic_fab");
//        pay_button.setText("$");
//        this.getParent().addComponent(FlowLayout.encloseBottom(FlowLayout.encloseCenter(pay_button)));
    }

    //////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Con_Tabs = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_pay = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_payments");
        setName("club_payments");
                gui_Con_Tabs.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Tabs.setName("Con_Tabs");
        gui_btn_pay.setPreferredSizeStr("11.111112mm 10.05291mm");
        gui_btn_pay.setText("$");
        gui_btn_pay.setUIID("ic_fab");
                gui_btn_pay.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_pay.setInlineAllStyles("font:6.0mm;");
        gui_btn_pay.setName("btn_pay");
        addComponent(gui_Con_Tabs);
        addComponent(gui_btn_pay);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Tabs.getParent().getLayout()).setInsets(gui_Con_Tabs, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Con_Tabs, "-1 -1 -1 -1").setReferencePositions(gui_Con_Tabs, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_pay.getParent().getLayout()).setInsets(gui_btn_pay, "auto auto 2.8835979mm auto").setReferenceComponents(gui_btn_pay, "-1 -1 -1 -1").setReferencePositions(gui_btn_pay, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!IT ABOVE THIS LINE!!!
    double offline_tot = 0;
    double online_tot = 0;

    private void installFixItems() {
        installSideMenu(res, this);
        installTitleArea(res);
        this.setScrollable(false);
        gui_Con_Tabs.setScrollableY(false);
        gui_Con_Tabs.add(CENTER, createTabs());
        gui_btn_pay.addActionListener(e -> new pay(res, offline_tot, online_tot).show());
    }

    private Tabs createTabs() {
        Map<String, Object> currentListing = getCurrentPaymentListing();
        Map<String, Object> offline = (Map<String, Object>) currentListing.get("offline");
        Map<String, Object> online = (Map<String, Object>) currentListing.get("online");
        offline_tot = Double.valueOf(offline.get("total_fees") + "");
        online_tot = Double.valueOf(online.get("total_fees") + "");
        Tabs tabs = new Tabs(Component.BOTTOM);
        if (!BaseForm.isArabic()) {
            tabs.addTab("", new cn1Icons().getImage("credit card", "Correct_Msg_Save_Lbl", 4), new cn1Icons().getImage("credit card", "Correct_Msg_Save_Lbl", 4), getOnlinePaymentsContainer(online));
            tabs.addTab("", new cn1Icons().getImage("attach money", "Correct_Msg_Save_Lbl", 4), new cn1Icons().getImage("attach money", "Correct_Msg_Save_Lbl", 4), getOfflinePaymentsContainer(offline));

        } else {
            tabs.addTab("", new cn1Icons().getImage("attach money", "Correct_Msg_Save_Lbl", 4), new cn1Icons().getImage("attach money", "Correct_Msg_Save_Lbl", 4), getOfflinePaymentsContainer(offline));
            tabs.addTab("", new cn1Icons().getImage("credit card", "Correct_Msg_Save_Lbl", 4), new cn1Icons().getImage("credit card", "Correct_Msg_Save_Lbl", 4), getOnlinePaymentsContainer(online));
            tabs.setSelectedIndex(1);
        }
        tabs.getAllStyles().setBgTransparency(0);
        tabs.getComponentAt(0).setUIID("Form");
        tabs.getComponentAt(1).getAllStyles().setBgColor(0XF7ED23);
        tabs.getComponentAt(1).getAllStyles().setBgTransparency(255);
        return tabs;
    }

    private Container getOfflinePaymentsContainer(Map<String, Object> offline) {

        Container OfflinePayments = new Container();
        OfflinePayments.setLayout(new BoxLayout(2));
        OfflinePayments.setScrollableY(false);
        OfflinePayments.add(new club_payment_tabs_container_top(res, "red", "-" + offline.get("total_fees") + ".00"));
        Container list = new Container();
        list.setLayout(new BoxLayout(2));
        list.setScrollableY(true);
        int highet_con_item = new club_payment_con_month_item().getPreferredH();
        List<Map<String, Object>> months = (List<Map<String, Object>>) offline.get("months");
        for (Map<String, Object> month : months) {
            List<Map<String, Object>> month_orders = (List<Map<String, Object>>) month.get("month_orders");
            if (month_orders.size() > 0) {
                list.add(new club_payment_con_month(res, "red", month, highet_con_item));
            }
        }
        OfflinePayments.add(list);
        return OfflinePayments;
    }

    private Container getOnlinePaymentsContainer(Map<String, Object> online) {
        Container OnlinePayments = new Container();
        OnlinePayments.setLayout(new BoxLayout(2));
        OnlinePayments.setScrollableY(false);
        OnlinePayments.add(new club_payment_tabs_container_top(res, "green", online.get("total_fees") + ".00"));
        Container list = new Container();
        list.setLayout(new BoxLayout(2));
        list.setScrollableY(true);
        int highet_con_item = new club_payment_con_month_item().getPreferredH();
//        list.add(new club_payment_con_month(res, 3, highet_con_item));
//        list.add(new club_payment_con_month(res, 5, highet_con_item));
//        list.add(new club_payment_con_month(res, 20, highet_con_item));
//        list.add(new club_payment_con_month(res, 1, highet_con_item));
        List<Map<String, Object>> months = (List<Map<String, Object>>) online.get("months");
        for (Map<String, Object> month : months) {
            List<Map<String, Object>> month_orders = (List<Map<String, Object>>) month.get("month_orders");
            if (month_orders.size() > 0) {
                list.add(new club_payment_con_month(res, "green", month, highet_con_item));
            }
        }
        OnlinePayments.add(list);
        return OnlinePayments;
    }

}
