import java.util.*;

public class AverageStudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> studentData = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] studentNameAndGrade = scanner.nextLine().split("\\s+");

            String studentName = studentNameAndGrade[0];
            double studentGrade = Double.parseDouble(studentNameAndGrade[1]);

            if (!studentData.containsKey(studentName)){
                studentData.put(studentName, new ArrayList<>());
                studentData.get(studentName).add(studentGrade);
            }else {
                studentData.get(studentName).add(studentGrade);
            }
        }
        studentData.forEach((key, value) -> {
            System.out.printf("%s -> ", key);
            value.forEach(v -> System.out.printf("%.2f ", v));
            System.out.printf("(avg: %.2f)%n", getAverage(value));
        });
    }
    private static Double getAverage(List<Double> value) {
        double average = 0.0;
        for (Double aDouble : value) {
            average += aDouble;
        }
        return average / value.size();

    }
}
