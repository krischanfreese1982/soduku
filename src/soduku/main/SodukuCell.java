package soduku.main;

import java.util.ArrayList;

public class SodukuCell {
    NumberContainer row;
    NumberContainer column;
    NumberContainer block;

    int number;

    public SodukuCell(NumberContainer inRow, NumberContainer inColumn, NumberContainer inBlock){
        this.row = inRow;
        this.column = inColumn;
        this.block = inBlock;

        this.number = 0;
    }

    public ArrayList<Integer> getAvailableNumbers(){
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> availableNumbers = this.row.getAvailableNumbers();
        for (int availableNumber: availableNumbers )
        {
            if(this.row.isAvailableNumber(availableNumber)
               && this.column.isAvailableNumber(availableNumber)
               && this.block.isAvailableNumber(availableNumber))
            {
                result.add(availableNumber);
            }
        }

        return result;
    }

    public void setNumber(int numberToBeSet) throws Exception {
        if (this.row.isValidNumber(numberToBeSet) ){
            if (this.numberIsAvailable(numberToBeSet)) {

                this.row.setNumberAsUnavailable(numberToBeSet);
                this.column.setNumberAsUnavailable(numberToBeSet);
                this.block.setNumberAsUnavailable(numberToBeSet);

                this.number = numberToBeSet;
            }
            else {
                throw new Exception("Number not available");
            }
        }else{
            throw new Exception("invalid number");
        }
    }

    public boolean numberIsAvailable(int number) {
        boolean result = false;
        if( this.row.isAvailableNumber(number)
            && this.column.isAvailableNumber(number)
            && this.block.isAvailableNumber(number)
            && this.number == 0
        ) result = true;
        return result;
    }

    public boolean noNumbersLeft() {
        boolean result = false;
        if( this.row.isEmpty()
            && this.column.isEmpty()
            && this.block.isEmpty()
            && this.number == 0
        ) {
            result = true;
        }
        return result;
    }

    public void unsetNumber(int toBeUnset) throws Exception {
        if(this.numberIsAvailable(toBeUnset)){
            throw new Exception(toBeUnset+" is not set and therefore can't be unset");
        }else{
            this.column.setNumberAsAvailable(toBeUnset);
            this.row.setNumberAsAvailable(toBeUnset);
            this.block.setNumberAsAvailable(toBeUnset);

            this.number = 0;
        }
    }

    public int getSetNumber() throws Exception {
        int result = 0;
        if( this.number == 0
            || this.noNumbersLeft()){
            result = -1;
            throw new Exception("There is no number set");
        }else{
            result = this.number;
        }
        return result;
    }

    public String toString(){
        if(this.number == 0){
            return "_";
        }else {
            return ""+this.number;
        }
    }
}
