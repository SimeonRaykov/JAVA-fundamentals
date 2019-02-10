package Google;

import java.text.DecimalFormat;

public class Company {

    private String name;
    private String department;
    private Double salary;

    public Company(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");
        sb.append(getName()).append(" ")
                .append(getDepartment()).append(" ")
                .append(df.format(getSalary()));

        return sb.toString();
    }
}
