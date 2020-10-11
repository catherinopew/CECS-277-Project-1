/** Interface for magical attacks of an entity */
public interface Magical {
    /** The menu for the magical attacks */
    public static final String MAGIC_MENU = "1. Magic Missle\n" +
    "2. Fireball\n3. Thunderclap";

    /** Method to make the entity use a magic missile */
    public String magicMissile(Entity e);
    /** Method to make the entity use a fireball */
    public String fireball(Entity e);
    /** Method to make the entity use thunderclap */
    public String thunderclap(Entity e);
}
