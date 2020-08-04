package Main;

import General.Maze;
import Messages.Messages;
import Nuts.Almond;
import Nuts.Nut;
import Nuts.Peanut;
import Nuts.PoisonousCashew;
import Pixies.Squirrel;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HungrySquirrelGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Maze maze = new Maze();
        Squirrel squirrel = new Squirrel(maze);
        int poisonNuts = 0;
        for(int i = 0; i < maze.getMaxNuts(); i++){
            int nutInt = ThreadLocalRandom.current().nextInt(0, 4);
            if(nutInt == 0) new Almond(maze);
            else if (nutInt == 1) new Peanut(maze);
            else {
                new PoisonousCashew(maze);
                poisonNuts = poisonNuts + 1;
            }
        }

        while(maze.getEdibleNuts() > 0) {
            maze.setEdibleNuts(maze.getMaxNuts() - poisonNuts);
            maze.display();
            Messages.movementDirections();
            String directionString = scanner.nextLine();
            char directionChar = directionString.charAt(0);
            squirrel.move(directionChar);
        }

    }

}
