package com.yallagym.client.forms;

import com.cn2.lang.cn1Math;
import com.cn2.ui.cn1Display;
import com.cn2.ui.cn1Icons;
import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.io.Preferences;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.util.Resources;
import com.yallagym.APIs;
import com.yallagym.BaseForm;
import com.yallagym.client.dialogs.erorr;
import com.yallagym.client.layouts.Correct_Msg;
import com.yallagym.login.sms.Activation_Form_2;
import java.util.Date;
import javafx.scene.input.DataFormat;

public class user_info extends BaseForm {

    Resources res;
    String countries[] = {"Amman", "Zarqa", "Irbid", "Jerash", "Madaba", "Ajloun", "Balqa", "Mafraq", "Ma'an", "Karak", "Tafilah", "Aqaba"};
//    String ages[] = {"2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900"};
    APIs api = new APIs();
    boolean isFromSubmit;
    Form frm;

    public user_info() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public user_info(com.codename1.ui.util.Resources res) {
        checkLanguage(res);

    }

    public user_info(com.codename1.ui.util.Resources res, Form frm) {
        checkLanguage(res);
        installBackIcon(frm);
        installBackCommand(frm);
        this.res = res;
        installFixItems();
//        for (String s : ages) {
//            gui_CBox_Age.addItem(s);
//        }

//        gui_CBox_Age.setScrollVisible(false);
//        gui_CBox_Age.setScrollVisible(false);
        setValues(frm);
        gui_Container_1.setPreferredH(cn1Math.nextUp(cn1Display.getHeight() * 0.80));
    }

    public user_info(com.codename1.ui.util.Resources res, Form frm, boolean isFromSubmit) {
        checkLanguage(res);
        installBackIcon(frm);
        installBackCommand(frm);
        installFixItems();
        this.res = res;
        this.isFromSubmit = isFromSubmit;
        this.frm = frm;
        setValues(frm);
//        gui_Container_1.setPreferredH(cn1Math.nextUp(cn1Display.getHeight() * 0.80));
        gui_Container_1.setPreferredH(cn1Math.nextUp(cn1Display.getHeight() * 0.80));
    }
////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_TF_First_Name = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_TF_Last_Name = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_TF_Phone = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_TF_Username = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.ComboBox gui_CBox_Country = new com.codename1.ui.ComboBox();
    protected com.codename1.ui.ComboBox gui_CBox_Sex = new com.codename1.ui.ComboBox();
    protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Con_Picker = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_change_phone = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_save = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_change_phone.addActionListener(callback);
        gui_btn_save.addActionListener(callback);
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

            if(sourceComponent == gui_btn_change_phone) {
                onbtn_change_phoneActionEvent(ev);
            }
            if(sourceComponent == gui_btn_save) {
                onbtn_saveActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("");
        setName("user_info");
        gui_Container.setPreferredSizeStr("76.98413mm 130.15874mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("70.10582mm 134.12698mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Container.addComponent(gui_Container_1);
        gui_Label.setPreferredSizeStr("25.132275mm 4.7619047mm");
        gui_Label.setText("Date");
        gui_Label.setUIID("PersonalInfo_Lbl");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("16.402117mm inherit");
        gui_Label_1.setText("Name");
        gui_Label_1.setUIID("PersonalInfo_Lbl");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_TF_First_Name.setPreferredSizeStr("inherit 5.555556mm");
        gui_TF_First_Name.setHint("First Name");
                gui_TF_First_Name.setInlineStylesTheme(resourceObjectInstance);
        gui_TF_First_Name.setName("TF_First_Name");
        gui_TF_Last_Name.setPreferredSizeStr("27.248678mm 5.555556mm");
        gui_TF_Last_Name.setHint("Second Name");
                gui_TF_Last_Name.setInlineStylesTheme(resourceObjectInstance);
        gui_TF_Last_Name.setName("TF_Last_Name");
        gui_Label_2.setPreferredSizeStr("30.15873mm 7.4074073mm");
        gui_Label_2.setText("Phone");
        gui_Label_2.setUIID("PersonalInfo_Lbl");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_TF_Phone.setPreferredSizeStr("61.11111mm inherit");
        gui_TF_Phone.setHint("Phone Number");
                gui_TF_Phone.setInlineStylesTheme(resourceObjectInstance);
        gui_TF_Phone.setName("TF_Phone");
        gui_TF_Phone.setConstraint(com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.NUMERIC | com.codename1.ui.TextArea.PHONENUMBER);
        gui_Label_3.setPreferredSizeStr("21.428572mm inherit");
        gui_Label_3.setText("Username");
        gui_Label_3.setUIID("PersonalInfo_Lbl");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setName("Label_3");
        gui_TF_Username.setPreferredSizeStr("61.11111mm inherit");
        gui_TF_Username.setHint("Username");
                gui_TF_Username.setInlineStylesTheme(resourceObjectInstance);
        gui_TF_Username.setName("TF_Username");
        gui_TF_Username.setConstraint(com.codename1.ui.TextArea.EMAILADDR);
        gui_Label_4.setPreferredSizeStr("25.132275mm 9.259259mm");
        gui_Label_4.setText("City");
        gui_Label_4.setUIID("PersonalInfo_Lbl");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setName("Label_4");
        gui_CBox_Country.setPreferredSizeStr("32.27513mm 9.523809mm");
        gui_CBox_Country.setScrollVisible(true);
                gui_CBox_Country.setInlineStylesTheme(resourceObjectInstance);
        gui_CBox_Country.setName("CBox_Country");
        gui_CBox_Sex.setPreferredSizeStr("27.513227mm 8.994709mm");
        gui_CBox_Sex.setScrollVisible(true);
                gui_CBox_Sex.setInlineStylesTheme(resourceObjectInstance);
        gui_CBox_Sex.setName("CBox_Sex");
        gui_Label_5.setPreferredSizeStr("25.132275mm 8.465609mm");
        gui_Label_5.setText("Gender");
        gui_Label_5.setUIID("PersonalInfo_Lbl");
                gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setName("Label_5");
        gui_Con_Picker.setPreferredSizeStr("37.56614mm 9.523809mm");
                gui_Con_Picker.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Picker.setName("Con_Picker");
        gui_btn_change_phone.setPreferredSizeStr("14.550264mm 8.465609mm");
                gui_btn_change_phone.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_change_phone.setName("btn_change_phone");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_change_phone,"\ue254".charAt(0));
        gui_btn_save.setPreferredSizeStr("47.8836mm 10.05291mm");
        gui_btn_save.setText("Save");
        gui_btn_save.setUIID("btn_select");
                gui_btn_save.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_save.setName("btn_save");
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_TF_First_Name);
        gui_Container_1.addComponent(gui_TF_Last_Name);
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_TF_Phone);
        gui_Container_1.addComponent(gui_Label_3);
        gui_Container_1.addComponent(gui_TF_Username);
        gui_Container_1.addComponent(gui_Label_4);
        gui_Container_1.addComponent(gui_CBox_Country);
        gui_Container_1.addComponent(gui_CBox_Sex);
        gui_Container_1.addComponent(gui_Label_5);
        gui_Container_1.addComponent(gui_Con_Picker);
        gui_Container_1.addComponent(gui_btn_change_phone);
        gui_Container_1.addComponent(gui_btn_save);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "2.3809524mm auto auto 0.0mm").setReferenceComponents(gui_Label, "7 -1 -1 -1").setReferencePositions(gui_Label, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "6.0% auto auto 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_TF_First_Name.getParent().getLayout()).setInsets(gui_TF_First_Name, "0.0mm 50.0% auto 0.0mm").setReferenceComponents(gui_TF_First_Name, "1 -1 -1 -1").setReferencePositions(gui_TF_First_Name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_TF_Last_Name.getParent().getLayout()).setInsets(gui_TF_Last_Name, "0.0mm 0.26455027mm auto 0.0mm").setReferenceComponents(gui_TF_Last_Name, "1 -1 -1 2 ").setReferencePositions(gui_TF_Last_Name, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Label_2, "2 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_TF_Phone.getParent().getLayout()).setInsets(gui_TF_Phone, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_TF_Phone, "4 -1 -1 -1").setReferencePositions(gui_TF_Phone, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Label_3, "5 -1 -1 -1").setReferencePositions(gui_Label_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_TF_Username.getParent().getLayout()).setInsets(gui_TF_Username, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_TF_Username, "6 -1 -1 -1").setReferencePositions(gui_TF_Username, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_Label_4, "11 -1 -1 -1").setReferencePositions(gui_Label_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_CBox_Country.getParent().getLayout()).setInsets(gui_CBox_Country, "0.0mm -9.536743E-7mm auto 0.0mm").setReferenceComponents(gui_CBox_Country, "10 -1 -1 8 ").setReferencePositions(gui_CBox_Country, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_CBox_Sex.getParent().getLayout()).setInsets(gui_CBox_Sex, "0.0mm 0.0mm auto 0.0%").setReferenceComponents(gui_CBox_Sex, "12 -1 -1 11 ").setReferencePositions(gui_CBox_Sex, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "2.3841858E-7mm auto auto 0.0mm").setReferenceComponents(gui_Label_5, "12 -1 -1 -1").setReferencePositions(gui_Label_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Picker.getLayout()).setPreferredWidthMM((float)37.56614);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Picker.getLayout()).setPreferredHeightMM((float)9.523809);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Con_Picker.getParent().getLayout()).setInsets(gui_Con_Picker, "0.0mm 2.0mm auto 0.0mm").setReferenceComponents(gui_Con_Picker, "7 -1 -1 0 ").setReferencePositions(gui_Con_Picker, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_change_phone.getParent().getLayout()).setInsets(gui_btn_change_phone, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_btn_change_phone, "3 -1 -1 -1").setReferencePositions(gui_btn_change_phone, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_save.getParent().getLayout()).setInsets(gui_btn_save, "2.0mm auto auto auto").setReferenceComponents(gui_btn_save, "9 -1 -1 -1").setReferencePositions(gui_btn_save, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)71.164024);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)134.12698);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)59.52381);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)130.15874);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 1.9073486E-6mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!///-- DON'T EDIT ABOVE THIS LINE!!!  
    private void installFixItems() {
        this.setTitle("Personal Information");
        getToolbar().setTitleCentered(true);
        gui_CBox_Sex.addItem("male");
        gui_CBox_Sex.addItem("female");
        gui_CBox_Sex.setScrollVisible(false);
        gui_CBox_Sex.setScrollVisible(false);
        gui_CBox_Country.setScrollVisible(false);
        gui_CBox_Country.setScrollVisible(false);
        for (String s : countries) {
            gui_CBox_Country.addItem(s);
        }

        setHeightTextFields();

        this.setScrollable(false);
        gui_Container.setScrollableY(true);
        Date now = new Date();
        date = PickerComponent.createDate(now);
        date.getPicker().setFormatter(dateFormat);
        try {
            date.getPicker().setStartDate(dateFormat.parse("01/01/1935"));
            date.getPicker().setEndDate(now);
        } catch (Exception e) {
        }

//        date.setUIID("TextField");
        date.getPicker().setUseLightweightPopup(true);
        date.setPreferredSize(gui_Con_Picker.getPreferredSize());
        date.getPicker().setPreferredSize(gui_Con_Picker.getPreferredSize());
//        date.getPicker().setPreferredH(200);

        gui_Con_Picker.add(CENTER, date);
        gui_TF_Phone.setEnabled(false);
        gui_TF_Username.setEnabled(false);
    }
    PickerComponent date;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private void setValues(Form frm) {
        String first_name = Preferences.get("first_name", "null");
        String last_name = Preferences.get("last_name", "null");
        String phone = Preferences.get("phone", "null");
        String username = Preferences.get("username", "null");
        String sex = Preferences.get("type", "null");
        String age = Preferences.get("age", "null");
        String country = Preferences.get("address", "null");

        gui_TF_First_Name.setText(first_name);
        gui_TF_Last_Name.setText(last_name);
        gui_TF_Phone.setText(phone);
        gui_TF_Username.setText(username);

        int index1 = 0;
        if (sex.equals("male")) {
            index1 = 0;
        } else {
            index1 = 1;
        }
        int index2 = 0;
        try {
            //date.getPicker().setDate(dateFormat.parse());
//                System.out.println(dateFormat.format(dateFormat.parse(age)));
            date.getPicker().setDate(dateFormat.parse(age));
        } catch (ParseException ex) {
            Log.p(ex.getMessage());
        }
        int index3 = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].equals(country)) {
                index3 = i;
            }
        }

        gui_CBox_Sex.setSelectedIndex(index1);

        gui_CBox_Country.setSelectedIndex(index3);

    }

    public void onbtn_saveActionEvent(com.codename1.ui.events.ActionEvent ev) {
        String first_name = gui_TF_First_Name.getText();
        String last_name = gui_TF_Last_Name.getText();
        String phone = gui_TF_Phone.getText();
        String username = gui_TF_Username.getText();
        String type = gui_CBox_Sex.getSelectedItem() + "";
        String age = date.getPicker().getText();
        String address = gui_CBox_Country.getSelectedItem() + "";
        String password = Preferences.get("password", "null");
//        if (phone.equals(Preferences.get("phone", "null"))) {
        if (!first_name.contains(" ") && !last_name.contains(" ") && !username.contains(" ") && !phone.contains(" ")) {
            boolean checkChars = !checkIfThereChars(first_name) && !checkIfThereChars(last_name) && !checkIfThereChars(username) && !checkIfThereChars(phone);
            if (first_name.length() > 0 && checkChars) {
                if (last_name.length() > 0) {
                    if (phone.length() > 0) {
                        if (username.length() > 0) {
                            if (address.length() > 0) {
                                if (address.length() > 0) {
                                    if (address.length() > 0) {
                                        try {
                                            api.addUser(first_name, last_name, phone, age, type, address, username, password);
                                            Preferences.set("first_name", first_name);
                                            Preferences.set("last_name", last_name);
//                                    Preferences.set("phone", phone);
                                            Preferences.set("username", username);
                                            Preferences.set("type", type);
                                            Preferences.set("age", age);
                                            Preferences.set("address", address);
                                            new Correct_Msg(res, "Saved successfully", "Please make sure that your information is correct, because we will make a contact with you.", ee -> {

                                            }).show();
                                        } catch (Exception e) {
                                            ToastBar.showErrorMessage("There's something does not correct, please check your input and try again", 10000);
                                        }

                                    } else {

                                        ToastBar.showErrorMessage("Please select city");
                                    }
                                } else {
                                    ToastBar.showErrorMessage("Please select your birthday");
                                }
                            } else {
                                ToastBar.showErrorMessage("Please select gender");
                            }

                        } else {
                            ToastBar.showErrorMessage("Please enter a username!");
                        }
                    } else {
                        ToastBar.showErrorMessage("Please enter phone number!");
                    }
                } else {
                    ToastBar.showErrorMessage("Please enter a last name!");
                }
            } else {
                if (checkChars) {
                    ToastBar.showErrorMessage("Please enter a first name!");
                } else {
                    ToastBar.showErrorMessage("Error: special chars are not allowed in fields");
                }
            }
        } else {
            ToastBar.showErrorMessage("Error: spaces are not allowed in fields");
        }
    }

    public void onbtn_check_privacyActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Display.getInstance().execute("https://openskyjo.github.io/Terms-Conditions/");
    }

    private void setHeightTextFields() {
        gui_TF_First_Name.setPreferredH(cn1Display.getHeight() / 16);
        gui_TF_First_Name.getAllStyles().setPaddingLeft(2);
        gui_TF_Last_Name.setPreferredH(cn1Display.getHeight() / 16);
        gui_TF_Last_Name.getAllStyles().setPaddingLeft(2);
        gui_TF_Phone.setPreferredH(cn1Display.getHeight() / 16);
        gui_TF_Phone.getAllStyles().setPaddingLeft(2);
        gui_TF_Username.setPreferredH(cn1Display.getHeight() / 16);
        gui_TF_Username.getAllStyles().setPaddingLeft(2);
        gui_TF_First_Name.setRows(1);
        gui_TF_Last_Name.setRows(1);
        gui_TF_Phone.setRows(1);
        gui_TF_Username.setRows(1);

    }

    public void onbtn_change_phoneActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new erorr(res, "Complete verification", "do you want change phone number? if selected yes, then you should complete verification", "Yes", e -> {
            new Activation_Form_2(res, this, false).show();
        }).show();
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
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("");
        setName("user_info");
        gui_Container.setPreferredSizeStr("76.98413mm 130.15874mm");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("70.10582mm 134.12698mm");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_btn_save.setPreferredSizeStr("47.8836mm 10.05291mm");
        gui_btn_save.setText("Save");
        gui_btn_save.setUIID("btn_select");
        gui_btn_save.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_save.setName("btn_save");
        gui_Container.addComponent(gui_Container_1);
        gui_Label.setPreferredSizeStr("25.132275mm 4.7619047mm");
        gui_Label.setRTL(true);
        gui_Label.setText("Date");
        gui_Label.setUIID("PersonalInfo_Lbl");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("68.25397mm inherit");
        gui_Label_1.setRTL(true);
        gui_Label_1.setText("Name");
        gui_Label_1.setUIID("PersonalInfo_Lbl");
        gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("alignment:left;");
        gui_Label_1.setName("Label_1");
        gui_TF_First_Name.setPreferredSizeStr("inherit 5.555556mm");
        gui_TF_First_Name.setRTL(true);
        gui_TF_First_Name.setHint("First Name");
        gui_TF_First_Name.setInlineStylesTheme(resourceObjectInstance);
        gui_TF_First_Name.setName("TF_First_Name");
        gui_TF_Last_Name.setPreferredSizeStr("24.338625mm 5.555556mm");
        gui_TF_Last_Name.setRTL(true);
        gui_TF_Last_Name.setHint("Second Name");
        gui_TF_Last_Name.setInlineStylesTheme(resourceObjectInstance);
        gui_TF_Last_Name.setName("TF_Last_Name");
        gui_Label_2.setPreferredSizeStr("30.15873mm 7.4074073mm");
        gui_Label_2.setRTL(true);
        gui_Label_2.setText("Phone");
        gui_Label_2.setUIID("PersonalInfo_Lbl");
        gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_TF_Phone.setPreferredSizeStr("61.11111mm inherit");
        gui_TF_Phone.setRTL(true);
        gui_TF_Phone.setHint("Phone Number");
        gui_TF_Phone.setInlineStylesTheme(resourceObjectInstance);
        gui_TF_Phone.setName("TF_Phone");
        gui_TF_Phone.setConstraint(com.codename1.ui.TextArea.EMAILADDR | com.codename1.ui.TextArea.NUMERIC | com.codename1.ui.TextArea.PHONENUMBER);
        gui_Label_3.setPreferredSizeStr("73.280426mm inherit");
        gui_Label_3.setRTL(true);
        gui_Label_3.setText("Username");
        gui_Label_3.setUIID("PersonalInfo_Lbl");
        gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setName("Label_3");
        gui_TF_Username.setPreferredSizeStr("61.11111mm inherit");
        gui_TF_Username.setRTL(true);
        gui_TF_Username.setHint("Username");
        gui_TF_Username.setInlineStylesTheme(resourceObjectInstance);
        gui_TF_Username.setName("TF_Username");
        gui_TF_Username.setConstraint(com.codename1.ui.TextArea.EMAILADDR);
        gui_Label_4.setPreferredSizeStr("25.132275mm 9.259259mm");
        gui_Label_4.setRTL(true);
        gui_Label_4.setText("City");
        gui_Label_4.setUIID("PersonalInfo_Lbl");
        gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setName("Label_4");
        gui_CBox_Country.setPreferredSizeStr("38.62434mm 9.523809mm");
        gui_CBox_Country.setScrollVisible(true);
        gui_CBox_Country.setInlineStylesTheme(resourceObjectInstance);
        gui_CBox_Country.setName("CBox_Country");
        gui_CBox_Sex.setPreferredSizeStr("24.867725mm 8.994709mm");
        gui_CBox_Sex.setScrollVisible(true);
        gui_CBox_Sex.setInlineStylesTheme(resourceObjectInstance);
        gui_CBox_Sex.setName("CBox_Sex");
        gui_Label_5.setPreferredSizeStr("25.132275mm 8.465609mm");
        gui_Label_5.setRTL(true);
        gui_Label_5.setText("Gender");
        gui_Label_5.setUIID("PersonalInfo_Lbl");
        gui_Label_5.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_5.setName("Label_5");
        gui_Con_Picker.setPreferredSizeStr("23.015873mm 9.523809mm");
        gui_Con_Picker.setInlineStylesTheme(resourceObjectInstance);
        gui_Con_Picker.setName("Con_Picker");
        gui_btn_change_phone.setPreferredSizeStr("14.550264mm 8.465609mm");
        gui_btn_change_phone.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_change_phone.setName("btn_change_phone");
        com.codename1.ui.FontImage.setMaterialIcon(gui_btn_change_phone, "\ue254".charAt(0));
        gui_Container_1.addComponent(gui_Label);
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_TF_First_Name);
        gui_Container_1.addComponent(gui_TF_Last_Name);
        gui_Container_1.addComponent(gui_Label_2);
        gui_Container_1.addComponent(gui_TF_Phone);
        gui_Container_1.addComponent(gui_Label_3);
        gui_Container_1.addComponent(gui_TF_Username);
        gui_Container_1.addComponent(gui_Label_4);
        gui_Container_1.addComponent(gui_CBox_Country);
        gui_Container_1.addComponent(gui_CBox_Sex);
        gui_Container_1.addComponent(gui_Label_5);
        gui_Container_1.addComponent(gui_Con_Picker);
        gui_Container_1.addComponent(gui_btn_change_phone);
        gui_Container_1.addComponent(gui_btn_save);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label.getParent().getLayout()).setInsets(gui_Label, "2.3809524mm 0.0mm auto auto").setReferenceComponents(gui_Label, "7 -1 -1 -1").setReferencePositions(gui_Label, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "10.0% 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_TF_First_Name.getParent().getLayout()).setInsets(gui_TF_First_Name, "0.0mm 0.0mm auto 50.0%").setReferenceComponents(gui_TF_First_Name, "1 -1 -1 -1").setReferencePositions(gui_TF_First_Name, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_TF_Last_Name.getParent().getLayout()).setInsets(gui_TF_Last_Name, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_TF_Last_Name, "1 2 -1 -1").setReferencePositions(gui_TF_Last_Name, "1.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_Label_2, "2 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_TF_Phone.getParent().getLayout()).setInsets(gui_TF_Phone, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_TF_Phone, "4 -1 -1 -1").setReferencePositions(gui_TF_Phone, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_3.getParent().getLayout()).setInsets(gui_Label_3, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_3, "5 -1 -1 -1").setReferencePositions(gui_Label_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_TF_Username.getParent().getLayout()).setInsets(gui_TF_Username, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_TF_Username, "6 -1 -1 -1").setReferencePositions(gui_TF_Username, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_4.getParent().getLayout()).setInsets(gui_Label_4, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_Label_4, "11 -1 -1 -1").setReferencePositions(gui_Label_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_CBox_Country.getParent().getLayout()).setInsets(gui_CBox_Country, "0.0mm 0.0mm auto 2.0mm").setReferenceComponents(gui_CBox_Country, "10 8 -1 -1").setReferencePositions(gui_CBox_Country, "1.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_CBox_Sex.getParent().getLayout()).setInsets(gui_CBox_Sex, "0.0mm 0.0mm auto 2.0mm").setReferenceComponents(gui_CBox_Sex, "12 11 -1 -1").setReferencePositions(gui_CBox_Sex, "1.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Label_5.getParent().getLayout()).setInsets(gui_Label_5, "2.3841858E-7mm 0.0mm auto auto").setReferenceComponents(gui_Label_5, "12 -1 -1 -1").setReferencePositions(gui_Label_5, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Picker.getLayout()).setPreferredWidthMM((float) 23.015873);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Picker.getLayout()).setPreferredHeightMM((float) 9.523809);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Con_Picker.getParent().getLayout()).setInsets(gui_Con_Picker, "0.0mm 0.0mm auto 2.0mm").setReferenceComponents(gui_Con_Picker, "7 0 -1 -1").setReferencePositions(gui_Con_Picker, "1.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_change_phone.getParent().getLayout()).setInsets(gui_btn_change_phone, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_btn_change_phone, "3 -1 -1 -1").setReferencePositions(gui_btn_change_phone, "1.0 0.0 0.0 0.0");

        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredWidthMM((float) 71.164024);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getLayout()).setPreferredHeightMM((float) 134.12698);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_btn_save.getParent().getLayout()).setInsets(gui_btn_save, "2.0mm auto auto auto").setReferenceComponents(gui_btn_save, "9 -1 -1 -1").setReferencePositions(gui_btn_save, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredWidthMM((float) 59.52381);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getLayout()).setPreferredHeightMM((float) 130.15874);
        ((com.codename1.ui.layouts.LayeredLayout) gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 1.9073486E-6mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

    private void setRTLCmb(Resources res) {
        gui_TF_First_Name.getHintLabel().setRTL(true);
        gui_TF_Last_Name.getHintLabel().setRTL(true);
        gui_TF_Phone.getHintLabel().setRTL(true);
        gui_TF_Username.getHintLabel().setRTL(true);
    }
}
