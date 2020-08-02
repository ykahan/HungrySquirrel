package Nuts;

import General.Entity;
import General.Location;
import General.Maze;
import General.OpenSpace;
import Pixies.Movable;
import Walls.Wall;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Nut extends Entity {
    private static final int TOTAL_NUTS = 5;
    private static int nutritionPoints;
    private Variety name;
    private Maze maze;
    private Location location;

    public Nut(){
        this.maze = maze;
        create();
    }

    public void create(){
        int row = ThreadLocalRandom.current().nextInt(0, maze.getMaxRow());
        int column = ThreadLocalRandom.current().nextInt(0, maze.getMaxColumn());
        Entity entity = maze.getEntity(row, column);
        if(locationAvailableForNut(entity)) {
            this.location = new Location(row, column);
            maze.setEntity(this, location.getRow(), location.getColumn());
        } else create();
    }

    private boolean locationAvailableForNut(Entity entity){
        if(entity instanceof OpenSpace) return true;
        return false;
    }
}
