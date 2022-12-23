import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task2 {
    public static void main(String[] args){
        Random rnd = new Random();

        // Тест с небольшими значениями

        int length = 10;
        ArrayList<Integer> randomValues = GenerateList(rnd, length);
        Collections.sort(randomValues);
        int searchValue =  13;

        boolean isSearchValueInList = isValueInListEnumerationMethod(searchValue, randomValues);
        String result1 = (isSearchValueInList) ? "" : "не";
        System.out.println("Результат: число " + " " + searchValue + " " + result1 + " содержится в массиве" + randomValues);
        System.out.println();

        boolean isSearchValueInListBinaryMethod = isValueInListBinaryMethod(searchValue, randomValues);
        String result2 = (isSearchValueInListBinaryMethod) ? "" : "не";
        System.out.println("Результат: число " + " " + searchValue + " " + result2 + " содержится в массиве" + randomValues);
        System.out.println();

        // end test

        //Тест с большими значениями

        int length1 = 100000000;
        ArrayList<Integer> randomValues1 = GenerateList(rnd, length1);
        Collections.sort(randomValues);
        int searchValue1 =  17;

        long startTime1 = System.currentTimeMillis();
        boolean isSearchValueInList1 = isValueInListEnumerationMethod(searchValue1, randomValues1);
        long endTime1 = System.currentTimeMillis();


        String result11 = (isSearchValueInList1) ? "" : "не";
        System.out.println("Метод перебора занял: " + (endTime1-startTime1) + "ms");
        System.out.println("Результат: число " + " " + searchValue1 + " " + result11 + " содержится в большом массиве.");
        System.out.println();

        long startTime2 = System.currentTimeMillis();
        boolean isSearchValueInListBinaryMethod1 = isValueInListBinaryMethod(searchValue1, randomValues1);
        long endTime2 = System.currentTimeMillis();


        String result21 = (isSearchValueInListBinaryMethod1) ? "" : "не";
        System.out.println("Метод бинарного поиска занял: " + (endTime2-startTime2) + "ms");
        System.out.println("Результат: число " + " " + searchValue1 + " " + result21 + " содержится в большом массиве.");

        // end test
    }

    /// Генерирует случайный список длиной length cо значениями от 0 до 15
    private static ArrayList<Integer> GenerateList(Random rnd, int length){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < length; i++){
            int newValue = rnd.nextInt(15);
            result.add(newValue);
        }

        return result;
    }

    private static boolean isValueInListEnumerationMethod(int value, ArrayList<Integer> list){

        for (int listItem: list) {
            if (value == listItem){
                return true;
            }
        }

        return false;
    }

    private static boolean isValueInListBinaryMethod(int value, ArrayList<Integer> list){
        int size = list.size();
        int halfValue = list.get(size / 2);
        boolean isValueInLeftPart = (value < halfValue);
        int startRange = isValueInLeftPart ? 0 : halfValue;
        int endRange = isValueInLeftPart ? halfValue : size;

        for (int i = startRange; i < endRange; i++){
            if (value == list.get(i)){
                return true;
            }
        }
        return false;
    }

}
