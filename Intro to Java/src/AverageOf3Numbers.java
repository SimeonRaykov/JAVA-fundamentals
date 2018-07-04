import java.util.Scanner;

public class AverageOf3Numbers {
    public static void main(String[] args) {


        Scanner Scanner = new Scanner(System.in);

        double firstNumber = Scanner.nextDouble();
        double secondNumber = Scanner.nextDouble();
        double thirdNumber = Scanner.nextDouble();

       double average= AverageOf3Nums(firstNumber, secondNumber, thirdNumber);
        System.out.printf("%.2f",average);


    }
    public static double AverageOf3Nums(double first, double second,double third){

            double average = (first + second + third) / 3;

            return average;
        }

}
