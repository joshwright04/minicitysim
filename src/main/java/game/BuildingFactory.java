package game;
public class BuildingFactory {

    public Building createCottage(String name){
        return new House(name, 20, 5);
    }

    public Building createHouse(String name){
        return new House(name, 30, 7);
    }

    public Building createMansion(String name){
        return new House(name, 50, 10);
    }

    public Building createFarm(String name){
        return new Farm(name, 15, 3);
    }

    public Building createFactory(String name){
        return new Factory(name, 50, 12);
    }

    public Building createApartmentComplex(String name){
        return new ApartmentComplex(name);
    }
}