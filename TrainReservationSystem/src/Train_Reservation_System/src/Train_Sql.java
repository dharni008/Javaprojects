package Train_Reservation_System.src;

import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;
public class Train_Sql {
    PreparedStatement st;
    Connection con;
    static Queue<BookingSeats> Rac = new LinkedList<>();
    static Queue<BookingSeats> WaitingList = new LinkedList<>();
    public Train_Sql(){
        try{
            String url = "jdbc:mysql://localhost:3306/darani"; // Adjust the port and database name
            String user = "root";
            String password = "2003";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
    }
    public int sql_method(String passenger,int age,String birth,String time_date,int trainNumber) {
        try {
            st = con.prepareStatement("INSERT INTO train_reservation_"+trainNumber +"(passenger_name,passenger_age,Passenger_birth,time) VALUES (?,?,?,?)",st.RETURN_GENERATED_KEYS);
                st.setString(1,passenger);
                st.setInt(2,age);
                st.setString(3,birth);
                st.setString(4,time_date);
                st.executeUpdate();
                ResultSet rs = st.getGeneratedKeys();
                int r=0;
                while(rs.next()){
                    r=rs.getInt(1);
                }
            return r;
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return 0 ;
    }
    public void cancel_ticket(int id,int trainNumber) {
            try{
                st= con.prepareStatement("SELECT passenger_id FROM train_reservation_"+trainNumber + " WHERE passenger_id=?");
                st.setInt(1,id);
                ResultSet rs =st.executeQuery();
                if(rs.next()){
                    System.out.println("id exists");
                    st = con.prepareStatement("DELETE FROM train_reservation_"+trainNumber +" WHERE passenger_id=?");
                    st.setInt(1,id);
                    st.executeUpdate();
                    System.out.println("Tickets Cancelled");
                    return ;
                }
                else {
                    System.out.println("id does not exists");
                    return;
                }
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
    }
    public int checkseat(int trainNumber){
          int seatsAvail=0;
        try{
            st=con.prepareStatement("SELECT COUNT(*) FROM train_reservation_"+ trainNumber);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                seatsAvail=rs.getInt(1);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return seatsAvail;
    }
    public void displayTicket(int id,int trainNumber){
        try{
            st=con.prepareStatement("SELECT * FROM train_reservation_"+trainNumber+" WHERE passenger_id=?");
            st.setInt(1,id);
            ResultSet rs= st.executeQuery();
            ResultSetMetaData res= rs.getMetaData();
            int columnCount= res.getColumnCount();
            while(rs.next()){
                for(int i=1;i<columnCount;i++){
                    String colname=res.getColumnName(i);
                    String Value=rs.getString(i);
                    System.out.println(colname+" : "+Value);
                }
                System.out.println();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean isRacTableEmpty() {
        try {
            st = con.prepareStatement("SELECT COUNT(*) FROM rac");
            ResultSet res = st.executeQuery();
            if (res.next()) {
                int count = res.getInt(1);
                return count == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void waiting_list_set(int trainNumber,String passenger,int age,String birth,String time_date){
        try{
            st = con.prepareStatement("INSERT INTO waiting_list (passenger_name,passenger_age,Passenger_birth,time) VALUES (?,?,?,?)");
            st.setString(1,passenger);
            st.setInt(2,age);
            st.setString(3,birth);
            st.setString(4,time_date);
            st.executeUpdate();
            waiting_list_get(trainNumber,passenger,age,birth,String.valueOf(time_date));
        }
       catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void waiting_list_get(int trainNumber,String passenger,int age,String birth,String time_date){
        try{
            st = con.prepareStatement("SELECT * FROM waiting_list ORDER BY num ASC");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                BookingSeats bs= new BookingSeats();
                bs.toBookSeats(
                rs.getString("passenger_name"),
                rs.getInt("passenger_age"),
                rs.getString("Passenger_birth"),
                rs.getString("time"));
                WaitingList.offer(bs);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        rac_list(trainNumber);
    }
    public void rac_list(int trainNumber){
        Rac.offer(WaitingList.remove());
        while(!Rac.isEmpty()) {
            BookingSeats p = Rac.poll();
            try {
                st = con.prepareStatement("INSERT INTO rac (passenger_name,passenger_age,Passenger_birth,time) VALUES (?,?,?,?) ");
                st.setString(1, p.getPassenger());
                st.setInt(2, p.getAge());
                st.setString(3, p.getBirth());
                st.setString(4, p.getTime());
                st.executeUpdate();
                st = con.prepareStatement("DELETE FROM waiting_list ORDER BY num ASC LIMIT 1");
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void rac_to_train(int trainNumber){
        try {
            st = con.prepareStatement("SELECT * FROM rac ORDER BY num ASC");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BookingSeats bs = new BookingSeats();
                bs.toBookSeats(
                        rs.getString("passenger_name"),
                        rs.getInt("passenger_age"),
                        rs.getString("Passenger_birth"),
                        rs.getString("time"));
                Rac.offer(bs);
            }
        }
        catch (SQLException c){
            c.printStackTrace();
        }
            BookingSeats p = Rac.poll();
        if(checkseat(trainNumber)<9) {
            try {
                st = con.prepareStatement("INSERT INTO train_reservation_" + trainNumber + " (passenger_name,passenger_age,Passenger_birth,time) VALUES (?,?,?,?)");
                st.setString(1, p.getPassenger());
                st.setInt(2, p.getAge());
                st.setString(3, p.getBirth());
                st.setString(4, p.getTime());
                st.executeUpdate();
                st = con.prepareStatement("DELETE FROM rac ORDER BY num ASC LIMIT 1");
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
