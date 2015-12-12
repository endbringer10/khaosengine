package com.khaos.core.data.packets;

import com.khaos.core.gui.frame.UpdateFrame;
import com.khaos.core.interfaces.EngineHook;
import com.khaos.core.interfaces.Packet;

/**
 *
 * @author endbringer10
 * @since 20151211
 */
public class ValidLoginPacket2 implements Packet {
    
    @Override
    public void process(EngineHook engine) {
        UpdateFrame.invokeLater(engine);
    }
    
}//End Class
