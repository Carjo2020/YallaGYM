package com.yallagym.client.forms;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


public class user_orders extends Form  {
    public user_orders(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_empty_order = new com.codename1.ui.Label();
    protected com.codename1.components.InfiniteProgress gui_Infinite_Progress = new com.codename1.components.InfiniteProgress();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("MyOrders");
        setName("user_orders");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_empty_order.setText("There's no any order");
        gui_empty_order.setUIID("PersonalInfo_Lbl");
                gui_empty_order.setInlineStylesTheme(resourceObjectInstance);
        gui_empty_order.setInlineAllStyles("font:4.0mm; fgColor:333; alignment:center;");
        gui_empty_order.setName("empty_order");
        gui_Infinite_Progress.setPreferredSizeStr("9.78836mm 9.523809mm");
                gui_Infinite_Progress.setInlineStylesTheme(resourceObjectInstance);
        gui_Infinite_Progress.setName("Infinite_Progress");
        addComponent(gui_Container);
        addComponent(gui_empty_order);
        addComponent(gui_Infinite_Progress);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_empty_order.getParent().getLayout()).setInsets(gui_empty_order, "0px 0px 0px 0px").setReferenceComponents(gui_empty_order, "-1 -1 -1 -1").setReferencePositions(gui_empty_order, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Infinite_Progress.getParent().getLayout()).setInsets(gui_Infinite_Progress, "auto auto auto auto").setReferenceComponents(gui_Infinite_Progress, "-1 -1 -1 -1").setReferencePositions(gui_Infinite_Progress, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
//-- DON'T EDIT ABOVE THIS LINE!!!
}
