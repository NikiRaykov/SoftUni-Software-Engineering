import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while(!commands.equals("Stop")){
            String[] instructions = commands.split(" ");

            switch (instructions[0]){
                case "Delete":
                    int indexToRemove = Integer.parseInt(instructions[1]) + 1;

                    if (indexToRemove >= 0 && indexToRemove < input.size()){
                        input.remove(indexToRemove);
                    }
                    break;

                case "Swap":
                    if (input.contains(instructions[1]) && input.contains(instructions[2])){
                        Collections.swap(input, input.indexOf(instructions[1]), input.indexOf(instructions[2]));
                    }
                    break;

                case "Sort":
                    Collections.sort(input);
                    Collections.reverse(input);
                    break;

                case "Replace ":
                    IntStream.range(0, input.size()).filter(i -> input.get(i).equals(instructions[2]))
                            .forEach(i -> input.set(i, instructions[1]));
                    break;

                case "Put":
                    int indexToPut = Integer.parseInt(instructions[2]) - 1;
                    if (indexToPut >= 0 && indexToPut <= input.size()) {
                        input.add(indexToPut, instructions[1]);
                    }
                    break;
            }

            commands = scanner.nextLine();
        }
        for (String s: input){
            System.out.print(s + " ");
        }
    }
}
