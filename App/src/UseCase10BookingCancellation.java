import java.util.*;

// Booking record (simple)
class Booking {
    String guestName;
    String roomType;
    String roomId;

    Booking(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }
}

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v10.0 =====");

        // Inventory
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 1);

        // Confirmed bookings
        HashMap<String, Booking> bookings = new HashMap<>();

        bookings.put("RES101", new Booking("Alice", "Single Room", "SI1"));
        bookings.put("RES102", new Booking("Bob", "Double Room", "DO1"));

        // Stack for rollback (released room IDs)
        Stack<String> rollbackStack = new Stack<>();

        // Cancel booking
        String cancelId = "RES101";

        if (bookings.containsKey(cancelId)) {

            Booking b = bookings.get(cancelId);

            // Push room ID to stack
            rollbackStack.push(b.roomId);

            // Restore inventory
            inventory.put(b.roomType,
                    inventory.getOrDefault(b.roomType, 0) + 1);

            // Remove booking
            bookings.remove(cancelId);

            System.out.println("Booking Cancelled:");
            System.out.println("Guest: " + b.guestName);
            System.out.println("Room Released: " + b.roomId);

        } else {
            System.out.println("Cancellation Failed: Booking not found");
        }

        // Show rollback stack
        System.out.println("\nRollback Stack:");
        for (String id : rollbackStack) {
            System.out.println(id);
        }

        System.out.println("\nUpdated Inventory:");
        for (String type : inventory.keySet()) {
            System.out.println(type + " → " + inventory.get(type));
        }

        System.out.println("\n=====================================");
    }
}