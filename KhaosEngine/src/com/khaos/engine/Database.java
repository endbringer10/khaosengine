package com.khaos.engine;

import com.khaos.core.interfaces.DatabaseHook;
import com.khaos.core.interfaces.Packet;

/**
 *
 * @author endbringer10
 * @since 20151208
 */
public class Database implements DatabaseHook {

    @Override
    public Packet validate(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//End Class
