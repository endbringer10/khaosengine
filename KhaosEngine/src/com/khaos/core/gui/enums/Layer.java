package com.khaos.core.gui.enums;

/**
 *
 * @author endbr
 */
public enum Layer {

    BOTTOM(0),
    TILE(1),
    PLAYER(99),
    INTERNALFRAME(100);

    private final int layer;

    Layer(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return layer;
    }

}//End Class
