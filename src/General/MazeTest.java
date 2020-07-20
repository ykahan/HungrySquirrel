package General;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void createMakesWalls() {
        Maze maze = new Maze();
        assertEquals(maze.getEntity(0, 0).getClass().getName(), "Walls.Wall");
    }

    @Test
    void createMakesPlaceholder(){
        Maze maze = new Maze();
        assertEquals(maze.getEntity(7, 3).getClass().getName(), "General.Placeholder");
    }

    @Test
    void testGetEntity() {
        Maze maze = new Maze();
        assertEquals(maze.getEntity(0, 0).getClass().getName(), "Walls.Wall");
    }

    @Test
    void testSetEntity() {
        Maze maze = new Maze();
        maze.setEntity(new OpenSpace(), 0, 0);
        assertEquals(maze.getEntity(7, 3).getClass().getName(), "General.Placeholder");
    }

    @Test
    void testToString() {
        Maze maze = new Maze();
        String string = maze.toString();
        int length = string.length();
        assert (length == 1019);
    }

    @Test
    void testDisplay() {
        Maze maze = new Maze();
        maze.display();
    }
}