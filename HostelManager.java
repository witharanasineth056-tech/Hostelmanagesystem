import java.util.ArrayList;
import java.util.Scanner;

public class HostelManager {

    public static void viewHostels(ArrayList<Hostel> hostels) {

        System.out.println("\n===== All Hostels =====\n");

        for (Hostel hostel : hostels) {

            System.out.println("ID: " + hostel.Id);
            System.out.println("Name: " + hostel.Name);
            System.out.println("Location: " + hostel.Location);
            System.out.println("Price: " + hostel.Price);
            System.out.println("----------------------------");
        }
    }

    public static void addHostel(ArrayList<Hostel> hostels, Scanner scanner) {

        System.out.print("Enter Hostel ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Hostel Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Hostel Location: ");
        String location = scanner.nextLine();

        System.out.print("Enter Hostel Price: ");
        double price = scanner.nextDouble();

        Hostel newHostel = new Hostel(id, name, location, price);

        hostels.add(newHostel);

        System.out.println("Hostel added successfully!");
    }


public static void deleteHostel(ArrayList<Hostel> hostels, Scanner scanner) {

    System.out.print("Enter Hostel ID to delete: ");
    int deleteId = scanner.nextInt();

    boolean deleted = false;

    for (int i = 0; i < hostels.size(); i++) {

        if (hostels.get(i).Id == deleteId) {

            hostels.remove(i);

            System.out.println("Hostel deleted successfully!");

            deleted = true;

            break;
        }
    }

    if (!deleted) {
        System.out.println("Hostel not found.");
    }

}

public static void updateHostel(ArrayList<Hostel> hostels, Scanner scanner) {

    System.out.print("Enter Hostel ID to update: ");
    int updateId = scanner.nextInt();
    scanner.nextLine();

    boolean updated = false;

    for (Hostel hostel : hostels) {

        if (hostel.Id == updateId) {

            System.out.print("Enter New Hostel Name: ");
            hostel.Name = scanner.nextLine();

            System.out.print("Enter New Hostel Location: ");
            hostel.Location = scanner.nextLine();

            System.out.print("Enter New Hostel Price: ");
            hostel.Price = scanner.nextDouble();

            System.out.println("Hostel updated successfully!");

            updated = true;
            break;
        }
    }

    if (!updated) {
        System.out.println("Hostel not found.");
    }
}
}
