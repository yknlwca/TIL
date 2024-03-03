package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최단거리 {

    static BufferedReader bf;
    static StringTokenizer st;
    static int n, m, row, column;
    static int[][] board, result;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};


    static int[][] bfs(int row, int column) {

        visited[row][column] = true;
        q.add(new int[]{row, column});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            for (int i = 0; i < dr.length; i++) {
                int nRow = r + dr[i];
                int nColumn = c + dc[i];
                if (0 <= nRow && nRow < n && 0 <= nColumn && nColumn < m) {
                    if (board[nRow][nColumn] == 1 && !visited[nRow][nColumn]) {
                        visited[nRow][nColumn] = true;
                        q.add(new int[]{nRow, nColumn});
                        result[nRow][nColumn] += result[r][c] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    result[i][j] = -1;
                }
            }
        }


        return result;
    }


    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    row = i;
                    column = j;
                    result[row][column] = 0;
                }
            }
        }


        bfs(row, column);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
