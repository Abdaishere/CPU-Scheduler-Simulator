package Main;

import java.awt.*;

public class Process {
    public String Name;
    public int arrivalTime;
    public int burstTime;
    public int priorityNumber;
    public int waitingTime;
    public int turnAroundTime;
    public int quantum;
    public int ceil;
    public int PID;

    public Process(String name, int arrivalTime, int burstTime, int priorityNumber, int quantum, int PID) {
        Name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priorityNumber = priorityNumber;
        this.quantum = quantum;
        this.PID = PID;
    }

    public String[] getData() {
        return new String[]{String.valueOf(PID), Name, String.valueOf(arrivalTime), String.valueOf(burstTime), String.valueOf(priorityNumber), String.valueOf(quantum)};
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getCeil() {
        return ceil;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setCeil(int ceil) {
        this.ceil = ceil;
    }

    public int compareTo(Process obj) {
        return Name.compareTo(obj.Name);
    }
}
