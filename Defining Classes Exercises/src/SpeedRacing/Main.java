package SpeedRacing;

import SpeedRacing.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        int lines = Integer.parseInt(bf.readLine());

        for (int i = 0; i < lines; i++) {
            String tokens[] = bf.readLine().split("\\s+");
            Car car = new Car(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            cars.put(tokens[0], car);
        }

        String command = bf.readLine();
        while (!command.equals("End")) {

            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("Drive")) {
                if (cars.get(tokens[1]).canMove(Integer.parseInt(tokens[2]))) {
                    cars.get(tokens[1]).moveCar(Integer.parseInt(tokens[2]));
                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
            command = bf.readLine();
        }

        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }

    }
}
