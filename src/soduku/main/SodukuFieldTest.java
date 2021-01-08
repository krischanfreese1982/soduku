package soduku.main;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SodukuFieldTest {

    @Test
    public void shouldKnowAvailableNumbers(){
        NumberContainer rowContainer = new NumberContainer();
        NumberContainer columnContainer = new NumberContainer();
        NumberContainer blockContainer = new NumberContainer();

        SodukuField sField = new SodukuField(rowContainer, columnContainer, blockContainer);
        ArrayList<Integer> allPossibleNumbers = this.makeArrayListWithAllNumbers();

        //assertEquals("Arrays should be equal", sField.getAvailableNumbers(0, 0), allNumbers);
        assertEquals("ArrayLists should be equal", allPossibleNumbers, sField.getAvailableNumbers());
    }

    private ArrayList<Integer> makeArrayListWithAllNumbers() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<9;i++){
            result.add(i);
        }
        return result;
    }
}
