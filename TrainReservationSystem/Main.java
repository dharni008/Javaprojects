
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Reservationsystem reservationsystem = new Reservationsystem();
        System.out.println("Enter number 1 to check the availability of trains:");
        while(true)
        {
            int choice= input.nextInt();
            input.nextLine();
            if (choice==1)
            {
                reservationsystem.displayseats();
                System.out.println("press number 2 to check the availability of seats:");

            } else if (choice==2) {
                System.out.println("Enter the train number to check the availability of seats:");
                int trainNumber = input.nextInt();
                reservationsystem.checkseat(trainNumber);
                System.out.println("press number 3 to book the seats:");
            } else if (choice==3) {
                System.out.println("Enter the train number:");
                int trainNumber = input.nextInt();
                input.nextLine();
                System.out.println("Enter the passenger name:");
                String passenger = input.nextLine();
                reservationsystem.bookseat(trainNumber,passenger);
                System.out.println("if you want to cancel the ticket press 4 or directly recieve yor tickets by pressing 5:");
            } else if (choice==4) {
                System.out.println("Enter the passenger name to cancel the ticket:");
                String passenger = input.nextLine();
                reservationsystem.cancel(passenger);
                System.out.println("press number 5 to get your ticket:");
            }
            else if(choice==5)
            {
                reservationsystem.displayTicket();

            }
        }

    }
}
