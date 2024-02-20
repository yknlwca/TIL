import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11726 {
	
	private static int[] d = new int[1001];
	
	private static int dp(int x) {
		if(x == 1)return 1;
		if(x == 2)return 2;
		if(d[x] != 0) return d[x];
		return d[x] = (dp(x - 1) + dp(x - 2)) % 10007;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(bf.readLine());
		
		System.out.println(dp(x));
	}
}
