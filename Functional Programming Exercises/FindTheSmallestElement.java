import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numsArr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getSmallestInt = x -> {
            int minValue = Integer.MAX_VALUE;
            for (int aX : x) {
                if (minValue > aX) {
                    minValue = aX;
                }
            }
            return minValue;
        };

        BiFunction<int[], Integer, Integer> getIndexOfSmallestEl = (x, y) -> {
            int index = 0;
            for (int i = 0; i < x.length; i++) {
                if (x[i] == y) {
                    index = i;
                }
            }
            return index;
        };
        int smallestNumber = getSmallestInt.apply(numsArr);
        System.out.println(getIndexOfSmallestEl.apply(numsArr, smallestNumber));

    }
}
