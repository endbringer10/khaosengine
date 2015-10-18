package com.khaos.client;

import com.khaos.core.Localized;
import com.khaos.core.connection.Connection;
import com.khaos.core.connection.ConnectionHook;
import com.khaos.core.connection.OfflineConnection;
import com.khaos.core.connection.OnlineConnection;
import com.khaos.core.data.packets.Packet;
import com.khaos.core.data.Resources;
import com.khaos.core.data.packets.UpToDatePacket;
import com.khaos.core.data.packets.ValidLoginPacket;
import com.khaos.core.exception.ServerConnectionException;
import com.khaos.core.gui.Game;
import com.khaos.core.gui.Login;
import com.khaos.core.gui.progress.SplashPanel;
import com.khaos.core.system.Messages;
import com.khaos.core.system.SysLog;
import com.khaos.core.threads.UpdateThread;
import com.khaos.core.threads.WaitThread;

/**
 *
 * @author endbr
 */
public class KhaosEngine implements ConnectionHook {

    private static final String release = "00";
    private static final String beta = "00";
    private static final String patch = "16";
    public static final String VERSION = release + "." + beta + "." + patch;

    private final Resources resources = new Resources();
    private final Connection connection;

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

    private synchronized void openLogin() {
        Login login = new Login(connection);
        login.init();
    }

    private synchronized void openUpdate() {
        UpdateThread update = new UpdateThread(this);
        update.start();
    }

    private synchronized void openGame() {
        Game game = new Game(connection, resources);
        game.init();
        game.start();
    }

    @Override
    public synchronized void process(Packet packet) {
        if (packet instanceof ValidLoginPacket) {
            this.openUpdate();
        } else if (packet instanceof UpToDatePacket) {
            this.openGame();
        } else {
            SysLog.log(Messages.UNSUPPORTED_PACKET);
        }
    }

}//End Class
