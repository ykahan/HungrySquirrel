package Pixies;

import General.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquirrelTest {
    @Test
    void testLocAvailableCoordinateIsAvailable(){
        Maze maze = new Maze();
        Movable squirrel = new Squirrel(maze);
        boolean isOpenSpace = squirrel.locAvailable(maze, 10, 10);
        assertTrue(isOpenSpace);
    }

    @Test
    void testLocAvailableCoordinateIsNotAvailable(){
        Maze maze = new Maze();
        Movable squirrel = new Squirrel(maze);
        boolean isWall = !squirrel.locAvailable(maze, 12, 20);
        assertTrue(isWall);
    }
}