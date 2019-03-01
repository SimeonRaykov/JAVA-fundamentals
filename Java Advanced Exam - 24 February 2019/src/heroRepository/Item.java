package heroRepository;

public class Item {

    private int strength;
    private int agility;
    private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("* Strength: ").append(this.getStrength()).append(System.lineSeparator())
                .append("* Agility: ").append(this.getAgility()).append(System.lineSeparator())
                .append("* Intelligence: ").append(this.getIntelligence()).append(System.lineSeparator());
        return sb.toString();
    }
}
