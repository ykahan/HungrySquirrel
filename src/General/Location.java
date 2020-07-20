package General;

public class Location {
    private int row;
    private int column;

    public Location(int row, int column){
        this.row = row;
        this.column = column;
    }

    public Location(){
        this.row = 0;
        this.column = 0;
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

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column){
        this.column = column;
    }
}
