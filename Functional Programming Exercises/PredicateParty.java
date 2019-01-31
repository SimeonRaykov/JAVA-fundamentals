import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class PredicateParty {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] partyPeople = sc.nextLine().split("\\s+");
        List<String> people = new ArrayList<>();
        people.addAll(Arrays.asList(partyPeople));

        BiPredicate<String, String> startsWithStr = String::startsWith;

        BiPredicate<String, Integer> length = PredicateParty::test;

        BiPredicate<String, String> endsWithStr = String::endsWith;

        String command = sc.nextLine();
        while (!command.equals("Party!")) {

            String tokens[] = command.split("\\s+");
            String commandX = tokens[0];
            String predicate = tokens[1];

            if (commandX.equals("Remove")) {
                switch (predicate) {
                    case "StartsWith": {
                        String checker = tokens[2];
                        for (int i = 0; i < people.size(); i++) {
                            if (startsWithStr.test(people.get(i), checker)) {
                                people.remove(i);
                                i -= 1;
                            }
                        }
                        break;
                    }
                    case "EndsWith": {
                        String checker = tokens[2];
                        for (int i = 0; i < people.size(); i++) {
                            if (endsWithStr.test(people.get(i), checker)) {
                                people.remove(i);
                                i -= 1;
                            }
                        }
                        break;
                    }
                    case "Length": {
                        Integer checker = Integer.parseInt(tokens[2]);
                        for (int i = 0; i < people.size(); i++) {
                            if (length.test(people.get(i), checker)) {
                                people.remove(i);
                                i -= 1;
                            }
                        }
                        break;
                    }
                }

            } else if (commandX.equals("Double")) {
                if (predicate.equals("StartsWith")) {
                    String checker = tokens[2];
                    for (int i = 0; i < people.size(); i++) {
                        if (startsWithStr.test(people.get(i), checker)) {
                            people.add(i + 1, people.get(i));
                            i += 1;
                        }
                    }


                } else if (predicate.equals("EndsWith")) {
                    String checker = tokens[2];
                    for (int i = 0; i < people.size(); i++) {
                        if (endsWithStr.test(people.get(i), checker)) {
                            people.add(i + 1, people.get(i));
                            i += 1;
                        }
                    }

                } else if (predicate.equals("Length")) {
                    int checker = Integer.parseInt(tokens[2]);
                    for (int i = 0; i < people.size(); i++) {
                        if (length.test(people.get(i), checker)) {
                            people.add(i + 1, people.get(i));
                            i += 1;
                        }
                    }

                }
            }
            command = sc.nextLine();
        }

        if (people.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            int i = 1;
            for (String person : people) {
                if (i == people.size()) {
                    System.out.print(person + " ");
                } else {
                    System.out.print(person + ", ");
                }

                i += 1;
            }
            System.out.print("are going to the party!");
        }


    }

    private static boolean test(String x, Integer y) {
        return x.length() == y;
    }
}
