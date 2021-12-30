import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class SRTF {

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

//    public static class PComparator implements Comparator<Process> {
//
//        @Override
//        public int compare(Process o1, Process o2) {
//            if (o1.arrivalTime != o2.arrivalTime)
//                return o1.arrivalTime - o2.arrivalTime;
//            return o1.priorityNumber - o2.priorityNumber;
//        }
//    }

    static class Process implements Comparable<Process> {

    @Override
    public int compareTo(Process obj) {
        return getname().compareTo(obj.getname());
    }

    private String name;
    private double ArrivalTime;
    private double BurstTime;
    private double completeTime;
    private double StartTime;
    private double EndTime;
    private int AtTime;

        public void setAtTime(int atTime) {
            AtTime = atTime;
        }

        public int getAtTime() {
            return AtTime;
        }

        public void setStartTime(double startTime) {
        StartTime = startTime;
    }

    public double getStartTime() {
        return StartTime;
    }

    public double getEndTime() {
        return EndTime;
    }

    public void setEndTime(double endTime) {
        EndTime = endTime;
    }

    Process(String name, double ArrivalTime, double burst,double startTime,double endTime) {
        this.name = name;
        this.ArrivalTime = ArrivalTime;
        this.BurstTime = burst;
        this.completeTime = 0;
        this.StartTime = startTime;
        this.EndTime=endTime;
    }
    Process(String name, double ArrivalTime, double burst) {
        this.name = name;
        this.ArrivalTime = ArrivalTime;
        this.BurstTime = burst;
        this.completeTime = 0;
    }

    public String getname() {
        return this.name;
    }

    public double getArrivalTime() {
        return this.ArrivalTime;
    }

    public double getBurst() {
        return this.BurstTime;
    }

    public void setCompleteTime(int time) {
        this.completeTime = time;
    }

    public double getCompleteTime() {
        return this.completeTime;
    }

    public boolean isCompleted() {
        return this.completeTime != 0;
    }
}

    public static ArrayList<Process> processes = new ArrayList<>();

    private static boolean checkCompleted(Process[] pros) {
        for(Process p : pros) {
            if(!p.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Process>  Gantt_Chart(Process[] pros){

        int Time = 0;
        int AtTime =0;
        while(!checkCompleted(pros)) {
            Process obj = null;
            double minBurstTime = Integer.MAX_VALUE;

            for(Process p : pros) {
                if(!p.isCompleted() && p.getArrivalTime() <= Time && p.getBurst() < minBurstTime) {
                    minBurstTime = p.getBurst();
                    obj = p;
                }
            }

            Time++;

            if(obj != null) {
                int arribetime = --Time;
                Process p = new Process(obj.name,arribetime,obj.BurstTime,arribetime,++Time);
                p.setAtTime(AtTime++);
                processes.add(p);
                obj.BurstTime--;

                if(obj.getBurst() == 0) {
                    obj.setCompleteTime(Time);
                }
            }
        }
        return processes;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Process[] pros = new Process[n];
        /*
            4
            p1 0 8
            p2 1 4
            p3 2 9
            p4 3 5
         */
        for (int i=0;i<n;i++){
            String name = input.next();
            int arrive = input.nextInt();
            int Burest = input.nextInt();
            pros[i] = new Process(name, arrive, Burest);
        }
        ArrayList<Process> AllProcess;
        ArrayList<Process> AllProcessAfterSorted ;

        AllProcess = Gantt_Chart(pros);
        AllProcessAfterSorted = AllProcess;
        Collections.sort(AllProcessAfterSorted);

        for(int j=0;j<AllProcess.size();j++)
        {
            System.out.print("At Time : "+j+" "+AllProcess.get(j).getname() + " ArrivalTime: "+AllProcess.get(j).getArrivalTime()+" Burst: "+AllProcess.get(j).getBurst()+" start " +AllProcess.get(j).getStartTime()+" End "+AllProcess.get(j).getEndTime());
            System.out.println("");
        }
        
//        for(int j=0;j<AllProcessAfterSorted.size();j++)
//        {
//            System.out.print("At Time : "+j+" "+AllProcessAfterSorted.get(j).getname() + " ArrivalTime: "+AllProcessAfterSorted.get(j).getArrivalTime()+" Burst: "+AllProcessAfterSorted.get(j).getBurst()+" start " +AllProcessAfterSorted.get(j).getStartTime()+" End "+AllProcessAfterSorted.get(j).getEndTime());
//            System.out.println("");
//        }



        for(Process p : pros)
        {
            System.out.println("TurnAround : "+p.getname()+" = "+p.getCompleteTime() +" seconds");
        }
    }
}