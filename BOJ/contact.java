import java.io.*;
        import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class contact {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] board;
    static boolean[] visited;
    static int lastMax;


    public static void main(String[] args) throws IOException {

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());

            board = new int[101][101];
            visited = new boolean[101];

            bw.write("#" + tc + " ");

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N / 2; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[a][b] = 1;
            }

            bfs(first);

            bw.write(String.valueOf(lastMax));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    static void bfs(int first) {
        Queue<Integer> que = new LinkedList<>();
        que.add(first);
        visited[first] = true;

        while (!que.isEmpty()) {
            int queSize = que.size();
            lastMax = 0;

            for (int i = 0; i < queSize; i++) {
                int curr = que.poll();

                lastMax = Math.max(curr, lastMax);

                for (int next = 0; next < visited.length; next++) {
                    if (!visited[next] && board[curr][next] == 1) {
                        visited[next] = true;
                        que.add(next);

                    }
                }
            }
        }
    }
}
