public class MagicalEnemy extends Enemy {
    public MagicalEnemy(String n, int mHp, Item i) {
        super(n, mHp, i);
    }

    public String attack(Entity e) {
        int damage = 0;
        if (e.getHP() != 0) {
            damage = (int)(Math.random() * e.getHP());
            e.takeDamage(damage);
        }
        return e.toString();
    }
}
