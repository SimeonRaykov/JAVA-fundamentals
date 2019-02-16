import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new HashMap<>();

        String command = bf.readLine();
        while (!command.equalsIgnoreCase("END")){

            String[]tokens = command.split("\\s+");
            Person person = new Person(tokens[0]);
            people.putIfAbsent(tokens[0],person);

            command = bf.readLine();
        }



    }
}
