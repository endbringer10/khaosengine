package com.khaos.core.gui.interfaces;

import com.khaos.core.gui.Layer;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public interface Aligned {

    default public void init() {
        this.align();
    }

    public void align();

    default public int getPreferredLayer() {
        return Layer.INTERNALFRAME.getLayer();
    }

}//End Class
