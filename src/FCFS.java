
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FCFS {

    //private Queue FCFS
    private Queue<Process> FCFS;

    //private long currentTime
    private long currentTime = 0;

    //constructor FCFS initialize FCFS and currentTime
    public FCFS(){
        FCFS = new LinkedList<>();
        currentTime = 0;
    }

    //method FCFS_Scheduling
    public void FCFS_Scheduling(Process[] processes) {
        currentTime = 0;
        //sort processes by arrival time
        Arrays.sort(processes);
        //add processes to FCFS
        FCFS.addAll(Arrays.asList(processes));

        //while FCFS is not empty
        while (!FCFS.isEmpty()) {
            //peek the first process in FCFS
            Process currentProcess = FCFS.peek();
            //if the arrival time of the first process in FCFS is less than or equal to currentTime
            if (currentProcess.getArrivalTime() <= currentTime) {
                executeProcess(FCFS.poll());
            } else {
                //add the difference between the arrival time of the first process in FCFS and currentTime to currentTime
                currentTime += currentProcess.getArrivalTime() - currentTime;
            }
        }
    }

    //method executeProcess
    private void executeProcess(Process process) {
        System.out.println("Executing Process " + process.getProcessID() + "...");
        //add the burst time of the process to currentTime
        currentTime += process.getBurstTime();
        //set the finished time of the process to currentTime
        process.setFinishedTime(currentTime);
        System.out.println("Process " + process.getProcessID() + " Execution Completed.");
    }


    public void FCFS_SchedulingNotPrinted(Process[] processes) {
        currentTime = 0;
        Arrays.sort(processes);
        FCFS.addAll(Arrays.asList(processes));

        while (!FCFS.isEmpty()) {
            Process currentProcess = FCFS.peek();
            if (currentProcess.getArrivalTime() <= currentTime) {
                executeProcessNotPrinted(FCFS.poll());
            } else {
                currentTime += currentProcess.getArrivalTime() - currentTime;
            }
        }
    }

    private void executeProcessNotPrinted(Process process) {
        currentTime += process.getBurstTime();
        process.setFinishedTime(currentTime);
    }

    public double averageTurnaroundTime =0;
    public double averageWaitingTime =0;

    public void Clc(Process[] processes) {
        // to calculate the total turnaround time and the average waiting time
        long totalTurnaroundTime = 0;
        // to calculate the total waiting time and the average waiting time
        long totalWaitingTime = 0;
        // to calculate the average turnaround time
        averageTurnaroundTime =0;
        // to calculate the average waiting time
        averageWaitingTime =0;
        // to calculate the total turnaround time and the total waiting time
        for (Process process : processes) {
            totalTurnaroundTime += (long) (process.getFinishedTime() - process.getArrivalTime());
            totalWaitingTime += (long) (process.getFinishedTime() - process.getArrivalTime() - process.getBurstTime());
        }
        // to calculate the average turnaround time
        averageTurnaroundTime = (double) totalTurnaroundTime / processes.length;
        // to calculate the average waiting time
        averageWaitingTime = (double) totalWaitingTime / processes.length;
        System.out.println("MLFQ - Average Turnaround Time: " + averageTurnaroundTime);
        System.out.println("MLFQ - Average Waiting Time: " + averageWaitingTime);
    }

    public void ClacNotPrinted(Process[] processes) {
        long totalTurnaroundTime = 0;
        long totalWaitingTime = 0;
        averageWaitingTime =0;
        averageTurnaroundTime =0;
        for (Process process : processes) {
            totalTurnaroundTime += (long) (process.getFinishedTime() - process.getArrivalTime());
            totalWaitingTime += (long) ((process.getFinishedTime() - process.getArrivalTime()) - process.getBurstTime());
        }
        averageTurnaroundTime = (double) totalTurnaroundTime / processes.length;
        averageWaitingTime = (double) totalWaitingTime / processes.length;
    }
}
