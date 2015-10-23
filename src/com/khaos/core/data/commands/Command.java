package com.khaos.core.data.commands;

import com.khaos.core.Database;
import com.khaos.core.data.packets.Packet;
import java.io.Serializable;

/**
 *
 * @author endbr
 */
public abstract class Command implements Serializable {

    private static final long serialVersionUID = 0L;

    public abstract Packet process(Database data);

    public void clear() {
        
    }

}//End Class
