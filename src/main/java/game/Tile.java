package game;

public class Tile {

    private TerrainType terrain;
    private Placeable object;

    public Tile(TerrainType terrain, Placeable object){
        this.terrain = terrain;
        this.object = object;
    }

    public boolean isEmpty() {
        return object == null;
    }

    public void print(){
        System.out.println(
                "game.Tile Contents:\n"
                + "Terrain: " + terrain.toString() + "\n"
                + "Contains: " + object.getName()
        );
    }

    public void setObject(Placeable object){
        this.object = object;
    }
    public Placeable getObject(){
        return this.object;
    }

}