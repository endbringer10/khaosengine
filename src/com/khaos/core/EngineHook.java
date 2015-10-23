package com.khaos.core;

import com.khaos.core.connection.Connection;
import com.khaos.core.data.GameData;
import com.khaos.core.data.Resources;
import newclass.EngineGUI;

/**
 *
 * @author endbr
 */
public interface EngineHook {

    public Connection getConnection();

    public Resources getResources();

    public EngineGUI getGUI();

    public GameData getGuiData();

    public void openLogin();

    public void openUpdate();

    public void openGUI(EngineGUI gui);

}//End CLass
