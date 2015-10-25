package com.khaos.core;

import com.khaos.core.enums.Direction;
import com.khaos.core.data.game.CharacterData;
import com.khaos.core.data.game.MapData;
import com.khaos.core.data.game.Tile;
import com.khaos.core.data.packets.CharacterLoadPacket;
import com.khaos.core.data.packets.CharacterSelectPacket;
import com.khaos.core.data.packets.MovePacket;
import com.khaos.core.data.packets.Packet;
import com.khaos.core.data.packets.ValidLoginPacket;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author endbr
 * @idea: public <E extends Packet> Packet validateLogin();
 */
public class DatabaseHook {

    private CharacterData character;

    public DatabaseHook() {
        character = new CharacterData(new Point(10, 10), "character.png", 100);
    }

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

        return new CharacterLoadPacket(character, map);
    }

    public Packet move(Direction d) {
        character.move(d);
        return new MovePacket(character);
    }

}//End Class
