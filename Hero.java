import java.util.ArrayList;
import java.awt.Point;
public class Hero extends Entity {
    private ArrayList <Item> items = new ArrayList <Item> ();
    private Map map; 
    private Point location;

    public Hero (String n, Map m) {
        super(n);
        map = m;
    }

    @Override
    public String toString() {
        String s = "";
        s += toString();
        return s;
    }

    @Override
    public String itemsToString() {
        String s = "";
        for (int i = 0; i < items.size(); i++) {
            s += i + ". " + items.get(i) + "\n";
        }
    }

    public int getNumItems() {
        int numOfItems = 0;
        for (int i = 0; i < items.size(); i++) {
            ++numOfItems;
        }
        return numOfItems;
    }

    public boolean pickUpItem(Item i) {

    }

    public void drinkPotion() {
        int potion = 25;
        heal(potion);
    }

    public void dropItem(int index) {
        items.remove(index);
    }

    public boolean hasPotion() {
        boolean potion = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName() == "Health Potion") {
                potion = true;
            }
        }
    }

    public Point getLocation() {
        return super.getLocation(); //idk
    }

    public char goNorth() {
        Point.translate(0, 1);
    }

    public char goSouth() {

    }

    public char goEast() {

    }

    public char goWest() {

    }
}
