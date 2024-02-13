import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj18110 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		int[] arr = new int[n];

		for (int tc = 0; tc < n; tc++) {
			arr[tc] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		int zulsa = (int) Math.round(arr.length * 0.15); // 1

		int sum = 0;
		for (int i = zulsa; i < arr.length - zulsa; i++) {
			sum += arr[i];
		}

		System.out.println(Math.round((double)sum / (arr.length - 2 * zulsa)));
		bf.close();
	}
}
