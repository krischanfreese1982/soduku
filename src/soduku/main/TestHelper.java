package soduku.main;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestHelper {
    final int ROWCOORDSMIN = 0;
    final int ROWCOORDSMAX = 8;

    final int COLUMNCOORDSMIN = 0;
    final int COLUMNCOORDSMAX = 8;

    public int getRandomNumberFromArrayListOrArray(ArrayList<Integer> arrayList){
        int randomPos = (int)(Math.random() * (arrayList.size() - 1));
        return arrayList.get(randomPos);
    }

    public int getRandomNumberFromArrayListOrArray(int[] array){
        int randomPos = (int)(Math.random() * array.length - 1);
        return array[randomPos];
    }

    public ArrayList<Integer> makeArrayListWithAllNumbers() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<9;i++){
            int tmp = i+1;
            result.add(tmp);
        }
        return result;
    }

    public Coordinates randomValidCoords(){
        int randomRow = ROWCOORDSMIN + (int)(Math.random() * ROWCOORDSMAX);
        int randomColumn = COLUMNCOORDSMIN + (int)(Math.random() * COLUMNCOORDSMAX);
        return new Coordinates(randomRow, randomColumn);
    }

}
