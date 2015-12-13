package com.khaos.core.data.packets;

import com.khaos.core.interfaces.EngineHook;
import com.khaos.core.interfaces.Packet;

/**
 *
 * @author endbringer10
 * @since 20151211
 */
public class OpenEngineFramePacket implements Packet {

    @Override
    public void process(EngineHook engine) {
        engine.openGUI();
    }

}//End Class
