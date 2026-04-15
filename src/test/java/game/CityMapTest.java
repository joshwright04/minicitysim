package game;

import org.junit.jupiter.api.Test;

public class CityMapTest {

    @Test
    public void testMapCreation(){
        Tile t1 = new Tile(TerrainType.LAND, new House("game.House 1"));
        Tile t2 = new Tile(TerrainType.ROCK, new House("game.House 2"));
        Tile t3 = new Tile(TerrainType.RIVER, new House("game.House 3"));
        Tile t4 = new Tile(TerrainType.LAND, new House("game.House 4"));

        Tile[][] grid = {
                {t1, t2},
                {t3, t4}
        };

        CityMap map = new CityMap(grid);
        map.printGrid();
    }

}
