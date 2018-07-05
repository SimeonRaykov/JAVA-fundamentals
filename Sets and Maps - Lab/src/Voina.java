import java.util.Scanner;

public class Voina {

    public static void main(String[] args) {
        Scanner Scanner=new Scanner(System.in);

        int number = (int)(Math.random() * 2);

       if (number == 0)
           System.out.println("First player win!");

       if (number == 1)
           System.out.println("Second player win!");



    }


}
