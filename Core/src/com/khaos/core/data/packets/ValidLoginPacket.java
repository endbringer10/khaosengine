package com.khaos.core.data.packets;

import com.khaos.core.gui.frame.UpdateFrame;
import com.khaos.core.interfaces.GuiHook;
import com.khaos.core.interfaces.Packet;

/**
 *
 * @author endbringer10
 * @since 20151211
 */
public class ValidLoginPacket implements Packet<GuiHook> {

    @Override
    public void process(GuiHook engine) {
        UpdateFrame.newInstance(engine);
    }

}//End Class
