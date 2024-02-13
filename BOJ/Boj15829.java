import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15829 {

	static final int MOD = 1234567891;
	static final int R = 31;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(bf.readLine());

		String str = bf.readLine();

		long hashValue = 0;
		long rValue = 1;

		for (int i = 0; i < L; i++) {
			hashValue = (hashValue + (str.charAt(i) - 'a' + 1) * rValue) % MOD;
			rValue = (rValue * R) % MOD;
		}

		System.out.println(hashValue);
		bf.close();
	}
}
