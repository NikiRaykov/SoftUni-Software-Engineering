import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> information = new TreeMap<>();

        while (!input.equals("end")){
            String[] info = input.split("\\s+");
            String[] ipSplit = info[0].split("=");
            String[] messageSplit = info[1].split("=");
            String[] userSplit = info[2].split("=");

            String ipAddress = ipSplit[1];
            String message = messageSplit[1];
            String username = userSplit[1];

            information.putIfAbsent(username, new LinkedHashMap<>());
            information.get(username).put(ipAddress, !information.get(username).containsKey(ipAddress)
                    ? 1 : information.get(username).get(ipAddress) + 1);

            input = scanner.nextLine();
        }
        information.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            int count = 1;
            for (Map.Entry<String, Integer> innerMap : value.entrySet()) {
                String output = String.format(count < value.entrySet().size()
                        ? "%s => %d, " : "%s => %d.%n", innerMap.getKey(), innerMap.getValue());
                System.out.printf("%s", output);
                count++;
            }
        });
    }
}
