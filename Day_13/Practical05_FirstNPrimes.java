import java.util.Scanner;

public class Practical05_FirstNPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int num = 2;

        while (count < n) {
            int i;
            for (i = 2; i < num; i++) {
                if (num % i == 0) {
                    break;
                }
            }
            if (i == num) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }

        sc.close();
    }
}