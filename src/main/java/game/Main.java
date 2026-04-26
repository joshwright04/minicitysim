package game;

import ui.CityFrame;

public class Main {
    public static MiniCitySim create2x2City(){
        Tile t1 = new Tile(TerrainType.LAND);
        Tile t2 = new Tile(TerrainType.ROCK);
        Tile t3 = new Tile(TerrainType.LAKE);
        Tile t4 = new Tile(TerrainType.LAND);

        Tile[][] grid = {
                {t1, t2},
                {t3, t4}
        };

        CityMap map = new CityMap(grid);
        return new MiniCitySim(map);
    }

    public static MiniCitySim create5x5City() {
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
        return new MiniCitySim(map);
    }


    public static void main(String[] args) {
        MiniCitySim miniCitySim = create5x5City();

        javax.swing.SwingUtilities.invokeLater(() -> {
            CityFrame frame = new CityFrame(miniCitySim);
            frame.setTitle("MiniCitySim");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
