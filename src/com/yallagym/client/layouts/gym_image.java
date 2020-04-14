package com.yallagym.client.layouts;

public class gym_image extends com.codename1.ui.Container {

    public gym_image() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
    }
    
    public gym_image(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }

    public gym_image(com.codename1.ui.util.Resources resourceObjectInstance, String name) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_lbl_name.setText(name);
        gui_Label.setPreferredW(gui_Label.getPreferredH());
    }
////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_lbl_name = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("gym_image");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setInlineAllStyles("bgImage:gym-name.png;");
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("9.523809mm 7.936508mm");
        gui_Label.setText("");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:logo.png;");
        gui_Label.setName("Label");
        gui_lbl_name.setPreferredSizeStr("52.645504mm 15.343915mm");
        gui_lbl_name.setText("Yalla Gym");
        gui_lbl_name.setUIID("img_lbl");
                gui_lbl_name.setInlineStylesTheme(resourceObjectInstance);
        gui_lbl_name.setName("lbl_name");
        gui_Container.addComponent(gui_Label);
        gui_Container.addComponent(gui_lbl_name);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto 10.0% auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_lbl_name.getParent().getLayout()).setInsets(gui_lbl_name, "20.0% auto auto auto").setReferenceComponents(gui_lbl_name, "-1 -1 -1 -1").setReferencePositions(gui_lbl_name, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
