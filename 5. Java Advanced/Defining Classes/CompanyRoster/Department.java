package CompanyRoster;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeFromEmployeeList;
    private double average;

    List<Employee> getEmployeeFromEmployeeList() {
        return employeeFromEmployeeList;
    }

    public Department(String name, List<Employee> employeeFromEmployeeList){
        this.name = name;
        this.employeeFromEmployeeList = employeeFromEmployeeList;
        this.average = employeeFromEmployeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0.00);
    }

    double getAverageSalary(){
        return average;
    }

    public String getName() {
        return name;
    }
}
