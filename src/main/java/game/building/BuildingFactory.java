package game.building;

import game.building.apartment.ApartmentComplex;
import game.building.apartment.ApartmentFactory;
import game.tenant.TenantFactory;

public class BuildingFactory {
    TenantFactory tenantFactory = new TenantFactory();

    public static final int DEFAULT_COTTAGE_COST = 20;
    public static final int DEFAULT_HOUSE_COST = 30;
    public static final int DEFAULT_MANSION_COST = 50;
    public static final int DEFAULT_FARM_COST = 15;
    public static final int DEFAULT_FACTORY_COST = 50;

    public static final int DEFAULT_COTTAGE_RENT = 5;
    public static final int DEFAULT_HOUSE_RENT = 7;
    public static final int DEFAULT_MANSION_RENT = 10;
    public static final int DEFAULT_FARM_INCOME = 3;
    public static final int DEFAULT_FACTORY_INCOME = 12;

    public static final String DEFAULT_COTTAGE_NAME = "Cottage";
    public static final String DEFAULT_HOUSE_NAME = "House";
    public static final String DEFAULT_MANSION_NAME = "Mansion";
    public static final String DEFAULT_FARM_NAME = "Farm";
    public static final String DEFAULT_FACTORY_NAME = "Factory";

    public Building createCottage(){ return createCottage(DEFAULT_COTTAGE_NAME); }

    public Building createCottage(String name){
        return new Cottage(name, DEFAULT_COTTAGE_COST, DEFAULT_COTTAGE_RENT, tenantFactory.createRandomTenant());
    }

    public Building createHouse(){ return createHouse(DEFAULT_HOUSE_NAME); }

    public Building createHouse(String name){
        return new House(name, DEFAULT_HOUSE_COST, DEFAULT_HOUSE_RENT, tenantFactory.createRandomTenant());
    }

    public Building createMansion(){ return createMansion(DEFAULT_MANSION_NAME); }

    public Building createMansion(String name){
        return new Mansion(name, DEFAULT_MANSION_COST, DEFAULT_MANSION_RENT, tenantFactory.createRandomTenant());
    }

    public Building createFarm(){ return createFarm(DEFAULT_FARM_NAME); }

    public Building createFarm(String name){
        return new Farm(name, DEFAULT_FARM_COST, DEFAULT_FARM_INCOME);
    }

    public Building createFactory(){ return createFactory(DEFAULT_FACTORY_NAME); }

    public Building createFactory(String name){
        return new Factory(name, DEFAULT_FACTORY_COST, DEFAULT_FACTORY_INCOME);
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