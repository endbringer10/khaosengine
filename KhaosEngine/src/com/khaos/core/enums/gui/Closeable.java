package com.khaos.core.enums.gui;

/**
 *
 * @author endbringer10
 * @since 20151025
 */
public enum Closeable {

    TRUE(true),
    FALSE(false);

    private final boolean close;

    Closeable(boolean close) {
        this.close = close;
    }

    public boolean isCloseable() {
        return close;
    }
}//End Class
