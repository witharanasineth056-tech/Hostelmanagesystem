import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class WaitingListManager {

    private Queue<String> waitingList = new LinkedList<>();

    public void joinWaitingList(Scanner scanner) {

        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        waitingList.offer(studentName);

        System.out.println(studentName + " added to waiting list.");
    }

    public void allocateRoom() {

        if (waitingList.isEmpty()) {

            System.out.println("Waiting list is empty.");

        } else {

            String student = waitingList.poll();

            System.out.println(student + " has been allocated a room.");
        }
    }

}
