import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMiniFunction {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Function<int[], Integer> getSmallestElement = CustomMiniFunction::apply;
        int[] numbersArr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getSmallestElement.apply(numbersArr));
    }

    private static Integer apply(int[] i) {
        int minValue = Integer.MAX_VALUE;
        for (int j = 0; j < i.length; j++) {
            if (minValue > i[j]) {
                minValue = i[j];
            }
        }
        return minValue;
    }
}
