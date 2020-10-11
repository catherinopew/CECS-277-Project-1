import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** EnemyGenerator class that generates an enemy */
public class EnemyGenerator {
    /** A private ArrayList enemyList of type Enemy */
    private ArrayList <Enemy> enemyList = new ArrayList <Enemy> ();
    /** A private instance variable ig of type ItemGenerator */
    private ItemGenerator ig;

    /** Reads from the EnemyList.txt file 
     * and adds each enemy to the ArrayList
     * @param ig item to be generated 
     */
    public EnemyGenerator(ItemGenerator ig) {
        try {
            Scanner read = new Scanner(new File("EnemyList.txt"));
            
            while(read.hasNextLine()) {
                String line = read.nextLine();
                String [] token = line.split(",");
                enemyList.add(new Enemy(token[0], 
                Integer.parseInt(token[1]), ig.generateItem())); 
            }
            read.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File Not Found - place in project folder");
        }
    }

    /** Randomly generates an enemy from the ArrayList
     * @param level the level in which the game is on
     * @return a randomly generated enemy
     */
    public Enemy generateEnemy(int level) {
        int random = 0;
        random = (int)(Math.random() * enemyList.size());
        return enemyList.get(random);
    }
}
