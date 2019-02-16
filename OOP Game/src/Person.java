import Apartments.Accommodation;
import Boosters.Booster;
import Properties.Property;
import Transport.Transport;
import Weapons.Weapon;

import java.util.List;

public class Person {

    private String name;
    private String job;
    private long money;

    //Stats
    private int power;
    private int health;
    private int damage;
    private int intellect;
    private int dexterity;
    private int charm;

    //DefaultStats
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_DAMAGE = 10;
    private static final int DEFAULT_INTELLECT = 10;
    private static final int DEFAULT_DEXTERITY = 10;
    private static final int DEFAULT_CHARM = 10;

    //Acquirements
    private List<Booster> boosters;
    private List<Accommodation> accommodations;
    private List<Property> properties;
    private List<Transport> vehicles;
    private List<Weapon> weapons;

    Weapon hands = new Weapon(20, 0, "low");

    public Person(String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
        this.health = DEFAULT_HEALTH;
        this.damage = DEFAULT_DAMAGE;
        this.intellect = DEFAULT_INTELLECT;
        this.dexterity = DEFAULT_DEXTERITY;
        this.charm = DEFAULT_CHARM;
        this.power = this.damage * 2 + this.charm + this.dexterity + this.intellect;
        this.weapons = null;
    }

    public void incrementAllStats() {
        if (this.money < 500) {
            System.out.println("Not enough money to train all stats.");
        } else {
            incrementCharm();
            incrementDamage();
            incrementDexterity();
            incrementIntellect();
        }

    }

    public void incrementDamage() {
        if (this.money < 100) {
            System.out.println("Not enough money to train Damage.");
        } else {
            this.money -= 100;
            this.damage += 1;
        }
    }

    public void incrementCharm() {
        if (this.money < 100) {
            System.out.println("Not enough money to train Charm.");
        } else {
            this.money -= 100;
            this.charm += 1;
        }
    }

    public void incrementIntellect() {
        if (this.money < 100) {
            System.out.println("Not enough money to train Intellect.");
        } else {
            this.money -= 100;
            this.charm += 1;
        }
    }

    public void incrementDexterity() {
        if (this.money < 100) {
            System.out.println("Not enough money to train Dexterity.");
        } else {
            this.money -= 100;
            this.dexterity += 1;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getPower() {
        return power;
    }

    public void setPower() {
        this.power = this.damage * 2 + this.intellect + this.dexterity + this.charm;
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

    public List<Booster> getBoosters() {
        return boosters;
    }

    public void setBoosters(List<Booster> boosters) {
        this.boosters = boosters;
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Transport> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Transport> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" has ").append(this.getMoney()).append(System.lineSeparator())
                .append("Stats: Health - ").append(this.getHealth()).append(" Damage - ").append(this.getDamage()).append(System.lineSeparator())
                .append("Dex - ").append(this.getDexterity()).append("Intellect - ").append(this.getIntellect());
        return sb.toString();
    }
}
