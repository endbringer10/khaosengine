package com.khaos.core.gui.enums;

/**
 *
 * @author endbr
 * @since 20151213
 */
public enum Resizeable {

    TRUE(true), FALSE(false);

    private final boolean resize;

    Resizeable(boolean resize) {
        this.resize = resize;
    }

    public boolean isResizeable() {
        return resize;
    }

}//End Class
