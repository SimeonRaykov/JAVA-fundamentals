package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int eLines = Integer.parseInt(bf.readLine());
        for (int i = 0; i < eLines; i++) {
            String tokens[] = bf.readLine().split("\\s+");
            if (tokens.length == 2) {
                Engine engine = new Engine(tokens[0], Integer.parseInt(tokens[1]));
                putEngineInMap(engines, tokens[0], engine);

            } else if (tokens.length == 3) {
                try {
                    Engine engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    putEngineInMap(engines, tokens[0], engine);
                } catch (Exception e) {
                    Engine engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    putEngineInMap(engines, tokens[0], engine);
                }
            } else if (tokens.length == 4) {
                Engine engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
                putEngineInMap(engines, tokens[0], engine);
            }
        }


        int cLines = Integer.parseInt(bf.readLine());
        for (int i = 0; i < cLines; i++) {
            String tokens[] = bf.readLine().split("\\s+");
            Engine currEngine = engines.get(tokens[1]);
            if (tokens.length == 2) {
                Car car = new Car(tokens[0], currEngine);
                putCarInMap(cars, tokens[0], car);
            } else if (tokens.length == 3) {
                try {
                    Car car = new Car(tokens[0], currEngine, Integer.parseInt(tokens[2]));
                    putCarInMap(cars, tokens[0], car);
                } catch (Exception e) {
                    Car car = new Car(tokens[0], currEngine, tokens[2]);
                    putCarInMap(cars, tokens[0], car);
                }
            } else if (tokens.length == 4) {
                Car car = new Car(tokens[0], currEngine, Integer.parseInt(tokens[2]), tokens[3]);
                putCarInMap(cars, tokens[0], car);
            }
        }

        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }

    }

    private static void putCarInMap(LinkedHashMap<String, Car> cars, String token, Car car) {
        cars.putIfAbsent(token, car);
    }

    private static void putEngineInMap(LinkedHashMap<String, Engine> engines, String token, Engine engine) {
        engines.putIfAbsent(token, engine);
    }
}
