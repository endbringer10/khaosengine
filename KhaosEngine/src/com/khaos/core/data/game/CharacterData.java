package com.khaos.core.data.game;

import java.awt.Point;

/**
 *
 * @author endbr
 */
public class CharacterData {

    private Point coor;
    private String texture;

    public CharacterData(Point coor, String texture) {
        this.coor = coor;
        this.texture = texture;
    }

    public String getTexture() {
        return texture;
    }

}//End Class
