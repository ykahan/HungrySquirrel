package General;

public abstract class Entity {
    private char symbol;
    private int row;
    private int column;

    public Entity put(int newRow, int newColumn){
        Entity oldEntity = Maze.getEntity(newRow, newColumn);
        boolean isWall = isWall(oldEntity);
        if(!isWall) Maze.setEntity(this, newRow, newColumn);
        return oldEntity;
    }


    private boolean isWall(Entity entity){
        return entity.getClass().getName().contentEquals("Wall");
    }
}
