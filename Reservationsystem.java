import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class  Reservationsystem
{
    private ArrayList<Train> availableseats = new ArrayList<>();
    private HashMap<Integer,BookingSeats> bookedseats = new HashMap<>();
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
                return;
            }
        }
        System.out.println("enter correct train number ");
    }
    public void bookseat(int trainNumber , String passenger,int age,String birth)
    {
        for(Train train : availableseats)
        {
            if(train.trainNumber==trainNumber)
            {
                if(train.passengerStrength>bookedseats.size())
                {
                    int count= bookedseats.size()+1;
                    BookingSeats person=new BookingSeats();
                    bookedseats.put(count,person.toBookSeats(trainNumber,passenger,age,birth));
                    System.out.println("successfully booked :"+"your_id :"+count+" "+passenger+" "+age+" "+birth+" "+time_date);
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
    public void cancel(int id)
    {
        if(bookedseats.containsKey(id))
        {
            bookedseats.remove(id);
            System.out.println("ticket cancelled");
        }
        else
        {
            System.out.println(" invalid user ");
        }
    }
    public void displayTicket(int id)
    {
        if(bookedseats.containsKey(id)) {
            System.out.println("booked tickets");
            System.out.println(bookedseats.get(id) + " ");
        }
        else
            System.out.println("Sorry No ticket available with this id ,you might have cancelled it");
    }
}
