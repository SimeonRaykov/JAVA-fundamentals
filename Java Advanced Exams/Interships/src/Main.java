import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int nProblemsCount = Integer.parseInt(reader.readLine());
            int mPersonsCount = Integer.parseInt(reader.readLine());


            List<String> problemsList = new ArrayList<>();
            List<String> candidates = new ArrayList<String>();
            List<String> failedProblems = new ArrayList<String>();

            String pattern = "[A-Z]{1}[a-z]+ [A-Z]{1}[a-z]+";

            for (int i = 0; i < nProblemsCount; i++) {

                String currentProblem = reader.readLine();
                problemsList.add(currentProblem);

            }
            Collections.reverse(problemsList);

            boolean isOnlyOne = false;


            for (int i = 0; i < mPersonsCount; i++) {

                long sumCharsPerson = 0;
                long sumCharsProblem = 0;

                String currentPerson = reader.readLine();
                if (currentPerson.matches(pattern)) {

                    String currentProblem = problemsList.get(0);

                    candidates.add(currentPerson);

                    for (int j = 0; j < currentPerson.length(); j++) {

                        sumCharsPerson += currentPerson.charAt(j);
                    }

                    for (int k = 0; k < currentProblem.length(); k++) {

                        sumCharsProblem += currentProblem.charAt(k);

                    }

                    if (sumCharsPerson >= sumCharsProblem) {

                        System.out.printf("%s solved %s.%n", currentPerson, currentProblem);
                        problemsList.remove(currentProblem);
                    } else {
                        System.out.printf("%s failed %s.%n", currentPerson, currentProblem);
                        candidates.remove(currentPerson);
                        problemsList.remove(currentProblem);
                        failedProblems.add(currentProblem);
                    }

                }


            }

            int i = 0;


            if (failedProblems.size() != 0) {

                while (failedProblems.size() == 0 || candidates.size() != 1) {

                    long sumCharsPerson = 0;
                    long sumCharsProblem = 0;

                    if (candidates.size() == 1) {
                        isOnlyOne = true;
                        break;
                    }

                    String currentPerson = candidates.get(0);

                    String failedProblem = failedProblems.get(0);


                    for (int j = 0; j < currentPerson.length(); j++) {

                        sumCharsPerson += currentPerson.charAt(j);
                    }

                    for (int k = 0; k < failedProblem.length(); k++) {

                        sumCharsProblem += failedProblem.charAt(k);

                    }
                    if (candidates.size() == 1) {
                        isOnlyOne = true;
                        break;
                    }

                    if (sumCharsPerson >= sumCharsProblem) {

                        System.out.printf("%s solved %s.%n", currentPerson, failedProblem);
                        failedProblems.remove(failedProblem);
                    } else {
                        System.out.printf("%s failed %s.%n", currentPerson, failedProblem);
                        candidates.remove(currentPerson);
                        continue;

                    }
                    if (candidates.size() == 1) {
                        isOnlyOne = true;
                        break;
                    }

                }
            }

            if (candidates.size() == 1) {
                System.out.printf("%s gets the job!", candidates.get(0));

            } else {
                System.out.println(String.join(",", candidates));
            }
        }
        catch (Exception e){

        }

    }
}
