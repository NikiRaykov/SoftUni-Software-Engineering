package dto;

import entities.Employee;

import java.util.Set;
import java.util.stream.Collectors;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private Set<EmployeeDto> employeesDto;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<EmployeeDto> getEmployeesDto() {
        return employeesDto;
    }

    public void setEmployeesDto(Set<EmployeeDto> employeesDto) {
        this.employeesDto = employeesDto;
    }

    public void addEmployee(Employee employee){
        this.employeesDto.add(employee);
    }

    @Override
    public String toString() {
        String employees = this.employeesDto.stream()
                .map(EmployeeDto::toString)
                .map(s -> "   - " + s)
                .collect(Collectors.joining("\n"));

        return String.format("%s %s | Employees: %d%n%s%n",
               this.firstName, this.lastName, this.employeesDto.size(), employees);
    }
}
