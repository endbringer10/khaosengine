package com.khaos.core.data.commands;

import com.khaos.core.data.packets.CharacterSelectPacket;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class CharacterSelectCommand extends Command {

    @Override
    public Packet process() {
        return new CharacterSelectPacket();
    }

}//End Class
