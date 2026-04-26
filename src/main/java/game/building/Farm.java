package game.building;

import game.MiniCitySim;

public class Farm extends Building {
    private final int incomeRate;

    public Farm(String name, int buildCost, int incomeRate){
        super(name, buildCost);
        this.incomeRate = incomeRate;
    }

    @Override
    public void onTick(MiniCitySim miniCitySim) {
        miniCitySim.addMoney(getIncomeRate());
    }

    @Override
    public String getImagePath() {
        return "/images/farm.jpg";
    }

    @Override
    public int getIncomeRate(){ return incomeRate; }
}
