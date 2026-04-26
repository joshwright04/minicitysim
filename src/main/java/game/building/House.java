package game.building;

import game.MiniCitySim;
import game.tenant.ITenant;

import java.util.List;

public class House extends Building implements RealEstate {
    private ITenant tenant;
    private final int baseRent;

    public House(String name, int buildCost, int baseRent) {
        super(name, buildCost);
        this.baseRent = baseRent;
        this.tenant = null;
    }

    public House(String name, int buildCost, int baseRent, ITenant tenant) {
        this(name, buildCost, baseRent);
        this.tenant = tenant;
    }

    public int getBaseRent() { return this.baseRent; }

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
    public void onTick(MiniCitySim miniCitySim) {
        miniCitySim.addMoney(collectRent());
    }

    @Override
    public String getImagePath() {
        return "/images/house.jpg";
    }

    @Override
    public List<String> getTenantNames() {
        if (tenant == null) {
            return List.of("No tenant");
        }

        return List.of(tenant.getName());
    }
}