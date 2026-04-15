package game;

public class Main {
    public static City create2x2City(){
        Tile t1 = new Tile(TerrainType.LAND, new House("game.House 1"));
        Tile t2 = new Tile(TerrainType.ROCK, new House("game.House 2"));
        Tile t3 = new Tile(TerrainType.RIVER, new House("game.House 3"));
        Tile t4 = new Tile(TerrainType.LAND, null);

        Tile[][] grid = {
                {t1, t2},
                {t3, t4}
        };

        CityMap map = new CityMap(grid);
        return new City(map);
    }

    public static void main(String[] args) {
        City city = create2x2City();
        Game game = new Game(city);

        game.run();
    }
}
