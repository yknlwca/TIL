import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class puyopuyo {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static char[][] board;
    static boolean[][] visited;
    static ArrayList<Node> list;
    static final int N = 12, M = 6;
    static int cnt;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        cnt = 0;

        boolean foundPop = true;
        while (foundPop) {
            foundPop = false;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != '.') {
                        list = new ArrayList<>();
//                        dfs(i, j, board[i][j]);
                        bfs(i, j, board[i][j]);
                        if (list.size() >= 4) {
                            for (int k = 0; k < list.size(); k++) {
                                board[list.get(k).x][list.get(k).y] = '.';
                            }
                            foundPop = true;
                        }
                    }
                }
            }

            if (foundPop) {
                fallDown();
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        bf.close();
    }

    static void dfs(int row, int column, char color) {
        visited[row][column] = true;
        list.add(new Node(row, column));

        for (int d = 0; d < dr.length; d++) {
            int nextRow = row + dr[d];
            int nextColumn = column + dc[d];
            if (nextRow >= 0 && nextRow < N && nextColumn >= 0 && nextColumn < M) {
                if (!visited[nextRow][nextColumn] && board[nextRow][nextColumn] == color) {
                    dfs(nextRow, nextColumn, color);
                }
            }
        }
    }

    static void bfs(int row, int column, char c) {
        Queue<Node> q = new LinkedList<>();
        list.add(new Node(row, column));
        q.add(new Node(row, column));
        visited[row][column] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int i = 0; i < dr.length; i++) {
                int nextRow = curr.x + dr[i];
                int nextColumn = curr.y + dc[i];
                if (0 <= nextRow && nextRow < N && 0 <= nextColumn && nextColumn < M) {
                    if (!visited[nextRow][nextColumn]) {
                        if (board[nextRow][nextColumn] == c) {
                            visited[nextRow][nextColumn] = true;
                            list.add(new Node(nextRow, nextColumn));
                            q.add(new Node(nextRow, nextColumn));
                        }
                    }
                }
            }
        }
    }


    static void fallDown() {
        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i > 0; i--) {
                if (board[i][j] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] != '.') {
                            board[i][j] = board[k][j];
                            board[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
