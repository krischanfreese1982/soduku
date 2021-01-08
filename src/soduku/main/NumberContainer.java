package soduku.main;

import java.util.ArrayList;

public class NumberContainer {
    boolean[] numbers;
    final int[] validNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public NumberContainer(){
        this.numbers = new boolean[]{true,true,true,true,true,true,true,true,true};
    }

    public boolean removeNumber(int toBeRemoved){
        boolean result = false;
        if(this.isValidNumber(toBeRemoved)) {
            this.numbers[toBeRemoved-1] = false;
            result = true;
        }
        return result;
    }

    protected boolean isValidNumber(int toBeRemoved) {
        boolean result = false;

        if(toBeRemoved >= 1 && toBeRemoved <=9){
            result = true;
        }
        return result;
    }

    public boolean addNumber(int toBeAdded){
        boolean result = false;
        if(this.isValidNumber(toBeAdded)){
            if(this.numbers[toBeAdded-1] == false){
                this.numbers[toBeAdded-1] = true;
                result = true;
            }
        }
        return result;
    }

    public int[] getValidNumbers(){
        return this.validNumbers;
    }

    public boolean isAvailableNumber(int number) {
        boolean result = false;
        if(this.isValidNumber(number)){
            result = this.numbers[number-1];
        }
        return result;
    }

    public ArrayList<Integer> getAvailableNumbers() {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0; i < this.numbers.length; i++){
            if(this.numbers[i] == true){
                int tmp = i+1;
                result.add(tmp);
            }
        }
        return result;
    }
}
