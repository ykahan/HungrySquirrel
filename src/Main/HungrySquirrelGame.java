package Main;

import General.Maze;
import Nuts.Almond;
import Nuts.Nut;
import Nuts.Peanut;
import Pixies.Squirrel;

import java.util.concurrent.ThreadLocalRandom;

public class HungrySquirrelGame {
    public static void main(String[] args) {
        Maze maze = new Maze();
        Squirrel squirrel = new Squirrel(maze);
        for(int i = 0; i < maze.getMaxNuts(); i++){
            Nut nut;
            int nutInt = ThreadLocalRandom.current().nextInt(0, 3);
            if(nutInt == 0) nut = new Almond(maze);
            else nut = new Peanut(maze);
        }
        maze.display();

    }

}
