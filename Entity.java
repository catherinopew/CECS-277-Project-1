/** Abstract Entity Class that represents an entity */
public abstract class Entity {
    /** A private instance variable name of the entity */
    private String name;
    /** A private instance variable max hit points of the entity */
    private int maxHp;
    /** A private instance variable hit points of the entity */
    private int hp;

    /** Constructs an entity with a name and max hp
     * @param n the name 
     * @param mHp the max hit points 
     */
    public Entity(String n, int mHp) {
        name = n;
        maxHp = mHp;
    }

    /** Returns a message when the entity attacks
     * @param e an entity
     * @return String the message when an entity attacks 
     */
    public abstract String attack(Entity e);
    
    /** Returns the name of the entity
     * @return String the name
     */
    public String getName() {
        return name;
    }

    /** Returns the hit points of the entity
     * @return int the hit points
     */
    public int getHP() {
        return hp;
    }

    /** Returns the max hit points of the entity
     * @return int the max hit points
     */
    public int getMaxHP() {
        return maxHp;
    }

    /** Heals entity with a certain amount
     * If the heal exceeds the max hp, set hp to the max hp.
     * @param h the amount of heal
     */
    public void heal(int h) {
        hp += h;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    /** Entity takes a certain amount of damage
     * @param h the amount of damage
     */
    public void takeDamage(int h) {
        hp -= h;
    }
    
    /** Displays the entity's current hp out of max hp 
     * @return String the current hp out of max hp
     */
    @Override
    public String toString() {
        return name + "\nHP: " + hp + "/" + maxHp;
    }
}
