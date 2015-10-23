package com.khaos.core.data.commands;

import com.khaos.core.DatabaseHook;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class LoginCommand extends Command<DatabaseHook> {

    private String username;
    private String password;

    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void clear() {
        username = "null";
        password = "null";
    }

    @Override
    public Packet process(DatabaseHook data) {
        return data.validateLogin();
    }

}//End Class
