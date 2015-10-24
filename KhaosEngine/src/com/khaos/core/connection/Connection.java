package com.khaos.core.connection;

import com.khaos.core.EngineHook;
import com.khaos.core.Localized;
import com.khaos.core.exception.ServerConnectionException;
import com.khaos.core.gui.panel.SplashPanel;
import com.khaos.core.threads.WaitThread;

/**
 *
 * @author endbr
 */
public interface Connection extends ConnectionHook {

    public void start();

    public static Connection open(EngineHook engine) {
        WaitThread splash = new WaitThread(new SplashPanel(), Localized.LOADING.getLocalized());
        splash.start();

        try {
            return new OnlineConnection(engine);
        } catch (ServerConnectionException ex) {
            return new OfflineConnection(engine);
        }
    }

}//End Class
