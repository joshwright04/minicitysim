package game;

import org.junit.jupiter.api.Test;

import static game.Main.create2x2City;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityTest {



    @Test
    public void testPlace(){
        City city = create2x2City();
        city.place(new House("game.House 4"), new Position(1, 1));
        city.printGrid();

    }

    @Test
    public void testTick(){
        City city = create2x2City();
        Double previousMoney = city.getMoney();
        city.tick();
        assertTrue(previousMoney < city.getMoney());
    }
}
