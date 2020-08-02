package Nuts;

import General.Entity;
import General.Location;
import General.Maze;
import General.OpenSpace;
import Pixies.Movable;
import Walls.Wall;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Nut extends Entity {
    private static int nutritionPoints;
    private Variety name;
    private Maze maze;
    private Location location;

    public Nut(Maze maze, char symbol, int nutritionPoints){
        super(symbol);
        this.maze = maze;
        this.nutritionPoints = nutritionPoints;
        create();
    }

    public void create(){
        boolean locationAvailableForNut = false;
        while(!locationAvailableForNut) {
            int row = ThreadLocalRandom.current().nextInt(0, maze.getMaxRow());
            int column = ThreadLocalRandom.current().nextInt(0, maze.getMaxColumn());
            Entity entity = maze.getEntity(row, column);
            locationAvailableForNut = locationAvailableForNut(entity);
            if(locationAvailableForNut) {
                this.location = new Location(row, column);
                maze.setEntity(this, location.getRow(), location.getColumn());
            }
        }
    }

    private boolean locationAvailableForNut(Entity entity){
        if(entity instanceof OpenSpace) return true;
        return false;
    }
    
    public int getNutritionPoints(){
        return this.nutritionPoints;
    }
}
