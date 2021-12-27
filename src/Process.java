import java.awt.*;

public class Process {
    String Name;
    Color color;
    int arrivalTime;
    int burstTime;
    int priorityNumber;
    int waitingTime;
    int turnAroundTime;
    int PID;

    public Process(String name, Color color, int arrivalTime, int burstTime, int priorityNumber, int PID) {
        Name = name;
        this.color = color;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priorityNumber = priorityNumber;
        this.PID = PID;
    }
}
