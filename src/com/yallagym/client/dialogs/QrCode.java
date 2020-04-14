package com.yallagym.client.dialogs;

import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;

public class QrCode extends com.codename1.ui.Dialog {

    public QrCode() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public QrCode(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }

    public QrCode(com.codename1.ui.util.Resources res, Image img) {
        initGuiBuilderComponents(res);
        gui_lbl_qrcode.setPreferredH(gui_lbl_qrcode.getPreferredW());
        gui_lbl_qrcode.getAllStyles().setBgImage(img);
    }
//////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_lbl_qrcode = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_ok = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_ok.addActionListener(callback);
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

            if(sourceComponent == gui_btn_ok) {
                onbtn_okActionEvent(ev);
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
        setTitle("QrCode");
        setName("QrCode");
        gui_Container.setPreferredSizeStr("75.92593mm 54.497356mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_lbl_qrcode.setPreferredSizeStr("38.095238mm 30.42328mm");
        gui_lbl_qrcode.setText("");
                gui_lbl_qrcode.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_qrcode.setName("lbl_qrcode");
        gui_btn_ok.setText("\u062D\u0633\u0646\u0627\u064B");
                gui_btn_ok.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_ok.setName("btn_ok");
        gui_Container.addComponent(gui_lbl_qrcode);
        gui_Container.addComponent(gui_btn_ok);
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_qrcode.getParent().getLayout()).setInsets(gui_lbl_qrcode, "3.0mm auto auto auto").setReferenceComponents(gui_lbl_qrcode, "-1 -1 -1 -1").setReferencePositions(gui_lbl_qrcode, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_ok.getParent().getLayout()).setInsets(gui_btn_ok, "5.0mm auto auto auto").setReferenceComponents(gui_btn_ok, "0 -1 -1 -1").setReferencePositions(gui_btn_ok, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)60.84656);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)54.497356);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 3.0mm auto 3.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onbtn_okActionEvent(com.codename1.ui.events.ActionEvent ev) {
        dispose();
    }

}
