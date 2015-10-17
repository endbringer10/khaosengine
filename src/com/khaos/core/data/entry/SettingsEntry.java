package com.khaos.core.data.entry;

import com.khaos.core.data.Meta;

/**
 *
 * @author endbr
 */
public class SettingsEntry extends Meta {

    private final String value;

    public SettingsEntry(String header, String value) {
        super(header);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}//End Class
