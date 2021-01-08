package soduku.main;

public class NumberContainer {
    boolean[] numbers;
    int[] validNumbers;

    public NumberContainer(){
        this.numbers = new boolean[]{true,true,true,true,true,true,true,true,true};
        this.validNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    public boolean removeNumber(int toBeRemoved){
        boolean result = false;
        if(this.isValidNumber(toBeRemoved)) {
            result = this.numbers[toBeRemoved-1];
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
            if(this.numbers[toBeAdded-1] == true){
                this.numbers[toBeAdded-1] = false;
                result = true;
            }
        }
        return result;
    }

    public int[] getValidNumbers(){
        return this.validNumbers;
    }
}
