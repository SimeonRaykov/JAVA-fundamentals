package Agents;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

public class Agents {

    private String name;
    private double totalRating;
    private HashSet<Mission> missions;

    public Agents(String name) {
        this.name = name;
        this.missions = new HashSet<Mission>();
    }

    public double sumTotalRation() {
        double a = 0.0;
        for (Mission mission : missions) {
            a += mission.getRating();
        }
        return a;
    }

    public void addMission(Mission mission) {
        this.getMissions().add(mission);
    }

    public void removeMission(String name) {
        for (Mission mission1 : missions) {
            if(mission1.getName().equals(name)){
                this.missions.remove(mission1);
                break;
            }
        }
    }

    public boolean hasMission(String mission) {
        if(this.missions == null){
            return false;
        }
        for (Mission missionX : missions) {
            if (missionX.getName().equals(mission)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(double totalRating) {
        this.totalRating = totalRating;
    }

    public HashSet<Mission> getMissions() {
        return missions;
    }

    public void setMissions(HashSet<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");
        sb.append("Agent: ").append(this.getName()).append(" - Total Rating: ")
                .append(df.format(sumTotalRation()));


        return sb.toString();
    }
}
