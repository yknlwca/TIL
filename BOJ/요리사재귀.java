package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요리사재귀 {

    static BufferedReader bf;
    static StringTokenizer st;
    private static int N;
    private static int[][] S;
    private static boolean[] group;
    private static int minDifference;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine());
            S = new int[N][N];
            group = new boolean[N];          // 선택한 재료인지 아닌지 확인
            minDifference = Integer.MAX_VALUE;  // 출력할 것

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            minTaste(0, 0);
            System.out.println("#" + tc + " " + minDifference);
        }
    }

    private static void minTaste(int start, int count) {
        if (count == N / 2) {       // 선택된 그룹과 선택되지 않은 그룹으로 나누기
            int tasteA = 0;
            int tasteB = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j) {   // 대각선 할 필요 없음 자기 자신
                        if (group[i] && group[j]) tasteA += S[i][j];      // 선택된 음식
                        if (!group[i] && !group[j]) tasteB += S[i][j];    // 선택되지 않은 음식
                    }
                }
            }

            int difference = Math.abs(tasteA - tasteB);
            minDifference = Math.min(minDifference, difference);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!group[i]) {
                group[i] = true;
                minTaste(i + 1, count + 1);
                group[i] = false;
            }
        }
    }
}
