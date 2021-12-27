

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        ArrayList<Process> processes = new ArrayList<>();
        while (size != 0) {
            String name = input.nextLine();
            int arrivalTime = Integer.parseInt(input.nextLine());
            int burstTime = Integer.parseInt(input.nextLine());
            int priorityNumber = Integer.parseInt(input.nextLine());
            processes.add(new Process(name, Color.BLACK, arrivalTime, burstTime, priorityNumber, processes.size() - 1));
            size--;
        }
        shortestJobFirst.start(processes, 11);
    }
}
