public class Entity {
    private String name;
    private int maxHp;
    private int hp;

    public Entity(String n, int mHp) {
        name = n;
        maxHp = mHp;
    }

    //abstract String attack(Entity e)
    //haven't learned this yet?

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public int getMaxHP() {
        return maxHp;
    }

    public void heal(int h) {
        hp += h;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public void takeDamage(int h) {
        int damage = 0;
        damage = hp - h;
    }

    @Override
    public String toString() {
        String s = "";
        s += name;
        s += "\nHP: " + hp + "/" + maxHp;
        return s;
    }
}
