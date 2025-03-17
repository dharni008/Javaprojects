
import java.util.Scanner;

public class Main{
    static {
        System.out.print("Enter number 1 to check the availability of trains:");
    }
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
                System.out.print("Enter the passenger's name:");
                String passenger = input.nextLine();
                System.out.println("Enter the passenger's age:");
                int age=input.nextInt();
                input.nextLine();
                System.out.println("Enter the birth");
                String birth=input.nextLine();
                reservationsystem.bookseat(trainNumber,passenger,age,birth);
                System.out.println("if you want to cancel the ticket press 4 or directly recieve your tickets by pressing 5:");
            } else if (choice==4) {
                System.out.println("Enter the id to cancel the ticket:");
                int id = input.nextInt();
                reservationsystem.cancel(id);
                System.out.println("press number 5 to get your ticket:");
            }
            else if(choice==5)
            {
                System.out.println("enter your id:");
                int id=input.nextInt();
                reservationsystem.displayTicket(id);

            }
           // System.out.print("Enter number 1 to check the availability of trains:");
        }

    }
}
