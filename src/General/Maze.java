package General;

import Walls.Wall;

import java.io.File;
import java.util.Scanner;

public class Maze {
    private static final int maxRow = 20;
    private static final int maxColumn = 50;
    private static Entity[][] maze;
    private static Scanner scanner;

    public Maze(){
        maze = new Entity[maxRow][maxColumn];
        create();
    }

    public static void create(){
        defineScanner();
        try{
            for(int row = 0; row < maxRow; row++){
                char[] chars = scanner.nextLine().toCharArray();
                for(int column = 0; column < maxColumn; column++){
                    Entity entity = null;
                    if(chars[row] == '*') entity = new Wall();

                    maze[row][column] = entity;
                }
            }
        } catch(Exception e){
            System.out.println(e.toString());
        }
        scanner.close();
    }

    private static void defineScanner() {
        String filename = "C:\\Users\\yehos\\Programming\\Anton Files\\HungrySquirrel\\Maze.txt";
        File file = new File(filename);
        try{
            scanner = new Scanner(file);
        } catch(Exception e){

        }
    }

    public static Entity getEntity(int newRow, int newColumn) {
        return maze[newRow][newColumn];
    }

    public static void setEntity(Entity entity, int newRow, int newColumn) {
        maze[newRow][newColumn] = entity;
    }

    @Override
    public String toString(){
        String description = "";
        for(int row = 0; row < maxRow; row++){
            for(int column = 0; column < maxColumn; column++){
                Entity entity = maze[row][column];
                if(column == 0 && row > 0) description += "\n";
                if(entity != null){{
                    if(entity.getClass().getName().contentEquals("Wall)")){
                        description += "*";
                    }
                }
                } else description += " ";
            }
        }
        return description;
    }

    public void display(){
        System.out.println(toString());
    }

}
