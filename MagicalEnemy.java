import java.util.Random;

/** MagicalEnemy class that represents a magical enemy
 * This class extends Enemy and implements Magical
 */
public class MagicalEnemy extends Enemy implements Magical {
    /** Constructs a magical enemy
     * @param n the name of the enemy
     * @param mHp the max hit points of the enemy
     * @param i the item on the enemy
     */
    public MagicalEnemy(String n, int mHp, Item i) {
        super(n, mHp, i);
    }

    /** Randomly chooses an attack to attack the hero
     * @param e the hero being attacked
     * @return String the attack message
     */
    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int random = rand.nextInt(3) + 1;
        if (random == 1) {
            return magicMissile(e);
        }
        else if (random == 2) {
            return fireball(e);
        }
        else {
            return thunderclap(e);
        }
    }

    /** Method to make the enemy use a magic missile 
     * @param e the hero being attacked
     * @return String the attack message
     */
    @Override
    public String magicMissile(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + 1;
        e.takeDamage(damage);

        return getName() + "hits" + e.getName() + "with a Magic Missle for"
        + damage + "damage.";
    }

    /** Method to make the enemy use a fireball
     * @param e the hero being attacked
     * @return String the attack message
     */
    @Override
    public String fireball(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + 1;
        e.takeDamage(damage);

        return getName() + "hits" + e.getName() + "with a Fireball for"
        + damage + "damage.";
    }

    /** Method to make the enemy use thunderclap 
     * @param e the hero being attacked
     * @return String the attack message
     */
    @Override
    public String thunderclap(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + 1;
        e.takeDamage(damage);

        return getName() + "zaps" + e.getName() + "with Thunderclap for"
        + damage + "damage.";
    }
}
