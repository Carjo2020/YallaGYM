package com.yallagym.club.layouts;

public class club_payment_devider extends com.codename1.ui.Container {

    public club_payment_devider() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public club_payment_devider(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_Label.setPreferredH(3);
        gui_Label_2.setPreferredH(3);
    }

////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("club_payment_devider");
        gui_Container.setPreferredSizeStr("inherit 9.78836mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("28.042328mm 0.52910054mm");
        gui_Label.setText("");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgColor:8d8d8d; transparency:135; bgImage:;");
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("21.428572mm 5.026455mm");
        gui_Label_1.setText("Transaction Timeline");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:2.0mm; fgColor:8d8d8d;");
        gui_Label_1.setName("Label_1");
        gui_Label_2.setPreferredSizeStr("28.042328mm 0.52910054mm");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("bgColor:8d8d8d; transparency:135; bgImage:;");
        gui_Label_2.setName("Label_2");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_Label_1);
        gui_Container.addComponent(gui_Label_2);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto 4.0mm auto 4.0mm").setReferenceComponents(gui_Label, "-1 1 -1 -1").setReferencePositions(gui_Label, "0.0 1.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "auto auto auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "auto 4.0mm auto 4.0mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 1 ").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)78.04233);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)9.78836);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto 0.0mm auto 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!- DON'T EDIT ABOVE THIS LINE!!!
}
