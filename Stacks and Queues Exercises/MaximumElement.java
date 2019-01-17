import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> deck = new ArrayDeque<>();
        int commands = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < commands; i++) {

            String[] tokens = sc.nextLine().split(" ");

            int firstNum = Integer.parseInt(tokens[0]);
            if (firstNum == 1) {
                deck.push(Integer.parseInt(tokens[1]));
            } else if (firstNum == 2) {
                deck.pop();
            } else if (firstNum == 3) {
                System.out.println(Collections.max(deck));
            }

        }


    }
}
