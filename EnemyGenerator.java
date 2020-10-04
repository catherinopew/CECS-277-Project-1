import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EnemyGenerator {
    private ArrayList <Enemy> enemyList = new ArrayList <Enemy> ();
    private ItemGenerator ig;

    public EnemyGenerator(ItemGenerator ig) {
        try {
            Scanner read = new Scanner(new File("EnemyList.txt"));
            
            while(read.hasNextLine()) {
                String line = read.nextLine();
                String [] token = line.split(",");
                enemyList.add(new Enemy(token[0], 
                Integer.parseInt(token[1]), ig)); 
            }
            read.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File Not Found - place in project folder");
        }
    }

    public Enemy generateEnemy(int level) {
        int random = 0;
        random = (int)(Math.random() * enemyList.size());
        return enemyList.get(random);
    }
}
