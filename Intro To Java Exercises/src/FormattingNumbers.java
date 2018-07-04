import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int a = Scanner.nextInt();
        double b = Scanner.nextDouble();
        double c = Scanner.nextDouble();

        StringBuilder sb = new StringBuilder();

        String resultHexa = Integer.toHexString(a);
        resultHexa = resultHexa.toUpperCase();
        String firstpart = String.format("%-10s", resultHexa).replace(' ', ' ');
        sb.append("|").append(firstpart).append("|");


        String binaryResult = Integer.toBinaryString(a);
        String secondPart = String.format("%10s", binaryResult).replace(' ', '0');
        sb.append(secondPart).append("|");

        String formatterB = String.format("%.2f", b);
        String thirdPart = String.format("%10s", formatterB).replace(' ', ' ');
        sb.append(thirdPart).append("|");

        String formatterC = String.format("%.3f", c);
        String fourthPart=String.format("%-10s", formatterC).replace(' ', ' ');
        sb.append(fourthPart).append("|");

        System.out.println(sb.toString());
    }
}

