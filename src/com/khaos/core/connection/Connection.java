package com.khaos.core.connection;

import com.khaos.core.data.commands.Command;

/**
 *
 * @author endbr
 */
public interface Connection {

    public void start();

    public void addCommand(Command command);

}//End Class
