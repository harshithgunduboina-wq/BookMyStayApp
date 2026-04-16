import java.util.LinkedList;
import java.util.Queue;

// Reservation class
class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Guest: " + guestName + " | Room: " + roomType);
    }
}

/**
 * @author Harshith
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v5.0 =====");

        // Create queue
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Add booking requests (FIFO)
        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Double Room"));
        bookingQueue.add(new Reservation("Charlie", "Suite Room"));

        System.out.println("Booking Requests in Queue:\n");

        // Display queue
        for (Reservation r : bookingQueue) {
            r.display();
        }

        System.out.println("=====================================");
    }
}