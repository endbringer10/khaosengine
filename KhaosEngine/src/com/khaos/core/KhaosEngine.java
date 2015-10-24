package com.khaos.core;

import com.khaos.core.connection.Connection;
import com.khaos.core.data.Resources;
import com.khaos.core.data.game.GameData;
import com.khaos.core.gui.EngineGUI;
import com.khaos.core.gui.frame.Login;
import com.khaos.core.threads.UpdateThread;

/**
 *
 * @author endbr
 */
public class KhaosEngine implements EngineHook {

    private static final String release = "00";
    private static final String beta = "00";
    private static final String patch = "20151023";
    public static final String VERSION = release + "." + beta + "." + patch;

    private final Resources resources = new Resources();
    private Connection connection;
    private EngineGUI gui;

    public synchronized void start() {
        connection = Connection.open(this);
        connection.start();
        this.openLogin();
    }

    @Override
    public synchronized void openLogin() {
        Login login = new Login(this);
        login.init();
    }

    @Override
    public synchronized void openUpdate() {
        UpdateThread update = new UpdateThread(this);
        update.start();
    }

    @Override
    public synchronized void openGUI(EngineGUI gui) {
        this.gui = gui;
        gui.init();
        gui.start();
    }

    @Override
    public synchronized GameData getGuiData() {
        return gui.getGuiData();
    }

    @Override
    public EngineGUI getGUI() {
        return this.gui;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public Resources getResources() {
        return this.resources;
    }

}//End Class
