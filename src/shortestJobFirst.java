import java.util.ArrayList;
import java.util.Comparator;

public class shortestJobFirst {
    public static void start(ArrayList<Process> processes, int age) {
        processes.sort(new SJFComparator());
        int time = processes.get(0).arrivalTime;
        while (!processes.isEmpty()) {
            int shortest = 0;
            for (int j = 0; j < processes.size() && processes.get(j).arrivalTime <= time; j++) {
                if (time - processes.get(j).arrivalTime >= age) {
                    shortest = j;
                    break;
                } else if (processes.get(j).burstTime < processes.get(shortest).burstTime) {
                    shortest = j;
                }
            }
            System.out.println(processes.get(shortest).Name);
            time += processes.get(shortest).burstTime;
            processes.remove(shortest);
        }
    }

    public static class SJFComparator implements Comparator<Process> {

        @Override
        public int compare(Process o1, Process o2) {
            if (o1.arrivalTime != o2.arrivalTime)
                return o1.arrivalTime - o2.arrivalTime;
            return o1.burstTime - o2.burstTime;
        }
    }
}
