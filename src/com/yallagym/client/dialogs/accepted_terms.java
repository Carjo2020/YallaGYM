package com.yallagym.client.dialogs;

import com.codename1.io.Preferences;
import com.codename1.ui.CN;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.Resources;

public class accepted_terms extends com.codename1.ui.Dialog {

    public accepted_terms() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public accepted_terms(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        this.setScrollable(false);
        this.setScrollVisible(false);
        this.setDialogUIID("transperent");
        this.setTitle("");
        this.setMinimizeOnBack(true);
        this.setBlurBackgroundRadius(15);
        this.setDisposeWhenPointerOutOfBounds(false);
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {

            }
        };
        this.setBackCommand(back);
        gui_btn_agree.addActionListener(e -> {
            Preferences.set("accepted_terms", true);
            dispose();
        });
        gui_btn_cancel.addActionListener(e -> {
            dispose();
        });
    }

////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Button gui_btn_agree = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btn_cancel = new com.codename1.ui.Button();
    protected com.codename1.components.SpanButton gui_Span_Button = new com.codename1.components.SpanButton();
    protected com.codename1.ui.Button gui_btn_open_terms = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_open_terms.addActionListener(callback);
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

            if(sourceComponent == gui_btn_open_terms) {
                onbtn_open_termsActionEvent(ev);
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
        setTitle("accepted_terms");
        setName("accepted_terms");
        gui_Container.setPreferredSizeStr("inherit 67.98942mm");
        gui_Container.setUIID("con_terms");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Container_1.setPreferredSizeStr("inherit 11.904762mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Span_Button.setPreferredSizeStr("77.24868mm 40.21164mm");
        gui_Span_Button.setText("By tapping the I Agree button, you confirm that you have understand them and that you agree to be bound by them");
        gui_Span_Button.setUIID("Correct_Msg_Sb_Txt");
                gui_Span_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Span_Button.setName("Span_Button");
        gui_Span_Button.setPropertyValue("textUiid", "Correct_Msg_Sb_Txt");
        gui_btn_open_terms.setPreferredSizeStr("71.95767mm inherit");
        gui_btn_open_terms.setText("Terms Of Service");
        gui_btn_open_terms.setUIID("under_line_btn");
                gui_btn_open_terms.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_open_terms.setName("btn_open_terms");
        gui_Label.setPreferredSizeStr("10.8465605mm 11.111112mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:terms_hand_ic.png;");
        gui_Label.setName("Label");
        gui_Container.addComponent(gui_Container_1);
        gui_btn_agree.setPreferredSizeStr("38.88889mm 24.074074mm");
        gui_btn_agree.setText("Agree");
        gui_btn_agree.setUIID("terms_light_green_btn");
                gui_btn_agree.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_agree.setInlineAllStyles("border:roundRect -top-left -top-right -bottom-left +bottom-right 8.0mm;");
        gui_btn_agree.setName("btn_agree");
        gui_btn_cancel.setPreferredSizeStr("32.804234mm 28.042328mm");
        gui_btn_cancel.setText("Cancel");
        gui_btn_cancel.setUIID("terms_bold_green_btn");
                gui_btn_cancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_cancel.setInlineAllStyles("border:roundRect -top-left -top-right +bottom-left -bottom-right 8.0mm;");
        gui_btn_cancel.setName("btn_cancel");
        gui_Container_1.addComponent(gui_btn_agree);
        gui_Container_1.addComponent(gui_btn_cancel);
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_agree.getParent().getLayout()).setInsets(gui_btn_agree, "0.0mm 0.0mm 0.0mm 50.0%").setReferenceComponents(gui_btn_agree, "-1 -1 -1 -1").setReferencePositions(gui_btn_agree, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_cancel.getParent().getLayout()).setInsets(gui_btn_cancel, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_cancel, "-1 0 -1 -1").setReferencePositions(gui_btn_cancel, "0.0 1.0 0.0 0.0");
        gui_Container.addComponent(gui_Span_Button);
        gui_Container.addComponent(gui_btn_open_terms);
        gui_Container.addComponent(gui_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)65.60847);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)11.904762);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container_1, "1 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Span_Button.getParent().getLayout()).setInsets(gui_Span_Button, "0.0mm 0.0mm 23.151464% -9.536743E-7mm").setReferenceComponents(gui_Span_Button, "2 -1 -1 -1").setReferencePositions(gui_Span_Button, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_open_terms.getParent().getLayout()).setInsets(gui_btn_open_terms, "1.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_btn_open_terms, "3 -1 -1 -1").setReferencePositions(gui_btn_open_terms, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "1.0mm auto auto 39.583336%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)67.72487);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)67.98942);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onbtn_open_termsActionEvent(com.codename1.ui.events.ActionEvent ev) {
        CN.execute("https://openskyjo.github.io/PrivacyPolicy/");
    }

    public void onSpan_ButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        CN.execute("https://openskyjo.github.io/PrivacyPolicy/");
    }

}
