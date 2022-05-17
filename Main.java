import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();

    ArrayList<Room> rooms = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      String cmd = sc.nextLine();
      String[] cmds = cmd.split(" ");
      if (cmds[0].equals("create")) {
        Room room = new Room(cmds[2]);
        rooms.add(room);
      }
      
      if (cmds[0].equals("book")) {
        if (Integer.parseInt(cmds[2]) > Integer.parseInt(cmds[3])) {
          System.out.println("ERR: Start date should be less than End date");
          return;
        }
        for(Room r: rooms) {
          if (r.id.equals(cmds[1])) {
            Booking b = new Booking(cmds[2], cmds[3]);
            r.bookings.add(b);
          }
        }
      }
      
      if (cmds[0].equals("cancel")) {
        boolean isDeleted = false;
        for (Room r: rooms) {
          Iterator<Booking> itr = r.bookings.iterator();
          while (itr.hasNext()) {
            Booking b = itr.next();
            if (b.id.equals(cmds[1])){
              itr.remove();
              isDeleted = true;
            }
          }
        }
        if (!isDeleted) {
          System.out.println("ERR: There is booking ID: " + cmds[1]);
          return;
        }
      }
    }
    
    // OUTPUT SECTION
    for(Room r: rooms) {
      System.out.println("Room: " + r.name);
      for(Booking b: r.bookings) {
        System.out.println("Booking Id " + b.id + ": " + b.start + " -> " + b.end);
      }
    }
  }
}

// 7
// create room Suite
// book 1 5 10
// create room Deluxe
// book 2 1 10
// book 1 12 18
// book 2 20 25
// cancel 4

// 2
// create room Suite
// book 1 5 10