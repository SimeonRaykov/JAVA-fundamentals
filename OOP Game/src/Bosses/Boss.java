package Bosses;

public class Boss {

    private String name;
    private int health;
    private int damage;
    private int power;
    private int intellect;
    private int dexterity;
    private int charm;

    private static final String DEFAULT_STATUS = "ALIVE";
    private static final int DEFAULT_DAMAGE = 20;
    private static final int DEFAULT_DEXTERITY = 20;
    private static final int DEFAULT_HEALTH = 2000;
    private static final int DEFAULT_INTELLECT = 20;

    private String status;

    public Boss(int health, int damage, int intellect, int dexterity, int charm) {
        this.health = health;
        this.damage = damage;
        this.intellect = intellect;
        this.dexterity = dexterity;
        this.charm = charm;
        this.status = Boss.DEFAULT_STATUS;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPower() {
        return power;
    }

    public void setPower() {
        this.power = this.damage * 2 + this.intellect
                + this.charm + this.dexterity;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
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
        sb.append("Boss ").append(this.getName()).append(" has")
                .append(this.getHealth()).append(" health")
                .append(" and has stats:").append(System.lineSeparator())
                .append("Damage: ").append(this.getDamage()).append(System.lineSeparator())
                .append("Dex: ").append(this.getDexterity()).append(System.lineSeparator())
                .append("Intellect: ").append(this.getIntellect()).append(System.lineSeparator())
                .append("Charm: ").append(this.getCharm());
        return sb.toString();
    }
}
