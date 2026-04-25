package game;

import game.building.BuildingFactory;
import ui.CityFrame;

public class Main {
    public static City create2x2City(){
        Tile t1 = new Tile(TerrainType.LAND);
        Tile t2 = new Tile(TerrainType.ROCK);
        Tile t3 = new Tile(TerrainType.LAKE);
        Tile t4 = new Tile(TerrainType.LAND);

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
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.ROCK),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND)
                },
                {
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAKE),
                        new Tile(TerrainType.LAKE),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.ROCK)
                },
                {
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND)
                },
                {
                        new Tile(TerrainType.ROCK),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAKE),
                        new Tile(TerrainType.LAND)
                },
                {
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.ROCK),
                        new Tile(TerrainType.LAND),
                        new Tile(TerrainType.LAND)
                }
        };

        CityMap map = new CityMap(grid);
        City city = new City(map);

        BuildingFactory buildingFactory = new BuildingFactory();
        city.place(buildingFactory.createCottage("Cottage"), new Position(0, 0));
        city.place(buildingFactory.createFarm("Farm"), new Position(0, 1));
        city.place(buildingFactory.createFactory("Factory"), new Position(2, 2));
        city.place(buildingFactory.createBudgetApartmentComplex("O Block"), new Position(4, 4));

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
