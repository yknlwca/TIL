import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(bf.readLine());

			if (x == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				
				else {
					System.out.println(pq.poll());
				}
			}
			
			else {
				pq.add(x);
			}
		}
	}
}
