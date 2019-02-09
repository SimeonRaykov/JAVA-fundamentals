package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(bf.readLine());
        HashMap<String, Department> departments = new HashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            if (tokens.length == 4) {
                Employee employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3]);
                checkDepartment(departments, tokens[3], employee);

            } else if (tokens.length == 5) {
                try {
                    Employee employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], Integer.parseInt(tokens[4]));
                    checkDepartment(departments, tokens[3], employee);
                } catch (Exception e) {
                    Employee employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4]);
                    checkDepartment(departments, tokens[3], employee);
                }

            } else {
                Employee employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]));
                checkDepartment(departments, tokens[3], employee);
            }
        }

        List<Department> departmentsSorted = departments.values().stream().sorted(Comparator.comparingDouble(Department::getAverage).reversed()).collect(Collectors.toList());
         Department bestDepartment = departmentsSorted.get(0);

        System.out.println("Highest Average Salary: " + bestDepartment.getName());

        List<Employee> orderedPeople = bestDepartment.getEmployees().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
        for (Employee orderedPerson : orderedPeople) {
            System.out.println(orderedPerson.toString());
        }
    }

    public static void checkDepartment(HashMap<String, Department> departments, String token, Employee employee) {
        if(!departments.containsKey(token)){
            departments.put(token,new Department(token));
        }
        departments.get(token).addEmployee(employee);
    }
}
