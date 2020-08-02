package Pixies;

import General.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquirrelTest {
    @Test
    void testLocAvailableCoordinateIsAvailable(){
        Movable squirrel = new Squirrel(14, 10);
        boolean isOpenSpace = squirrel.locAvailable(10, 10);
        assertTrue(isOpenSpace);
    }

    @Test
    void testLocAvailableCoordinateIsNotAvailable(){
        Movable squirrel = new Squirrel(14, 10);
        boolean isWall = !squirrel.locAvailable(12, 20);
        assertTrue(isWall);
    }

    @Test
    void testLocAvailableNegXCoordinateIsOutsideMaze(){
        Movable squirrel = new Squirrel(15, 10);
        boolean isOutsideMaze = !squirrel.locAvailable(-5, 15);
        assertTrue(isOutsideMaze);
    }

    @Test
    void testLocAvailableNegYCoordinateIsOutsideMaze(){
        Movable squirrel = new Squirrel(15, 10);
        boolean isOutsideMaze = !squirrel.locAvailable(5, -5);
        assertTrue(isOutsideMaze);
    }

    @Test
    void testLocAvailableHighXCoordinateIsOutsideMaze(){
        Movable squirrel = new Squirrel(15, 10);
        boolean isOutsideMaze = !squirrel.locAvailable(100, 10);
        assertTrue(isOutsideMaze);
    }

    @Test
    void testLocAvailableHighYCoordinateIsOutsideMaze(){
        Movable squirrel = new Squirrel(15, 10);
        boolean isOutsideMaze = !squirrel.locAvailable(10, 100);
        assertTrue(isOutsideMaze);
    }

//    @Test
    void testParamaterlessConstructor(){
        Maze maze = new Maze();
        Squirrel squirrel = new Squirrel(maze);
        assertTrue(squirrel instanceof Squirrel);
    }

    @Test
    void symbolIsAtSymbol(){
        Squirrel squirrel = new Squirrel(14, 14);
        char squirrelSymbol = squirrel.getSymbol();
        assertTrue(squirrelSymbol == '@');
    }

}