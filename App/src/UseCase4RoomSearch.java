public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v4.0 =====");

        RoomInventory inventory = new RoomInventory();

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        if (inventory.getAvailability("Single Room") > 0) {
            r1.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Single Room"));
            System.out.println();
        }

        if (inventory.getAvailability("Double Room") > 0) {
            r2.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Double Room"));
            System.out.println();
        }

        if (inventory.getAvailability("Suite Room") > 0) {
            r3.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Suite Room"));
            System.out.println();
        }

        System.out.println("=====================================");
    }
}