import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReverseStack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> deck = new ArrayDeque<>();
        String[] line = sc.nextLine().split(" ");

        for (int i = 0; i < line.length; i++) {
            int currentNum = Integer.parseInt(line[i]);
            deck.push(currentNum);

        }
        int size=deck.size();
        for (int i = 0; i < size; i++) {
            System.out.print(deck.pop() + " ");
        }
    }
}
