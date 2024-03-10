package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class CCTV {
    int row, column;   // CCTV 위치
    int direction;  // CCTV 방향
    int num;    // CCTV 번호

    CCTV(int row, int column, int direction, int num) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        this.num = num;
    }
}

public class 감시 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[][] board, map;
    static int minCnt;  // 출력 (최소 사각지대 칸 수)

    static int numCCTV; // CCTV 개수
    static List<CCTV> inputCCTV = new ArrayList<>();    // 입력받은 CCTV의 위치
    static List<CCTV> cctvList = new ArrayList<>();


    static void backtrack(int depth) {
        // 전체 CCTV의 감시 방향을 정한 경우
        if (depth >= numCCTV) {
            // map 초기화
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = board[i][j];
                }
            }

            // map에 CCTV 감시 방향 표시
            for (CCTV cctv : cctvList) {
                canCheckArea(cctv);
            }

            // 사각지대 칸 수 세기 (빈칸 0)
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        // 4개의 회전 방향 (direction : 0 ~ 3)
        // 0 위 1 오른 2 아래 3 왼
        CCTV cctv = inputCCTV.get(depth);
        for (int direction = 0; direction < 4; direction++) {
            cctvList.add(new CCTV(cctv.row, cctv.column, direction, cctv.num));
            backtrack(depth + 1);
            cctvList.remove(depth);
        }
    }

    // CCTV 감시 영역 표시하기
    static void canCheckArea(CCTV cctv) {
        if (cctv.num == 1) {
            canCheckArea1(cctv);
        } else if (cctv.num == 2) {
            canCheckArea2(cctv);
        } else if (cctv.num == 3) {
            canCheckArea3(cctv);
        } else if (cctv.num == 4) {
            canCheckArea4(cctv);
        } else if (cctv.num == 5) {
            canCheckArea5(cctv);
        }
    }

    // 1번 CCTV의 감시 영역 메소드
    static void canCheckArea1(CCTV cctv) {
        if (cctv.direction == 0) {  // 1번 CCTV이고 위를 바라보고 있는 경우
            checkUp(cctv.row, cctv.column);
        } else if (cctv.direction == 1) {   // 1번 CCTV이고 오른쪽 보고 있는 경우
            checkRight(cctv.row, cctv.column);
        } else if (cctv.direction == 2) {   // 1번 CCTV이고 아래 보고 있는 경우
            checkDown(cctv.row, cctv.column);
        } else if (cctv.direction == 3) {   // 1번 CCTV가 왼쪽을 보는 경우
            checkLeft(cctv.row, cctv.column);
        }
    }

    // 2번 CCTV의 감시 영역 메소드
    static void canCheckArea2(CCTV cctv) {
        if (cctv.direction == 0 || cctv.direction == 2) {   // 2번 CCTV 이고 위 or 아래를 보고 있을 경우
            // 오른쪽 왼쪽 일직선으로 감시
            checkRight(cctv.row, cctv.column);
            checkLeft(cctv.row, cctv.column);
        } else if (cctv.direction == 1 || cctv.direction == 3) {    // 2번 CCTV 이고 왼 or 우 보고 있는 경우
            // 위 아래 일직선으로 감시
            checkUp(cctv.row, cctv.column);
            checkDown(cctv.row, cctv.column);
        }
    }

    // 3번 CCTV의 감시 영역 메소드
    static void canCheckArea3(CCTV cctv) {
        if (cctv.direction == 0) {  // 3번 CCTV이고 위를 보는 경우
            checkUp(cctv.row, cctv.column);
            checkRight(cctv.row, cctv.column);
        } else if (cctv.direction == 1) {   // 3번 CCTV이고 오른쪽을 보는 경우
            checkRight(cctv.row, cctv.column);
            checkDown(cctv.row, cctv.column);
        } else if (cctv.direction == 2) {   // 3번 CCTV가 아래를 보는 경우
            checkDown(cctv.row, cctv.column);
            checkLeft(cctv.row, cctv.column);
        } else if (cctv.direction == 3) {   // 3번 CCTV가 왼쪽을 보는 경우
            checkLeft(cctv.row, cctv.column);
            checkUp(cctv.row, cctv.column);
        }
    }

    // 4번 CCTV의 감시 영역 메소드
    static void canCheckArea4(CCTV cctv) {
        if (cctv.direction == 0) {  // 4번 CCTV 위를 보는 경우
            checkUp(cctv.row, cctv.column);
            checkLeft(cctv.row, cctv.column);
            checkRight(cctv.row, cctv.column);
        } else if (cctv.direction == 1) {   // 4번 CCTV 오른쪽을 보는 경우
            checkRight(cctv.row, cctv.column);
            checkUp(cctv.row, cctv.column);
            checkDown(cctv.row, cctv.column);
        } else if (cctv.direction == 2) {   // 4번 CCTV 아래를 보는 경우
            checkDown(cctv.row, cctv.column);
            checkLeft(cctv.row, cctv.column);
            checkRight(cctv.row, cctv.column);
        } else if (cctv.direction == 3) {   // 4번 CCTV 왼쪽 보는 경우
            checkLeft(cctv.row, cctv.column);
            checkUp(cctv.row, cctv.column);
            checkDown(cctv.row, cctv.column);
        }
    }

    // 5번 CCTV 감시 영역 메소드
    static void canCheckArea5(CCTV cctv) {
        // 5번 CCTV : 상하좌우 4방향 일직선 모두 감시
        // direction 바라보는 방향 상황 없음
        checkUp(cctv.row, cctv.column);
        checkRight(cctv.row, cctv.column);
        checkDown(cctv.row, cctv.column);
        checkLeft(cctv.row, cctv.column);
    }

    // 위로 일직선 감시
    static void checkUp(int row, int column) {
        for (int nRow = row - 1; nRow >= 0; nRow--) {
            if (!(0 <= nRow && nRow < N) || map[nRow][column] == 6) {
                // 범위가 벗어나거나 벽을 만나면
                break;
            }
            // CCTV는 통과 가능
            if (1 <= map[nRow][column] && map[nRow][column] <= 5) {
                continue;
            }
            // 아무것도 아닌 값 넣어 두기
            map[nRow][column] = 7;
        }
    }

    // 왼쪽 방향 일직선 감시
    static void checkRight(int row, int column) {
        for (int nColumn = column + 1; nColumn < M; nColumn++) {
            if (!(0 <= nColumn && nColumn < M) || map[row][nColumn] == 6) {
                // 범위 벗어나거나 벽이면
                break;
            }
            if (1 <= map[row][nColumn] && map[row][nColumn] <= 5) {
                // CCTV 통과
                continue;
            }
            // 아무것도 아닌 값 넣어 두기
            map[row][nColumn] = 7;
        }
    }

    // 아래 방향 일직선 감시
    static void checkDown(int row, int column) {
        for (int nRow = row + 1; nRow < N; nRow++) {
            if (!(0 <= nRow && nRow < N) || map[nRow][column] == 6) {
                // 범위 벗어나거나 벽을 만나면 브레이크
                break;
            }
            if (1 <= map[nRow][column] && map[nRow][column] <= 5) {
                // CCTV 통과
                continue;
            }
            // 아무것도 아닌 값 넣어 두기
            map[nRow][column] = 7;
        }
    }

    // 왼쪽으로 일직선 감시
    static void checkLeft(int row, int column) {
        for (int nColumn = column - 1; nColumn >= 0; nColumn--) {
            if (!(0 <= nColumn && nColumn < M) || map[row][nColumn] == 6) {
                // 범위를 벗어나거나 벽을 만나면 브레이크
                break;
            }
            if (1 <= map[row][nColumn] && map[row][nColumn] <= 5) {
                // CCTV 통과
                continue;
            }
            // 아무것도 아닌 값 넣어 두기
            map[row][nColumn] = 7;
        }
    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minCnt = N * M;

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= board[i][j] && board[i][j] <= 5) {
                    // CCTV 개수 세기
                    numCCTV++;
                    inputCCTV.add(new CCTV(i, j, -1, board[i][j]));
                }
            }
        }

        backtrack(0);
        bw.write(String.valueOf(minCnt));
        bw.flush();
        bw.close();
        bf.close();
    }
}