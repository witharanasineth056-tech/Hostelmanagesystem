import java.util.Stack;

public class RecentViewManager {

    private Stack<Hostel> recentViews = new Stack<>();

    public void addRecentView(Hostel hostel) {

        recentViews.push(hostel);

    }

    public void showRecentViews() {

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
    }
}
