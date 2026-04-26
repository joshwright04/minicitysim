package game.building;

import game.MiniCitySim;

public class Factory extends Building {
    private final int incomeRate;
    public Factory(String name, int buildCost, int incomeRate){
        super(name, buildCost);
        this.incomeRate = incomeRate;
    }
    @Override
    public void onTick(MiniCitySim miniCitySim) {
        miniCitySim.addMoney(getIncomeRate());
    }

    @Override
    public String getImagePath() {
        return "/images/factory.jpg";
    }

    @Override
    public int getIncomeRate(){
        return incomeRate;
    }
}
