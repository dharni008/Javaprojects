package Train_Reservation_System.src;

import java.util.Scanner;

//import static java.lang.reflect.Array.setInt;

public class Main extends Reservationsystem{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Reservationsystem reservationsystem = new Reservationsystem();
        Train_Sql tr = new Train_Sql();
        reservationsystem.displayseats();
        System.out.println("Enter the train number:");
        int trainNumber = input.nextInt();
        System.out.println("press number 1 to check the availability of seats:");
        int available=0;
        while(true)
        {
            int choice= input.nextInt();
            //input.nextLine();
            //trainNumber = input.nextInt();

             if (choice==1) {
                available=reservationsystem.checkseat(trainNumber);
                System.out.println("press number 2 to book the seats:");
              }
             else if (choice==2) {
                 if (available != 0) {
                     System.out.print("Enter the passenger's name:");
                     String passenger = input.nextLine();
                     System.out.println("Enter the passenger's age:");
                     int age = input.nextInt();
                     input.nextLine();
                     System.out.println("Enter the Seat birth");
                     String birth = input.nextLine();
                     reservationsystem.bookseat(trainNumber, passenger, age, birth);
                 } else if (tr.isRacTableEmpty() || available == 0) {
                     System.out.print("Enter the passenger's name:");
                     String passenger = input.nextLine();
                     System.out.println("Enter the passenger's age:");
                     int age = input.nextInt();
                     input.nextLine();
                     System.out.println("Enter the Seat birth");
                     String birth = input.nextLine();
                     reservationsystem.bookseat(trainNumber, passenger, age, birth);
                 } else {
                     tr.rac_to_train(trainNumber);
                     System.out.println("Your Rac seat got confirmed");
                 }
                 System.out.println("if you want to cancel the ticket press 3:");
             }
            else if (choice==3) {
                reservationsystem.cancel(input,trainNumber);
                System.out.println("press number 5 to get your ticket:");
            }
//            else if(choice==4)
//            {
//                System.out.print("Enter the id:");
//                int id= input.nextInt();
//                reservationsystem.displayTicket(id,trainNumber);
//            }
             else if(choice==4)
             {
                tr.rac_list(trainNumber);
                 System.out.println("Your Waiting List seat got upgraded to RAC");
             }

        }


    }
}
