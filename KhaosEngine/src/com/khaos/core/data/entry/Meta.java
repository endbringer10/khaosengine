package com.khaos.core.data.entry;

import java.util.Objects;

/**
 *
 * @author endbr
 */
public class Meta {

    private final String meta;

    public Meta(String meta) {
        this.meta = meta;
    }

    public String getMeta() {
        return meta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Meta) {
            return this.meta.equalsIgnoreCase(((Meta) obj).getMeta());
        }

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.meta);
        return hash;
    }

}//End Class
