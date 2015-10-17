package com.khaos.core.data;

/**
 *
 * @author endbr
 */
public class Entry extends Meta {

    private final String value;

    public Entry(String header, String value) {
        super(header);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}//End Class
