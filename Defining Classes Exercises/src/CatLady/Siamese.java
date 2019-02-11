package CatLady;

public class Siamese extends Cat {
    private double earSize;
    private String name;

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    public Siamese(String name,double earSize) {
        this.earSize = earSize;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" "+this.name +" "+getFormat().format(getEarSize());
    }

}
