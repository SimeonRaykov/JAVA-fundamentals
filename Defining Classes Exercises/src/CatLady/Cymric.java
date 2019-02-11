package CatLady;

public class Cymric extends Cat {

    private String name;
    private double furLength;

    public Cymric(String name,double furLength) {
        this.furLength = furLength;
        this.name = name;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" "+this.name + " " +getFormat().format(getFurLength());
    }

}
