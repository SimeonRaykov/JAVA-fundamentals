import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> deck = new ArrayDeque<String>();

        String command = sc.nextLine();
        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (deck.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    String last = deck.pop();
                    System.out.println(deck.peek());
                }
            } else {
                deck.push(command);
                System.out.println(command);
            }
            command = sc.nextLine();
        }

    }
}
