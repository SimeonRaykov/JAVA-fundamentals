package LogsAggregator;

public class IPaddress {

    private String address;
    private int time;

    public IPaddress(String address, int time) {
        this.address = address;
        this.time = time;
    }

    public void incrementTime(int time) {
        this.time += time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
