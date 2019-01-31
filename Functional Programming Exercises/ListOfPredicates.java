import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int range = Integer.parseInt(sc.nextLine());
        List<Integer> allDivisors = new ArrayList<>();
        String[] tokens = sc.nextLine().split("\\s+");
        for (String token : tokens) {
            allDivisors.add(Integer.parseInt(token));
        }
        BiPredicate<Integer, List<Integer>> checkNumber = (x, y) -> {

            for (Integer aY : y) {
                if (x % aY != 0) {
                    return false;
                }
            }
            return true;
        };
        int i = 1;
        while (i <= range) {
            if (checkNumber.test(i,allDivisors)) {
                System.out.print(i + " ");
            }
            i += 1;
        }
    }
}
