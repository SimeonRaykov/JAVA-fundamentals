import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class EuroTrip {

    public static void main(String[] args) {

        Scanner Scanner=new Scanner(System.in);

        double kgsDouble=Double.parseDouble(Scanner.nextLine());
        kgsDouble=kgsDouble*0.8;
        BigDecimal kgs=BigDecimal.valueOf(kgsDouble);
        BigDecimal calc=BigDecimal.ONE;
         calc= calc.add(kgs);
        long wurst=4210500000000l;
        BigDecimal wurstConverted=BigDecimal.valueOf(wurst);
        calc=calc.multiply(wurstConverted);
        BigDecimal costForPrice=BigDecimal.valueOf(1);
      //  costForPrice=costForPrice.multiply(kgs);

        System.out.printf("%.2f marks",calc);

    }
}
