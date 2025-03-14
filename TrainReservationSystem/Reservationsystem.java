import java.util.ArrayList;
import java.util.Date;
public class  Reservationsystem
{
    private ArrayList<Train> availableseats = new ArrayList<>();
    private ArrayList<String> bookedseats = new ArrayList<>();
    Date time_date=new Date();
    public Reservationsystem()
    {
        availableseats.add(new Train("Mumbai — Delhi Superfast","13:05",50,101099));
        availableseats.add(new Train("Delhi — Jaipur SuperFast","7:00",50,201363));
        availableseats.add(new Train("Prayagraj — Delhi Express","10:00",50,304589));
    }

    public void displayseats()
    {
        for(Train train : availableseats)
        {
            System.out.println(train.name + " " +"Scheduled to Depart:"+ train.time+" "+"Available Seats:"+train.passengerStrength+" " +"Train number:"+train.trainNumber);
        }
    }
    public void checkseat(int trainNumber)
    {
        for(Train train : availableseats)
        {
            if(train.trainNumber==trainNumber)
            {
                int availableseat = train.passengerStrength-bookedseats.size();
                System.out.println("availableseat:"+availableseat + " " + "trainNumber:"+trainNumber);
            }
            return;
        }
        System.out.println("enter correct train number ");
    }
    public void bookseat(int trainNumber , String passenger)
    {
        for(Train train : availableseats)
        {
            if(train.trainNumber==trainNumber)
            {
                if(train.passengerStrength>bookedseats.size())
                {
                    bookedseats.add(passenger);
                    System.out.println("successfully booked :"+passenger+" "+time_date);
                }
                else
                {
                    System.out.println("no seats available");
                }
                return;
            }
        }
        System.out.println("enter correct train number");
    }
    public void cancel(String passenger)
    {
        if(bookedseats.remove(passenger))
        {
            System.out.println("ticket cancelled");
        }
        else
        {
            System.out.println(" invalid user ");
        }
    }
    public void displayTicket()
    {
        System.out.println("booked tickets");
        for (String passenger : bookedseats)
        {
            System.out.println(passenger+" "+time_date);
        }

    }
}
