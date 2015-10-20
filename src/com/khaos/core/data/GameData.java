package com.khaos.core.data;

import com.khaos.core.data.game.CharacterData;
import com.khaos.core.data.game.MapData;
import com.khaos.core.data.game.Tile;
import com.khaos.core.gui.panel.TilePanel;

/**
 *
 * @author endbr
 */
public class GameData {

    private final Array2D<TilePanel> grid;
    private final Resources resources;
    private MapData map;
    private CharacterData character;

    public GameData(Resources resources, Array2D<TilePanel> grid) {
        this.resources = resources;
        this.grid = grid;
        System.out.println(grid.get(1, 1).getLocation());
    }

    public void updateGrid() {
        for (int x = 0; x < grid.getColumns(); x++) {
            for (int y = 0; y < grid.getRows(); y++) {
                Tile temp = map.get(x, y);
                grid.get(x, y).update(resources.getTexture(temp.getTexture()));
            }
        }
    }

    public synchronized void update(CharacterData data) {
        this.character = data;
    }

    public synchronized void update(MapData data) {
        this.map = data;
    }

}//End Class
