/** Abstract Entity Class that represents an entity */
public abstract class Entity {
    /** An entity's name */
    private String name;
    /** An entity's max hit points */
    private int maxHp;
    /** An entity's current hit points */
    private int hp;

    /** Constructs an entity with a name and max hp
     * @param n the entity's name 
     * @param mHp the entity's max hit points 
     */
    public Entity(String n, int mHp) {
        name = n;
        maxHp = mHp;
        hp = mHp;
    }

    /** Returns a message when the entity is attacked
     * @param e an entity
     * @return String the message when the entity is attacked 
     */
    public abstract String attack(Entity e);
    
    /** Retrieves the name of the entity
     * @return String the entity's name
     */
    public String getName() {
        return name;
    }

    /** Retrieves the current hit points of the entity
     * @return int the entity's hit points
     */
    public int getHP() {
        return hp;
    }

    /** Returns the max hit points of the entity
     * @return int the entity's max hit points
     */
    public int getMaxHP() {
        return maxHp;
    }

    /** Heals entity with a certain amount
     * If the heal exceeds the max hp, set hp to the max hp
     * @param h the amount of heal given to the entity
     */
    public void heal(int h) {
        hp += h;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    /** Entity takes a certain amount of damage
     * @param h the amount of damage taken by the entity
     */
    public void takeDamage(int h) {
        hp -= h;
        if (hp < 0) {
            hp = 0;
        }
    }
    
    /** Displays the entity's current hp out of max hp 
     * @return String the entity's current hp out of max hp
     */
    @Override
    public String toString() {
        return name + "\nHP: " + hp + "/" + maxHp; 
    }
}
