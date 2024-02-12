package boj;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int row = 0;
            int column = 0;
            int num = 1;
            int N = Integer.parseInt(bf.readLine());
            int[][] snailArr = new int[N][N];
            int direction = 0; // 0 오른 1 아래 2왼 3위
            int turn = N;

            while (num <= N * N) {
                snailArr[row][column] = num++;

                if (direction == 0 && column == turn - 1) {
                    direction++;
                    turn--;
                } else if (direction == 1 && row == turn)
                    direction++;
                else if (direction == 2 && column == N - turn -1)
                    direction++;
                else if (direction == 3 && row == N - turn)
                    direction = 0;


                if (direction == 0)
                    column++;
                else if (direction == 1)
                    row++;
                else if (direction == 2)
                    column--;
                else
                    row--;

            }
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    sb.append(snailArr[r][c]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println("#" + (i + 1));
            System.out.print(sb.toString());
        }
    }
}


