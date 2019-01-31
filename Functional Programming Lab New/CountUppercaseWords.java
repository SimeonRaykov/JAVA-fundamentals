import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> uppercaseWords = new LinkedHashSet<>();
        Predicate<String> isUppercase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        String[] words = sc.nextLine().split("\\s+");
        for (String word : words) {
            if (isUppercase.test(word)) {
                uppercaseWords.add(word);
            }
        }
        System.out.println(uppercaseWords.size());
        for (String uppercaseWord : uppercaseWords) {
            System.out.println(uppercaseWord);
        }
    }
}
