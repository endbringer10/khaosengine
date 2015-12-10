package com.khaos.game;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public abstract class Manager {

    public static Manager open(EngineHook engine) {
        try {
            return new OnlineConnection(engine);
        } catch (ServerConnectionException ex) {
            return new OfflineConnection(engine);
        }
    }

    public abstract void start();

}//End Class
