package com.khaos.core.system;

import com.khaos.core.Settings;
import java.util.ArrayList;

/**
 *
 * @author endbr
 */
public class SysLog {

    private static final ArrayList<String> history = new ArrayList<>();

    public synchronized static void log(Messages msg) {
        String line = "[ Log ]" + msg.getMessage();
        history.add(line);

        if (Settings.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void err(Errors code, Exception ex) {
        String line = "[Error][" + code.getNum() + "] " + code.getMessage();
        history.add(line);

        if (Settings.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void dump() {

    }

}//End Class
