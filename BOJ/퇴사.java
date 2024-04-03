import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 퇴사 {

	static class counter {
		int days;
		int cost;

		counter() {
		}

		counter(int days, int cost) {
			this.days = days;
			this.cost = cost;
		}
	}

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bf.readLine());

		counter[] c = new counter[N];
		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			c[i] = new counter(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

//			if(c[i].days + i > N) {
//				c[i].cost = 0;
//				c[i].days = 0;
//			}
		}

		for (int i = 0; i < N; i++) {
			if (i + c[i].days <= N) {
				// 일처리 끝난 날의 비용 누적
				dp[i + c[i].days] = Math.max(dp[i + c[i].days], dp[i] + c[i].cost);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);

		}

		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		bf.close();
	}
}
