package game.tenant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WealthyTenantTest {

    @Test
    public void testWealthyTenantIncreasesRent() {
        ITenant base = new Tenant("Alex");
        ITenant wealthy = new WealthyTenant(base);

        int rent = wealthy.modifyRent(100);

        assertTrue(rent >= 100);
    }
}
