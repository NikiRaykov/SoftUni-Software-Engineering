import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> scores = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split("\\s+");

            for (String grade : grades) {
                if (!scores.containsKey(name)) {
                    scores.put(name, new LinkedList<>());
                }
                scores.get(name).add(Double.parseDouble(grade));
            }
        }
        scores.forEach((k, v) -> System.out.printf("%s is graduated with %s%n", k, getAverage(v)));
    }
    private static Double getAverage(List<Double> value) {
        double average = 0.0;
        for (Double aDouble : value) {
            average += aDouble;
        }
        return average / value.size();
    }
}

