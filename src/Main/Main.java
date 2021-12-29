package Main;

import java.util.ArrayList;
import java.util.Scanner;

import org.jfree.ui.RefineryUtilities;
import shortestJobFirst.*;
import PriorityScheduling.*;
import AGAT.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        ArrayList<Process> processes1 = new ArrayList<>();
        ArrayList<String> order = new ArrayList<>();
        while (size != 0) {
            String name = input.next();
            int arrivalTime = Integer.parseInt(input.next());
            int burstTime = Integer.parseInt(input.next());
            int priorityNumber = Integer.parseInt(input.next());
            int quantumNumber = Integer.parseInt(input.next());
            order.add(name);
            processes1.add(new Process(name, arrivalTime, burstTime, priorityNumber, quantumNumber, processes1.size() - 1));
            size--;
        }
//        PlotWindow ShortestJobFirst = new PlotWindow("Shortest Job First", shortestJobFirst.start((ArrayList<Process>) processes1.clone(), 100));
//        ShortestJobFirst.pack();
//        RefineryUtilities.centerFrameOnScreen(ShortestJobFirst);
//        ShortestJobFirst.setVisible(true);
//
//        PlotWindow priorityScheduling = new PlotWindow("Priority Scheduling", PriorityScheduling.start((ArrayList<Process>) processes1.clone(), 1, 100));
//        priorityScheduling.pack();
//        RefineryUtilities.centerFrameOnScreen(priorityScheduling);
//        priorityScheduling.setVisible(true);
//
//        System.out.println();

        PlotWindow agat = new PlotWindow("AGAT", AGAT.start((ArrayList<Process>) processes1.clone()), order);
        agat.pack();
        RefineryUtilities.centerFrameOnScreen(agat);
        agat.setVisible(true);

    }
}


//4
//P1 0 17 4 4
//P2 3 6 9 3
//P3 4 10 3 5
//P4 29 4 8 2