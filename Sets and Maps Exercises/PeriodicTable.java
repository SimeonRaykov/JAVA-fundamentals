import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        TreeSet<String> periodicElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                periodicElements.add(line[j]);
            }
        }

        for (String periodicElement : periodicElements) {
            System.out.print(periodicElement+" ");
        }

    }
}
