package game.tenant;

public class ReliableTenant extends TenantDecorator {

    public ReliableTenant(ITenant tenant) {
        super(tenant);
    }

    @Override
    public String getName() {
        return tenant.getName() + " [Reliable]";
    }

    @Override
    public int modifyRent(int baseRent) {
        int currentRent = tenant.modifyRent(baseRent);
        return currentRent + 5;
    }

    @Override
    public boolean paysRentThisTick() {
        return true;
    }
}