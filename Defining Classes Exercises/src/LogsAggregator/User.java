package LogsAggregator;

import java.util.ArrayList;
import java.util.Comparator;

public class User {

    private String name;
    private ArrayList<IPaddress> ipAddressList;

    public User(String name) {
        this.name = name;
        this.ipAddressList = new ArrayList<>();
    }

    public void sortCollection(){
        this.ipAddressList.sort(Comparator.comparing(IPaddress::getAddress));
    }

    public void addAddress(IPaddress address) {
        this.ipAddressList.add(address);
    }

    public boolean contains(String iPaddress) {

        for (IPaddress iPaddressX : ipAddressList) {
            if (iPaddressX.getAddress().equals(iPaddress)) {
                return true;
            }
        }
        return false;
    }

    public void incrementTime(String ip, int time) {
        for (IPaddress iPaddress : ipAddressList) {
            if (iPaddress.getAddress().equals(ip)) {
                iPaddress.incrementTime(time);
            }
        }
    }

    public int getSumOfAllTime() {

        int sum = 0;
        for (IPaddress iPaddress : ipAddressList) {
            sum += iPaddress.getTime();
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IPaddress> getIpAddressList() {
        return ipAddressList;
    }

    public void setIpAddressList(ArrayList<IPaddress> ipAddressList) {
        this.ipAddressList = ipAddressList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(": ").append(this.getSumOfAllTime())
                .append(" [");

        int count = 0;
        for (IPaddress iPaddress : ipAddressList) {
            if (count == ipAddressList.size() - 1) {
                sb.append(iPaddress.getAddress());
            } else {
                sb.append(iPaddress.getAddress()).append(", ");
            }
            count += 1;
        }
        sb.append("]");
        return sb.toString();

    }
}
