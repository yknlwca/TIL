package boj;

import java.util.Scanner;

public class Boj1018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int minRepaint = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaint = reDraw(board, i, j);
                minRepaint = Math.min(minRepaint, repaint);
            }
        }

        System.out.println(minRepaint);

        scanner.close();
    }

    private static int reDraw(char[][] board, int x, int y) {
        char startColor = board[x][y];
        int repaint = 0;


        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // 현재 칸의 색이 시작 칸의 색과 다르면 다시 칠하기
                if (board[i][j] != startColor) {
                    repaint++;
                }
                // 다음 칸의 색은 시작 칸의 색과 반대
                // W면 B 아니면 W
                startColor = (startColor == 'W') ? 'B' : 'W';
            }
            // 체스판의 다음 줄에서는 시작 색 반대
            startColor = (startColor == 'W') ? 'B' : 'W';
        }

        // 더 작은 값 반환
        return Math.min(repaint, 64 - repaint);
    }
}
