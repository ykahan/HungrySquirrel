package Main;

import General.Maze;
import Pixies.Squirrel;

public class HungrySquirrelGame {
    public static void main(String[] args) {
        Maze maze = new Maze();
        Squirrel squirrel = new Squirrel(maze);
        maze.display();

    }

}
