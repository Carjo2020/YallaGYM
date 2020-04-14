package com.yallagym.client.forms;

import com.cn2.ui.cn1Display;
import com.cn2.util.cn1String;
import com.codename1.io.Preferences;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.codename1.util.StringUtil;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import com.yallagym.client.layouts.client_orders_item;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class client_orders extends BaseForm {

    APIs api = new APIs();

    public client_orders() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public client_orders(com.codename1.ui.util.Resources res) {
    }

    public client_orders(com.codename1.ui.util.Resources res, Form frm) {
          initGuiBuilderComponents(res);
        gui_empty_order.setVisible(false);
        installTitleArea(res);
        installBackIcon(frm);
        installBackCommand(frm);
        this.setScrollableY(false);
        this.setScrollVisible(false);
        gui_Container.setLayout(new FlowLayout());
        gui_Container.setScrollVisible(false);
        gui_Container.setScrollableY(true);
        int d = cn1Display.getScaledMin(8);
        gui_Infinite_Progress.setPreferredH(d + 20);
        gui_Infinite_Progress.setPreferredW(d + 20);
        System.out.println("run:");
        new UITimer(() -> {
            storeOrder(res);
        }).schedule(150, false, this);

        gui_Container.addPullToRefresh(() -> {
            gui_Container.removeAll();
            storeOrder(res);
            gui_Container.revalidate();
        });
    }

//////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_empty_order = new com.codename1.ui.Label();
    protected com.codename1.components.InfiniteProgress gui_Infinite_Progress = new com.codename1.components.InfiniteProgress();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("client_orders");
        setName("client_orders");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_empty_order.setText("There's no any order");
        gui_empty_order.setUIID("PersonalInfo_Lbl");
                gui_empty_order.setInlineStylesTheme(resourceObjectInstance);
        gui_empty_order.setInlineAllStyles("font:4.0mm; fgColor:333; alignment:center;");
        gui_empty_order.setName("empty_order");
        gui_Infinite_Progress.setPreferredSizeStr("9.78836mm 9.523809mm");
                gui_Infinite_Progress.setInlineStylesTheme(resourceObjectInstance);
        gui_Infinite_Progress.setName("Infinite_Progress");
        addComponent(gui_Container);
        addComponent(gui_empty_order);
        addComponent(gui_Infinite_Progress);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_empty_order.getParent().getLayout()).setInsets(gui_empty_order, "0px 0px 0px 0px").setReferenceComponents(gui_empty_order, "-1 -1 -1 -1").setReferencePositions(gui_empty_order, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Infinite_Progress.getParent().getLayout()).setInsets(gui_Infinite_Progress, "auto auto auto auto").setReferenceComponents(gui_Infinite_Progress, "-1 -1 -1 -1").setReferencePositions(gui_Infinite_Progress, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    SimpleDateFormat dateFormat = new SimpleDateFormat("d / M / yyyy");

    private void storeOrder(Resources res) {
        String username = Preferences.get("username", "");
        if (!username.equals("")) {
            List<Map<String, Object>> orders = api.getOrders(username);

//            String[] list_orders = cn1String.splite(orders, ";");
            if (orders.size() > 0) {
//                for (int i = list_orders.length - 1; i >= 0; i--) {
//                    int order = Integer.valueOf(StringUtil.replaceAll(list_orders[i], ".0", ""));
//                    Map<String, Object> list = api.getOrder(order);
                for (Map<String, Object> list : orders) {
//                String subscribe_type = list.get("subscribe_type").toString();
                    String name = list.get("name").toString();
                    String id_order = list.get("id_order").toString();
//                String date_start = list.get("date_start").toString();
                    String pay_method = list.get("pay_method").toString();
                    String total_price = list.get("total_price").toString();
                    String date_order = list.get("date_order").toString();
                    String status = list.get("status").toString();
                    String date_order_formated = dateFormat.format(new Date(Long.parseLong(date_order)));

//                String date_order_formated = dateFormat.format(new Date(Long.parseLong(date_order)));
//                String work_time = list.get("work_time").toString();
//                String address = list.get("address").toString();
//                String coordinates = list.get("coordinates").toString();
//                String[] split_coord = cn1String.splite(coordinates, ",");
                    if (!status.equals("deleted")) {
//                        gui_Container.add(new user_orders_Con_Item(res, order + "", name, subscribe_type, date_start, total_price, status, new Coord(Double.valueOf(split_coord[0]), Double.valueOf(split_coord[1]))));
                        if (pay_method.equals("offline")) {
                            gui_Container.add(new client_orders_item(res,list, "red", id_order, name, date_order_formated, total_price));
                        } else if (pay_method.equals("online")) {
                            gui_Container.add(new client_orders_item(res,list, "green", id_order, name, date_order_formated, total_price));
                        }
                    }
                }
                gui_Infinite_Progress.setVisible(false);
            } else {
                gui_Infinite_Progress.setVisible(false);
                gui_empty_order.setVisible(true);
            }
        } else {
            gui_Infinite_Progress.setVisible(false);
            gui_empty_order.setVisible(true);
        }

        this.revalidate();
    }

}
