package Agents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Mission> validMissions = new HashSet<Mission>();
        LinkedHashMap<String, Agents> agentsMap = new LinkedHashMap<String, Agents>();

        String command = bf.readLine();
        while (!command.equals("registration")) {

            if (command.charAt(0) == '#') {
                String[] tokens = command.split(":");
                Mission mission = new Mission(tokens[0], Double.parseDouble(tokens[1]));
                validMissions.add(mission);
            } else if (Character.isDigit(command.charAt(command.length() - 2))
                    && Character.isDigit(command.charAt(command.length() - 3))) {
                Agents agent = new Agents(command);
                agentsMap.putIfAbsent(command, agent);
            }


            command = bf.readLine();
        }
        command = bf.readLine();

        while (!command.equals("operate")) {

            String tokens[] = command.split("->");
            if (tokens[0].equals("assign")) {
                if (containsMission(validMissions, tokens[2])) {
                    if (!agentsMap.get(tokens[1]).hasMission(tokens[2])) {
                        Mission mission = new Mission(tokens[2], getMission(validMissions, tokens[2]));
                        agentsMap.get(tokens[1]).addMission(mission);
                    }
                }
            } else if (tokens[0].equals("abort")) {

                for (Map.Entry<String, Agents> agent : agentsMap.entrySet()) {
                    if (agent.getValue().hasMission(tokens[1])) {
                        agent.getValue().removeMission(tokens[1]);
                    }
                }

            } else if (tokens[0].equals("change")) {
                HashSet<Mission> arrMissionsA = agentsMap.get(tokens[1]).getMissions();
                HashSet<Mission> arrMissionsB = agentsMap.get(tokens[2]).getMissions();
                agentsMap.get(tokens[1]).setMissions(arrMissionsB);
                agentsMap.get(tokens[2]).setMissions(arrMissionsA);
            }
            command = bf.readLine();
        }

        List<Map.Entry<String, Agents>> sortedAgents = agentsMap.entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().sumTotalRation(), e1.getValue().sumTotalRation()))
                .collect(Collectors.toList());

        for (Map.Entry<String, Agents> sortedAgent : sortedAgents) {
            if (sortedAgent.getValue().getMissions() != null
                    && sortedAgent.getValue().getMissions().size() != 0) {
                System.out.println(sortedAgent.getValue().toString());
                List<Mission> sortedMissions = sortedAgent.getValue().getMissions()
                        .stream()
                        .sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()))
                        .collect(Collectors.toList());

                for (Mission sortedMission : sortedMissions) {
                    System.out.println(sortedMission.toString());
                }
            }
        }
    }

    private static boolean containsMission(HashSet<Mission> missions, String name) {
        for (Mission mission1 : missions) {
            if (mission1.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static double getMission(HashSet<Mission> missions, String name) {
        if (missions.size() <= 0) {
            return 0;
        }
        for (Mission mission : missions) {
            if (mission.getName().equals(name)) {
                return mission.getRating();
            }
        }
        return 0;
    }
}
