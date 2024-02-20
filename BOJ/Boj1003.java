import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1003 {

	private static int[][] dp = new int[41][2];

	private static int[] fibonacci(int n) {
		if (n == 0) {
			return dp[n];
		} else if (dp[n][0] != 0) {
			return dp[n];
		} else if (dp[n][1] != 0) {
			return dp[n];
		} else {
			dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
		}
		return dp[n];

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(bf.readLine());
			fibonacci(n);
			System.out.print(dp[n][0] + " " + dp[n][1] + "\n");
		}
	}
}
