import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String contractLength = scanner.nextLine();
        String contractType = scanner.nextLine();
        String addedMobileOperator = scanner.nextLine();
        int monthsToPay = Integer.parseInt(scanner.nextLine());
        double sum = 0;

        switch (contractType){
            case "Small":
                if (contractLength.equals("one")){
                    if (addedMobileOperator.equals("yes")){
                        sum = monthsToPay * (9.98 + 5.50);
                    }else {
                        sum = monthsToPay * 9.98;
                    }

                }else if (contractLength.equals("two")){
                    if (addedMobileOperator.equals("yes")){
                        sum = monthsToPay * (8.58 + 5.50);
                    }else {
                        sum = monthsToPay * 8.58;
                    }
                    sum -= sum * (3.75f/100.0f);
                }

                break;
            case "Middle":
                if (contractLength.equals("one")){
                    if (addedMobileOperator.equals("yes")){
                        sum = monthsToPay * (18.99 + 4.35);
                    }else {
                        sum = monthsToPay * 18.99;
                    }

                }else if (contractLength.equals("two")){
                    if (addedMobileOperator.equals("yes")){
                        sum = monthsToPay * (17.09 + 4.35);
                    }else {
                        sum = monthsToPay * 17.09;
                    }
                    sum -= sum * (3.75f/100.0f);
                }

                break;
            case "Large":
                if (contractLength.equals("one")){
                    if (addedMobileOperator.equals("yes")){
                        sum = monthsToPay * (25.98 + 4.35);
                    }else {
                        sum = monthsToPay * 25.98;
                    }
                }else if (contractLength.equals("two")){
                    if (addedMobileOperator.equals("yes")){
                        sum = monthsToPay * (23.59 + 4.35);
                    }else {
                        sum = monthsToPay * 23.59;
                    }
                    sum -= sum * (3.75f/100.0f);
                }

                break;
            case "ExtraLarge":
                if (contractLength.equals("one")){
                    if (addedMobileOperator.equals("yes")){
                        sum = monthsToPay * (35.99 + 3.85);
                    }else {
                        sum = monthsToPay * 35.99;
                    }

                }else if (contractLength.equals("two")){
                    if (addedMobileOperator.equals("yes")){
                        sum = monthsToPay * (31.79 + 3.85);
                    }else {
                        sum = monthsToPay * 31.79;
                    }
                    sum -= sum * (3.75f/100.0f);
                }

                break;
        }
        System.out.printf("%.2f lv.", sum);
    }
}
