import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 네트워크연결 {
    static class Edge implements Comparable<Edge> {
        int start, end, W;

        Edge(int start, int end, int W) {
            this.start = start;
            this.end = end;
            this.W = W;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.W, o.W);
        }
    }

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parents;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine()) + 1;
        int M = Integer.parseInt(bf.readLine());

        Edge[] edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(edges);

        parents = new int[N];

        // makeset
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int answer = 0;
        int pick = 0;

        for (Edge e : edges) {
            int x = findSet(e.start);
            int y = findSet(e.end);

            if (x != y) {
                union(x, y);
                answer += e.W;
                pick++;
            }
            if (pick == N - 1) break;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        bf.close();
    }

    static int findSet(int x) {
        if (x != parents[x]) {
            parents[x] = findSet(parents[x]);
        }
        return parents[x];
    }

    static void union(int x, int y) {
        parents[y] = x;
    }
}
