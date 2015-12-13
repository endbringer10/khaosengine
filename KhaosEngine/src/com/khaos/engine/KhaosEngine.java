package com.khaos.engine;

import com.khaos.core.gui.frame.LoginFrame;
import com.khaos.core.gui.frame.UpdateFrame;
import com.khaos.core.interfaces.Connection;
import com.khaos.core.interfaces.EngineHook;
import zom.core.EngineFrame;
import zom.core.Resources;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public class KhaosEngine implements EngineHook {

    public static final String VERSION = "20151213";

    private final Resources resources = new Resources();
    private Connection connection;
    private EngineFrame gui;

    public void start() {
        connection = Manager.open(this);
        connection.start();
        this.openLogin();
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public EngineFrame getGUI() {
        return gui;
    }

    @Override
    public Resources getResources() {
        return resources;
    }

    @Override
    public void openGUI() {
        this.gui = EngineFrame.newInstance(this);
        gui.start();
    }

    @Override
    public void openUpdate() {
        UpdateFrame.newInstance(this);
    }

    @Override
    public void openLogin() {
        LoginFrame.newInstance(this);
    }

}//End Class
