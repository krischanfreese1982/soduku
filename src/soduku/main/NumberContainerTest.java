package soduku.main;

import org.junit.*;

import java.math.MathContext;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class NumberContainerTest {

    @Test
    public void validNumberFunctionTest(){
        NumberContainer numberContainer = new NumberContainer();
        int randomNumber = this.pickRandomNumber(numberContainer.getValidNumbers());
        assertTrue(randomNumber+" should be valid", numberContainer.isValidNumber(randomNumber));
        assertFalse("Negative numbers should be invalid", numberContainer.isValidNumber((-4)));
        assertFalse("Numbers greater 9 should be invalid", numberContainer.isValidNumber(11));
    }

    private int pickRandomNumber(int[] validNumbers) {
        int randomPos = (int)(Math.random() * validNumbers.length - 1);
        return validNumbers[randomPos];
    }

    @Test
    public void canRemoveNumberOnNewField() {
        NumberContainer numberContainer = new NumberContainer();
        assertTrue("Can remove number from new field", numberContainer.removeNumber(6));
    }

    @Test
    public void shouldBeAbleToReAddNumber(){
        NumberContainer numberContainer = new NumberContainer();
        int randomValidNumber = this.pickRandomNumber(numberContainer.getValidNumbers());
        assertTrue("Should be able to remove "+randomValidNumber, numberContainer.removeNumber(randomValidNumber));
        assertTrue("Should be able to re-add "+randomValidNumber, numberContainer.addNumber(randomValidNumber));
    }

    @Test
    public void shouldHaveAllNumbersAvailable(){
        NumberContainer numberContainer = new NumberContainer();
        int randomValidNumber = this.pickRandomNumber(numberContainer.getValidNumbers());
        assertEquals("ArrayLists should be equal"
                    ,this.makeArrayListWithAllNumbers()
                    ,numberContainer.getAvailableNumbers());
    }

    @Test
    public void availableNumbersShouldChange(){
        NumberContainer numberContainer = new NumberContainer();
        ArrayList<Integer> availableNumbers = numberContainer.getAvailableNumbers();
        int randomValidNumber = this.pickRandomNumber(numberContainer.getValidNumbers());
        numberContainer.removeNumber(randomValidNumber);
        System.out.println("rnd "+randomValidNumber);
        System.out.println("1st "+availableNumbers);
        System.out.println("2nd "+this.makeArrayListWithAllNumbers());
        assertNotEquals("All numbers vs. one removed"
                ,numberContainer.getAvailableNumbers()
                ,this.makeArrayListWithAllNumbers());
    }

    private ArrayList<Integer> makeArrayListWithAllNumbers() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<9;i++){
            int tmp = i+1;
            result.add(tmp);
        }
        return result;
    }
}
