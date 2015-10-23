package com.khaos.core.data.commands;

import com.khaos.core.Database;
import com.khaos.core.data.packets.Packet;
import com.khaos.core.data.packets.ValidLoginPacket;

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

    @Override
    public Packet process(Database data) {
        return data.validateLogin();
    }

}//End Class
