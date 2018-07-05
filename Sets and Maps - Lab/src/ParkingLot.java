import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class ParkingLot {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        HashSet<String> carsSet = new HashSet<>();

        String input = Scanner.nextLine();
        while (!input.equals("END")) {

            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber=tokens[1];

            if(command.equals("IN")){

                carsSet.add(carNumber);

            }
            else if(command.equals("OUT")){

                carsSet.remove(carNumber);

            }


            input = Scanner.nextLine();
        }


        if(carsSet.size()==0){
            System.out.println("Parking Lot is Empty");
        }

        else{
            Iterator iter = carsSet.iterator();
            while(iter.hasNext()){

                String obj = (String)iter.next();
                System.out.printf("%s%n",obj);
            }


        }

    }
}
