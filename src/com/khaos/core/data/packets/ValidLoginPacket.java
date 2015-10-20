package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;

/**
 *
 * @author endbr
 */
public class ValidLoginPacket extends LoginValidationPacket{

    @Override
    public void process(EngineHook engine) {
        engine.openUpdate();
    }
    
}//End Class
