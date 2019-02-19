import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Socks {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] firstArr = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArr = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstDeck = new ArrayDeque<>();
        for (int i : firstArr) {
            firstDeck.add(i);
        }
        ArrayDeque<Integer> secondDeck = new ArrayDeque<>();
        for (int i : secondArr) {
            secondDeck.add(i);
        }

        LinkedHashSet<Integer> pair = new LinkedHashSet<>();
        boolean isPair = false;

        while (!isPair) {
            int lastLeft = firstDeck.peekLast();
            int firstRight = secondDeck.peekFirst();
            if (lastLeft > firstRight) {
                lastLeft += firstRight;
                pair.add(lastLeft);
                firstDeck.pollLast();
                secondDeck.pollFirst();
                isPair = true;
            } else if (firstRight > lastLeft) {
                firstDeck.pollLast();
            } else {
                secondDeck.pollFirst();
                firstDeck.pollLast();
                firstDeck.addLast(lastLeft += 1);
            }
        }
        while (firstDeck.size() > 1 && secondDeck.size() > 1) {
            int first = firstDeck.pollLast();
            int second = secondDeck.pollFirst();
            pair.add(first + second);
        }

        int max = Collections.max(pair);
        System.out.println(max);
        for (Integer integer : pair) {
            System.out.print(integer+" ");
        }

    }
}
