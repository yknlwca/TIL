package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제
//2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오.
// 배열의 (i, j) 위치는 i행 j열을 나타낸다.
//
//입력
//첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다.
// 다음 N개의 줄에는 M개의 정수로 배열이 주어진다.
// 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다.
// 그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다.
// 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M).
//
//출력
//K개의 줄에 순서대로 배열의 합을 출력한다. 배열의 합은 231-1보다 작거나 같다.
public class Boj2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M]; // (N,M) 행렬 생성

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(bf.readLine()); // 행을 입력받을 때 마다 새로운 인스턴스 생성하는거 까먹지마라
            for (int column = 0; column < M; column++) {
                arr[row][column] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());

        for (int o = 0; o < K; o++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int row = i - 1; row <= x - 1; row++) { // 수학 행렬 접근이므로 -1 씩
                for (int column = j - 1; column <= y - 1; column++) {
                    sum += arr[row][column];
                }
            }
            System.out.println(sum);
        }
    }
}
