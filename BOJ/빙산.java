package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산 {
    static BufferedReader bf;
    static StringTokenizer st;
    static int[][] board;
    static boolean[][] visited;
    static int N, M;
    static Queue<int[]> q;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int bfs(int row, int column) {
        q.add(new int[]{row, column});
        visited[row][column] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < dr.length; i++) {
                int nRow = tmp[0] + dr[i];
                int nColumn = tmp[1] + dc[i];
                if (0 <= nRow && nRow < N && 0 <= nColumn && nColumn < M && board[nRow][nColumn] > 0 && !visited[nRow][nColumn]) {
                    visited[nRow][nColumn] = true;
                    q.add(new int[]{nRow, nColumn});
                }
            }
        }

        return 1;
    }

    static int countIce() {
        // 빙산 세기
        // 방문 하지 않고 빙산이 있다 -> bfs 돌려
        visited = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0 && !visited[i][j]) {
                    cnt += bfs(i, j);
                }
            }
        }
        // 총 빙산의 개수
        return cnt;
    }

    static void meltIce() {
        int[][] tmpBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    // 얼음 주위가 물인 곳
                    int zeroCnt = 0;
                    for (int d = 0; d < dr.length; d++) {
                        int nRow = i + dr[d];
                        int nColumn = j + dc[d];
                        if (0 <= nRow && nRow < N && 0 <= nColumn && nColumn < M) {
                            if (board[nRow][nColumn] == 0) {
                                zeroCnt++;
                            }
                        }
                    }
                    // 사방면 중 물인 것 개수 빼주기
                    tmpBoard[i][j] = Math.max(board[i][j] - zeroCnt, 0);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            // 임시배열 복사 하기
            System.arraycopy(tmpBoard[i], 0, board[i], 0, M);
        }
    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while (true) {
            int cnt = countIce();
            if (cnt >= 2) {
                System.out.println(years);
                break;
            } else if (cnt == 0) {
                System.out.println(0);
                break;
            }
            // 2개가 될때 까지 녹는 로직
            meltIce();
            years++;
        }
    }
}
