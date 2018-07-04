import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {

        Scanner Scanner=new Scanner(System.in);
        double kms=Double.parseDouble(Scanner.nextLine());
        double price=1;

        String typeOfDay=Scanner.nextLine();
        if(kms<20){

            if(typeOfDay.equals("day")){
price=0.7+(0.79*kms);
            }
            else if(typeOfDay.equals("night")){
price=0.7+(kms*0.9);
            }


        }
        else if(kms<100){


price=0.09*kms;



        }
        else if(kms>=100){

price=0.06*kms;

        }

        System.out.printf("%.2f",price);
    }
}
