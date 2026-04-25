package game;

import game.tenant.ITenant;

public class Apartment implements RealEstate {
    String unitName;
    private final int baseRent;
    private ITenant tenant;

    public Apartment(String unitName, int baseRent) {
        this.unitName = unitName;
        this.baseRent = baseRent;
    }
    public Apartment(String unitName, int baseRent, ITenant tenant) {
        this(unitName, baseRent);
        this.tenant = tenant;
    }

    public void setTenant(ITenant tenant) {
        this.tenant = tenant;
    }

    public boolean hasTenant() {
        return tenant != null;
    }

    @Override
    public int collectRent() {
        if (tenant == null) {
            return 0;
        }

        if (!tenant.paysRentThisTick()) {
            return 0;
        }

        return tenant.modifyRent(baseRent);
    }
}