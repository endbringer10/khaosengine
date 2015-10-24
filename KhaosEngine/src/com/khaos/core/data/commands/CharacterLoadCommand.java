package com.khaos.core.data.commands;

import com.khaos.core.DatabaseHook;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class CharacterLoadCommand implements Command {

    @Override
    public Packet process(DatabaseHook data) {
        return data.loadCharacter();
    }

}//End Class
