package Pixies;

import General.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquirrelTest {
    @Test
    void testLocAvailableOpenSpace(){
        Movable squirrel = new Squirrel();
        Maze maze = new Maze();
        boolean isOpenSpace = squirrel.locAvailable(maze, 10, 10);
        assertTrue(isOpenSpace);
    }

    @Test
    void testLocAvailableWall(){
        Movable squirrel = new Squirrel();
        Maze maze = new Maze();
        boolean isWall = !squirrel.locAvailable(maze, 12, 20);
        assertTrue(isWall);
    }
}