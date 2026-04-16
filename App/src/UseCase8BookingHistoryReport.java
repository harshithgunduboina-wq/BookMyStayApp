import java.util.*;

// Reusing Reservation class (from UC5)
class BookingRecord {
    String guestName;
    String roomType;
    String roomId;

    BookingRecord(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    void display() {
        System.out.println("Guest: " + guestName +
                " | Room: " + roomType +
                " | Room ID: " + roomId);
    }
}

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v8.0 =====");

        // Booking history (List)
        List<BookingRecord> history = new ArrayList<>();

        // Add confirmed bookings (simulate UC6)
        history.add(new BookingRecord("Alice", "Single Room", "SI1"));
        history.add(new BookingRecord("Bob", "Double Room", "DO1"));
        history.add(new BookingRecord("Charlie", "Suite Room", "SU1"));

        // Display report
        System.out.println("\nBooking History Report:\n");

        for (BookingRecord b : history) {
            b.display();
        }

        System.out.println("\nTotal Bookings: " + history.size());

        System.out.println("\n=====================================");
    }
}
