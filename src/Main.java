import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        ArrayList<Process> processes1 = new ArrayList<>();
        while (size != 0) {
            String name = input.next();
            int arrivalTime = Integer.parseInt(input.next());
            int burstTime = Integer.parseInt(input.next());
            int priorityNumber = Integer.parseInt(input.next());
            int quantumNumber = Integer.parseInt(input.next());
            processes1.add(new Process(name, Color.BLACK, arrivalTime, burstTime, priorityNumber,quantumNumber, processes1.size() - 1));
            size--;
        }

        ArrayList<Process> processes2 = (ArrayList<Process>) processes1.clone();
//        shortestJobFirst.start(processes1, 11);
//        System.out.println();
//        PriorityScheduling.start(processes2, 11);
        AGAT.start(processes1);
    }
}


//4
//        p1 0 17 4 4
//        p2 3 6 9 34
//        p3 4 10 3 5
//        p4 29 4 8 2