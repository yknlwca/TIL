import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 핀볼게임 {
    static class Ball {
        int row;
        int column;
        // 0 상, 1 우, 2 하, 3 좌 시작
//        int direction;
//        int cnt;

//        Ball(int row, int column, int direction, int cnt) {
//            this.row = row;
//            this.column = column;
//            this.direction = direction;
//            this.cnt = cnt;
//        }

        Ball(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

//    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, answer, count, startRow, startColumn;
    static int[][] board;
    static int[][] directionChange = {{0, 0, 0, 0}, {2, 3, 1, 0}, {1, 3, 0, 2}, {3, 2, 0, 1}, {2, 0, 3, 1}, {2, 3, 0, 1}};
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static ArrayList<Ball>[] wormHole;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();

            board = new int[N][N];
            wormHole = new ArrayList[5];

            for (int i = 0; i < 5; i++) {
                wormHole[i] = new ArrayList<>();
            }

            answer = 0;
            for (int i = 0; i < board.length; i++) {
//                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = sc.nextInt();
                    if (board[i][j] >= 6) {
                        wormHole[board[i][j] - 6].add(new Ball(i, j));
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) {
                        continue;
                    }
                    for (int direction = 0; direction < 4; direction++) {
                        int score = check(i, j, direction);
                        if (score > answer) {
                            answer = score;
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);

//            bw.write("#" + tc + " " + answer);
//            bw.newLine();
        }
//        bw.flush();
//        bw.close();
//        bf.close();
    }

    static int check(int row, int column, int direction) {
        int score = 0;
        int currRow = row;
        int currColumn = column;
        int move = 0;

        while (true) {
            // 처음 자리로 왔을 때
            if (currRow == row && currColumn == column && move != 0) {
                break;
            }

            // 블랙홀 만났을때
            if (board[currRow][currColumn] == -1) {
                break;
            }

            currRow = currRow + dr[direction];
            currColumn = currColumn + dc[direction];
            move++;

            // 벽에 부딪힘
            if (0 > currRow || currRow >= N || currColumn < 0 || currColumn >= N) {
                currRow = currRow - dr[direction];
                currColumn = currColumn - dc[direction];

                if (direction == 0) {
                    direction = 2;
                } else if (direction == 1) {
                    direction = 3;
                } else if (direction == 2) {
                    direction = 0;
                } else if (direction == 3) {
                    direction = 1;
                }
                score++;
            }

            // 블록 붇ㅈ힘
            if (board[currRow][currColumn] >= 1 && board[currRow][currColumn] <= 5) {
                int block = board[currRow][currColumn];
                direction = directionChange[block][direction];
                score++;
                continue;
            }

            // 웜홀
            if (board[currRow][currColumn] > 5) {
                int block = board[currRow][currColumn];
                int fromRow = wormHole[block - 6].get(0).row;
                int fromColumn = wormHole[block - 6].get(0).column;
                int toRow = wormHole[block - 6].get(1).row;
                int toColumn = wormHole[block - 6].get(1).column;

                if (currRow == fromRow && currColumn == fromColumn) {
                    currRow = toRow;
                    currColumn = toColumn;
                } else {
                    currRow = fromRow;
                    currColumn = fromColumn;
                }
            }
        }
        return score;
    }
}

//    public static void main(String[] args) throws IOException {
//        int T = Integer.parseInt(bf.readLine());
//
//        // -1 블랙홀
//        // 0 빈 공간 ------- 시작 가능 위치
//        // 1 ~ 5 블록
//        // 6 ~ 10 웜홀
//
//        for (int tc = 1; tc <= T; tc++) {
//            N = Integer.parseInt(bf.readLine());
//
//            board = new int[N][N];
//
//            answer = Integer.MIN_VALUE;
//            for (int i = 0; i < board.length; i++) {
//                st = new StringTokenizer(bf.readLine());
//                for (int j = 0; j < board[i].length; j++) {
//                    board[i][j] = Integer.parseInt(st.nextToken());
//                    if (board[i][j] == 0) {
//                        startRow = i;
//                        startColumn = j;
//                        // 0 상, 1 우, 2 하, 3 좌
//                        dfs(new Ball(i, j, 0, 0));
//                        dfs(new Ball(i, j, 1, 0));
//                        dfs(new Ball(i, j, 2, 0));
//                        dfs(new Ball(i, j, 3, 0));
//                        answer = Math.max(answer, count);
//                    }
//                }
//            }
//
//            bw.write("#" + tc + " " + answer);
//            bw.newLine();
//        }
//        bw.flush();
//        bw.close();
//        bf.close();
//    }
//
//    static void dfs(Ball ball) {
//
//        // 블랙홀이거나 시작점으로 돌아오면 끝
//        if ((1 <= ball.cnt && ball.row == startRow && ball.column == startColumn) || board[ball.row][ball.column] == -1) {
//            count = ball.cnt;
//            return;
//        }
//
//
//
//        // 벽을 만났을 때
//        if (0 == ball.row || 0 == ball.column || N - 1 == ball.row || N - 1 == ball.column) {
//            if (ball.direction == 0) {
//                ball.direction = changeDirection(ball.direction);
//                dfs(new Ball(ball.row + 1, ball.column, ball.direction, ball.cnt + 1));
//            } else if (ball.direction == 1) {
//                ball.direction = changeDirection(ball.direction);
//                dfs(new Ball(ball.row, ball.column - 1, ball.direction, ball.cnt + 1));
//            } else if (ball.direction == 2) {
//                ball.direction = changeDirection(ball.direction);
//                dfs(new Ball(ball.row - 1, ball.column, ball.direction, ball.cnt + 1));
//            } else if (ball.direction == 3) {
//                ball.direction = changeDirection(ball.direction);
//                dfs(new Ball(ball.row, ball.column + 1, ball.direction, ball.cnt + 1));
//            }
//        }
//
//        // 평시
//        if (board[ball.row][ball.column] == 0) {
//            switch (ball.direction) {
//                case 0:
//                    dfs(new Ball(ball.row - 1, ball.column, ball.direction, ball.cnt));
//                    break;
//                case 1:
//                    dfs(new Ball(ball.row, ball.column + 1, ball.direction, ball.cnt));
//                    break;
//                case 2:
//                    dfs(new Ball(ball.row + 1, ball.column, ball.direction, ball.cnt));
//                    break;
//                case 3:
//                    dfs(new Ball(ball.row, ball.column - 1, ball.direction, ball.cnt));
//                    break;
//            }
//        }
//
//        // 블록 구분
//        if (board[ball.row][ball.column] == 1) {
//            switch (ball.direction) {
//                case 0:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row + 1, ball.column, ball.direction, ball.cnt + 1));
//                    break;
//                case 1:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row, ball.column - 1, ball.direction, ball.cnt + 1));
//                    break;
//                case 2:
//                    dfs(new Ball(ball.row, ball.column + 1, 1, ball.cnt + 1));
//                    break;
//                case 3:
//                    dfs(new Ball(ball.row - 1, ball.column, 0, ball.cnt + 1));
//                    break;
//            }
//        } else if (board[ball.row][ball.column] == 2) {
//            switch (ball.direction) {
//                case 0:
//                    dfs(new Ball(ball.row, ball.column + 1, 1, ball.cnt + 1));
//                    break;
//                case 1:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row, ball.column - 1, ball.direction, ball.cnt + 1));
//                    break;
//                case 2:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row - 1, ball.column, ball.direction, ball.cnt + 1));
//                    break;
//                case 3:
//                    dfs(new Ball(ball.row + 1, ball.column, 2, ball.cnt + 1));
//            }
//        } else if (board[ball.row][ball.column] == 3) {
//            switch (ball.direction) {
//                case 0:
//                    dfs(new Ball(ball.row, ball.column - 1, 3, ball.cnt + 1));
//                    break;
//                case 1:
//                    dfs(new Ball(ball.row + 1, ball.column, 2, ball.cnt + 1));
//                case 2:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row - 1, ball.column, ball.direction, ball.cnt + 1));
//                    break;
//                case 3:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row, ball.column + 1, ball.direction, ball.cnt + 1));
//                    break;
//            }
//        } else if (board[ball.row][ball.column] == 4) {
//            switch (ball.direction) {
//                case 0:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row + 1, ball.column, ball.direction, ball.cnt + 1));
//                    break;
//                case 1:
//                    dfs(new Ball(ball.row - 1, ball.column, 0, ball.cnt + 1));
//                    break;
//                case 2:
//                    dfs(new Ball(ball.row, ball.column - 1, 3, ball.cnt + 1));
//                    break;
//                case 3:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row, ball.column + 1, ball.direction, ball.cnt + 1));
//                    break;
//            }
//        } else if (board[ball.row][ball.column] == 5) {
//            switch (ball.direction) {
//                case 0:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row + 1, ball.column, ball.direction, ball.cnt + 1));
//                    break;
//                case 1:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row, ball.column - 1, ball.direction, ball.cnt + 1));
//                    break;
//                case 2:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row - 1, ball.column, ball.direction, ball.cnt + 1));
//                    break;
//                case 3:
//                    ball.direction = changeDirection(ball.direction);
//                    dfs(new Ball(ball.row, ball.column + 1, ball.direction, ball.cnt + 1));
//                    break;
//            }
//        }// 웜홀
//        else if (board[ball.row][ball.column] > 5) {
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[i].length; j++) {
//                    // 웜홀 똑같은 자리에 있을 위험
//                    if (board[i][j] == board[ball.row][ball.column] && i != ball.row && j != ball.column) {
//                        dfs(new Ball(i, j, ball.direction, ball.cnt + 1));
//                    }
//                }
//            }
//        }
//
//    }
//
//    static int changeDirection(int direction) {
//        if (direction == 0) {
//            return 2;
//        }
//        if (direction == 1) {
//            return 3;
//        }
//        if (direction == 2) {
//            return 0;
//        }
//        if (direction == 3) {
//            return 1;
//        }
//        return -1;
//    }

