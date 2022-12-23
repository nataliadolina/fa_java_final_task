import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args){
        ArrayList<String> sb = new ArrayList<String>();
        numbersPrinter(10, sb);
        System.out.println(String.join(" ", sb));
    }
    static void numbersPrinter(int n, ArrayList<String> sb){

        if (n != 0) {
            sb.add(n + " ");
        } else{
            reverseArrayList(sb);
            return;
        }

        numbersPrinter(n - 1, sb);
    }

    private static void reverseArrayList(ArrayList<String> arrayList){
        int length = arrayList.size();
        int maxIndex = length - 1;
        for (int i = 0; i < length / 2; i ++){
            String b = arrayList.get(i);
            arrayList.set(i, arrayList.get(maxIndex - i));
            arrayList.set(maxIndex - i, b);
        }
    }
}
