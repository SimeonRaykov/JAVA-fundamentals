package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Person> people = new HashMap<>();
        String command = bf.readLine();
        while (!command.equals("End")) {

            String tokens[] = command.split("\\s+");
            if (!people.containsKey(tokens[0])) {
                Person person = new Person(tokens[0]);
                people.put(tokens[0],person);
            }

            if (tokens[1].equals("pokemon")) {
                Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                people.get(tokens[0]).addPokemon(pokemon);

            } else if (tokens[1].equals("parents")) {
                Parents parent = new Parents(tokens[2], tokens[3]);
                people.get(tokens[0]).addParent(parent);

            } else if (tokens[1].equals("children")) {
                Children child = new Children(tokens[2], tokens[3]);
                people.get(tokens[0]).addChild(child);

            } else if (tokens[1].equals("car")) {
                Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                people.get(tokens[0]).setCar(car);

            } else if (tokens[1].equals("company")) {
                Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                people.get(tokens[0]).setCompany(company);

            }
            command = bf.readLine();
        }

        String chosenOne = bf.readLine();
        System.out.println(people.get(chosenOne).toString());

        //  for (Person person : people.values()) {
        //      if (person.getName().equals(chosenOne)) {
        //          System.out.println(person.toString());
        //          break;
        //      }
        //  }

    }
}
