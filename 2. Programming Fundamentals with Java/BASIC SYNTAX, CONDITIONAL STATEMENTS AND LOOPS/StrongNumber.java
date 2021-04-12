import java.util.Scanner;

public class StrongNumber {
    private static Scanner sc;
    public static void main(String[] args)
    {
        int Number, Temp, Reminder, Sum = 0, i, Factorial;
        sc = new Scanner(System.in);

        Number = sc.nextInt();

        Temp = Number;
        while( Temp > 0)
        {
            Factorial = 1;
            i = 1;
            Reminder = Temp % 10;
            while (i <= Reminder)
            {
                Factorial = Factorial * i;
                i++;
            }
           // System.out.println(" The Factorial of " + Reminder + "  =  " + Factorial);
            Sum = Sum + Factorial;
            Temp = Temp /10;
        }

       // System.out.println(" The Sum of the Factorials of a Given Number " + Number + " =  " + Sum);

        if ( Number == Sum )
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
}