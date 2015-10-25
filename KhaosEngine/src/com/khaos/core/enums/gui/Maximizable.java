package com.khaos.core.enums.gui;

/**
 *
 * @author endbringer10
 * @since 20151025 
 */
public enum Maximizable {
    
    TRUE(true),
    FALSE(false);

    private final boolean max;

    Maximizable(boolean max) {
        this.max = max;
    }

    public boolean isMaximizable() {
        return max;
    }

}//End Class
