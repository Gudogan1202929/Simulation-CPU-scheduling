import java.util.Arrays;

public class Main {

    //those arrays to save the average of each algorithm to print it in the table
    public static double[][] FCFS_Avg = new double[5][2];
    public static double[][] RR_Avg = new double[5][2];
    public static double[][] SRTF_Avg = new double[5][2];
    public static double[][] MLFQ_Avg = new double[5][2];

    public static void main(String[] args) {

        //those arrays to save the process that created randomly
        Process[][] processes11 = new Process[1][8];
        Process[][] processesCopy12 = new Process[1][8];
        Process[][] processesCopy13 = new Process[1][8];
        Process[][] processesCopy14 = new Process[1][8];

        Process[][] processes21 = new Process[100][8];
        Process[][] processesCopy22 = new Process[100][8];
        Process[][] processesCopy23 = new Process[100][8];
        Process[][] processesCopy24 = new Process[100][8];

        Process[][] processes31 = new Process[1000][8];
        Process[][] processesCopy32 = new Process[1000][8];
        Process[][] processesCopy33 = new Process[1000][8];
        Process[][] processesCopy34 = new Process[1000][8];

        Process[][] processes41 = new Process[10000][8];
        Process[][] processesCopy42 = new Process[10000][8];
        Process[][] processesCopy43 = new Process[10000][8];
        Process[][] processesCopy44 = new Process[10000][8];

        Process[][] processes51 = new Process[100000][8];
        Process[][] processesCopy52 = new Process[100000][8];
        Process[][] processesCopy53 = new Process[100000][8];
        Process[][] processesCopy54 = new Process[100000][8];


        //this loop to create the process randomly on the burst time and the arrival time
        for (int i = 0; i < 8; i++) {
            int BurstTime = (int)(Math.random()*95) + 5;
            int ArrivalTime = (int)(Math.random()*95) + 5;
            processes11[0][i] = new Process(i, ArrivalTime, BurstTime);
            processesCopy12[0][i] = new Process(i, ArrivalTime, BurstTime);
            processesCopy13[0][i] = new Process(i, ArrivalTime, BurstTime);
            processesCopy14[0][i] = new Process(i, ArrivalTime, BurstTime);
        }

        //this loop to create the process randomly with arrival time and burst time on 100 time each 1 is 8 process
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 8; j++) {
                int BurstTime = (int)(Math.random()*95) + 5;
                int ArrivalTime = (int)(Math.random()*95) + 5;
                processes21[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy22[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy23[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy24[i][j] = new Process(j, ArrivalTime, BurstTime);
            }
        }

        //this loop to create the process randomly with arrival time and burst time on 1000 time each 1 is 8 process
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 8; j++) {
                int BurstTime = (int)(Math.random()*95) + 5;
                int ArrivalTime = (int)(Math.random()*95) + 5;
                processes31[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy32[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy33[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy34[i][j] = new Process(j, ArrivalTime, BurstTime);
            }
        }

        //this loop to create the process randomly with arrival time and burst time on 10000 time each 1 is 8 process
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 8; j++) {
                int BurstTime = (int)(Math.random()*95) + 5;
                int ArrivalTime = (int)(Math.random()*95) + 5;
                processes41[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy42[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy43[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy44[i][j] = new Process(j, ArrivalTime, BurstTime);
            }
        }

        //this loop to create the process randomly with arrival time and burst time on 100000 time each 1 is 8 process
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 8; j++) {
                int BurstTime = (int)(Math.random()*95) + 5;
                int ArrivalTime = (int)(Math.random()*95) + 5;
                processes51[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy52[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy53[i][j] = new Process(j, ArrivalTime, BurstTime);
                processesCopy54[i][j] = new Process(j, ArrivalTime, BurstTime);
            }
        }

        System.out.println();
        System.out.println("FCFS");
        System.out.println();
        //this function to run the FCFS algorithm on each arrays process that created randomly on 8 100 1000 10000 100000
        FCFS(processes11,processes21,processes31,processes41,processes51);
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("RR");
        System.out.println();
        //this function to run the RR algorithm on each arrays process that created randomly on 8 100 1000 10000 100000
        RR(processesCopy12,processesCopy22,processesCopy32,processesCopy42,processesCopy52);
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("MLFQ");
        System.out.println();
        //this function to run the MLFQ algorithm on each arrays process that created randomly on 8 100 1000 10000 100000
        MLFQ(processesCopy13,processesCopy23,processesCopy33,processesCopy43,processesCopy53);
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("SRTF");
        System.out.println();
        //this function to run the SRTF algorithm on each arrays process that created randomly on 8 100 1000 10000 100000
        SRTF(processesCopy14,processesCopy24,processesCopy34,processesCopy44,processesCopy54);

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println();

        //print the table of ATT , AWT for each algorithm
        printTable("FCFS", FCFS_Avg);
        printTable("RR", RR_Avg);
        printTable("SRTF", SRTF_Avg);
        printTable("MLFQ", MLFQ_Avg);

        System.out.println("But you must know the 8 (1 time) process for step 2 is random on the arrival time and buerst time \n" +
                "and the other process is random on the arrival time and the burst time \n" +
                "and the process above that you seen running and paused and Executed is the 8 process for each algorithm \n"
                +"and the other process is not printed \n"+
                "the tables above it AWT & ATT for each algorithm on (100 1000 10000 100000) Time of process that created randomly   \n");
    }

    //this function to run the FCFS algorithm on each arrays process that created randomly on 8 100 1000 10000 100000
    static void FCFS(Process[][] processes1,Process[][] processes2,Process[][] processes3,Process[][] processes4,Process[][] processes5) {

        //create object from FCFS class
        FCFS fcfs = new FCFS();
        //this array to save the 8 process that created randomly
        Process []p1 = processes1[0];
        //this function to run the FCFS algorithm on the 8 process that created randomly
        fcfs.FCFS_Scheduling(p1);
        //this function to calculate the ATT & AWT for the 8 process that created randomly
        fcfs.Clc(p1);
        //save the ATT & AWT for the 8 process that created randomly in the array
        FCFS_Avg[0][0] = fcfs.averageWaitingTime;
        FCFS_Avg[0][1] = fcfs.averageTurnaroundTime;

        FCFS fcfs2 = new FCFS();
        double sum100ATT = 0;
        double sum100AWT = 0;
        //this loop to run the FCFS algorithm 100 times on 8 process that created randomly
        //and take the average of ATT & AWT for the 100 times
        for (int i=0;i<100;i++){
            Process []p2 = processes2[i];
            fcfs2.FCFS_SchedulingNotPrinted(p2);
            fcfs2.ClacNotPrinted(p2);
            sum100ATT += fcfs2.averageTurnaroundTime;
            sum100AWT += fcfs2.averageWaitingTime;
        }
        //save the avareg ATT & AWT for the 100 process that created randomly in the array
        FCFS_Avg[1][0] = (double)(sum100AWT/100);
        FCFS_Avg[1][1] = (double)(sum100ATT/100);

        FCFS fcfs3 = new FCFS();
        double sum1000ATT = 0;
        double sum1000AWT = 0;
        for (int i=0;i<1000;i++){
            Process []p3 = processes3[i];
            fcfs3.FCFS_SchedulingNotPrinted(p3);
            fcfs3.ClacNotPrinted(p3);
            sum1000ATT += fcfs3.averageTurnaroundTime;
            sum1000AWT += fcfs3.averageWaitingTime;
        }
        FCFS_Avg[2][0] = (double)(sum1000AWT/1000);
        FCFS_Avg[2][1] = (double)(sum1000ATT/1000);


        FCFS fcfs4 = new FCFS();
        double sum10000ATT = 0;
        double sum10000AWT = 0;
        for (int i=0;i<10000;i++){
            Process []p4 = processes4[i];
            fcfs4.FCFS_SchedulingNotPrinted(p4);
            fcfs4.ClacNotPrinted(p4);
            sum10000ATT += fcfs4.averageTurnaroundTime;
            sum10000AWT += fcfs4.averageWaitingTime;
        }
        FCFS_Avg[3][0] = (double)(sum10000AWT/10000);
        FCFS_Avg[3][1] = (double)(sum10000ATT/10000);

        FCFS fcfs5 = new FCFS();
        double sum100000ATT = 0;
        double sum100000AWT = 0;
        for (int i=0;i<100000;i++){
            Process []p5 = processes5[i];
            fcfs5.FCFS_SchedulingNotPrinted(p5);
            fcfs5.ClacNotPrinted(p5);
            sum100000ATT += fcfs5.averageTurnaroundTime;
            sum100000AWT += fcfs5.averageWaitingTime;
        }
        FCFS_Avg[4][0] = (double)(sum100000AWT/100000);
        FCFS_Avg[4][1] = (double)(sum100000ATT/100000);
    }


    //this function to run the RR algorithm on each arrays process that created randomly on 8 100 1000 10000 100000
    static void SRTF(Process[][] processes1,Process[][] processes2,Process[][] processes3,Process[][] processes4,Process[][] processes5) {

        SRTF srtf = new SRTF();
        Process []p1 = processes1[0];
        srtf.SRTF_Scheduling(p1);
        srtf.Clc(p1);
        SRTF_Avg[0][0] = srtf.averageWaitingTime;
        SRTF_Avg[0][1] = srtf.averageTurnaroundTime;

        SRTF srtf2 = new SRTF();
        double sum100ATT = 0;
        double sum100AWT = 0;
        for (int i=0;i<100;i++){
            Process []p2 = processes2[i];
            srtf2.SRTF_SchedulingNotPrinted(p2);
            srtf2.ClcNotPrinted(p2);
            sum100ATT += srtf2.averageTurnaroundTime;
            sum100AWT += srtf2.averageWaitingTime;
        }
        SRTF_Avg[1][0] = (double)(sum100AWT/100);
        SRTF_Avg[1][1] = (double)(sum100ATT/100);


        SRTF srtf3 = new SRTF();
        double sum1000ATT = 0;
        double sum1000AWT = 0;
        for (int i=0;i<1000;i++){
            Process []p3 = processes3[i];
            srtf3.SRTF_SchedulingNotPrinted(p3);
            srtf3.ClcNotPrinted(p3);
            sum1000ATT += srtf3.averageTurnaroundTime;
            sum1000AWT += srtf3.averageWaitingTime;
        }
        SRTF_Avg[2][0] = (double)(sum1000AWT/1000);
        SRTF_Avg[2][1] = (double)(sum1000ATT/1000);


        SRTF srtf4 = new SRTF();
        double sum10000ATT = 0;
        double sum10000AWT = 0;
        for (int i=0;i<10000;i++){
            Process []p4 = processes4[i];
            srtf4.SRTF_SchedulingNotPrinted(p4);
            srtf4.ClcNotPrinted(p4);
            sum10000ATT += srtf4.averageTurnaroundTime;
            sum10000AWT += srtf4.averageWaitingTime;
        }
        SRTF_Avg[3][0] = (double)(sum10000AWT/10000);
        SRTF_Avg[3][1] = (double)(sum10000ATT/10000);

        SRTF srtf5 = new SRTF();
        double sum100000ATT = 0;
        double sum100000AWT = 0;
        for (int i=0;i<100000;i++){
            Process []p5 = processes5[i];
            srtf5.SRTF_SchedulingNotPrinted(p5);
            srtf5.ClcNotPrinted(p5);
            sum100000ATT += srtf5.averageTurnaroundTime;
            sum100000AWT += srtf5.averageWaitingTime;
        }
        SRTF_Avg[4][0] = (double)(sum100000AWT/100000);
        SRTF_Avg[4][1] = (double)(sum100000ATT/100000);
    }

    //this function to run the RR algorithm on each arrays process that created randomly on 8 100 1000 10000 100000
    static void RR(Process[][] processes1,Process[][] processes2,Process[][] processes3,Process[][] processes4,Process[][] processes5) {

        int quantum = 20;
        RR rr = new RR(quantum);
        Process []p1 = processes1[0];
        rr.RR_Scheduling(p1);
        rr.Clc(p1);
        RR_Avg[0][0] = rr.averageWaitingTime;
        RR_Avg[0][1] = rr.averageTurnaroundTime;

        RR rr2 = new RR(quantum);
        double sum100AWT = 0;
        double sum100ATT = 0;
        for (int i = 0; i < 100 ; i++){
            Process []p2 = processes2[i];
            rr2.RR_SchedulingNotPrinted(p2);
            rr2.ClacNotPrinted(p2);
            sum100AWT += rr2.averageWaitingTime;
            sum100ATT += rr2.averageTurnaroundTime;
        }
        RR_Avg[1][0] = (double)(sum100AWT/100);
        RR_Avg[1][1] = (double)(sum100ATT/100);

        RR rr3 = new RR(quantum);
        double sum1000AWT = 0;
        double sum1000ATT = 0;
        for (int i = 0; i < 1000 ; i++){
            Process []p3 = processes3[i];
            rr3.RR_SchedulingNotPrinted(p3);
            rr3.ClacNotPrinted(p3);
            sum1000AWT += rr3.averageWaitingTime;
            sum1000ATT += rr3.averageTurnaroundTime;
        }
        RR_Avg[2][0] = (double)(sum1000AWT/1000);
        RR_Avg[2][1] = (double)(sum1000ATT/1000);

        RR rr4 = new RR(quantum);
        double sum10000AWT = 0;
        double sum10000ATT = 0;
        for (int i = 0; i < 10000 ; i++){
            Process []p4 = processes4[i];
            rr4.RR_SchedulingNotPrinted(p4);
            rr4.ClacNotPrinted(p4);
            sum10000AWT += rr4.averageWaitingTime;
            sum10000ATT += rr4.averageTurnaroundTime;
        }
        RR_Avg[3][0] = (double)(sum10000AWT/10000);
        RR_Avg[3][1] = (double)(sum10000ATT/10000);

        RR rr5 = new RR(quantum);
        double sum100000AWT = 0;
        double sum100000ATT = 0;
        for (int i = 0; i < 100000 ; i++){
            Process []p5 = processes5[i];
            rr5.RR_SchedulingNotPrinted(p5);
            rr5.ClacNotPrinted(p5);
            sum100000AWT += rr5.averageWaitingTime;
            sum100000ATT += rr5.averageTurnaroundTime;
        }
        RR_Avg[4][0] = (double)(sum100000AWT/100000);
        RR_Avg[4][1] = (double)(sum100000ATT/100000);

    }

    //this function to run the MLFQ algorithm on each arrays process that created randomly on 8 100 1000 10000 100000
    static void MLFQ(Process[][] processes1,Process[][] processes2,Process[][] processes3,Process[][] processes4,Process[][] processes5) {

        MLFQ mlfq = new MLFQ();
        Process []p1 = processes1[0];
        mlfq.MLFQ_Scheduling(p1);
        mlfq.Clc(p1);
        MLFQ_Avg[0][0] = mlfq.averageWaitingTime;
        MLFQ_Avg[0][1] = mlfq.averageTurnaroundTime;

        MLFQ mlfq2 = new MLFQ();
        double sum100AWT = 0;
        double sum100ATT = 0;
        for (int i = 0; i < 100 ; i++){
            Process []p2 = processes2[i];
            mlfq2.MLFQ_SchedulingNotPrinted(p2);
            mlfq2.ClcNotPrinted(p2);
            sum100AWT += mlfq2.averageWaitingTime;
            sum100ATT += mlfq2.averageTurnaroundTime;
        }
        MLFQ_Avg[1][0] = (double)(sum100AWT/100);
        MLFQ_Avg[1][1] = (double)(sum100ATT/100);

        MLFQ mlfq3 = new MLFQ();
        double sum1000AWT = 0;
        double sum1000ATT = 0;
        for (int i = 0; i < 1000 ; i++){
            Process []p3 = processes3[i];
            mlfq3.MLFQ_SchedulingNotPrinted(p3);
            mlfq3.ClcNotPrinted(p3);
            sum1000AWT += mlfq3.averageWaitingTime;
            sum1000ATT += mlfq3.averageTurnaroundTime;
        }
        MLFQ_Avg[2][0] = (double)(sum1000AWT/1000);
        MLFQ_Avg[2][1] = (double)(sum1000ATT/1000);

        MLFQ mlfq4 = new MLFQ();
        double sum10000AWT = 0;
        double sum10000ATT = 0;
        for (int i = 0; i < 10000 ; i++){
            Process []p4 = processes4[i];
            mlfq4.MLFQ_SchedulingNotPrinted(p4);
            mlfq4.ClcNotPrinted(p4);
            sum10000AWT += mlfq4.averageWaitingTime;
            sum10000ATT += mlfq4.averageTurnaroundTime;
        }
        MLFQ_Avg[3][0] = (double)(sum10000AWT/10000);
        MLFQ_Avg[3][1] = (double)(sum10000ATT/10000);


        MLFQ mlfq5 = new MLFQ();
        double sum100000AWT = 0;
        double sum100000ATT = 0;
        for (int i = 0; i < 100000 ; i++){
            Process []p5 = processes5[i];
            mlfq5.MLFQ_SchedulingNotPrinted(p5);
            mlfq5.ClcNotPrinted(p5);
            sum100000AWT += mlfq5.averageWaitingTime;
            sum100000ATT += mlfq5.averageTurnaroundTime;
        }
        MLFQ_Avg[4][0] = (double)(sum100000AWT/100000);
        MLFQ_Avg[4][1] = (double)(sum100000ATT/100000);
    }

    //this function to print the table of ATT , AWT for each algorithm
    private static void printTable(String tableName, double[][] data) {
        System.out.println("Table: each Time is 8 process " + tableName);
        System.out.println();
        String[] columnHeaders = {"1 Time", "100 Time", "1000 Time", "10000 Time", "100000 Time"};
        String[] rowHeaders = {"AWT", "ATT"};
        System.out.println(String.format("%-10s     %-10s     %-10s    %-10s   %-10s  %-10s", "", columnHeaders[0], columnHeaders[1], columnHeaders[2], columnHeaders[3], columnHeaders[4]));
        System.out.println(String.format("%-10s     %-10.2f     %-10.2f     %-10.2f     %-10.2f     %-10.2f", rowHeaders[0], data[0][0], data[1][0], data[2][0], data[3][0], data[4][0]));
        System.out.println(String.format("%-10s     %-10.2f     %-10.2f     %-10.2f     %-10.2f     %-10.2f", rowHeaders[1], data[0][1], data[1][1], data[2][1], data[3][1], data[4][1]));
        System.out.println("------------------------------");
        System.out.println();
    }
}