package com.khaos.core.data.packets;

import com.khaos.core.EngineHook;
import com.khaos.core.enums.Localized;
import com.khaos.core.gui.internalframe.PanelHolder;
import com.khaos.core.gui.panel.CharacterSelectPanel;

/**
 *
 * @author endbr
 */
public class CharacterSelectPacket implements Packet {

    @Override
    public void process(EngineHook engine) {
        PanelHolder select = new PanelHolder(Localized.CHARACTER_SELECT.getLocalized());
        engine.getGUI().openInternalFrame(select);
        select.addCustom(new CharacterSelectPanel(engine, select));

        //PanelHolder settings = new KeyBoundFrame(Localized.SETTINGS.getLocalized());
        //engine.getGUI().openInternalFrame(settings);
        //settings.add(new SettingsEditorPanel(engine, settings));
    }

}//End CLass
