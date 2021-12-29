public class SRTF {
    static class Process {
        private String name;
        private double ArrivalTime;
        private double BurstTime;
        private double completeTime;
        private double StartTime;
        private double EndTime;

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

        public Process(String name, double ArrivalTime, double burst) {
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

        public void reduceBurst(int q) {
            BurstTime -= Math.min(BurstTime, q);
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

    private static boolean checkCompleted(Process[] pros) {
        for(Process p : pros) {
            if(!p.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Process[] pros = new Process[4];
        pros[0] = new Process("1", 0, 8);
        pros[1] = new Process("2", 1, 4);
        pros[2] = new Process("3", 2, 9);
        pros[3] = new Process("4", 3, 5);

        int Context = 1;
        int quantum = 1;

        while(!checkCompleted(pros)) {
            Process obj = null;
            double minBurstTime = Integer.MAX_VALUE;

            for(Process p : pros) {
                if(!p.isCompleted() && p.getArrivalTime() <= Context && p.getBurst() < minBurstTime) {
                    minBurstTime = p.getBurst();
                    obj = p;
                }
            }
            Context += quantum;

            if(obj != null) {
                obj.reduceBurst(quantum);

                if(obj.getBurst() == 0) {
                    obj.setCompleteTime(Context);
                }
            }
        }

        System.out.println("name -->  All Time");

        for(Process p : pros)
        {
            System.out.print(p.getname()+"\t -->  ");
            System.out.println(p.getCompleteTime()+ " seconds");
        }
    }
}