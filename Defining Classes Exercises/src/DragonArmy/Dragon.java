package DragonArmy;

public class Dragon {

    private String name;
    private int health;
    private int damage;
    private int armor;

    public static final int DEFAULT_HEALTH = 250;
    public static final int DEFAULT_DAMAGE = 45;
    public static final int DEFAULT_ARMOR = 10;

    public Dragon(String name, int damage, int health, int armor) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-").append(this.getName()).append(" -> ")
                .append("damage: ").append(this.getDamage())
                .append(", health: ").append(this.getHealth())
                .append(", armor: ").append(this.getArmor());

        return sb.toString();
    }
}
