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

    public Building createBudgetApartmentComplex(String name){
        ApartmentComplex.ApartmentComplexBuilder builder = ApartmentComplex.getNewBuilder(new ApartmentFactory());

        return builder.addBudgetApartment()
                .addBudgetApartment()
                .addBudgetApartment()
                .addBudgetApartment()
                .build();
    }

    public Building createMidTierApartmentComplex(String name){
        ApartmentComplex.ApartmentComplexBuilder builder = ApartmentComplex.getNewBuilder(new ApartmentFactory());

        return builder
                .addStandardApartment()
                .addStandardApartment()
                .addStandardApartment()
                .addStandardApartment()
                .build();
    }

    public Building createLuxuryApartmentComplex(String name){
        ApartmentComplex.ApartmentComplexBuilder builder = ApartmentComplex.getNewBuilder(new ApartmentFactory());

        return builder
            .addLuxuryApartment()
            .addLuxuryApartment()
            .addLuxuryApartment()
            .addLuxuryApartment()
                .build();
    }
}