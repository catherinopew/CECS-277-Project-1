import java.util.Random;
/** Enemy class that extends Entity class */
public class Enemy extends Entity {
    /** A private instance variable item of type Item */
    private Item item;
    
    /** Constructs an enemy 
     * @param n the enemy name
     * @param mHp the max hit points
     * @param i the item
     */
    public Enemy(String n, int mHp, Item i) {
        super(n, mHp);
        item = i;
    }

    /** Returns an item
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /** Attacks the hero for a random amount of damage
     * @param e the hero who is being attacked
     */
    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + 1;
        e.takeDamage(damage);
        return getName() + "attacks" + e.getName() 
        + "for" + damage + "damage.";
    }
}
