import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line = bf.readLine().substring(7);
        String[] coins = line.split(", ");
        List<Integer> allowedCoins = Arrays.stream(coins)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(allowedCoins);
        int sum = Integer.parseInt(bf.readLine()
                .split(": ")[1]);

        LinkedHashMap<Integer, Integer> coinsToTake = new LinkedHashMap<>();
        int totalCoins = 0;
        int currSum = 0;
        int index = 0;

        while (currSum != sum) {
            if(index >= allowedCoins.size()){
                System.out.println("Error");
                return;
            }

            while (allowedCoins.get(index) + currSum <= sum) {

                putValuesInMap(allowedCoins, coinsToTake, index);
                totalCoins += 1;
                currSum += allowedCoins.get(index);
            }
            index += 1;
        }

        System.out.println("Number of coins to take: " + totalCoins);
        coinsToTake.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(coin -> System.out.println(coin.getValue() + " coin(s) with value " + coin.getKey()));

    }

    private static void putValuesInMap(List<Integer> allowedCoins, LinkedHashMap<Integer, Integer> coinsToTake, int index) {
        if (!coinsToTake.containsKey(allowedCoins.get(index))) {
            coinsToTake.put(allowedCoins.get(index), 1);
        } else {
            coinsToTake.put(allowedCoins.get(index), coinsToTake.get(allowedCoins.get(index)) + 1);
        }
    }
}
