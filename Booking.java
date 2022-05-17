public class Booking {
  public static int count = 1;
  public String id;
  public String start;
  public String end;


  public Booking(String start, String end) {
    this.id = count++ + "";
    this.start = start;
    this.end = end;
  }

}
