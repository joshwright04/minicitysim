package game.building.apartment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApartmentFactoryTest {

    @Test
    public void testCreateApartments() {
        ApartmentFactory factory = new ApartmentFactory();

        Apartment budget = factory.createBudgetApartment();
        Apartment standard = factory.createStandardApartment();
        Apartment luxury = factory.createLuxuryApartment();

        assertNotNull(budget);
        assertNotNull(standard);
        assertNotNull(luxury);

        assertEquals(25, budget.getBuildCost());
        assertEquals(40, standard.getBuildCost());
        assertEquals(75, luxury.getBuildCost());

        assertTrue(budget.hasTenant());
        assertTrue(standard.hasTenant());
        assertTrue(luxury.hasTenant());
    }

    @Test
    public void testGetRandomApartmentName() {
        ApartmentFactory factory = new ApartmentFactory();

        String luxuryName = factory.getRandomApartmentName("Luxury");
        String standardName = factory.getRandomApartmentName("Standard");
        String budgetName = factory.getRandomApartmentName("Budget");

        assertNotNull(luxuryName);
        assertNotNull(standardName);
        assertNotNull(budgetName);

        assertNull(factory.getRandomApartmentName("InvalidType"));
    }
}