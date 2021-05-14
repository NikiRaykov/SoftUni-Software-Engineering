import java.util.*;

public class Gymnastics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String gymnasticEquipment = scanner.nextLine();

        double evaluation = 0.0;

        switch (country){
            case "Bulgaria":
                if (gymnasticEquipment.equals("ribbon")){
                    evaluation = 9.600 + 9.400;
                }else if (gymnasticEquipment.equals("hoop")){
                    evaluation = 9.550+9.750;
                }else if (gymnasticEquipment.equals("rope")){
                    evaluation = 9.500+9.400;
                }
                break;
            case "Italy":
                if (gymnasticEquipment.equals("ribbon")){
                    evaluation = 9.200 + 9.500;
                }else if (gymnasticEquipment.equals("hoop")){
                    evaluation = 9.450 + 9.350;
                }else if (gymnasticEquipment.equals("rope")){
                    evaluation = 9.700 + 9.150;
                }
                break;
            case "Russia":
                if (gymnasticEquipment.equals("ribbon")){
                    evaluation = 9.100 + 9.400;
                }else if (gymnasticEquipment.equals("hoop")){
                    evaluation = 9.300 + 9.800;
                }else if (gymnasticEquipment.equals("rope")){
                    evaluation = 9.600 + 9.000;
                }
                break;
        }
        int maxPoints = 20;
        double pointsNeeded = maxPoints - evaluation;
        double percent = (pointsNeeded / maxPoints) * 100;

        System.out.printf("The team of %s get %.3f on %s.%n", country, evaluation, gymnasticEquipment);
        System.out.printf("%.2f%%", percent);
    }
}

