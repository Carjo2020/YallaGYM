package com.yallagym.client.dialogs;

import com.codename1.io.Preferences;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.yallagym.client.forms.map_form;

public class dlg_apple_select_map extends com.codename1.ui.Dialog {

    public dlg_apple_select_map() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public dlg_apple_select_map(com.codename1.ui.util.Resources res) {
        initGuiBuilderComponents(res);
        this.setScrollable(false);
        this.setScrollVisible(false);
        this.setDialogUIID("transperent");
        this.setTitle("");
        this.setMinimizeOnBack(true);
        this.setBlurBackgroundRadius(15);
        this.setDisposeWhenPointerOutOfBounds(true);
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {

            }
        };
        this.setBackCommand(back);
        gui_btn_continue.addActionListener(e -> {
            System.out.println(gui_r_google.isSelected());
            System.out.println(gui_cb_not_show.isSelected());
            if (gui_r_google.isSelected()) {
                if (gui_cb_not_show.isSelected()) {
                    Preferences.set("map_type", true);
                }
                this.dispose();
                Form map = new map_form(res, this, null);
                map.show();
            } else {
                this.dispose();
                new erorr(res, "Permission Request", "This app attempts to access Apple native maps app to display you the nearest gym.", "Allow", eee -> {
                    Display.getInstance().execute("http://maps.apple.com/?daddr=32.023837199999996,35.8508545&dirflg=d");
                }, "Don't Allow", eee -> {

                }).show();
            }
//           

        });
        new ButtonGroup(gui_r_google, gui_r_apple);
    }

////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_icon = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.RadioButton gui_r_google = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_r_apple = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.CheckBox gui_cb_not_show = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.Button gui_btn_continue = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("dlg_apple_select_map");
        setName("dlg_apple_select_map");
        gui_Container.setPreferredSizeStr("inherit 70.24051mm");
        gui_Container.setUIID("con_terms");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setInlineAllStyles("padding:0.0mm 2.0mm 0.0mm 2.0mm;");
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_lbl_icon.setPreferredSizeStr("12.137559mm 11.375662mm");
                gui_lbl_icon.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_icon.setInlineAllStyles("bgImage:greet.png;");
        gui_lbl_icon.setName("lbl_icon");
        gui_Container_1.setPreferredSizeStr("40.90807mm 27.513227mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_btn_continue.setPreferredSizeStr("31.580132mm 7.4074073mm");
        gui_btn_continue.setText("Continue");
        gui_btn_continue.setUIID("btn_get_yellow");
                gui_btn_continue.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_continue.setName("btn_continue");
        gui_Label.setPreferredSizeStr("41.35761mm 6.518319mm");
        gui_Label.setText("Select type of map");
        gui_Label.setUIID("Correct_Msg_Sb_Txt");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:3.0mm; alignment:center;");
        gui_Label.setName("Label");
        gui_Container.addComponent(gui_lbl_icon);
        gui_Container.addComponent(gui_Container_1);
        gui_r_google.setSelected(true);
        gui_r_google.setText("Google Map");
                gui_r_google.setInlineStylesTheme(resourceObjectInstance);
        gui_r_google.setName("r_google");
        gui_r_apple.setText("Apple Map");
                gui_r_apple.setInlineStylesTheme(resourceObjectInstance);
        gui_r_apple.setName("r_apple");
        gui_cb_not_show.setRTL(true);
        gui_cb_not_show.setText("don't show again");
                gui_cb_not_show.setInlineStylesTheme(resourceObjectInstance);
        gui_cb_not_show.setInlineAllStyles("alignment:right; margin:3.0mm 1.0mm 0.0mm 1.0mm;");
        gui_cb_not_show.setName("cb_not_show");
        gui_Container_1.addComponent(gui_r_google);
        gui_Container_1.addComponent(gui_r_apple);
        gui_Container_1.addComponent(gui_cb_not_show);
        gui_Container.addComponent(gui_btn_continue);
        gui_Container.addComponent(gui_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_icon.getParent().getLayout()).setInsets(gui_lbl_icon, "4.0mm auto auto auto").setReferenceComponents(gui_lbl_icon, "-1 -1 -1 -1").setReferencePositions(gui_lbl_icon, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "2.0mm 2.0mm auto 2.0mm").setReferenceComponents(gui_Container_1, "3 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_continue.getParent().getLayout()).setInsets(gui_btn_continue, "3.0mm auto auto auto").setReferenceComponents(gui_btn_continue, "1 -1 -1 -1").setReferencePositions(gui_btn_continue, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "3.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Label, "0 -1 -1 -1").setReferencePositions(gui_Label, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)45.853);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)70.24051);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
