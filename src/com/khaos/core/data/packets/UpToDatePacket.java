package com.khaos.core.data.packets;

import com.khaos.client.Game;
import com.khaos.core.EngineHook;

/**
 *
 * @author endbr
 */
public class UpToDatePacket extends Packet {

    @Override
    public void process(EngineHook engine) {
        engine.openGUI(new Game(engine.getConnection(), engine.getResources()));
    }

}//ENd CLass
