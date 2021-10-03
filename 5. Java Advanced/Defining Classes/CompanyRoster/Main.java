package CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();

        Employee employee = null;
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 6) {
                // has everything
                employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], Integer.parseInt(input[5]));
            } else if (input.length == 5) {
                // we do not have email or age
                try {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], "n/a", age);
                } catch (NumberFormatException e) {
                    employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], -1);
                }
            } else if (input.length == 4) {
                // we do not have email and age
                employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], "n/a", -1);
            }

            employeeList.add(employee);
        }

        List<String> departmentNames = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        List<Department> departments = departmentNames.stream().map(department -> new Department(department,
                employeeList.stream().filter(employee1 -> employee1.getDepartment().equals(department)).collect(Collectors.toList())))
                .sorted(Comparator.comparingDouble(Department::getAverageSalary).reversed()).collect(Collectors.toList());

        Department department = departments.get(0);
        department.getEmployeeFromEmployeeList().sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n", department.getName());

        department.getEmployeeFromEmployeeList().forEach(employee1 ->
                System.out.printf("%s %.2f %s %d%n", employee1.getName(), employee1.getSalary(), employee1.getEmail(), employee1.getAge()));

    }
}
