package game.building;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static game.building.BuildingFactory.*;
import static org.junit.jupiter.api.Assertions.*;

public class FarmTest {

    BuildingFactory buildingFactory;

    @BeforeEach
    public void setupBuildingFactory(){
        buildingFactory = new BuildingFactory();
    }

    @Test
    public void testConstructor() {
        Building farm = buildingFactory.createFarm();
        Farm castedFarm = (Farm) farm;

        assertEquals(DEFAULT_FARM_NAME, castedFarm.getName());
        assertEquals(DEFAULT_FARM_INCOME, castedFarm.getIncomeRate());
    }

    @Test
    public void testImagePath() {
        Building farm = buildingFactory.createFarm();
        Farm castedFarm = (Farm) farm;

        assertEquals("/images/farm.jpg", farm.getImagePath());
    }
}
