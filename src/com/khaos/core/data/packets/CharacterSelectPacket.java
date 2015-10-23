package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import com.khaos.core.gui.internalframe.CharacterSelect;

/**
 *
 * @author endbr
 */
public class CharacterSelectPacket extends Packet {

    @Override
    public void process(EngineHook engine) {
        CharacterSelect select = new CharacterSelect(engine.getConnection());
        engine.getGUI().openInternalFrame(select);
        select.init();
    }

}//End CLass
