import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPairs = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPairs; i++) {
            String studentName = scanner.nextLine();
            double studentGrade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(studentGrade);
        }
        students.entrySet().stream().filter(e -> getAverage(e.getValue()) >= 4.50)
                .sorted((a, b) -> Double.compare(getAverage(b.getValue()), getAverage(a.getValue())))
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), getAverage(e.getValue())));
    }
    static double getAverage (List<Double> list){
        return list.stream().mapToDouble(Double::doubleValue).average().orElseThrow();
    }
}
