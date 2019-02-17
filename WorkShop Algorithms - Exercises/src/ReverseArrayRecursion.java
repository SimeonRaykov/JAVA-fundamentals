import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] intArr = Arrays.stream(bf.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        reverseArr(intArr, 0, intArr.length - 1);
        for (int i : intArr) {
            System.out.print(i+" ");
        }

    }

    private static int[] reverseArr(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return arr;
        }
        int temp = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = temp;
        return reverseArr(arr, startIndex + 1, endIndex - 1);
    }
}
