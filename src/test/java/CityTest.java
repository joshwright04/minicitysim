import org.junit.jupiter.api.Test;

public class CityTest {

    @Test
    public void testPlace(){
        Tile t1 = new Tile(TerrainType.LAND, new House("House 1"));
        Tile t2 = new Tile(TerrainType.ROCK, new House("House 2"));
        Tile t3 = new Tile(TerrainType.RIVER, new House("House 3"));
        Tile t4 = new Tile(TerrainType.LAND, null);

        Tile[][] grid = {
                {t1, t2},
                {t3, t4}
        };

        CityMap map = new CityMap(grid);
        City city = new City(map);
        city.place(new House("House 4"), new Position(1, 1));
        city.getMap().printGrid();

    }
}
