package boj;

import java.util.Scanner;


public class Boj2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int count = 1;
        int range = 6;
        int start = 2;

        while (start <= N) {
            start += range;
            range += 6;
            count++;
        }

        System.out.println(count);
        scanner.close();
    }
}
