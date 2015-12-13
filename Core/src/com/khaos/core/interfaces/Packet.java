package com.khaos.core.interfaces;

import java.io.Serializable;

/**
 *
 * @author endbr
 * @param <E>
 */
public interface Packet<E extends EngineHooks> extends Serializable {

    public static final long serialVersionUID = 0L;

    public abstract void process(E engine);

}//End Class
