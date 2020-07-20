package General;

public class Location {
    private int row;
    private int column;

    public Location(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public void incrementRow(){
        row++;
    }

    public void decrementRow(){
        row--;
    }

    public void incrementColumn(){
        column++;
    }

    public void decrementColumn(){
        column--;
    }
}
