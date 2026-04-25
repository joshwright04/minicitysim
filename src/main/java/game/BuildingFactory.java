package game;

import game.tenant.TenantFactory;

public class BuildingFactory {

    public Building createCottage(String name){
        return new House(name, 20, 5);
    }

    TenantFactory tenantFactory = new TenantFactory();
    public Building createHouse(String name){
        return new House(name, 30, 7, tenantFactory.createRandomTenant());
    }

    public Building createMansion(String name){
        return new House(name, 50, 10, tenantFactory.createRandomTenant());
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