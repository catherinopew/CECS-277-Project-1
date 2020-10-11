import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Map {
  //private instance var
  private char [][] map = new char [5][5];

  private boolean [][] revealed = new boolean [][]{};

  //Constructor 
  public Map() {
    char character_position = map[2][0];
    int mapNum = 1;
  }

  public void loadMap(int mapNum) {
    if(mapNum == 1 || mapNum == 4 || mapNum == 7) {
      displayMap(findStart());
    }
    else if(mapNum == 2 || mapNum == 5 || mapNum == 8) {
      displayMap(findStart());
    }
    else {
      displayMap(findStart());
    }
  }

  public char getCharAtLoc(Point p) {
    return map[p.getX()][p.getY()];
  }

  public void displayMap(Point p) {
    try {
      if (p.getX() == 2 && p.getY() == 0) {
        Scanner read = new Scanner(new File("Map1.txt"));
        while (read.hasNext()) {
          String line = read.nextLine();
          System.out.println(line);
        }
        read.close();
      }
      else if (p.getX() == 4 && p.getY() == 4) {
        Scanner read = new Scanner(new File("Map2.txt"));
        while (read.hasNext()) {
          String line = read.nextLine();
          System.out.println(line);
        }
        read.close();
      }
      else {
        Scanner read = new Scanner(new File("Map3.txt"));
        while (read.hasNext()) {
          String line = read.nextLine();
          System.out.println(line);
        }
        read.close();
      }
    } catch (FileNotFoundException e) {
      System.out.println("File Not Found - place in project folder");
    }
  }

  public Point findStart() {
    Point start = new Point();
    for (int i = 0; i < 5; i++) {
      for (int j = 0; i < 5; j++) {
        if (map [i][j] == 's') {
          start.setLocation(i, j);
        }
      }
    }
    return start;
  }

  public void reveal(Point p) {
    revealed [p.getX()][p.getY()] = true;
  }

  public void removeCharAtLoc(Point p) {
    map[p.getX()][p.getY()] = '\0';
  }
}
