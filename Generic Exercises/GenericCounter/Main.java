package GenericCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Double> arrDoubles = new ArrayList<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            Double info = Double.parseDouble(bf.readLine());
            arrDoubles.add(info);
        }
        Double comparable = Double.parseDouble(bf.readLine());
        System.out.println(getCountOfDoubles(arrDoubles, comparable));
        //  System.out.println(getCountOfStrings(arrStrings, strToCompare));

    }

    public static <T> int getCountOfStrings(ArrayList<T> T, String comparable) {
        int count = 0;

        for (T t : T) {
            if (t.toString().compareTo(comparable) >= 1) {
                count += 1;
            }
        }

        return count;
    }

    public static <T extends Comparable> int getCountOfDoubles(ArrayList<T> T, double comparable) {
        int count = 0;

        for (T t : T) {
            if (t.compareTo(comparable) > 0) {
                count += 1;
            }
        }
        return count;
    }
}
