import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(", ");
        HashSet<String> cars = new HashSet<>();

        while (!line[0].equals("END")) {

            if (line[0].equals("IN")) {
                cars.add(line[1]);
            } else {
                if (cars.contains(line[1])) {
                    cars.remove(line[1]);
                }
            }

            line = sc.nextLine().split(", ");
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
