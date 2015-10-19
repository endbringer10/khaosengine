package com.khaos.core.data.commands;

import com.khaos.core.data.game.CharacterData;
import com.khaos.core.data.packets.CharacterLoadPacket;
import com.khaos.core.data.packets.Packet;
import java.awt.Point;

/**
 *
 * @author endbr
 */
public class CharacterLoadCommand extends Command {

    @Override
    public Packet process() {
        return new CharacterLoadPacket(new CharacterData(new Point(10, 10)));
    }

}//End Class
