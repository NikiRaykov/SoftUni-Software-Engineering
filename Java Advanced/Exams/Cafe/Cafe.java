import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.capacity > this.employees.size()){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        Employee employee = null;
        for (Employee e: employees) {
            if (employee == null || employee.getAge() < e.getAge()){
                employee = e;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder("Employees working at Cafe " + name + ":");
        for (Employee employee : employees) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(employee);
        }

        return stringBuilder.toString();
    }
}
