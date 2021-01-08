package soduku.main;

import org.junit.*;

import java.math.MathContext;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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
}
