package Weapons;

public class Weapon {

    private int damage;
    private int price;
    private String type;

    public Weapon(int damage, int price, String type) {
        this.damage = damage;
        this.price = price;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
