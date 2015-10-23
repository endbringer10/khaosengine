package com.khaos.client;

import com.khaos.client.data.CharacterLoadPacket;
import com.khaos.client.data.CharacterSelectPacket;
import com.khaos.client.data.GameInitPacket;
import com.khaos.core.DatabaseHook;
import com.khaos.core.data.game.CharacterData;
import com.khaos.core.data.game.MapData;
import com.khaos.core.data.game.Tile;
import com.khaos.core.data.packets.LoginValidationPacket;
import com.khaos.core.data.packets.ValidLoginPacket;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author endbr
 */
public class Database implements DatabaseHook{

    public LoginValidationPacket validateLogin() {
        return new ValidLoginPacket();
    }

    public CharacterSelectPacket getCharactersList() {
        return new CharacterSelectPacket();
    }

    public CharacterLoadPacket loadCharacter() {
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

    public GameInitPacket getGui() {
        return new GameInitPacket();
    }

}//End CLass
