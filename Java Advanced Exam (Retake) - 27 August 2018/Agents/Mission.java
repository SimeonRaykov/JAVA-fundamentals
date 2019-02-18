package Agents;

public class Mission {

    private String name;
    private double rating;

    public Mission(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" -").append(this.getName()).append(" -> ")
                .append(this.getRating());

        return sb.toString();
    }
}
