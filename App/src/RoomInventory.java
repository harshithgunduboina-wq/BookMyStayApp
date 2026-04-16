import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor to initialize inventory
    RoomInventory() {
        inventory = new HashMap<>();

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

    // Display inventory
    void displayInventory() {
        System.out.println("===== Room Inventory =====");

        for (String room : inventory.keySet()) {
            System.out.println(room + " → Available: " + inventory.get(room));
        }
    }
}