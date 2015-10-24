package com.khaos.core.data.game;

import com.khaos.core.data.Direction;
import java.awt.Point;

/**
 *
 * @author endbr
 */
public class CharacterData {

    private Point coord;
    private String texture;
    private int speed = 100;

    public CharacterData(Point coord, String texture, int speed) {
        this.coord = coord;
        this.texture = texture;
        this.speed = speed;
    }

    public void move(Direction d) {
        if (d == Direction.UP) {
            coord.setLocation(coord.x, coord.y - 1);
        } else if (d == Direction.DOWN) {
            coord.setLocation(coord.x, coord.y + 1);
        } else if (d == Direction.LEFT) {
            coord.setLocation(coord.x - 1, coord.y);
        } else if (d == Direction.RIGHT) {
            coord.setLocation(coord.x + 1, coord.y);
        }
    }

    public String getTexture() {
        return texture;
    }

    public int getSpeed() {
        return speed;
    }

    public Point getCoord() {
        return coord;
    }

}//End Class
