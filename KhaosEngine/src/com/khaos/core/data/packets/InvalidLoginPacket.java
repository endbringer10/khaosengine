package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;

/**
 *
 * @author endbr
 */
public class InvalidLoginPacket extends LoginValidationPacket{

    @Override
    public void process(EngineHook engine) {
        engine.openLogin();
    }
    
}//End Class
