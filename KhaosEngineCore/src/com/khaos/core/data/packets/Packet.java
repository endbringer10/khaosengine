package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import java.io.Serializable;

/**
 *
 * @author endbr
 */
public interface Packet extends Serializable {

    public static final long serialVersionUID = 0L;

    public abstract void process(EngineHook engine);

}//End Class
