package soduku.main;

public class Coordinates {
    int row;
    int column;

    Coordinates(int column, int row){
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return "Row "+this.row+" - column "+this.column;
    }
}
