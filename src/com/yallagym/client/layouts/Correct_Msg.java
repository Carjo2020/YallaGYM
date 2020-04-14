package com.yallagym.client.layouts;

import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

public class Correct_Msg extends com.codename1.ui.Dialog {

    public Correct_Msg() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public Correct_Msg(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }

    public Correct_Msg(com.codename1.ui.util.Resources res, String title, String msg, ActionListener e) {
        initGuiBuilderComponents(res);
        this.setDialogUIID("transperent");
        this.setTitle("");
        this.setDisposeWhenPointerOutOfBounds(true);
        this.setMinimizeOnBack(true);
        gui_lbl_title.setText(title);
        gui_sb_msg.setText(msg);
        gui_Label.setPreferredH(gui_Label.getPreferredW());
        gui_btn_done.addActionListener(e);
    }
//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.components.SpanLabel gui_sb_msg = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Label gui_lbl_title = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_done = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_done.addActionListener(callback);
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

            if(sourceComponent == gui_btn_done) {
                onbtn_doneActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Correct_Msg");
        setName("Correct_Msg");
        gui_Container_1.setPreferredSizeStr("58.201057mm 72.48677mm");
        gui_Container_1.setUIID("Home_Cars_Con");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        addComponent(gui_Container_1);
        gui_Container.setPreferredSizeStr("60.84656mm 55.291004mm");
        gui_Container.setUIID("Home_Cars_Con");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_btn_done.setPreferredSizeStr("18.518518mm 7.4074073mm");
        gui_btn_done.setText("Done");
        gui_btn_done.setUIID("btn_select");
                gui_btn_done.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_done.setName("btn_done");
        gui_Container_1.addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("26.984127mm 23.015873mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:correct.png;");
        gui_Label.setName("Label");
        gui_sb_msg.setPreferredSizeStr("69.04762mm 13.756614mm");
        gui_sb_msg.setUIID("Correct_Msg_Txt");
                gui_sb_msg.setInlineStylesTheme(resourceObjectInstance);
        gui_sb_msg.setName("sb_msg");
        gui_sb_msg.setPropertyValue("textUiid", "Correct_Msg_Sb_Txt");
        gui_lbl_title.setPreferredSizeStr("41.00529mm inherit");
        gui_lbl_title.setText("Saved successfully");
        gui_lbl_title.setUIID("Correct_Msg_Save_Lbl");
                gui_lbl_title.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_title.setInlineAllStyles("alignment:center;");
        gui_lbl_title.setName("lbl_title");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_sb_msg);
        gui_Container.addComponent(gui_lbl_title);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_sb_msg.getParent().getLayout()).setInsets(gui_sb_msg, "5.9604645E-8mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_sb_msg, "2 -1 -1 -1").setReferencePositions(gui_sb_msg, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_title.getParent().getLayout()).setInsets(gui_lbl_title, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_lbl_title, "0 -1 -1 -1").setReferencePositions(gui_lbl_title, "1.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_btn_done);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)49.4709);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)55.291004);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 1 -1").setReferencePositions(gui_Container, "0.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_done.getParent().getLayout()).setInsets(gui_btn_done, "auto auto 0.0mm auto").setReferenceComponents(gui_btn_done, "-1 -1 -1 -1").setReferencePositions(gui_btn_done, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)57.142857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)72.48677);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "auto auto auto auto").setReferenceComponents(gui_Container_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    public void onbtn_doneActionEvent(com.codename1.ui.events.ActionEvent ev) {
        dispose();
    }
 
}
