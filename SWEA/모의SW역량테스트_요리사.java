import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모의SW역량테스트_요리사 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] board, newboard;
	static int minDiff;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			board = new int[N][N];
			newboard = new int[N][N];

			for (int i = 0; i < board.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int row = 0; row < board.length; row++) {
				for (int column = 0; column < board[row].length; column++) {
					if (row != column) {
						newboard[row][column] = board[row][column] + board[column][row];
					}
				}
			}

			for (int[] ar : newboard) {
				System.out.println(Arrays.toString(ar));
			}

			for (int row = 1; row < newboard.length; row++) {
				retry: for (int column = 1; column < newboard[row].length; column++) {
					if (row > column) {
						break retry;
					}
					
					
				}
			}
		}
	}
}
