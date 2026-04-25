package game.tenant;

import java.util.Random;

public class Tenant implements ITenant {
    private static final Random random = new Random();

    private final String name;

    public Tenant(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int modifyRent(int baseRent) {
        return baseRent;
    }

    @Override
    public boolean paysRentThisTick() {
        return random.nextInt(100) >= 10; // 10% chance to miss rent
    }
}