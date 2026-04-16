import java.io.*;
import java.util.*;

// Serializable Booking class
class BookingData implements Serializable {
    String guestName;
    String roomType;

    BookingData(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class UseCase12DataPersistenceRecovery {

    static String FILE_NAME = "hotel_data.ser";

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v12.0 =====");

        // Data to store
        List<BookingData> bookings = new ArrayList<>();
        bookings.add(new BookingData("Alice", "Single Room"));
        bookings.add(new BookingData("Bob", "Double Room"));

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);

        // SAVE DATA
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(FILE_NAME));

            out.writeObject(bookings);
            out.writeObject(inventory);
            out.close();

            System.out.println("Data saved successfully!");

        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }

        // LOAD DATA
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(FILE_NAME));

            List<BookingData> loadedBookings =
                    (List<BookingData>) in.readObject();

            HashMap<String, Integer> loadedInventory =
                    (HashMap<String, Integer>) in.readObject();

            in.close();

            System.out.println("\nRecovered Data:\n");

            for (BookingData b : loadedBookings) {
                System.out.println("Guest: " + b.guestName +
                        " | Room: " + b.roomType);
            }

            System.out.println("\nInventory:");
            for (String key : loadedInventory.keySet()) {
                System.out.println(key + " → " + loadedInventory.get(key));
            }

        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        System.out.println("\n=====================================");
    }
}