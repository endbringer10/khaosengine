package com.khaos.engine;

import com.khaos.core.gui.frame.Login;
import com.khaos.core.interfaces.ConnectionHook;
import com.khaos.core.interfaces.EngineHook;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public class KhaosEngine implements EngineHook {

    private ConnectionHook manager;

    public void start() {
        manager = Manager.open(this);
        manager.start();
        Login.invokeLater(this);
    }

    @Override
    public ConnectionHook getManager() {
        return manager;
    }

}//End Class
