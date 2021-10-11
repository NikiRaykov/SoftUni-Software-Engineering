package bakery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()){
            this.employees.add(employee);
        }
    }

        public boolean remove(String name) {
           // employees.removeIf(e -> e.getName().equals(name));
            int indexToRemove = -1;
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                if (employee.getName().equals(name)){
                    indexToRemove = i;
                    break;
                }
            }

        if (indexToRemove != -1){
            employees.remove(indexToRemove);
            return true;
        }
        return false;
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
       StringBuilder out = new StringBuilder("Employees working at Bakery " + name + ":");

        for (Employee employee : employees) {
            out.append(System.lineSeparator());
            out.append(employee.toString());
        }

        return out.toString();
    }
}

