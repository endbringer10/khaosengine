package com.khaos.core.interfaces;

import java.io.Serializable;

/**
 *
 * @author endbr
 * @param <E>
 */
public interface Packet<E extends EngineHook> extends Serializable {

    public static final long serialVersionUID = 0L;

    public abstract void process(E engine);

}//End Class
