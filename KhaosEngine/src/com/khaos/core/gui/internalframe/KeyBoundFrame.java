package com.khaos.core.gui.internalframe;

import com.khaos.core.KeyBinds;
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
    }

    public void bindKeys() {
        int ancestor = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
        this.getInputMap(ancestor).put(KeyBinds.ESC.getKey(), KeyBinds.ESC.getAction());
        this.getActionMap().put(KeyBinds.ESC.getAction(), new EscAction());
    }

    private class EscAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }

    }//End Class

}//End Class
