import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티 {
	static class Node implements Comparable<Node> {
		int start;
		int end;
		int w;

		Node(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node node) {
			return this.w - node.w;
		}
	}

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Node>[] adjacent, reverseAdj;
	static int[] distance, reverseDist;
	static int N, M, X;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		adjacent = new ArrayList[N];
		reverseAdj = new ArrayList[N];

		distance = new int[N];
		reverseDist = new int[N];
		for (int i = 0; i < N; i++) {
			distance[i] = Integer.MAX_VALUE;
			reverseDist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < N; i++) {
			adjacent[i] = new ArrayList<>();
			reverseAdj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjacent[a].add(new Node(a, b, c));
			reverseAdj[b].add(new Node(b, a, c));
		}

		dijkstra(X);

//		System.out.println(Arrays.toString(distance));

		reverseDijkstra(X);

//		System.out.println(Arrays.toString(reverseDist));

		int times = 0;
		for (int i = 1; i < distance.length; i++) {
			times = Math.max(times, distance[i] + reverseDist[i]);
		}
		
		bw.write(String.valueOf(times));
		bw.flush();
		bw.close();
		bf.close();
	}

	static void dijkstra(int start) {
		boolean[] visited = new boolean[N];

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(start, start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.end])
				continue;

			visited[curr.end] = true;

			for (Node node : adjacent[curr.end]) {
				if (!visited[node.end] && distance[node.end] > distance[curr.end] + node.w) {
					distance[node.end] = distance[curr.end] + node.w;
					pq.add(new Node(node.start, node.end, distance[node.end]));
				}
			}
		}
	}

	static void reverseDijkstra(int start) {
		boolean[] visited = new boolean[N];

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(start, start, 0));
		reverseDist[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.end])
				continue;

			visited[curr.end] = true;

			for (Node node : reverseAdj[curr.end]) {
				if (!visited[node.end] && reverseDist[node.end] > reverseDist[curr.end] + node.w) {
					reverseDist[node.end] = reverseDist[curr.end] + node.w;
					pq.add(new Node(node.start, node.end, reverseDist[node.end]));
				}
			}
		}
	}
}
