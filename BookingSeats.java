public class BookingSeats {
    private int trainnumber;
   private String Passenger;
   private int age;
   private String Birth;
    public BookingSeats toBookSeats(int trainnum, String Pass, int age, String Birth){
        this.trainnumber=trainnum;
        this.Passenger=Pass;
        this.age=age;
        this.Birth=Birth;
        return this;
    }
    public String toString(){
        return trainnumber+" "+Passenger+" "+age+" "+Birth;
    }
}
