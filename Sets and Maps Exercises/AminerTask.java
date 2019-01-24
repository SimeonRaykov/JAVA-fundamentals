import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AminerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String resource = sc.nextLine();
        Map<String, Integer> resourceMap = new LinkedHashMap<>();
        int quantity = 0;
        for (int i = 0; i < 1000000; i++) {
            if (i % 2 == 0) {
                quantity = Integer.parseInt(sc.nextLine());
            } else {
                resource = sc.nextLine();
                if (resource.equals("stop")) {
                    break;
                }
            }
            if (i % 2 == 0 || i == 0) {
                if (!resourceMap.containsKey(resource)) {
                    resourceMap.put(resource, quantity);
                } else {
                    resourceMap.put(resource, resourceMap.get(resource) + quantity);
                }
            }
        }
        for (String s : resourceMap.keySet()) {
            System.out.println(s + " -> " + resourceMap.get(s));
        }
    }
}


