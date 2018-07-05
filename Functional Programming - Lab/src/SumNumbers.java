import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String[] inputString = Scanner.nextLine().split(", ");
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < inputString.length; i++) {

            int currentNumber = Integer.parseInt(inputString[i]);

                numbersList.add(0, currentNumber);

                }

                int sum=0;

        for (int i = 0; i < numbersList.size(); i++) {

            sum+=numbersList.get(i);

        }


        System.out.printf("Count = %d%nSum = %d",numbersList.size(),sum);
    }
}
