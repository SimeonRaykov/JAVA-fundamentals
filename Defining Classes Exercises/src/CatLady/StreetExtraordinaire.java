package CatLady;

public class StreetExtraordinaire extends Cat {

    private double decibelsOfMeows;
    private String name;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
        this.name = name;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" "+this.name + " " + getFormat().format(getDecibelsOfMeows());
    }
}
