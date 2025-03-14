
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Reservationsystem reservationsystem = new Reservationsystem();

        while(true)
        {
            int choice= input.nextInt();
            input.nextLine();
            if (choice==1)
            {
                reservationsystem.displayseats();

            } else if (choice==2) {
                int trainNumber = input.nextInt();
                reservationsystem.checkseat(trainNumber);
            } else if (choice==3) {
                int trainNumber = input.nextInt();
                input.nextLine();
                String passenger = input.nextLine();
                reservationsystem.bookseat(trainNumber,passenger);

            } else if (choice==4) {
                String passenger = input.nextLine();
                reservationsystem.cancel(passenger);

            }
            else if(choice==5)
            {
                reservationsystem.displayTicket();

            }
        }

    }
}
