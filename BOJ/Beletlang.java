import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beletlang {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N = Integer.parseInt(bf.readLine());
			
			if (N == 0)
				break;
			
			int count = countPrime(N);
			System.out.println(count);
		}
		bf.close();
	}
	

	private static boolean primeNum(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0)
				return false;
		}
		return true;
	}
	

	private static int countPrime(int N) {
		int cnt = 0;
		for (int i = N + 1; i <= 2 * N; i++) {
			if (primeNum(i))
				cnt++;
		}
		return cnt;
	}
}
