package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import com.khaos.core.gui.frame.Game;

/**
 *
 * @author endbr
 */
public class GameInitPacket implements Packet {

    @Override
    public void process(EngineHook engine) {
        engine.openGUI(new Game(engine));
    }

}//End Class
