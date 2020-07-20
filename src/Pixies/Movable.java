package Pixies;

import General.Maze;

public interface Movable {
    public boolean locAvailable(Maze maze, int row, int column);
}