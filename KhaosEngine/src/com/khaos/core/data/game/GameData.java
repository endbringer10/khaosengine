package com.khaos.core.data.game;

import com.khaos.core.data.Resources;
import com.khaos.core.gui.gamevisuals.CharacterPanel;

/**
 *
 * @author endbr
 */
public class GameData {

    private final DisplayGrid grid;
    private final CharacterPanel me;
    private final Resources resources;
    private MapData map;
    private CharacterData character;

    public GameData(Resources resources, DisplayGrid grid, CharacterPanel character) {
        this.resources = resources;
        this.grid = grid;
        this.me = character;
    }

    private void updateGrid() {
        for (int x = 0; x < grid.getColumns(); x++) {
            for (int y = 0; y < grid.getRows(); y++) {
                Tile temp = map.get(x, y);
                grid.update(x, y, resources.getTexture(temp.getTexture()));
            }
        }
    }

    public synchronized void update(CharacterData data) {
        this.character = data;
        me.update(resources.getTexture(character.getTexture()), data.getCoord());
    }

    public synchronized void update(MapData data) {
        this.map = data;
        this.updateGrid();
    }

    public synchronized void repaint() {
        me.repaint();
        grid.repaint();
    }

    public int getCharacterSpeed() {
        return character.getSpeed();
    }

}//End Class
