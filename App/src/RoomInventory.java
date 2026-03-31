import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    RoomInventory() {
        inventory = new HashMap<>();

        // Initialize room availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display all rooms
    void displayInventory() {
        System.out.println("===== Room Inventory =====");

        for (String key : inventory.keySet()) {
            System.out.println(key + " → Available: " + inventory.get(key));
        }
    }
}