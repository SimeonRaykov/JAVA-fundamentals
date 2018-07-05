import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddVat {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);
        String[] inputString = Scanner.nextLine().split(", ");

        List<Double> numbersList = new ArrayList<>();

        for (int i = 0; i < inputString.length; i++) {

            double currentNumber = Double.parseDouble(inputString[i]);

            numbersList.add( currentNumber);

        }

        System.out.println("Prices with VAT:");

        for (int i = 0; i <numbersList.size() ; i++) {

            System.out.printf("%.2f%n",numbersList.get(i)*1.2);

        }

    }
}
