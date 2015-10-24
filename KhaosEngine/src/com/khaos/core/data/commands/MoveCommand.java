package com.khaos.core.data.commands;

import com.khaos.core.DatabaseHook;
import com.khaos.core.data.Direction;
import com.khaos.core.data.packets.Packet;

/**
 *
 * @author endbr
 */
public class MoveCommand implements Command {

    private final Direction direction;

    public MoveCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Packet process(DatabaseHook data) {
        return data.move(Direction.UP);
    }

}//End Class
