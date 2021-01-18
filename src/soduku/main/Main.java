package soduku.main;

public class Main {

    public static void main(String[] args) {
        printTest();
    }

    public static void printTest(){
        SodukuField sField = new SodukuField();
        try {
            sField.setNumber(new Coordinates(0, 0), 1);
            try {
                sField.setNumber(new Coordinates(0, 6), 1);
            } catch (Exception e){

            }
            sField.setNumber(new Coordinates(1,1), 2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(sField);
    }
}
