package com.khaos.game;

import com.khaos.game.EngineHook;
import java.io.Serializable;

/**
 *
 * @author endbr
 */
public interface Packet extends Serializable {

    public static final long serialVersionUID = 0L;

    public abstract void process(EngineHook engine);

}//End Class
