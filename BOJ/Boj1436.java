package boj;

import java.util.Scanner;

public class Boj1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 666;
        int cnt = 0;

        while (true) {
            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
            if (cnt == N) {
                System.out.println(num);
                break;
            }
            num++;
        }
        sc.close();
    }
}
