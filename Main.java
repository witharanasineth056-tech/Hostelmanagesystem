import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        Hostel hostel1 = new Hostel(101, "Silver Tips Boys Hostel", "Inside", 10500);
        Hostel hostel2 = new Hostel(102, "Coral Beauty Boys Hostel", "Inside", 8500);
        Hostel hostel3 = new Hostel(103, "Cattleya Girls Hostel", "Inside", 7500);
        Hostel hostel4 = new Hostel(104, "Blue Sapphire Girls Hostel", "Inside", 2500);
        Hostel hostel5 = new Hostel(105, "Hindagoda E boys Hostel", "Hindagoda", 7500);
        Hostel hostel6 = new Hostel(106, "Walawwa Boys Hostel", "Kahataruppa", 5000);
        Hostel hostel7 = new Hostel(107, "Udawela Boys Hostel", "Udawela", 4000);
        Hostel hostel8 = new Hostel(108, "Kalugalpitiya Girls Hostel", "Kalugalpitiya", 2500);
        
        ArrayList<Hostel> hostels = new ArrayList<>();
        RecentViewManager recentViewManager = new RecentViewManager();
        WaitingListManager waitingListManager = new WaitingListManager();

        hostels.add(hostel1);
        hostels.add(hostel2);
        hostels.add(hostel3);
        hostels.add(hostel4);
        hostels.add(hostel5);
        hostels.add(hostel6);
        hostels.add(hostel7);
        hostels.add(hostel8);

        int choice = 0;

        while (choice != 10) {
            
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("               UWU HOSTEL MANAGEMENT SYSTEM");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
            System.out.println("1. View All Hostels\n");
            System.out.println("2. Search Hostel\n");
            System.out.println("3. Add Hostel\n");
            System.out.println("4. Delete Hostel\n");
            System.out.println("5. Update Hostel\n");
            System.out.println("6. Recently Viewed\n");
            System.out.println("7. Join Waiting List\n");
            System.out.println("8. Allocate Room\n");
            System.out.println("9. Sort Hostels by Price\n");
            System.out.println("10. Exit");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    HostelManager.viewHostels(hostels);
                    break;   
                case 2:
                    System.out.print("Enter Hostel ID: ");
                    int searchId = scanner.nextInt();
                    Hostel searchedHostel = SearchManager.binarySearch(hostels, searchId);
                    if (searchedHostel != null) {
                        System.out.println("ID: " + searchedHostel.Id);
                        System.out.println("Name: " + searchedHostel.Name);
                        System.out.println("Location: " + searchedHostel.Location);
                        System.out.println("Price: " + searchedHostel.Price);
                        recentViewManager.addRecentView(searchedHostel);
                    } else {
                        System.out.println("Hostel not found.");
                    }
                    break;
                case 3:
                    HostelManager.addHostel(hostels, scanner);
                    break;
                case 4:
                    HostelManager.deleteHostel(hostels, scanner);
                    break;
                case 5:
                    HostelManager.updateHostel(hostels, scanner);
                    break;
                case 6:
                    recentViewManager.showRecentViews();
                    break;
                case 7:
                    waitingListManager.joinWaitingList(scanner);
                break;
                case 8:
                    waitingListManager.allocateRoom();
                break;
                case 9:
                    SortManager.mergeSort(hostels, 0, hostels.size() - 1);
                        System.out.println("Hostels sorted by price");
                    for (Hostel hostel : hostels) {
                        System.out.println(hostel.Name + " - " + hostel.Price);
                    }
                    break;
                case 10:
                    System.out.println("Thank you for using UWU Hostel Management!");
                break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}    