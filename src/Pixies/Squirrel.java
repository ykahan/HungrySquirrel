package Pixies;

import General.Entity;
import General.Location;
import General.Maze;
import Walls.Wall;

import java.util.Scanner;

import Messages.Messages;

public class Squirrel implements Movable {
    private Location location;
    private Scanner scanner = new Scanner(System.in);
    private Maze maze;
    private int pointsCollected = 0;
    private int totalNutsEaten = 0;

    public static void main(String[] args) {
        Squirrel sq = new Squirrel();
    }

    public Squirrel(int row, int column) {
        location = new Location(row, column);
        maze = new Maze();
    }

    private int getNutsEaten(){
        return totalNutsEaten;
    }

    private void incrementsNutsEaten(){
        totalNutsEaten++;
    }

    public void increasePoints(int newPoints){
        pointsCollected = pointsCollected + newPoints;
    }

    public int getPoints(){
        return pointsCollected;
    }

    public Squirrel() {
        maze = new Maze();
        boolean foundAvailableLoc = false;
        int row = -1;
        int column = -1;

        SetRowAndColumn setRowAndColumn = new SetRowAndColumn(foundAvailableLoc, row, column).invoke();
        row = setRowAndColumn.getRow();
        column = setRowAndColumn.getColumn();

        location = new Location(row, column);
    }

    public void create(){
        Messages.squirrelLocation();
        Messages.getRow();
        try{int row = Integer.parseInt(scanner.nextLine());}
        catch(Exception e){Messages.invalidInput();}
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
        if (row <= 0 || column <= 0) return true;
        if (row > maze.getMaxRow() || column > maze.getMaxColumn()) return true;
        return false;
    }

    private class SetRow {
        private boolean myResult;
        private int row;

        public SetRow(int row) {
            this.row = row;
        }

        boolean is() {
            return myResult;
        }

        public int getRow() {
            return row;
        }

        public SetRow invoke() {
            Messages.getRow();
            try {
                row = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                Messages.invalidInput();
                myResult = true;
                return this;
            }
            myResult = false;
            return this;
        }
    }

    private class SetColumn {
        private boolean myResult;
        private int column;

        public SetColumn(int column) {
            this.column = column;
        }

        boolean is() {
            return myResult;
        }

        public int getColumn() {
            return column;
        }

        public SetColumn invoke() {
            Messages.getColumn();
            try {
                column = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                Messages.invalidInput();
                myResult = true;
                return this;
            }
            myResult = false;
            return this;
        }
    }

    private class SetRowAndColumn {
        private boolean foundAvailableLoc;
        private int row;
        private int column;

        public SetRowAndColumn(boolean foundAvailableLoc, int row, int column) {
            this.foundAvailableLoc = foundAvailableLoc;
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public SetRowAndColumn invoke() {
            while (!foundAvailableLoc) {
                if (row == -1) {
                    SetRow setRow = new SetRow(row).invoke();
                    if (setRow.is()) continue;
                    row = setRow.getRow();
                }
                SetColumn setColumn = new SetColumn(column).invoke();
                if (setColumn.is()) continue;
                column = setColumn.getColumn();

                foundAvailableLoc = locAvailable(row, column);

                if (!foundAvailableLoc) {
                    Messages.locationInvalid();
                    row = -1;
                    column = -1;
                }
            }
            return this;
        }
    }
}
