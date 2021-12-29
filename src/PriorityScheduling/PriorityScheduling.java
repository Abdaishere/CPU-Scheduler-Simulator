package PriorityScheduling;

import java.util.ArrayList;
import java.util.Comparator;
import Main.Process;

public class PriorityScheduling {

    public static void start(ArrayList<Process> processes, float contextSwitching, int age) {
        processes.sort(new PComparator());
        float time = processes.get(0).arrivalTime;
        while (!processes.isEmpty()) {
            int shortest = 0;
            for (int j = 0; j < processes.size() && processes.get(j).arrivalTime <= time; j++) {
                if (time - processes.get(j).arrivalTime >= age) {
                    shortest = j;
                    break;
                } else if (processes.get(j).priorityNumber <= processes.get(shortest).priorityNumber) {
                    shortest = j;
                }
            }
            System.out.println(processes.get(shortest).Name);
            time += processes.get(shortest).burstTime + contextSwitching;
            processes.remove(shortest);
        }
    }

    public static class PComparator implements Comparator<Process> {

        @Override
        public int compare(Process o1, Process o2) {
            if (o1.arrivalTime != o2.arrivalTime)
                return o1.arrivalTime - o2.arrivalTime;
            return o1.priorityNumber - o2.priorityNumber;
        }
    }
}
