package HighScore;


import java.util.LinkedHashMap;
import java.util.Map;

public class Duelist {

    private String name;
    private int initialScore;
    private LinkedHashMap<Integer, String> duels;
    private int totalScore;

    public Duelist(String name, int initialScore) {
        this.name = name;
        this.initialScore = initialScore;
        this.totalScore = 0;
        this.duels = new LinkedHashMap<>();
    }

    public void addDuel(String duel, Integer score) {
        this.duels.put(score, duel);
    }

    public void addScoreToTotal(int difference) {
        this.totalScore += difference;
    }

    public void subtractToTotal(int difference) {
        this.totalScore -= difference;
    }

    public void printDuels() {
        for (Map.Entry<Integer, String> duelInfo : duels.entrySet()) {
            System.out.println("*  " + duelInfo.getValue() + " <-> " + duelInfo.getKey());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitialScore() {
        return initialScore;
    }

    public void setInitialScore(int initialScore) {
        this.initialScore = initialScore;
    }

    public LinkedHashMap<Integer, String> getDuels() {
        return duels;
    }

    public void setDuels(LinkedHashMap<Integer, String> duels) {
        this.duels = duels;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - (").append(this.getTotalScore()).append(")");
        return sb.toString();
    }
}
