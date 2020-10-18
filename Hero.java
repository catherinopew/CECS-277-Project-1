import java.util.ArrayList;
import java.util.Random;

/** Hero class that represents a hero 
 * It extends Entity and implements the Magical interface
 */
public class Hero extends Entity implements Magical {
    /** An ArrayList of items that stores the hero's current items */
    private ArrayList <Item> items = new ArrayList <Item> ();
    /** The map that the hero is on */
    private Map map; 
    /** The location of the hero */
    private Point location;

    /** Constructs a hero
     * @param n the hero's name
     * @param m the map that the hero is currently on
     */
    public Hero (String n, Map m) {
        super(n, 25);
        map = m;
        location = map.findStart(); //puts hero at starting point of map
    }

    /** Displays the hero's current hp out of max hp 
     * @return String the hero's current hp out of max hp
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + itemsToString();
    }

    /** Displays the hero's current inventory
     * @return String a list of the hero's inventory
     */
    public String itemsToString() {
        String itemString = "Inventory:";
        for (int i = 0; i < items.size(); i++) {
            itemString += "\n" + (i + 1) + ". " + items.get(i).getName();
        }
        return itemString;
    }

    /** Retrieves the number of items in the hero's inventory
     * @return int the number of items in the inventory
     */
    public int getNumItems() {
        return items.size();
    }

    /** Picks up an item if the inventory isn't full
     * Gives user option to replace an inventory item if inventory is full
     * @param i the item being picked up
     * @return boolean true if the item is picked up, false otherwise
     */
    public boolean pickUpItem(Item i) {
        boolean pickUp = false;
        if (items.size() < 5) {
            items.add(i);
            pickUp = true;
        }
        else { 
            System.out.println("Your inventory is full. Do you still want " + 
            "to pick up this item (Y/N)? ");
            boolean choice = CheckInput.getYesNo();
            if (choice == true) { //ask if user wants to replace an item
                System.out.println("Which item number would you like to drop? " +
                "\n" + itemsToString()); //show them the current inventory
                int itemChoice = CheckInput.getIntRange(1, 5);
                System.out.println("You've chosen to drop a " + items.get(itemChoice - 1).getName() 
                + " and replaced it with a " + i.getName() + "."); //display message of what they dropped
                dropItem(itemChoice - 1);
                items.add(i);
                pickUp = true;
            }
            else { //otherwise, display message that user chose to not replace anything
                System.out.println("You've chosen to not replace any of " + 
                "your inventory items.");
            }
        }
        return pickUp;
    }

    /** Allows the hero to drink a potion if it is in inventory
     * Once healed, remove potion from the inventory
     */
    public void drinkPotion() {
        heal(getMaxHP()); //heal with maxHP amount b/c potion is +25
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals("Health Potion")) {
                dropItem(i);
            }
        }
    }

    /** Drops an item if the inventory is full and
     * hero wants to pick up a new item
     * @param index the index of the item to be dropped
     */
    public void dropItem(int index) {
        items.remove(index);
    }

    /** Determines whether the hero has a potion in their inventory
     * @return boolean true if hero has a potion, false otherwise
     */
    public boolean hasPotion() {
        boolean potion = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals("Health Potion")) {
                potion = true;
            }
        }
        return potion;
    }

    /** Retrieves the location of the hero
     * @return Point the coordinates of the hero's location
     */
    public Point getLocation() {
        return location;
    }

    /** Moves the hero North
     * and reveals the hero's location if hero isn't moved out of bounds
     * @return char the character at the hero's location on the map
     */
    public char goNorth() {
        if (location.getX() == 0) {
            System.out.println("You can't go there!"); //out of bounds message
            return map.getCharAtLoc(location);
        }
        else {
            map.reveal(location);
            location.translate(-1, 0);  
            return map.getCharAtLoc(location);
        }
    }
    
    /** Moves the hero South
     * and reveals the hero's location if hero isn't moved out of bounds
     * @return char the character at the hero's location on the map
     */
    public char goSouth() {
        if (location.getX() == 4) {
            System.out.println("You can't go there!");
            return map.getCharAtLoc(location);
        }
        else {
            map.reveal(location);
            location.translate(1, 0);  
            return map.getCharAtLoc(location);
        }
    }

    /** Moves the hero East
     * and reveals the hero's location if hero isn't moved out of bounds
     * @return char the character at the hero's location on the map
     */
    public char goEast() {
        if (location.getY() == 4) {
            System.out.println("You can't go there!");
            return map.getCharAtLoc(location);
        }
        else {
            map.reveal(location);
            location.translate(0, 1);  
            return map.getCharAtLoc(location);
        }
    }

    /** Moves the hero West
     * and reveals the hero's location if hero isn't moved out of bounds
     * @return char the character at the hero's location on the map
     */
    public char goWest() {
        if (location.getY() == 0) {
            System.out.println("You can't go there!");
            return map.getCharAtLoc(location);
        }
        else {
            map.reveal(location);
            location.translate(0, -1);  
            return map.getCharAtLoc(location);
        }
    }

    /** Performs a physical attack on the enemy
     * @param e the enemy being attacked
     * @return String the attack message
     */
    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(7) + 1; //random amount of damage 1-7
        e.takeDamage(damage);

        return getName() + " attacks " + e.getName() 
        + " for " + damage + " damage.";
    }

    /** Uses a magic missile on the enemy
     * @param e the enemy being attacked
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

    /** Uses a fireball on the enemy
     * @param e the enemy being attacked
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

    /** Uses thunderclap on the enemy
     * @param e the enemy being attacked
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
