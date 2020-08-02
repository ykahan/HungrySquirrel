package Nuts;

import General.Entity;
import General.Location;
import General.Maze;
import General.OpenSpace;

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
        boolean locationAvailable = false;
        while(!locationAvailable) {
            location = getRandomLocation();
            locationAvailable = locationAvailable(location.getRow(), location.getColumn());
            if(locationAvailable) {
                maze.setEntity(this, location.getRow(), location.getColumn());
            }
        }
    }

    private Location getRandomLocation(){
        int row = ThreadLocalRandom.current().nextInt(0, maze.getMaxRow());
        int column = ThreadLocalRandom.current().nextInt(0, maze.getMaxColumn());
        return new Location(row, column);
    }

    private boolean locationAvailable(int row, int column){
        Entity entity = maze.getEntity(row, column);
        if(entity instanceof OpenSpace) return true;
        return false;
    }

    public int getNutritionPoints(){
        return this.nutritionPoints;
    }
}
