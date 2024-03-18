import java.io.*;
import java.util.StringTokenizer;

public class 이공사팔4트 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, Answer;
    static int[][] board;
    static int[][] copyBoard;
    static int[] Select = new int[5];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        copyBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        selectDirection(0);
        bw.write(String.valueOf(Answer));
        bw.flush();
        bw.close();
        bf.close();
    }

    static void makeBoard() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, N);
        }
    }

    static void Move(int dir) {
        boolean[][] combined = new boolean[N][N];
        switch (dir) {
            case 0: // Up
                for (int col = 0; col < N; col++) {
                    for (int row = 1; row < N; row++) {
                        // 현재 블록이 0이면 패스
                        if (copyBoard[row][col] == 0) continue;
                        int target = row;
                        // 다음 블록이 0이면 이동
                        while (target > 0 && copyBoard[target - 1][col] == 0) {
                            target--;
                        }
                        // 다음 블록이 같고 합쳐진 적 없으면 합쳐주기
                        if (target > 0 && copyBoard[target - 1][col] == copyBoard[row][col] && !combined[target - 1][col]) {
                            copyBoard[target - 1][col] *= 2;
                            copyBoard[row][col] = 0;
                            combined[target - 1][col] = true;
                        }
                        // 같은 값이 아닌 블록을 만났음
                        // 그 바로 앞까지 쭉 이동
                        else if (target != row) {
                            copyBoard[target][col] = copyBoard[row][col];
                            copyBoard[row][col] = 0;
                        }
                    }
                }
                break;
            case 1: // Down
                for (int col = 0; col < N; col++) {
                    for (int row = N - 2; row >= 0; row--) {
                        // 현재 블록이 0이면 패스
                        if (copyBoard[row][col] == 0) continue;
                        int target = row;
                        // 다음 블록이 0이면 이동
                        while (target < N - 1 && copyBoard[target + 1][col] == 0) {
                            target++;
                        }
                        // 다음 블록이 같고 합쳐진 적 없으면 합쳐주기
                        if (target < N - 1 && copyBoard[target + 1][col] == copyBoard[row][col] && !combined[target + 1][col]) {
                            copyBoard[target + 1][col] *= 2;
                            copyBoard[row][col] = 0;
                            combined[target + 1][col] = true;
                        }
                        // 같은 값이 아닌 블록을 만났음
                        // 그 바로 앞까지 쭉 이동
                        else if (target != row) {
                            copyBoard[target][col] = copyBoard[row][col];
                            copyBoard[row][col] = 0;
                        }
                    }
                }
                break;
            case 2: // Left
                for (int row = 0; row < N; row++) {
                    for (int col = 1; col < N; col++) {
                        // 현재 블록이 0이면 패스
                        if (copyBoard[row][col] == 0) continue;
                        int target = col;
                        while (target > 0 && copyBoard[row][target - 1] == 0) {
                            target--;
                        }
                        // 다음 블록이 같고 합쳐진 적 없으면 합쳐주기
                        if (target > 0 && copyBoard[row][target - 1] == copyBoard[row][col] && !combined[row][target - 1]) {
                            copyBoard[row][target - 1] *= 2;
                            copyBoard[row][col] = 0;
                            combined[row][target - 1] = true;
                        }
                        // 같은 값이 아닌 블록을 만났음
                        // 그 바로 앞까지 쭉 이동
                        else if (target != col) {
                            copyBoard[row][target] = copyBoard[row][col];
                            copyBoard[row][col] = 0;
                        }
                    }
                }
                break;
            case 3: // Right
                for (int row = 0; row < N; row++) {
                    for (int col = N - 2; col >= 0; col--) {
                        // 현재 블록이 0이면 패스
                        if (copyBoard[row][col] == 0) continue;
                        int target = col;
                        // 현재 블록이 0이면 패스
                        while (target < N - 1 && copyBoard[row][target + 1] == 0) {
                            target++;
                        }
                        // 다음 블록이 같고 합쳐진 적 없으면 합쳐주기
                        if (target < N - 1 && copyBoard[row][target + 1] == copyBoard[row][col] && !combined[row][target + 1]) {
                            copyBoard[row][target + 1] *= 2;
                            copyBoard[row][col] = 0;
                            combined[row][target + 1] = true;
                        }
                        // 같은 값이 아닌 블록을 만났음
                        // 그 바로 앞까지 쭉 이동
                        else if (target != col) {
                            copyBoard[row][target] = copyBoard[row][col];
                            copyBoard[row][col] = 0;
                        }
                    }
                }
                break;
        }
    }

    static int findMax() {
        int Max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Max = Math.max(Max, copyBoard[i][j]);
            }
        }
        return Max;
    }

    static void doGame() {
        for (int i = 0; i < 5; i++) {
            Move(Select[i]);
        }
        Answer = Math.max(Answer, findMax());
    }

    static void selectDirection(int Cnt) {
        if (Cnt == 5) {
            makeBoard();
            doGame();
            return;
        }
        for (int i = 0; i < 4; i++) {
            Select[Cnt] = i;
            selectDirection(Cnt + 1);
        }
    }

}
