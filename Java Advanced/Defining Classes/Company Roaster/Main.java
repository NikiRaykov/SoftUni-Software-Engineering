package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> infoEmployee = new ArrayList<>();

        Map<String, Department> departments = new HashMap<>();

        Employee employee = null;
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];


            if (input.length == 6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }else if (input.length == 5){
                String forthInput = input[4];

                try {
                    int age = Integer.parseInt(forthInput);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e){
                    employee = new Employee(name, salary, position, department, forthInput);
                }
            }else if (input.length == 4){
                employee = new Employee(name, salary, position, department);
            }


            if (!departments.containsKey(department)){
                departments.put(department, new Department(department));
            }
                departments.get(department).getEmployees().add(employee);
        }

        Department maxAverage = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().averageSalary()))
                .get().getValue();

        System.out.println("Highest Average Salary: " + maxAverage.getName());
        maxAverage.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee1 -> System.out.println(employee1.toString()));
    }
}
