import java.util.ArrayList;

public class SortManager {
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
}
