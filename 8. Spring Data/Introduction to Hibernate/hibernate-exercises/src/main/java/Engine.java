import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private Scanner scanner;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Please select exercise number: ");
        int exNumber = Integer.parseInt(scanner.nextLine());

        switch (exNumber) {
            case 2:
                exTwo();
            case 3:
                exThree();
            case 4:
                exFour();
            case 5:
                exFive();
            case 6:
                exSix();
            case 7:
                exSeven();
            case 8:
                exEight();
            case 9:
                exNine();
        }
    }

    private void exNine() {
                entityManager.createQuery("SELECT e FROM Employee e", Employee.class).
                        getResultStream().map(Employee::getProjects).forEach(System.out::println);
    }

    private void exEight() {
        System.out.println("Enter employee id: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        Employee employee = entityManager.find(Employee.class, employeeId);

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects().forEach(project -> System.out.println(project.getName()));
    }

    private void exSeven() {

        List<Address> addresses =
                entityManager.createQuery("SELECT a FROM Address a " +
                                " ORDER BY a.employees.size DESC", Address.class)
                        .setMaxResults(10)
                        .getResultList();

       addresses.forEach(address -> System.out.printf("%s, %s - %d employees%n",
               address.getText(),
               address.getTown() == null ? "Unknown" : address.getTown().getName(),
               address.getEmployees().size()));
    }

    private void exSix() {
        System.out.println("Enter employee last name: ");
        String lastName = scanner.nextLine();

        Employee emp = entityManager.
                createQuery("SELECT e FROM Employee e WHERE e.lastName = :l_name", Employee.class).
                setParameter("l_name", lastName).getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        emp.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText("Vitoshka 15");

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void exFive() {
        entityManager.createQuery("SELECT e FROM Employee e " +
                        " WHERE e.department.name = :d_name " +
                        " ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d_name", "Research and Development").
                getResultStream().forEach(emp -> System.out.printf("%s %s from %s - $%.2f%n",
                        emp.getFirstName(), emp.getLastName(), emp.getDepartment().getName(),
                        emp.getSalary()));
    }

    private void exFour() {
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.salary > 50000", Employee.class).
                getResultStream().map(Employee::getFirstName).forEach(System.out::println);

    }

    private void exThree() {
        System.out.print("Enter a name of the employee: ");
        String[] employeeName = scanner.nextLine().split("\\s+");
        String firstName = employeeName[0];
        String lastName = employeeName[1];

        Long result = entityManager.
                createQuery("SELECT count(e) FROM Employee e " +
                        "WHERE e.firstName = :f_name AND e.lastName = :l_name", Long.class).
                setParameter("f_name", firstName).
                setParameter("l_name", lastName).
                getSingleResult();

       // entityManager.getTransaction().begin();

        System.out.println(result == 0 ? "No" : "Yes");
    }

    private void exTwo() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("UPDATE Town t SET t.name = lower(t.name) " +
                "WHERE length(t.name) >= 5");

        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();
    }
}
