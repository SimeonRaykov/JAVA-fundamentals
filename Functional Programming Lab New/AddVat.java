import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        UnaryOperator<Double> calcVat = x->x*1.2;
        double[] nums = Arrays.stream(sc.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        System.out.println("Prices with VAT:");
        DecimalFormat df = new DecimalFormat("#.00");
        for (double num : nums) {
            System.out.println(df.format(calcVat.apply(num)));
        }
    }
}
