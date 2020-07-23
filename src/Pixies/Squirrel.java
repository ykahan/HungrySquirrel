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

    public Squirrel() {
        maze = new Maze();
        create(); // gets row and column, validates, create location

    }

    public Squirrel(int row, int column) {
        maze = new Maze();
        location = new Location(row, column);
    }

    private int getNutsEaten() {
        return totalNutsEaten;
    }

    private void incrementsNutsEaten() {
        totalNutsEaten++;
    }

    public void increasePoints(int newPoints) {
        pointsCollected = pointsCollected + newPoints;
    }

    public int getPoints() {
        return pointsCollected;
    }

    public void create() {
        boolean locationUnavailable = true;
        Messages.squirrelLocation();
        int row = -1;
        int column = -1;
        while (locationUnavailable) {
            try {
                Messages.getRow();
                row = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                Messages.invalidInput();
                continue;
            }
            try {
                Messages.getColumn();
                column = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                Messages.invalidInput();
                continue;
            }
            locationUnavailable = locNotAvailable(row, column);
            if(locationUnavailable) Messages.locationInvalid();
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

        Entity entity = maze.getEntity(row - 1, column - 1);
        return !(entity instanceof Wall);
    }

    public boolean locNotAvailable(int row, int column) {
        return !locAvailable(row, column);
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
        private int row;
        private int column;

        public SetRowAndColumn(int row, int column) {
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
            boolean foundAvailableLoc = false;
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
