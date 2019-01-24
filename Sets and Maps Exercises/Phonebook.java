import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String[] command = sc.nextLine().split("-");
        while (!command[0].equals("search")) {
            phonebook.put(command[0], command[1]);
            command = sc.nextLine().split("-");
        }
        String name = sc.nextLine();

        while (!name.equals("stop")) {
            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }
            name = sc.nextLine();
        }

    }
}
