package game;

import game.building.BuildingFactory;
import org.junit.jupiter.api.Test;

import static game.Main.create2x2City;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiniCitySimTest {



    @Test
    public void testPlace(){
        MiniCitySim miniCitySim = create2x2City();
        BuildingFactory buildingFactory = new BuildingFactory();
        miniCitySim.place(buildingFactory.createHouse("House"), new Position(0, 0));
        miniCitySim.place(buildingFactory.createHouse("House"), new Position(0, 1));
        miniCitySim.place(buildingFactory.createHouse("House"), new Position(1, 0));
        miniCitySim.place(buildingFactory.createHouse("House"), new Position(1, 1));
        miniCitySim.printGrid();

    }

    @Test
    public void testTick(){
        MiniCitySim miniCitySim = create2x2City();
        Double previousMoney = miniCitySim.getMoney();
        miniCitySim.tick();
        assertTrue(previousMoney == miniCitySim.getMoney());
    }
}
