import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        System.out.println(getFactorial(n));

    }

    private static int getFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getFactorial(n - 1);

    }
}
