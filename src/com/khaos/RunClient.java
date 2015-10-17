package com.khaos;

import com.khaos.client.KhaosEngine;
import com.khaos.core.Localized;
import com.khaos.core.Settings;
import com.khaos.core.gui.progress.SplashPanel;
import com.khaos.core.threads.WaitThread;

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
