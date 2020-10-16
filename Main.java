public class Main {
    public static void main(String[] args) {
        System.out.println("What is your name, traveler? ");
        String name = CheckInput.getString();
        Map map = new Map();
        Hero hero = new Hero(name, map);
        int choice = 0;

        for (int level = 0; level < 3; level++) {
            while(choice != 5 || hero.getHP() != 0) {
                System.out.println(hero.getName());
                System.out.println(hero.toString());
                System.out.println(hero.itemsToString());
                map.loadMap(level);
                map.displayMap(hero.getLocation());
    
                System.out.println("1. Go North\n2. Go South\n3. Go East\n" +
                "4. Go West\n5. Quit");
                choice = CheckInput.getIntRange(1, 5);
                if (choice == 1) {
                    hero.goNorth();
                }
                else if (choice == 2) {
                    hero.goSouth();
                }
                else if (choice == 3) {
                    hero.goEast();
                }
                else if (choice == 4) {
                    hero.goWest();
                }
                else if (choice == 5) {
                    System.out.println("You've chosen to quit. Game over.");
                }
            }
        }
        if (hero.getHP() == 0) {
            System.out.println("You've died. Game over.");
        }
    }

    public static boolean monsterRoom(Hero h, Map m, EnemyGenerator eg, int level) {
        boolean hasMonster = false;
        if (m.getCharAtLoc(h.getLocation()) == 'm') {
            hasMonster = true;
        }
        return hasMonster;
    }

    public static boolean fight(Hero h, Enemy e) {
        int choice = 0;
        ItemGenerator ig = new ItemGenerator();
        // if monsterRoom is true
        System.out.println("You've encountered a " + e.getName());
        System.out.println(e.getName());
        System.out.println(e.toString());

        if (h.hasPotion() == true) {
            System.out.println("1. Fight\n2. Run Away\n3. Drink Health Potion");
            choice = CheckInput.getIntRange(1, 3);
        }
        else {
            System.out.println("1. Fight\n2. Run Away");
            choice = CheckInput.getIntRange(1, 2);
        }

        if (choice == 1) {
            while (e.getHP() > 0) {
                System.out.println("1. Physical Attack\n2. Magic Attack");
                choice = CheckInput.getIntRange(1, 2);
                if (choice == 1) {
                    h.attack(e);
                }
                else {
                    System.out.println(Magical.MAGIC_MENU);
                    choice = CheckInput.getIntRange(1, 3);
                    if (choice == 1) {
                        h.magicMissile(e);
                    }
                    else if (choice == 2) {
                        h.fireball(e);
                    }
                    else {
                        h.thunderclap(e);
                    }
                }
            }
            if (e.getHP() == 0) {
                System.out.println("You defeated the " + e.getName() + "!");
                System.out.println("You received a " + ig.generateItem() + 
                "from its corpse.");
            }
        }
        else if (choice == 2) {
            //you run, so monsterRoom is false?
        }
        else {
            h.drinkPotion();
        }
    }

    public static void itemRoom(Hero h, Map m, ItemGenerator ig) {

    }
}
