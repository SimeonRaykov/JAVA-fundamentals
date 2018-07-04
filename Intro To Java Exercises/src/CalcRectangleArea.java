import java.util.Scanner;

public class CalcRectangleArea {

    public static void main(String[] args) {

        Scanner Scanner=new Scanner(System.in);

        double a=Scanner.nextDouble();
        double b=Scanner.nextDouble();

        double area=a*b*1.0;
        System.out.printf("%.2f",area);

    }
}
