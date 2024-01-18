public class Process implements Comparable<Process>{

    // Process ID
    private int processID;

    // Arrival Time
    private long arrivalTime;

    // Burst Time to Complete
    private long burstTime;

    // Time Remaining to Complete
    private long timeRemaining;

    // Finished Time to calculate Turnaround Time and Waiting Time
    private double FinishedTime;

    // Constructor
    public Process(int id, long arrival, long burst) {
        this.processID = id;
        this.arrivalTime = arrival;
        this.burstTime = burst;
        this.timeRemaining=burst;
    }

    public double getFinishedTime() {
        return FinishedTime;
    }

    public void setFinishedTime(double finishedTime) {
        FinishedTime = finishedTime;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }


    public long getBurstTime() {
        return burstTime;
    }

    public long getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(long timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    // Decrement Time Remaining by 1 unit until it reaches 0
    public void decrementTimeRemaining() {
        if (timeRemaining > 0) {
            timeRemaining--;
        }
    }

    // Print Process ID, Arrival Time, Burst Time, and Time Remaining
    @Override
    public String toString() {
        return "Process{" +
                "processID=" + processID +
                ", arrivalTime=" + arrivalTime +
                ", burstTime=" + burstTime +
                ", timeRemaining=" + timeRemaining +
                '}';
    }

    // Compare Arrival Time of two Processes for sorting
    @Override
    public int compareTo(Process o) {
        if (this.arrivalTime > o.arrivalTime)
            return 1;
        else if (this.arrivalTime == o.arrivalTime) {
            return 0;
        }else
            return -1;
    }
}