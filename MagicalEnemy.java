import java.util.Random;
public class MagicalEnemy extends Enemy {
    public MagicalEnemy(String n, int mHp, Item i) {
        super(n, mHp, i);
    }

    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(15) + 1;
        e.takeDamage(damage);
        return getName() + "attacks" + e.getName() 
        + "for" + damage + "damage.";
    }
}
