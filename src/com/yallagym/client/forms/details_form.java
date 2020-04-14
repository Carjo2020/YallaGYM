package com.yallagym.client.forms;

import com.cn2.util.cn1String;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.Preferences;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.CN;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.codename1.util.StringUtil;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import com.yallagym.client.dialogs.erorr_msg;
import com.yallagym.client.layouts.Correct_Msg;
import com.yallagym.client.layouts.gym_image;
import java.util.Date;
import java.util.Map;

public class details_form extends BaseForm {

    Resources res;
    APIs api = new APIs();
    int index = 1;
    int list_size = 0;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Form current;
    Form frm;
    String id_gym;
//    String[] urls;
    Image[] imgs;
    Image first_img;
    Dialog dlg;
    protected com.codename1.ui.Label lbl_name = new com.codename1.ui.Label();
    SpanLabel sb_description = new SpanLabel();
    protected com.codename1.components.InfiniteProgress Infinite_Progress = new com.codename1.components.InfiniteProgress();
    Map<String, Object> item = null;

    public details_form() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public details_form(com.codename1.ui.util.Resources res) {
        checkLanguage(res);
    }

    public details_form(com.codename1.ui.util.Resources res, Form frm, String id_gym, String type) {
        System.out.println("id_gym:" + id_gym);
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setTitle("Club Information");
        addComponent(BorderLayout.centerAbsolute(Infinite_Progress));
        this.res = res;
        current = this;
        this.frm = frm;
        this.id_gym = id_gym;
        this.getToolbar().setTitleCentered(true);
        installBackIcon(frm);
        installBackCommand(frm);
        this.setScrollableY(false);
        this.setScrollVisible(false);
        gui_Container_1.setScrollableY(true);
//        gui_Container_4.setScrollableY(false);
        gui_Container_6.setScrollableY(false);
        gui_Container_6.setVisible(false);

//        new UITimer(() -> {
//            InfiniteProgress prog = new InfiniteProgress();
//            dlg = prog.showInfiniteBlocking();
        CN.callSerially(() -> {
            gui_Container_1.setFocusable(true);
            gui_Container_1.setScrollableY(true);
        });
        gui_Con_Image_View.setVisible(false);

//        }).schedule(50, false, current);
//        }).schedule(150, false, );
        new UITimer(() -> {
            item = api.getGymAllInfo(res, id_gym);
            first_img = api.getFirstGymImg(res, id_gym);
            CN.callSerially(() -> {
        
                if (first_img != null) {
                    gui_Con_Image_View.getAllStyles().setBgImage(first_img);
                    new UITimer(() -> {
                        imgs = api.getGymImages(res, id_gym);
                        if (imgs.length > 1) {
                            new UITimer(() -> {
                                if (index < imgs.length) {
                                    gui_Con_Image_View.getAllStyles().setBgImage(imgs[index]);
                                    gui_Con_Image_View.revalidate();
                                    index++;
                                } else {
                                    index = 0;
                                    gui_Con_Image_View.getAllStyles().setBgImage(imgs[index]);
                                    gui_Con_Image_View.revalidate();
                                    index++;
                                }
                                gui_Con_Image_View.revalidate();
                            }).schedule(5000, true, this);
                        }
                    }).schedule(5000, false, this);
                } else {
                            System.out.println("first_img:" + first_img);
                    gui_Con_Image_View.add(BorderLayout.CENTER, new gym_image(res, item.get("name").toString()));
                    this.revalidate();
                }

            });

            checkLanguage(res);
            setValues(id_gym, type);
            gui_Container_1.setScrollableY(true);
            gui_Container_1.setScrollVisible(false);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            gui_date_picker.setFormatter(dateFormat);
            gui_date_picker.setDate(new Date());
            gui_date_picker.setUseLightweightPopup(true);
            int dimension = gui_date_picker.getPreferredH() / 3;
            gui_date_picker.setIcon(res.getImage("ic_datePiker.png").scaled(dimension, dimension));
            Date now = new Date();

            try {
                gui_date_picker.setStartDate(now);
                long one_year = (1000l * 60l * 60l * 24l * 365l);
                gui_date_picker.setEndDate(new Date(now.getTime() + one_year));
            } catch (Exception e) {
            }

            new ButtonGroup(gui_RB_1_DAYS, gui_RB_7_DAYS, gui_RB_30_DAYS);
//            gui_Infinite_Progress.setVisible(false);
            gui_Container_1.setVisible(true);
            gui_Con_Image_View.setVisible(true);

            System.out.println(System.currentTimeMillis());
            Infinite_Progress.setVisible(false);
            gui_Container_6.setVisible(true);
            System.err.println("run");
            gui_date_picker.setGap(20);

            sb_description.getAllStyles().setAlignment(CENTER);
//            gui_Container.setPreferredH(sb.getPreferredH());
//            System.out.println("sb.getPreferredH(): " + sb.getPreferredH());
//            System.out.println("gui_Container.getPreferredH(): " + gui_Container.getPreferredH());
            this.revalidate();
        }).schedule(1000, false, current);

//        
//        System.out.println("gui_lbl_description.getRows():"+gui_lbl_description.getRows());
//           System.out.println("gui_lbl_description.getLines():"+gui_lbl_description.getPreferredH());
//           gui_lbl_description.setActAsLabel(true);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Con_Image_View = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_address = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.spinner.Picker gui_date_picker = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    protected com.codename1.ui.RadioButton gui_RB_1_DAYS = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_RB_7_DAYS = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_RB_30_DAYS = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.Button gui_btn_book = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_5 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_price = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Club Information");
        setName("details_form");
        gui_Container_6.setPreferredSizeStr("inherit 32.804234mm");
                gui_Container_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_6.setName("Container_6");
        addComponent(gui_Container_6);
        gui_Con_Image_View.setPreferredSizeStr("67.72487mm 35.449738mm");
                gui_Con_Image_View.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Image_View.setInlineAllStyles("bgImage:null;");
        gui_Con_Image_View.setName("Con_Image_View");
        gui_Container_1.setPreferredSizeStr("inherit 63.492065mm");
        gui_Container_1.setUIID("Gray_Con");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_6.addComponent(gui_Con_Image_View);
        gui_Container_6.addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("inherit 5.820106mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Label_5.setPreferredSizeStr("71.69312mm 5.291005mm");
        gui_Label_5.setText("Choose the start date:");
        gui_Label_5.setUIID("Details_Lbls");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setName("Label_5");
        gui_Container_3.setPreferredSizeStr("50.79365mm 6.0846562mm");
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_4.setPreferredSizeStr("74.07407mm 44.179893mm");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Container_1.addComponent(gui_Container_2);
        gui_Label_3.setPreferredSizeStr("13.756614mm 10.58201mm");
        gui_Label_3.setText("Address:");
        gui_Label_3.setUIID("Details_Lbls");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setName("Label_3");
        gui_lbl_address.setPreferredSizeStr("48.67725mm 10.31746mm");
        gui_lbl_address.setText("Amman, Sweileh");
        gui_lbl_address.setUIID("Detalis_Sb_green");
                gui_lbl_address.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_address.setName("lbl_address");
        gui_Container_2.addComponent(gui_Label_3);
        gui_Container_2.addComponent(gui_lbl_address);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "5.9604645E-8mm auto 0.0mm -3.5762787E-7mm").setReferenceComponents(gui_Label_3, "-1 -1 -1 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_address.getParent().getLayout()).setInsets(gui_lbl_address, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_address, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_address, "0.0 0.0 0.0 1.0");
        gui_Container_1.addComponent(gui_Label_5);
        gui_Container_1.addComponent(gui_Container_3);
        gui_date_picker.setPreferredSizeStr("54.761906mm 10.8465605mm");
        gui_date_picker.setText("...");
        gui_date_picker.setUIID("datePicker");
                gui_date_picker.setInlineStylesTheme(resourceObjectInstance);
        gui_date_picker.setName("date_picker");
        gui_date_picker.setType(1);
        gui_Container_3.addComponent(gui_date_picker);
        ((com.codename1.ui.layouts.LayeredLayout)gui_date_picker.getParent().getLayout()).setInsets(gui_date_picker, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_date_picker, "-1 -1 -1 -1").setReferencePositions(gui_date_picker, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_Label_6.setPreferredSizeStr("71.69312mm inherit");
        gui_Label_6.setText("Choose your reservation type:");
        gui_Label_6.setUIID("Details_Lbls");
                gui_Label_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_6.setName("Label_6");
        gui_RB_1_DAYS.setPreferredSizeStr("35.185184mm 4.2328043mm");
        gui_RB_1_DAYS.setText("       Booking for a day");
        gui_RB_1_DAYS.setUIID("Detalis_Sb_green");
                gui_RB_1_DAYS.setInlineStylesTheme(resourceObjectInstance);
        gui_RB_1_DAYS.setName("RB_1_DAYS");
        gui_RB_7_DAYS.setPreferredSizeStr("34.920635mm 4.7619047mm");
        gui_RB_7_DAYS.setText("       Booking for a week");
        gui_RB_7_DAYS.setUIID("Detalis_Sb_green");
                gui_RB_7_DAYS.setInlineStylesTheme(resourceObjectInstance);
        gui_RB_7_DAYS.setName("RB_7_DAYS");
        gui_RB_30_DAYS.setPreferredSizeStr("35.185184mm 4.4973545mm");
        gui_RB_30_DAYS.setText("       Booking for a month");
        gui_RB_30_DAYS.setUIID("Detalis_Sb_green");
                gui_RB_30_DAYS.setInlineStylesTheme(resourceObjectInstance);
        gui_RB_30_DAYS.setName("RB_30_DAYS");
        gui_btn_book.setPreferredSizeStr("35.185184mm 7.4074073mm");
        gui_btn_book.setText("Book now");
        gui_btn_book.setUIID("btn_get_yellow");
                gui_btn_book.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_book.setName("btn_book");
        gui_Container_5.setPreferredSizeStr("64.55026mm 5.820106mm");
                gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setName("Container_5");
        gui_Container_4.addComponent(gui_Label_6);
        gui_Container_4.addComponent(gui_RB_1_DAYS);
        gui_Container_4.addComponent(gui_RB_7_DAYS);
        gui_Container_4.addComponent(gui_RB_30_DAYS);
        gui_Container_4.addComponent(gui_btn_book);
        gui_Container_4.addComponent(gui_Container_5);
        gui_Label_4.setPreferredSizeStr("23.809525mm 10.58201mm");
        gui_Label_4.setText("Total price:");
        gui_Label_4.setUIID("Details_Lbls");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setName("Label_4");
        gui_lbl_price.setPreferredSizeStr("38.62434mm 10.31746mm");
        gui_lbl_price.setText("35 JOD");
        gui_lbl_price.setUIID("Detalis_Sb_green");
                gui_lbl_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price.setName("lbl_price");
        gui_Container_5.addComponent(gui_Label_4);
        gui_Container_5.addComponent(gui_lbl_price);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "5.9604645E-8mm auto 0.0mm -3.5762787E-7mm").setReferenceComponents(gui_Label_4, "-1 -1 -1 -1").setReferencePositions(gui_Label_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_price.getParent().getLayout()).setInsets(gui_lbl_price, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_price, "-1 -1 -1 0 ").setReferencePositions(gui_lbl_price, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_6.getParent().getLayout()).setInsets(gui_Label_6, "-2.3841858E-7mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_6, "-1 -1 -1 -1").setReferencePositions(gui_Label_6, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_RB_1_DAYS.getParent().getLayout()).setInsets(gui_RB_1_DAYS, "2.3841858E-7mm auto auto 2.910053mm").setReferenceComponents(gui_RB_1_DAYS, "0 -1 -1 -1").setReferencePositions(gui_RB_1_DAYS, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_RB_7_DAYS.getParent().getLayout()).setInsets(gui_RB_7_DAYS, "0.0mm auto auto 2.910053mm").setReferenceComponents(gui_RB_7_DAYS, "1 -1 -1 -1").setReferencePositions(gui_RB_7_DAYS, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_RB_30_DAYS.getParent().getLayout()).setInsets(gui_RB_30_DAYS, "0.0mm auto auto 2.910053mm").setReferenceComponents(gui_RB_30_DAYS, "2 -1 -1 -1").setReferencePositions(gui_RB_30_DAYS, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_book.getParent().getLayout()).setInsets(gui_btn_book, "1.8518518mm auto auto auto").setReferenceComponents(gui_btn_book, "5 -1 -1 -1").setReferencePositions(gui_btn_book, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredWidthMM((float)64.55026);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getLayout()).setPreferredHeightMM((float)5.820106);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_5, "3 -1 -1 -1").setReferencePositions(gui_Container_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)64.55026);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)5.820106);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredWidthMM((float)50.79365);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_3.getLayout()).setPreferredHeightMM((float)6.0846562);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredWidthMM((float)57.93651);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_4.getLayout()).setPreferredHeightMM((float)44.179893);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Image_View.getLayout()).setPreferredWidthMM((float)64.28571);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Image_View.getLayout()).setPreferredHeightMM((float)35.449738);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Image_View.getParent().getLayout()).setInsets(gui_Con_Image_View, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Image_View, "-1 -1 -1 -1").setReferencePositions(gui_Con_Image_View, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "0 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getLayout()).setPreferredWidthMM((float)64.28571);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getLayout()).setPreferredHeightMM((float)32.804234);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_6.getParent().getLayout()).setInsets(gui_Container_6, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_6, "-1 -1 -1 -1").setReferencePositions(gui_Container_6, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private void setValues(String id_gym, String type) {

        if (item != null) {
            String id = item.get("id") + "";
            String name = item.get("name") + "";
            String description = item.get("description") + "";
            String price_d = (Integer.valueOf(item.get("price_d").toString()) + Integer.valueOf(item.get("price_d_fees").toString())) + " JD";
            String price_w = (Integer.valueOf(item.get("price_w").toString()) + Integer.valueOf(item.get("price_w_fees").toString())) + " JD";
            String price_m = (Integer.valueOf(item.get("price_m").toString()) + Integer.valueOf(item.get("price_m_fees").toString())) + " JD";

            String rate = item.get("rate") + "";
            String address = item.get("address") + "";
            String work_time = item.get("work_time") + "";
//        String image = item.get("images") + "";
//        String images[] = cn1String.splite(image, ",");

            String coordinates = item.get("coordinates") + "";
            String[] adressSub = cn1String.splite(coordinates, ",");
            double lat = Double.valueOf(adressSub[0]);
            double lon = Double.valueOf(adressSub[1]);
//            gui_lbl_name.setText(name);
//            gui_lbl_description.setText(description);
            gui_lbl_address.setText(address);

            if (item.get("price_d").toString().equals("0")) {
                gui_RB_1_DAYS.setVisible(false);
            }
            if (item.get("price_w").toString().equals("0")) {
                gui_RB_7_DAYS.setVisible(false);
            }
            if (item.get("price_m").toString().equals("0")) {
                gui_RB_30_DAYS.setVisible(false);
            }

//        pay_dlg.addActionListener(e -> {
//        });
//
//        pay_dlg.setPreferredH(cn1Display.getScaledMax(12));
//        pay_dlg.getAllStyles().setMargin(30, 0, 20, 20);
            if (type.equals("price_d")) {
                gui_RB_1_DAYS.setSelected(true);
                gui_lbl_price.setText(price_d);
                Type_Seb = "price_d";
            } else if (type.equals("price_w")) {
                gui_RB_7_DAYS.setSelected(true);
                gui_lbl_price.setText(price_w);
                Type_Seb = "price_w";
            } else if (type.equals("price_m")) {
                gui_RB_30_DAYS.setSelected(true);
                gui_lbl_price.setText(price_m);
                Type_Seb = "price_m";
            }
            gui_RB_1_DAYS.addActionListener(e -> {
                gui_lbl_price.setText(price_d);
                Type_Seb = "price_d";
            });
            gui_RB_7_DAYS.addActionListener(e -> {
                gui_lbl_price.setText(price_w);
                Type_Seb = "price_w";
            });
            gui_RB_30_DAYS.addActionListener(e -> {
                gui_lbl_price.setText(price_m);
                Type_Seb = "price_m";
            });
            gui_date_picker.addActionListener(e -> {
                if (gui_date_picker.getDate().getTime() < new Date().getTime()) {
                    ToastBar.showErrorMessage("you can't choose time before current time");
                    gui_date_picker.setDate(new Date());
                }
            });

//            CN.callSerially(() -> {
//            new Thread() {
//                public void run() {
////                         InfiniteProgress prog = new InfiniteProgress();
////            Dialog dlg = prog.showInfiniteBlocking();
//            CN.invokeAndBlock(() -> {
//                Image[] get_urls = api.getGymImages(res, id);
//            setImages();
//            });
////                    dlg.dispose();
//                }
//            }.start();
            gui_btn_book.addActionListener(e -> {
//                boolean checkTime = checkIsTime();
//                System.out.println("checkTime: " + checkTime);
//                if (checkTime) {
                int amount = Integer.valueOf(StringUtil.replaceFirst(gui_lbl_price.getText(), " JD", ""));
                if (Type_Seb.equals("price_d")) {
                    InfiniteProgress prog = new InfiniteProgress();
                    Dialog dlg = prog.showInfiniteBlocking();
                    boolean isHaveAnotherOrder = api.checkHaveOrder(gui_date_picker.getDate().getTime() + "");
                    dlg.dispose();
                    if (isHaveAnotherOrder) {
                        new erorr_msg(res, "Warning", "You have already ordered in this date", "Ok", null).show();
                    } else {
//                            new pay_dialog(res, id_gym, Type_Seb, gui_date_picker.getDate().getTime() + "", amount + "").show(cn1Display.getHeight() - cn1Display.getHeight() / 3, 0, 0, 0);
                        newOfflineOrder(id_gym, type, gui_date_picker.getDate().getTime() + "");
                    }
                } else {
//                        new pay_dialog(res, id_gym, Type_Seb, gui_date_picker.getDate().getTime() + "", amount + "").show(cn1Display.getHeight() - cn1Display.getHeight() / 3, 0, 0, 0);
                    newOfflineOrder(id_gym, type, gui_date_picker.getDate().getTime() + "");
                }
//                } else {
//                    ToastBar.showErrorMessage("Error, can't book start date before now date.");
//                }
            });
        } else {
            frm.show();
            new erorr_msg(res, "Unavailable", "Sorry, this gym is not available until now", "Ok", e -> {
                new list_form(res).show();
            }, true).show();
        }

    }
    String Type_Seb = "";
    int i = 0;

    private void checkLanguage(Resources res) {
        String name = item.get("name") + "";
        String description = item.get("description") + "";
        addNameAndDescruption(name, description);
        if (com.yallagym.BaseForm.isArabic()) {
            initArGuiBuilderComponents(res);
        } else {
            initGuiBuilderComponents(res);
        }
        gui_Container_1.setPreferredH(gui_Container_1.getPreferredH() + sb_description.getPreferredH());
    }

    private void initArGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("Club Information");
        setName("details_form");
        gui_Container_6.setPreferredSizeStr("inherit 32.804234mm");
        gui_Container_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_6.setName("Container_6");
        addComponent(gui_Container_6);
        gui_Con_Image_View.setPreferredSizeStr("67.72487mm 35.449738mm");
        gui_Con_Image_View.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Image_View.setInlineAllStyles("bgImage:null;");
        gui_Con_Image_View.setName("Con_Image_View");
        gui_Container_1.setPreferredSizeStr("inherit 63.492065mm");
        gui_Container_1.setUIID("Gray_Con");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container_6.addComponent(gui_Con_Image_View);
        gui_Container_6.addComponent(gui_Container_1);
        gui_Container_2.setPreferredSizeStr("45.238094mm 5.820106mm");
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_Label_5.setPreferredSizeStr("71.69312mm 5.291005mm");
        gui_Label_5.setText("Choose the start date:");
        gui_Label_5.setUIID("Details_Lbls");
        gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setInlineAllStyles("alignment:right;");
        gui_Label_5.setName("Label_5");
        gui_Container_3.setPreferredSizeStr("50.79365mm 6.0846562mm");
        gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_Container_4.setPreferredSizeStr("74.07407mm 44.179893mm");
        gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Container_1.addComponent(gui_Container_2);
        gui_Label_3.setPreferredSizeStr("13.756614mm 10.58201mm");
        gui_Label_3.setText("Address:");
        gui_Label_3.setUIID("Details_Lbls");
        gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setInlineAllStyles("alignment:right;");
        gui_Label_3.setName("Label_3");
        gui_lbl_address.setPreferredSizeStr("16.137566mm 10.31746mm");
        gui_lbl_address.setText("Amman, Sweileh");
        gui_lbl_address.setUIID("Detalis_Sb_green");
        gui_lbl_address.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_address.setInlineAllStyles("alignment:right;");
        gui_lbl_address.setName("lbl_address");
        gui_Container_2.addComponent(gui_Label_3);
        gui_Container_2.addComponent(gui_lbl_address);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "5.9604645E-8mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Label_3, "-1 -1 -1 -1").setReferencePositions(gui_Label_3, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_address.getParent().getLayout()).setInsets(gui_lbl_address, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_address, "-1 0 -1 -1").setReferencePositions(gui_lbl_address, "0.0 1.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Label_5);
        gui_Container_1.addComponent(gui_Container_3);
        gui_date_picker.setPreferredSizeStr("54.761906mm 10.8465605mm");
        gui_date_picker.setText("...");
        gui_date_picker.setUIID("datePicker");
        gui_date_picker.setInlineStylesTheme(resourceObjectInstance);
        gui_date_picker.setName("date_picker");
        gui_date_picker.setType(1);
        gui_Container_3.addComponent(gui_date_picker);
        ((com.codename1.ui.layouts.LayeredLayout) gui_date_picker.getParent().getLayout()).setInsets(gui_date_picker, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_date_picker, "-1 -1 -1 -1").setReferencePositions(gui_date_picker, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_Container_4);
        gui_Label_6.setPreferredSizeStr("71.69312mm inherit");
        gui_Label_6.setText("Choose your reservation type:");
        gui_Label_6.setUIID("Details_Lbls");
        gui_Label_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_6.setInlineAllStyles("alignment:right;");
        gui_Label_6.setName("Label_6");
        gui_RB_1_DAYS.setPreferredSizeStr("35.185184mm 4.2328043mm");
        gui_RB_1_DAYS.setRTL(true);
        gui_RB_1_DAYS.setText("Booking for a day");
        gui_RB_1_DAYS.setUIID("Detalis_Sb_green");
        gui_RB_1_DAYS.setInlineStylesTheme(resourceObjectInstance);
        gui_RB_1_DAYS.setName("RB_1_DAYS");
        gui_RB_1_DAYS.setGap(15);
        gui_RB_7_DAYS.setPreferredSizeStr("34.920635mm 4.7619047mm");
        gui_RB_7_DAYS.setRTL(true);
        gui_RB_7_DAYS.setText("Booking for a week");
        gui_RB_7_DAYS.setUIID("Detalis_Sb_green");
        gui_RB_7_DAYS.setInlineStylesTheme(resourceObjectInstance);
        gui_RB_7_DAYS.setName("RB_7_DAYS");
        gui_RB_7_DAYS.setGap(15);
        gui_RB_30_DAYS.setPreferredSizeStr("35.185184mm 4.4973545mm");
        gui_RB_30_DAYS.setRTL(true);
        gui_RB_30_DAYS.setText("Booking for a month");
        gui_RB_30_DAYS.setUIID("Detalis_Sb_green");
        gui_RB_30_DAYS.setInlineStylesTheme(resourceObjectInstance);
        gui_RB_30_DAYS.setName("RB_30_DAYS");
        gui_RB_30_DAYS.setGap(15);
        gui_btn_book.setPreferredSizeStr("35.185184mm 7.4074073mm");
        gui_btn_book.setText("Book now");
        gui_btn_book.setUIID("btn_get_yellow");
        gui_btn_book.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_book.setName("btn_book");
        gui_Container_5.setPreferredSizeStr("64.55026mm 5.820106mm");
        gui_Container_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_5.setName("Container_5");
        gui_Container_4.addComponent(gui_Label_6);
        gui_Container_4.addComponent(gui_RB_1_DAYS);
        gui_Container_4.addComponent(gui_RB_7_DAYS);
        gui_Container_4.addComponent(gui_RB_30_DAYS);
        gui_Container_4.addComponent(gui_btn_book);
        gui_Container_4.addComponent(gui_Container_5);
        gui_Label_4.setPreferredSizeStr("23.809525mm 10.58201mm");
        gui_Label_4.setText("Total price:");
        gui_Label_4.setUIID("Details_Lbls");
        gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setInlineAllStyles("alignment:right;");
        gui_Label_4.setName("Label_4");
        gui_lbl_price.setPreferredSizeStr("29.36508mm 10.31746mm");
        gui_lbl_price.setText("35 JOD");
        gui_lbl_price.setUIID("Detalis_Sb_green");
        gui_lbl_price.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_price.setInlineAllStyles("alignment:right;");
        gui_lbl_price.setName("lbl_price");
        gui_Container_5.addComponent(gui_Label_4);
        gui_Container_5.addComponent(gui_lbl_price);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "5.9604645E-8mm 0.0mm 0.0mm auto").setReferenceComponents(gui_Label_4, "-1 -1 -1 -1").setReferencePositions(gui_Label_4, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_lbl_price.getParent().getLayout()).setInsets(gui_lbl_price, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_lbl_price, "-1 0 -1 -1").setReferencePositions(gui_lbl_price, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_6.getParent().getLayout()).setInsets(gui_Label_6, "-2.3841858E-7mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_6, "-1 -1 -1 -1").setReferencePositions(gui_Label_6, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_RB_1_DAYS.getParent().getLayout()).setInsets(gui_RB_1_DAYS, "2.3841858E-7mm 3.0mm auto auto").setReferenceComponents(gui_RB_1_DAYS, "0 -1 -1 -1").setReferencePositions(gui_RB_1_DAYS, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_RB_7_DAYS.getParent().getLayout()).setInsets(gui_RB_7_DAYS, "0.0mm 3.0mm auto auto").setReferenceComponents(gui_RB_7_DAYS, "1 -1 -1 -1").setReferencePositions(gui_RB_7_DAYS, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_RB_30_DAYS.getParent().getLayout()).setInsets(gui_RB_30_DAYS, "0.0mm 3.0mm auto auto").setReferenceComponents(gui_RB_30_DAYS, "2 -1 -1 -1").setReferencePositions(gui_RB_30_DAYS, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_book.getParent().getLayout()).setInsets(gui_btn_book, "1.8518518mm auto auto auto").setReferenceComponents(gui_btn_book, "5 -1 -1 -1").setReferencePositions(gui_btn_book, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getLayout()).setPreferredWidthMM((float) 64.55026);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getLayout()).setPreferredHeightMM((float) 5.820106);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_5.getParent().getLayout()).setInsets(gui_Container_5, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_5, "3 -1 -1 -1").setReferencePositions(gui_Container_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredWidthMM((float) 45.238094);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_2.getLayout()).setPreferredHeightMM((float) 5.820106);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredWidthMM((float) 50.79365);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_3.getLayout()).setPreferredHeightMM((float) 6.0846562);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredWidthMM((float) 57.93651);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_4.getLayout()).setPreferredHeightMM((float) 44.179893);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Image_View.getLayout()).setPreferredWidthMM((float) 64.28571);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Image_View.getLayout()).setPreferredHeightMM((float) 35.449738);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Image_View.getParent().getLayout()).setInsets(gui_Con_Image_View, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Con_Image_View, "-1 -1 -1 -1").setReferencePositions(gui_Con_Image_View, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Container_1, "0 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_6.getLayout()).setPreferredWidthMM((float) 64.28571);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_6.getLayout()).setPreferredHeightMM((float) 32.804234);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_6.getParent().getLayout()).setInsets(gui_Container_6, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_6, "-1 -1 -1 -1").setReferencePositions(gui_Container_6, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void newOfflineOrder(String id_gym, String type, String dateStart) {
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        String username = Preferences.get("username", "null");
        String date_order = dateFormat.format(new Date());

        api.createOfflineOrder(username, StringUtil.replaceFirst(id_gym, ".0", ""), date_order, type, dateStart);
        dlg.dispose();
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
            }
        };
//        CN.getCurrentForm().setBackCommand(back);
//        this.setBackCommand(back);
        String msg = "";
        if (type.equals("price_d")) {
            msg = "Thank you for your submit, we will contact you within 5 min.";
        } else if (type.equals("price_w")) {
            msg = "Thank you for your submit, we will contact you within a few 24 hours.";
        } else {
            msg = "Thank you for your submit, we will contact you within a few 48 hours.";
        }
        Dialog dlg_correct_Msg = new Correct_Msg(res, "Sent successfully", msg, e -> {
            new client_orders(res, new list_form(res)).show();
        });
        dlg_correct_Msg.setDisposeWhenPointerOutOfBounds(false);
        dlg_correct_Msg.show();

    }

    private void addNameAndDescruption(String name, String description) {
        lbl_name.setPreferredSizeStr("69.31217mm 6.6137567mm");
        lbl_name.setText(name);
        lbl_name.setUIID("PersonalInfo_Lbl");
        lbl_name.setInlineStylesTheme(res);
        lbl_name.getAllStyles().setFgColor(0x3c4646);
        lbl_name.getAllStyles().setAlignment(CENTER);
        sb_description.setText(description);
        sb_description.getTextAllStyles().setAlignment(CENTER);
        gui_Container_1.addComponent(lbl_name);
        gui_Container_1.add(sb_description);
    }

    private String gethtml(String url) {
        return "<!DOCTYPE html> <html> <style> body { background-image: url('"
                + url
                + "'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%; } </style> <body> </body> </html>";
    }
}
