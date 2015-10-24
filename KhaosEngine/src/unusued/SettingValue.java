package unusued;

import com.khaos.core.data.entry.Meta;

/**
 *
 * @author endbringer10
 * @since 20151024
 */
public class SettingValue extends Meta {

    private String value;

    public SettingValue(NewSettings name, String value) {
        super(name.toString());
        this.value = value;
    }

    public String parseString() {
        return value;
    }

    public boolean parseBoolean() {
        return Boolean.parseBoolean(value);
    }

    public int parseInteger() {
        return Integer.parseInt(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = Boolean.toString(value);
    }

    public void setValue(int value) {
        this.value = Integer.toString(value);
    }

    public void clear() {
        this.value = "null";
    }

}//End Class
