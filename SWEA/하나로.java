import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 하나로 {

    static int[] parent;
    static int N;
    static double E;
    static land[] lands;

    static class land {
        int x;
        int y;

        land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end;
        double cost;

        Edge(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {

            return Double.compare(this.cost, o.cost);
        }

    }

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= T; tc++) {
            bw.write("#" + tc + " ");
            N = Integer.parseInt(bf.readLine());
//            w = Math.sqrt(Math.pow(x1, x2) + Math.pow(y1, y2))
            parent = new int[N];
            lands = new land[N];

            // makeSet
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            StringTokenizer stX = new StringTokenizer(bf.readLine());
            StringTokenizer stY = new StringTokenizer(bf.readLine());

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(stX.nextToken());
                int y = Integer.parseInt(stY.nextToken());

                lands[i] = new land(x, y);
            }

            E = Double.parseDouble(bf.readLine());
            
            // 가능한 모든 간선을 저장할 수 있는 크기
            // N * (N - 1) / 2
            Edge[] edges = new Edge[N * (N - 1) / 2];

            
            int x = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    double cost = distance(lands[i], lands[j]);
                    edges[x++] = new Edge(i, j, cost);
                }
            }

            // 정렬할 때 null값이 있는지 실제 사용된 간선 수만큼 배열 잘라내기
            Edge[] rlEdges = Arrays.copyOf(edges, x);
            Arrays.sort(rlEdges);

            double result = 0;
            for (Edge e : rlEdges) {
                if (findSet(e.start) != findSet(e.end)) {
                    union(e.start, e.end);
                    result += e.cost;
                }
            }

            bw.write(Math.round(result) + "");
            bw.newLine();
        }
        bw.close();
        bf.close();
    }

    static int findSet(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findSet(parent[x]);
    }

    static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    static double distance(land a, land b) {
        long disA = a.x - b.x;
        long disB = a.y - b.y;

        return (Math.pow(disA, 2) + Math.pow(disB, 2)) * E;
    }
}
