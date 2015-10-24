package com.khaos.core;

import com.khaos.core.data.Direction;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 * @idea: public <E extends Packet> Packet validateLogin();
 */
public interface DatabaseHook {

    public Packet getGui();

    public Packet validateLogin();
    
    public Packet move(Direction d);

}
