import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2075 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				pq.add(-Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < N - 1; i++) {
			pq.poll();
		}
		System.out.println(-pq.poll());
	}

}

