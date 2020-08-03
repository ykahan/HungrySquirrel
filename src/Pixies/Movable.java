package Pixies;

import General.Maze;

public interface Movable {
    public boolean locAvailable(int row, int column);
    public Maze getMaze();
}