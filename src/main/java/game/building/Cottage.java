package game.building;

import game.tenant.ITenant;

public class Cottage extends House {
    public Cottage(String name, int buildCost, int baseRent, ITenant randomTenant){
        super(name, buildCost, baseRent, randomTenant);
    }

    @Override
    public String getSymbol() {
        return "C";
    }
}
