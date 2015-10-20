package com.khaos.core.data.commands;

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
    public Packet process() {
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

        return new CharacterLoadPacket(new CharacterData(new Point(10, 10)), map);
    }

}//End Class
