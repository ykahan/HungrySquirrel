package Main;

import General.Maze;
import Pixies.Squirrel;

public class HungrySquirrelGame {
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.display();
        Squirrel squirrel = new Squirrel(maze);
        maze.display();
//        for(int i = 0; i < maze.getMaxNuts(); i++){
//
//        }

    }

}
