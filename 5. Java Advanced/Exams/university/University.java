package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;
    private int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount(){
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.capacity > this.students.size()){
            this.students.add(student);
            return "Added student " + student.getFirstName() + " " + student.getLastName();
        }else if (this.capacity < this.students.size()){
            return "No seats in the university";
        }
        return "Student is already in the university";
    }

    public String dismissStudent(Student student) {
        for (Student s: students) {
            if (s.equals(student)){
                this.students.remove(student);
                return "Removed student " + s.getFirstName() + " " + s.getLastName();
            }
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName){
        return this.students.stream().filter(e->e.getFirstName().equals(firstName)&&e.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        for (Student student : students) {
            out.append(System.lineSeparator());
            out.append("==Student: First Name = " + student.getFirstName() + "," +
                    " Last Name = " + student.getLastName() + "," + " Best Subject = " + student.getBestSubject());
        }
        return out.toString().trim();
    }
}
