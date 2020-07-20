package Pixies;

import General.Entity;
import General.Maze;
import General.OpenSpace;

public class Squirrel implements Movable{
    public static void main(String[] args) {
        Maze testMaze = new Maze();
    }

    public boolean locAvailable(Maze maze, int row, int column){
        Entity entity = maze.getEntity(row, column);
        return entity instanceof OpenSpace;
    }
}
