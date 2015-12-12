package com.khaos.core;

import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

/**
 *
 * @author endbr
 */
public enum KeyBinds {

    UP(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Move Up"),
    DOWN(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Move Down"),
    LEFT(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Move Left"),
    RIGHT(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Move Right"),
    CLOSE(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Close Window");

    private KeyStroke key;
    private final String action;

    KeyBinds(KeyStroke key, String action) {
        this.key = key;
        this.action = action;
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

    public static void load() {

    }

    public static void save() {

    }

}//End Class
