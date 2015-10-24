package com.khaos.core;

import java.awt.event.KeyEvent;

/**
 *
 * @author endbr
 */
public enum KeyBinds {

    UP(KeyEvent.VK_UP, "Move Up"),
    ESC(KeyEvent.VK_ESCAPE, "Close Window");

    private int key;
    private final String name;
    private final String action;

    KeyBinds(int key, String action) {
        this.key = key;
        this.action = action;
        this.name = action;
    }

    public String getAction() {
        return action;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}//End Class
