import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {
	static class Hide {
		int now;
		int time;

		Hide(int now, int time) {
			this.now = now;
			this.time = time;
		}
	}

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final int last = 100001;
	static int N, K, minTime;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[last];

		minTime = Integer.MAX_VALUE;
		bfs(N);
		bw.write(String.valueOf(minTime));
		bw.flush();
		bw.close();
		bf.close();

	}

	static void bfs(int start) {
		Queue<Hide> que = new LinkedList<>();
		que.offer(new Hide(start, 0));
		visited[start] = true;

		while (!que.isEmpty()) {
			Hide curr = que.poll();
			
			
			// 순간 이동의 가중치 0
			int nextPosition = curr.now * 2;
			if (nextPosition < last && !visited[nextPosition]) {
				que.offer(new Hide(nextPosition, curr.time));
			}
			nextPosition = curr.now - 1;
			if (nextPosition >= 0 && !visited[nextPosition]) {
				que.offer(new Hide(nextPosition, curr.time + 1));
			}
			// +1 / -1 가중치 1
			nextPosition = curr.now + 1;
			if (nextPosition < last && !visited[nextPosition]) {
				que.offer(new Hide(nextPosition, curr.time + 1));
			}

			if (curr.now == K) {
				minTime = Math.min(minTime, curr.time);
				break;
			}
			visited[curr.now] = true;
		}
	}
}
