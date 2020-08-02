package Pixies;

import General.Maze;
import General.Placeable;

public interface Movable extends Placeable {
    public boolean locAvailable(int row, int column);
    public Maze getMaze();
    public boolean locationAvailable();
}