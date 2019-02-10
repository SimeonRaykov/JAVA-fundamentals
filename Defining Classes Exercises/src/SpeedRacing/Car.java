package SpeedRacing;

import java.text.DecimalFormat;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public boolean canMove(int distance) {
        return getFuelAmount() / getFuelCost() >= distance*1.0;
    }

    public void moveCar(int distance) {
        setDistanceTraveled(distance);
        double fuelToRemove = (distance*1.0) * getFuelCost();
        setFuelAmount(fuelToRemove);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    private void setFuelAmount(double fuelAmount) {
        this.fuelAmount -= fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    private void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled += distanceTraveled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");
        sb.append(getModel()).append(" ").append(df.format(getFuelAmount())).append(" ").append(getDistanceTraveled());
        return sb.toString();
    }
}
