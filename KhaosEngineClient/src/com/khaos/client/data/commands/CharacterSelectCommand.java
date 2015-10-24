package com.khaos.client.data.commands;

import com.khaos.client.data.Database;
import com.khaos.core.DatabaseHook;
import com.khaos.core.data.commands.Command;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class CharacterSelectCommand implements Command {

    @Override
    public Packet process(DatabaseHook data) {
        return ((Database) data).getCharactersList();
    }

}//End Class
