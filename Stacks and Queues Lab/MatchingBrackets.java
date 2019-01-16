import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> deck = new ArrayDeque<>();
        String[] line = sc.nextLine().split("");

        int counter = 0;
        int extender = 1;
        String resultStr = "";

        for (int i = 0; i < line.length; i++) {

            if (line[i].equals("(")) {
                while (countOccurrences(resultStr, ")") != extender) {

                    if (line[line.length - 1].equals(")")) {
                        if (line[i].equals(")")) {
                            resultStr += line[i];
                            if (countOccurrences(resultStr, ")") == extender) {
                                break;
                            }
                        }
                    }
                    if (line[i + 1].equals("(")) {

                        resultStr += line[i];
                        i += 1;
                        counter += 1;
                        extender += 1;
                        continue;
                    }
                    resultStr += line[i];
                    counter += 1;
                    i += 1;
                }
                deck.push(resultStr);
                extender = 1;
                resultStr = "";
                i = i - counter + 1;
                counter = 0;
            }
        }
        while (!deck.isEmpty()) {
            System.out.println(deck.pollLast());
        }
    }

    public static int countOccurrences(String someString, String searchedChar) {

        String[] arr = someString.split("");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(searchedChar)) {
                count += 1;
            }
        }
        return count;
    }
}
