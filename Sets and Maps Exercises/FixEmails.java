import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        Map<String, String> emailsMap = new LinkedHashMap<>();
        String email = "";
        for (int i = 0; i < 1000000; i++) {
            if (i % 2 == 0) {
                email = sc.nextLine();
                if(email.equals("stop")){
                    break;
                }
            } else {
                name = sc.nextLine();
                if (name.equals("stop")) {
                    break;
                }
            }
            if (i % 2 == 0) {
                if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {

                } else {
                    emailsMap.put(name, email);
                }
            }
        }
        for (String s : emailsMap.keySet()) {
            System.out.println(s + " -> " + emailsMap.get(s));
        }
    }
}
