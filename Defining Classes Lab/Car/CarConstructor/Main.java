package CarConstructor;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i <n ; i++) {
            String tokens [] = sc.nextLine().split(" ");
            if(tokens.length==1){
                Car car = new Car(tokens[0]);
                System.out.println("The car is: "+car.getInfo());
            }
            else{
                Car car = new Car(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
                System.out.println("The car is: "+car.getInfo());
            }
        }
    }
}
