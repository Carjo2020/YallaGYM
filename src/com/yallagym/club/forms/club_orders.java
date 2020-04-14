package com.yallagym.club.forms;

import com.cn2.lang.cn1Math;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ToastBar;
import com.codename1.ext.codescan.CodeScanner;
import com.codename1.ext.codescan.ScanResult;
import com.codename1.io.Preferences;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import static com.codename1.ui.CN.EAST;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.yallagym.BaseForm;
import static com.yallagym.club.forms.club_BaseForm.getCurrentListing;
import com.yallagym.club.layouts.club_order_con;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.club.dialogs.club_qr_first;
import com.yallagym.forms.login.forms.login_form;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;
//import org.littlemonkey.qrscanner.QRScanner;

public class club_orders extends club_BaseForm {
    
    Resources res;
    int size = 56;
    Container pending;
    Container accepted;
    Container blocked;
    Container ended;
    TextField tf_search;
    SimpleDateFormat dateFormat = new SimpleDateFormat("d - M - yyyy");
    
    public club_orders() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
    }
    
    public club_orders(com.codename1.ui.util.Resources res) {
        initGuiBuilderComponents(res);
        this.res = res;
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
                new erorr(res, "Warning", "Do you want to exit from app?", "Yes", e -> {
                    Display.getInstance().exitApplication();
                }).show();
            }
        };
        this.setBackCommand(back);
        installFixItems();
        gui_Con_Tabs.add(CENTER, createTabs());
        setupSearchBar();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Con_Search = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Con_Tabs = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("club_orders");
        setName("club_orders");
        gui_Con_Search.setPreferredSizeStr("51.851852mm 12.962963mm");
                gui_Con_Search.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Search.setName("Con_Search");
        gui_Con_Tabs.setPreferredSizeStr("93.1217mm 56.613758mm");
                gui_Con_Tabs.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Tabs.setName("Con_Tabs");
        addComponent(gui_Con_Search);
        addComponent(gui_Con_Tabs);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Search.getLayout()).setPreferredWidthMM((float)52.38095);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Search.getLayout()).setPreferredHeightMM((float)12.962963);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Search.getParent().getLayout()).setInsets(gui_Con_Search, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Search, "-1 -1 -1 -1").setReferencePositions(gui_Con_Search, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Tabs.getLayout()).setPreferredWidthMM((float)52.38095);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Tabs.getLayout()).setPreferredHeightMM((float)56.613758);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Tabs.getParent().getLayout()).setInsets(gui_Con_Tabs, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Con_Tabs, "0 -1 -1 -1").setReferencePositions(gui_Con_Tabs, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!N'T EDIT ABOVE THIS LINE!!!   
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Preferences.clearAll();
        new login_form(res).show();
    }
    
    private void installFixItems() {
        
        installSideMenu(res, this);
        
        installTitleArea(res);
        this.setScrollable(false);
        gui_Con_Tabs.setScrollableY(false);
        Button btn = new Button("");
//        System.out.println(getToolbar().getPreferredH());
        int scale = cn1Math.nextDown(getToolbar().getPreferredH() * 0.50);
        btn.setPreferredW(scale);
        btn.setPreferredH(scale);
        btn.setIcon(res.getImage("qrcode_ic.png")/*.scaled(scale, scale)*/);
        btn.getAllStyles().setPadding(0, 0, 0, 0);
//        btn.getAllStyles().setBgImage(res.getImage("qrcode_ic.png").scaled(scale, scale));
        if (!BaseForm.isArabic()) {
            getToolbar().addComponent(EAST, btn);
        } else {
            getToolbar().addComponent(CN.WEST, btn);
        }
        System.out.println("run1");
        btn.addActionListener(e -> scanQrCode());
        tf_search = createSearchBar(res, gui_Con_Search);
    }
    Tabs tabs = new Tabs(Component.BOTTOM);
    
    private Tabs createTabs() {
        Map<String, Object> currentListing = getCurrentListing();
        
        List<Map<String, Object>> pending_list = (List<Map<String, Object>>) currentListing.get("pending");
        List<Map<String, Object>> accepted_list = (List<Map<String, Object>>) currentListing.get("accepted");
        List<Map<String, Object>> blocked_list = (List<Map<String, Object>>) currentListing.get("blocked");
        List<Map<String, Object>> ended_list = (List<Map<String, Object>>) currentListing.get("ended");
        pending = getPendingContainer(pending_list);
        accepted = getAcceptedContainer(accepted_list);
        blocked = getBlockedContainer(blocked_list);
        ended = getEndedContainer(ended_list);
        if (!BaseForm.isArabic()) {
            tabs.addTab("", res.getImage("in_proccess_order_ic.png").scaled(size, size), res.getImage("in_proccess_order_orange_ic.png").scaled(size, size), pending);
            tabs.addTab("", res.getImage("accepted_order_ic.png").scaled(size, size), res.getImage("accepted_order_green_ic.png").scaled(size, size), accepted);
            tabs.addTab("", res.getImage("not_accepted_order_ic.png").scaled(size, size), res.getImage("not_accepted_order_red_ic.png").scaled(size, size), blocked);
            tabs.addTab("", res.getImage("finish_order_ic.png").scaled(size, size), res.getImage("finish_order_black_ic.png").scaled(size, size), ended);
        } else {
            tabs.addTab("", res.getImage("finish_order_ic.png").scaled(size, size), res.getImage("finish_order_black_ic.png").scaled(size, size), ended);
            tabs.addTab("", res.getImage("not_accepted_order_ic.png").scaled(size, size), res.getImage("not_accepted_order_red_ic.png").scaled(size, size), blocked);
            tabs.addTab("", res.getImage("accepted_order_ic.png").scaled(size, size), res.getImage("accepted_order_green_ic.png").scaled(size, size), accepted);
            tabs.addTab("", res.getImage("in_proccess_order_ic.png").scaled(size, size), res.getImage("in_proccess_order_orange_ic.png").scaled(size, size), pending);
            tabs.setSelectedIndex(3);
        }

//        tabs.setSmoothScrolling(true);
//        tabs.setAnimateTabSelection(focusScrolling);
//        tabs.setSwipeActivated(true);
        tabs.getAllStyles().setBgTransparency(0);
        tabs.getComponentAt(0).setUIID("Form");
        tabs.getComponentAt(1).getAllStyles().setBgColor(0XF7ED23);
        tabs.getComponentAt(1).getAllStyles().setBgTransparency(255);
        RadioButton r1 = (RadioButton) ((Container) tabs.getComponentAt(1)).getComponentAt(0);
        RadioButton r2 = (RadioButton) ((Container) tabs.getComponentAt(1)).getComponentAt(1);
        RadioButton r3 = (RadioButton) ((Container) tabs.getComponentAt(1)).getComponentAt(2);
        RadioButton r4 = (RadioButton) ((Container) tabs.getComponentAt(1)).getComponentAt(3);
        
        r1.getAllStyles().setFgColor(0XFF971D);
        r1.addActionListener(e -> {
            r1.getAllStyles().setFgColor(0XFF8A00);
            r2.getAllStyles().setFgColor(0X3C4646);
            r3.getAllStyles().setFgColor(0X3C4646);
            r4.getAllStyles().setFgColor(0X3C4646);
            Map<String, Object> currentListing_new = getCurrentListing();
            List<Map<String, Object>> pending_list_new = (List<Map<String, Object>>) currentListing_new.get("pending");
            pending.removeAll();
            pending.setLayout(new BorderLayout());
            pending.setScrollableY(false);
            pending.add(CENTER, getPendingContainer(pending_list_new));
            this.revalidate();
        });
        
        r2.addActionListener(e -> {
            r1.getAllStyles().setFgColor(0X3C4646);
            r2.getAllStyles().setFgColor(0X2CBB1C);
            r3.getAllStyles().setFgColor(0X3C4646);
            r4.getAllStyles().setFgColor(0X3C4646);
            Map<String, Object> currentListing_new = getCurrentListing();
            List<Map<String, Object>> accepted_list_new = (List<Map<String, Object>>) currentListing_new.get("accepted");
            accepted.removeAll();
            accepted.setLayout(new BorderLayout());
            accepted.setScrollableY(false);
            accepted.add(CENTER, getAcceptedContainer(accepted_list_new));
            this.revalidate();
        });

//        r3.getAllStyles().setFgColor(0XC90000);
        r3.addActionListener(e -> {
            
            r1.getAllStyles().setFgColor(0X3C4646);
            r2.getAllStyles().setFgColor(0X3C4646);
            r3.getAllStyles().setFgColor(0XE91E1E);
            r4.getAllStyles().setFgColor(0X3C4646);
            Map<String, Object> currentListing_new = getCurrentListing();
            List<Map<String, Object>> blocked_list_new = (List<Map<String, Object>>) currentListing_new.get("blocked");
            blocked.removeAll();
            blocked.setLayout(new BorderLayout());
            blocked.setScrollableY(false);
            blocked.add(CENTER, getBlockedContainer(blocked_list_new));
            this.revalidate();
        });

//        r4.getAllStyles().setFgColor(0X000000);
        r4.addActionListener(e -> {
            
            r1.getAllStyles().setFgColor(0X3C4646);
            r2.getAllStyles().setFgColor(0X3C4646);
            r3.getAllStyles().setFgColor(0X3C4646);
            r4.getAllStyles().setFgColor(0X191919);
            Map<String, Object> currentListing_new = getCurrentListing();
            List<Map<String, Object>> ended_list_new = (List<Map<String, Object>>) currentListing_new.get("ended");
            ended.removeAll();
            ended.setLayout(new BorderLayout());
            ended.setScrollableY(false);
            ended.add(CENTER, getEndedContainer(ended_list_new));
            this.revalidate();
        });
        return tabs;
    }
    club_APIs api = new club_APIs();
    
    private Container getPendingContainer(List<Map<String, Object>> list) {
        Container pending = new Container();
        pending.setLayout(BoxLayout.y());
        pending.setScrollableY(true);
        pending.setScrollVisible(false);
        for (Map<String, Object> map : list) {
            pending.add(new club_order_con(res, $(map.get("id_order")), $(map.get("name")), $(map.get("phone")), $(map.get("total_price")) + " JOD", $(map.get("date_start")), $(map.get("date_end")), $(map.get("subscribe_type")), $(map.get("time_format")), "pending"));
        }
        pending.addPullToRefresh(() -> {
            Map<String, Object> orders = api.getGymOrders();
            club_BaseForm.currentListing = orders;
            List<Map<String, Object>> pending_list_new = (List<Map<String, Object>>) orders.get("pending");
            pending.removeAll();
            for (Map<String, Object> map : pending_list_new) {
                pending.add(new club_order_con(res, $(map.get("id_order")), $(map.get("name")), $(map.get("phone")), $(map.get("total_price")) + " JOD", $(map.get("date_start")), $(map.get("date_end")), $(map.get("subscribe_type")), $(map.get("time_format")), "pending"));
            }
            this.revalidate();
        });
        return pending;
    }
    
    private Container getAcceptedContainer(List<Map<String, Object>> list) {
        Container accepted = new Container();
        accepted.setLayout(BoxLayout.y());
        accepted.setScrollableY(true);
        accepted.setScrollVisible(false);
        for (Map<String, Object> map : list) {
            accepted.add(new club_order_con(res, $(map.get("id_order")), $(map.get("name")), $(map.get("phone")), $(map.get("total_price")) + " JOD", $(map.get("date_start")), $(map.get("date_end")), $(map.get("subscribe_type")), $(map.get("time_format")), "accepted"));
        }
        return accepted;
    }
    
    private Container getBlockedContainer(List<Map<String, Object>> list) {
        Container blocked = new Container();
        blocked.setLayout(BoxLayout.y());
        blocked.setScrollableY(true);
        blocked.setScrollVisible(false);
        for (Map<String, Object> map : list) {
            blocked.add(new club_order_con(res, $(map.get("id_order")), $(map.get("name")), $(map.get("phone")), $(map.get("total_price")) + " JOD", $(map.get("date_start")), $(map.get("date_end")), $(map.get("subscribe_type")), $(map.get("time_format")), "blocked"));
        }
        return blocked;
    }
    
    private Container getEndedContainer(List<Map<String, Object>> list) {
        Container ended = new Container();
        ended.setLayout(BoxLayout.y());
        ended.setScrollableY(true);
        ended.setScrollVisible(false);
        for (Map<String, Object> map : list) {
            ended.add(new club_order_con(res, $(map.get("id_order")), $(map.get("name")), $(map.get("phone")), $(map.get("total_price")) + " JOD", $(map.get("date_start")), $(map.get("date_end")), $(map.get("subscribe_type")), $(map.get("time_format")), "ended"));
        }
        return ended;
    }
    
//    private void scanAndroidDevice() {
////        if (org.littlemonkey.qrscanner.QRScannerCodeScanner.getInstance() != null) {
//        org.littlemonkey.qrscanner.QRScanner.scanQRCode(new com.codename1.ext.codescan.ScanResult() {
//            @Override
//            public void scanCompleted(String contents, String formatName, byte[] rawBytes) {
//                String decryptID = api.decryptID(contents);
//                if (!decryptID.equals("faild")) {
//                    try {
//                        String id_order = StringUtil.replaceAll(decryptID, " ", "");
//                        InfiniteProgress prog = new InfiniteProgress();
//                        Dialog dlg = prog.showInifiniteBlocking();
//                        String getStatusOrder = api.isOrderForGym(id_order);
//                        
//                        switch (getStatusOrder) {
//                            case "pending":
//                                dlg.dispose();
//                                new erorr(res, "Required Step", "This order is in pending\ndo you want to accept it and continue?", "ok", e -> {
//                                    Map<String, Object> map = api.getGymOrder(id_order);
//                                    new club_qr_first(res, id_order, $(map.get("name")), $(map.get("total_price")) + " JOD", $(map.get("subscribe_type")), $(map.get("date_start")), $(map.get("date_end")), $(map.get("pay_method"))).show();
//                                }).show();
//                                break;
//                            case "accepted":
//                                Map<String, Object> map = api.getGymOrder(id_order);
//                                dlg.dispose();
//                                new club_qr_first(res, id_order, $(map.get("name")), $(map.get("total_price")) + " JOD", $(map.get("subscribe_type")), $(map.get("date_start")), $(map.get("date_end")), $(map.get("pay_method"))).show();
//                                
//                                break;
//                            case "blocked":
//                                dlg.dispose();
//                                new erorr_msg(res, "WARNING!!", "This user was blocked from you, you should unblock and then tell customer to open a new order.", "ok", null).show();
//                                break;
//                            case "rejected":
//                                dlg.dispose();
//                                new erorr_msg(res, "WARNING!!", "This order is rejected\nplease tell customer to open a new order.", "ok", null).show();
//                                break;
//                            case "ended":
//                                Map<String, Object> map1 = api.getOrder(id_order);
//                                String date_end = map1.get("date_end") + "";
//                                Long end = Long.parseLong(date_end);
//                                System.out.println("date_end" + date_end);
//                                dlg.dispose();
//                                if (new Date().getTime() < end) {
//                                    new erorr_msg(res, "Status: Active", "This order is still active for:\n\n" + dateFormat.format(new Date(end)), "ok", null).show();
//                                } else {
//                                    new erorr_msg(res, "Status: End", "This order was ended.", "ok", null).show();
//                                }
//                                break;
//                            case "false":
//                                dlg.dispose();
//                                new erorr_msg(res, "User error", "This order is for another gym", "Ok", null).show();
//                                break;
//                            default:
//                                dlg.dispose();
//                                break;
//                            
//                        }
//                        
//                    } catch (Exception e) {
//                        ToastBar.showErrorMessage("error in encrypted contents, please contact us to fix this.", 10000);
//                    }
//                } else {
//                    ToastBar.showErrorMessage("error in encrypted contents, please contact us to fix this.", 10000);
//                }
//            }
//            
//            @Override
//            public void scanCanceled() {
//                System.out.println("cancelled");
//            }
//            
//            @Override
//            public void scanError(int errorCode, String message) {
//                System.out.println("err " + message);
//            }
//        });
////        } else {
////            CodeScanner.getInstance().scanQRCode(new com.codename1.codescan.ScanResult() {
////                public void scanCompleted(String contents, String formatName, byte[] rawBytes) {
////                    String decryptID = api.decryptID(contents);
////                    if (!decryptID.equals("faild")) {
////                        try {
////                            String id_order = StringUtil.replaceAll(decryptID, " ", "");
////                            InfiniteProgress prog = new InfiniteProgress();
////                            Dialog dlg = prog.showInifiniteBlocking();
////                            String getStatusOrder = api.isOrderForGym(id_order);
////
////                            switch (getStatusOrder) {
////                                case "pending":
////                                    dlg.dispose();
////                                    new erorr(res, "Required Step", "This order is in pending\ndo you want to accept it and continue?", "ok", e -> {
////                                        Map<String, Object> map = api.getGymOrder(id_order);
////                                        new club_qr_first(res, id_order, $(map.get("name")), $(map.get("total_price")) + " JOD", $(map.get("subscribe_type")),  $(map.get("date_start")),  $(map.get("date_end")), $(map.get("pay_method"))).show();
////                                    }).show();
////                                    break;
////                                case "accepted":
////                                    Map<String, Object> map = api.getGymOrder(id_order);
////                                    dlg.dispose();
////                                    new club_qr_first(res, id_order, $(map.get("name")), $(map.get("total_price")) + " JOD", $(map.get("subscribe_type")),  $(map.get("date_start")),  $(map.get("date_end")), $(map.get("pay_method"))).show();
////
////                                    break;
////                                case "blocked":
////                                    dlg.dispose();
////                                    new erorr_msg(res, "WARNING!!", "This user was blocked from you, you should unblock and then tell customer to open a new order.", "ok", null).show();
////                                    break;
////                                case "rejected":
////                                    dlg.dispose();
////                                    new erorr_msg(res, "WARNING!!", "This order is rejected\nplease tell customer to open a new order.", "ok", null).show();
////                                    break;
////                                case "ended":
////                                    Map<String, Object> map1 = api.getOrder(id_order);
////                                    String date_end = map1.get("date_end") + "";
////                                    Long end = Long.parseLong(date_end);
////                                    System.out.println("date_end" + date_end);
////                                    dlg.dispose();
////                                    if (new Date().getTime() < end) {
////                                        new erorr_msg(res, "Status: Active", "This order is still active for:\n\n" + dateFormat.format(new Date(end)), "ok", null).show();
////                                    } else {
////                                        new erorr_msg(res, "Status: End", "This order was ended.", "ok", null).show();
////                                    }
////                                    break;
////                                case "false":
////                                    dlg.dispose();
////                                    new erorr_msg(res, "User error", "This order is for another gym", "Ok", null).show();
////                                    break;
////                                default:
////                                    dlg.dispose();
////                                    break;
////
////                            }
////
////                        } catch (Exception e) {
////                            ToastBar.showErrorMessage("error in encrypted contents, please contact us to fix this.", 10000);
////                        }
////                    } else {
////                        ToastBar.showErrorMessage("error in encrypted contents, please contact us to fix this.", 10000);
////                    }
////                }
////
////                public void scanCanceled() {
////                    System.out.println("cancelled");
////                }
////
////                public void scanError(int errorCode, String message) {
////                    System.out.println("err " + message);
////
////                }
////            }
////            );
////        }
//    }
    
    private void scanIosDevice() {
        if (CodeScanner.isSupported()) {
            if (CodeScanner.getInstance() != null) {
                CodeScanner.getInstance().scanQRCode(new ScanResult() {
                    
                    public void scanCompleted(String contents, String formatName, byte[] rawBytes) {
                        String decryptID = api.decryptID(contents);
                        if (!decryptID.equals("faild")) {
                            try {
                                String id_order = StringUtil.replaceAll(decryptID, " ", "");
                                InfiniteProgress prog = new InfiniteProgress();
                                Dialog dlg = prog.showInifiniteBlocking();
                                String getStatusOrder = api.isOrderForGym(id_order);
                                
                                switch (getStatusOrder) {
                                    case "pending":
                                        dlg.dispose();
                                        new erorr(res, "Required Step", "This order is in pending\ndo you want to accept it and continue?", "ok", e -> {
                                            Map<String, Object> map = api.getGymOrder(id_order);
                                            new club_qr_first(res, id_order, $(map.get("name")), $(map.get("total_price")) + " JOD", $(map.get("subscribe_type")), $(map.get("date_start")), $(map.get("date_end")), $(map.get("pay_method"))).show();
                                        }).show();
                                        break;
                                    case "accepted":
                                        Map<String, Object> map = api.getGymOrder(id_order);
                                        dlg.dispose();
                                        new club_qr_first(res, id_order, $(map.get("name")), $(map.get("total_price")) + " JOD", $(map.get("subscribe_type")), $(map.get("date_start")), $(map.get("date_end")), $(map.get("pay_method"))).show();
                                        
                                        break;
                                    case "blocked":
                                        dlg.dispose();
                                        new erorr_msg(res, "WARNING!!", "This user was blocked from you, you should unblock and then tell customer to open a new order.", "ok", null).show();
                                        break;
                                    case "rejected":
                                        dlg.dispose();
                                        new erorr_msg(res, "WARNING!!", "This order is rejected\nplease tell customer to open a new order.", "ok", null).show();
                                        break;
                                    case "ended":
                                        Map<String, Object> map1 = api.getOrder(id_order);
                                        String date_end = map1.get("date_end") + "";
                                        Long end = Long.parseLong(date_end);
                                        System.out.println("date_end" + date_end);
                                        dlg.dispose();
                                        if (new Date().getTime() < end) {
                                            new erorr_msg(res, "Status: Active", "This order is still active for:\n\n" + dateFormat.format(new Date(end)), "ok", null).show();
                                        } else {
                                            new erorr_msg(res, "Status: End", "This order was ended.", "ok", null).show();
                                        }
                                        break;
                                    case "false":
                                        dlg.dispose();
                                        new erorr_msg(res, "User error", "This order is for another gym", "Ok", null).show();
                                        break;
                                    default:
                                        dlg.dispose();
                                        break;
                                    
                                }
                                
                            } catch (Exception e) {
                                ToastBar.showErrorMessage("error in encrypted contents, please contact us to fix this.", 10000);
                            }
                        } else {
                            ToastBar.showErrorMessage("error in encrypted contents, please contact us to fix this.", 10000);
                        }
                    }
                    
                    public void scanCanceled() {
//                        Dialog.show("Cancelled", "Scan Cancelled", "OK", null);
                    }
                    
                    public void scanError(int errorCode, String message) {
//                        Dialog.show("Error", message, "OK", null);
                    }
                });
                
            } else {
//                Dialog.show("Wearing", "CodeScanner.getInstance() == null", "OK", null);
            }
        } else {
//            Dialog.show("Not Supported", "QR Code Scanning is not available on this device", "OK", null);
        }
    }
    
    public void scanQrCode() {
        if (BaseForm.isAndroid()) {
//            scanAndroidDevice();
        } else {
            scanIosDevice();
        }
    }
    
    private String $(Object get) {
        return get + "";
    }
    
    private void setupSearchBar() {
        tf_search.addDataChangedListener(new DataChangedListener() {
            @Override
            public void dataChanged(int type, int index) {
                String search = tf_search.getText();
                
                int tab_index = tabs.getSelectedIndex();
                Map<String, Object> currentListing_new = getCurrentListing();
                switch (tab_index) {
                    case 0:
                        Container pending = (Container) ((Container) tabs.getComponentAt(0)).getComponentAt(tab_index);
                        List<Map<String, Object>> pending_list_new = (List<Map<String, Object>>) currentListing_new.get("pending");
                        if (search.length() > 0) {
                            List<Map<String, Object>> filiterNameList_new = filiterNameList(search, pending_list_new);
                            pending.removeAll();
                            pending.revalidate();
                            pending.setLayout(new BorderLayout());
                            pending.setScrollableY(false);
                            pending.add(CENTER, getPendingContainer(filiterNameList_new));
                        } else {
                            pending.removeAll();
                            pending.revalidate();
                            pending.setLayout(new BorderLayout());
                            pending.setScrollableY(false);
                            pending.add(CENTER, getPendingContainer(pending_list_new));
                        }
                        pending.revalidate();
                        break;
                    case 1:
                        Container accepted = (Container) ((Container) tabs.getComponentAt(0)).getComponentAt(tab_index);
                        List<Map<String, Object>> accepted_list_new = (List<Map<String, Object>>) currentListing_new.get("accepted");
                        accepted.removeAll();
                        accepted.revalidate();
                        accepted.setLayout(new BorderLayout());
                        accepted.setScrollableY(false);
                        if (search.length() > 0) {
                            List<Map<String, Object>> filiterNameList_accepted_new = filiterNameList(search, accepted_list_new);
                            accepted.add(CENTER, getAcceptedContainer(filiterNameList_accepted_new));
                        } else {
                            accepted.add(CENTER, getAcceptedContainer(accepted_list_new));
                        }
                        accepted.revalidate();
                        break;
                    case 2:
                        Container blocked = (Container) ((Container) tabs.getComponentAt(0)).getComponentAt(tab_index);
                        List<Map<String, Object>> blocked_list_new = (List<Map<String, Object>>) currentListing_new.get("blocked");
                        blocked.removeAll();
                        blocked.revalidate();
                        blocked.setLayout(new BorderLayout());
                        blocked.setScrollableY(false);
                        if (search.length() > 0) {
                            List<Map<String, Object>> filiterNameList_blocked_new = filiterNameList(search, blocked_list_new);
                            blocked.add(CENTER, getBlockedContainer(filiterNameList_blocked_new));
                        } else {
                            blocked.add(CENTER, getBlockedContainer(blocked_list_new));
                        }
                        blocked.revalidate();
                        break;
                    case 3:
                        Container ended = (Container) ((Container) tabs.getComponentAt(0)).getComponentAt(tab_index);
                        List<Map<String, Object>> ended_list_new = (List<Map<String, Object>>) currentListing_new.get("ended");
                        ended.removeAll();
                        ended.revalidate();
                        ended.setLayout(new BorderLayout());
                        ended.setScrollableY(false);
                        if (search.length() > 0) {
                            List<Map<String, Object>> filiterNameList_ended_new = filiterNameList(search, ended_list_new);
                            ended.add(CENTER, getEndedContainer(filiterNameList_ended_new));
                        } else {
                            ended.add(CENTER, getEndedContainer(ended_list_new));
                        }
                        ended.revalidate();
                        break;
                }
                
            }
            
        });
    }
    
    private List<Map<String, Object>> filiterNameList(String value, List<Map<String, Object>> pending_list_new) {
        List<Map<String, Object>> filiterNameList = new ArrayList<>();
        String value_filter = StringUtil.replaceAll(value, " ", "").toLowerCase();
        for (Map<String, Object> obj : pending_list_new) {
            String name = StringUtil.replaceAll(obj.get("name").toString(), " ", "").toLowerCase();
            if (name.contains(value_filter)) {
                filiterNameList.add(obj);
            }
        }
        return filiterNameList;
    }

//    private void test() {
//        new club_qr_first(res, "1051", "name", "12 JOD", "Weekly Subscribtion", "21 / 12 / 2019", "29 / 12 / 2019", "offline").show();
//
//    }
}
