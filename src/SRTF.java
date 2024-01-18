import java.util.*;

public class SRTF {

    // SRTF is a preemptive scheduling algorithm
    private PriorityQueue<Process> SRTF;

    //SRTFtoArrival is List of processes that will sort based on arrival time
    private List<Process> SRTFtoArrival;

    // currentTime is the current time of the system
    private long currentTime = 0;

    // constructor to initialize the SRTF queue and the currentTime
    public SRTF(){
        SRTF = new PriorityQueue<>(Comparator.comparingLong(Process::getTimeRemaining));
        currentTime = 0;
        SRTFtoArrival = new LinkedList<>();
    }

    // SRTF_Scheduling is the function that implements the SRTF algorithm
    public void SRTF_Scheduling(Process[] processes) {
        currentTime = 0;
        // to add all the processes to the SRTFtoArrival list
        for (Process process : processes) {
            process.setTimeRemaining(process.getBurstTime());
            SRTFtoArrival.add(process);
        }

        // to sort the SRTFtoArrival list based on the arrival time
        Collections.sort(SRTFtoArrival);

        // to loop until the SRTFtoArrival list and the SRTF queue are empty
        while (!SRTFtoArrival.isEmpty() || !SRTF.isEmpty()) {
            // to add the processes that arrived to the SRTF queue
            while (!SRTFtoArrival.isEmpty() && SRTFtoArrival.get(0).getArrivalTime() <= currentTime) {
                SRTF.add(SRTFtoArrival.get(0));
                SRTFtoArrival.remove(SRTFtoArrival.get(0));
            }

            // to check if the SRTF queue is empty and the SRTFtoArrival list is not empty
            if (!SRTFtoArrival.isEmpty() && SRTF.isEmpty()) {
                currentTime = SRTFtoArrival.get(0).getArrivalTime();
                SRTF.add(SRTFtoArrival.get(0));
                SRTFtoArrival.remove(SRTFtoArrival.get(0));
            }

            // to get the current process
            Process currentProcess = SRTF.poll();

            // to execute the current process
            boolean isFiniseh = executeProcess(currentProcess);

            // to check if the current process is finished
            if (isFiniseh) {
                currentProcess.setFinishedTime(currentTime);
                SRTF.remove(currentProcess);
            } else {
                // to add the current process to the SRTF queue
                SRTF.add(currentProcess);
            }
        }
    }

    // to execute the current process
    private boolean executeProcess(Process process) {
        System.out.println("Executing Process " + process.getProcessID() + "...");
        process.decrementTimeRemaining();
        currentTime++;
        System.out.println("Process " + process.getProcessID() + " Time Remaining: " + process.getTimeRemaining());
        if (process.getTimeRemaining() == 0) {
            System.out.println("Process " + process.getProcessID() + " Finished!");
            return true;
        }
        return false;
    }


    public void SRTF_SchedulingNotPrinted(Process[] processes) {
        currentTime = 0;
        for (Process process : processes) {
            process.setTimeRemaining(process.getBurstTime());
            SRTFtoArrival.add(process);
        }

        Collections.sort(SRTFtoArrival);

        while (!SRTFtoArrival.isEmpty() || !SRTF.isEmpty()) {
            while (!SRTFtoArrival.isEmpty() && SRTFtoArrival.get(0).getArrivalTime() <= currentTime) {
                SRTF.add(SRTFtoArrival.get(0));
                SRTFtoArrival.remove(SRTFtoArrival.get(0));
            }

            if (!SRTFtoArrival.isEmpty() && SRTF.isEmpty()) {
                currentTime = SRTFtoArrival.get(0).getArrivalTime();
                SRTF.add(SRTFtoArrival.get(0));
                SRTFtoArrival.remove(SRTFtoArrival.get(0));
            }

            Process currentProcess = SRTF.poll();
            boolean isFiniseh = executeProcessNotPrinted(currentProcess);
            if (isFiniseh) {
                currentProcess.setFinishedTime(currentTime);
                SRTF.remove(currentProcess);
            } else {
                SRTF.add(currentProcess);
            }
        }
    }

    private boolean executeProcessNotPrinted(Process process) {
        process.decrementTimeRemaining();
        currentTime++;
        if (process.getTimeRemaining() == 0) {
            return true;
        }
        return false;
    }

    public double averageTurnaroundTime = 0;
    public double averageWaitingTime = 0;
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

    public void ClcNotPrinted(Process[] processes) {
        long totalTurnaroundTime = 0;
        long totalWaitingTime = 0;
        averageWaitingTime = 0;
        averageTurnaroundTime = 0;
        for (Process process : processes) {
            totalTurnaroundTime += (long) (process.getFinishedTime() - process.getArrivalTime());
            totalWaitingTime += (long) ((process.getFinishedTime() - process.getArrivalTime()) - process.getBurstTime());
        }
        averageTurnaroundTime = (double) totalTurnaroundTime / processes.length;
        averageWaitingTime = (double) totalWaitingTime / processes.length;
    }
}
