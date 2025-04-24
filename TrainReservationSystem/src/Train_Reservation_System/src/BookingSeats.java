package Train_Reservation_System.src;

import java.util.Date;
public class BookingSeats {
    Date time_date=new Date();
   private String Passenger;
   private int age;
   private String Birth;
   private String time;
    public BookingSeats toBookSeats(String Pass, int age, String Birth, String time_date){
        this.Passenger=Pass;
        this.age=age;
        this.Birth=Birth;
        this.time=time_date;
        return this;
    }
    public String toString(){
        return Passenger+" "+age+" "+Birth+" "+time;
    }

    public String getPassenger() {
        return Passenger;
    }

    public int getAge() {
        return age;
    }

    public String getBirth() {
        return Birth;
    }

    public String getTime() {
        return time;
    }
}
