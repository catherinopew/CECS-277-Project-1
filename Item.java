/** Item class to represent an item */
public class Item {
    /** The name of the item */
    private String name;

    /** Constructs an item
     * @param n the item's name
     */
    public Item(String n) {
        name = n;
    }

    /** Retrieves the name of the item
     * @return String the item name
     */
    public String getName() {
        return name;
    }
}
