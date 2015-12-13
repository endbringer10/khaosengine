package com.khaos.engine;

import com.khaos.core.gui.frame.LoginFrame;
import com.khaos.core.interfaces.Command;
import com.khaos.core.interfaces.Connection;
import com.khaos.core.interfaces.ConnectionHook;
import com.khaos.core.interfaces.GuiHook;
import com.khaos.core.interfaces.ResourceHook;
import zom.core.EngineFrame;
import zom.core.Resources;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public class KhaosEngine implements ConnectionHook, GuiHook, ResourceHook {

    private final Resources resources = new Resources();
    private Connection connection;
    private EngineFrame gui;

    public void start() {
        connection = Manager.open(this);
        connection.start();
        LoginFrame.newInstance(this);
    }

    @Override
    public void openGUI(EngineFrame gui) {
        this.gui = gui;
    }

    @Override
    public void sendCommand(Command command) {
        connection.send(command);
    }

}//End Class
