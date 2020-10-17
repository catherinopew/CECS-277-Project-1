import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("What is your name, traveler? ");
        String name = CheckInput.getString();
        
        int level = 1;
        Map map = new Map();
        map.loadMap(level);
        Hero hero = new Hero(name, map);
        ItemGenerator ig = new ItemGenerator();
        EnemyGenerator eg = new EnemyGenerator(ig);

        int choice = 0;
        while (hero.getHP() != 0) {
            System.out.println(hero.toString());
            System.out.println(hero.itemsToString());
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
                break;
            }
            //monster room
            if (monsterRoom(hero, map, eg, level) == true) {
                Enemy enemy = eg.generateEnemy(level);
                System.out.println("You've encountered a " + enemy.getName());
                while(fight(hero, enemy) == true);
                if (enemy.getHP() == 0) {
                    System.out.println("You defeated the " + enemy.getName() + "!");
                    hero.pickUpItem(enemy.getItem());
                    map.reveal(hero.getLocation());
                    map.removeCharAtLoc(hero.getLocation());

                    if (hero.pickUpItem(enemy.getItem()) == true) {
                        System.out.println("You received a " + enemy.getItem().getName() + 
                        " from its corpse.");
                    }
                }
            }
            //item room
            else if (map.getCharAtLoc(hero.getLocation()) == 'i') {
                itemRoom(hero, map, ig);
            }
            //empty room
            else if (map.getCharAtLoc(hero.getLocation()) == 'n') {
                System.out.println("There was nothing here.");
            }
            // finish
            else if (map.getCharAtLoc(hero.getLocation()) == 'f') {
                System.out.println("You've completed level " + level + ".");
                level++;
                map.loadMap(level);
                hero.heal(hero.getMaxHP());
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
        System.out.println(e.toString());
        int choice = 0;

        if (h.hasPotion() == true) {
            System.out.println("1. Fight\n2. Run Away\n3. Drink Health Potion");
            choice = CheckInput.getIntRange(1, 3);
        }
        else {
            System.out.println("1. Fight\n2. Run Away");
            choice = CheckInput.getIntRange(1, 2);
        }

        if (e instanceof MagicalEnemy) {
            e = (MagicalEnemy) e;
        }
        if (choice == 1) {
            System.out.println("1. Physical Attack\n2. Magic Attack");
            choice = CheckInput.getIntRange(1, 2);
            if (choice == 1) {
                System.out.println(h.attack(e));
                if (e.getHP() != 0) {
                    System.out.println(e.attack(h));
                }
            }
            else {
                System.out.println(Magical.MAGIC_MENU);
                choice = CheckInput.getIntRange(1, 3);
                if (choice == 1) {
                    System.out.println(h.magicMissile(e));
                    if (e.getHP() != 0) {
                        System.out.println(e.attack(h));
                    }
                }
                else if (choice == 2) {
                    System.out.println(h.fireball(e));
                    if (e.getHP() != 0) {
                        System.out.println(e.attack(h));
                    }
                }
                else {
                    System.out.println(h.thunderclap(e));
                    if (e.getHP() != 0) {
                        System.out.println(e.attack(h));
                    }
                }
            }
            if (e.getHP() == 0 || h.getHP() == 0) {
                return false;
            }
            else {
                return true;
            }
        }
        else if (choice == 2) {
            Random rand = new Random();
            int random = 0;

            if (h.getLocation().getY() == 0 || h.getLocation().getY() == 4) {
                random = rand.nextInt(2) + 1;
                if (random == 1) {
                    h.goNorth();
                }
                else {
                    h.goSouth();
                }
            }
            else if (h.getLocation().getX() == 0 || h.getLocation().getX() == 4) {
                random = rand.nextInt(2) + 1;
                if (random == 1) {
                    h.goEast();
                }
                else {
                    h.goWest();
                }
            }
            else {
                random = rand.nextInt(4) + 1;
                if (random == 1) {
                    h.goNorth();
                }
                else if (random == 2) {
                    h.goSouth();
                }
                else if (random == 3) {
                    h.goEast();
                }
                else {
                    h.goWest();
                }
            }
            return false;
        }
        else {
            h.drinkPotion();
            return true;
        }
    }

    public static void itemRoom(Hero h, Map m, ItemGenerator ig) {
        h.pickUpItem(ig.generateItem());
        if (h.pickUpItem(ig.generateItem()) == true) {
            System.out.println("You've picked up a " + ig.generateItem().getName());
        }
        if (h.pickUpItem(ig.generateItem()) == true) {
            m.removeCharAtLoc(h.getLocation());
        }
    }
}
