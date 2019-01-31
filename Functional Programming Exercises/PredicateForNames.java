import java.util.*;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Predicate<String> checkCorrectName = x -> x.length() <= n;
        String[] namesX = sc.nextLine().split("\\s+");

        List<String> names = new ArrayList<>(Arrays.asList(namesX));
        for (int i = 0; i < names.size(); i += 1) {
            if (!checkCorrectName.test(names.get(i))) {
                names.remove(i);
                i-=1;
            }
        }
        for (String name : names) {
            System.out.println(name);
        }

    }
}
