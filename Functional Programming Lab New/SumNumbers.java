import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);
        int[] array = Arrays.stream(Scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(array).reduce((x, y) -> x + y).ifPresent(r -> System.out.println("Count = "+array.length+System.lineSeparator()+"Sum = "+r));

    }
}
