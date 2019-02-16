import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(bf.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = Integer.parseInt(bf.readLine());
        System.out.println(linearSearch(arr, n));

    }

    private static int linearSearch(int[] arr, int i) {

        int index = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i) {
                index = j;
                break;
            }
        }
        return index;

    }
}
