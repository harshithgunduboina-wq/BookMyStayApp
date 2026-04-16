import java.util.*;



// Booking + Allocation Service
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v6.0 =====");

        // Queue (FIFO)
        Queue<Reservation> queue = new LinkedList<>();

        queue.add(new Reservation("Alice", "Single Room"));
        queue.add(new Reservation("Bob", "Double Room"));
        queue.add(new Reservation("Charlie", "Suite Room"));

        // Inventory
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);

        // Allocated rooms (to avoid duplicates)
        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();

        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.put("Double Room", new HashSet<>());
        allocatedRooms.put("Suite Room", new HashSet<>());

        // Process queue
        while (!queue.isEmpty()) {

            Reservation r = queue.poll();
            String type = r.roomType;

            int available = inventory.getOrDefault(type, 0);

            if (available > 0) {

                // Generate unique room ID
                String roomId = type.substring(0, 2).toUpperCase() + (available);

                // Ensure uniqueness
                if (!allocatedRooms.get(type).contains(roomId)) {

                    allocatedRooms.get(type).add(roomId);

                    // Update inventory
                    inventory.put(type, available - 1);

                    System.out.println("Booking Confirmed:");
                    System.out.println("Guest: " + r.guestName);
                    System.out.println("Room Type: " + type);
                    System.out.println("Room ID: " + roomId);
                    System.out.println();
                }

            } else {
                System.out.println("Booking Failed (No Availability): " + r.guestName);
            }
        }

        System.out.println("=====================================");
    }
}