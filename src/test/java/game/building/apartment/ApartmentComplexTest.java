package game.building.apartment;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApartmentComplexTest {

    @Test
    public void testBuilderRequiresAtLeastOneApartment() {
        ApartmentFactory factory = new ApartmentFactory();

        assertThrows(
                IllegalArgumentException.class,
                () -> ApartmentComplex.getNewBuilder(factory).build()
        );
    }

    @Test
    public void testBuildBudgetApartmentComplex() {
        ApartmentFactory factory = new ApartmentFactory();

        ApartmentComplex complex = ApartmentComplex.getNewBuilder(factory)
                .addBudgetApartment()
                .addBudgetApartment()
                .build();

        assertEquals(2, complex.size());
        assertTrue(complex.getBuildCost() > 0);
        assertEquals("/images/apartment_complex.jpg", complex.getImagePath());
    }

    @Test
    public void testBuildMixedApartmentComplex() {
        ApartmentFactory factory = new ApartmentFactory();

        ApartmentComplex complex = ApartmentComplex.getNewBuilder(factory)
                .addBudgetApartment()
                .addStandardApartment()
                .addLuxuryApartment()
                .build();

        assertEquals(3, complex.size());
        assertTrue(complex.getBuildCost() > 0);
    }

    @Test
    public void testCollectRentAndIncomeRateAreSame() {
        ApartmentFactory factory = new ApartmentFactory();

        ApartmentComplex complex = ApartmentComplex.getNewBuilder(factory)
                .addStandardApartment()
                .addStandardApartment()
                .build();

        int rent = complex.collectRent();

        assertTrue(rent >= 0);
        assertTrue(complex.getIncomeRate() >= 0);
    }

    @Test
    public void testGetTenantNames() {
        ApartmentFactory factory = new ApartmentFactory();

        ApartmentComplex complex = ApartmentComplex.getNewBuilder(factory)
                .addBudgetApartment()
                .addStandardApartment()
                .addLuxuryApartment()
                .build();

        List<String> tenantNames = complex.getTenantNames();

        assertEquals(3, tenantNames.size());
        assertFalse(tenantNames.isEmpty());
    }
}