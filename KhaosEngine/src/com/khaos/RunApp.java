package com.khaos;

import com.khaos.core.KhaosEngine;
import com.khaos.core.Settings;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public class RunApp {

    public static void main(String args[]) {
        Settings.load();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhaosEngine engine = new KhaosEngine();
                engine.start();
            }
        });
    }

}//End Class
