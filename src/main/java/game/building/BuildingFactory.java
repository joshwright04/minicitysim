package game.building;

import game.building.apartment.ApartmentComplex;
import game.building.apartment.ApartmentFactory;
import game.tenant.TenantFactory;

public class BuildingFactory {
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

    public Building createCottage(String name){
        return new Cottage(name, DEFAULT_COTTAGE_COST, DEFAULT_COTTAGE_RENT, tenantFactory.createRandomTenant());
    }

    TenantFactory tenantFactory = new TenantFactory();
    public Building createHouse(String name){
        return new House(name, DEFAULT_HOUSE_COST, DEFAULT_HOUSE_RENT, tenantFactory.createRandomTenant());
    }

    public Building createMansion(String name){
        return new Mansion(name, DEFAULT_MANSION_COST, DEFAULT_MANSION_RENT, tenantFactory.createRandomTenant());
    }

    public Building createFarm(String name){
        return new Farm(name, DEFAULT_FARM_COST, DEFAULT_FARM_INCOME);
    }

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