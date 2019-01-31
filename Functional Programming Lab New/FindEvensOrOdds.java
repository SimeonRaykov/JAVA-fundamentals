import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split(" ");
        String criteria = sc.nextLine();

        int lowerRange = Integer.parseInt(tokens[0]);
        int upperRange = Integer.parseInt(tokens[1]);

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isOdd = x -> x % 2 != 0;

        for (int i = lowerRange; i <= upperRange; i++) {
            if (isEven.test(i) && criteria.equals("even")) {
                System.out.print(i+" ");
            }
            else if(isOdd.test(i) && criteria.equals("odd")){
                System.out.print(i+" ");
            }
        }


    }
}
