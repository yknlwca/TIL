package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static BufferedReader bf;
    static StringTokenizer st;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    // 3차원에서의 위 아래 이동
    static int[] dl = {1, -1};
    // 3차원 배열 생성
    // [layers][row][column]
    static int[][][] board;
    // M 가로 N 세로 H 높이
    static int N, M, H;
    static int row, column, layers, days;
    static int[] tmp;
    static Queue<int[]> q = new LinkedList<>();

    static int bfs() {
        days = 0;
        while (!q.isEmpty()) {
            tmp = q.poll();
            layers = tmp[0];
            row = tmp[1];
            column = tmp[2];
            // 사방탐색 + 3차원의 위 아래
            // 한 층을 먼저 2차원으로 사방탐색을 한 후
            // 또 따로 3차원 레이어를 탐색 해야함 한 번에 할 수 없음
            for (int i = 0; i < dr.length; i++) {
                int nRow = row + dr[i];
                int nColumn = column + dc[i];
                if (0 <= nRow && nRow < N && 0 <= nColumn && nColumn < M) {
                    if (board[layers][nRow][nColumn] == 0) {
                        q.add(new int[]{layers, nRow, nColumn});
                        board[layers][nRow][nColumn] = board[layers][row][column] + 1;
                    }
                }
            }

            // 3차원 위아래 탐색
            for (int i = 0; i < dl.length; i++) {
                int nLayers = layers + dl[i];
                if (0 <= nLayers && nLayers < H) {
                    if (board[nLayers][row][column] == 0) {
                        q.add(new int[]{nLayers, row, column});
                        board[nLayers][row][column] = board[layers][row][column] + 1;
                    }
                }
            }
        }

        for (int k = 0; k < board.length; k++) {
            for (int i = 0; i < board[k].length; i++) {
                for (int j = 0; j < board[k][i].length; j++) {
                    if (board[k][i][j] == 0) {
                        return -1;
                    } else {
                        days = Math.max(days, board[k][i][j]);
                    }
                }
            }
        }

        // 1이면 아무 변화가 없었다는 것 => 애초에 모든 토마토가 익었다는 것
        if (days == 1) {
            return 0;
        } else {
            // 1부터 시작이니 -1 해줌
            return days - 1;
        }
    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][N][M];

        // 입력 받기
        // 3차원 배열에서 통상적으로 z축 layer는 첫 번째로 받는게 편할 듯
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < M; j++) {
                    board[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // layers까지
        // 3차원을 돌면서 1인 값을 찾아 큐에 넣기
        for (int layers = 0; layers < board.length; layers++) {
            for (int row = 0; row < board[layers].length; row++) {
                for (int column = 0; column < board[layers][row].length; column++) {
                    if (board[layers][row][column] == 1) {
                        q.add(new int[]{layers, row, column});
                    }
                }
            }
        }

        System.out.println(bfs());
    }
}
