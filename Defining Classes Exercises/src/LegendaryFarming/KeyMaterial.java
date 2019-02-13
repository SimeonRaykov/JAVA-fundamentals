package LegendaryFarming;

public class KeyMaterial {

    private String name;
    private int quantity;

    public KeyMaterial(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeLegendQuantity() {
        this.quantity -= 250;
    }

    public boolean checkIfItsLegendary() {
        return this.quantity >= 250;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName().toLowerCase()).append(": ").append(this.getQuantity());
        return sb.toString();
    }
}
