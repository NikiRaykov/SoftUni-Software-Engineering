import java.util.Scanner;
//Spice is Love, Spice is Life. And most importantly, Spice must flow. It must be extracted from the scorching sands of Arrakis, 
// under constant threat of giant sand worms. To make the work as efficient as possible, the Duke has tasked you with the creation of a 
// management software. 
//Write a program that calculates the total amount of spice that can be extracted from a source. 
//The source has a starting yield, which indicates how much spice can be mined on the first day. After it has been mined for a day, 
// the yield drops by 10, meaning on the second day it’ll produce 10 less spice than on the first, on the third day 10 less than on the second, 
// and so on (see examples). 
//A source is considered profitable only 
// while its yield is at least 100 – when less than 100 spice is expected in a day, abandon the source. 
//The mining crew consumes 26 spice every day at the end of their shift and an additional 26 after the mine has been exhausted. 
// Note that the workers cannot consume more spice than there is in storage. 
//When the operation is complete, print on the console on two separate lines how many days 
// the mine has operated and the total amount of spice extracted.


public class SpiceMustFlow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startingYield= Integer.parseInt(scanner.nextLine());
        int days = 0; int total; int spiceExtracted = 0;

        while (startingYield >= 100){
            days ++;
            if (days != 0){
                total = startingYield;
                total -= 26;
                spiceExtracted += total;
                startingYield -= 10;
            }

        }
        System.out.println(days);
        if (spiceExtracted >= 26){
            System.out.println(spiceExtracted - 26);
        }else {
            System.out.println(spiceExtracted);
        }
    }
}
