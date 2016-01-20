package com.khaos;

import com.khaos.core.gui.frame.SplashFrame;
import com.khaos.engine.KhaosEngine;
import com.khaos.engine.Manager;
import zom.core.SplashPanel;

/**
 *
 * @author endbringer10
 * @since 20151209
 */
public class RunEngine {

    public static void main(String[] args) {
        Manager.loadSettings();
        SplashFrame.newInstance(new SplashPanel());

        KhaosEngine engine = new KhaosEngine();
        engine.start();
    }

}//End Class
