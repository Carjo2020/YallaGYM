package com.yallagym.club.layouts;

import com.cn2.ui.cn1Display;
import com.codename1.ui.util.Resources;
import java.util.List;
import java.util.Map;

public class club_payment_con_month extends com.codename1.ui.Container {

    public club_payment_con_month() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public club_payment_con_month(com.codename1.ui.util.Resources res) {
        checkLanguage(res);
        int highet = cn1Display.getHeight() / 10;
        for (int i = 0; i < 3; i++) {
            gui_con_list.add(new club_payment_con_month_item(res));
        }
//        gui_con_list.setPreferredH(highet * 3);
//        this.setPreferredH(highet * 3+400);
        gui_con_list.setScrollableY(false);
        gui_con_list.setScrollVisible(false);
    }

    public club_payment_con_month(com.codename1.ui.util.Resources res, int no, int size) {
        checkLanguage(res);
        int highet = cn1Display.getHeight() / 10;
        for (int i = 0; i < no; i++) {
            gui_con_list.add(new club_payment_con_month_item(res));
        }
        gui_con_month.setPreferredH(no * size + gui_Container.getPreferredH());
        gui_con_list.setScrollableY(false);
        gui_con_list.setScrollVisible(false);
    }

    public club_payment_con_month(com.codename1.ui.util.Resources res, String type, Map<String, Object> month, int size) {
        checkLanguage(res);
        List< Map<String, Object>> month_orders = (List< Map<String, Object>>) month.get("month_orders");
        int highet = cn1Display.getHeight() / 10;
                    gui_con_list.setScrollableY(false);
            gui_con_list.setScrollVisible(false);
             gui_con_month.setPreferredH(month_orders.size() * size + gui_Container.getPreferredH());
        if (type.equals("red")) {
            for (Map<String, Object> order : month_orders) {
                gui_con_list.add(new club_payment_con_month_item(res, "red", $(order.get("id_order")), $(order.get("name")), $(order.get("date_order")), $(order.get("fees_order"))));
            }
            gui_lbl_total.getAllStyles().setFgColor(0xc90000);
            gui_lbl_total.setText("-" + month.get("month_total_price") + " JOD");
            gui_lbl_month_name.setText(month.get("month_name") + "");
        } else if (type.equals("green")) {

            for (Map<String, Object> order : month_orders) {
                gui_con_list.add(new club_payment_con_month_item(res, "green", $(order.get("id_order")), $(order.get("name")), $(order.get("date_order")), $(order.get("gym_price"))));
            }
            gui_lbl_total.setText(month.get("month_total_price") + " JOD");
            gui_lbl_month_name.setText(month.get("month_name") + "");
        }

    }
//res, $(order.get(""), $(order.get(""), $(order.get(""), $(order.get(""), $(order.get("")
//////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_con_month = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_month_name = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_total = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_con_list = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setUIID("Container");
                setInlineStylesTheme(resourceObjectInstance);
        setName("club_payment_con_month");
        gui_con_month.setPreferredSizeStr("inherit 51.32275mm");
        gui_con_month.setUIID("White_Con");
                gui_con_month.setInlineStylesTheme(resourceObjectInstance);
        gui_con_month.setName("con_month");
        addComponent(gui_con_month);
        gui_Container.setPreferredSizeStr("51.32275mm 14.814815mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_con_list.setPreferredSizeStr("38.359787mm 108.20106mm");
        gui_con_list.setScrollableY(false);
                gui_con_list.setInlineStylesTheme(resourceObjectInstance);
        gui_con_list.setName("con_list");
        gui_con_month.addComponent(gui_Container);
        gui_lbl_month_name.setPreferredSizeStr("65.87302mm 5.026455mm");
        gui_lbl_month_name.setText("December transaction");
                gui_lbl_month_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_month_name.setInlineAllStyles("font:4.0mm; fgColor:0; alignment:center;");
        gui_lbl_month_name.setName("lbl_month_name");
        gui_Container_2.setPreferredSizeStr("31.481482mm 7.4074073mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_lbl_month_name);
        gui_Container.addComponent(gui_Container_2);
        gui_Label_1.setPreferredSizeStr("16.666666mm 11.375662mm");
        gui_Label_1.setText("Total  ");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:3.0mm; fgColor:0; alignment:right;");
        gui_Label_1.setName("Label_1");
        gui_lbl_total.setPreferredSizeStr("20.10582mm 8.994709mm");
        gui_lbl_total.setText("30 JOD");
                gui_lbl_total.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total.setInlineAllStyles("font:3.0mm; fgColor:a5cd34;");
        gui_lbl_total.setName("lbl_total");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Container_2.addComponent(gui_lbl_total);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 50.0% 0.0mm 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total.getParent().getLayout()).setInsets(gui_lbl_total, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_total, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_total, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_month_name.getParent().getLayout()).setInsets(gui_lbl_month_name, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_month_name, "-1 -1 -1 -1").setReferencePositions(gui_lbl_month_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)31.481482);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "-2.3841858E-7mm auto auto auto").setReferenceComponents(gui_Container_2, "0 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        gui_con_month.addComponent(gui_con_list);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)62.433865);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)14.814815);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_list.getParent().getLayout()).setInsets(gui_con_list, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_con_list, "0 -1 -1 -1").setReferencePositions(gui_con_list, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_month.getLayout()).setPreferredWidthMM((float)76.190475);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_month.getLayout()).setPreferredHeightMM((float)51.32275);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_month.getParent().getLayout()).setInsets(gui_con_month, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_con_month, "-1 -1 -1 -1").setReferencePositions(gui_con_month, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!S LINE!!!
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
        setName("club_payment_con_month");
        gui_con_month.setPreferredSizeStr("inherit 51.32275mm");
        gui_con_month.setUIID("White_Con");
                gui_con_month.setInlineStylesTheme(resourceObjectInstance);
        gui_con_month.setName("con_month");
        addComponent(gui_con_month);
        gui_Container.setPreferredSizeStr("51.32275mm 14.814815mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_con_list.setPreferredSizeStr("38.359787mm 108.20106mm");
        gui_con_list.setScrollableY(false);
                gui_con_list.setInlineStylesTheme(resourceObjectInstance);
        gui_con_list.setName("con_list");
        gui_con_month.addComponent(gui_Container);
        gui_lbl_month_name.setPreferredSizeStr("65.87302mm 5.026455mm");
        gui_lbl_month_name.setText("December transaction");
                gui_lbl_month_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_month_name.setInlineAllStyles("font:4.0mm; fgColor:0; alignment:center;");
        gui_lbl_month_name.setName("lbl_month_name");
        gui_Container_2.setPreferredSizeStr("31.481482mm 7.4074073mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_lbl_month_name);
        gui_Container.addComponent(gui_Container_2);
        gui_Label_1.setPreferredSizeStr("15.608466mm 11.375662mm");
        gui_Label_1.setText("Total  ");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:3.0mm; fgColor:0; alignment:left;");
        gui_Label_1.setName("Label_1");
        gui_lbl_total.setPreferredSizeStr("20.10582mm 8.994709mm");
        gui_lbl_total.setText("30 JOD");
                gui_lbl_total.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_total.setInlineAllStyles("font:3.0mm; fgColor:a5cd34; alignment:right;");
        gui_lbl_total.setName("lbl_total");
        gui_Container_2.addComponent(gui_Label_1);
        gui_Container_2.addComponent(gui_lbl_total);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 0.0mm 0.0mm 1.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 1 ").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_total.getParent().getLayout()).setInsets(gui_lbl_total, "0.0mm 50.0% 0.0mm 0.0mm").setReferenceComponents(gui_lbl_total, "-1 -1 -1 -1").setReferencePositions(gui_lbl_total, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_month_name.getParent().getLayout()).setInsets(gui_lbl_month_name, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_month_name, "-1 -1 -1 -1").setReferencePositions(gui_lbl_month_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)31.481482);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)7.4074073);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "-2.3841858E-7mm auto auto auto").setReferenceComponents(gui_Container_2, "0 -1 -1 -1").setReferencePositions(gui_Container_2, "1.0 0.0 0.0 0.0");
        gui_con_month.addComponent(gui_con_list);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)62.433865);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)14.814815);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_list.getParent().getLayout()).setInsets(gui_con_list, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_con_list, "0 -1 -1 -1").setReferencePositions(gui_con_list, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_month.getLayout()).setPreferredWidthMM((float)76.190475);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_month.getLayout()).setPreferredHeightMM((float)51.32275);
        ((com.codename1.ui.layouts.LayeredLayout)gui_con_month.getParent().getLayout()).setInsets(gui_con_month, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_con_month, "-1 -1 -1 -1").setReferencePositions(gui_con_month, "0.0 0.0 0.0 0.0");
    }// </editor-fold>


    private void setRTLCmb(Resources res) {
    }
}
