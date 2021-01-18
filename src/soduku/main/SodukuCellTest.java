package soduku.main;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SodukuCellTest {

    TestHelper helper = new TestHelper();

    @Test
    public void shouldKnowAvailableNumbers(){
        SodukuCell sCell = this.getNewSodukuField();
        ArrayList<Integer> allPossibleNumbers = helper.makeArrayListWithAllNumbers();

        assertEquals("ArrayLists should be equal", allPossibleNumbers, sCell.getAvailableNumbers());
    }

    @Test
    public void shouldBeAbleToSetAndRemoveNumber(){
        SodukuCell sCell = getNewSodukuField();
        ArrayList<Integer> availableNumbersBefore = sCell.getAvailableNumbers();
        int randomNumber = helper.getRandomNumberFromArrayListOrArray(availableNumbersBefore);
        try {
            sCell.setNumber(randomNumber);
            assertFalse("Number should be set", sCell.numberIsAvailable(randomNumber));
        }catch(Exception e){
            fail("Should not get a number Exception");
        }
        ArrayList<Integer> availableNumbersAfter = sCell.getAvailableNumbers();
        assertTrue("Available numbers should be different before and after removal", availableNumbersBefore.size() != availableNumbersAfter.size());
        try {
            sCell.unsetNumber(randomNumber);
        }catch(Exception e){
            fail(""+e.getMessage());
        }
        assertTrue("Number should be unset", sCell.numberIsAvailable(randomNumber));

    }

    @Test
    public void shouldKnowEmptiness(){
        SodukuCell sCell = getNewSodukuField();
        assertFalse(sCell.noNumbersLeft());
        ArrayList<Integer> availableNumbers = sCell.getAvailableNumbers();
        for (int availableNumber: availableNumbers){
            try {
                sCell.setNumber(availableNumber);
            }catch(Exception e){
                fail(""+e.getMessage());
            }
        }
        assertTrue(sCell.noNumbersLeft());
    }

    @Test
    public void shouldKnowSetNumber(){
        SodukuCell sCell = getNewSodukuField();
        ArrayList<Integer> allNumbers = sCell.getAvailableNumbers();
        int randomNumber = helper.getRandomNumberFromArrayListOrArray(allNumbers);
        try {
            sCell.setNumber(randomNumber);

            try {
                int result = sCell.getSetNumber();
                assertEquals(randomNumber+" should be the set number which is "+result, randomNumber, result);

            }catch(Exception e){
                fail(""+e.getMessage());
            }

        }catch(Exception e){
            fail(""+e.getMessage());
        }
    }

    private SodukuCell getNewSodukuField(){
        NumberContainer rowContainer = new NumberContainer();
        NumberContainer columnContainer = new NumberContainer();
        NumberContainer blockContainer = new NumberContainer();

        return new SodukuCell(rowContainer, columnContainer, blockContainer);
    }
}
