/**
 * @author Harshith
 * @version 3.0
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v3.0 =====");

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Update inventory
        System.out.println("\nUpdating Single Room availability...");
        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("=====================================");
    }
}