package com.khaos.core.data.packets;

import com.khaos.core.gui.frame.EngineFrame;
import com.khaos.core.interfaces.EngineHook;
import com.khaos.core.interfaces.Packet;


/**
 *
 * @author endbringer10
 * @since 20151211 
 */
public class GameInitPacket implements Packet{

    @Override
    public void process(EngineHook engine) {
        EngineFrame.invokeLater(engine);
    }

}//End Class
