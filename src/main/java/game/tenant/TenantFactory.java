package game.tenant;

import java.util.Random;

public class TenantFactory {
    private final Random random = new Random();

    public ITenant createRandomTenant() {
        ITenant tenant = new Tenant(randomName());

        int roll = random.nextInt(100);

        if (roll < 5) {
            return new WealthyTenant(tenant);
        } else if (roll < 15) {
            return new ReliableTenant(tenant);
        } else if (roll < 20) {
            return new ErraticTenant(tenant);
        }

        return tenant;
    }

    private String randomName() {
        String[] names = {"Evil Wizard", "Incubus", "Foghorn", "Lucifer", "Ogre", "Hero", "Black Knight"};
        return names[random.nextInt(names.length)];
    }
}