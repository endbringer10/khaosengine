package com.khaos.core.system;

import com.khaos.core.Settings;
import javax.swing.JTextArea;

/**
 *
 * @author endbr
 * @idea append text file
 * @idea backup log file (.bak)
 */
public class SysLog {

    private static JTextArea console = new ConsoleTextArea();

    public synchronized static void log(Messages msg) {
        String line = "[ Log ]" + msg.getMessage();
        console.append(line);

        if (Settings.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void log(String msg) {
        String line = "[ Log ]" + msg;
        console.append(line);

        if (Settings.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void err(Errors code, Exception ex) {
        String line = "[Error][" + code.getCode() + "] " + code.getMessage();
        console.append(line);

        if (Settings.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void dump() {

    }

    public static void setOut(JTextArea area) {
        console = area;
    }

    /**
     * @deprecated
     */
    public static JTextArea getConsole() {
        return console;
    }

}//End Class
