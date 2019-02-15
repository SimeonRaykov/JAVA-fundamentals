import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(bf.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(getSum(arr, 0));

    }

    private static int getSum(int[] arr, int index) {

        if (index == arr.length - 1) {
            return arr[index];
        }
        return arr[index] + getSum(arr,index + 1);
    }
}
