package com.khaos.core.enums.gui;

/**
 *
 * @author endbringer10
 * @since 20151025 
 */
public enum Resizeable {

    TRUE(true),
    FALSE(false);

    private final boolean resize;

    Resizeable(boolean resize) {
        this.resize = resize;
    }

    public boolean isResizeable() {
        return resize;
    }
}//End Class
