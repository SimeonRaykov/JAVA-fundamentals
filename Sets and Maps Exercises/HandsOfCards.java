import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Set<String>> handOfCardsMap = new HashMap<>();
        HashMap<String, Integer> cardValues = new HashMap<>();

        String[] line = sc.nextLine().split(": ");
        while (!line[0].equals("JOKER")) {

            String[] cardsValue = line[1].split(", ");
            if (!handOfCardsMap.containsKey(line[0])) {
                handOfCardsMap.put(line[0], new HashSet<>());
            }
            for (int i = 0; i < cardsValue.length; i++) {
                handOfCardsMap.get(line[0]).add(cardsValue[i]);
            }
            line = sc.nextLine().split(": ");
        }
        for (String player : handOfCardsMap.keySet()) {
            int sum = 0;
            for (String card : handOfCardsMap.get(player)) {
                sum += calculateCardValue(card);
            }
            cardValues.put(player, sum);
        }
        cardValues.entrySet()
                .stream()
                .sorted(comparingByValue())
                .forEachOrdered(x -> cardValues.put(x.getKey(), x.getValue()));

        Map<String, Integer> cardSorted = cardValues.entrySet().stream().sorted(comparingByValue()) .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        for (String player : cardSorted.keySet()) {
            System.out.println(player + ": " + cardSorted.get(player));
        }
    }

    public static Integer calculateCardValue(String card) {
        int value = 0;
        int multiplier = 0;

        if (card.endsWith("C")) {
            multiplier = 1;
        } else if (card.endsWith("D")) {
            multiplier = 2;
        } else if (card.endsWith("H")) {
            multiplier = 3;
        } else if (card.endsWith("S")) {
            multiplier = 4;
        }

        if (card.charAt(0) == 'J') {
            value = 11;
        } else if (card.charAt(0) == 'Q') {
            value = 12;
        } else if (card.charAt(0) == 'K') {
            value = 13;
        } else if (card.charAt(0) == 'A') {
            value = 14;
        }

        for (int i = 2; i <= 9; i++) {
            if (i == (card.charAt(0) - '0')) {
                value = i;
                break;
            }
        }
        if (value == 0) {
            value = 10;
        }
        return value * multiplier;
    }
}
