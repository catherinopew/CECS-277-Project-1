import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

/** EnemyGenerator class that generates an enemy */
public class EnemyGenerator {
    /** An ArrayList of the enemies */
    private ArrayList <Enemy> enemyList = new ArrayList <Enemy> ();
    /** A randomly generated item */
    private ItemGenerator ig;

    /** Reads from the EnemyList.txt file 
     * Constructs and adds each enemy to the ArrayList, enemyList
     * @param ig item to be generated 
     */
    public EnemyGenerator(ItemGenerator ig) {
        this.ig = ig;
        try {
            Scanner read = new Scanner(new File("EnemyList.txt"));
            while(read.hasNextLine()) {
                String line = read.nextLine();
                String [] token = line.split(",");
                Random rand = new Random(); 
                int randHealth = rand.nextInt(4) + 1;
                if (token[2] == "p") {
                    enemyList.add(new Enemy(token[0], 
                    Integer.parseInt(token[1]) + randHealth, ig.generateItem())); 
                }
                else {
                    enemyList.add(new MagicalEnemy(token[0], 
                    Integer.parseInt(token[1]) + randHealth, ig.generateItem())); 
                }
            }
            read.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File Not Found - place in project folder");
        }
    }

    /** Randomly generates an enemy from the ArrayList
     * @param level the level in which the game is on
     * @return Enemy a randomly generated enemy
     */
    public Enemy generateEnemy(int level) {
        int random = (int)(Math.random() * enemyList.size());

        if (enemyList.get(random) instanceof Enemy) {
            Enemy physical = new Enemy(enemyList.get(random).getName(),
            enemyList.get(random).getMaxHP(), enemyList.get(random).getItem());
            return physical;
        }
        else {
            Enemy magical = new MagicalEnemy(enemyList.get(random).getName(),
            enemyList.get(random).getMaxHP(), enemyList.get(random).getItem());
            return magical;
        }
    }
}
