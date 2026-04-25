package game.building;

import game.City;
import game.tenant.ITenant;

public class House extends Building implements RealEstate {
    private ITenant tenant;
    private final int baseRent;

    public House(String name, int buildCost, int baseRent) {
        super(name, buildCost);
        this.baseRent = baseRent;
    }

    public House(String name, int buildCost, int baseRent, ITenant tenant) {
        this(name, buildCost, baseRent);
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

    @Override
    public int getIncomeRate() {
        return collectRent();
    }

    @Override
    public void onTick(City city) {
        city.addMoney(collectRent());
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}