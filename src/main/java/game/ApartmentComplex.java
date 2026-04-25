package game;

import game.tenant.Tenant;
import game.tenant.TenantFactory;

import java.util.ArrayList;
import java.util.List;

public class ApartmentComplex extends Building implements RealEstate {
    private static final String DEFAULT_APARTMENT_COMPLEX_NAME = "Complex Living";

    public static ApartmentComplexBuilder getNewBuilder(ApartmentFactory apartmentFactory) {
        return new ApartmentComplexBuilder(apartmentFactory);
    }

    public static class ApartmentComplexBuilder {
        private final ApartmentComplex apartmentComplex;
        private final ApartmentFactory apartmentFactory;

        private ApartmentComplexBuilder(ApartmentFactory apartmentFactory) {
            this.apartmentFactory = apartmentFactory;
            this.apartmentComplex = new ApartmentComplex(DEFAULT_APARTMENT_COMPLEX_NAME);
        }

        public ApartmentComplexBuilder addLuxuryApartment() {
            apartmentComplex.addApartment(apartmentFactory.createLuxuryApartment());
            return this;
        }

        public ApartmentComplexBuilder addStandardApartment() {
            apartmentComplex.addApartment(apartmentFactory.createStandardApartment());
            return this;
        }

        public ApartmentComplexBuilder addBudgetApartment() {
            apartmentComplex.addApartment(apartmentFactory.createBudgetApartment());
            return this;
        }

        public ApartmentComplex build() {
            if (apartmentComplex.size() == 0) {
                throw new IllegalArgumentException("Cannot create an Apartment Complex with 0 Apartments!");
            }
            return apartmentComplex;
        }
    }

    private final List<Apartment> apartments;

    private ApartmentComplex(String name) {
        super(name, 120);
        this.apartments = new ArrayList<>();
    }

    private void addApartment(Apartment apartmentToAdd) {
        apartments.add(apartmentToAdd);
    }

    public int size() {
        return apartments.size();
    }

    @Override
    public int collectRent() {
        int total = 0;

        for (Apartment apartment : apartments) {
            total += apartment.collectRent();
        }

        return total;
    }

    @Override
    public int getIncomeRate() {
        return collectRent();
    }

    @Override
    public void onTick(City city) {
        city.addMoney(collectRent());
    }

    @Override
    public String getSymbol() {
        return "A";
    }
}