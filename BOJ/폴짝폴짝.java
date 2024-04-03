import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 폴짝폴짝 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] arr;
	static int[] visited;
	static int a, b, N, jump;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(bf.readLine());
		arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf(bfs(a, b)));
		bw.flush();
		bw.close();
		bf.close();
	}

	static int bfs(int start, int end) {
		visited = new int[N + 1];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = Integer.MAX_VALUE;
		}

		Queue<int[]> que = new LinkedList<>();
		visited[start] = 0;

		que.offer(new int[] { start, 0 });

		while (!que.isEmpty()) {
			int[] now = que.poll();
			int currentPosition = now[0];
			int currentTime = now[1];

			if (currentPosition == end) {
				return currentTime;
			}

			// 현재 위치에서 모든 배수로 점프
			int jumpDistance = arr[currentPosition];
			for (int multi = 1; currentPosition + jumpDistance * multi <= N; multi++) {
				int nextPosition = currentPosition + jumpDistance * multi;
				if (visited[nextPosition] > currentTime + 1) {
					visited[nextPosition] = currentTime + 1;
					que.offer(new int[] { nextPosition, currentTime + 1 });
				}
			}

			// 뒤로 점프 가능
			for (int multi = 1; currentPosition - jumpDistance * multi >= 1; multi--) {
				int nextPosition = currentPosition - jumpDistance * multi;
				if(nextPosition >= 1 && visited[nextPosition] > currentTime + 1) {
					visited[nextPosition] = currentTime + 1;
					que.offer(new int[] {nextPosition, currentTime + 1});
				}
			}
		}
		
		return -1;
	}
}
