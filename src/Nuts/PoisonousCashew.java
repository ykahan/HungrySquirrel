package Nuts;

import General.Maze;

public class PoisonousCashew extends Nut{
    private final int nutritionPoints = -15;

    public PoisonousCashew (Maze maze){
        super(maze,'C');
    }
}
