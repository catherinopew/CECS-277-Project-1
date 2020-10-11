import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** ItemGenerator class that generates an item */
public class ItemGenerator {
    /** A private ArrayList itemList of type Item */
    private ArrayList <Item> itemList = new ArrayList <Item> ();

    /** Reads from the ItemList.txt file 
     * and adds each item to the ArrayList
     */
    public ItemGenerator() {
        try {
            Scanner read = new Scanner(new File("ItemList.txt"));
            
            while(read.hasNextLine()) {
                String line = read.nextLine();
                itemList.add(new Item(line));
            }
            read.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File Not Found - place in project folder");
        }
    }

    /** Randomly generates an item from the ArrayList
     * @return a randomly generated item
     */
    public Item generateItem() {
        int random = 0;
        random = (int)(Math.random() * itemList.size());
        return itemList.get(random);
    }
}
