package unusued;

import com.khaos.core.data.UniqueArray;
import com.khaos.core.data.entry.SettingEntry;
import com.khaos.core.file.FileSystem;
import com.khaos.core.file.builder.SettingBuilder;
import com.khaos.core.file.dFile;
import com.khaos.core.system.Errors;
import com.khaos.core.system.Messages;
import com.khaos.core.system.SysLog;
import java.io.IOException;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public enum NewSettings {

    AUTO_LOGIN,
    DEBUG,
    USERNAME,
    PASSWORD,
    HOST_IP,
    HOST_PORT,
    NIMBUS,
    SCREEN_WIDTH,
    SCREEN_HEIGHT;

    private static UniqueArray<SettingValue> list = new UniqueArray<>();

    public static void load() {
        dFile file = FileSystem.FILE_USER_SETTINGS.getFile();
        try {
            SettingBuilder builder = new SettingBuilder(file);

            SettingEntry next;
            while ((next = builder.next()) != null) {
                try {
                    NewSettings.valueOf(next.getMeta());
                    list.add(new SettingValue(NewSettings.valueOf(next.getMeta()), next.getValue()));
                } catch (IllegalArgumentException ex) {
                    SysLog.err(Errors.ENUM_DOES_NOT_EXIST, ex);
                }
            }
        } catch (IOException ex) {
            SysLog.log(Messages.NO_SETTINGS_FILE);
            //Settings.generate();
        }

        //Settings.lookAndFeel();
    }

    public void setValue(String value) {
        list.get(list.indexOf(this.toString())).setValue(value);
    }

    public void setValue(boolean value) {
        list.get(list.indexOf(this.toString())).setValue(value);
    }

    public void setValue(int value) {
        list.get(list.indexOf(this.toString())).setValue(value);
    }

    public String parseString() {
        return list.get(list.indexOf(this.toString())).parseString();
    }

    public boolean parseBoolean() {
        return list.get(list.indexOf(this.toString())).parseBoolean();
    }

    public int parseInteger() {
        return list.get(list.indexOf(this.toString())).parseInteger();
    }

}//End Class
