package CarConstructor;

public class Car {

    private String make;
    private String model;
    private int horsePower;

    public static final String unsetValue = "unknown";
    public static final int negativeValue = -1;

    public Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String make) {
        this.make = make;
        this.model = Car.unsetValue;
        this.horsePower = Car.negativeValue;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getInfo() {
        return this.make + " " + this.model + " - " + this.horsePower + " HP.";
    }
}
