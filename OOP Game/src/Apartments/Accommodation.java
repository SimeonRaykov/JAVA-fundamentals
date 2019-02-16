package Apartments;

public class Accommodation {

    private String name;
    private String location;
    private int rooms;
    private int price;

    public Accommodation(String name, String location, int rooms, int price) throws IllegalAccessException {
        if (price < 1) {
            throw new IllegalAccessException("Price can't be lower than 1.");
        }
        if (rooms < 1) {
            throw new IllegalAccessException("The accommodation must have at least 1 room.");
        }
        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Accommodation ").append(this.getName())
                .append("which is located in ").append(this.getLocation())
                .append(System.lineSeparator()).append("costs ").append(this.getPrice())
                .append(" and has ").append(this.getRooms()).append(" rooms.");

        return sb.toString();
    }
}
