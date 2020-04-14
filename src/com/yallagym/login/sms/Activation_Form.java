package com.yallagym.login.sms;

import com.codename1.ui.util.Resources;
import com.yallagym.forms.login.forms.BaseLogin;

public class Activation_Form extends BaseLogin {

    Resources res;

    public Activation_Form() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public Activation_Form(com.codename1.ui.util.Resources res) {
          initGuiBuilderComponents(res);
        this.res = res;
        sethideToolbar();
        /// ...
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_bg_img = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_bg_img_gray = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_logo = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_yallagym = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_btn_show_next_form = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btn_show_next_form.addActionListener(callback);
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

            if(sourceComponent == gui_btn_show_next_form) {
                onbtn_show_next_formActionEvent(ev);
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
        setTitle("Activation_Form");
        setName("Activation_Form");
        gui_bg_img.setPreferredSizeStr("98.677246mm 134.12698mm");
                gui_bg_img.setInlineStylesTheme(resourceObjectInstance);
        gui_bg_img.setInlineAllStyles("bgImage:background-image.png;");
        gui_bg_img.setName("bg_img");
        gui_bg_img_gray.setPreferredSizeStr("123.544975mm 138.62434mm");
                gui_bg_img_gray.setInlineStylesTheme(resourceObjectInstance);
        gui_bg_img_gray.setInlineAllStyles("bgImage:dark-layer.png;");
        gui_bg_img_gray.setName("bg_img_gray");
        gui_Container.setPreferredSizeStr("104.49735mm 123.809525mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_bg_img);
        addComponent(gui_bg_img_gray);
        addComponent(gui_Container);
        gui_logo.setPreferredSizeStr("41.534393mm 41.798943mm");
                gui_logo.setInlineStylesTheme(resourceObjectInstance);
        gui_logo.setInlineAllStyles("bgImage:logo.png;");
        gui_logo.setName("logo");
        gui_yallagym.setPreferredSizeStr("47.089947mm 12.698413mm");
                gui_yallagym.setInlineStylesTheme(resourceObjectInstance);
        gui_yallagym.setInlineAllStyles("bgImage:Logo---Crop.png;");
        gui_yallagym.setName("yallagym");
        gui_Container_2.setPreferredSizeStr("57.93651mm 37.037037mm");
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setInlineAllStyles("bgColor:ffffff; transparency:255; opacity:255;");
        gui_Container_2.setName("Container_2");
        gui_Container.addComponent(gui_logo);
        gui_Container.addComponent(gui_yallagym);
        gui_Container.addComponent(gui_Container_2);
        gui_Container_1.setPreferredSizeStr("66.137566mm 11.904762mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Label_2.setPreferredSizeStr("47.354496mm 9.259259mm");
        gui_Label_2.setText("Get a club with yalla gym");
        gui_Label_2.setUIID("Activation_Title");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_Container_2.addComponent(gui_Container_1);
        gui_Container_1_1.setPreferredSizeStr("17.989418mm 7.142857mm");
                gui_Container_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1_1.setName("Container_1_1");
        gui_btn_show_next_form.setPreferredSizeStr("57.67196mm 19.047619mm");
        gui_btn_show_next_form.setText("Enter your mobile number");
        gui_btn_show_next_form.setUIID("Activation_Input");
                gui_btn_show_next_form.setInlineStylesTheme(resourceObjectInstance);
        gui_btn_show_next_form.setName("btn_show_next_form");
        gui_Container_1.addComponent(gui_Container_1_1);
        gui_Label.setPreferredSizeStr("5.820106mm 3.968254mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:flag-jordan.png;");
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("9.259259mm inherit");
        gui_Label_1.setText("+962");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Container_1_1.addComponent(gui_Label);
        gui_Container_1_1.addComponent(gui_Label_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto auto -5.9604645E-8mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "auto 0.0mm auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        gui_Container_1.addComponent(gui_btn_show_next_form);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getLayout()).setPreferredWidthMM((float)17.989418);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getLayout()).setPreferredHeightMM((float)7.142857);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1_1.getParent().getLayout()).setInsets(gui_Container_1_1, "auto auto auto 0.2645502mm").setReferenceComponents(gui_Container_1_1, "-1 -1 -1 -1").setReferencePositions(gui_Container_1_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btn_show_next_form.getParent().getLayout()).setInsets(gui_btn_show_next_form, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_btn_show_next_form, "-1 -1 -1 0 ").setReferencePositions(gui_btn_show_next_form, "0.0 0.0 0.0 1.0");
        gui_Container_2.addComponent(gui_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredWidthMM((float)66.137566);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getLayout()).setPreferredHeightMM((float)11.904762);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "7.746479% 1.0582011mm auto 5.0%").setReferenceComponents(gui_Container_1, "1 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "3.4391534mm 3.4391534mm auto 3.4391534mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_logo.getParent().getLayout()).setInsets(gui_logo, "10.0% auto auto auto").setReferenceComponents(gui_logo, "-1 -1 -1 -1").setReferencePositions(gui_logo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_yallagym.getParent().getLayout()).setInsets(gui_yallagym, "5.0% auto auto auto").setReferenceComponents(gui_yallagym, "0 -1 -1 -1").setReferencePositions(gui_yallagym, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredWidthMM((float)69.31217);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getLayout()).setPreferredHeightMM((float)37.037037);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_2.getParent().getLayout()).setInsets(gui_Container_2, "70.0% 0.0mm -0.26455027mm 0.0mm").setReferenceComponents(gui_Container_2, "-1 -1 -1 -1").setReferencePositions(gui_Container_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img.getParent().getLayout()).setInsets(gui_bg_img, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img, "-1 -1 -1 -1").setReferencePositions(gui_bg_img, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_bg_img_gray.getParent().getLayout()).setInsets(gui_bg_img_gray, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_bg_img_gray, "-1 -1 -1 -1").setReferencePositions(gui_bg_img_gray, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)104.49735);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)123.809525);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.26455027mm auto 0.26455027mm auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onbtn_show_next_formActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new Activation_Form_2(res,this).show();
    }

}