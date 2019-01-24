import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rows = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = new LinkedHashSet<>(rows[0]);
        Set<Integer> secondSet = new LinkedHashSet<>(rows[1]);

        for (int i = 0; i < rows[0]; i++) {

            firstSet.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < rows[1]; i++) {

            secondSet.add(Integer.parseInt(sc.nextLine()));
        }


        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                System.out.print(integer+" ");
            }
        }

    }
}
