package com.khaos.engine.data;

import com.khaos.core.data.packets.ValidLoginPacket2;
import com.khaos.core.interfaces.DatabaseHook;
import com.khaos.core.interfaces.Packet;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public class Database implements DatabaseHook {

    @Override
    public Packet validate(String username, String password) {
        return new ValidLoginPacket2();
    }

}//End Class
