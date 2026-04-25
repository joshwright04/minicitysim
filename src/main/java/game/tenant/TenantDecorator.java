package game.tenant;

public abstract class TenantDecorator implements ITenant {
    protected final ITenant tenant;

    public TenantDecorator(ITenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public String getName() {
        return tenant.getName();
    }

    @Override
    public int modifyRent(int baseRent) {
        return tenant.modifyRent(baseRent);
    }

    @Override
    public boolean paysRentThisTick() {
        return tenant.paysRentThisTick();
    }
}