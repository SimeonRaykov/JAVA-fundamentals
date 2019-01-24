import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();
        TreeMap<Character, Integer> countLettersInString = new TreeMap<>();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (!countLettersInString.containsKey(currentChar)) {
                countLettersInString.put(currentChar, 1);
            } else {
                countLettersInString.put(currentChar, countLettersInString.get(currentChar) + 1);
            }
        }

        for (Character character : countLettersInString.keySet()) {
            System.out.println(character +": " + countLettersInString.get(character)+" time/s");
        }

    }
}
