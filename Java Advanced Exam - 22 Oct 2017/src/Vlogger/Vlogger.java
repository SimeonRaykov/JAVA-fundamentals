package Vlogger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vlogger {

    private String name;
    private List<String> followers;
    private List<String> following;

    public Vlogger(String name) {
        this.name = name;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public void printFollowers() {
        if (this.getFollowersCount() != 0) {
            final List<String> sortedFollowers = this.getFollowers().stream().sorted(String::compareTo)
                    .collect(Collectors.toList());
            for (String follower : sortedFollowers) {
                System.out.println("*  " + follower);
            }
        }
    }

    public boolean containsFollower(String follower) {
        return this.followers.contains(follower);
    }

    public boolean containsFollowing(String following) {
        return this.following.contains(following);
    }

    public void addFollowing(String following) {
        if (!this.containsFollowing(following)) {
            if(!this.getName().equals(following)){
                this.following.add(following);
            }
        }
    }

    public void addFollower(String follower) {
        if (!this.containsFollower(follower)) {
            if(!this.getName().equals(follower)){
                this.followers.add(follower);
            }
        }
    }

    public int getFollowersCount() {
        return this.getFollowers().size();
    }

    public int getFollowingCount() {
        return this.getFollowing().size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }

}
