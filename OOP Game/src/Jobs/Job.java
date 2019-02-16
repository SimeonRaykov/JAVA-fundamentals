package Jobs;

public class Job {
    private String name;
    private int salary;
    private int hoursWeekly;

    public Job(String name, int salary, int hoursWeekly) {
        this.name = name;
        this.salary = salary;
        this.hoursWeekly = hoursWeekly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getHoursWeekly() {
        return hoursWeekly;
    }

    public void setHoursWeekly(int hoursWeekly) {
        this.hoursWeekly = hoursWeekly;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
}
