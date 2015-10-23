package com.khaos.core.data.commands;

import com.khaos.core.DatabaseHook;
import com.khaos.core.data.packets.Packet;
import java.io.Serializable;

/**
 *
 * @author endbr
 */
public abstract class Command<E extends DatabaseHook> implements Serializable {

    private static final long serialVersionUID = 0L;

    public abstract Packet process(E data);

    public void clear() {

    }

}//End Class
