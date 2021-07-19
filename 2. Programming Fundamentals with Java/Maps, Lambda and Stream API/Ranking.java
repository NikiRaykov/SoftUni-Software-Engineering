import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String contests = scanner.nextLine();
        Map<String, String> contestsData = new LinkedHashMap<>();

        while (!contests.equals("end of contests")){
            String contest = contests.split(":")[0];
            String password = contests.split(":")[1];

            contestsData.putIfAbsent(contest, password);

            contests = scanner.nextLine();
        }

        String submissions = scanner.nextLine();

        Map<String, Map<String, Integer>> submission = new TreeMap<>();

        while (!submissions.equals("end of submissions")){
            String contestSubmitted = submissions.split("=>")[0];
            String pass = submissions.split("=>")[1];
            String username = submissions.split("=>")[2];
            int points = Integer.parseInt(submissions.split("=>")[3]);

           if (contestsData.containsKey(contestSubmitted) && contestsData.get(contestSubmitted).equals(pass)) {
               submission.putIfAbsent(username, new LinkedHashMap<>());
               submission.get(username).putIfAbsent(contestSubmitted, 0);
               if (submission.get(username).get(contestSubmitted) < points){
                   submission.get(username).put(contestSubmitted, points);
               }
           }

            submissions = scanner.nextLine();
        }
        String bestCandidate = "";
        int bestPoints = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : submission.entrySet()) {
            int currentSum = 0;
            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                currentSum += integerEntry.getValue();
            }
            if (currentSum > bestPoints) {
                bestPoints = currentSum;
                bestCandidate = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestPoints);
        System.out.println("Ranking: ");
        submission.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });
    }
}
