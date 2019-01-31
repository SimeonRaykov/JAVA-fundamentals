import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnaryOperator<int[]> incrementNums = x -> {
            for (int i = 0; i < x.length; i++) {
                x[i] += 1;
            }
            return x;
        };

        UnaryOperator<int[]> multiplyby2 = x -> {
            for (int i = 0; i < x.length; i++) {
                x[i] *= 2;
            }
            return x;
        };

        UnaryOperator<int[]> subtractOne = x -> {
            for (int i = 0; i < x.length; i++) {
                x[i] -= 1;
            }
            return x;
        };

        Consumer<int[]> printIntArray = x -> {
            int c = 1;
            for (int i : x) {
                if (c == x.length) {
                    System.out.print(i);
                } else {
                    System.out.print(i + " ");
                }
                c += 1;
            }
        };

        int[] numsArr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = sc.nextLine();
        while (!command.equals("end")) {
            if (command.equals("add")) {
                numsArr = incrementNums.apply(numsArr);
            } else if (command.equals("subtract")) {
                subtractOne.apply(numsArr);
            } else if (command.equals("multiply")) {
                multiplyby2.apply(numsArr);
            } else if (command.equals("print")) {
                printIntArray.accept(numsArr);
            }
            command = sc.nextLine();
        }
    }
}
