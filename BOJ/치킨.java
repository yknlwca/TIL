package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static ArrayList<int[]> chickens, homes;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(bf.readLine());
        chickens = new ArrayList<>();
        homes = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                // 집 위치 저장
                if (board[i][j] == 1) {
                    homes.add(new int[]{i, j});
                }
                // 치킨 집 위치 저장
                if (board[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        comb(new ArrayList<>(), 0);
        bw.write(String.valueOf(minDistance));
        bw.flush();
        bw.close();
        bf.close();
    }

    // 치킨집 조합
    // 치킨 집 중에서 최대 M개를 고르는 조합
    static void comb(ArrayList<int[]> selected, int start) {
        // M개를 고르면 끝
        // 거리 계산
        if (selected.size() == M) {
            calDistance(selected);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            comb(selected, i + 1);
            // removeLast
            selected.remove(selected.size() - 1);
        }
    }

    // 거리 계산 메서드
    static void calDistance(ArrayList<int[]> selected) {
        int totalDistance = 0;

        for (int[] home : homes) {
            int distance = Integer.MAX_VALUE;
            for (int[] chicken : selected) {
                distance = Math.min(distance, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
            }
            totalDistance += distance;
        }
        minDistance = Math.min(minDistance, totalDistance);
    }
}
