package Transport;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Car extends Transport {

    private String name;
    private String engine;
    private int horsePower;
    private String type;

    public static final Set<String> ALLOWED_ENGINES = new HashSet<>(Arrays.asList("V6", "V12", "V10", "V4", "V16", "V8"));

    public Car(String name, int price, String engine, int horsePower, String type) throws IllegalAccessException {
        super(price);
        if (!Car.ALLOWED_ENGINES.contains(engine.toUpperCase())) {
            throw new IllegalAccessException("Engine " + engine + " is not allowed!");
        }
        this.name = name;
        this.engine = engine;
        this.horsePower = horsePower;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        engine = engine;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car: ").append(this.getName()).append("(").append(this.getType()).append(")")
                .append(System.lineSeparator()).append("has ").append(this.getHorsePower()).append(" horsepowers and a")
                .append(this.getEngine()).append(".").append(System.lineSeparator()).append("It costs: ").append(this.getPrice());

        return sb.toString();
    }
}
