package com.yallagym.club.dialogs;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.Resources;

public class club_BaseDialog extends Dialog {

    public void installDialog(Resources res) {
        this.setScrollVisible(false);
        this.setScrollable(false);
        this.setDialogUIID("transperent");
        this.setTitle("");
        this.setMinimizeOnBack(true);
        this.setDisposeWhenPointerOutOfBounds(true);
        Command back = new Command("Back") {
            public void actionPerformed(ActionEvent ev) {
                dispose();
            }
        };
        this.setBackCommand(back);
    }
}
