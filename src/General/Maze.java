package General;

import Walls.Wall;

import java.util.Scanner;

public class Maze {
    private static final int maxRow = 20;
    private static final int maxColumn = 50;
    private static Entity[][] maze;

    public static void create(String filename){
        Scanner scanner = new Scanner(filename);
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

}
