package OpinionPoll;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        TreeMap<String, Integer> people = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            people.put(tokens[0], Integer.parseInt(tokens[1]));
        }

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (person.getValue() > 30) {
                System.out.println(person.getKey() + " - " + person.getValue());
            }
        }

    }
}
