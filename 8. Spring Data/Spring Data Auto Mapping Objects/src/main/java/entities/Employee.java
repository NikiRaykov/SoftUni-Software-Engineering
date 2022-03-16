package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private String first_name;
    private String last_name;
    private BigDecimal salary;
    private LocalDate birthday;
    private Address address;
    private boolean isOnHoliday;
    private Employee manager;
    private Set<Employee> employees;

    public Employee(String first_name, String last_name,
                    BigDecimal salary, LocalDate birthday, Address address, boolean isOnHoliday) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
        this.isOnHoliday = isOnHoliday;

        this.employees = new HashSet<>();
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isOnHoliday() {
        return isOnHoliday;
    }

    public void setOnHoliday(boolean onHoliday) {
        isOnHoliday = onHoliday;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return String.format("- %s %s %.2f", this.first_name,
                this.last_name, this.salary);
    }
}
