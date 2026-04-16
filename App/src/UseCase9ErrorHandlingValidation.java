// Custom Exception
class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

public class UseCase9ErrorHandlingValidation {

    // Validation method
    static void validateBooking(String roomType, int available)
            throws InvalidBookingException {

        // Check invalid room type
        if (!(roomType.equals("Single Room") ||
              roomType.equals("Double Room") ||
              roomType.equals("Suite Room"))) {

            throw new InvalidBookingException("Invalid Room Type: " + roomType);
        }

        // Check availability
        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for: " + roomType);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v9.0 =====");

        try {
            // Test cases
            validateBooking("Single Room", 2);   // valid
            System.out.println("Booking Valid for Single Room");

            validateBooking("Deluxe Room", 3);   // invalid room
            System.out.println("This will not print");

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            validateBooking("Double Room", 0);   // no availability
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("=====================================");
    }
}