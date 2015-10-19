package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import com.khaos.core.system.Messages;
import com.khaos.core.system.SysLog;

/**
 *
 * @author endbr
 */
public class CommandNotSupportedPacket extends Packet {

    @Override
    public void process(EngineHook engine) {
        SysLog.log(Messages.UNSUPPORTED_PACKET);
    }

}//End CLass
