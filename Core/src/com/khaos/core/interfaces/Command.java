package com.khaos.core.interfaces;

import java.io.Serializable;

/**
 *
 * @author endbr
 * @param <E>
 */
public interface Command<E extends DatabaseHook> extends Serializable {

    public static final long serialVersionUID = 0L;

    public Packet process(E data);

    default void clear() {

    }

}//End Class
