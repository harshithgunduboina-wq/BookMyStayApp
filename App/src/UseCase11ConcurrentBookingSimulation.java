import java.util.*;

// Reservation (reuse idea, but new class name to avoid conflict)
class BookingRequest {
    String guestName;
    String roomType;

    BookingRequest(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Shared Booking System
class BookingSystem {

    private HashMap<String, Integer> inventory = new HashMap<>();

    BookingSystem() {
        inventory.put("Single Room", 2);
    }

    // synchronized = only one thread at a time
    public synchronized void bookRoom(BookingRequest req) {

        int available = inventory.getOrDefault(req.roomType, 0);

        if (available > 0) {
            inventory.put(req.roomType, available - 1);

            System.out.println(Thread.currentThread().getName() +
                    " booked " + req.roomType +
                    " for " + req.guestName +
                    " | Remaining: " + (available - 1));
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED for " + req.guestName +
                    " (No rooms available)");
        }
    }
}

// Thread class
class BookingThread extends Thread {

    BookingSystem system;
    BookingRequest request;

    BookingThread(BookingSystem system, BookingRequest request) {
        this.system = system;
        this.request = request;
    }

    public void run() {
        system.bookRoom(request);
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v11.0 =====");

        BookingSystem system = new BookingSystem();

        // Multiple requests
        BookingThread t1 = new BookingThread(system,
                new BookingRequest("Alice", "Single Room"));

        BookingThread t2 = new BookingThread(system,
                new BookingRequest("Bob", "Single Room"));

        BookingThread t3 = new BookingThread(system,
                new BookingRequest("Charlie", "Single Room"));

        // Start threads (simultaneous execution)
        t1.start();
        t2.start();
        t3.start();

        System.out.println("=====================================");
    }
}
