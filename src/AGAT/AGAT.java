package AGAT;

import Main.Process;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class AGAT {
    public static Queue<Process> readyQueue = new LinkedList<>();
    public static ArrayList<Integer> Factor = new ArrayList<>();
    public static int V1;
    public static int V2;
    public static void start(ArrayList<Process> processes){
        ArrayList<Process> execute = new ArrayList<>();
        int time = 0, i = 0, j = 1;
        Process x = null;

        sort(processes,Comparator.comparing(Process::getArrivalTime));
        setV1(processes);
        setCeil(processes);
        int newQuantum =0;
        int factorIndex = 0;

        int forhelp =0;

        while(i < processes.size() || !execute.isEmpty())
        {
            for (; i < processes.size(); i++){
                if(processes.get(i).getArrivalTime() == time){
                    setV2(processes);
                    setAGATFactor(processes);
                    execute.add(processes.get(i));
                }else if(processes.get(i).getArrivalTime() > time){
                    break;
                }
            }
            if(execute.size()==1 &&forhelp!=newQuantum){
                if (forhelp == 0){
                    newQuantum = (int) Math.ceil(execute.get(0).getQuantum() * 0.4);
                    forhelp++;
                }else{
                    forhelp++;
                }
            }else if(execute.size()==1 && forhelp>=newQuantum){
                newQuantum++;
            }else{
                if(forhelp!=newQuantum){
                    if(forhelp>newQuantum){
                        forhelp =0;
                        factorIndex = setAGATFactor(processes);
                        int diffQuantum = execute.get(factorIndex).getQuantum()-forhelp+1;
                        execute.get(factorIndex).setQuantum(execute.get(factorIndex).getQuantum()+diffQuantum);
                    }
                    else if (forhelp == 0){
                        factorIndex = setAGATFactor(processes);
                        newQuantum = (int) Math.ceil(execute.get(factorIndex).getQuantum() * 0.4);
                        forhelp++;
                    }else{
                        forhelp++;
                    }
                }else if(forhelp==newQuantum){
                    forhelp =0;
                    int diffQuantum = execute.get(factorIndex).getQuantum()-forhelp+1;
                    execute.get(factorIndex).setQuantum(execute.get(factorIndex).getQuantum()+diffQuantum);

                }
            }
            time++;
        }
    }

    public static void sort(ArrayList<Process> processes,Comparator x) {
        processes.sort(x);
    }

    public static void setV1(ArrayList<Process> processes){
        if(processes.get(processes.size()-1).arrivalTime > 10){
            V1 = (processes.get(processes.size()-1).arrivalTime)/10;
        }else{
            V1 = 1;
        }
    }

    public static void setV2(ArrayList<Process> processes){
        int maxBurstTime =0;
        for(Process process: processes){
            if(process.burstTime > maxBurstTime){
                maxBurstTime = process.burstTime;
            }
        }
        if(maxBurstTime> 10){
            V2 = maxBurstTime/10;
        }else{
            V2 = 1;
        }
    }

    public static int setAGATFactor(ArrayList<Process> processes){
        for(Process process: processes){
            int factor = (10-process.priorityNumber) + (int)Math.ceil(process.arrivalTime/V1) + (int)Math.ceil(process.burstTime/V2);
            Factor.add(factor);
        }
        int minFactor =Factor.get(0);
        for(int i=0; i<Factor.size(); i++){
            if(Factor.get(i) < minFactor){
                minFactor = Factor.get(i);
            }
        }
        return minFactor;
    }

    public static void setCeil(ArrayList<Process> processes){ //at the beginning of each new time(when new process start)
        for(Process process: processes){
            process.setCeil((int) Math.ceil(process.arrivalTime/V1));
        }
    }

}
