package Main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import AGAT.*;
import PriorityScheduling.*;
import shortestJobFirst.*;


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
            processes1.add(new Process(name, Color.BLACK, arrivalTime, burstTime, priorityNumber, quantumNumber, processes1.size() - 1));
            size--;
        }

//        shortestJobFirst.start((ArrayList<Process>) processes1.clone(), 11);
//        System.out.println();
//        PriorityScheduling.start((ArrayList<Process>) processes1.clone(), 0.5F, 11);
//        System.out.println();
        AGAT.start((ArrayList<Process>) processes1.clone());
    }
}


//4
//P1 0 17 4 4
//P2 3 6 9 3
//P3 4 10 3 5
//P4 29 4 8 2