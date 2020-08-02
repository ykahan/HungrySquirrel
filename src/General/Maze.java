package General;

import Pixies.Squirrel;
import Walls.Wall;

import java.io.File;
import java.util.Scanner;

public class Maze {
    private static final int MAX_ROW = 20;
    private static final int MAX_COLUMN = 50;
    private static Entity[][] maze;
    private static Scanner scanner;
    private static final int MAX_NUTS = 5;

    public Maze() {
        maze = new Entity[MAX_ROW][MAX_COLUMN];
        defineScanner();
        create();
    }

    public static void create() {
        try {
            for (int row = 0; row < MAX_ROW; row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int column = 0; column < MAX_COLUMN; column++) {
                    Entity entity = null;
                    if (chars[column] == '*') entity = new Wall();
                    else entity = new OpenSpace();

                    maze[row][column] = entity;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public int getMaxNuts(){
        return this.MAX_NUTS;
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

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();
        for (int row = 0; row < MAX_ROW; row++) {
            for (int column = 0; column < MAX_COLUMN; column++) {
                if (column == 0 && row > 0) {
                    description.append("\n");
                }

                Entity entity = getEntity(row, column);
                String symbol = Character.toString(entity.getSymbol());
                description.append(symbol);

            }
        }
        return description.toString();
    }

    public void display() {
        System.out.println(toString());
    }

    public int getMaxRow() {
        return MAX_ROW;
    }

    public int getMaxColumn(){
        return MAX_COLUMN;
    }
}
