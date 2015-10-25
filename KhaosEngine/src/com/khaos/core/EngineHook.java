package com.khaos.core;

import com.khaos.core.connection.Connection;
import com.khaos.core.data.Resources;
import com.khaos.core.gui.EngineGUI;

/**
 *
 * @author endbr
 */
public interface EngineHook {

    public Connection getConnection();

    public Resources getResources();

    public EngineGUI getGUI();

    public void openLogin();

    public void openUpdate();

    public void openGUI(EngineGUI gui);

}//End CLass
