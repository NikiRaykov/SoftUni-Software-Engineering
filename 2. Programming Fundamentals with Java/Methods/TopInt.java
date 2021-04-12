import java.util.Scanner;

public class TopInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        topInteger(n);
        }

        public static void topInteger(int n){
            for (int i = 1; i <= n; i++) {
                int sum;
                sum = (i % 10) + (i / 10);

                if (sum % 8 == 0){
                    if (i % 2 != 0){
                        System.out.println(i);
                    }
                }
            }
        }
    }

