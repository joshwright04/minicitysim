package game.building;

import game.building.apartment.Apartment;
import game.tenant.ITenant;
import game.tenant.Tenant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static game.building.BuildingFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MansionTest {

    BuildingFactory buildingFactory;

    @BeforeEach
    public void setupBuildingFactory(){
        buildingFactory = new BuildingFactory();
    }

    @Test
    public void testConstructor(){
        Building Mansion = buildingFactory.createMansion();
        Mansion castedMansion = (Mansion) Mansion;
        assertEquals(DEFAULT_MANSION_NAME, castedMansion.getName());
        assertEquals(DEFAULT_MANSION_RENT, castedMansion.getBaseRent());
    }

    @Test
    public void testSetTenant() {
        Building Mansion = buildingFactory.createMansion();

        Mansion castedMansion = (Mansion) Mansion;

        castedMansion.setTenant(new Tenant("Josh"));

        assertTrue(castedMansion.hasTenant());
        assertTrue(castedMansion.hasTenant());
        assertEquals(List.of("Josh"), castedMansion.getTenantNames());
    }

    @Test
    public void testGetTenantNames() {
        Mansion Mansion = new Mansion("Mansion", DEFAULT_MANSION_COST, DEFAULT_MANSION_RENT, new Tenant("Gavin"));

        assertEquals(List.of("Gavin"), Mansion.getTenantNames());
    }

    @Test
    public void testCollectRent() {
        ITenant tenant = new Tenant("Gavin");

        Building Mansion = buildingFactory.createMansion();

        Mansion castedMansion = (Mansion) Mansion;

        castedMansion.setTenant(tenant);

        assertTrue(castedMansion.collectRent() >= 0);
    }
}
