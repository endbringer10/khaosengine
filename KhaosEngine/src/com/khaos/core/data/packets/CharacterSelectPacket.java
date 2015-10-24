package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import com.khaos.core.gui.internalframe.CharacterSelect;

/**
 *
 * @author endbr
 */
public class CharacterSelectPacket implements Packet {

    @Override
    public void process(EngineHook engine) {
        CharacterSelect select = new CharacterSelect(engine);
        engine.getGUI().openInternalFrame(select);
        select.init();
    }

}//End CLass
