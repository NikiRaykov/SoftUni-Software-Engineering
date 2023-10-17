public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    private void setFirstName(String firstName) {
        if (firstName.length()<3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
            this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName.length()<3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
            this.lastName = lastName;
    }

    private void setAge(int age) {
        if (age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setSalary(double salary) {
        if (salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
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
        return String.format("%s %s gets %.2f leva.", this.getFirstName(), this.getLastName(), this.salary);
    }
}