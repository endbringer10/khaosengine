package com.khaos.core.data.comm.commands;

import com.khaos.core.data.comm.Command;

/**
 *
 * @author endbr
 */
public class LoginCommand extends Command {

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

}//End Class
