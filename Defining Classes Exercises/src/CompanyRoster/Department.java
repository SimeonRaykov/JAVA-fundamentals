package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double getAverage() {
        double avg = 0.0;
        for (Employee employee : employees) {
            avg += employee.getSalary();
        }
        return avg / employees.size();
    }


}
