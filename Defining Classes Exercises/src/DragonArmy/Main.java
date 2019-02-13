package DragonArmy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        LinkedHashMap<String, TypeDrake> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String tokens[] = bf.readLine().split("\\s+");
            if (tokens[2].equals("null")) {
                tokens[2] = Dragon.DEFAULT_DAMAGE + "";
            }
            if (tokens[3].equals("null")) {
                tokens[3] = Dragon.DEFAULT_HEALTH + "";
            }
            if (tokens[4].equals("null")) {
                tokens[4] = Dragon.DEFAULT_ARMOR + "";
            }

            Dragon dragon = new Dragon(tokens[1],
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4]));

            TypeDrake titan = new TypeDrake(tokens[0]);
            dragons.putIfAbsent(tokens[0], titan);
            dragons.get(tokens[0]).addDrake(dragon);
        }

        for (TypeDrake typeDrake : dragons.values()) {
            System.out.println(typeDrake.toString());
            typeDrake.getDragons().stream().sorted(Comparator.comparing(Dragon::getName))
                    .forEach(e1 -> System.out.println(e1.toString()));
        }

    }
}
