import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** Map class that represents the map that the hero is on */
public class Map {
  /** A 2D array of chracters of the map */
  private char [][] map;
  /** A 2D array of boolean values */
  private boolean [][] revealed;

  /** Constructs a 5 x 5 map and 5 x 5 revealed */
  public Map() {
    map = new char [5][5];
    revealed = new boolean [5][5];
  }

  /** Reads in and loads the appropriate map file given the map number
   * and fills the 2D array with values
   * @param mapNum the map number
   */
  public void loadMap(int mapNum) {
    try {
      if (mapNum > 3) { //beyond level 3, repeat first map, second, and so on
        if (mapNum % 3 == 1) {
          mapNum = 1;
        }
        else if (mapNum % 3 == 2) {
          mapNum = 2;
        }
        else {
          mapNum = 3;
        }
      }
      Scanner read = new Scanner(new File("Map" + mapNum + ".txt"));
      while (read.hasNextLine()) {
        for (int i = 0; i < map.length; i++) {
          String line = read.nextLine().replace(" ", "");
          for (int j = 0; j < map.length; j++) {
            map[i][j] = line.charAt(j);
            revealed[i][j] = false;
          }
        }
      }
      read.close();
    } catch (FileNotFoundException e) {
      System.out.println("File Not Found - place in project folder");
    }
  }

  /** Retrieves the character at a certain location
   * @param p the point coordinates of the location
   * @return char the character at the location
   */
  public char getCharAtLoc(Point p) {
    return map[p.getX()][p.getY()];
  }

  /** Displays the map with the appropriate characters
   * @param p the point coordinates of the hero's location
   */
  public void displayMap(Point p) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map.length; j++) {
        if (i == p.getX() && j == p.getY()) { //hero's current location
          System.out.print('*');
        }
        else if (revealed[i][j] == true) { //reveal char underneath if hero visited
          System.out.print(map[i][j]);
        }
        else {
          System.out.print('x'); //hide the map chars underneath with x's
        }
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  /** Finds the hero's starting point on the map
   * @return Point the point coordinates of the starting point
   */
  public Point findStart() {
    Point start = new Point();
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map.length; j++) {
        if (map[i][j] == 's') {
          start.setLocation(i, j);
        }
      }
    }
    return start;
  }

  /** Reveals a character if the hero has visited that location
   * @param p the point coordinates of the location
   */
  public void reveal(Point p) {
    revealed[p.getX()][p.getY()] = true;
  }

  /** Removes a character at a certain location
   * @param p the point coordinates of the location
   */
  public void removeCharAtLoc(Point p) {
    map[p.getX()][p.getY()] = 'n'; //'n' signifying that there is nothing there
  }
}
