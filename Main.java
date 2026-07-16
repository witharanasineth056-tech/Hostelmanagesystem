import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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
        Stack<Hostel> recentViews = new Stack<>();
        Queue<String> waitingList = new LinkedList<>();


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

            System.out.println("\n========== UWU Hostel Management ==========\n\n");
            System.out.println("1. View All Hostels");
            System.out.println("2. Search Hostel");
            System.out.println("3. Add Hostel");
            System.out.println("4. Delete Hostel");
            System.out.println("5. Update Hostel");
            System.out.println("6. Recently Viewed");
            System.out.println("7. Join Waiting List");
            System.out.println("8. Allocate Room");
            System.out.println("9. Sort Hostels by Price");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n===== All Hostels =====\n");

                    for (Hostel hostel : hostels) {
                        System.out.println("ID: " + hostel.Id);
                        System.out.println("Name: " + hostel.Name);
                        System.out.println("Location: " + hostel.Location);
                        System.out.println("Price: " + hostel.Price);
                        System.out.println("----------------------------");
                    }

                    break;

                case 2:

                    System.out.print("Enter Hostel ID: ");
                    int searchId = scanner.nextInt();

                    Hostel searchedHostel = binarySearch(hostels, searchId);

                    if (searchedHostel != null) {

                        System.out.println("ID: " + searchedHostel.Id);
                        System.out.println("Name: " + searchedHostel.Name);
                        System.out.println("Location: " + searchedHostel.Location);
                        System.out.println("Price: " + searchedHostel.Price);

                        recentViews.push(searchedHostel);

                    } else {

                        System.out.println("Hostel not found.");
                    }

                break;

                case 3:

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

                    break;
                case 4:

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

                    break;

                case 5:

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

                break;

                case 6:

                    if (recentViews.isEmpty()) {

                        System.out.println("No recently viewed hostels.");

                    } else {

                        System.out.println("\n===== Recently Viewed Hostels =====");

                    for (int i = recentViews.size() - 1; i >= 0; i--) {

                    Hostel hostel = recentViews.get(i);

                    System.out.println("ID: " + hostel.Id);
                    System.out.println("Name: " + hostel.Name);
                    System.out.println("Location: " + hostel.Location);
                    System.out.println("Price: " + hostel.Price);
                    System.out.println("----------------------------");
                        }
                    }

                break;

                case 7:
                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();

                    waitingList.offer(studentName);

                    System.out.println(studentName + " added to waiting list.");

                break;

                case 8:

                    if(waitingList.isEmpty()){

                    System.out.println("Waiting list is empty.");

                    }else{

                    String student = waitingList.poll();

                    System.out.println(student + " has been allocated a room.");
                    }

                break;

                case 9:

                    mergeSort(hostels,0,hostels.size()-1);

                    System.out.println("Hostels sorted by price");

                    for(Hostel hostel: hostels){

                    System.out.println(hostel.Name+" - "+hostel.Price);

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

    public static void mergeSort(ArrayList<Hostel> hostels, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(hostels, left, middle);

            mergeSort(hostels, middle + 1, right);

            merge(hostels, left, middle, right);
        }
    }

    public static void merge(ArrayList<Hostel> hostels, int left, int middle, int right) {

        ArrayList<Hostel> temp = new ArrayList<>();

        int i = left;
        int j = middle + 1;

        while (i <= middle && j <= right) {

            if (hostels.get(i).Price <= hostels.get(j).Price) {

                temp.add(hostels.get(i));
                i++;

            } else {

                temp.add(hostels.get(j));
                j++;
            }
        }

        while (i <= middle) {
            temp.add(hostels.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(hostels.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            hostels.set(left + k, temp.get(k));
        }
    }

         public static Hostel binarySearch(ArrayList<Hostel> hostels, int searchId) {

        int left = 0;
        int right = hostels.size() - 1;

        while (left <= right) {

            int middle = (left + right) / 2;


            if (hostels.get(middle).Id == searchId) {

                return hostels.get(middle);


            } else if (hostels.get(middle).Id < searchId) {

                left = middle + 1;


            } else {

                right = middle - 1;
            }
        }
        return null;
    }
}