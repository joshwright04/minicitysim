package game.tenant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErraticTenantTest {
    @Test
    public void testErraticTenantSometimesMissesRent() {
        ITenant base = new Tenant("Alex");
        ITenant erratic = new ErraticTenant(base);

        boolean missed = false;

        for (int i = 0; i < 100; i++) {
            if (!erratic.paysRentThisTick()) {
                missed = true;
                break;
            }
        }

        assertTrue(missed);
    }
}
