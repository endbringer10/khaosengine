package com.khaos.core.data.entry;

/**
 *
 * @author endbr
 */
public class SettingEntry extends Meta {

    private final String value;

    public SettingEntry(String meta, String value) {
        super(meta);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}//End Class
