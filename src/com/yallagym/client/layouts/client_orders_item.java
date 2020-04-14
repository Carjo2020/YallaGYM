package com.yallagym.client.layouts;

import com.cn2.util.cn1String;
import com.codename1.maps.Coord;
import com.codename1.ui.CN;
import com.codename1.ui.util.Resources;
import com.yallagym.client.forms.client_order_details;
import java.util.Map;

public class client_orders_item extends com.codename1.ui.Container {

    public client_orders_item() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public client_orders_item(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }

    public client_orders_item(com.codename1.ui.util.Resources res, Map<String, Object> map, String type, String id_order, String name, String data_order, String total_price) {
        checkLanguage(res);
        gui_Container_3.setPreferredW(gui_Container_3.getPreferredH());
        gui_lbl_divider.setPreferredH(3);
        gui_lbl_id_order.setText(id_order);
        gui_lbl_name.setText(name);
        gui_lbl_date_start.setText(data_order);
        if (type.equals("red")) {
            gui_lbl_total_price.setText("-" + total_price + " JOD");
            gui_lbl_total_price.getAllStyles().setFgColor(0xc90000);
            gui_btn_details.addActionListener(e -> {
                String coordinates = map.get("coordinates").toString();
                String[] split_coord = cn1String.splite(coordinates, ",");
                Coord coord = new Coord(Double.valueOf(split_coord[0]), Double.valueOf(split_coord[1]));
                new client_order_details(res, CN.getCurrentForm(), id_order, name, $(map.get("token")), $(map.get("address")), coord, "-" + total_price, $(map.get("date_start")), $(map.get("date_end")), $(map.get("subscribe_type")), "offline", $(map.get("status")), $(map.get("phone_gym"))).show();
            });
        } else if (type.equals("green")) {
            gui_lbl_total_price.setText(total_price + " JOD");
            gui_btn_details.addActionListener(e -> {
                String coordinates = map.get("coordinates").toString();
                String[] split_coord = cn1String.splite(coordinates, ",");
                Coord coord = new Coord(Double.valueOf(split_coord[0]), Double.valueOf(split_coord[1]));
                new client_order_details(res, CN.getCurrentForm(), id_order, name, $(map.get("token")), $(map.get("address")), coord, $(map.get("total_price")), $(map.get("date_start")), $(map.get("date_end")), $(map.get("subscribe_type")), "online", $(map.get("status")), $(map.get("phone_gym"))).show();
            });
        }
    }
//////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_divider = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_details = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_lbl_total_price = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_date_start = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_id_order = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("client_orders_item");
        gui_Container.setPreferredSizeStr("inherit 12.962963mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_lbl_divider.setPreferredSizeStr("104.49735mm 0.52910054mm");
                gui_lbl_divider.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_divider.setInlineAllStyles("bgColor:777777; transparency:77;");
        gui_lbl_divider.setName("lbl_divider");
        gui_Container_2.setPreferredSizeStr("19.31217mm 14.550264mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container_3.setPreferredSizeStr("11.640212mm 8.994709mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setInlineAllStyles("border:round ff3c4646;");
        gui_Container_3.setName("Container_3");
        gui_lbl_date_start.setPreferredSizeStr("36.772488mm 4.2328043mm");
        gui_lbl_date_start.setText("8 Dec 2019");
                gui_lbl_date_start.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_date_start.setInlineAllStyles("font:2.0mm; fgColor:8b8b8b;");
        gui_lbl_date_start.setName("lbl_date_start");
        gui_lbl_name.setPreferredSizeStr("36.772488mm 4.2328043mm");
        gui_lbl_name.setText("Miki Mohd");
                gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("font:2.5mm; fgColor:3c4646;");
        gui_lbl_name.setName("lbl_name");
                gui_lbl_id_order.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_id_order.setName("lbl_id_order");
        gui_Container.addComponent(gui_lbl_divider);
        gui_Container.addComponent(gui_Container_2);
        gui_btn_details.setPreferredSizeStr("6.6137567mm 27.513227mm");
                gui_btn_details.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_details.setInlineAllStyles("fgColor:3c4646;");
        gui_btn_details.setName("btn_details");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_details,"\ue315".charAt(0));
        gui_lbl_total_price.setPreferredSizeStr("17.460318mm 7.142857mm");
        gui_lbl_total_price.setText("50.5 JOD  ");
                gui_lbl_total_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total_price.setInlineAllStyles("font:2.5mm; fgColor:a3cc2e; alignment:right;");
        gui_lbl_total_price.setName("lbl_total_price");
        gui_Container_2.addComponent(gui_btn_details);
        gui_Container_2.addComponent(gui_lbl_total_price);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_details.getParent().getLayout()).setInsets(gui_btn_details, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_btn_details, "-1 -1 -1 -1").setReferencePositions(gui_btn_details, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total_price.getParent().getLayout()).setInsets(gui_lbl_total_price, "auto -2.3841858E-7mm auto 0.0mm").setReferenceComponents(gui_lbl_total_price, "-1 0 -1 -1").setReferencePositions(gui_lbl_total_price, "0.0 1.0 0.0 0.0");
        gui_Container.addComponent(gui_Container_3);
        gui_Label_1.setPreferredSizeStr("5.291005mm 4.7619047mm");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("bgImage:ic_card.png;");
        gui_Label_1.setName("Label_1");
        gui_Container_3.addComponent(gui_Label_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "auto auto auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_lbl_date_start);
        gui_Container.addComponent(gui_lbl_name);
        gui_Container.addComponent(gui_lbl_id_order);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_divider.getParent().getLayout()).setInsets(gui_lbl_divider, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_divider, "-1 -1 -1 -1").setReferencePositions(gui_lbl_divider, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)19.31217);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)13.227513);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)11.640212);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)8.994709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "auto auto auto 2.0mm").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_date_start.getParent().getLayout()).setInsets(gui_lbl_date_start, "0.0mm 0.0mm 2.0mm 3.0mm").setReferenceComponents(gui_lbl_date_start, "4 1 -1 2 ").setReferencePositions(gui_lbl_date_start, "1.0 1.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "2.0mm 0.0mm 50.0% 3.0mm").setReferenceComponents(gui_lbl_name, "-1 1 -1 2 ").setReferencePositions(gui_lbl_name, "0.0 1.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_id_order.getParent().getLayout()).setInsets(gui_lbl_id_order, "50.0% 50.0% 50.0% 50.0%").setReferenceComponents(gui_lbl_id_order, "-1 -1 -1 -1").setReferencePositions(gui_lbl_id_order, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)74.86773);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)12.962963);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public String $(Object value) {
        return value + "";
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
        setInlineStylesTheme(resourceObjectInstance);
        setName("client_orders_item");
        gui_Container.setPreferredSizeStr("inherit 12.962963mm");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_lbl_divider.setPreferredSizeStr("104.49735mm 0.52910054mm");
        gui_lbl_divider.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_divider.setInlineAllStyles("bgColor:777777; transparency:77;");
        gui_lbl_divider.setName("lbl_divider");
        gui_Container_2.setPreferredSizeStr("19.31217mm 14.550264mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container_3.setPreferredSizeStr("11.640212mm 8.994709mm");
        gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setInlineAllStyles("border:round ff3c4646;");
        gui_Container_3.setName("Container_3");
        gui_lbl_date_start.setPreferredSizeStr("26.719578mm 4.2328043mm");
        gui_lbl_date_start.setRTL(true);
        gui_lbl_date_start.setText("8 Dec 2019");
        gui_lbl_date_start.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_date_start.setInlineAllStyles("font:2.0mm; fgColor:8b8b8b;");
        gui_lbl_date_start.setName("lbl_date_start");
        gui_lbl_name.setPreferredSizeStr("28.306879mm 4.2328043mm");
        gui_lbl_name.setRTL(true);
        gui_lbl_name.setText("Miki Mohd");
        gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setInlineAllStyles("font:2.5mm; fgColor:3c4646;");
        gui_lbl_name.setName("lbl_name");
        gui_lbl_id_order.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_id_order.setName("lbl_id_order");
        gui_Container.addComponent(gui_lbl_divider);
        gui_Container.addComponent(gui_Container_2);
        gui_btn_details.setPreferredSizeStr("6.6137567mm 27.513227mm");
        gui_btn_details.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_details.setInlineAllStyles("fgColor:3c4646;");
        gui_btn_details.setName("btn_details");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_details, "\ue314".charAt(0));
        gui_lbl_total_price.setPreferredSizeStr("8.201058mm 7.142857mm");
        gui_lbl_total_price.setText("50.5 JOD  ");
        gui_lbl_total_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total_price.setInlineAllStyles("font:2.5mm; fgColor:a3cc2e; alignment:right;");
        gui_lbl_total_price.setName("lbl_total_price");
        gui_Container_2.addComponent(gui_btn_details);
        gui_Container_2.addComponent(gui_lbl_total_price);
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_details.getParent().getLayout()).setInsets(gui_btn_details, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_btn_details, "-1 -1 -1 -1").setReferencePositions(gui_btn_details, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_total_price.getParent().getLayout()).setInsets(gui_lbl_total_price, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_total_price, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_total_price, "0.0 0.0 0.0 1.0");
        gui_Container.addComponent(gui_Container_3);
        gui_Label_1.setPreferredSizeStr("5.291005mm 4.7619047mm");
        gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("bgImage:ic_card.png;");
        gui_Label_1.setName("Label_1");
        gui_Container_3.addComponent(gui_Label_1);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "auto auto auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_lbl_date_start);
        gui_Container.addComponent(gui_lbl_name);
        gui_Container.addComponent(gui_lbl_id_order);
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_divider.getParent().getLayout()).setInsets(gui_lbl_divider, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_divider, "-1 -1 -1 -1").setReferencePositions(gui_lbl_divider, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 19.31217);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 13.227513);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "0.0mm auto 0.0mm 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredWidthMM((float) 11.640212);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredHeightMM((float) 8.994709);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getParent().getLayout()).setInsets(gui_Container_3, "auto 2.0mm auto auto").setReferenceComponents(gui_Container_3, "-1 -1 -1 -1").setReferencePositions(gui_Container_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_date_start.getParent().getLayout()).setInsets(gui_lbl_date_start, "0.0mm 2.0mm 2.0mm 0.0mm").setReferenceComponents(gui_lbl_date_start, "4 2 -1 1 ").setReferencePositions(gui_lbl_date_start, "1.0 1.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "2.0mm 2.0mm 50.0% 0.0mm").setReferenceComponents(gui_lbl_name, "-1 2 -1 1 ").setReferencePositions(gui_lbl_name, "0.0 1.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_id_order.getParent().getLayout()).setInsets(gui_lbl_id_order, "50.0% 50.0% 50.0% 50.0%").setReferenceComponents(gui_lbl_id_order, "-1 -1 -1 -1").setReferencePositions(gui_lbl_id_order, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 74.86773);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 12.962963);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
    }
}
