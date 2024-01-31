import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SectionSum {

	public static void main(String[] args) throws IOException  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] arr = new int[N];
		int[] sumArr = new int[N + 1];
		int a = 0;
		int b = 0;
		
		String[] numbers = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(numbers[i]);
			sumArr[i + 1] = sumArr[i] + arr[i];
		}


		for (int i = 0; i < M; i++) {
			String[] hapCha = bf.readLine().split(" ");
			a = Integer.parseInt(hapCha[0]);
			b = Integer.parseInt(hapCha[1]);
			System.out.println(sumArr[b] - sumArr[a - 1]);
		}
	}
}
