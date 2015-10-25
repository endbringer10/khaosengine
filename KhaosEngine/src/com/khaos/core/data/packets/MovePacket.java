package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import com.khaos.core.data.game.CharacterData;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public class MovePacket implements Packet {

    private final CharacterData character;

    public MovePacket(CharacterData character) {
        this.character = character;
    }

    @Override
    public void process(EngineHook engine) {
        engine.getGUI().getData().update(character);
        //engine.getGuiData().repaint();
    }

}//End Class
