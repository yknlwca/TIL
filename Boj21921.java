import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21921 {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int currentValue = 0;
		int maxValue = 0;
		int maxCount = 0;

		for (int i = 0; i < N - X + 1; i++) {
			
			if (i == 0) {
				// 처음 값은 직접 구함
				for (int j = 0; j < X; j++) {
					currentValue += arr[j];
				}

				maxValue = currentValue;
				maxCount = 1;
			}

			else {
				// 한칸씩 오른쪽으로 이동한다고 하면
				// 한칸 이동한 맨 왼쪽 값은 빼고
				// 한칸 이동한 맨 오른쪽 값 더하기
				currentValue = currentValue - arr[i - 1] + arr[i + X - 1];

				if (currentValue == maxValue) {
					maxCount++;
				} else if (currentValue > maxValue) {
					maxValue = currentValue;
					maxCount = 1;
				}
			}
		}
		if (maxValue == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(maxValue);
			System.out.println(maxCount);
		}

	}
}
