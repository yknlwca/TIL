package boj;

import java.util.Scanner;

public class Boj7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt(); // 몸무게
            people[i][1] = sc.nextInt(); // 키
        }


        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            int count = 0; // 더 큰 덩치의 사람 수를 카운트
            for (int j = 0; j < N; j++) {
                if (i == j) continue; // 자기 자신은 비교 안하기
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    count++;
                }
            }
            rank[i] = count + 1; // 앞 사람 + 1
        }

        for (int i = 0; i < N; i++) {
            System.out.print(rank[i] + " ");
        }
        sc.close();
    }
}
