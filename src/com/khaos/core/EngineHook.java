package com.khaos.core;

import com.khaos.core.data.GameData;

/**
 *
 * @author endbr
 */
public interface EngineHook {

    public void openLogin();

    public void openUpdate();

    public void openGame();

    public void openCharacterSelect();
    
    public GameData getGameData();

}//End CLass
