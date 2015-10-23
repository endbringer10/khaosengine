package com.khaos.core.data.commands;

import com.khaos.core.Database;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class CharacterSelectCommand extends Command {

    @Override
    public Packet process(Database data) {
        return data.getCharactersList();
    }

}//End Class
