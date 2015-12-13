package com.khaos.core.data.packets;

import com.khaos.core.interfaces.GuiHook;
import com.khaos.core.interfaces.Packet;
import zom.core.EngineFrame;

/**
 *
 * @author endbringer10
 * @since 20151211
 */
public class GameInitPacket implements Packet<GuiHook> {

    @Override
    public void process(GuiHook engine) {
        EngineFrame.invokeLater(engine);
    }

}//End Class
