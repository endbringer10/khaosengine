package com.khaos.core.data.commands;

import com.khaos.core.data.packets.OpenEngineFramePacket;
import com.khaos.core.interfaces.Command;
import com.khaos.core.interfaces.DatabaseHook;
import com.khaos.core.interfaces.Packet;

/**
 *
 * @author endbr
 */
public class OpenEngineFrameCommand implements Command {

    @Override
    public Packet process(DatabaseHook data) {
        return new OpenEngineFramePacket();
    }

}//End Class
