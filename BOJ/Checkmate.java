import java.util.Scanner;

public class Checkmate {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] chess = new int[N][N];
            int kingX = sc.nextInt();
            int kingY = sc.nextInt();
            int queenX = sc.nextInt();
            int queenY = sc.nextInt();

            chess[kingX - 1][kingY - 1] = 1;
            chess[queenX - 1][queenY - 1] = 2;

            // 상 하 좌 우 상좌 상우 하우 하좌
            int[] drow = { -1, 1, 0, 0, -1, -1, 1, 1 };
            int[] dcolumn = { 0, 0, -1, 1, -1, 1, 1, -1 };

            boolean checkmate = false;

            for (int d = 0; d < drow.length; d++) {
                int nr = queenX - 1 + drow[d];
                int nc = queenY - 1 + dcolumn[d];

                while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (chess[nr][nc] == 1) {
                        checkmate = true;
                        break;
                    }
                    // if (chess[nr][nc] == 2) {
                    //     break; // 퀸이 블록킹
                    }
                    nr += drow[d];
                    nc += dcolumn[d];
                }
                if (checkmate) break;
            }

            System.out.println("#" + (t + 1) + " " + (checkmate ? 1 : 0));
        }
        sc.close();
    }
}
