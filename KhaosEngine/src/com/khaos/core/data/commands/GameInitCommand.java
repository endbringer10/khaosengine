package com.khaos.core.data.commands;

import com.khaos.core.DatabaseHook;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class GameInitCommand implements Command{

    @Override
    public Packet process(DatabaseHook data) {
        return data.getGui();
    }
    
    
}//End CLass
