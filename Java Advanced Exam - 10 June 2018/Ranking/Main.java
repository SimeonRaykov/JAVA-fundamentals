package Ranking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Contest> contests = new ArrayList<>();
        HashMap<String, Candidate> candidates = new HashMap<>();
        String line = bf.readLine();


        while (!line.equals("end of contests")) {

            String tokens[] = line.split(":");
            Contest contest = new Contest(tokens[0], tokens[1]);
            contests.add(contest);
            line = bf.readLine();
        }

        line = bf.readLine();
        while (!line.equals("end of submissions")) {

            String tokens[] = line.split("=>");
            Contest contest = new Contest(tokens[0], tokens[1]);

            if (containsContest(contests, tokens[0], tokens[1])) {
                if (!candidates.containsKey(tokens[2])) {
                    Candidate candidate = new Candidate(tokens[2]);
                    candidates.put(tokens[2], candidate);
                }
                if (candidates.get(tokens[2]).containsContest(tokens[0])) {
                    if (candidates.get(tokens[2]).getContest(tokens[0]).getPoints() < Integer.parseInt(tokens[3])) {
                        candidates.get(tokens[2]).getContest(tokens[0]).setPoints(Integer.parseInt(tokens[3]));
                    }
                } else {
                    candidates.get(tokens[2]).getContests().put(contest, Integer.parseInt(tokens[3]));
                    candidates.get(tokens[2]).getContest(tokens[0]).setPoints(Integer.parseInt(tokens[3]));
                }

            }

            line = bf.readLine();
        }

        List<Map.Entry<String, Candidate>> sortedCandidatesByAllPoints = candidates.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().sumAllPoints(), e1.getValue().sumAllPoints()))
                .collect(Collectors.toList());

        Map.Entry<String, Candidate> bestCandidate = sortedCandidatesByAllPoints.get(0);
        System.out.println("Best candidate is " + bestCandidate.getValue().getName() + " with total " + bestCandidate.getValue().sumAllPoints() + " points.");
        System.out.println("Ranking:");

        List<Candidate> sortedCandidatesByName = candidates.values()
                .stream()
                .sorted(Comparator.comparing(Candidate::getName))
                .collect(Collectors.toList());

        for (Candidate candidate : sortedCandidatesByName) {
            System.out.println(candidate.getName());
            List<Map.Entry<Contest, Integer>> sortedContests = candidate.getContests()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .collect(Collectors.toList());
            for (Map.Entry<Contest, Integer> sortedContest : sortedContests) {
                System.out.println("# " + sortedContest.getKey().getName() + " ->" + sortedContest.getValue());
            }
        }

    }

    public static boolean containsContest(List<Contest> contests, String name, String password) {
        for (Contest contest : contests) {
            if (contest.getName().equals(name) && contest.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
