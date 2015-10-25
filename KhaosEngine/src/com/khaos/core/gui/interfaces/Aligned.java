package com.khaos.core.gui.interfaces;

import com.khaos.core.gui.enums.Layer;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public interface Aligned {

    default public void init2() {
        this.align2();
    }

    public void align2();

    default public int getPreferredLayer2() {
        return Layer.INTERNALFRAME.getLayer();
    }

}//End Class
