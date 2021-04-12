public class Clock2 {
    public static void main(String[] args) {

        for (int hours = 0; hours <= 23; hours++) {
            for (int minutes = 0; minutes <= 59 ; minutes++) {
                for (int seconds = 0; seconds <=59 ; seconds++) {
                    System.out.printf("%d : %d : %d%n", hours, minutes, seconds);
                }
            }
        }
    }
}
