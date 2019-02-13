package LogsAggregator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        HashMap<String, User> users = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            User user = new User(tokens[1]);
            IPaddress ip = new IPaddress(tokens[0], Integer.parseInt(tokens[2]));

            if (!users.containsKey(tokens[1])) {
                users.put(tokens[1], user);
                users.get(tokens[1]).addAddress(ip);
            }
            //Increment Time
            else if (users.get(tokens[1]).contains(tokens[0])) {
                users.get(tokens[1]).incrementTime(tokens[0], Integer.parseInt(tokens[2]));
                //Add addresses
            } else {
                users.get(tokens[1]).addAddress(ip);
            }
        }

        List<User> sortedUsers = users.values().stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());

        for (User sortedUser : sortedUsers) {
            sortedUser.sortCollection();
            System.out.println(sortedUser.toString());
        }

    }
}
