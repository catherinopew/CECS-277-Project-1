/** Interface for magical attacks of an entity */
public interface Magical {
    /** The menu for the magical attacks */
    public static final String MAGIC_MENU = "1. Magic Missle\n" +
    "2. Fireball\n3. Thunderclap";

    /** Uses a magic missile on the entity being attacked
     * @param e the entity being attacked
     * @return String the attack message
     */
    public String magicMissile(Entity e);

    /** Uses a fireball on the entity being attacked
     * @param e the entity being attacked
     * @return String the attack message
     */
    public String fireball(Entity e);

    /** Uses thunderclap on the entity being attacked
     * @param e the entity being attacked
     * @return String the attack message
     */
    public String thunderclap(Entity e);
}
