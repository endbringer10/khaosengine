package com.khaos.core;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public class Entry extends Header {

    private String value;

    public Entry(String header, String value) {
        super(header);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}//End Class
