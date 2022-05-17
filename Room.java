import java.util.ArrayList;

public class Room {
  public static int count = 1;
  public String id;
  public String name;
  public ArrayList<Booking> bookings;


  public Room(String name) {
    this.id = count++ + "";
    this.name = name;
    this.bookings = new ArrayList<>();
  }

}
