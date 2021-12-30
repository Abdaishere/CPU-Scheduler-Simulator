import Main.Process;
import Main.duration;
import PriorityScheduling.PriorityScheduling;
import shortestJobFirst.shortestJobFirst;

import java.util.ArrayList;
import java.util.Comparator;

public class SRTF {
//    private static boolean checkCompleted(Process[] pros) {
//        for (Process p : pros) {
//            if (p.burstTime != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static ArrayList<duration> start(ArrayList<Process> processes, int contextSwitching, int age) {
//        ArrayList<duration> durations = new ArrayList<>();
//        processes.sort(new PriorityScheduling.PComparator());
//        int time = processes.get(0).arrivalTime;
//        while (!processes.isEmpty()) {
//            int shortest = 0;
//            for (int j = 0; j < processes.size() && processes.get(j).arrivalTime <= time; j++) {
//                if (time - processes.get(j).arrivalTime >= age) {
//                    shortest = j;
//                    break;
//                } else if (processes.get(j).priorityNumber <= processes.get(shortest).priorityNumber) {
//                    shortest = j;
//                }
//            }
//            durations.add(new duration(processes.get(shortest).Name, time, time += processes.get(shortest).burstTime + contextSwitching, "Done"));
//            processes.remove(shortest);
//        }
//        return durations;
//    }
//
//    public static class PComparator implements Comparator<Process> {
//
//        @Override
//        public int compare(Process o1, Process o2) {
//            if (o1.arrivalTime != o2.arrivalTime)
//                return o1.arrivalTime - o2.arrivalTime;
//            return o1.priorityNumber - o2.priorityNumber;
//        }
//    }
//
//    public static void main(String[] args) {
//        Process[] pros = new Process[4];
//        pros[0] = new Process("1", 0, 8);
//        pros[1] = new Process("2", 1, 4);
//        pros[2] = new Process("3", 2, 9);
//        pros[3] = new Process("4", 3, 5);
//
//        int Context = 1;
//        int quantum = 1;
//
//        while (!checkCompleted(pros)) {
//            Process obj = null;
//            double minBurstTime = Integer.MAX_VALUE;
//
//            for (Process p : pros) {
//                if (!p.isCompleted() && p.getArrivalTime() <= Context && p.getBurst() < minBurstTime) {
//                    minBurstTime = p.getBurst();
//                    obj = p;
//                }
//            }
//            Context += quantum;
//
//            if (obj != null) {
//                obj.reduceBurst(quantum);
//
//                if (obj.getBurst() == 0) {
//                    obj.setCompleteTime(Context);
//                }
//            }
//        }
//
//        System.out.println("name -->  All Time");
//
//        for (Process p : pros) {
//            System.out.print(p.getname() + "\t -->  ");
//            System.out.println(p.getCompleteTime() + " seconds");
//        }
//    }
}