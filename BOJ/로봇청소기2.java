package boj;

import java.io.*;
import java.util.StringTokenizer;

public class 로봇청소기2 {
    static int[][] board;
    static boolean[][] visited;
    static int N, M, cnt = 0;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static BufferedWriter bw;
    static BufferedReader bf;
    static StringTokenizer st;

    static void dfs(int r, int c, int d) {
        if (!visited[r][c]) {
            visited[r][c] = true;
            cnt++;
        }

        boolean clean = false;

        for (int i = 0; i < 4; i++) {
            // 반시계 왼쪽 방향으로 회전하는 법
            int nextD = (d + 3) % 4;
            int nRow = r + dr[nextD];
            int nColumn = c + dc[nextD];

            if (0 <= nRow && nRow < board.length && 0 <= nColumn && nColumn < M && board[nRow][nColumn] == 0 && !visited[nRow][nColumn]) {
                dfs(nRow, nColumn, nextD);
                clean = true;
                break;
            }
            d = nextD;
        }

        // 모든 방향이 청소 되었거나 벽인 겨우
        if (!clean) {
            int backD = (d + 2) % 4; // 후진
            int backR = r + dr[backD];
            int backC = c + dc[backD];

            if (0 <= backR && backR < N && 0 <= backC && backC < M && board[backR][backC] != 1) {
                dfs(backR, backC, d);   // 후진할땐 방향 유지
            }
        }
    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(bf.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(startR, startC, d);
        System.out.println(cnt);
    }
}
