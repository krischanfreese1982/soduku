package soduku.main;

import javax.management.InvalidAttributeValueException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SodukuField {
    NumberContainer row;
    NumberContainer column;
    NumberContainer block;

    public SodukuField(NumberContainer inRow, NumberContainer inColumn, NumberContainer inBlock){
        this.row = inRow;
        this.column = inColumn;
        this.block = inBlock;
    }

    public ArrayList<Integer> getAvailableNumbers(){
        ArrayList<Integer> result = new ArrayList<Integer>();

        return result;
    }
}
