package game.building.apartment;

import game.tenant.TenantFactory;

public class ApartmentFactory {
    public static int LUXURY_APARTMENT_RENT = 100;
    public static int STANDARD_APARTMENT_RENT = 50;
    public static int BUDGET_APARTMENT_RENT = 25;

    public static String[] LUXURY_APARTMENT_NAMES = new String[]{};
    public static String[] STANDARD_APARTMENT_NAMES = new String[]{};
    public static String[] BUDGET_APARTMENT_NAMES = new String[]{};

    private final TenantFactory tenantFactory= new TenantFactory();

    public Apartment createLuxuryApartment(){ return new Apartment("", LUXURY_APARTMENT_RENT, tenantFactory.createRandomTenant()); }

    public Apartment createStandardApartment(){ return new Apartment("", STANDARD_APARTMENT_RENT, tenantFactory.createRandomTenant()); }

    public Apartment createBudgetApartment() { return new Apartment("", BUDGET_APARTMENT_RENT, tenantFactory.createRandomTenant()); }
}
