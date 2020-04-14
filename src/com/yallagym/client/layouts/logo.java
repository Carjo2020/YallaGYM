 package com.yallagym.client.layouts;  

public class logo extends com.codename1.ui.Container {
    public logo() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }
    
    public logo(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        /// ...
    }
    
////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("logo");
        gui_Container.setPreferredSizeStr("58.46561mm 7.6719575mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        addComponent(gui_Container);
        gui_Label.setPreferredSizeStr("23.280424mm 7.6719575mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("bgImage:Logo---Crop.png;");
        gui_Label.setName("Label");
        gui_Container.addComponent(gui_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)35.714287);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)7.6719575);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "auto auto auto auto").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!N'T EDIT ABOVE THIS LINE!!!

}