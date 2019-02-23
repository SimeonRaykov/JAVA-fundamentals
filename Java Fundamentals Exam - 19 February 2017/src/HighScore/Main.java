package HighScore;

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

        String command = bf.readLine();
        HashMap<String, Duelist> duelists = new HashMap<>();

        while (!command.equals("osu!")) {

            String tokens[] = command.split("\\s|<->");

            if (!duelists.containsKey(tokens[1])) {
                Duelist duelist = new Duelist(tokens[1], Integer.parseInt(tokens[0]));
                duelists.put(tokens[1], duelist);
            }
            if (!duelists.containsKey(tokens[2])) {
                Duelist duelist = new Duelist(tokens[2], Integer.parseInt(tokens[3]));
                duelists.put(tokens[2], duelist);
            }

            if (Integer.parseInt(tokens[0]) > Integer.parseInt(tokens[3])) {
                duelists.get(tokens[1]).addScoreToTotal((Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[3])));
                duelists.get(tokens[2]).subtractToTotal((Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[3])));
                duelists.get(tokens[1]).addDuel(tokens[2],- (Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[3])));
                duelists.get(tokens[2]).addDuel(tokens[1], (Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[3])));
            } else {
                duelists.get(tokens[2]).addScoreToTotal((Integer.parseInt(tokens[3]) - Integer.parseInt(tokens[0])));
                duelists.get(tokens[1]).subtractToTotal((Integer.parseInt(tokens[3]) - Integer.parseInt(tokens[0])));
                duelists.get(tokens[1]).addDuel(tokens[2],- (Integer.parseInt(tokens[3]) - Integer.parseInt(tokens[0])));
                duelists.get(tokens[2]).addDuel(tokens[1], (Integer.parseInt(tokens[3]) - Integer.parseInt(tokens[0])));
            }

            command = bf.readLine();
        }

        List<Duelist> sortedDuelists = duelists.values().stream().sorted(Comparator.comparingInt(Duelist::getTotalScore).reversed()).collect(Collectors.toList());
        for (Duelist sortedDuelist : sortedDuelists) {
            System.out.println(sortedDuelist.toString());
            sortedDuelist.printDuels();
        }
    }
}
