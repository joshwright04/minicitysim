package game;

public class Factory extends Building {
    private final int incomeRate;
    public Factory(String name, int buildCost, int incomeRate){
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
    public int getIncomeRate(){
        return incomeRate;
    }
}
