package game;

import game.building.Placeable;

public class Tile {

    private TerrainType terrain;
    private Placeable object;

    public Tile(TerrainType terrain, Placeable object) {
        this.terrain = terrain;
        this.object = object;
    }

    public Tile(TerrainType terrain) {
        this.terrain = terrain;
        this.object = null;
    }

    public TerrainType getTerrainType() { return terrain; }

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

    public void setTerrain(TerrainType terrain){ this.terrain = terrain; }

    public Placeable getObject(){
        return this.object;
    }

}