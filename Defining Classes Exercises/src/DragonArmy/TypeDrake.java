package DragonArmy;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;

public class TypeDrake {

    private String name;
    private HashSet<Dragon> dragons;

    public TypeDrake(String name) {
        this.name = name;
        this.dragons = new HashSet<Dragon>();
    }

    public void addDrake(Dragon dragon) {

        dragons.removeIf(dragon1 -> dragon1.getName().equals(dragon.getName()));

        this.dragons.add(dragon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Dragon> getDragons() {
        return dragons;
    }

    public void setDragons(HashSet<Dragon> dragons) {
        this.dragons = dragons;
    }

    public double getAvgHealth() {

        double healthSum = 0;
        for (Dragon dragon : dragons) {
            healthSum += dragon.getHealth();
        }
        return healthSum / dragons.size();
    }

    public double getAvgDamage() {

        double damageSum = 0;
        for (Dragon dragon : dragons) {
            damageSum += dragon.getDamage();
        }
        return damageSum / dragons.size();

    }

    public double getAvgArmor() {

        double armorSum = 0;
        for (Dragon dragon : dragons) {
            armorSum += dragon.getArmor();
        }
        return armorSum / dragons.size();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");
        sb.append(this.getName()).append("::(").append(df.format(this.getAvgDamage()))
                .append("/").append(df.format(this.getAvgHealth())).append("/")
                .append(df.format(this.getAvgArmor())).append(")");
        return sb.toString();
    }
}
