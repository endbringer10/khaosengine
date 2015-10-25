package com.khaos.core.gui.internalframe;

import com.khaos.core.KeyBinds;
import com.khaos.core.gui.enums.Closeable;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public class KeyBoundFrame extends PanelHolder {

    public KeyBoundFrame(String title) {
        super(title);
        this.bindKeys();
    }

    public KeyBoundFrame(String title, Closeable close) {
        super(title, close);
        this.bindKeys();
    }

    /*public KeyBoundFrame(String title, Alignment align, Iconifiable icon) {
        super(title, align, icon);
        this.bindKeys();
    }*/

    private void bindKeys() {
        int ancestor = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        this.getInputMap(ancestor).put(KeyBinds.CLOSE.getKey(), KeyBinds.CLOSE.getAction());
        this.getActionMap().put(KeyBinds.CLOSE.getAction(), new EscAction());
    }

    private class EscAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }

    }//End Class

}//End Class
