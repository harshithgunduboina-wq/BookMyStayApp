import java.util.*;

// Add-On Service class
class AddOnService {
    String name;
    int cost;

    AddOnService(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("===== Hotel Booking System v7.0 =====");

        // Reservation IDs (from UC6 concept)
        String res1 = "RES101";
        String res2 = "RES102";

        // Map: Reservation → List of Services
        HashMap<String, List<AddOnService>> serviceMap = new HashMap<>();

        // Create service lists
        List<AddOnService> services1 = new ArrayList<>();
        services1.add(new AddOnService("WiFi", 200));
        services1.add(new AddOnService("Breakfast", 300));

        List<AddOnService> services2 = new ArrayList<>();
        services2.add(new AddOnService("Airport Pickup", 500));

        // Map services to reservations
        serviceMap.put(res1, services1);
        serviceMap.put(res2, services2);

        // Display services + total cost
        for (String resId : serviceMap.keySet()) {

            System.out.println("\nReservation ID: " + resId);

            int total = 0;

            for (AddOnService s : serviceMap.get(resId)) {
                System.out.println("Service: " + s.name + " | Cost: " + s.cost);
                total += s.cost;
            }

            System.out.println("Total Add-On Cost: " + total);
        }

        System.out.println("\n=====================================");
    }
}