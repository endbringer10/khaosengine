package com.khaos;

import com.khaos.core.TimedDisplayFrame;
import com.khaos.engine.KhaosEngine;
import com.khaos.engine.SettingsManager;
import com.khaos.engine.SplashPanel;

/**
 *
 * @author endbringer10
 * @since 20151209
 */
public class RunEngine {

    public static void main(String[] args) {
        SettingsManager.load();

        TimedDisplayFrame.invokeLater(new SplashPanel());

        KhaosEngine engine = new KhaosEngine();
        engine.start();

    }

}//End Class
