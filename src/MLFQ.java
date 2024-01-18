import java.util.*;

public class MLFQ {

    // queue10: 10 burst time the highest priority
    private Queue<Process> queue10;

    // queue50: 50 burst time the second highest priority
    private Queue<Process> queue50;

    // queueFCFS: the lowest priority
    private Queue<Process> queueFCFS;

    // currentTime: the current time of the CPU
    private long currentTime = 0;

    // averageTurnaroundTime: the average turnaround time of the processes
    double averageTurnaroundTime =0;

    // averageWaitingTime: the average waiting time of the processes
    double averageWaitingTime =0;

    // to initialize the queues
    public MLFQ() {
        queue10 = new LinkedList<>();
        queue50 = new LinkedList<>();
        queueFCFS = new LinkedList<>();
    }

    // the main function of the MLFQ algorithm
    public void MLFQ_Scheduling(Process[] pros) {
        currentTime = 0;
        // to sort the processes according to their arrival time
        List<Process> Processes = new ArrayList<>(Arrays.asList(pros));
        Collections.sort(Processes);

        currentTime = Processes.get(0).getArrivalTime();

        while (!Processes.isEmpty()  || !queue10.isEmpty() || !queue50.isEmpty() || !queueFCFS.isEmpty()) {
            if (!Processes.isEmpty() && Processes.get(0).getArrivalTime() <= currentTime) {
                queue10.add(Processes.get(0));
                // to remove the process from the list of processes
                Processes.remove(0);
            }

            // to check if the queue10 is not empty
            if (!queue10.isEmpty()) {
                Process currentProcess = queue10.poll();
                if (currentProcess.getTimeRemaining() > 10) {
                    // to check if the time remaining of the process is greater than 10
                    System.out.println("Executing Process " + currentProcess.getProcessID() + "...");
                    currentTime += 10;
                    currentProcess.setTimeRemaining(currentProcess.getTimeRemaining() - 10);
                    System.out.println("Process " + currentProcess.getProcessID() + " Paused.");
                    queue50.add(currentProcess);
                } else {
                    // to check if the time remaining of the process is less than or equal to 10
                    System.out.println("Executing Process " + currentProcess.getProcessID() + "...");
                    currentTime += currentProcess.getTimeRemaining();
                    currentProcess.setTimeRemaining(0);
                    System.out.println("Process " + currentProcess.getProcessID() + " Execution Completed.");
                    currentProcess.setFinishedTime(currentTime);
                }
            }
            // to check if the queue50 is not empty
            else if (!queue50.isEmpty()) {
                // to get the process from the queue50
                Process currentProcess = queue50.poll();
                // to check if the time remaining of the process is greater than 50
                if (currentProcess.getTimeRemaining() > 50) {
                    System.out.println("Executing Process " + currentProcess.getProcessID() + "...");
                    currentTime += 50;
                    currentProcess.setTimeRemaining(currentProcess.getTimeRemaining() - 50);
                    System.out.println("Process " + currentProcess.getProcessID() + " Paused.");
                    queueFCFS.add(currentProcess);
                }
                // to check if the time remaining of the process is less than or equal to 50
                else {
                    System.out.println("Executing Process " + currentProcess.getProcessID() + "...");
                    currentTime += currentProcess.getTimeRemaining();
                    currentProcess.setTimeRemaining(0);
                    currentProcess.setFinishedTime(currentTime);
                    System.out.println("Process " + currentProcess.getProcessID() + " Execution Completed.");
                }
            }
            // to check if the queueFCFS is not empty
            else if (!queueFCFS.isEmpty()) {
                Process currentProcess = queueFCFS.poll();
                System.out.println("Executing Process " + currentProcess.getProcessID() + "...");
                currentTime += currentProcess.getTimeRemaining();
                currentProcess.setTimeRemaining(0);
                System.out.println("Process " + currentProcess.getProcessID() + " Execution Completed.");
                currentProcess.setFinishedTime(currentTime);
            }
            // to check if all the queues but not the list of processes are empty
            // so the CPU is waiting for processes
            else {
                currentTime++;
                System.out.println("CPU waiting for Processes...");
            }
        }
    }

    public void MLFQ_SchedulingNotPrinted(Process[] pros) {
        currentTime = 0;
        List<Process> Processes = new ArrayList<>(Arrays.asList(pros));
        Collections.sort(Processes);

        currentTime = Processes.get(0).getArrivalTime();

        while (!Processes.isEmpty()  || !queue10.isEmpty() || !queue50.isEmpty() || !queueFCFS.isEmpty()) {
            if (!Processes.isEmpty() && Processes.get(0).getArrivalTime() <= currentTime) {
                queue10.add(Processes.get(0));
                Processes.remove(0);
            }

            if (!queue10.isEmpty()) {
                Process currentProcess = queue10.poll();
                if (currentProcess.getTimeRemaining() > 10) {
                    currentTime += 10;
                    currentProcess.setTimeRemaining(currentProcess.getTimeRemaining() - 10);
                    queue50.add(currentProcess);
                } else {
                    currentTime += currentProcess.getTimeRemaining();
                    currentProcess.setTimeRemaining(0);
                    currentProcess.setFinishedTime(currentTime);
                }
            } else if (!queue50.isEmpty()) {
                Process currentProcess = queue50.poll();
                if (currentProcess.getTimeRemaining() > 50) {
                    currentTime += 50;
                    currentProcess.setTimeRemaining(currentProcess.getTimeRemaining() - 50);
                    queueFCFS.add(currentProcess);
                } else {
                    currentTime += currentProcess.getTimeRemaining();
                    currentProcess.setTimeRemaining(0);
                    currentProcess.setFinishedTime(currentTime);
                }
            } else if (!queueFCFS.isEmpty()) {
                Process currentProcess = queueFCFS.poll();
                currentTime += currentProcess.getTimeRemaining();
                currentProcess.setTimeRemaining(0);
                currentProcess.setFinishedTime(currentTime);
            }else {
                currentTime++;
            }
        }
    }

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
        averageTurnaroundTime =0;
        averageWaitingTime =0;
        for (Process process : processes) {
            totalTurnaroundTime += (long) (process.getFinishedTime() - process.getArrivalTime());
            totalWaitingTime += (long) (process.getFinishedTime() - process.getArrivalTime() - process.getBurstTime());
        }
        averageTurnaroundTime = (double) totalTurnaroundTime / processes.length;
        averageWaitingTime = (double) totalWaitingTime / processes.length;
    }
}


