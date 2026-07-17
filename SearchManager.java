import java.util.ArrayList;

public class SearchManager {
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
