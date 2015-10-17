package com.khaos.core.connection;

import com.khaos.core.data.comm.Command;
import com.khaos.core.data.comm.Packet;

/**
 *
 * @author endbr
 */
public interface ConnectionHook {

    public void process(Packet packet);

}
