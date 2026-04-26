package game.building;

import game.tenant.ITenant;
import game.tenant.Tenant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static game.building.BuildingFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CottageTest {

    BuildingFactory buildingFactory;

    @BeforeEach
    public void setupBuildingFactory(){
        buildingFactory = new BuildingFactory();
    }

    @Test
    public void testConstructor(){
        Building cottage = buildingFactory.createCottage();
        Cottage castedCottage = (Cottage) cottage;
        assertEquals(DEFAULT_COTTAGE_NAME, castedCottage.getName());
        assertEquals(DEFAULT_COTTAGE_RENT, castedCottage.getBaseRent());
    }

    @Test
    public void testSetTenant() {
        Building cottage = buildingFactory.createCottage();

        Cottage castedCottage = (Cottage) cottage;

        castedCottage.setTenant(new Tenant("Josh"));

        assertTrue(castedCottage.hasTenant());
        assertTrue(castedCottage.hasTenant());
        assertEquals(List.of("Josh"), castedCottage.getTenantNames());
    }

    @Test
    public void testGetTenantNames() {
        Cottage cottage = new Cottage("cottage", DEFAULT_COTTAGE_COST, DEFAULT_COTTAGE_RENT, new Tenant("Gavin"));

        assertEquals(List.of("Gavin"), cottage.getTenantNames());
    }

    @Test
    public void testCollectRent() {
        ITenant tenant = new Tenant("Gavin");

        Building cottage = buildingFactory.createCottage();

        Cottage castedCottage = (Cottage) cottage;

        castedCottage.setTenant(tenant);

        assertTrue(castedCottage.collectRent() >= 0);
    }
}
