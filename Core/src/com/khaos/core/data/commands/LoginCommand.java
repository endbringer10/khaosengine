package com.khaos.core.data.commands;

import com.khaos.core.interfaces.Command;
import com.khaos.core.interfaces.DatabaseHook;
import com.khaos.core.interfaces.Packet;

/**
 *
 * @author endbr
 */
public class LoginCommand implements Command {

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
        return data.validate(username, password);
    }

}//End Class
