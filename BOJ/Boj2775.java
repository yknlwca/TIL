import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2775 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			int k = Integer.parseInt(bf.readLine());
			int n = Integer.parseInt(bf.readLine());
			
			int people = howMany(k, n);
			System.out.println(people);
		}
		bf.close();
	}

	static int howMany(int k, int n) {

		if (k == 0)
			return n;
		
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += howMany(k - 1, i);
		}
		
		return sum;
	}
}
