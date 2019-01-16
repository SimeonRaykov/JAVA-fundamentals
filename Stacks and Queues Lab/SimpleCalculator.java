import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> deck = new ArrayDeque<String>();

        String line = sc.nextLine();
        Collections.addAll(deck, line.split(" "));
        int result = 0;

        while (!deck.isEmpty()) {

            int num = Integer.parseInt(deck.pollLast());
            if (deck.size() > 1) {
                String operator = deck.pollLast();
                if (operator.equals("-")) {
                    num = -num;
                }
                result += num;
            }
            else{
            result += num;
            }
        }
        System.out.println(result);
    }
}
