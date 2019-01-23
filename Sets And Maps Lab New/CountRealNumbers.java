import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        double values[] = Arrays.stream(sc.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        for (int i = 0; i < values.length; i++) {
            if (numbersMap.containsKey(values[i])) {
                numbersMap.put(values[i], numbersMap.get(values[i]) + 1);
            } else {
                numbersMap.put(values[i], 1);
            }
        }
        DecimalFormat df = new DecimalFormat("#.0");

        for (Double num : numbersMap.keySet()) {
            System.out.printf("%.1f -> %s%n",(num),numbersMap.get(num));
        }

    }
}
