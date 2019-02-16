package Boosters;

public class Booster {

    private String name;
    private String type;
    private int powerUp;

    public Booster(String name, String type, int powerUp) {
        this.name = name;
        this.type = type;
        this.powerUp = powerUp;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(int powerUp) {
        this.powerUp = powerUp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" ")
                .append("increases ").append(this.getType())
                .append(" with ").append(getPowerUp()).append(" units");

        return sb.toString();
    }
}
