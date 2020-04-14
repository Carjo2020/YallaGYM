package com.yallagym.client.dialogs;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

public class erorr_msg extends com.codename1.ui.Dialog {

    public erorr_msg() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public erorr_msg(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }

    public erorr_msg(com.codename1.ui.util.Resources res, String title, String msg, String yes, ActionListener yes_a) {
        initGuiBuilderComponents(res);
        this.setScrollable(false);
        this.setScrollVisible(false);
        gui_Title.setText(title);
        gui_Msg.setText(msg);
        gui_Yes.setText(yes);

        this.setDialogUIID("transperent");
        this.setTitle("");
        this.setDisposeWhenPointerOutOfBounds(true);
        this.setMinimizeOnBack(true);
        this.setBlurBackgroundRadius(15);
        if (yes_a == null) {
            gui_Yes.addActionListener(e -> {
                dispose();
            });
        } else {
            gui_Yes.addActionListener(e -> {
                dispose();
            });
            gui_Yes.addActionListener(yes_a);
        }
    }

    public erorr_msg(com.codename1.ui.util.Resources res, String title, String msg, String yes, ActionListener yes_a, boolean forceKeeping) {
        initGuiBuilderComponents(res);
        this.setScrollable(false);
        this.setScrollVisible(false);
        gui_Title.setText(title);
        gui_Msg.setText(msg);
        gui_Yes.setText(yes);
        this.setDialogUIID("transperent");
        this.setTitle("");
        this.setMinimizeOnBack(true);
        this.setBlurBackgroundRadius(15);
        this.setDisposeWhenPointerOutOfBounds(false);
        gui_Yes.addActionListener(yes_a);
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {

            }
        };
        this.setBackCommand(back);

    }
////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_Yes = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Title = new com.codename1.ui.Label();
    protected com.codename1.components.SpanLabel gui_Msg = new com.codename1.components.SpanLabel();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("erorr");
        setName("erorr_msg");
        gui_Container.setPreferredSizeStr("59.78836mm 40.476192mm");
        gui_Container.setUIID("Dialog_ContantPane");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Yes.setPreferredSizeStr("32.539684mm 8.465609mm");
        gui_Yes.setText("Yes");
        gui_Yes.setUIID("Dialog_Btn");
                gui_Yes.setInlineStylesTheme(resourceObjectInstance);
        gui_Yes.setName("Yes");
        gui_Title.setPreferredSizeStr("55.291004mm 6.878307mm");
        gui_Title.setUIID("Dialog_Title");
                gui_Title.setInlineStylesTheme(resourceObjectInstance);
        gui_Title.setName("Title");
        gui_Msg.setText("");
        gui_Msg.setUIID("Dialog_Msg");
                gui_Msg.setInlineStylesTheme(resourceObjectInstance);
        gui_Msg.setName("Msg");
        gui_Msg.setPropertyValue("textUiid", "Dialog_Msg");
        gui_Container.addComponent(gui_Yes);
        gui_Container.addComponent(gui_Title);
        gui_Container.addComponent(gui_Msg);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Yes.getParent().getLayout()).setInsets(gui_Yes, "auto 19.905212% 0.0mm 19.905212%").setReferenceComponents(gui_Yes, "-1 -1 -1 -1").setReferencePositions(gui_Yes, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Title.getParent().getLayout()).setInsets(gui_Title, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Title, "-1 -1 -1 -1").setReferencePositions(gui_Title, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Msg.getParent().getLayout()).setInsets(gui_Msg, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Msg, "1 -1 0 -1").setReferencePositions(gui_Msg, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)55.291004);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)40.476192);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

}
