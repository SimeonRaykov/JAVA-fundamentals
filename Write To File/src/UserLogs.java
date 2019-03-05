import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        while (!line.equals("end")) {
            String tokens[] = line.split(" ");
            String ip = tokens[0].substring(3);
            String user = tokens[2].substring(5);

            if (!userLogs.containsKey(user)) {
                userLogs.put(user, new LinkedHashMap<>());
            }
            if (!userLogs.get(user).containsKey(ip)) {
                userLogs.get(user).put(ip, 1);
            } else {
                userLogs.get(user).put(ip, userLogs.get(user).get(ip) + 1);
            }
            line = sc.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : userLogs.entrySet()) {
            int i = 1;
            System.out.println(user.getKey() + ": ");
            for (Map.Entry<String, Integer> ip : user.getValue().entrySet()) {
                if(i==user.getValue().entrySet().size()) {
                    System.out.print(ip.getKey() + " => " + ip.getValue() + ".");
                }
                else{
                    System.out.print(ip.getKey() + " => " + ip.getValue() + ", ");
                }
                i+=1;
            }
            System.out.println();
        }

    }
}
