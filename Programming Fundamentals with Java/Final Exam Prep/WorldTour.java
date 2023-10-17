import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder initialStops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Travel")){
            String[] tokens = input.split(":");

            switch (tokens[0]){
                case "Add Stop":
                    int indexToAddAt = Integer.parseInt(tokens[1]);
                    String stopToAdd = tokens[2];

                    if (indexToAddAt >= 0 && indexToAddAt < initialStops.length()){
                        initialStops.insert(indexToAddAt, stopToAdd);
                    }
                    System.out.println(initialStops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && startIndex < initialStops.length()
                            && endIndex >= 0 && endIndex < initialStops.length()){
                        initialStops.replace(startIndex, endIndex + 1, "");
                    }
                    System.out.println(initialStops);
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    if (initialStops.toString().contains(oldString)){
                        int index = initialStops.indexOf(oldString);
                        while (index != -1) {
                            initialStops.replace(index, index + oldString.length(), newString);
                            index += newString.length();
                            index = initialStops.indexOf(oldString, index);
                        }
                    }
                    System.out.println(initialStops);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + initialStops);
    }
}
