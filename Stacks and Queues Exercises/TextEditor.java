import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> deck = new ArrayDeque<>();
        String textor = "";
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            if (Integer.parseInt(tokens[0]) == 1) {
                textor += tokens[1];
                deck.push(textor);
            } else if (Integer.parseInt(tokens[0]) == 2) {
                textor = textor.substring(0, textor.length() - Integer.parseInt(tokens[1]));
                deck.push(textor);
            } else if (Integer.parseInt(tokens[0]) == 3) {
                if (Integer.parseInt(tokens[1]) > 0 && Integer.parseInt(tokens[1]) <= textor.length()) {
                    System.out.println(textor.charAt(Integer.parseInt(tokens[1]) - 1));
                }
            } else if (Integer.parseInt(tokens[0]) == 4) {
                if (deck.size() >= 2) {
                    deck.pop();
                    textor = deck.peek();
                }
            }
        }
    }
}
