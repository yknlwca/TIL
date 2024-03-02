package boj;

import java.io.*;
import java.util.StringTokenizer;

public class 로봇청소기 {
    // 칸의 개수는 센다 -> DFS
    // d = 0 북 1 동 2 남 3 서
    static BufferedReader bf;
    static StringTokenizer st;
    static int[][] board;
    static boolean[][] visited;
    static int N, M, d, startR, startC, cnt;
    // 사방 탐색
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        dfs(startR, startC, d);
        System.out.println(cnt);
    }

    // 1이 벽 0이 청소되지 않은 칸
    static void dfs(int startR, int startC, int d) {
        if (!visited[startR][startC]) {
            visited[startR][startC] = true;
            cnt++;
        }

        for (int i = 0; i < dr.length; i++) {
            int nRow = startR + dr[i];
            int nColumn = startC + dc[i];
            if (0 <= nRow && nRow < board.length && 0 <= nColumn && nColumn < M) {
                // 청소해야되고 방문하지 않은 곳
                // 반 시계 방향이니깐 어떻게 해야하지
                // 처음 d를 확인하고 시작
                // d에서 반 시계 반향으로 가장 가까운 곳부터 봐야하는데 어떤 식으로 하지
                if (d == 0) {
                    if (board[startR - 1][startC] == 0 && !visited[startR - 1][startC]) {
                        visited[startR - 1][startC] = true;
                        cnt++;
                        dfs(startR - 1, startC, d);
                    } else if (board[startR][startC - 1] == 0 && !visited[startR][startC - 1]) {
                        visited[startR][startC - 1] = true;
                        cnt++;
                        d = 3;
                        dfs(startR, startC - 1, d);
                    } else if (board[startR + 1][startC] == 0 && !visited[startR + 1][startC]) {
                        visited[startR + 1][startC] = true;
                        cnt++;
                        d = 2;
                        dfs(startR + 1, startC, d);
                    } else if (board[startR][startC + 1] == 0 && !visited[startR][startC + 1]) {
                        visited[startR][startC + 1] = true;
                        cnt++;
                        d = 1;
                        dfs(startR, startC + 1, d);
                    }
                    // 갈 곳이 없다면 후진
                    else if (board[startR + 1][startC] != 1) {
                        if (!visited[startR + 1][startC]) {
                            visited[startR + 1][startC] = true;
                            cnt++;
                        }
                        dfs(startR + 1, startC, d);
                    }

                } else if (d == 3) {
                    if (board[startR][startC - 1] == 0 && !visited[startR][startC - 1]) {
                        visited[startR][startC - 1] = true;
                        cnt++;
                        dfs(startR, startC - 1, d);
                    } else if (board[startR + 1][startC] == 0 && !visited[startR + 1][startC]) {
                        visited[startR + 1][startC] = true;
                        cnt++;
                        d = 2;
                        dfs(startR + 1, startC, d);
                    } else if (board[startR][startC + 1] == 0 && !visited[startR][startC + 1]) {
                        visited[startR][startC + 1] = true;
                        cnt++;
                        d = 1;
                        dfs(startR, startC + 1, d);
                    } else if (board[startR - 1][startC] == 0 && !visited[startR - 1][startC]) {
                        visited[startR - 1][startC] = true;
                        cnt++;
                        d = 0;
                        dfs(startR - 1, startC, d);
                    }
                    else if (board[startR][startC + 1] != 1) {
                        if (!visited[startR][startC + 1]) {
                            visited[startR][startC + 1] = true;
                            cnt++;
                        }
                        dfs(startR, startC + 1, d);
                    }

                } else if (d == 2) {
                    if (board[startR + 1][startC] == 0 && !visited[startR + 1][startC]) {
                        visited[startR + 1][startC] = true;
                        cnt++;
                        dfs(startR + 1, startC, d);
                    } else if (board[startR][startC + 1] == 0 && !visited[startR][startC + 1]) {
                        visited[startR][startC + 1] = true;
                        cnt++;
                        d = 1;
                        dfs(startR, startC + 1, d);
                    } else if (board[startR - 1][startC] == 0 && !visited[startR - 1][startC]) {
                        visited[startR - 1][startC] = true;
                        cnt++;
                        d = 0;
                        dfs(startR - 1, startC, d);
                    } else if (board[startR][startC - 1] == 0 && !visited[startR][startC - 1]) {
                        visited[startR][startC - 1] = true;
                        cnt++;
                        d = 3;
                        dfs(startR, startC - 1, d);
                    }
                    else if (board[startR - 1][startC] != 1) {
                        if (!visited[startR - 1][startC]) {
                            visited[startR - 1][startC] = true;
                            cnt++;
                        }
                        dfs(startR - 1, startC, d);
                    }

                } else if (d == 1) {
                    if (board[startR][startC + 1] == 0 && !visited[startR][startC + 1]) {
                        visited[startR][startC + 1] = true;
                        cnt++;
                        dfs(startR, startC + 1, d);
                    } else if (board[startR - 1][startC] == 0 && !visited[startR - 1][startC]) {
                        visited[startR - 1][startC] = true;
                        cnt++;
                        d = 0;
                        dfs(startR - 1, startC, d);
                    } else if (board[startR][startC - 1] == 0 && !visited[startR][startC - 1]) {
                        visited[startR][startC - 1] = true;
                        cnt++;
                        d = 3;
                        dfs(startR, startC - 1, d);
                    } else if (board[startR + 1][startC] == 0 && !visited[startR + 1][startC]) {
                        visited[startR + 1][startC] = true;
                        cnt++;
                        d = 2;
                        dfs(startR + 1, startC, d);
                    }
                    else if (board[startR][startC - 1] != 1) {
                        if (!visited[startR][startC - 1]) {
                            visited[startR][startC - 1] = true;
                            cnt++;
                        }
                        dfs(startR, startC - 1, d);
                    }

                }
            }
        }
    }
}
