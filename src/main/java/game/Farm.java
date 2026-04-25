package game;

public class Farm extends Building {
    private final int incomeRate;

    public Farm(String name, int buildCost, int incomeRate){
        super(name, buildCost);
        this.incomeRate = incomeRate;
    }

    @Override
    public void onTick(City city) {
        city.addMoney(getIncomeRate());
    }

    @Override
    public String getSymbol() {
        return "F";
    }

    @Override
    public int getIncomeRate(){ return incomeRate; }
}
