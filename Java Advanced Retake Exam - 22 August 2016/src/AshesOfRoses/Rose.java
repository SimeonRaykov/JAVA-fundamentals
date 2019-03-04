package AshesOfRoses;

public class Rose {

    private String name;
    private int count;

    public Rose(String name, int count) {
        if (name.matches("[A-Za-z0-9]+")) {
            if (count == (int) count) {
                this.name = name;
                this.count = count;
            } else {
                throw new IllegalArgumentException("Invalid count");
            }
        } else {
            throw new IllegalArgumentException("Invalid color");
        }

    }

    public void increaseRosesCount(int increaseCount) {
        this.count += increaseCount;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*--").append(this.getName()).append(" | ")
                .append(this.getCount());
        return sb.toString();
    }
}
