package com.khaos.core.connection;

import com.khaos.core.data.commands.Command;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public interface ConnectionHook {

    public void process(Packet packet);

}
