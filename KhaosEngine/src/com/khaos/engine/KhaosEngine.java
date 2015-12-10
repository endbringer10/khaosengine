package com.khaos.engine;

import com.khaos.game.EngineHook;
import com.khaos.game.Manager;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public class KhaosEngine implements EngineHook {

    private Manager manager;

    public void start() {
        manager = Manager.open(this);
        manager.start();
    }

}//End Class
