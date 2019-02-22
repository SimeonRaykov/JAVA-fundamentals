package Vlogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String command = bf.readLine();
        TreeMap<String, Vlogger> vloggers = new TreeMap<>();


        while (!command.equals("Statistics")) {

            String tokens[] = command.split("\\s+");

            if (tokens[1].equals("joined")) {
                if (!vloggers.containsKey(tokens[0])) {
                    Vlogger vlogger = new Vlogger(tokens[0]);
                    vloggers.put(tokens[0], vlogger);
                }
            } else if (tokens[1].equals("followed")) {
                if (vloggers.containsKey(tokens[0]) && vloggers.containsKey(tokens[2])) {
                    vloggers.get(tokens[0]).addFollowing(tokens[2]);
                    vloggers.get(tokens[2]).addFollower(tokens[0]);
                }
            }
            command = bf.readLine();
        }

        System.out.println("The V-Logger has a total of " + vloggers.size() + " vloggers in its logs.");

        List<Vlogger> sortedVloggers = vloggers
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Vlogger::getFollowersCount)
                        .reversed()
                        .thenComparingInt(Vlogger::getFollowingCount))
                .collect(Collectors.toList());

        int i = 1;
        for (Vlogger sortedVlogger : sortedVloggers) {
            System.out.println(i + ". " + sortedVlogger.getName() + " :" + " " + sortedVlogger.getFollowersCount()+" followers" + ", " + sortedVlogger.getFollowingCount() + " following");
            if(i == 1) {
                sortedVlogger.printFollowers();
            }
            i += 1;
        }


    }
}
