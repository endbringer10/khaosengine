package com.khaos.core.data.comm;

import java.io.Serializable;

/**
 *
 * @author endbr
 */
public abstract class Command implements Serializable {

    private static final long serialVersionUID = 0L;

    public void clear() {
        //Do nothing
        //placeholder for commands with secure data which will override this
    }

}//End Class
