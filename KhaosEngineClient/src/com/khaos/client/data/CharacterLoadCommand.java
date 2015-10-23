package com.khaos.client.data;

import com.khaos.client.Database;
import com.khaos.core.data.commands.Command;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class CharacterLoadCommand extends Command<Database> {

    public Packet process(Database data) {
       return data.loadCharacter();
    }

}//End Class
