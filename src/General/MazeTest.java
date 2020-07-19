package General;

import Walls.Wall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void createMakesWalls() {
        Maze maze = new Maze();
        assertEquals(maze.getEntity(0, 0).getClass().getName(), "Walls.Wall");
    }

    @Test
    void createMakesNulls(){
        Maze maze = new Maze();
        assertNull(maze.getEntity(7, 3), "'Error: Entity not null");
    }

    @Test
    void getEntity() {
        Maze maze = new Maze();
        assertEquals(maze.getEntity(0, 0).getClass().getName(), "Walls.Wall");
    }

    @Test
    void setEntity() {
        Maze maze = new Maze();
        maze.setEntity(null, 0, 0);
        assertNull(maze.getEntity(7, 3), "'Error: Entity not null");
    }

    @Test
    void testToString() {
    }

    @Test
    void display() {
    }
}