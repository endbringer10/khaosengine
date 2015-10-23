package com.khaos.client.data;

import com.khaos.core.EngineHook;
import com.khaos.client.gui.CharacterSelect;
import com.khaos.core.data.packets.Packet;

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
