package com.khaos.system;

import zom.core.Settings;

/**
 *
 * @author endbringer10
 * @since 20151207
 */
public class SysLog {

    //private static JTextArea console = new ConsoleTextArea();
    public synchronized static void log(Messages msg) {
        String line = "[ Log ]" + msg.getMessage();
        //console.append(line);

        if (Settings.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void log(String msg) {
        String line = "[ Log ]" + msg;
        //console.append(line);

        if (Settings.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    public synchronized static void err(Errors code, Exception ex) {
        String line = "[Error][" + code.getCode() + "] " + code.getMessage();
        //console.append(line);

        if (Settings.DEBUG.parseBoolean()) {
            System.out.println(line);
        }
    }

    /*public static JTextArea getConsole() {
     return console;
     }*/
}//End Class
