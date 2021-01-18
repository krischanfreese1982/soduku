package soduku.main;

import java.util.ArrayList;

public class NumberContainer {
    boolean[] numberAvailableStatus;
    final int[] validNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public NumberContainer(){
        this.numberAvailableStatus = new boolean[]{true,true,true,true,true,true,true,true,true};
    }

    public void setNumberAsUnavailable(int numberToBeUnAvailable) throws Exception {
        if(this.isValidNumber(numberToBeUnAvailable)) {
            this.numberAvailableStatus[numberToBeUnAvailable-1] = false;
        }else{
            throw new Exception(numberToBeUnAvailable+" is an invalid Number");
        }
    }

    public boolean isValidNumber(int toBeRemoved) {
        boolean result = false;

        if(toBeRemoved >= 1 && toBeRemoved <=9){
            result = true;
        }
        return result;
    }

    public void setNumberAsAvailable(int numberToBeAvailable) throws Exception{
        if(this.isValidNumber(numberToBeAvailable)){
            if(!this.numberAvailableStatus[numberToBeAvailable - 1]){
                this.numberAvailableStatus[numberToBeAvailable-1] = true;
            }
        }else{
            throw new Exception(numberToBeAvailable+" is an invalid Number");
        }
    }

    public int[] getValidNumbers(){
        return this.validNumbers;
    }

    public boolean isAvailableNumber(int number) {
        boolean result = false;
        if(this.isValidNumber(number)){
            result = this.numberAvailableStatus[number-1];
        }
        return result;
    }

    public ArrayList<Integer> getAvailableNumbers() {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0; i < this.numberAvailableStatus.length; i++){
            if(this.numberAvailableStatus[i] == true){
                int tmp = i+1;
                result.add(tmp);
            }
        }
        return result;
    }

    public boolean isEmpty() {
        boolean empty = false;
        for( boolean numberAvailable: numberAvailableStatus){
            empty = empty || !numberAvailable;
        }
        return empty;
    }
}
