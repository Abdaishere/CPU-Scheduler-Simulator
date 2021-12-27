

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        ArrayList<Process> processes1 = new ArrayList<>();
        ArrayList<Process> processes2 = new ArrayList<>();
        while (size != 0) {
            String name = input.next();
            int arrivalTime = Integer.parseInt(input.next());
            int burstTime = Integer.parseInt(input.next());
            int priorityNumber = Integer.parseInt(input.next());
            processes1.add(new Process(name, Color.BLACK, arrivalTime, burstTime, priorityNumber, processes1.size() - 1));
            processes2.add(new Process(name, Color.BLACK, arrivalTime, burstTime, priorityNumber, processes2.size() - 1));
            size--;
        }

        shortestJobFirst.start(processes1, 11);
        System.out.println();
        PriorityScheduling.start(processes2, 11);
    }
}
