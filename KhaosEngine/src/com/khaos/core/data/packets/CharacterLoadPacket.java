package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import com.khaos.core.data.game.CharacterData;
import com.khaos.core.data.game.GameData;
import com.khaos.core.data.game.MapData;

/**
 *
 * @author endbr
 */
public class CharacterLoadPacket implements Packet {

    private final CharacterData character;
    private final MapData map;

    public CharacterLoadPacket(CharacterData character, MapData map) {
        this.character = character;
        this.map = map;
    }

    @Override
    public void process(EngineHook engine) {
        GameData data = engine.getGuiData();
        data.update(character);
        data.update(map);
        data.repaint();
        engine.getGUI().addKeyBinds();
    }

}//End Class
