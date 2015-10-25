package com.khaos.core.enums;

import com.khaos.core.data.entry.KeyBindsEntry;
import com.khaos.core.file.FileSystem;
import com.khaos.core.file.FileTypes;
import com.khaos.core.file.FileWriter;
import com.khaos.core.file.builder.KeyBindsBuilder;
import com.khaos.core.file.dFile;
import com.khaos.core.system.Errors;
import com.khaos.core.system.Messages;
import com.khaos.core.system.SysLog;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.KeyStroke;

/**
 *
 * @author endbr
 */
public enum KeyBinds {

    UP(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Move Up"),
    DOWN(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Move Down"),
    LEFT(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Move Left"),
    RIGHT(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Move Right"),
    CLOSE(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Close Window");

    private KeyStroke key;
    private final String action;

    KeyBinds(KeyStroke key, String action) {
        this.key = key;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public KeyStroke getKey() {
        return key;
    }

    public void setKey(KeyStroke key) {
        this.key = key;
    }

    public static void load() {
        dFile file = FileSystem.FILE_USER_KEYBINDS.getFile();
        try {
            KeyBindsBuilder builder = new KeyBindsBuilder(file);

            KeyBindsEntry next;
            while ((next = builder.next()) != null) {
                try {
                    KeyBinds.valueOf(next.getMeta()).setKey(next.getKey());
                } catch (IllegalArgumentException ex) {
                    SysLog.err(Errors.ENUM_DOES_NOT_EXIST, ex);
                }
            }
        } catch (IOException ex) {
            SysLog.log(Messages.NO_KEYBINDS_FILE);
            KeyBinds.generate();
        }
    }

    public static void save() {
        KeyBinds.generate();
    }

    private static void generate() {
        FileWriter writer = new FileWriter(FileSystem.FILE_USER_KEYBINDS, FileTypes.KEYBINDS);
        writer.cache(UP);
        writer.cache(DOWN);
        writer.cache(LEFT);
        writer.cache(RIGHT);
        writer.cache(CLOSE);
        writer.print();
    }

}//End Class
