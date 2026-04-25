package game;

import ui.CityFrame;

public class Main {
    public static City create2x2City(){
        Tile t1 = new Tile(TerrainType.LAND, null);
        Tile t2 = new Tile(TerrainType.ROCK, null);
        Tile t3 = new Tile(TerrainType.RIVER, null);
        Tile t4 = new Tile(TerrainType.LAND, null);

        Tile[][] grid = {
                {t1, t2},
                {t3, t4}
        };

        CityMap map = new CityMap(grid);
        return new City(map);
    }

    public static City create5x5City() {
        Tile[][] grid = {
                {
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.ROCK, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null)
                },
                {
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.RIVER, null),
                        new Tile(TerrainType.RIVER, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.ROCK, null)
                },
                {
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null)
                },
                {
                        new Tile(TerrainType.ROCK, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.RIVER, null),
                        new Tile(TerrainType.LAND, null)
                },
                {
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.ROCK, null),
                        new Tile(TerrainType.LAND, null),
                        new Tile(TerrainType.LAND, null)
                }
        };

        CityMap map = new CityMap(grid);
        City city = new City(map);

        city.place(new House("Starter House", 20, 5), new Position(0, 0));
        city.place(new Farm("Starter Farm", 15, 3), new Position(0, 1));
        city.place(new Factory("Starter Factory", 50, 12), new Position(2, 2));
        city.place(new ApartmentComplex("Starter Apartments"), new Position(4, 4));

        return city;
    }


    public static void main(String[] args) {
        City city = create5x5City();

        javax.swing.SwingUtilities.invokeLater(() -> {
            CityFrame frame = new CityFrame(city);
            frame.setTitle("MiniCitySim");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
