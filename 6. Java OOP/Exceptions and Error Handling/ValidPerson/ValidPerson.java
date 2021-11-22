import custom.exceptions.InvalidAge;
import custom.exceptions.InvalidNameException;

public class ValidPerson {
    private String firstName;
    private String lastName;
    private int age;

    public ValidPerson (String firstName, String lastName, int age) throws InvalidNameException, InvalidAge {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    private void setAge(int age) throws InvalidAge {
        if (age < 0) {
            throw new InvalidAge("Age must be a positive number!");
        }

        this.age = age;
    }

    private void setLastName(String lastName) throws InvalidNameException {
        if (lastName.isEmpty()) {
            throw new InvalidNameException("Name cannot be empty!");
        }else if (lastName.length() <= 1) {
            throw new InvalidNameException("Name should be longer!");
        }

        this.lastName = lastName;
    }

    private void setFirstName(String firstName) throws InvalidNameException {
       if (firstName.isEmpty()) {
           throw new InvalidNameException("Name cannot be empty!");
       }else if (firstName.length() <= 1) {
           throw new InvalidNameException("Name should be longer!");
       }

       this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("Hello, my first name is %s, my last name is %s" +
                " and I am %d years old.", this.firstName, this.lastName, this.age);
    }
}
