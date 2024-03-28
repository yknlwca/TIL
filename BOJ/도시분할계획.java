import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획 {
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] parents;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()) + 1;
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        Edge[] edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        Arrays.sort(edges);
        int answer = 0;
        int lastCost = 0;
        int pick = 0;

        for (int i = 0; i < M; i++) {
            int x = findSet(edges[i].start);
            int y = findSet(edges[i].end);

            if (x != y) {
                union(x, y);
                answer += edges[i].cost;
                lastCost = edges[i].cost;
                pick++;
            }
            if (pick == (N - 1)) {
                break;
            }
        }
        answer -= lastCost;
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
