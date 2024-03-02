package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {
    static int F,S,G,U,D;
    static BufferedReader bf;
    static StringTokenizer st;
    static Queue<Integer> q;
    static boolean[] visited;
    static int[] moves;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];
        moves = new int[F + 1];

        if (S == G) {
            System.out.println(0);
            return;
        }

        bfs();

        if (visited[G]) {
            System.out.println(moves[G]);
        } else {
            System.out.println("use the stairs");
        }
    }
    static void bfs(){
        q = new LinkedList<>();
        q.add(S);
        visited[S] = true;
        moves[S] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            int nextU = curr + U;
            int nextD = curr - D;
            if (nextU <= F && !visited[nextU]) {
                visited[nextU] = true;
                moves[nextU] = moves[curr] + 1;
                q.add(nextU);
            }
            if (1 <= nextD && !visited[nextD]) {
                visited[nextD] = true;
                moves[nextD] = moves[curr] + 1;
                q.add(nextD);
            }
        }
    }
}
