package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import com.khaos.core.data.game.CharacterData;

/**
 *
 * @author endbr
 */
public class CharacterLoadPacket extends Packet {

    private final CharacterData character;

    public CharacterLoadPacket(CharacterData character) {
        this.character = character;
    }

    @Override
    public void process(EngineHook engine) {
        engine.loadCharacter();
    }

}//End Class
