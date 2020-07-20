package Pixies;

import General.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquirrelTest {
    @Test
    void testLocAvailableCoordinateIsAvailable(){
        Movable squirrel = new Squirrel();
        Maze maze = new Maze();
        boolean isOpenSpace = squirrel.locAvailable(maze, 10, 10);
        assertTrue(isOpenSpace);
    }

    @Test
    void testLocAvailableCoordinateIsNotAvailable(){
        Movable squirrel = new Squirrel();
        Maze maze = new Maze();
        boolean isWall = !squirrel.locAvailable(maze, 12, 20);
        assertTrue(isWall);
    }
}