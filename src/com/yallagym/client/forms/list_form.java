package com.yallagym.client.forms;

import com.cn2.lang.cn1Math;
import com.cn2.util.cn1String;
import com.codename1.components.Switch;
import com.codename1.io.Preferences;
import com.codename1.l10n.L10NManager;
import com.codename1.maps.Coord;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.codename1.util.StringUtil;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import com.yallagym.client.dialogs.dlg_apple_select_map;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.client.dialogs.rating_user_to_gym;
import com.yallagym.client.layouts.list_con;
import java.util.List;
import java.util.Map;

public class list_form extends BaseForm {

    APIs api = new APIs();
    List<Map<String, Object>> list;

    public list_form() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public list_form(com.codename1.ui.util.Resources res) {
        String username = Preferences.get("username", "null");
        String password = Preferences.get("password", "null");

        tf_search = createSearchBar(res, gui_Con_Search);
        checkLanguage(res);
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
                new erorr(res, "Warning", "Do you want to exit from app?", "Yes", e -> {
                    Display.getInstance().exitApplication();
                }).show();
            }
        };
        this.setBackCommand(back);
        list = api.getGymBaseInfo(res);
        setList(list);
        installFixItems(res);
        addList(res);
        String checkRatingOrder = api.checkRatingOrder();
        if (!checkRatingOrder.equals("false")) {
            new UITimer(() -> {
                new rating_user_to_gym(res, StringUtil.replaceAll(checkRatingOrder, ".0", "")).show();
            }).schedule(500, false, this);
        }

//        double lat = Preferences.get("lat", 0);
//        double lng = Preferences.get("lng", 0);
//        if (lat != 0 && lng != 0) {
//            Coord coord = new Coord(lat, lng);
//            addList(res, coord);
//        } else {
//        }
    }

    @Override
    public void show() {
        switch_cpm.setPropertyValue("value", true);
        super.show(); //To change body of generated methods, choose Tools | Templates.
    }

    //////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Container gui_Con_Search = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("list_form");
        setName("list_form");
        gui_Container.setPreferredSizeStr("inherit 110.31746mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_Con_Search.setPreferredSizeStr("82.80423mm 14.021164mm");
        gui_Con_Search.setUIID("search_input");
                gui_Con_Search.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Search.setName("Con_Search");
        addComponent(gui_Container);
        addComponent(gui_Con_Search);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "1 -1 -1 -1").setReferencePositions(gui_Container, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Search.getLayout()).setPreferredWidthMM((float)63.756615);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Search.getLayout()).setPreferredHeightMM((float)14.021164);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Search.getParent().getLayout()).setInsets(gui_Con_Search, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Search, "-1 -1 -1 -1").setReferencePositions(gui_Con_Search, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!-- DON'T EDIT ABOVE THIS LINE!!! 
    TextField tf_search;
    boolean BOOL_SWITCH;
    Switch switch_cpm = new Switch();

    private void installFixItems(Resources res) {
        installTitleArea(res);
        installSideMenu(res, this);
        this.setScrollable(false);
        this.setScrollVisible(false);
        gui_Container.setScrollableY(true);
        gui_Container.setScrollVisible(false);
        switch_cpm.getAllStyles().setFgColor(0xF7ED23);
        switch_cpm.getAllStyles().setBgColor(0xA3CC2E);
        switch_cpm.setPropertyValue("value", true);
        if (!isArabic()) {
            getToolbar().addComponent(BorderLayout.EAST, switch_cpm);
        } else {
            getToolbar().addComponent(BorderLayout.WEST, switch_cpm);
        }
        switch_cpm.addActionListener(e -> {
            if (isAndroid()) {
                if (switch_cpm.isOff()) {
                    Form lastform = getCerruntForm();
                    if (lastform != null) {
                        lastform.show();
                    } else {
                        Form map = new map_form(res, this, null);
                        setCerruntForm(map);
                        map.show();
                    }
                }
            } else {

                boolean is_select_map = Preferences.get("map_type", false);
                if (is_select_map) {
                    if (switch_cpm.isOff()) {
                        Form lastform = getCerruntForm();
                        if (lastform != null) {
                            lastform.show();
                        } else {
                            Form map = new map_form(res, this, null);
                            setCerruntForm(map);
                            map.show();
                        }
                    }
                } else {
                    switch_cpm.setPropertyValue("value", true);
                    new dlg_apple_select_map(res).show();
                }

            }
        });
        this.revalidate();

    }

    private void addList(Resources res) {
        for (Map<String, Object> map : list) {
            String id_gym = map.get("id") + "";
            String name = map.get("name") + "";
            String price_d = (Integer.valueOf(map.get("price_d").toString()) + Integer.valueOf(map.get("price_d_fees").toString())) + " JD";
            String price_w = (Integer.valueOf(map.get("price_w").toString()) + Integer.valueOf(map.get("price_w_fees").toString())) + " JD";
            String price_m = (Integer.valueOf(map.get("price_m").toString()) + Integer.valueOf(map.get("price_m_fees").toString())) + " JD";
            if (map.get("price_d").toString().equals("0")) {
                price_d = "null";
            }
            if (map.get("price_w").toString().equals("0")) {
                price_w = "null";
            }
            if (map.get("price_m").toString().equals("0")) {
                price_m = "null";
            }
//       String price_d="2 JD";
//            String price_w = map.get("price_w") + " JD";
//            String price_m = map.get("price_m") + " JD";
            String coordinates = map.get("coordinates") + "";
            String address = map.get("address") + "";
            String[] adressSub = cn1String.splite(coordinates, ",");
            double lat = Double.valueOf(adressSub[0]);
            double lon = Double.valueOf(adressSub[1]);
//                String distance = L10NManager.getInstance().format(cn1Math.distanceFromCoordinate(deviceCoord.getLatitude(), deviceCoord.getLongitude(), lat, lon, 'K'), 1);
            gui_Container.add(new list_con(res, id_gym, name, price_d, price_w, price_m, address/*, distance + " km"*/));

        }

        tf_search.addDataChangedListener(new DataChangedListener() {
            @Override
            public void dataChanged(int type, int index) {
                String search = StringUtil.replaceAll(tf_search.getText(), " ", "").toLowerCase();
                if (search.length() > 0) {
                    gui_Container.removeAll();
                    gui_Container.revalidate();
                    for (Map<String, Object> map : list) {
                        String id_gym = map.get("id") + "";
                        String name = map.get("name") + "";
                        String name_filter = StringUtil.replaceAll(name, " ", "").toLowerCase();
                        if (name_filter.contains(search)) {
                            String price_d = (Integer.valueOf(map.get("price_d").toString()) + Integer.valueOf(map.get("price_d_fees").toString())) + " JD";
                            String price_w = (Integer.valueOf(map.get("price_w").toString()) + Integer.valueOf(map.get("price_w_fees").toString())) + " JD";
                            String price_m = (Integer.valueOf(map.get("price_m").toString()) + Integer.valueOf(map.get("price_m_fees").toString())) + " JD";
                            String coordinates = map.get("coordinates") + "";
                            String address = map.get("address") + "";
                            String[] adressSub = cn1String.splite(coordinates, ",");
                            double lat = Double.valueOf(adressSub[0]);
                            double lon = Double.valueOf(adressSub[1]);
//                            String distance = L10NManager.getInstance().format(cn1Math.distanceFromCoordinate(deviceCoord.getLatitude(), deviceCoord.getLongitude(), lat, lon, 'K'), 1);
                            gui_Container.add(new list_con(res, id_gym, name, price_d, price_w, price_m, address/*, distance + " km"*/));
                        }
                    }
                    gui_Container.revalidate();
                } else {
                    gui_Container.removeAll();
                    gui_Container.revalidate();
                    for (Map<String, Object> map : list) {
                        String id_gym = map.get("id") + "";
                        String name = map.get("name") + "";
                        String price_d = (Integer.valueOf(map.get("price_d").toString()) + Integer.valueOf(map.get("price_d_fees").toString())) + " JD";
                        String price_w = (Integer.valueOf(map.get("price_w").toString()) + Integer.valueOf(map.get("price_w_fees").toString())) + " JD";
                        String price_m = (Integer.valueOf(map.get("price_m").toString()) + Integer.valueOf(map.get("price_m_fees").toString())) + " JD";
                        String coordinates = map.get("coordinates") + "";
                        String address = map.get("address") + "";
                        String[] adressSub = cn1String.splite(coordinates, ",");
                        double lat = Double.valueOf(adressSub[0]);
                        double lon = Double.valueOf(adressSub[1]);
//                            String distance = L10NManager.getInstance().format(cn1Math.distanceFromCoordinate(deviceCoord.getLatitude(), deviceCoord.getLongitude(), lat, lon, 'K'), 1);
                        gui_Container.add(new list_con(res, id_gym, name, price_d, price_w, price_m, address/*, distance + " km"*/));
                    }
                }
                gui_Container.revalidate();
            }
        }
        );
    }

    private void addList(Resources res, Coord coord) {
        for (Map<String, Object> map : list) {
            String id_gym = map.get("id") + "";
            String name = map.get("name") + "";
            String price_d = (Integer.valueOf(map.get("price_d").toString()) + Integer.valueOf(map.get("price_d_fees").toString())) + " JD";
            String price_w = (Integer.valueOf(map.get("price_w").toString()) + Integer.valueOf(map.get("price_w_fees").toString())) + " JD";
            String price_m = (Integer.valueOf(map.get("price_m").toString()) + Integer.valueOf(map.get("price_m_fees").toString())) + " JD";
            if (map.get("price_d").toString().equals("0")) {
                price_d = "null";
            }
            if (map.get("price_w").toString().equals("0")) {
                price_w = "null";
            }
            if (map.get("price_m").toString().equals("0")) {
                price_m = "null";
            }
            String coordinates = map.get("coordinates") + "";
            String address = map.get("address") + "";
            String[] adressSub = cn1String.splite(coordinates, ",");
            double lat = Double.valueOf(adressSub[0]);
            double lon = Double.valueOf(adressSub[1]);
            String distance = L10NManager.getInstance().format(cn1Math.distanceFromCoordinate(coord.getLatitude(), coord.getLongitude(), lat, lon, 'K'), 1);
            gui_Container.add(new list_con(res, id_gym, name, price_d, price_w, price_m, address, distance));

        }

        tf_search.addDataChangedListener(new DataChangedListener() {
            @Override
            public void dataChanged(int type, int index) {
                String search = StringUtil.replaceAll(tf_search.getText(), " ", "").toLowerCase();
                if (search.length() > 0) {
                    gui_Container.removeAll();
                    gui_Container.revalidate();
                    for (Map<String, Object> map : list) {
                        String id_gym = map.get("id") + "";
                        String name = map.get("name") + "";
                        String name_filter = StringUtil.replaceAll(name, " ", "").toLowerCase();
                        if (name_filter.contains(search)) {
                            String price_d = (Integer.valueOf(map.get("price_d").toString()) + Integer.valueOf(map.get("price_d_fees").toString())) + " JD";
                            String price_w = (Integer.valueOf(map.get("price_w").toString()) + Integer.valueOf(map.get("price_w_fees").toString())) + " JD";
                            String price_m = (Integer.valueOf(map.get("price_m").toString()) + Integer.valueOf(map.get("price_m_fees").toString())) + " JD";
                            String coordinates = map.get("coordinates") + "";
                            String address = map.get("address") + "";
                            String[] adressSub = cn1String.splite(coordinates, ",");
                            double lat = Double.valueOf(adressSub[0]);
                            double lon = Double.valueOf(adressSub[1]);
//                            String distance = L10NManager.getInstance().format(cn1Math.distanceFromCoordinate(deviceCoord.getLatitude(), deviceCoord.getLongitude(), lat, lon, 'K'), 1);
                            gui_Container.add(new list_con(res, id_gym, name, price_d, price_w, price_m, address/*, distance + " km"*/));
                        }
                    }
                    gui_Container.revalidate();
                } else {
                    gui_Container.removeAll();
                    gui_Container.revalidate();
                    for (Map<String, Object> map : list) {
                        String id_gym = map.get("id") + "";
                        String name = map.get("name") + "";
                        String price_d = (Integer.valueOf(map.get("price_d").toString()) + Integer.valueOf(map.get("price_d_fees").toString())) + " JD";
                        String price_w = (Integer.valueOf(map.get("price_w").toString()) + Integer.valueOf(map.get("price_w_fees").toString())) + " JD";
                        String price_m = (Integer.valueOf(map.get("price_m").toString()) + Integer.valueOf(map.get("price_m_fees").toString())) + " JD";
                        String coordinates = map.get("coordinates") + "";
                        String address = map.get("address") + "";
                        String[] adressSub = cn1String.splite(coordinates, ",");
                        double lat = Double.valueOf(adressSub[0]);
                        double lon = Double.valueOf(adressSub[1]);
//                            String distance = L10NManager.getInstance().format(cn1Math.distanceFromCoordinate(deviceCoord.getLatitude(), deviceCoord.getLongitude(), lat, lon, 'K'), 1);
                        gui_Container.add(new list_con(res, id_gym, name, price_d, price_w, price_m, address/*, distance + " km"*/));
                    }
                }
                gui_Container.revalidate();
            }
        }
        );
    }

    private void checkLanguage(Resources res) {
        initGuiBuilderComponents(res);
        if (com.yallagym.BaseForm.isArabic()) {
            setRTLCmb(res);
        }

    }

    private void setRTLCmb(Resources res) {
        tf_search.setRTL(true);
        tf_search.getHintLabel().setRTL(true);
    }
}
