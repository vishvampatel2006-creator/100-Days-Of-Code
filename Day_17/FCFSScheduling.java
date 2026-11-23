package Day_17;
public class FCFSScheduling {
    public static void main(String[] args) {
        int[] processes = {1, 2, 3};
        int[] burstTime = {5, 8, 3};
        int n = processes.length;

        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];

        waitingTime[0] = 0;

        for (int i = 1; i < n; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
        }

        int totalWT = 0, totalTAT = 0;

        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = burstTime[i] + waitingTime[i];
            totalWT += waitingTime[i];
            totalTAT += turnaroundTime[i];
            System.out.println("P" + processes[i] + "\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", (double) totalWT / n);
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTAT / n);
    }
}