package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기 {
    static BufferedReader bf;
    static StringTokenizer st;
    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        // 직사각형 그리그
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int sRow = Integer.parseInt(st.nextToken());
            int sCol = Integer.parseInt(st.nextToken());
            int eRow = Integer.parseInt(st.nextToken());
            int eCol = Integer.parseInt(st.nextToken());
            for (int x = sRow; x < eRow; x++) {
                for (int y = sCol; y < eCol; y++) {
                    board[x][y] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (int li : list) {
            System.out.print(li + " ");
        }
    }

    static int bfs(int row, int column) {
        q = new LinkedList<>();
        q.add(new int[]{row, column});
        visited[row][column] = true;
        int area = 1;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int currRow = tmp[0];
            int currColumn = tmp[1];


            visited[row][column] = true;
            for (int x = 0; x < dr.length; x++) {
                int nRow = currRow + dr[x];
                int nColumn = currColumn + dc[x];
                if (0 <= nRow && nRow < N && 0 <= nColumn && nColumn < M && !visited[nRow][nColumn] && board[nRow][nColumn] == 0) {
                    q.add(new int[]{nRow, nColumn});
                    visited[nRow][nColumn] = true;
                    area++;
                }
            }
        }
        return area;
    }
}