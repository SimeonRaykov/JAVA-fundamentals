import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> deck = new ArrayDeque<>();

        int pushers = sc.nextInt();
        int poppers = sc.nextInt();
        int checker = sc.nextInt();
        sc.nextLine();
        String[] line = sc.nextLine().split("\\s+");

        for (int i = 0; i < pushers; i++) {
            deck.push(Integer.parseInt(line[i]));
        }

        for (int i = 0; i < poppers; i++) {
            deck.pop();
        }

        if (deck.contains(checker)) {
            System.out.println("true");
        } else {
            if (!deck.isEmpty()) {
                deck.descendingIterator();
                System.out.println(deck.pop());
            }
            else{
                System.out.println(0);
            }
        }


    }
}
