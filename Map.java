import java.io.*;
import java.util.Scanner;

public class Map{
  //private instance var
  private char [][] map = new char [5][5];

  /*private boolean [][] revealed = new boolean [5][];*/

  //Constructor 
  Map(){
    int character_position = map[2][0];
    int mapNum = 1;
  }
  public void loadMap(int mapNum){
    try{
      /* redundant... map should be displayed in diplayma() */
      if (mapNum == 1){  
        Scanner read = new Scanner (new File("Map1.txt"));
        
        while (read.hasNext()){
          String line = read.nextLine();
          System.out.println(line);
       
        }
        read.close();
       
      }
      
      else if (mapNum == 2){
        Scanner read = new Scanner (new File("Map2.txt"));
        
        while (read.hasNext()){
          String line = read.nextLine();
          System.out.println(line);
        }
        read.close();
      }
      else if (mapNum == 3){
        Scanner read = new Scanner (new File("Map1.txt"));
        
        while (read.hasNext()){
          String line = read.nextLine();
          System.out.println(line);
        }

        read.close();
      }
      else if (mapNum == 4){
        Scanner read = new Scanner (new File("Map2.txt"));
        while (read.hasNext()){
          String line = read.nextLine();
          System.out.println(line);
        }
        read.close();
      }
      
      
    } catch (FileNotFoundException fnf){
      System.out.print("NO FILE FOUND.");
    }
  }
  public char getCharAtLoc(point p){
    character_position = character_position.p;
    return character_position;
  }
  
}
