import java.util.Random;

/** MagicalEnemy class that represents a magical enemy
 * It extends Enemy and implements the Magical interface
 */
public class MagicalEnemy extends Enemy implements Magical {
    /** Constructs a magical enemy
     * @param n the magical enemy's name
     * @param mHp the magical enemy's max hit points 
     * @param i the magical enemy's item
     */
    public MagicalEnemy(String n, int mHp, Item i) {
        super(n, mHp, i);
    }

    /** Randomly chooses a magical attack to attack the hero
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

    /** Uses a magic missile on the hero
     * @param e the hero being attacked
     * @return String the attack message
     */
    @Override
    public String magicMissile(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(7) + 1;
        e.takeDamage(damage);

        return getName() + " hits " + e.getName() + " with a Magic Missle for "
        + damage + " damage.";
    }

    /** Uses a fireball on the hero
     * @param e the hero being attacked
     * @return String the attack message
     */
    @Override
    public String fireball(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(7) + 1;
        e.takeDamage(damage);

        return getName() + " hits " + e.getName() + " with a Fireball for "
        + damage + " damage.";
    }

    /** Uses thunderclap on the hero
     * @param e the hero being attacked
     * @return String the attack message
     */
    @Override
    public String thunderclap(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(7) + 1;
        e.takeDamage(damage);

        return getName() + " zaps " + e.getName() + " with Thunderclap for "
        + damage + " damage.";
    }
}
