import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스페닝트리_크루스칼클래스버전 {
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int W;

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
		StringTokenizer st = new StringTokenizer(bf.readLine());

		// 1부터 시작
		int V = Integer.parseInt(st.nextToken()) + 1;
		int E = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		parents = new int[V];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		int answer = 0;
		int pick = 0;

		Arrays.sort(edges);
		
		for (Edge e : edges) {
			int x = findSet(e.start);
			int y = findSet(e.end);

			if (x != y) {
				union(x, y);
				answer += e.W;
				pick++;
			}

			if (pick == (V - 1))
				break;
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
