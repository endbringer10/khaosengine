package com.khaos.core.data.entry;

import javax.swing.KeyStroke;

/**
 *
 * @author endbr
 */
public class KeyBindsEntry extends Meta {

    private final String key;

    public KeyBindsEntry(String meta, String key) {
        super(meta);
        this.key = key;
    }

    public KeyStroke getKey() {
        return KeyStroke.getKeyStroke(key);
    }

}//End CLass
