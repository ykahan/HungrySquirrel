package General;

public abstract class Entity {
    private char symbol;
    private int row;
    private int column;

    public Entity(char symbol){
        this.symbol = symbol;
    }

    public Entity put(int row, int column){
        Entity oldEntity = Maze.getEntity(row, column);
        boolean isWall = isWall(oldEntity);
        if(!isWall) Maze.setEntity(this, row, column);
        return oldEntity;
    }

    public char getSymbol(){
        return this.symbol;
    }

    private boolean isWall(Entity entity){
        return entity.getClass().getName().contentEquals("Wall");
    }
}
