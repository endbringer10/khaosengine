package com.khaos.core.interfaces;

import zom.core.EngineFrame;
import zom.core.Resources;

/**
 *
 * @author endbr
 * @since 20151212
 */
public interface EngineHook {

    public Connection getConnection();

    public EngineFrame getGUI();

    public Resources getResources();

    public void openGUI();

    public void openUpdate();

    public void openLogin();

}//End Class
