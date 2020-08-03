package Pixies;

import General.Entity;
import General.Location;
import General.Maze;
import General.OpenSpace;
import Nuts.Nut;
import Walls.Wall;

import java.util.Scanner;

import Messages.Messages;

public class Squirrel extends Entity implements Movable {
    private Location location;
    private Maze maze;
    private Scanner scanner = new Scanner(System.in);
    private int pointsCollected = 0;
    private int totalNutsEaten = 0;

    public static void main(String[] args) {
        Maze maze = new Maze();
        Squirrel sq = new Squirrel(maze);
    }

    public Squirrel(Maze maze) {
        super('@');
        this.maze = maze;
        create(); // gets row and column, validates, create location
    }

    public Squirrel(int row, int column) {
        super('@');
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
            if (locationUnavailable) Messages.locationInvalid();
        }
        location = new Location(row - 1, column - 1);  // convert user-input into zero-based equivalent
        maze.setEntity(this, location.getRow(), location.getColumn());
    }

    public void move(char direction) {

        int row = location.getRow();
        int column = location.getColumn();
        
        switch (Character.toUpperCase(direction)) {
            case ('W'):
                row = row - 1;
                break;
            case ('A'):
                column = column - 1;
                break;
            case ('S'):
                row = row + 1;
                break;
            case ('D'):
                column = column + 1;
                break;
            default:
                break;
        }

        if (locAvailable(row, column)) {
            maze.setEntity(new OpenSpace(), location.getRow(), location.getColumn());
            getNut(row, column);
            setLocation(row, column);
        }
        else Messages.invalidInput();
    }

    private void getNut(int row, int column){
        Entity entity = maze.getEntity(row, column);
        if (entity instanceof Nut) {
            this.totalNutsEaten = this.totalNutsEaten + 1;
            this.pointsCollected = this.pointsCollected + ((Nut) entity).getNutritionPoints();
        }
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
        private boolean isNotValidInteger;
        private int row;

        public SetRow(int row) {
            this.row = row;
        }

        boolean isInvalidInteger() {
            return isNotValidInteger;
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
                isNotValidInteger = true;
                return this;
            }
            isNotValidInteger = false;
            return this;
        }
    }

    private class SetColumn {
        private boolean isNotValidInteger;
        private int column;

        public SetColumn(int column) {
            this.column = column;
        }

        boolean isNotValidInteger() {
            return isNotValidInteger;
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
                isNotValidInteger = true;
                return this;
            }
            isNotValidInteger = false;
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

                SetRow setRow = new SetRow(row).invoke();
                if (setRow.isInvalidInteger()) continue;
                row = setRow.getRow();

                SetColumn setColumn = new SetColumn(column).invoke();
                if (setColumn.isNotValidInteger()) continue;
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
