package Properties;

public class Property {

    private String name;
    private int income;
    private int health;

    public Property(String name, int income, int health) {
        this.name = name;
        this.income = income;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName())
                .append("generates income: ").append(this.getIncome())
                .append("and has health: ").append(this.getHealth());

        return sb.toString();
    }
}
