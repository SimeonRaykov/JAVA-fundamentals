package Transport;

public class Plane extends Transport {

    private String name;
    private int capacity;

    public Plane(int price, String name, int capacity) throws IllegalAccessException {
        super(price);
        if(capacity < 1){
            throw new IllegalAccessException("Invalid plane capacity can't be lower than 1.");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" costs - ").append(this.getPrice())
                .append("The plane has a maxspeed of ").append(this.getSpeed()).append(" km/h.")
                .append(System.lineSeparator()).append("Maximum plane capacity is ").append(this.getCapacity());

        return sb.toString();
    }
}
