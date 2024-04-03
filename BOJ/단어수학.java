import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 단어수학 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bf.readLine());

		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = bf.readLine();
		}

		int[] alphabet = new int[26];

		for (int i = 0; i < N; i++) {
			int tmp = (int) Math.pow(10, arr[i].length() - 1);
			for (int j = 0; j < arr[i].length(); j++) {
				alphabet[arr[i].charAt(j) - 65] += tmp;
				tmp /= 10;
			}
		}

//		System.out.println(Arrays.toString(alphabet));

		// 정렬
		for (int i = 0; i < alphabet.length - 1; i++) {
			for (int j = i + 1; j < alphabet.length; j++) {
				if(alphabet[i] > alphabet[j]) {
					int tmp = alphabet[i];
					alphabet[i] = alphabet[j];
					alphabet[j] = tmp;
				}
			}
		}

//		System.out.println(Arrays.toString(alphabet));

		int large = 9;
		int sum = 0;
		for (int i = alphabet.length - 1; i >= 0; i--) {
			if (alphabet[i] == 0) {
				break;
			}
			sum += alphabet[i] * large--;
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		bf.close();
	}
}
