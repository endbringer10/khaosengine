package com.khaos.client.data;

import com.khaos.client.Game;
import com.khaos.core.EngineHook;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class GameInitPacket extends Packet {

    @Override
    public void process(EngineHook engine) {
        engine.openGUI(new Game(engine.getConnection(), engine.getResources()));
    }

}//End Class
