package game.tenant;

public class ErraticTenant extends TenantDecorator {

    public ErraticTenant(ITenant tenant) {
        super(tenant);
    }

    @Override
    public String getName() {
        return tenant.getName() + " [Erratic]";
    }

    @Override
    public int modifyRent(int baseRent) {
        return tenant.modifyRent(baseRent);
    }

    @Override
    public boolean paysRentThisTick() {
        return Math.random() >= 0.30;
    }
}