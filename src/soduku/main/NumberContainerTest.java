package soduku.main;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NumberContainerTest {

    TestHelper helper = new TestHelper();

    @Test
    public void validNumberFunctionTest(){
        NumberContainer numberContainer = new NumberContainer();
        int randomNumber = helper.getRandomNumberFromArrayListOrArray(numberContainer.getValidNumbers());
        assertTrue(randomNumber+" should be valid", numberContainer.isValidNumber(randomNumber));
        assertFalse("Negative numbers should be invalid", numberContainer.isValidNumber((-4)));
        assertFalse("Numbers greater 9 should be invalid", numberContainer.isValidNumber(11));
    }

    @Test
    public void canRemoveNumberOnNewField() {
        NumberContainer numberContainer = new NumberContainer();
        int countAvailableNumbers = numberContainer.getAvailableNumbers().size();
        int randomNumber = helper.getRandomNumberFromArrayListOrArray(numberContainer.getValidNumbers());
        try {
            numberContainer.setNumberAsUnavailable(randomNumber);
        }catch(Exception e){
            fail("Should not get a number Exception");
        }
        assertTrue("Can remove number from new field", countAvailableNumbers > numberContainer.getAvailableNumbers().size());
    }

    @Test
    public void shouldBeAbleToReAddNumber(){
        NumberContainer numberContainer = new NumberContainer();
        int randomValidNumber = helper.getRandomNumberFromArrayListOrArray(numberContainer.getValidNumbers());
        assertTrue(numberContainer.isAvailableNumber(randomValidNumber));
        try {
            numberContainer.setNumberAsUnavailable(randomValidNumber);
        }catch(Exception e){
            fail("Should not get a number Exception");
        }

        assertFalse(numberContainer.isAvailableNumber(randomValidNumber));
        try {
            numberContainer.setNumberAsAvailable(randomValidNumber);
        }catch(Exception e){
            fail("Should not get a number Exception");
        }
        assertTrue(numberContainer.isAvailableNumber(randomValidNumber));
    }

    @Test
    public void shouldHaveAllNumbersAvailable(){
        NumberContainer numberContainer = new NumberContainer();
        assertEquals("ArrayLists should be equal", helper.makeArrayListWithAllNumbers(), numberContainer.getAvailableNumbers());
    }

    @Test
    public void availableNumbersShouldChange(){
        NumberContainer numberContainer = new NumberContainer();
        ArrayList<Integer> availableNumbersBeforeRemoval = numberContainer.getAvailableNumbers();
        int randomValidNumber = helper.getRandomNumberFromArrayListOrArray(numberContainer.getValidNumbers());
        try {
            numberContainer.setNumberAsUnavailable(randomValidNumber);
        }catch(Exception e){
            fail("Should not get a number Exception");
        }
        ArrayList<Integer> availableNumbersAfterRemoval = numberContainer.getAvailableNumbers();
        assertNotEquals("All numbers vs. one removed", availableNumbersBeforeRemoval, availableNumbersAfterRemoval);
    }

    @Test
    public void shouldBeAbleToStateEmptiness(){
        NumberContainer numberContainer = new NumberContainer();
        ArrayList<Integer> availableNumbers = numberContainer.getAvailableNumbers();
        assertFalse(numberContainer.isEmpty());
        for (int number: availableNumbers){
            try {
                numberContainer.setNumberAsUnavailable(number);
            }catch (Exception e){
                System.out.println("Action was not possible "+e.getMessage());
            }

        }
        assertEquals(0, numberContainer.getAvailableNumbers().size());
        assertTrue(numberContainer.isEmpty());
    }
}
