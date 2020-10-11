/** Item class to represent an item */
public class Item {
    /** A private instance variable that is the name of the item */
    private String name;

    /** Constructs an item
     * @param n the item name
     */
    public Item(String n) {
        name = n;
    }

    /** Returns the name of the item
     * @return String the item name
     */
    public String getName() {
        return name;
    }
}
