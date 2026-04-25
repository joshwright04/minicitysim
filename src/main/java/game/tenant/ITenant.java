package game.tenant;

public interface ITenant {
    String getName();
    int modifyRent(int baseRent);
    boolean paysRentThisTick();
}