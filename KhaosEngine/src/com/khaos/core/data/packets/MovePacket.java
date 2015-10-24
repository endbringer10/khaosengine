package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public class MovePacket implements Packet {

    @Override
    public void process(EngineHook engine) {
        //engine.getGuiData().update(character);
        System.out.println("Moved");
    }

}//End Class
