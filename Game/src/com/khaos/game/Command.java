package com.khaos.game;

import java.io.Serializable;

/**
 *
 * @author endbr
 */
public interface Command extends Serializable {

    public static final long serialVersionUID = 0L;

    public abstract Packet process(Database data);

    default void clear() {

    }

}//End Class
