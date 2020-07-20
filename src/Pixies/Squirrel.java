package Pixies;

import General.Entity;
import General.Location;
import General.Maze;
import General.OpenSpace;
import Walls.Wall;

import java.util.Scanner;

import Messages.Messages;

public class Squirrel implements Movable {
    private Location location;
    private Scanner scanner = new Scanner(System.in);
    private Maze maze;

    public static void main(String[] args) {
        Squirrel sq = new Squirrel();
    }

    public Squirrel(int row, int column) {
        location = new Location(row, column);
        maze = new Maze();
    }

    public Squirrel() {
        maze = new Maze();
        boolean foundAvailableLoc = false;
        int row = -1;
        int column = -1;
        while (!foundAvailableLoc) {
            if (row == -1) {
                Messages.getRow();
                try {
                    row = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    Messages.invalidInput();
                }
            }
            Messages.getColumn();
            try {
                column = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                Messages.invalidInput();
            }
            foundAvailableLoc = locAvailable(row, column);
            if (!foundAvailableLoc) Messages.locationInvalid();
        }
        location = new Location(row, column);
    }

    public void setLocation(int row, int column) {
        this.location.setRow(row);
        this.location.setColumn(column);
    }

    public Maze getMaze() {
        return this.maze;
    }

    public boolean locAvailable(int row, int column) {
        if (locIsOutsideMaze(row, column)) return false;

        Entity entity = maze.getEntity(row, column);
        return !(entity instanceof Wall);
    }

    public boolean locNotAvailable(int row, int column) {
        if (locIsOutsideMaze(row, column)) return true;

        Entity entity = maze.getEntity(row, column);
        return entity instanceof Wall;
    }

    private boolean locIsOutsideMaze(int row, int column) {
        if (row < 0 || column < 0) return true;
        if (row > maze.getMaxRow() || column > maze.getMaxColumn()) return true;
        return false;
    }
}
