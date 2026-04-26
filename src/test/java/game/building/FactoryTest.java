package game.building;

import game.CityMap;
import game.MiniCitySim;
import game.building.apartment.Apartment;
import game.tenant.ITenant;
import game.tenant.Tenant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static game.building.BuildingFactory.*;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    BuildingFactory buildingFactory;

    @BeforeEach
    public void setupBuildingFactory(){
        buildingFactory = new BuildingFactory();
    }

    @Test
    public void testConstructor() {
        Building factory = buildingFactory.createFactory();
        Factory castedFactory = (Factory) factory;

        assertEquals(DEFAULT_FACTORY_NAME, castedFactory.getName());
        assertEquals(DEFAULT_FACTORY_INCOME, castedFactory.getIncomeRate());
    }

    @Test
    public void testImagePath() {
        Building factory = buildingFactory.createFactory();
        Factory castedFactory = (Factory) factory;

        assertEquals("/images/factory.jpg", factory.getImagePath());
    }
}
