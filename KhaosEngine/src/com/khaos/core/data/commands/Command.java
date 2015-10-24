package com.khaos.core.data.commands;

import com.khaos.core.DatabaseHook;
import com.khaos.core.data.packets.Packet;
import java.io.Serializable;

/**
 *
 * @author endbr
 * @idea: public abstract <E extends DatabaseHook> Packet process(E data);
 */
public interface Command extends Serializable {

    public static final long serialVersionUID = 0L;

    public abstract Packet process(DatabaseHook data);

    default void clear() {

    }

}//End Class
