package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;

/**
 *
 * @author endbr
 */
public class CharacterSelectPacket extends Packet {

    @Override
    public void process(EngineHook engine) {
        engine.openCharacterSelect();
    }

}//End CLass
