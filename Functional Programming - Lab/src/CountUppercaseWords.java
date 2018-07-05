
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String[] text = Scanner.nextLine().split(" ");

        List<String> upperCaseWords = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {

            String currentWord = text[i];
           if(Character.isUpperCase(currentWord.charAt(0))){
               upperCaseWords.add(currentWord);
           }
           
        }

        System.out.println(upperCaseWords.size());

        for (int i = 0; i <upperCaseWords.size() ; i++) {

            System.out.println(upperCaseWords.get(i));

        }

    }
}
