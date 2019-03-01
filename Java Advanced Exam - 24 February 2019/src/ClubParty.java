import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClubParty {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int maxCapacity = Integer.parseInt(bf.readLine());

        String[] inputLine = bf.readLine().split("\\s+");

        Deque<Character> openHalls = new ArrayDeque<Character>();
        LinkedHashMap<Character, ArrayList<Integer>> hallsMap = new LinkedHashMap<>();

        try {
            for (int i = inputLine.length - 1; i >= 0; i--) {

                if (Character.isLetter(inputLine[i].charAt(0))) {
                    openHalls.offer(inputLine[i].charAt(0));
                    hallsMap.put(inputLine[i].charAt(0), new ArrayList<>());

                } else if (Character.isDigit(inputLine[i].charAt(0))) {
                    if (openHalls.isEmpty()) {
                        continue;
                    } else {
                        Character lastChar = openHalls.peekFirst();
                        if (hallsMap.get(lastChar)
                                .stream()
                                .mapToInt(a -> a)
                                .sum() + Integer.parseInt("" + inputLine[i]) < maxCapacity) {
                            hallsMap.get(lastChar).add(Integer.parseInt("" + inputLine[i]));
                        } else if (hallsMap.get(lastChar)
                                .stream()
                                .mapToInt(b -> b)
                                .sum() + Integer.parseInt("" + inputLine[i]) == maxCapacity) {
                            hallsMap.get(lastChar).add(Integer.parseInt("" + inputLine[i]));
                            openHalls.remove(lastChar);
                        } else {
                            openHalls.remove(lastChar);
                            lastChar = openHalls.peekFirst();
                            if (hallsMap.get(lastChar)
                                    .stream()
                                    .mapToInt(a -> a)
                                    .sum() + Integer.parseInt("" + inputLine[i]) < maxCapacity) {
                                hallsMap.get(lastChar).add(Integer.parseInt("" + inputLine[i]));
                            } else if (hallsMap.get(lastChar)
                                    .stream()
                                    .mapToInt(b -> b)
                                    .sum() + Integer.parseInt("" + inputLine[i]) == maxCapacity) {
                                hallsMap.get(lastChar).add(Integer.parseInt("" + inputLine[i]));
                                openHalls.remove(lastChar);
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
        for (Map.Entry<Character, ArrayList<Integer>> hall : hallsMap.entrySet()) {
            if (!hall.getValue().isEmpty()) {
                int reservationSize = 0;
                System.out.print(hall.getKey() + " -> ");
                for (Integer integer : hall.getValue()) {
                    if (reservationSize + 1 == hall.getValue().size()) {
                        System.out.println(integer);
                    } else {
                        System.out.print(integer + ", ");
                    }
                    reservationSize += 1;
                }
            }
        }

    }
}

