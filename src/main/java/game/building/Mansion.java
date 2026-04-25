package game.building;

import game.tenant.ITenant;

public class Mansion extends House {
    public Mansion(String name, int buildCost, int baseRent, ITenant randomTenant){
        super(name, buildCost, baseRent, randomTenant);
    }

    @Override
    public String getSymbol() {
        return "M";
    }
}
