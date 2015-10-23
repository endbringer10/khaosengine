package com.khaos.core.data.commands;

import com.khaos.core.Database;
import com.khaos.core.data.game.CharacterData;
import com.khaos.core.data.game.MapData;
import com.khaos.core.data.game.Tile;
import com.khaos.core.data.packets.CharacterLoadPacket;
import com.khaos.core.data.packets.Packet;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author endbr
 */
public class CharacterLoadCommand extends Command {

    @Override
    public Packet process(Database data) {
        return data.loadCharacter();
    }

}//End Class
