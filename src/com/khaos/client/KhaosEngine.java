package com.khaos.client;

import com.khaos.core.EngineHook;
import com.khaos.core.Localized;
import com.khaos.core.connection.Connection;
import com.khaos.core.connection.OfflineConnection;
import com.khaos.core.connection.OnlineConnection;
import com.khaos.core.data.Resources;
import com.khaos.core.exception.ServerConnectionException;
import com.khaos.core.gui.Game;
import com.khaos.core.gui.Login;
import com.khaos.core.gui.internalframe.CharacterSelect;
import com.khaos.core.gui.progress.SplashPanel;
import com.khaos.core.threads.UpdateThread;
import com.khaos.core.threads.WaitThread;

/**
 *
 * @author endbr
 */
public class KhaosEngine implements EngineHook {

    private static final String release = "00";
    private static final String beta = "00";
    private static final String patch = "16";
    public static final String VERSION = release + "." + beta + "." + patch;

    private final Resources resources = new Resources();
    private final Connection connection;
    private Game game;

    public KhaosEngine() {
        this.openSplash();
        connection = this.openConnection();
    }

    public synchronized void start() {
        connection.start();
        this.openLogin();
    }

    private synchronized Connection openConnection() {
        try {
            return new OnlineConnection(this);
        } catch (ServerConnectionException ex) {
            return new OfflineConnection(this);
        }
    }

    private synchronized void openSplash() {
        WaitThread splash = new WaitThread(new SplashPanel(), Localized.LOADING.getLocalized());
        splash.start();
    }

    @Override
    public synchronized void openLogin() {
        Login login = new Login(connection);
        login.init();
    }

    @Override
    public synchronized void openUpdate() {
        UpdateThread update = new UpdateThread(this);
        update.start();
    }

    @Override
    public synchronized void openGame() {
        game = new Game(connection, resources);
        game.init();
        game.start();
    }

    @Override
    public void openCharacterSelect() {
        game.openCharacterSelect();
    }

    @Override
    public void loadCharacter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//End Class
