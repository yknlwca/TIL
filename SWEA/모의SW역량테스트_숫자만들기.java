import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모의SW역량테스트_숫자만들기 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] operators, numbers;
	static int minValue, maxValue, currentValue, resultValue;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 숫자의 개수
			N = Integer.parseInt(bf.readLine());
			operators = new int[4];

			// 연산자 개수 입력
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < operators.length; i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}

			numbers = new int[N];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			minValue = Integer.MAX_VALUE;
			maxValue = Integer.MIN_VALUE;

			// index 1번 부터 
			// 시작 값이 numbers[0] 0번 인덱스
			calculation(1, numbers[0], operators[0], operators[1], operators[2], operators[3]);

			resultValue = maxValue - minValue;

			bw.write("#" + tc + " " + resultValue);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	static void calculation(int idx, int currentValue, int plus, int minus, int mulpy, int divide) {
		if (idx == N) {
			minValue = Math.min(currentValue, minValue);
			maxValue = Math.max(currentValue, maxValue);
			return;
		}

		if (plus > 0) {
			calculation(idx + 1, currentValue + numbers[idx], plus - 1, minus, mulpy, divide);
		}
		if (minus > 0) {
			calculation(idx + 1, currentValue - numbers[idx], plus, minus - 1, mulpy, divide);
		}
		if (mulpy > 0) {
			calculation(idx + 1, currentValue * numbers[idx], plus, minus, mulpy - 1, divide);
		}
		if (divide > 0) {
			calculation(idx + 1, currentValue / numbers[idx], plus, minus, mulpy, divide - 1);
		}
	}
}
