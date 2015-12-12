package com.khaos;

import com.khaos.core.KeyBinds;
import com.khaos.core.gui.frame.TimedDisplayFrame;
import com.khaos.engine.KhaosEngine;
import com.khaos.engine.Manager;
import com.khaos.engine.gui.SplashPanel;

/**
 *
 * @author endbringer10
 * @since 20151209
 */
public class RunEngine {

    public static void main(String[] args) {
        Manager.load();
        KeyBinds.load();
        TimedDisplayFrame.invokeLater(new SplashPanel());

        KhaosEngine engine = new KhaosEngine();
        engine.start();
    }

}//End Class
