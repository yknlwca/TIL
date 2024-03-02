package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 연결요소개수 {
    static BufferedReader bf;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        // index 1부터 사용
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        // 돌면서 인접리스트 초기화 해주기
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = bf.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            list[start].add(end);
            list[end].add(start);
        }
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int idx) {
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;
        for (int i : list[idx]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
