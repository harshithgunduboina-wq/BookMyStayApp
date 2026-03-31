/**
 * @author Harshith
 * @version 2.0
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v2.0 =====");

        // Create room objects
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        r1.displayDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        r2.displayDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        r3.displayDetails();
        System.out.println("Available: " + suiteAvailable);

        System.out.println("====================================");
    }
}