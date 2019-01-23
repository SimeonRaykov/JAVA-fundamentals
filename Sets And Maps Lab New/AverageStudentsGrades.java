import java.text.DecimalFormat;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();
        int lines = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] info = sc.nextLine().split(" ");
            if (!students.containsKey(info[0])) {
                students.put(info[0], new ArrayList<>());
            }
            students.get(info[0]).add(Double.parseDouble(info[1]));
        }
        DecimalFormat df = new DecimalFormat("#.00");

        for (String student : students.keySet()) {
            System.out.print(student + " -> ");
            for (int i = 0; i < students.get(student).size(); i++) {
                System.out.print(df.format(students.get(student).get(i)) + " ");
            }
            System.out.println("(avg: " + df.format(calculateAverage(students.get(student))) + ")");
        }


    }

    private static double calculateAverage(List<Double> marks) {
        double sum = 0;
        if (!marks.isEmpty()) {
            for (double mark : marks) {
                sum += mark;
            }
            return sum / marks.size();
        }
        return sum;
    }
}
