public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void increaseSalary(double percentage){
        if (this.getAge() < 30){
            this.setSalary(this.salary + (this.salary * percentage / 200));
        }else {
            this.setSalary(this.salary + (this.salary * percentage / 100));
        }
    }

    @Override
    public String toString(){
        return String.format("%s %s gets %f leva.", this.getFirstName(), this.getLastName(), this.salary);
    }
}
