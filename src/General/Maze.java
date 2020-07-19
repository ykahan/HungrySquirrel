package General;

import Walls.Wall;

import java.io.File;
import java.util.Scanner;

public class Maze {
    private static final int maxRow = 20;
    private static final int maxColumn = 50;
    private static Entity[][] maze;
    private static Scanner scanner;

    public Maze() {
        maze = new Entity[maxRow][maxColumn];
        create();
    }

    public static void create() {
        defineScanner();
        try {
            for (int row = 0; row < maxRow; row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int column = 0; column < maxColumn; column++){
                    Entity entity = null;
                    if (chars[column] == '*') entity = new Wall();
                    else entity = new Placeholder();

                    maze[row][column] = entity;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        scanner.close();
    }

    private static void defineScanner() {
        String filename = "C:\\Users\\yehos\\Programming\\Anton Files\\HungrySquirrel\\Maze.txt";
        File file = new File(filename);
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {

        }
    }

    public static Entity getEntity(int newRow, int newColumn) {
        return maze[newRow][newColumn];
    }

    public static void setEntity(Entity entity, int newRow, int newColumn) {
        maze[newRow][newColumn] = entity;
    }

    public String describe(){
        String str = "";
        for(int row = 0; row < maxRow; row++){
            for(int column = 0; column < maxColumn; column++){
                Entity entity = getEntity(row, column);
                if(column == 0 && row > 0) str += "\n";
                if(entity.getClass().equals(new Wall().getClass())) str += "W ";
                else if (entity.getClass().equals(new Placeholder().getClass())) str += "P ";
            }
        }
        return str;
    }

    @Override
    public String toString() {
        String description = "";
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                if (column == 0 && row > 0) {
                    description += "\n";
                }

                Entity entity = getEntity(row, column);
                if (entity.getClass().equals(new Wall().getClass())) {
                    description += "*";
                } else if (entity.getClass().equals(new Placeholder().getClass())){
                    description += " ";
                }

            }
        }
        description = description;
        return description;
    }

    public void display() {
        System.out.println(toString());
    }

}
