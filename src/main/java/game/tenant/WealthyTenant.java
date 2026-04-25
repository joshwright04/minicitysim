package game.tenant;

public class WealthyTenant extends TenantDecorator {

    public WealthyTenant(ITenant tenant) {
        super(tenant);
    }

    @Override
    public String getName() {
        return tenant.getName() + " [Wealthy]";
    }

    @Override
    public int modifyRent(int baseRent) {
        int currentRent = tenant.modifyRent(baseRent);
        return (int)(currentRent * 1.05);
    }
}