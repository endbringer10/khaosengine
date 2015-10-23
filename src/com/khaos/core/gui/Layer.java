package com.khaos.core.gui;

/**
 *
 * @author endbr
 */
public enum Layer {

    BOTTOM(0),
    TILE(1),
    CHARACTER(99);

    private final int layer;

    Layer(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return layer;
    }

    /**
     *
     * @param y objects y coordinate on the screen
     * @return a lower number the lower on the screen (higher y coordinate) the object is
     */
    public static int getPosition(int x, int y) {
        return 10000 - y + x;
    }

}//End Class
