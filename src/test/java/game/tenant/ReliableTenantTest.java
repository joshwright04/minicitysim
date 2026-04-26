package game.tenant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReliableTenantTest {

    @Test
    public void testReliableTenantAlwaysPays() {
        ITenant base = new Tenant("Alex");
        ITenant reliable = new ReliableTenant(base);

        for (int i = 0; i < 50; i++) {
            Assertions.assertTrue(reliable.paysRentThisTick());
        }
    }
}
