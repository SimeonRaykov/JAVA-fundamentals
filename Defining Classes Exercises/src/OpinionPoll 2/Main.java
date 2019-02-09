package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(bf.readLine());
        Set<Human> humans = new HashSet<>();

        for (int i = 0; i < lines; i++) {

            String[] tokens = bf.readLine().split("\\s+");
            Human currentHuman = new Human(tokens[0], Integer.parseInt(tokens[1]));
            humans.add(currentHuman);

        }

        List<Human> collect = humans.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Human::getName))
                .collect(Collectors.toList());

        for (Human human : collect) {
            System.out.println(human.toString());
        }
    }
}
