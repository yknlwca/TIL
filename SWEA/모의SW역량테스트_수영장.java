import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 모의SW역량테스트_수영장 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] useCase = new int[4];
	static int[] canlender = new int[12];
	static int minCost;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < useCase.length; i++) {
				useCase[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < canlender.length; i++) {
				canlender[i] = Integer.parseInt(st.nextToken());
			}

			minCost = useCase[3];

			findMinCost(0, 0);

			bw.write("#" + tc + " " + minCost);
			bw.newLine();
		}
		bw.close();
		bf.close();
	}

	static void findMinCost(int month, int cost) {

		if (month >= 12) {
			minCost = Math.min(cost, minCost);
			return;
		}

		if (canlender[month] == 0) {
			findMinCost(month + 1, cost);
		} else {
			// 하루 이용권
			findMinCost(month + 1, cost + canlender[month] * useCase[0]);
			// 한달 이용권
			findMinCost(month + 1, cost + useCase[1]);
			// 3달 이용권
			findMinCost(month + 3, cost + useCase[2]);
		}
	}
}
