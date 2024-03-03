package boj;

import java.io.*;
import java.util.StringTokenizer;

public class 촌수계산 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] graph;
    static boolean[] visited;
    static int x, y, result = -1;

    static void dfs(int curr, int target, int count) {
        if (curr == target) {
            result = count;
            return;
        }
        visited[curr] = true;

        for (int i = 1; i < graph.length; i++) {
            if (!visited[i] && graph[curr][i] >= 1) {
                dfs(i, target, count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        graph = new int[T + 1][T + 1];
        visited = new boolean[T + 1];
        st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        dfs(x, y, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        bf.close();
    }
}
