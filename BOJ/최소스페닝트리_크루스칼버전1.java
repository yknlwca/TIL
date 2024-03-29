import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 최소스페닝트리_크루스칼버전1 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] parents;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());

		// 정점 1번 부터
		int V = Integer.parseInt(st.nextToken()) + 1;
		int E = Integer.parseInt(st.nextToken());

		// 간선의 개수는 E개 이므로 E개로 해야함
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges[i][0] = a;
			edges[i][1] = b;
			edges[i][2] = w;
		}

		// 가중치 기준 오름 차순 정렬 하기
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] edge1, int[] edge2) {
				return Integer.compare(edge1[2], edge2[2]);
			}

		});

		// makeset만들기 => 자기 자신을 대표로
		parents = new int[V];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		int answer = 0;
		int pick = 0;
		// findset / union 메서드
		for (int i = 0; i < E; i++) {
			int x = findSet(edges[i][0]);
			int y = findSet(edges[i][1]);

			if (x != y) {
				union(x, y);
				answer += edges[i][2];
				pick++;
			}
			
			if(pick == (V - 1)) break;
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
