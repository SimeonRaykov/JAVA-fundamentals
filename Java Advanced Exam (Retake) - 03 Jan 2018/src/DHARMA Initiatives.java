import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Set<String> validDharma = new HashSet<>(Arrays.asList("Hydra", "Arrow",
                "Flame", "Pearl", "Orchid"));

        String[] command = bf.readLine().split(":");
        TreeMap<String, Integer> dharmaInitiatives = new TreeMap<>();
        HashMap<String, HashMap<String, Integer>> stationMap = new HashMap<>();


        while (!command[0].equals("Recruit")) {

            if (!validDharma.contains(command[2])) {
                command = bf.readLine().split(":");
                continue;
            } else {
                dharmaInitiatives.putIfAbsent(command[2], 0);
                dharmaInitiatives.put(command[2], dharmaInitiatives.get(command[2]) + 1);
                stationMap.putIfAbsent(command[2], new HashMap<>());
                stationMap.get(command[2]).put(command[0], Integer.parseInt(command[1]));
            }
            command = bf.readLine().split(":");
        }

        String caseX = bf.readLine();
        if (caseX.equals("DHARMA Initiative")) {
            List<Map.Entry<String, Integer>> sortedDharmas = dharmaInitiatives
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .collect(Collectors.toList());

            for (Map.Entry<String, Integer> sortedDharma : sortedDharmas) {
                System.out.println("The " + sortedDharma.getKey() + " has " + sortedDharma.getValue() + " DHARMA recruits in it.");
            }

        } else if (!validDharma.contains(caseX)) {
            System.out.println("DHARMA Initiative does not have such a station!");
        } else {

            List<Map.Entry<String, Integer>> sortedStation = new LinkedList<>();
            boolean isInvalid = false;
            try {
                sortedStation = stationMap.get(caseX)
                        .entrySet()
                        .stream()
                        .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                        .collect(Collectors.toList());
            }
            catch (Exception e){
                isInvalid = true;
            }

            if (caseX.equals("Arrow")) {
                System.out.println("The Arrow station: Development of defensive strategies, and Intelligence gathering.");
            } else if (caseX.equals("Hydra")) {
                System.out.println("The Hydra station: Zoological Research.");
            } else if (caseX.equals("Flame")) {
                System.out.println("The Flame station: Communication.");
            } else if (caseX.equals("Orchid")) {
                System.out.println("The Orchid station: Space-time manipulation research, disguised as a Botanical station.");
            } else if (caseX.equals("Pearl")) {
                System.out.println("The Pearl station: Psychological Research and/or Observation.");
            }
if(isInvalid){
    System.out.print(" No recruits");
    return;
}
            for (Map.Entry<String, Integer> person : sortedStation) {
                System.out.println("###" + person.getKey() + " - " + person.getValue());
            }
        }
    }
}
