package com.khaos.core.enums.gui;

/**
 *
 * @author endbringer10
 * @since 20151025
 */
public enum Iconifiable {

    TRUE(true),
    FALSE(false);

    private final boolean icon;

    Iconifiable(boolean icon) {
        this.icon = icon;
    }

    public boolean isIconifiable() {
        return icon;
    }

}//End Class
