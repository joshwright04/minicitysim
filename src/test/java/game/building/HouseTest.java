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

public class HouseTest {

    BuildingFactory buildingFactory;

    @BeforeEach
    public void setupBuildingFactory(){
        buildingFactory = new BuildingFactory();
    }

    @Test
    public void testConstructor(){
        Building house = buildingFactory.createHouse();
        House castedHouse = (House) house;
        assertEquals(DEFAULT_HOUSE_NAME, castedHouse.getName());
        assertEquals(DEFAULT_HOUSE_RENT, castedHouse.getBaseRent());
    }

    @Test
    public void testSetTenant() {
        Building house = buildingFactory.createHouse();

        House castedHouse = (House) house;

        castedHouse.setTenant(new Tenant("Josh"));

        assertTrue(castedHouse.hasTenant());
        assertTrue(castedHouse.hasTenant());
        assertEquals(List.of("Josh"), castedHouse.getTenantNames());
    }

    @Test
    public void testGetTenantNames() {
        House house = new House("House", DEFAULT_HOUSE_COST, DEFAULT_HOUSE_RENT, new Tenant("Gavin"));

        assertEquals(List.of("Gavin"), house.getTenantNames());
    }

    @Test
    public void testCollectRent() {
        ITenant tenant = new Tenant("Gavin");

        Building house = buildingFactory.createHouse();

        House castedHouse = (House) house;

        castedHouse.setTenant(tenant);

        assertTrue(castedHouse.collectRent() >= 0);
    }
}
