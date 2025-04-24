package Train_Reservation_System.src;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class  Reservationsystem
{
    private ArrayList<Train> availableseats = new ArrayList<>();
   // private HashMap<Integer,BookingSeats> bookedseats = new HashMap<>();
    Train_Sql out=new Train_Sql();
    Date time_date=new Date();
    public Reservationsystem()
    {
        availableseats.add(new Train("Mumbai — Delhi Superfast","13:05",50,101099));
        availableseats.add(new Train("Delhi — Jaipur SuperFast","7:00",9,201363));
        availableseats.add(new Train("Chennai — Madurai Express","10:00",50,304589));
    }

    public void displayseats()
    {
        for(Train train : availableseats)
        {
            System.out.println(train.name + " " +"Scheduled to Depart:"+ train.time+" "+"Available Seats:"+train.passengerStrength+" " +"Train number:"+train.trainNumber);
        }
    }
    public int checkseat(int trainNumber)
    {
        for(Train train : availableseats)
        {
            if(train.trainNumber==trainNumber)
            {
                int avail=out.checkseat(trainNumber);
                int availableseat = train.passengerStrength-avail;
                System.out.println("availableseat:"+availableseat + " " + "trainNumber:"+trainNumber);
                return availableseat;
            }
        }
        System.out.println("enter correct train number ");
        return 0;
    }
    public void bookseat(int trainNumber , String passenger,int age,String birth)
    {
        for(Train train : availableseats)
        {
            if(train.trainNumber==trainNumber)
            {
                if(train.passengerStrength>out.checkseat(trainNumber))
                {
                        int r = out.sql_method(passenger, age, birth, String.valueOf(time_date), trainNumber);
                        System.out.println("successfully booked :" + "your_id : " + r + " " + passenger + " " + age + " " + birth + " " + time_date);
                        displayTicket(r,trainNumber);
                }
                else
                {
                      System.out.println("No Seats Available You are Passed On to Waiting List");
                      out.waiting_list_set(trainNumber,passenger,age,birth,String.valueOf(time_date));
                }
                return;
            }
        }
        System.out.println("enter correct train number");
    }
    public void cancel(Scanner input,int trainNumber) {
        if(out.checkseat(trainNumber)!=0) {
            System.out.println("Enter the id to cancel the ticket:");
            int id = input.nextInt();
            out.cancel_ticket(id, trainNumber);
        }
        else{
            out.rac_list(trainNumber);
        }
    }
    public void displayTicket(int id,int trainNumber)
    {
            out.displayTicket(id,trainNumber);
            System.out.println("booked tickets");
    }
}
