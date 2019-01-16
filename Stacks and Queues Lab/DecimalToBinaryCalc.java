import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryCalc {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        ArrayDeque<Integer> deck =new ArrayDeque<>();
        int decimal = Integer.parseInt(sc.nextLine());
        if(decimal==0){
            System.out.println(0);
        }
        else{
            while(decimal>0){
                int reminder = decimal%2;
                decimal/=2;
                deck.push(reminder);
            }
            while (!deck.isEmpty()){
                System.out.print(deck.pop());
            }
        }
    }
}
