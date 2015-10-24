package com.khaos;

import com.khaos.core.KhaosEngine;
import com.khaos.core.Settings;

/**
 *
 * @author endbr
 */
public class RunClient {

    public static void main(String[] args) {
        Settings.load();

        //WaitThread splash = new WaitThread(new SplashPanel(), Localized.LOADING.getLocalized());
        //splash.start();
        KhaosEngine engine = new KhaosEngine();
        engine.start();
    }

}//End Class
