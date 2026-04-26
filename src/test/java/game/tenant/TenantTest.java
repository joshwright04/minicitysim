package game.tenant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TenantTest {

    @Test
    public void testGetName() {
        Tenant tenant = new Tenant("Alex");
        assertEquals("Alex", tenant.getName());
    }

    @Test
    public void testModifyRentReturnsBaseRent() {
        Tenant tenant = new Tenant("Alex");
        assertEquals(100, tenant.modifyRent(100));
    }
}
