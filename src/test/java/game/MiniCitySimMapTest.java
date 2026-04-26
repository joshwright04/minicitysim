package game;

import game.building.BuildingFactory;
import org.junit.jupiter.api.Test;

public class MiniCitySimMapTest {

    @Test
    public void testMapCreation(){
        BuildingFactory buildingFactory = new BuildingFactory();
        Tile t1 = new Tile(TerrainType.LAND, buildingFactory.createHouse("House 1"));
        Tile t2 = new Tile(TerrainType.ROCK, buildingFactory.createHouse("House 2"));
        Tile t3 = new Tile(TerrainType.LAKE, buildingFactory.createHouse("House 3"));
        Tile t4 = new Tile(TerrainType.LAND, buildingFactory.createHouse("House 4"));

        Tile[][] grid = {
                {t1, t2},
                {t3, t4}
        };

        CityMap map = new CityMap(grid);
        map.printGrid();
    }

}
