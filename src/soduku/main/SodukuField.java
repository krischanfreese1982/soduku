package soduku.main;

import java.util.ArrayList;

public class SodukuField {

    SodukuCell[][] sodukuField = new SodukuCell[9][9];
    String message;

    public SodukuField(){
        ArrayList<NumberContainer> rowNumberContainerList = new ArrayList<NumberContainer>();
        ArrayList<NumberContainer> columnNumberContainerList = new ArrayList<NumberContainer>();
        ArrayList<NumberContainer> blockContainerList = new ArrayList<NumberContainer>();

        this.message = "New field";

        for(int i=0; i < 9; i++){
            rowNumberContainerList.add(new NumberContainer());
            columnNumberContainerList.add(new NumberContainer());
            blockContainerList.add(new NumberContainer());
        }

        for(int row=0; row < 9; row++){
            for(int column=0; column < 9;column++) {
                NumberContainer rowNumberContainer = rowNumberContainerList.get(row);
                NumberContainer columnNumberContainer = columnNumberContainerList.get(column);

                int blockNumberOfCoordinates = this.getBlockNumberOfCoordinates(new Coordinates(row, column));
                NumberContainer blockNumberContainer = blockContainerList.get(blockNumberOfCoordinates);

                this.sodukuField[row][column] = new SodukuCell(rowNumberContainer, columnNumberContainer, blockNumberContainer);
            }
        }
    }
    public boolean areValidCoordinates(Coordinates invalidCoords) {
        return (this.numberIsWithinCoordinateBounds(invalidCoords.row)
               && this.numberIsWithinCoordinateBounds(invalidCoords.column));
    }

    private boolean numberIsWithinCoordinateBounds(int number){
        boolean result = false;
        if(number >= 0
           && number <= 8)
        {
            result = true;
        }
        return result;
    }

    public ArrayList<Integer> getNumbersAt(Coordinates coordinates) throws Exception {
        if( this.areValidCoordinates(coordinates)){
            return this.sodukuField[coordinates.row][coordinates.column].getAvailableNumbers();
        }else {
            throw new Exception("Coordinates are invalid");
        }
    }

    public int getIndexOfCellCoordinates(Coordinates coordinates) {
        return (coordinates.row * 8) + coordinates.row + coordinates.column;
    }

    public int getBlockNumberOfCoordinates(Coordinates coordinates) {
        int rowValue = (coordinates.row / 3) * 3;
        int columnValue = (coordinates.column / 3);
        return (rowValue + columnValue);
    }

    public String toString(){
        final String FATLINE = "===================\n";
        String result = "";
        String tail = "|";
        result = result + FATLINE;
        for(int row=0; row < 9; row++){
            for(int column=0; column < 9;column++) {
                if(column % 3 == 0){
                    result = result + "║";
                }if( (column + 1) % 3 == 0 && column != 8){
                    tail = "";
                }else if( column == 8) {
                    tail = "║";
                }else {
                    tail = "|";
                }
                result = result + this.sodukuField[row][column] + tail;
            }
            if(row > 0 && (row + 1) % 3 == 0) {
                result = result + "\n" + FATLINE;
            }else{
                result = result + "\n";
            }
        }
        return result;
    }

    public void setNumber(Coordinates coordinates, int number) throws Exception{
        if(this.areValidCoordinates(coordinates)){
            this.sodukuField[coordinates.row][coordinates.column].setNumber(number);
        }else{
            throw new Exception("Coordinates are invalid");
        }
    }
}
