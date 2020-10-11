import java.util.ArrayList;
import java.util.Random;

public class Hero extends Entity {
    private ArrayList <Item> items = new ArrayList <Item> ();
    private Map map; 
    private Point location;

    public Hero (String n, Map m) {
        super(n, 25);
        map = m;
    }

    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(15) + 1;
        e.takeDamage(damage);
        return getName() + "attacks" + e.getName() 
        + "for" + damage + "damage.";
    }

    @Override
    public String toString() {
        return super.toString(); //prob this but idk
    }

    //@Override?
    public String itemsToString() {
        String itemString = "Inventory: \n";
        for (int i = 0; i < items.size(); i++) {
            itemString += i + ". " + items.get(i) + "\n";
        }
        return itemString;
    }

    public int getNumItems() {
        return items.size();
    }

    public boolean pickUpItem(Item i) {
        boolean pickUp = false;
        if (items.size() < 5) {
            items.add(i);
            pickUp = true;
        }
        return pickUp;
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
        return potion;
    }

    public Point getLocation() {
        return location;
    }

    public char goNorth() {
        location.translate(0, 1);    
        return map.getCharAtLoc(location);
    }

    public char goSouth() {
        location.translate(0, -1);    
        return map.getCharAtLoc(location);
    }

    public char goEast() {
        location.translate(1,0);    
        return map.getCharAtLoc(location);
    }

    public char goWest() {
        location.translate(-1,0);    
        return map.getCharAtLoc(location);
    }
}
