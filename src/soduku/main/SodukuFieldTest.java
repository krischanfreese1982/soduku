package soduku.main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SodukuFieldTest {

    TestHelper helper = new TestHelper();

    @Test
    public void shouldBeAbleToGetAvailableNumbersByCoordinates(){
        SodukuField sField = new SodukuField();
        Coordinates block1Coords = new Coordinates(0,0);
        Coordinates block2Coords = new Coordinates(6,2);
        Coordinates block6Coords = new Coordinates(1,7);
        try {
            ArrayList<Integer> availableNumbersBlock1 = sField.getNumbersAt(block1Coords);
            try {
                ArrayList<Integer> availableNumbersBlock2 = sField.getNumbersAt(block2Coords);
                assertEquals("Available number should be equal on an empty field ", availableNumbersBlock1.size(), availableNumbersBlock2.size() );

                try {
                    ArrayList<Integer> availableNumbersBlock6 = sField.getNumbersAt(block6Coords);
                    assertEquals("Available number should be equal on an empty field ", availableNumbersBlock2.size(), availableNumbersBlock6.size() );
                }catch (Exception e){
                    fail("Exception "+e.getMessage());
                }
            }catch (Exception e){
                fail("Exception "+e.getMessage());
            }
        }catch (Exception e){
            fail("Exception "+e.getMessage());
        }
    }

    @Test
    public void shouldKnowNumberContainerBlockOfCoordinates(){
        SodukuField sField = new SodukuField();
        assertEquals("0.0 should be Block 0", 0, sField.getBlockNumberOfCoordinates(new Coordinates(0,0)));
        assertEquals("2.2 should be Block 0", 0, sField.getBlockNumberOfCoordinates(new Coordinates(2,2)));
        assertEquals("3.1 should be Block 1", 1, sField.getBlockNumberOfCoordinates(new Coordinates(3,1)));
        assertEquals("7.1 should be Block 2", 2, sField.getBlockNumberOfCoordinates(new Coordinates(7,1)));
        assertEquals("0.3 should be Block 3", 3, sField.getBlockNumberOfCoordinates(new Coordinates(0,3)));
        assertEquals("4.4 should be Block 4", 4, sField.getBlockNumberOfCoordinates(new Coordinates(4,4)));
        assertEquals("7.4 should be Block 5", 5, sField.getBlockNumberOfCoordinates(new Coordinates(7,4)));
        assertEquals("0.7 should be Block 6", 6, sField.getBlockNumberOfCoordinates(new Coordinates(0,7)));
        assertEquals("4.8 should be Block 7", 7, sField.getBlockNumberOfCoordinates(new Coordinates(4,8)));
        assertEquals("8.8 should be Block 8", 8, sField.getBlockNumberOfCoordinates(new Coordinates(8,8)));
    }

    @Test
    public void numberToBeSetThrowsUnavailableExceptionIfUnavailable(){
        SodukuField sField = new SodukuField();
        Coordinates randomCoords = helper.randomValidCoords();
        try {
            sField.setNumber(randomCoords, 1);
            try{
                sField.setNumber(randomCoords, 1);
            }catch (Exception e) {
                assertTrue("Exception succesfully triggered " + e.getMessage(), true);
            }
        }catch(Exception e){
            fail("Should be able to set number on new field. Exception: "+e.getMessage());
        }
    }

    @Test
    public void shouldKnowCellIndexOfFieldCoordinates(){
        SodukuField sField = new SodukuField();

        int randomFirstRowColumn= this.getRandomNumberWithin(0, 8);
        Coordinates firstRowCoordinates = new Coordinates(randomFirstRowColumn, 0);
        int firstRowIndex = sField.getIndexOfCellCoordinates(firstRowCoordinates);
        assertTrue("Coordinates "+firstRowCoordinates+" | First row index should be within 0 and 8, given value"+firstRowIndex, (firstRowIndex >= 0 && firstRowIndex <= 8));

        int randomThirdRowColumn = this.getRandomNumberWithin(0, 8);
        Coordinates thirdRowCoordinates = new Coordinates(randomThirdRowColumn, 3);
        int thirdRowIndex = sField.getIndexOfCellCoordinates(thirdRowCoordinates);
        assertTrue("Coordinates "+thirdRowCoordinates+" | Third row index should be within 25 and 32, given value "+thirdRowIndex, (thirdRowIndex >= 27 && thirdRowIndex <= 35));

        int randomSixthRowColumn = this.getRandomNumberWithin(0, 8);
        Coordinates sixthRowCoordinates = new Coordinates(randomSixthRowColumn, 6);
        int sixthRowIndex = sField.getIndexOfCellCoordinates(sixthRowCoordinates);
        assertTrue("Coordinates "+sixthRowCoordinates+" | Third row index should be within 25 and 32, given value"+sixthRowIndex, (sixthRowIndex >= 54 && sixthRowIndex <= 62));
    }

    @Test
    public void shouldKnowValidityOfCoordinates(){
        Coordinates invalidCoords = new Coordinates(-1, -10);
        SodukuField sField = new SodukuField();
        assertFalse("Negative coordinates should be invalid", sField.areValidCoordinates(invalidCoords));
        Coordinates validCoords = new Coordinates(1,1);
        assertTrue("1,1 should be valid Coordinates", sField.areValidCoordinates(validCoords));
    }

    @Test public void settingNumberShouldAffectRelatedCells(){
        SodukuField sField = new SodukuField();
        Coordinates zeroZero = new Coordinates(0,0);
        try {
            ArrayList<Integer> allNumbers = sField.getNumbersAt(zeroZero);
            sField.setNumber(zeroZero, 1);
            ArrayList<Integer> numbersAfter = sField.getNumbersAt(zeroZero);
            assertNotEquals("Available numbers should have changed at zero zero ", numbersAfter, allNumbers);
            Coordinates sameRow = new Coordinates(0, 6);
            Coordinates sameColumn = new Coordinates(6, 0);
            Coordinates sameBlock = new Coordinates(1, 1);
            ArrayList<Integer> sameRowNumbers = sField.getNumbersAt(sameRow);
            ArrayList<Integer> sameColumnNumbers = sField.getNumbersAt(sameColumn);
            ArrayList<Integer> sameBlockNumbers = sField.getNumbersAt(sameBlock);
            assertEquals("Available number should be equal at cell and cell inside same row", numbersAfter, sameRowNumbers);
            assertEquals("Available number should be equal at cell and cell inside same column", sameRowNumbers, sameColumnNumbers);
            assertEquals("Available number should be equal at cell and cell inside same block", sameColumnNumbers, sameBlockNumbers);
        }catch(Exception e){
            fail(""+e.getMessage());
        }
    }

    private SodukuField getNewSodukuField(){
        return new SodukuField();
    }

    private int getRandomNumberWithin(int min, int max){
        return min + (int)(Math.random() * max);
    }
}
