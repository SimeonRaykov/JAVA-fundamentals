package CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = null;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getModel()).append(":").append(System.lineSeparator())
                .append(getEngine().getModel()).append(":").append(System.lineSeparator())
                .append("Power: ").append(getEngine().getPower()).append(System.lineSeparator());
        if (getEngine().getDisplacements() == 0) {
            sb.append("Displacement: n/a").append(System.lineSeparator());
        } else {
            sb.append("Displacement: ").append(getEngine().getDisplacements()).append(System.lineSeparator());
        }
        if (getEngine().getEfficiency() == null) {
            sb.append("Efficiency: n/a").append(System.lineSeparator());
        } else {
            sb.append("Efficiency: ").append(getEngine().getEfficiency()).append(System.lineSeparator());
        }
        if (getWeight() == 0) {
            sb.append("Weight: n/a").append(System.lineSeparator());
        } else {
            sb.append("Weight: ").append(getWeight()).append(System.lineSeparator());
        }

        if (getColor() == null) {
            sb.append("Color: n/a");
        } else {
            sb.append("Color: ").append(getColor());
        }

        return sb.toString();
    }
}
