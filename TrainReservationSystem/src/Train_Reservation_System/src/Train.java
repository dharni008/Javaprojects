package Train_Reservation_System.src;

public class Train {
    String name;
    String time;

    int passengerStrength;
    int trainNumber;
    public Train(String name , String time , int passengerStrength , int trainNumber)
    {
        this.name=name;
        this.time=time;
        this.passengerStrength=passengerStrength;
        this.trainNumber=trainNumber;
    }

    public int getPassengerStrength() {
        return passengerStrength;
    }

}
