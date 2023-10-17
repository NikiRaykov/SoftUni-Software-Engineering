import java.util.Scanner;
//Calculate how many courses will be needed to elevate n persons by using an elevator with capacity of p persons.
//The input holds two lines: the number of people n and the capacity p of the elevator.


public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacityOfTheElevator = Integer.parseInt(scanner.nextLine());
        int courses;

        courses = (int) Math.ceil((double) numberOfPeople / capacityOfTheElevator);
        System.out.println(courses);
    }
}
