package Pixies;

import General.Entity;
import General.Location;
import General.Maze;
import General.OpenSpace;
import Walls.Wall;

import java.util.Scanner;

public class Squirrel implements Movable{
    private Location location;
    private Scanner scanner = new Scanner(System.in);
    private Maze maze;

    public Squirrel(Maze maze){
        this.maze = maze;
        boolean foundAvailableLoc = false;
        int row = -1;
        int column = -1;
        while(!foundAvailableLoc){
            System.out.println("Row: ");
            row = Integer.parseInt(scanner.nextLine());
            System.out.println("Column: ");
            column = Integer.parseInt(scanner.nextLine());
            foundAvailableLoc = locAvailable(maze, row, column);
            if(!foundAvailableLoc) System.out.println("Location not available, try again.");
        }
        this.location = new Location(row, column);
    }

    public static void main(String[] args) {
        Maze testMaze = new Maze();
    }

    public boolean locAvailable(Maze maze, int row, int column){
        if (locIsOutsideMaze(maze, row, column)) return false;

        Entity entity = maze.getEntity(row, column);
        return !(entity instanceof Wall);
    }

    public boolean locNotAvailable(Maze maze, int row, int column){
        if(locIsOutsideMaze(maze, row, column)) return true;

        Entity entity = maze.getEntity(row, column);
        return entity instanceof Wall;
    }

    private boolean locIsOutsideMaze(Maze maze, int row, int column) {
        if(row < 0 || column < 0) return true;
        if(row > maze.getMaxRow() || column > maze.getMaxColumn()) return true;
        return false;
    }
}
