import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 모의SW역량테스트_보호필름 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] board;
	static int[] A, B;
	static int D, W, K, answer;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(bf.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[D][W];

			A = new int[W];
			B = new int[W];
			for (int i = 0; i < W; i++) {
				B[i] = 1;
			}

			for (int i = 0; i < board.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;

			makeFilm(0, 0);

			bw.write("#" + tc + " " + answer);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	static void makeFilm(int row, int cnt) {

		if (isOk()) {
			answer = Math.min(answer, cnt);
			return;
		}

		if (answer < cnt) {
			return;
		}
		
		if(row == D) return;


		// 주입 X
		makeFilm(row + 1, cnt);

		// 약품 주입 전 원상복구를 위해 저장
		int[] tmp = board[row];

		// 주입 A
		board[row] = A;
		makeFilm(row + 1, cnt + 1);

		// 주입 B
		board[row] = B;
		makeFilm(row + 1, cnt + 1);

		// 원상 복구
		board[row] = tmp;
	}


	// 연속된 것이 K개 이상인가?
	static boolean isOk() {
		for (int c = 0; c < W; c++) {
			boolean flag = false;
			int cnt = 1;
			for (int r = 1; r < D; r++) {
				if (board[r][c] == board[r - 1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if (cnt >= K) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}
}
