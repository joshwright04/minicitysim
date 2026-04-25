package game.building.apartment;

import game.building.RealEstate;
import game.tenant.ITenant;

public class Apartment implements RealEstate {
    String unitName;
    private final int baseRent;
    private ITenant tenant;
    private final int buildCost;

    public Apartment(String unitName, int baseRent, int buildCost, ITenant tenant) {
        this.unitName = unitName;
        this.baseRent = baseRent;
        this.tenant = tenant;
        this.buildCost = buildCost;
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

    public int getBuildCost(){ return this.buildCost; }
}