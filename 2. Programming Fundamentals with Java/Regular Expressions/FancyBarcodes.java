import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> barcodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            barcodes.add(input);
        }

        String regex = "^@[#]+([A-Z][A-Za-z\\d]{4,}[A-Z])@[#]+$";
        Pattern patternForValidBarcode = Pattern.compile(regex);

        String regexForGroups = "\\d";
        Pattern patternForGroups = Pattern.compile(regexForGroups);

        for (String barcode: barcodes) {
            Matcher matcherForValidBarcode = patternForValidBarcode.matcher(barcode); boolean isValid = false;

            while (matcherForValidBarcode.find()){
                isValid = true;

                Matcher matcherForGroups = patternForGroups.matcher(barcode);
                StringBuilder group = new StringBuilder(); boolean validGroup = false;

                while (matcherForGroups.find()){
                    validGroup = true;
                    group.append(matcherForGroups.group());
                }

                if (validGroup){
                    System.out.println("Product group: " + group);
                }else {
                    System.out.println("Product group: 00");
                }
            }

            if (!isValid) {
                System.out.println("Invalid barcode");
            }
        }
        }
}


