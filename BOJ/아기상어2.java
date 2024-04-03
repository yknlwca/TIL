import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N, M, maxLong;
	static int[][] board, guard;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		guard = new int[N][M];

		for (int i = 0; i < guard.length; i++) {
			for (int j = 0; j < guard[i].length; j++) {
				guard[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> que = new LinkedList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					que.offer(new int[] { i, j });
					guard[i][j] = 0;
				}
			}
		}

		bfs(que);

		int answer = 0;
		for (int i = 0; i < guard.length; i++) {
			for (int j = 0; j < guard[i].length; j++) {
				answer = Math.max(answer, guard[i][j]);
			}
		}

//		for (int[] ar : guard) {
//			System.out.println(Arrays.toString(ar));
//		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		bf.close();
	}

	static void bfs(Queue<int[]> que) {
		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int currRow = tmp[0];
			int currColumn = tmp[1];

			for (int i = 0; i < dr.length; i++) {
				int nextRow = currRow + dr[i];
				int nextColumn = currColumn + dc[i];

				if (0 <= nextRow && nextRow < guard.length && 0 <= nextColumn && nextColumn < guard[nextRow].length) {
					if (guard[nextRow][nextColumn] > guard[currRow][currColumn] + 1) {
						guard[nextRow][nextColumn] = guard[currRow][currColumn] + 1;
						que.offer(new int[] { nextRow, nextColumn });
					}
				}
			}
		}
	}
}
