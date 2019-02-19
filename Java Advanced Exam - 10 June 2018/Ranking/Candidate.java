package Ranking;

import java.util.HashMap;
import java.util.Map;

public class Candidate {

    private String name;
    private HashMap<Contest, Integer> contests;

    public Candidate(String name) {
        this.name = name;
        this.contests = new HashMap<>();
    }

    public boolean containsContest(String contest){
        for (Contest contest1 : contests.keySet()) {
            if(contest1.getName().equals(contest)){
                return true;
            }
        }
        return false;
    }

    public Contest getContest(String contest) {
        for (Contest contest1 : contests.keySet()) {
            if (contest1.getName().equals(contest)) {
                return contest1;
            }
        }
        return null;
    }

    public int sumAllPoints() {
        int sum = 0;
        for (Map.Entry<Contest, Integer> contest : contests.entrySet()) {
            sum += contest.getValue();
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Contest, Integer> getContests() {
        return contests;
    }

    public void setContests(HashMap<Contest, Integer> contests) {
        this.contests = contests;
    }
}
