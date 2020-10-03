import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ItemGenerator {
    private ArrayList <Item> itemList = new ArrayList <Item> ();

    public ItemGenerator() {
        try {
            Scanner read = new Scanner(new File("ItemList.txt"));
            
            while(read.hasNext()) {
                String line = read.nextLine();
                String [] token = line.split("\n");
                itemList.add(new Item(token[0]));
            }
            read.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File Not Found - place in project folder");
        }
    }

    public Item generateItem() {
        int random = 0;
        random = (int)(Math.random() * itemList.size());
        return itemList.get(random);
    }
}
