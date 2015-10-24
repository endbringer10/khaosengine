package com.khaos.core;

import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

/**
 *
 * @author endbr
 */
public enum KeyBinds {

    UP(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Move Up"),
    ESC(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Close Window");

    private KeyStroke key;
    private final String name;
    private final String action;

    KeyBinds(KeyStroke key, String action) {
        this.key = key;
        this.action = action;
        this.name = action;
    }

    public String getAction() {
        return action;
    }

    public KeyStroke getKey() {
        return key;
    }

    public void setKey(KeyStroke key) {
        this.key = key;
    }

}//End Class
