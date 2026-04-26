package game.building.apartment;

import game.tenant.Tenant;
import game.tenant.ITenant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApartmentTest {

    @Test
    public void testConstructorAndGetBuildCost() {
        ITenant tenant = new Tenant("Sir Gobbles");

        Apartment apartment = new Apartment("Unit 1", 100, 250, tenant);

        assertEquals(250, apartment.getBuildCost());
    }

    @Test
    public void testHasTenantWhenTenantExists() {
        ITenant tenant = new Tenant("Sir Gobbles");

        Apartment apartment = new Apartment("Unit 1", 100, 250, tenant);

        assertTrue(apartment.hasTenant());
    }

    @Test
    public void testHasTenantWhenTenantIsNull() {
        Apartment apartment = new Apartment("Unit 1", 100, 250, null);

        assertFalse(apartment.hasTenant());
    }

    @Test
    public void testSetTenant() {
        Apartment apartment = new Apartment("Unit 1", 100, 250, null);

        apartment.setTenant(new Tenant("Sam"));

        assertTrue(apartment.hasTenant());
        assertEquals(List.of("Sam"), apartment.getTenantNames());
    }

    @Test
    public void testCollectRentWithNoTenantReturnsZero() {
        Apartment apartment = new Apartment("Unit 1", 100, 250, null);

        assertEquals(0, apartment.collectRent());
    }

    @Test
    public void testCollectRentIsNeverNegative() {
        ITenant tenant = new Tenant("Sir Gobbles");

        Apartment apartment = new Apartment("Unit 1", 100, 250, tenant);

        int rent = apartment.collectRent();

        assertTrue(rent >= 0);
    }

    @Test
    public void testCollectRentWhenTenantPaysIsAtLeastBaseRent() {
        ITenant tenant = new Tenant("Sir Gobbles");

        Apartment apartment = new Apartment("Unit 1", 100, 250, tenant);
        
        boolean observedPayment = false;

        for (int i = 0; i < 20; i++) {
            int rent = apartment.collectRent();

            if (rent > 0) {
                observedPayment = true;
                assertTrue(rent >= 100);
                break;
            }
        }

        assertTrue(observedPayment, "Tenant never paid rent in 20 tries (unlikely)");
    }

    @Test
    public void testGetTenantNamesWithTenant() {
        ITenant tenant = new Tenant("Sir Gobbles");

        Apartment apartment = new Apartment("Unit 1", 100, 250, tenant);

        assertEquals(List.of("Sir Gobbles"), apartment.getTenantNames());
    }

    @Test
    public void testGetTenantNamesWithoutTenant() {
        Apartment apartment = new Apartment("Unit 1", 100, 250, null);

        assertEquals(List.of("No tenant"), apartment.getTenantNames());
    }
}