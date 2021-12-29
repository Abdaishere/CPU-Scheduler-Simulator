package AGAT;

import Main.Process;

import java.util.ArrayList;
import java.util.Comparator;

public class AGAT {
    public static ArrayList<Process> readyQueue = new ArrayList<>();
    public static ArrayList<Process> deadlist = new ArrayList<>();
    public static ArrayList<Integer> quantumleft = new ArrayList<>();
    public static ArrayList<Integer> Factor = new ArrayList<>();
    public static int V1;
    public static int V2;

    public static void start(ArrayList<Process> processes) {
        sort(processes, Comparator.comparing(Process::getArrivalTime));
        setV1(processes);

        Process last = processes.get(processes.size() - 1);
        int time = 0, i = 0;
        while (time++ < last.arrivalTime + last.burstTime && (i < processes.size() || !readyQueue.isEmpty())) {

            for (; i < processes.size(); i++) {
                if (processes.get(i).getArrivalTime() <= time) {
                    setV2(processes);
                    getAGATFactor(processes);
                    readyQueue.add(processes.get(i));
                    quantumleft.add(processes.get(i).getQuantum());
                } else if (processes.get(i).getArrivalTime() > time) {
                    break;
                }
            }
        /*
            The running process used all its quantum time and it still has job to do (add this process to the
            end of the queue, then increases its quantum time by 2). Next process is picked from queue.

            ii. The running process didn’t use all its quantum time because it was removed in favor of a
            process with better AGAT factor (add this process to the end of the queue, then increases its
            quantum time by the remaining quantum time for it).

            iii. The running process finished its job (set its quantum time to zero and remove it from ready
            queue and add it to the dead list).
         */

            int Factor = getAGATFactor(readyQueue);

            if (readyQueue.get(0).burstTime == 0) {

                System.out.println(readyQueue.get(0).getName());

                readyQueue.get(0).setQuantum(0);
                deadlist.add(readyQueue.get(0));

                readyQueue.remove(0);
                quantumleft.remove(0);

            } else {
                if (readyQueue.get(0).burstTime != 0 && quantumleft.get(0) == 0) {

                    System.out.println(readyQueue.get(0).getName());

                    Process p = readyQueue.get(0);
                    p.setQuantum(readyQueue.get(0).getQuantum() * 2);
                    readyQueue.remove(0);
                    quantumleft.remove(0);
                    readyQueue.add(p);
                    quantumleft.add(p.getQuantum());
                }
            }

            while()

            readyQueue.get(0).burstTime--;
            quantumleft.set(0, quantumleft.get(0) - 1);

        }

//        while (i < processes.size() || !execute.isEmpty()) {
//            System.out.println(1);
//
//            for (; i < processes.size(); i++) {
//                if (processes.get(i).getArrivalTime() == time) {
//                    setV2(processes);
//                    getAGATFactor(processes);
//                    execute.add(processes.get(i));
//                } else if (processes.get(i).getArrivalTime() > time) {
//                    break;
//                }
//            }
//
//            if (execute.size() == 1 && forhelp != newQuantum) {
//                if (forhelp == 0) {
//                    newQuantum = (int) Math.ceil(execute.get(0).getQuantum() * 0.4);
//                    forhelp++;
//                } else {
//                    forhelp++;
//                }
//            } else if (execute.size() == 1 && forhelp >= newQuantum) {
//                forhelp++;
//            } else {
//                if (forhelp != newQuantum) {
//                    if (forhelp > newQuantum) {
//                        factorIndex = getAGATFactor(processes);
//                        int diffQuantum = execute.get(factorIndex).getQuantum() - forhelp + 1;
//                        forhelp = 0;
//                        execute.get(factorIndex).setQuantum(execute.get(factorIndex).getQuantum() + diffQuantum);
//                    } else if (forhelp == 0) {
//                        factorIndex = getAGATFactor(processes);
//                        newQuantum = (int) Math.ceil(execute.get(factorIndex).getQuantum() * 0.4);
//                        execute.get(factorIndex).burstTime--;
//                        forhelp++;
//                    } else {
//                        forhelp++;
//                        execute.get(factorIndex).burstTime--;
//                        if (execute.get(factorIndex).burstTime == 0) {
//                            System.out.println(execute.get(factorIndex).getName());
//                            execute.remove(factorIndex);
//                            forhelp = 0;
//                        }
//                        else{
//                            System.out.println(execute.get(factorIndex).getName());
//                        }
//                    }
//                } else if (forhelp == newQuantum) {
//                    int diffQuantum = execute.get(factorIndex).getQuantum() - forhelp + 1;
//                    forhelp = 0;
//                    execute.get(factorIndex).setQuantum(execute.get(factorIndex).getQuantum() + diffQuantum);
//
//                }
//            }
//            time++;
//        }
    }

    public static void sort(ArrayList<Process> processes, Comparator x) {
        processes.sort(x);
    }

    public static void setV1(ArrayList<Process> processes) {

        if (processes.get(processes.size() - 1).arrivalTime > 10) {
            V1 = (processes.get(processes.size() - 1).arrivalTime) / 10;
        } else {
            V1 = 1;
        }
    }

    public static void setV2(ArrayList<Process> processes) {
        int maxBurstTime = 0;
        for (Process process : processes) {
            if (process.burstTime > maxBurstTime) {
                maxBurstTime = process.burstTime;
            }
        }
        if (maxBurstTime > 10) {
            V2 = maxBurstTime / 10;
        } else {
            V2 = 1;
        }
    }

    public static int getAGATFactor(ArrayList<Process> processes) {
        for (Process process : processes) {
            int factor = (10 - process.priorityNumber) + (int) Math.ceil(process.arrivalTime / V1) + (int) Math.ceil(process.burstTime / V2);
            Factor.add(factor);
        }
        int minFactor = 0;
        for (int i = 0; i < Factor.size(); i++) {
            if (Factor.get(i) < Factor.get(minFactor)) {
                minFactor = i;
            }
        }
        return minFactor;
    }
}
