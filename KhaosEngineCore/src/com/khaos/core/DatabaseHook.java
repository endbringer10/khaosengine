package com.khaos.core;

import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public interface DatabaseHook {

    public Packet getGui();

    public Packet validateLogin();

    //public Packet loadCharacter();

    //public Packet getCharactersList();
    
}
