package game.building.apartment;

import game.tenant.TenantFactory;

import java.util.Random;

public class ApartmentFactory {
    private static final Random random = new Random();

    public static int LUXURY_APARTMENT_RENT = 100;
    public static int STANDARD_APARTMENT_RENT = 50;
    public static int BUDGET_APARTMENT_RENT = 25;

    public static String[] LUXURY_APARTMENT_NAMES = new String[]{"Luxury Lane", "Luxury Apartment", "Livin Good"};
    public static String[] STANDARD_APARTMENT_NAMES = new String[]{"Very Normal Apartment", "Decent Hotel", "Boulder Apartment"};
    public static String[] BUDGET_APARTMENT_NAMES = new String[]{"Falling Apart Apartment", "Gross Apartment", "Budget Apartment"};

    public String getRandomApartmentName(String apartmentType){
        return switch (apartmentType) {
            case "Luxury" -> LUXURY_APARTMENT_NAMES[random.nextInt(LUXURY_APARTMENT_NAMES.length)];
            case "Standard" -> STANDARD_APARTMENT_NAMES[random.nextInt(STANDARD_APARTMENT_NAMES.length)];
            case "Budget" -> BUDGET_APARTMENT_NAMES[random.nextInt(BUDGET_APARTMENT_NAMES.length)];
            default -> null;
        };
    }

    private final TenantFactory tenantFactory= new TenantFactory();

    public Apartment createBudgetApartment() {
        return new Apartment("Budget", 5, 25, tenantFactory.createRandomTenant());
    }

    public Apartment createStandardApartment() {
        return new Apartment("Standard", 10, 40, tenantFactory.createRandomTenant());
    }

    public Apartment createLuxuryApartment() {
        return new Apartment("Luxury", 20, 75, tenantFactory.createRandomTenant());
    }
}
