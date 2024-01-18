import java.util.*;

public class RR {

    // private List RR;
    private List<Process> RR;

    //the quantum time
    private int quantum = 20;

    //the current time
    private long coreentTime = 0;

    //constructor to initialize the RR list and the quantum time
    public RR(int quantum) {
        this.RR = new LinkedList<>();
        this.quantum = quantum;
        coreentTime = 0;
        index =0;
    }

    //to check if the RR list is empty or not
    int stillSize = 0;
    //to check the index of the process
    int index = 0;
    //main function to execute the RR scheduling
    public void RR_Scheduling (Process[] processes) {
        //to initialize the current time
        coreentTime= 0;
        //to add the processes to the RR list
        RR.addAll(Arrays.asList(processes));
        //to sort the RR list according to the arrival time
        Collections.sort(RR);
        //to get the size of the RR list
        stillSize = RR.size();
        index = 0;

        //to check if the RR list is empty or not
        while (stillSize > 0) {
            //to check if the arrival time of the process is less than the current time
           if (RR.get(index).getArrivalTime() <= coreentTime) {
               execution(RR.get(index));
           } else {
               //to check if the arrival time of the process is greater than the current time
               if (RR.get(index).getArrivalTime() > coreentTime && RR.get(0).getArrivalTime() > coreentTime){
                   //to add the difference between the arrival time of the first process and the current time to the current time
                   coreentTime += RR.get(0).getArrivalTime() - coreentTime;
               }else {
                   index =0;
               }
           }
        }
    }

    //to execute the process
    public void execution(Process process) {
        //to check if the time remaining of the process is greater than the quantum time
        if (process.getTimeRemaining() > quantum) {
            System.out.println("Executing Process " + process.getProcessID() + "...");
            //to add the quantum time to the current time
            coreentTime += quantum;
            //to subtract the quantum time from the time remaining of the process
            process.setTimeRemaining(process.getTimeRemaining() - quantum);
            System.out.println("Process " + process.getProcessID() + " Time Remaining: " + process.getTimeRemaining());
            //to check if the index is greater than the size of the RR list
                if (index+1 >= stillSize){
                    index=0;
                }else {
                    index++;
                }
        }
        //to check if the time remaining of the process is less than the quantum time
        else {
            System.out.println("Executing Process " + process.getProcessID() + "...");
            //to add the time remaining of the process to the current time
            coreentTime += process.getTimeRemaining();
            process.setTimeRemaining(0);
            //to set the finished time of the process
            process.setFinishedTime(coreentTime);
            stillSize--;
            //to remove the process from the RR list
            RR.remove(process);
            System.out.println("Executing Process " + process.getProcessID() +" Complete");
            if (index >= stillSize) {
                index = 0;
            }
        }
    }


    public void RR_SchedulingNotPrinted (Process[] processes) {
        coreentTime= 0;
        RR.addAll(Arrays.asList(processes));
        Collections.sort(RR);
        stillSize = RR.size();
        index = 0;

        while (stillSize > 0) {
            if (RR.get(index).getArrivalTime() <= coreentTime) {
                executionNotPrinted(RR.get(index));
            } else {
                if (RR.get(index).getArrivalTime() > coreentTime && RR.get(0).getArrivalTime() > coreentTime){
                    coreentTime += RR.get(0).getArrivalTime() - coreentTime;
                }else {
                    index =0;
                }
            }
        }
    }

    public void executionNotPrinted(Process process) {
        if (process.getTimeRemaining() > quantum) {
            coreentTime += quantum;
            process.setTimeRemaining(process.getTimeRemaining() - quantum);
            if (index+1 >= stillSize){
                index=0;
            }else {
                index++;
            }
        } else {
            coreentTime += process.getTimeRemaining();
            process.setTimeRemaining(0);
            process.setFinishedTime(coreentTime);
            stillSize--;
            RR.remove(process);
            if (index >= stillSize) {
                index = 0;
            }
        }
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