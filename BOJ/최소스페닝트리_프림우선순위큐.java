import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스페닝트리_프림우선순위큐 {
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int w;

		Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		List<Edge>[] adjList = new ArrayList[V + 1];

		for (int i = 1; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			adjList[A].add(new Edge(A, B, W));
			adjList[B].add(new Edge(B, A, W));
		}

		boolean[] visited = new boolean[V + 1];

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		visited[1] = true;

		pq.addAll(adjList[1]);

		int pick = 1;
		int answer = 0;

		while (pick != V) {
			Edge e = pq.poll();
			if (visited[e.end])
				continue;

			answer += e.w;
			visited[e.end] = true;
			pick++;

			pq.addAll(adjList[e.end]);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		bf.close();

	}
}
