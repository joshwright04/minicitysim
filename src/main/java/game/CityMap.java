package game;

public class CityMap {
    private final Tile[][] grid;

    public CityMap(Tile[][] grid) {
        this.grid = grid;
    }

    public Tile getTile(Position position){
        return grid[ position.row() ] [ position.col() ];
    }

    public void printGrid(){
        for(Tile[] row : grid){
            for(Tile tile : row){
                tile.print();
            }
        }
    }

    public Tile[][] getGrid(){
        return this.grid;
    }

}
