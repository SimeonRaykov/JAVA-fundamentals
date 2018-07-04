import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import  java.util.List;

public class ProductOfNumbers {
    public static void main(String[] args) {

        Scanner Scanner=new Scanner(System.in);

        int firstNumber=Scanner.nextInt();
        int secondNumber=Scanner.nextInt();
        List<Integer> numbersToMuliply = new ArrayList<Integer>();

        BigInteger sum=BigInteger.ONE;

        BigInteger i=BigInteger.valueOf(firstNumber);
        BigInteger one=BigInteger.ONE;

        int firstNumberCopy=firstNumber;

       while (firstNumberCopy!=secondNumber+1){
           String stringNumber=Integer.toString(firstNumberCopy);
           numbersToMuliply.add(0,firstNumberCopy);
           firstNumberCopy+=1;
       }

        for (int j = 0; j <numbersToMuliply.size() ; j++) {

           BigInteger currentNumber=BigInteger.valueOf(numbersToMuliply.get(j));
           sum=sum.multiply(currentNumber);

        }

        System.out.printf("product[%s..%s] = %s",firstNumber,secondNumber,sum);




    }
}
