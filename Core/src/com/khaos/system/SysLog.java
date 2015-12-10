package com.khaos.system;

import com.khaos.SettingsCore;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public class SysLog {

    //private static JTextArea console = new ConsoleTextArea();
    public synchronized static void log(IMessages msg) {
        String line = "[ Log ]" + msg.getMessage();
        //console.append(line);

        if (SettingsCore.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void log(String msg) {
        String line = "[ Log ]" + msg;
        //console.append(line);

        if (SettingsCore.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void err(IErrors code, Exception ex) {
        String line = "[Error][" + code.getCode() + "] " + code.getMessage();
        //console.append(line);

        if (SettingsCore.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    /*public static JTextArea getConsole() {
     return console;
     }*/
}//End Class
