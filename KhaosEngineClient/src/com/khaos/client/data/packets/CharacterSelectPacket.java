package com.khaos.client.data.packets;

import com.khaos.client.gui.CharacterSelect;
import com.khaos.core.EngineHook;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class CharacterSelectPacket implements Packet {

    @Override
    public void process(EngineHook engine) {
        CharacterSelect select = new CharacterSelect(engine.getConnection());
        engine.getGUI().openInternalFrame(select);
        select.init();
    }

}//End CLass
