package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String command = bf.readLine();
        HashMap<String, Cat> cats = new HashMap<>();
        while (!command.equals("End")) {
            String tokens[] = command.split("\\s+");

            switch (tokens[0]) {
                case "Siamese": {
                    Cat cat = new Siamese(tokens[1], Double.parseDouble(tokens[2]));
                    cats.putIfAbsent(tokens[1], cat);
                    break;
                }
                case "Cymric": {
                    Cat cat = new Cymric(tokens[1], Double.parseDouble(tokens[2]));
                    cats.putIfAbsent(tokens[1], cat);
                    break;
                }
                case "StreetExtraordinaire": {
                    Cat cat = new StreetExtraordinaire(tokens[1], Double.parseDouble(tokens[2]));
                    cats.putIfAbsent(tokens[1], cat);
                    break;
                }
            }

            command = bf.readLine();
        }
        String chosenCat = bf.readLine();

        System.out.println(cats.get(chosenCat).toString());

    }
}
