import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Mission {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> missionValidation = new ArrayList<>(Arrays.asList("M", "I", "S", "S", "I", "O", "N"));

        String line = bf.readLine();
        HashMap<String,Integer> completedMissions = new HashMap<>();
        HashMap<String,Integer> failedMissions = new HashMap<>();

        while (!line.equals("Decrypt")) {

            int sum = 0;
            StringBuilder missionName = new StringBuilder();
            if (containsMission(line)) {
                char[] charArray = line.toCharArray();
                for (char c : charArray) {
                    if (Character.isDigit(c)) {
                        sum += Integer.parseInt(c+"");
                    } else if (Character.isLowerCase(c)) {
                        missionName.append(c);
                    }
                }
                if(line.contains("C")){
                    completedMissions.put(missionName.toString(),sum);
                 //   System.out.println("Completed mission "+missionName.toString()+" with rating: "+sum);
                }
                else if(line.contains("X")){
                    failedMissions.put(missionName.toString(),sum);
                //    System.out.println("Failed Mission "+missionName.toString()+" with rating: "+sum);
                }
            }

            line = bf.readLine();
        }

        List<Map.Entry<String, Integer>> completedMissionsSorted = completedMissions.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());

        List<Map.Entry<String, Integer>> failedMissionsSorted = failedMissions.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());

        Map.Entry<String, Integer> completedX = completedMissionsSorted.get(0);
        System.out.println("Completed mission "+completedX.getKey()+" with rating: "+completedX.getValue());
        Map.Entry<String, Integer> failedX = failedMissionsSorted.get(0);
        System.out.println("Failed Mission "+failedX.getKey()+" with rating: "+failedX.getValue());

    }

    private static boolean containsMission(String line) {

        String validation = "MISSION";
        int i = 0;
        char[] charArray = line.toCharArray();
        for (char c : charArray) {
            if (c == validation.charAt(i)) {
                if (validation.length() - 1 == i) {
                    return true;
                }
                i += 1;
            }
        }
        return false;
    }
}
