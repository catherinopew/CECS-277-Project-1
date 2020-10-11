/** Enemy class that extends Entity class */
public class Enemy extends Entity {
    /** A private instance variable item of type Item */
    private Item item;
    
    /** Constructs an enemy. 
     * @param n the enemy name
     * @param mHp the max hit points
     * @param i the item
     */
    public Enemy(String n, int mHp, Item i) {
        super(n, mHp);
        item = i;
    }

    /** Returns an item.
     * @return the item
     */
    public Item getItem() {
        return item;
    }
}
