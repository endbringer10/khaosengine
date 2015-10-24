package com.khaos.client.data;

import com.khaos.client.data.packets.CharacterLoadPacket;
import com.khaos.client.data.packets.CharacterSelectPacket;
import com.khaos.client.data.packets.GameInitPacket;
import com.khaos.core.DatabaseHook;
import com.khaos.core.data.Direction;
import com.khaos.core.data.game.CharacterData;
import com.khaos.core.data.game.MapData;
import com.khaos.core.data.game.Tile;
import com.khaos.core.data.packets.Packet;
import com.khaos.core.data.packets.ValidLoginPacket;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author endbr
 */
public class Database implements DatabaseHook {

    @Override
    public Packet validateLogin() {
        return new ValidLoginPacket();
    }

    public Packet getCharactersList() {
        return new CharacterSelectPacket();
    }

    public Packet loadCharacter() {
        MapData map = new MapData();

        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                Random ran = new Random();
                int type = ran.nextInt(7) + 1;
                if (type == 1 || type == 2 || type == 3) {
                    map.add(x, y, new Tile("terrain\\grass.png"));
                } else if (type == 4 || type == 5) {
                    map.add(x, y, new Tile("terrain\\dirt.png"));
                } else if (type == 6) {
                    map.add(x, y, new Tile("terrain\\stone.png"));
                } else {
                    map.add(x, y, new Tile("terrain\\water.png"));
                }
            }
        }

        return new CharacterLoadPacket(new CharacterData(new Point(10, 10), "character.png"), map);
    }

    @Override
    public Packet getGui() {
        return new GameInitPacket();
    }

    @Override
    public Packet move(Direction d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//End CLass
