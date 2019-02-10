package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int lines = Integer.parseInt(bf.readLine());
        for (int i = 0; i < lines; i++) {
            String tokens[] = bf.readLine().split("\\s+");
            Engine currEngine = new Engine(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            Cargo currCargo = new Cargo(Integer.parseInt(tokens[3]), tokens[4]);

            Tyres currTyres = new Tyres(Double.parseDouble(tokens[5]), Integer.parseInt(tokens[6]),
                    Double.parseDouble(tokens[7]), Integer.parseInt(tokens[8]),
                    Double.parseDouble(tokens[9]), Integer.parseInt(tokens[10]),
                    Double.parseDouble(tokens[11]), Integer.parseInt(tokens[12]));

            Car car = new Car(tokens[0], currEngine, currCargo, currTyres);
            cars.put(tokens[0], car);
        }

        String type = bf.readLine();
        if (type.equals("fragile")) {
            List<Car> fragileCars = cars.values().stream()
                    .filter(e -> e.getCargo().getType().equals("fragile"))
                    .filter(p -> p.getTyres().isLowPressure())
                    .collect(Collectors.toList());

            for (Car fragileCar : fragileCars) {
                System.out.println(fragileCar.toString());
            }
        } else {
            List<Car> flamableCars = cars.values().stream()
                    .filter(e -> e.getCargo().getType().equals("flamable"))
                    .filter(p -> p.getEngine().getPower() > 250)
                    .collect(Collectors.toList());

            for (Car flamableCar : flamableCars) {
                System.out.println(flamableCar.toString());
            }

        }
    }
}
