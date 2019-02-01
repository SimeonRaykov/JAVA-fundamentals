package Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String tokens[] = sc.nextLine().split("\\s+");
            Car car = new Car();
            car.setMake(tokens[0]);
            car.setModel(tokens[1]);
            car.setHorsePower(Integer.parseInt(tokens[2]));
            System.out.println("The car is: " + car.getInfo());
        }

    }
}
